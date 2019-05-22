package com.study.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.study.common.TokenInfo;
import com.study.config.redis.RedisUtils;
import com.study.exception.MyException;
import com.study.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtUtils {

    @Autowired
    private RedisUtils redisUtils;

    public static JwtUtils jwtUtils;

    @PostConstruct
    public void init() {
        jwtUtils = this;
    }

    /**
     * token过期时间15分钟
     */
    private static final long EXPIRE_TIME = 2 * 60 * 1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "e5426284672f494d8b9828352d3d0ee6";


    /**
     * refresh_token过期时间7天
     */
    private static final long REFRESH_EXPIRE_TIME = 4 * 60 * 1000;//7 * 24 * 60 * 60 * 1000;

    /**
     * refresh_token私钥
     * token失效时使用
     */
    private static final String REFRESH_TOKEN_SECRET = "822392b4ab744336812aace9adec3396";

    /**
     * 生成token、refresh_token
     *
     * @param userId
     * @param userName
     * @return
     */

    public static TokenInfo createToken(String userId, String userName) {
        try {
            if (StringUtils.isBlank(userId) || StringUtils.isBlank(userName)) {
                throw new MyException(1, "param is empty!");
            }

            long nowTime = System.currentTimeMillis();
            //token生成时间
            Date startTime = new Date(nowTime);

            //token过期时间
            Date tokenExpireTime = new Date(nowTime + EXPIRE_TIME);

            //token私钥及加密算法
            Algorithm tokenAlgorithm = Algorithm.HMAC256(TOKEN_SECRET);

            //refreshToken过期时间
            Date refreshTokenExpireTime = new Date(nowTime + REFRESH_EXPIRE_TIME);

            //token私钥及加密算法
            Algorithm refreshTokenAlgorithm = Algorithm.HMAC256(REFRESH_TOKEN_SECRET);

            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");

            //附带userId、userName信息，生成签名
            JWTCreator.Builder builder = JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withClaim("userName", userName)
                    .withIssuedAt(startTime);
            //生成token
            String token = builder.withExpiresAt(tokenExpireTime).sign(tokenAlgorithm);
            //生成refreshToken
            String refreshToken = builder.withExpiresAt(refreshTokenExpireTime).sign(refreshTokenAlgorithm);

            //refreshToken存入redis
            String key = "userId"+userId;
            boolean success =  jwtUtils.redisUtils.set(key,refreshToken,REFRESH_EXPIRE_TIME/1000);
            if (!success){
                throw new MyException("创建token失败");
            }

            return new TokenInfo(token, refreshToken);

        } catch (UnsupportedEncodingException e) {
            log.error("创建token失败！原因：" + e.getMessage());
            throw new MyException("创建token失败");
        }

    }


    /**
     * 刷新token
     * @param refreshToken
     * @return
     */
    public static TokenInfo refreshToken(String refreshToken) {
        if (StringUtils.isBlank(refreshToken)) {
            throw new MyException(1, "refreshToken method prompt param is empty!");
        }
        //验证refreshToken
        Map<String, Claim> claimMap = verifyRefreshToken(refreshToken);
        String userId = claimMap.get("userId").asString();
        String userName = claimMap.get("userName").asString();

        //验证redis中是否有此token
        String key = "userId"+userId;
        if (!refreshToken.equals(jwtUtils.redisUtils.get(key))){
            throw new MyException(1,"refreshToken已过期，请重新登陆！");
        }

        return createToken(userId,userName);

    }


    /**
     * 校验token是否正确并返回数据
     *
     * @param token 秘钥
     * @return 是否正确
     */
    public static Map<String, Claim> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            //校验token
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaims();
        } catch (Exception e) {
            log.error("校验token失败，原因：" + e.getMessage());
            throw new MyException(401, "登录凭证错误或已失效，请重新登录！");
        }
    }

    /**
     * 校验refreshToken是否正确并返回数据
     * @param refreshToken
     * @return
     */
    public static Map<String, Claim> verifyRefreshToken(String refreshToken) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(REFRESH_TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            //校验refreshToken
            DecodedJWT jwt = verifier.verify(refreshToken);
            return jwt.getClaims();
        } catch (Exception e) {
            log.error("校验refreshToken失败，原因：" + e.getMessage());
            throw new MyException(401, "refreshToken错误或已失效，请重新登录！");
        }
    }


}

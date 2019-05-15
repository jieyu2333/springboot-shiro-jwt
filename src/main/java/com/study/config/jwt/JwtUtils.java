package com.study.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtils {

    /**
     * 过期时间15分钟
     */
    private static final long EXPIRE_TIME = 1 * 60 * 1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "e5426284672f494d8b9828352d3d0ee6";

    /**
     * 生成签名，15分钟过期
     * @param userId
     * @param userName
     * @return 加密的token值
     */
    public static String createToken(String userId,String userName){
        try {

            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            //私钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            Map<String,Object> header = new HashMap<>(2);
            header.put("typ","JWT");
            header.put("alg","HS256");

            //附带userId、userName信息，生成签名
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId",userId)
                    .withClaim("userName",userName)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * 校验token是否正确
     * @param token 秘钥
     * @return 是否正确
     */
    public static boolean verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            //校验token
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            log.error("校验token失败，原因："+e.getMessage());
            return false;
        }
    }

    /**
     * 根据token获取userId（未解密也能得到数据）
     * @param token
     * @return
     */
    public String getUserId(String token){
       try {
           DecodedJWT jwt = JWT.decode(token);
           return jwt.getClaim("userId").asString();
       }catch (JWTDecodeException e){
           log.error("get userId fail");
           return null;
       }
    }

    /**
     * 根据token获取userName（未解密也能得到数据）
     * @param token
     * @return
     */
    public String getUserName(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        }catch (JWTDecodeException e){
            log.error("get userName fail");
            return null;
        }
    }
}

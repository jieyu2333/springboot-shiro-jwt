package com.study.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author JieYu
 * @since 2019-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user_token")
public class UserToken implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId
    private String userId;

    /**
     * token
     */
    private String token;

    /**
     * token过期时间
     */
    private Date tokenExpireTime;

    /**
     * refresh_token
     */
    private String refreshToken;

    /**
     * refresh_token过期时间
     */
    private Date refreshTokenExpireTime;

    public UserToken() {
    }

    public UserToken(String userId, String refreshToken, Date refreshTokenExpireTime) {
        this.userId = userId;
        this.refreshToken = refreshToken;
        this.refreshTokenExpireTime = refreshTokenExpireTime;
    }

    public UserToken(String userId, String token, Date tokenExpireTime, String refreshToken, Date refreshTokenExpireTime) {
        this.userId = userId;
        this.token = token;
        this.tokenExpireTime = tokenExpireTime;
        this.refreshToken = refreshToken;
        this.refreshTokenExpireTime = refreshTokenExpireTime;
    }
}

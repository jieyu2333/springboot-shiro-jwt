package com.study.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * @since 2019-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    @TableId
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idNum;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别，1男2女3未知
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 使用标记,Y启用,N停用
     */
    private String useMark;

    /**
     * 删除标记，1删除0未删除
     * TableLogic注解：查询时默认 delMark = 0
     */
    @TableLogic
    private String delMark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 盐值
     */
    private String salt;


}

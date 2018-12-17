package com.study.utils.validate;

import com.study.utils.validate.impl.PhoneValidateImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @InterfaceName PhoneValidate
 * @Description 手机号验证
 * @Author jieyu
 * @Date 2018/12/17 10:52
 * @Version 1.0
 **/
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidateImpl.class)
public @interface PhoneValidate {

    /**
     * @Description: 错误提示
     */
    String message() default "手机号格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}

package com.study.utils.validate;

import com.study.utils.validate.impl.IdNumValidateImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @InterfaceName IdnumValidate
 * @Description 验证身份证号
 * @Author jieyu
 * @Date 2018/12/17 11:26
 * @Version 1.0
 **/
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdNumValidateImpl.class)
public @interface IdNumValidate {

    /**
     * @Description: 错误提示
     */
    String message() default "身份证号格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

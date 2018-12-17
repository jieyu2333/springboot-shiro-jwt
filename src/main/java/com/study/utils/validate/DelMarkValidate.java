package com.study.utils.validate;

import com.study.utils.validate.impl.DelMarkValidateImpl;
import com.study.utils.validate.impl.UseMarkValidateImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @InterfaceName IdnumValidate
 * @Description 删除标记验证
 * @Author jieyu
 * @Date 2018/12/17 11:26
 * @Version 1.0
 **/
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DelMarkValidateImpl.class)
public @interface DelMarkValidate {

    /**
     * @Description: 错误提示
     */
    String message() default "删除标记格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

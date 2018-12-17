package com.study.utils;

import com.study.common.GlobalEnum;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 接口入参数据校验工具类.
 * 使用hibernate-validator进行校验.
 *
 * @Null   被注释的元素必须为 null
 * @NotNull    被注释的元素必须不为 null
 * @AssertTrue     被注释的元素必须为 true
 * @AssertFalse    被注释的元素必须为 false
 * @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
 * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Past   被注释的元素必须是一个过去的日期
 * @Future     被注释的元素必须是一个将来的日期
 * @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
 * Hibernate Validator 附加的 constraint
 * @NotBlank(message =)   验证字符串非null，且长度必须大于0
 * @Email  被注释的元素必须是电子邮箱地址
 * @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
 * @NotEmpty   被注释的字符串的必须非空
 * @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
 *
 */
public class ValidationUtils {
    private static Validator validator;
    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static <T> void validator(T object) {
        if (null == object) {
            throw new RuntimeException(GlobalEnum.PARAM_NOT_NULL.getMsg());
        }

        Set<ConstraintViolation<T>> violations = validator.validate(object);
        int errSize = violations.size();

        StringBuilder errMsg = new StringBuilder();
        if (errSize > 0) {
            int i = 0;
            for (ConstraintViolation<T> violation : violations) {
                errMsg.append(violation.getMessage()+",");
                i++;
            }
            String lastErrMsg = "";
            if (errMsg!=null){
                lastErrMsg =  errMsg.toString().substring(0,errMsg.length()-1);
            }
            throw new RuntimeException(lastErrMsg);
        }
    }

}




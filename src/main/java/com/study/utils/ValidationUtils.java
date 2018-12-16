package com.study.utils;

import com.study.common.ResultData;
import com.study.common.ValidateResult;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 参数校验类（JSR 303）
 */
public class ValidationUtils {
    private static Validator validator;
    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static <T> ResultData validator(T object) {
        if (null == object) {
            return new ResultData(400, "参数不能为空");
        }

        Set<ConstraintViolation<T>> violations = validator.validate(object);
        int errSize = violations.size();

         StringBuilder errMsg = new StringBuilder();
        int code = 200;
        if (errSize > 0) {
            int i = 0;
            for (ConstraintViolation<T> violation : violations) {
                errMsg.append(violation.getMessage());
                i++;
            }
            code = 400;
        }

        return new ResultData(code, errMsg.toString());
    }

}




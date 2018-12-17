package com.study.utils.validate.impl;

import com.study.common.GlobalEnum;
import com.study.common.UserEnum;
import com.study.utils.StringUtils;
import com.study.utils.validate.IdNumValidate;
import com.study.utils.validate.UseMarkValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;

/**
 * @ClassName PhoneValidateImpl
 * @Description 启用标记字段验证实现
 * @Author jieyu
 * @Date 2018/12/17 10:55
 * @Version 1.0
 **/
public class UseMarkValidateImpl implements ConstraintValidator<UseMarkValidate, String> {

    @Override
    public void initialize(UseMarkValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)||s.equals(GlobalEnum.USE_MARK.getKey())||s.equals(GlobalEnum.NO_USE_MARK.getKey())){
           return true;
        }
        return false;
    }
}

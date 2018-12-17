package com.study.utils.validate.impl;

import com.study.utils.RegexUtils;
import com.study.utils.StringUtils;
import com.study.utils.validate.PhoneValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName PhoneValidateImpl
 * @Description 手机号验证实现
 * @Author jieyu
 * @Date 2018/12/17 10:55
 * @Version 1.0
 **/
public class PhoneValidateImpl implements ConstraintValidator<PhoneValidate, String> {

    @Override
    public void initialize(PhoneValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isNotBlank(s)){
            return RegexUtils.isMobileExact(s)?  true:false;
        }
        return true;

    }
}

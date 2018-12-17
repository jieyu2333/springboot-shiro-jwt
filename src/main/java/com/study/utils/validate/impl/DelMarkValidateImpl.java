package com.study.utils.validate.impl;

import com.study.common.GlobalEnum;
import com.study.common.UserEnum;
import com.study.utils.StringUtils;
import com.study.utils.validate.DelMarkValidate;
import com.study.utils.validate.IdNumValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;

/**
 * @ClassName PhoneValidateImpl
 * @Description 删除字段验证实现
 * @Author jieyu
 * @Date 2018/12/17 10:55
 * @Version 1.0
 **/
public class DelMarkValidateImpl implements ConstraintValidator<DelMarkValidate, String> {

    @Override
    public void initialize(DelMarkValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)||s.equals(GlobalEnum.DEL_MARK.getKey())||s.equals(GlobalEnum.NO_DEL_MARK.getKey())){
            return true;
        }
        return false;

    }
}

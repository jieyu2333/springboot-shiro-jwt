package com.study.utils.validate.impl;

import com.study.utils.RegexUtils;
import com.study.utils.StringUtils;
import com.study.utils.validate.IdNumValidate;
import com.study.utils.validate.PhoneValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;

/**
 * @ClassName PhoneValidateImpl
 * @Description 身份证号验证实现
 * @Author jieyu
 * @Date 2018/12/17 10:55
 * @Version 1.0
 **/
public class IdNumValidateImpl implements ConstraintValidator<IdNumValidate, String> {

    @Override
    public void initialize(IdNumValidate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isNotBlank(s)){
            try {
             return StringUtils.isBlank(StringUtils.iDCardValidate(s))? true:false;

            }catch (ParseException e){
                e.printStackTrace();
                throw new RuntimeException("身份证号验证出错！");
            }
        }
        return true;

    }
}

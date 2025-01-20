package com.fnfcorp.sms.rfid.domain.validation;

import com.fnfcorp.sms.rfid.domain.constant.RfidConstant;
import com.fnfcorp.sms.rfid.domain.RfidErrorCode;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @Author           : yun
 * @Summary         : Rfid Validator
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2023/01/25          yun        최초 생성
 *</pre>
 */
public class RfidCodeValidator implements ConstraintValidator<com.fnfcorp.sms.rfid.domain.validation.RfidCode, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isVal = true;
        //32자 체크하기
        if (value.length() != RfidConstant.RFID_CODE_LENGTH) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(RfidErrorCode.CODE_LENGTH_DIFF.getMessage()).addConstraintViolation();
            isVal = false;
        }

        //27번째 자리가 숫자여야함
        if (!Character.isDigit(value.charAt(RfidConstant.RFID_CODE_VALID_NUMBER_INDEX))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(RfidErrorCode.CODE_VALID_NUMBER_DIFF.getMessage()).addConstraintViolation();
            isVal = false;
        }

        return isVal;
    }

}

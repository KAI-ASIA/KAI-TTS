package sb.locnv.w10.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PartnerConfigValidator implements ConstraintValidator<ValidPartnerConfig, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null)
            return false;
        if(s.trim() == "")
            return false;
        return true;
    }
}

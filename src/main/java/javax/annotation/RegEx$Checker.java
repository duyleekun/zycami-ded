/*
 * Decompiled with CFR 0.151.
 */
package javax.annotation;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.RegEx;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class RegEx$Checker
implements TypeQualifierValidator {
    public When b(RegEx regEx, Object object) {
        boolean bl2 = object instanceof String;
        if (!bl2) {
            return When.NEVER;
        }
        try {
            object = (String)object;
        }
        catch (PatternSyntaxException patternSyntaxException) {
            return When.NEVER;
        }
        Pattern.compile((String)object);
        return When.ALWAYS;
    }
}


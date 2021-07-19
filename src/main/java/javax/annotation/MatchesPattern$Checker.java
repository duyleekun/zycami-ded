/*
 * Decompiled with CFR 0.151.
 */
package javax.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.MatchesPattern;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class MatchesPattern$Checker
implements TypeQualifierValidator {
    public When b(MatchesPattern object, Object object2) {
        String string2 = object.value();
        int n10 = object.flags();
        object = Pattern.compile(string2, n10);
        n10 = (int)(((Matcher)(object = ((Pattern)object).matcher((CharSequence)(object2 = (String)object2)))).matches() ? 1 : 0);
        if (n10 != 0) {
            return When.ALWAYS;
        }
        return When.NEVER;
    }
}


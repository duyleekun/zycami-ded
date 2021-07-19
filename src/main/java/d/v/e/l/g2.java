/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.e.l;

import android.text.TextUtils;
import d.v.e.h.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g2 {
    public static final String a = "[`~!@#$%^&*()+=|_{}\\[\\]':;',\\\\.<>/?~\uff01@#\uffe5%\u2026\u2026&*\uff08\uff09\u2014\u2014+|{}\u3010\u3011\u2018\uff1b\uff1a\u201d\u201c\u2019\u3002\uff0c\u3001\uff1f]";
    private static final String[] b;
    private static final Pattern[] c;

    static {
        String[] stringArray = new String[]{a};
        b = stringArray;
        c = new Pattern[stringArray.length];
    }

    private static Pattern a(int n10) {
        Pattern[] patternArray = c;
        Pattern pattern = patternArray[n10];
        if (pattern == null) {
            patternArray[n10] = pattern = g2.c(b[n10]);
        }
        return patternArray[n10];
    }

    public static Pattern b(String string2) {
        int n10;
        block3: {
            Object object;
            int n11;
            for (n10 = 0; n10 < (n11 = ((String[])(object = b)).length); ++n10) {
                boolean bl2 = f.a((String)(object = object[n10]), string2);
                if (!bl2) {
                    continue;
                }
                break block3;
            }
            n10 = -1;
        }
        if (n10 < 0) {
            return g2.c(string2);
        }
        return g2.a(n10);
    }

    private static Pattern c(String string2) {
        return Pattern.compile(string2);
    }

    public static String d(String string2, String object) {
        object = g2.b((String)object);
        return g2.e(string2, (Pattern)object);
    }

    public static String e(String string2, Pattern object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string2;
        }
        bl2 = ((Matcher)(object = ((Pattern)object).matcher(string2))).find();
        if (bl2) {
            string2 = ((Matcher)object).replaceAll("");
        }
        return string2;
    }

    public static String f(String string2) {
        Pattern pattern = g2.b(a);
        return g2.e(string2, pattern);
    }
}


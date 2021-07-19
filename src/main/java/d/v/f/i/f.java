/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.Spanned
 */
package d.v.f.i;

import android.text.InputFilter;
import android.text.Spanned;
import d.v.e.l.g2;
import d.v.f.i.a;
import java.util.regex.Pattern;

public class f {
    public static InputFilter a(String string2) {
        return f.b(g2.b(string2));
    }

    public static InputFilter b(Pattern pattern) {
        a a10 = new a(pattern);
        return a10;
    }

    public static InputFilter c() {
        return f.b(g2.b("[`~!@#$%^&*()+=|_{}\\[\\]':;',\\\\.<>/?~\uff01@#\uffe5%\u2026\u2026&*\uff08\uff09\u2014\u2014+|{}\u3010\u3011\u2018\uff1b\uff1a\u201d\u201c\u2019\u3002\uff0c\u3001\uff1f]"));
    }

    public static /* synthetic */ CharSequence d(Pattern pattern, CharSequence charSequence, int n10, int n11, Spanned spanned, int n12, int n13) {
        return g2.e(charSequence.toString(), pattern);
    }
}


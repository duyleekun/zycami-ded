/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.q;

import android.text.TextUtils;
import d.v.e.l.k2;
import d.v.e.l.s1;
import d.v.q.d;
import java.io.File;

public class f {
    private static final String a;
    private static final String b;

    static {
        String string2 = "logger_log";
        a = k2.J(string2).getAbsolutePath();
        b = k2.s(string2).getAbsolutePath();
    }

    private static String a(String object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
            ((StringBuilder)comparable).append((String)object);
            String string3 = File.separator;
            ((StringBuilder)comparable).append(string3);
            ((StringBuilder)comparable).append(string2);
            s1.d0(((StringBuilder)comparable).toString());
            comparable = new Comparable<StringBuilder>((String)object, string2);
            return ((File)comparable).getAbsolutePath();
        }
        object = new IllegalArgumentException("null dir name");
        throw object;
    }

    public static String b() {
        boolean bl2 = d.a;
        String string2 = "cache";
        if (bl2) {
            return f.a(b, string2);
        }
        return f.a(a, string2);
    }

    public static String c() {
        boolean bl2 = d.a;
        String string2 = "log";
        if (bl2) {
            return f.a(b, string2);
        }
        return f.a(a, string2);
    }
}


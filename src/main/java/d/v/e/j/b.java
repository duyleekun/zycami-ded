/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.e.j;

import android.text.TextUtils;
import d.v.e.j.a;
import d.v.e.l.k2;
import d.v.e.l.s1;
import java.io.File;

public class b {
    public static final String a = "assets:/";
    public static final String b = "file:///android_asset/";

    public static String a(String string2) {
        return d.v.e.j.b.c(b, string2);
    }

    public static String b(String string2) {
        return d.v.e.j.b.c(a, string2);
    }

    private static String c(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            return string3;
        }
        bl2 = string3.startsWith(string2);
        if (bl2) {
            return string3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static String d(String string2) {
        String string3 = d.v.e.j.b.e(string2);
        boolean bl2 = s1.r(string3);
        if (bl2) {
            string2 = string3;
        }
        return string2;
    }

    private static String e(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object object = d.v.e.j.b.f();
        stringBuilder.append(object);
        object = File.separator;
        stringBuilder.append((String)object);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static File f() {
        return k2.M();
    }

    public static String g(a a10) {
        return a10.getDirName();
    }

    public static String h(a object, String string2) {
        boolean bl2 = d.v.e.j.b.i(string2);
        if (!bl2 && !(bl2 = s1.q(string2))) {
            StringBuilder stringBuilder = new StringBuilder();
            object = d.v.e.j.b.g((a)object);
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            object = stringBuilder.toString();
            string2 = d.v.e.j.b.d((String)object);
        }
        return string2;
    }

    public static boolean i(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        return string2.startsWith("http");
    }

    public static String j(String string2) {
        return d.v.e.j.b.l(b, string2);
    }

    public static String k(String string2) {
        return d.v.e.j.b.l(a, string2);
    }

    private static String l(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            return string3;
        }
        bl2 = string3.startsWith(string2);
        if (bl2) {
            return string3.replaceFirst(string2, "");
        }
        return string3;
    }
}


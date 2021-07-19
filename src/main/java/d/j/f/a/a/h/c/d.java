/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.j.f.a.a.h.c;

import android.text.TextUtils;
import d.j.f.a.a.h.f.c;
import d.j.f.a.a.h.f.g;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class d {
    private static final String a = "d";
    private static final String b = "SHA-256";
    private static final String c = "";
    private static final String[] d = new String[]{"SHA-256", "SHA-384", "SHA-512"};

    private d() {
    }

    private static boolean a(String string2) {
        for (String string3 : d) {
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static String b(String string2) {
        return d.j.f.a.a.h.c.d.c(string2, b);
    }

    public static String c(String object, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = c;
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object2))) {
            bl2 = d.j.f.a.a.h.c.d.a((String)object2);
            if (!bl2) {
                g.f(a, "algorithm is not safe or legal");
                return string2;
            }
            object2 = MessageDigest.getInstance((String)object2);
            String string3 = "UTF-8";
            object = ((String)object).getBytes(string3);
            ((MessageDigest)object2).update((byte[])object);
            object = ((MessageDigest)object2).digest();
            try {
                return d.j.f.a.a.h.f.c.b((byte[])object);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object = a;
                object2 = "Error in generate SHA NoSuchAlgorithmException";
                g.f((String)object, (String)object2);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                object = a;
                object2 = "Error in generate SHA UnsupportedEncodingException";
                g.f((String)object, (String)object2);
            }
            return string2;
        }
        g.f(a, "content or algorithm is null.");
        return string2;
    }

    public static boolean d(String string2, String string3, String string4) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!(bl2 || (bl2 = TextUtils.isEmpty((CharSequence)string3)) || (bl2 = TextUtils.isEmpty((CharSequence)string4)))) {
            string2 = d.j.f.a.a.h.c.d.c(string2, string4);
            return string3.equals(string2);
        }
        return false;
    }

    public static boolean e(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            string2 = d.j.f.a.a.h.c.d.b(string2);
            return string3.equals(string2);
        }
        return false;
    }
}


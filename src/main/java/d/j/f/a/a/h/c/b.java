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
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class b {
    private static final String a = "b";
    private static final String b = "HmacSHA256";
    private static final String c = "";
    private static final int d = 32;

    public static String a(String string2, String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            object = d.j.f.a.a.h.f.c.c((String)object);
            return d.j.f.a.a.h.c.b.b(string2, (byte[])object);
        }
        return c;
    }

    public static String b(String object, byte[] object2) {
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string2 = c;
        if (n10 == 0 && object2 != null) {
            String string3;
            n10 = ((byte[])object2).length;
            int n11 = 32;
            if (n10 < n11) {
                g.f(a, "hmac key length is not right");
                return string2;
            }
            String string4 = b;
            Object object3 = new SecretKeySpec((byte[])object2, string4);
            object2 = ((SecretKeySpec)object3).getAlgorithm();
            object2 = Mac.getInstance((String)object2);
            ((Mac)object2).init((Key)object3);
            object3 = "UTF-8";
            object = ((String)object).getBytes((String)object3);
            object = ((Mac)object2).doFinal((byte[])object);
            try {
                return d.j.f.a.a.h.f.c.b((byte[])object);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            }
            catch (InvalidKeyException invalidKeyException) {
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                // empty catch block
            }
            object2 = a;
            object3 = new StringBuilder();
            string4 = "hmacsha256 encrypt exception";
            ((StringBuilder)object3).append(string4);
            string3 = ((Throwable)((Object)string3)).getMessage();
            ((StringBuilder)object3).append(string3);
            string3 = ((StringBuilder)object3).toString();
            g.f((String)object2, string3);
        }
        return string2;
    }
}


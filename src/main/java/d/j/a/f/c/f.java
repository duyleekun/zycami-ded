/*
 * Decompiled with CFR 0.151.
 */
package d.j.a.f.c;

import d.j.a.f.c.d;
import java.security.spec.KeySpec;
import java.util.Objects;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class f {
    public static SecretKey a(byte[] object, byte[] object2, byte[] object3, byte[] byArray) {
        int n10 = ((byte[])object).length;
        int n11 = 16;
        if (n10 == n11 && (n10 = ((byte[])object2).length) == n11 && (n10 = ((byte[])object3).length) == n11) {
            object = d.a(f.d(object, (byte[])object2, object3));
            object2 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            object3 = new PBEKeySpec;
            object = object.toCharArray();
            object3((char[])object, byArray, 5000, 128);
            object = ((SecretKeyFactory)object2).generateSecret((KeySpec)object3);
            object = object.getEncoded();
            object2 = new SecretKeySpec((byte[])object, "AES");
            return object2;
        }
        object = new IllegalArgumentException;
        object("invalid data for generating the key.");
        throw object;
    }

    private static byte[] b(byte[] byArray, int n10) {
        int n11;
        Objects.requireNonNull(byArray, "bytes must not be null.");
        for (int i10 = 0; i10 < (n11 = byArray.length); ++i10) {
            if (n10 < 0) {
                n11 = byArray[i10];
                int n12 = -n10;
                byArray[i10] = n11 = (int)((byte)(n11 << n12));
                continue;
            }
            byArray[i10] = n11 = (int)((byte)(byArray[i10] >> n10));
        }
        return byArray;
    }

    private static byte[] c(byte[] object, byte[] byArray) {
        if (object != null && byArray != null) {
            int n10 = ((byte[])object).length;
            int n11 = byArray.length;
            if (n10 == n11) {
                int n12;
                n10 = ((byte[])object).length;
                byte[] byArray2 = new byte[n10];
                for (n11 = 0; n11 < (n12 = ((byte[])object).length); ++n11) {
                    n12 = object[n11];
                    byte by2 = byArray[n11];
                    byArray2[n11] = n12 = (int)((byte)(n12 ^ by2));
                }
                return byArray2;
            }
            object = new IllegalArgumentException;
            object("left and right must be the same length.");
            throw object;
        }
        object = new NullPointerException;
        object("left or right must not be null.");
        throw object;
    }

    public static byte[] d(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        return f.c(f.b(f.c(f.b(byArray, -4), byArray2), 6), byArray3);
    }
}


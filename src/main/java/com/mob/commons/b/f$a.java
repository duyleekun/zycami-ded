/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.b;

import com.mob.commons.b.c;
import java.security.MessageDigest;

public class f$a {
    private static final char[] a;

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[16];
        char[] cArray3 = cArray;
        cArray2[0] = 48;
        cArray3[1] = 49;
        cArray2[2] = 50;
        cArray3[3] = 51;
        cArray2[4] = 52;
        cArray3[5] = 53;
        cArray2[6] = 54;
        cArray3[7] = 55;
        cArray2[8] = 56;
        cArray3[9] = 57;
        cArray2[10] = 65;
        cArray3[11] = 66;
        cArray2[12] = 67;
        cArray3[13] = 68;
        cArray2[14] = 69;
        cArray3[15] = 70;
        a = cArray;
    }

    public static /* synthetic */ String a(String string2) {
        return f$a.b(string2);
    }

    private static String b(String string2) {
        Object object = "MD5";
        object = MessageDigest.getInstance((String)object);
        Object object2 = "UTF-8";
        object2 = string2.getBytes((String)object2);
        ((MessageDigest)object).update((byte[])object2);
        object = ((MessageDigest)object).digest();
        object2 = new StringBuilder();
        int n10 = ((Object)object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = object[i10];
            char[] cArray = a;
            char c10 = (object3 & 0xF0) >> 4;
            c10 = cArray[c10];
            ((StringBuilder)object2).append(c10);
            object3 = object3 & 0xF;
            object3 = cArray[object3];
            ((StringBuilder)object2).append((char)object3);
            continue;
        }
        try {
            return ((StringBuilder)object2).toString();
        }
        catch (Throwable throwable) {
            c.a().a(throwable);
            return string2;
        }
    }
}


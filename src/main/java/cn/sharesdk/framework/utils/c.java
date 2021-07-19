/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils;

import cn.sharesdk.framework.utils.h;

public class c
extends h {
    private static final char[] a;
    private static final char[] b;
    private final boolean c;
    private final boolean[] d;

    static {
        char[] cArray = new char[]{'+'};
        a = cArray;
        b = "0123456789ABCDEF".toCharArray();
    }

    public c(String object, boolean bl2) {
        String string2 = ".*[0-9A-Za-z].*";
        boolean bl3 = ((String)object).matches(string2);
        if (!bl3) {
            if (bl2 && (bl3 = ((String)object).contains(string2 = " "))) {
                object = new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
                throw object;
            }
            string2 = "%";
            bl3 = ((String)object).contains(string2);
            if (!bl3) {
                this.c = bl2;
                object = cn.sharesdk.framework.utils.c.a((String)object);
                this.d = (boolean[])object;
                return;
            }
            object = new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
            throw object;
        }
        object = new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        throw object;
    }

    private static boolean[] a(String object) {
        Object object2;
        object = ((String)object).toCharArray();
        int n10 = ((Object)object).length;
        int n11 = 0;
        int n12 = 122;
        boolean[] blArray = null;
        Object object3 = n12;
        for (int i10 = 0; i10 < n10; ++i10) {
            object2 = object[i10];
            object3 = Math.max((int)object2, object3);
        }
        n10 = 1;
        blArray = new boolean[object3 + n10];
        for (object3 = 48; object3 <= (object2 = (Object)57); ++object3) {
            blArray[object3] = n10;
        }
        for (object3 = 65; object3 <= (object2 = (Object)90); ++object3) {
            blArray[object3] = n10;
        }
        for (object3 = 97; object3 <= n12; ++object3) {
            blArray[object3] = n10;
        }
        n12 = ((Object)object).length;
        while (n11 < n12) {
            object3 = object[n11];
            blArray[object3] = n10;
            ++n11;
        }
        return blArray;
    }

    public int a(CharSequence charSequence, int n10, int n11) {
        boolean[] blArray;
        int n12;
        char c10;
        while (n10 < n11 && (c10 = charSequence.charAt(n10)) < (n12 = (blArray = this.d).length) && (c10 = blArray[c10]) != '\u0000') {
            ++n10;
        }
        return n10;
    }

    public char[] a(int n10) {
        int n11;
        Object object = this.d;
        int n12 = ((boolean[])object).length;
        if (n10 < n12 && (n11 = object[n10]) != 0) {
            return null;
        }
        n11 = 32;
        if (n10 == n11 && (n11 = (int)(this.c ? 1 : 0)) != 0) {
            return a;
        }
        n11 = 127;
        n12 = 1;
        int n13 = 0;
        char[] cArray = null;
        int n14 = 2;
        int n15 = 37;
        int n16 = 3;
        int n17 = 4;
        if (n10 <= n11) {
            object = new char[n16];
            object[0] = n15;
            cArray = b;
            n15 = n10 & 0xF;
            object[n14] = n15 = cArray[n15];
            n10 >>>= n17;
            object[n12] = n10 = cArray[n10];
            return object;
        }
        n11 = 2047;
        int n18 = 12;
        int n19 = 5;
        int n20 = 6;
        int n21 = 8;
        if (n10 <= n11) {
            object = new char[n20];
            object[0] = n15;
            object[n16] = n15;
            cArray = b;
            n15 = n10 & 0xF;
            object[n19] = n15 = cArray[n15];
            n15 = (n10 >>>= n17) & 3 | n21;
            object[n17] = n15 = cArray[n15];
            n15 = (n10 >>>= n14) & 0xF;
            object[n14] = n15 = cArray[n15];
            n10 = n10 >>> n17 | n18;
            object[n12] = n10 = cArray[n10];
            return object;
        }
        n11 = (char)-1;
        int n22 = 9;
        int n23 = 7;
        if (n10 <= n11) {
            object = new char[n22];
            object[0] = n15;
            object[n12] = 69;
            object[n16] = n15;
            object[n20] = n15;
            char[] cArray2 = b;
            n13 = n10 & 0xF;
            object[n21] = n13 = cArray2[n13];
            n13 = (n10 >>>= n17) & 3 | n21;
            object[n23] = n13 = cArray2[n13];
            n13 = (n10 >>>= n14) & 0xF;
            object[n19] = n13 = cArray2[n13];
            n13 = (n10 >>>= n17) & 3 | n21;
            object[n17] = n13 = cArray2[n13];
            n10 >>>= n14;
            object[n14] = n10 = cArray2[n10];
            return object;
        }
        n11 = 0x10FFFF;
        if (n10 <= n11) {
            object = new char[n18];
            object[0] = n15;
            object[n12] = 70;
            object[n16] = n15;
            object[n20] = n15;
            object[n22] = n15;
            cArray = b;
            n15 = n10 & 0xF;
            object[11] = n15 = cArray[n15];
            n15 = (n10 >>>= n17) & 3 | n21;
            object[10] = n15 = cArray[n15];
            n12 = (n10 >>>= n14) & 0xF;
            object[n21] = n12 = cArray[n12];
            n12 = (n10 >>>= n17) & 3 | n21;
            object[n23] = n12 = cArray[n12];
            n12 = (n10 >>>= n14) & 0xF;
            object[n19] = n12 = cArray[n12];
            n12 = (n10 >>>= n17) & 3 | n21;
            object[n17] = n12 = cArray[n12];
            n10 = n10 >>> n14 & n23;
            object[n14] = n10 = cArray[n10];
            return object;
        }
        object = new IllegalArgumentException;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid unicode character value ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object(string2);
        throw object;
    }

    public String escape(String string2) {
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean[] blArray;
            int n11;
            char c10 = string2.charAt(i10);
            if (c10 < (n11 = (blArray = this.d).length) && (c10 = blArray[c10]) != '\u0000') {
                continue;
            }
            string2 = this.a(string2, i10);
            break;
        }
        return string2;
    }
}


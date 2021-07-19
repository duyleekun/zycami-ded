/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.q2.b;

public class c
extends b {
    public static final boolean v(char c10, char c11, boolean c12) {
        char c13;
        boolean bl2 = true;
        if (c10 == c11) {
            return bl2;
        }
        if (c12 == '\u0000') {
            return false;
        }
        c12 = Character.toUpperCase(c10);
        if (c12 == (c13 = Character.toUpperCase(c11))) {
            return bl2;
        }
        if ((c10 = Character.toLowerCase(c10)) == (c11 = Character.toLowerCase(c11))) {
            return bl2;
        }
        return false;
    }

    public static /* synthetic */ boolean w(char c10, char c11, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return c.v(c10, c11, bl2);
    }

    public static final boolean x(char n10) {
        int n11 = 55296;
        n10 = n11 <= n10 && (n11 = 57343) >= n10 ? 1 : 0;
        return n10 != 0;
    }

    private static final String y(char c10, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = String.valueOf(c10);
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}


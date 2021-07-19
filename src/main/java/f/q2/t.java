/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.t.f0;
import f.q2.b;
import f.q2.s;

public class t
extends s {
    public static final Void U0(String string2) {
        f0.p(string2, "input");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid number format: '");
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        string2 = stringBuilder.toString();
        NumberFormatException numberFormatException = new NumberFormatException(string2);
        throw numberFormatException;
    }

    public static final Byte V0(String string2) {
        f0.p(string2, "$this$toByteOrNull");
        return t.W0(string2, 10);
    }

    public static final Byte W0(String object, int n10) {
        int n11;
        int n12;
        String string2 = "$this$toByteOrNull";
        f0.p(object, string2);
        object = t.Y0((String)object, n10);
        n10 = 0;
        if (object != null && (n12 = ((Integer)object).intValue()) >= (n11 = -128) && n12 <= (n11 = 127)) {
            return (byte)n12;
        }
        return null;
    }

    public static final Integer X0(String string2) {
        f0.p(string2, "$this$toIntOrNull");
        return t.Y0(string2, 10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Integer Y0(String string2, int n10) {
        String string3 = "$this$toIntOrNull";
        f0.p(string2, string3);
        b.a(n10);
        int n11 = string2.length();
        if (n11 == 0) {
            return null;
        }
        int n12 = 0;
        int n13 = string2.charAt(0);
        int n14 = f0.t(n13, 48);
        int n15 = -2147483647;
        int n16 = 1;
        if (n14 < 0) {
            if (n11 == n16) {
                return null;
            }
            n14 = 45;
            if (n13 == n14) {
                n15 = -1 << -1;
                n13 = n16;
            } else {
                n14 = 43;
                if (n13 != n14) return null;
                n13 = 0;
            }
        } else {
            n13 = 0;
            n16 = 0;
        }
        int n17 = n14 = -59652323;
        while (n16 < n11) {
            int n18 = b.b(string2.charAt(n16), n10);
            if (n18 < 0) {
                return null;
            }
            if (n12 < n17 && (n17 != n14 || n12 < (n17 = n15 / n10))) {
                return null;
            }
            int n19 = n15 + n18;
            if ((n12 *= n10) < n19) {
                return null;
            }
            n12 -= n18;
            ++n16;
        }
        if (n13 != 0) return n12;
        n12 = -n12;
        return n12;
    }

    public static final Long Z0(String string2) {
        f0.p(string2, "$this$toLongOrNull");
        return t.a1(string2, 10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Long a1(String string2, int n10) {
        String string3 = string2;
        int n11 = n10;
        String string4 = "$this$toLongOrNull";
        f0.p(string2, string4);
        b.a(n10);
        int n12 = string2.length();
        if (n12 == 0) {
            return null;
        }
        int n13 = 0;
        char c10 = string2.charAt(0);
        int n14 = f0.t(c10, 48);
        long l10 = -9223372036854775807L;
        int n15 = 1;
        float f10 = Float.MIN_VALUE;
        if (n14 < 0) {
            if (n12 == n15) {
                return null;
            }
            n14 = 45;
            if (c10 == n14) {
                l10 = Long.MIN_VALUE;
                n13 = n15;
            } else {
                n14 = 43;
                if (c10 != n14) return null;
                int n16 = n15;
                n15 = 0;
                f10 = 0.0f;
                n13 = n16;
            }
        } else {
            n15 = 0;
            f10 = 0.0f;
        }
        long l11 = -256204778801521550L;
        long l12 = 0L;
        long l13 = l11;
        while (n13 < n12) {
            int n17 = b.b(string3.charAt(n13), n11);
            if (n17 < 0) {
                return null;
            }
            Object object = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (object < 0) {
                Object object2 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
                if (object2 != false) return null;
                l13 = n11;
                long l14 = l12 - (l13 = l10 / l13);
                object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object < 0) {
                    return null;
                }
            }
            l11 = n11;
            long l15 = l10 + (l11 = (long)n17);
            long l16 = (l12 *= l11) - l15;
            if ((n17 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1))) < 0) {
                return null;
            }
            l12 -= l11;
            ++n13;
            l11 = -256204778801521550L;
        }
        if (n15 != 0) return l12;
        l12 = -l12;
        return l12;
    }

    public static final Short b1(String string2) {
        f0.p(string2, "$this$toShortOrNull");
        return t.c1(string2, 10);
    }

    public static final Short c1(String object, int n10) {
        int n11;
        int n12;
        String string2 = "$this$toShortOrNull";
        f0.p(object, string2);
        object = t.Y0((String)object, n10);
        n10 = 0;
        if (object != null && (n12 = ((Integer)object).intValue()) >= (n11 = Short.MIN_VALUE) && n12 <= (n11 = Short.MAX_VALUE)) {
            return (short)n12;
        }
        return null;
    }
}


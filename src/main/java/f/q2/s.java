/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.t.f0;
import f.q2.b;
import f.q2.l;
import f.q2.r;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.text.Regex;

public class s
extends r {
    public static final BigInteger A0(String string2) {
        f0.p(string2, "$this$toBigIntegerOrNull");
        return s.B0(string2, 10);
    }

    public static final BigInteger B0(String string2, int n10) {
        Object object = "$this$toBigIntegerOrNull";
        f0.p(string2, (String)object);
        b.a(n10);
        int n11 = string2.length();
        if (n11 != 0) {
            int n12 = 0;
            int n13 = 1;
            if (n11 != n13) {
                char c10;
                char c11 = string2.charAt(0);
                if (c11 == (c10 = '-')) {
                    n12 = n13;
                }
                while (n12 < n11) {
                    n13 = b.b(string2.charAt(n12), n10);
                    if (n13 < 0) {
                        return null;
                    }
                    ++n12;
                }
            } else {
                n11 = b.b(string2.charAt(0), n10);
                if (n11 < 0) {
                    return null;
                }
            }
            n10 = b.a(n10);
            object = new BigInteger(string2, n10);
            return object;
        }
        return null;
    }

    private static final /* synthetic */ boolean C0(String string2) {
        return Boolean.parseBoolean(string2);
    }

    private static final boolean D0(String string2) {
        return Boolean.parseBoolean(string2);
    }

    private static final byte E0(String string2) {
        return Byte.parseByte(string2);
    }

    private static final byte F0(String string2, int n10) {
        n10 = b.a(n10);
        return Byte.parseByte(string2, n10);
    }

    private static final double G0(String string2) {
        return Double.parseDouble(string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Double H0(String object) {
        Regex regex;
        f0.p(object, "$this$toDoubleOrNull");
        Object object2 = null;
        try {
            regex = l.a;
        }
        catch (NumberFormatException numberFormatException) {
            return object2;
        }
        boolean bl2 = regex.matches((CharSequence)object);
        if (!bl2) return object2;
        double d10 = Double.parseDouble((String)object);
        object = d10;
        return object;
    }

    private static final float I0(String string2) {
        return Float.parseFloat(string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Float J0(String object) {
        Regex regex;
        f0.p(object, "$this$toFloatOrNull");
        Object object2 = null;
        try {
            regex = l.a;
        }
        catch (NumberFormatException numberFormatException) {
            return object2;
        }
        boolean bl2 = regex.matches((CharSequence)object);
        if (!bl2) return object2;
        float f10 = Float.parseFloat((String)object);
        object = Float.valueOf(f10);
        return object;
    }

    private static final int K0(String string2) {
        return Integer.parseInt(string2);
    }

    private static final int L0(String string2, int n10) {
        n10 = b.a(n10);
        return Integer.parseInt(string2, n10);
    }

    private static final long M0(String string2) {
        return Long.parseLong(string2);
    }

    private static final long N0(String string2, int n10) {
        n10 = b.a(n10);
        return Long.parseLong(string2, n10);
    }

    private static final short O0(String string2) {
        return Short.parseShort(string2);
    }

    private static final short P0(String string2, int n10) {
        n10 = b.a(n10);
        return Short.parseShort(string2, n10);
    }

    private static final String Q0(byte by2, int n10) {
        n10 = b.a(b.a(n10));
        String string2 = Integer.toString(by2, n10);
        f0.o(string2, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string2;
    }

    private static final String R0(int n10, int n11) {
        n11 = b.a(n11);
        String string2 = Integer.toString(n10, n11);
        f0.o(string2, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string2;
    }

    private static final String S0(long l10, int n10) {
        n10 = b.a(n10);
        String string2 = Long.toString(l10, n10);
        f0.o(string2, "java.lang.Long.toString(this, checkRadix(radix))");
        return string2;
    }

    private static final String T0(short s10, int n10) {
        n10 = b.a(b.a(n10));
        String string2 = Integer.toString(s10, n10);
        f0.o(string2, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final Object t0(String object, f.h2.s.l l10) {
        Regex regex;
        Object object2 = null;
        try {
            regex = l.a;
        }
        catch (NumberFormatException numberFormatException) {
            return object2;
        }
        boolean bl2 = regex.matches((CharSequence)object);
        if (!bl2) return object2;
        return object = l10.invoke(object);
    }

    private static final BigDecimal u0(String string2) {
        BigDecimal bigDecimal = new BigDecimal(string2);
        return bigDecimal;
    }

    private static final BigDecimal v0(String string2, MathContext mathContext) {
        BigDecimal bigDecimal = new BigDecimal(string2, mathContext);
        return bigDecimal;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final BigDecimal w0(String string2) {
        void var1_3;
        block6: {
            BigDecimal bigDecimal;
            Regex regex;
            f0.p(string2, "$this$toBigDecimalOrNull");
            Object var1_1 = null;
            try {
                regex = l.a;
            }
            catch (NumberFormatException numberFormatException) {
                return var1_3;
            }
            boolean bl2 = regex.matches(string2);
            if (!bl2) break block6;
            BigDecimal bigDecimal2 = bigDecimal = new BigDecimal(string2);
        }
        return var1_3;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final BigDecimal x0(String string2, MathContext mathContext) {
        void var2_4;
        block6: {
            BigDecimal bigDecimal;
            Regex regex;
            f0.p(string2, "$this$toBigDecimalOrNull");
            f0.p(mathContext, "mathContext");
            Object var2_2 = null;
            try {
                regex = l.a;
            }
            catch (NumberFormatException numberFormatException) {
                return var2_4;
            }
            boolean bl2 = regex.matches(string2);
            if (!bl2) break block6;
            BigDecimal bigDecimal2 = bigDecimal = new BigDecimal(string2, mathContext);
        }
        return var2_4;
    }

    private static final BigInteger y0(String string2) {
        BigInteger bigInteger = new BigInteger(string2);
        return bigInteger;
    }

    private static final BigInteger z0(String string2, int n10) {
        n10 = b.a(n10);
        BigInteger bigInteger = new BigInteger(string2, n10);
        return bigInteger;
    }
}


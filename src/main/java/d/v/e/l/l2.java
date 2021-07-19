/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import d.v.e.l.c2;
import d.v.e.l.l2$a;
import java.math.RoundingMode;

public class l2 {
    public static float a(long l10, int n10) {
        return c2.d((float)l10 * 1.0E-6f, n10);
    }

    public static String b(long l10) {
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        return l2.c(l10, roundingMode, false);
    }

    private static String c(long l10, RoundingMode object, boolean n10) {
        int n11;
        long l11;
        double d10;
        long l12;
        long l13;
        block7: {
            block8: {
                double d11;
                double d12;
                block5: {
                    block6: {
                        l13 = 1000L;
                        l12 = 60000L;
                        d10 = 2.9644E-319;
                        l11 = (l10 /= l13) / l12;
                        l12 = l10 % l12;
                        int[] nArray = l2$a.a;
                        n11 = ((Enum)object).ordinal();
                        n11 = nArray[n11];
                        int n12 = 1;
                        d12 = 1000.0;
                        d11 = 1.0;
                        if (n11 == n12) break block5;
                        n12 = 2;
                        if (n11 == n12) break block6;
                        d10 = (double)l12 * d11 / d12;
                        l12 = Math.round(d10);
                        break block7;
                    }
                    d10 = Math.ceil((double)l12 * d11 / d12);
                    break block8;
                }
                d10 = Math.floor((double)l12 * d11 / d12);
            }
            l12 = (long)d10;
        }
        long l14 = 60;
        n11 = (int)(l12 == l14 ? 0 : (l12 < l14 ? -1 : 1));
        if (n11 == 0) {
            l12 = 0L;
            d10 = 0.0;
            l14 = 1L;
            l11 += l14;
        }
        l14 = 10;
        n11 = (int)(l11 == l14 ? 0 : (l11 < l14 ? -1 : 1));
        String string2 = "0";
        String string3 = "";
        if (n11 < 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            string3 = ((StringBuilder)object).toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(l11);
        CharSequence charSequence = ":";
        ((StringBuilder)object).append((String)charSequence);
        object = ((StringBuilder)object).toString();
        long l15 = l12 == l14 ? 0 : (l12 < l14 ? -1 : 1);
        if (l15 < 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(string2);
            object = ((StringBuilder)charSequence).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(l12);
        object = ((StringBuilder)charSequence).toString();
        if (n10 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(".");
            object = stringBuilder.toString();
            l10 = l10 % l13 / l14;
            n10 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
            if (n10 < 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)object);
                stringBuilder.append(string2);
                object = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(l10);
            object = stringBuilder.toString();
        }
        return object;
    }

    public static String d(long l10) {
        RoundingMode roundingMode = RoundingMode.FLOOR;
        return l2.c(l10, roundingMode, false);
    }

    public static String e(long l10) {
        RoundingMode roundingMode = RoundingMode.FLOOR;
        return l2.c(l10, roundingMode, true);
    }
}


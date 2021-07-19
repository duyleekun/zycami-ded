/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class c2 {
    public static String a(double d10) {
        return c2.b(d10, 2);
    }

    public static String b(double d10, int n10) {
        double d11;
        double d12;
        double d13;
        double d14;
        int n11;
        CharSequence charSequence = null;
        for (n11 = 0; (d14 = (d13 = (d12 = d10 / 1024.0) - (d11 = 1.0)) == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1)) >= 0 && n11 < (d14 = (double)5); ++n11) {
            d10 = d12;
        }
        CharSequence charSequence2 = "";
        if (n11 != 0) {
            int n12 = 1;
            if (n11 != n12) {
                n12 = 2;
                if (n11 != n12) {
                    n12 = 3;
                    if (n11 != n12) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append((String)charSequence2);
                        charSequence2 = "T";
                        ((StringBuilder)charSequence).append((String)charSequence2);
                        charSequence = ((StringBuilder)charSequence).toString();
                    } else {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append((String)charSequence2);
                        charSequence2 = "G";
                        ((StringBuilder)charSequence).append((String)charSequence2);
                        charSequence = ((StringBuilder)charSequence).toString();
                    }
                } else {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    charSequence2 = "M";
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    charSequence = ((StringBuilder)charSequence).toString();
                }
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)charSequence2);
                charSequence2 = "K";
                ((StringBuilder)charSequence).append((String)charSequence2);
                charSequence = ((StringBuilder)charSequence).toString();
            }
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence2 = "B";
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        charSequence2 = new StringBuilder();
        d10 = c2.c(d10, n10);
        ((StringBuilder)charSequence2).append(d10);
        ((StringBuilder)charSequence2).append((String)charSequence);
        return ((StringBuilder)charSequence2).toString();
    }

    public static double c(double d10, int n10) {
        BigDecimal bigDecimal = BigDecimal.valueOf(d10);
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        return bigDecimal.setScale(n10, roundingMode).doubleValue();
    }

    public static float d(float f10, int n10) {
        BigDecimal bigDecimal = BigDecimal.valueOf(f10);
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        return bigDecimal.setScale(n10, roundingMode).floatValue();
    }

    public static float e(long l10, int n10) {
        BigDecimal bigDecimal = BigDecimal.valueOf(l10);
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        return bigDecimal.setScale(n10, roundingMode).floatValue();
    }

    public static String f(double d10) {
        double d11;
        double d12;
        double d13 = 0.0;
        Object object = d10 == d13 ? 0 : (d10 < d13 ? -1 : 1);
        Object object2 = "\\.";
        if (object < 0) {
            return String.valueOf(0).split((String)object2)[0];
        }
        double d14 = 1000.0;
        double d15 = d10 - d14;
        object = d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1);
        if (object < 0) {
            return String.valueOf(d10).split((String)object2)[0];
        }
        object = d10 == d14 ? 0 : (d10 > d14 ? 1 : -1);
        String string2 = "k";
        if (object > 0 && (object = (d12 = d10 - (d11 = 100000.0)) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1)) < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            object2 = Locale.getDefault();
            Object object3 = d10 /= d14;
            Object[] objectArray = new Object[]{object3};
            object3 = String.format((Locale)object2, "%.1f", objectArray);
            stringBuilder.append((String)object3);
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = String.valueOf(d10 /= d14).split((String)object2)[0];
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static String g(double d10) {
        double d11 = 0.0;
        Object object = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
        Object object2 = "\\.";
        if (object < 0) {
            return String.valueOf(0).split((String)object2)[0];
        }
        double d12 = 1000.0;
        double d13 = d10 - d12;
        object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        if (object < 0) {
            return String.valueOf(d10).split((String)object2)[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        object2 = Locale.getDefault();
        Object object3 = d10 /= d12;
        Object[] objectArray = new Object[]{object3};
        object3 = String.format((Locale)object2, "%.1f", objectArray);
        stringBuilder.append((String)object3);
        stringBuilder.append("K");
        return stringBuilder.toString();
    }

    public static int h(int n10, int[] nArray) {
        int n11;
        int n12 = nArray.length;
        int n13 = -1;
        if (n12 == 0) {
            return n13;
        }
        for (n12 = 0; n12 < (n11 = nArray.length); ++n12) {
            n11 = nArray[n12];
            if (n10 != n11) continue;
            return n12;
        }
        return n13;
    }

    public static int i(String string2, CharSequence[] charSequenceArray) {
        int n10 = charSequenceArray.length;
        int n11 = -1;
        if (n10 != 0 && string2 != null) {
            int n12;
            for (n10 = 0; n10 < (n12 = charSequenceArray.length); ++n10) {
                CharSequence charSequence = charSequenceArray[n10];
                n12 = (int)(string2.contentEquals(charSequence) ? 1 : 0);
                if (n12 == 0) continue;
                return n10;
            }
        }
        return n11;
    }
}


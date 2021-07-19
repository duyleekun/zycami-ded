/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import java.math.BigDecimal;

public class q1 {
    private static final int a = 1;
    private static final int b = 1024;
    private static final int c = 0x100000;
    private static final int d = 0x40000000;
    public static final String e = "B";
    public static final String f = "K";
    public static final String g = "M";
    public static final String h = "G";

    public static String a(long l10) {
        Object object;
        double d10 = l10;
        double d11 = d10 / 1.048576E9;
        double d12 = 1.0;
        Object object2 = d11 == d12 ? 0 : (d11 > d12 ? 1 : -1);
        int n10 = 1;
        if (object2 >= 0) {
            l10 = 4742290407621132288L;
            object = new BigDecimal(d10 /= 1.073741824E9);
            int n11 = 2;
            double d13 = ((BigDecimal)object).setScale(n11, n10).doubleValue();
            StringBuilder stringBuilder = new StringBuilder();
            object = Double.toString(d13);
            stringBuilder.append((String)object);
            stringBuilder.append("GB");
            object = stringBuilder.toString();
        } else {
            double d14 = d10 / 1024000.0;
            double d15 = d14 - d12;
            object2 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
            if (object2 >= 0) {
                l10 = 4697254411347427328L;
                object = new BigDecimal(d10 /= 1048576.0);
                double d16 = ((BigDecimal)object).setScale(n10, n10).doubleValue();
                StringBuilder stringBuilder = new StringBuilder();
                object = Double.toString(d16);
                stringBuilder.append((String)object);
                stringBuilder.append("MB");
                object = stringBuilder.toString();
            } else {
                d14 = d10 / 1000.0;
                double d17 = d14 - d12;
                object2 = d17 == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1);
                if (object2 >= 0) {
                    l10 = 0x4090000000000000L;
                    object = new BigDecimal(d10 /= 1024.0);
                    double d18 = ((BigDecimal)object).setScale(n10, n10).doubleValue();
                    StringBuilder stringBuilder = new StringBuilder();
                    object = Double.toString(d18);
                    stringBuilder.append((String)object);
                    stringBuilder.append("KB");
                    object = stringBuilder.toString();
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(l10);
                    stringBuilder.append(e);
                    object = stringBuilder.toString();
                }
            }
        }
        return object;
    }

    public static String b(long l10) {
        long l11 = 0x40000000L;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        if (object >= 0) {
            Object[] objectArray = new Object[n10];
            float f10 = l10;
            float f11 = l11;
            Float f12 = Float.valueOf(f10 / f11);
            objectArray[0] = f12;
            return String.format("%.1f GB", objectArray);
        }
        l11 = 0x100000L;
        object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        float f13 = 100.0f;
        if (object >= 0) {
            float f14 = l10;
            float f15 = l11;
            float f16 = (f14 /= f15) - f13;
            Object object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            String string2 = object2 > 0 ? "%.0f MB" : "%.1f MB";
            Object[] objectArray = new Object[n10];
            Float f17 = Float.valueOf(f14);
            objectArray[0] = f17;
            return String.format(string2, objectArray);
        }
        l11 = 1024L;
        long l12 = l10 - l11;
        object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            float f18 = l10;
            float f19 = l11;
            float f20 = (f18 /= f19) - f13;
            Object object3 = f20 == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1);
            String string3 = object3 > 0 ? "%.0f KB" : "%.1f KB";
            Object[] objectArray = new Object[n10];
            Float f21 = Float.valueOf(f18);
            objectArray[0] = f21;
            return String.format(string3, objectArray);
        }
        Object[] objectArray = new Object[n10];
        Long l13 = l10;
        objectArray[0] = l13;
        return String.format("%d B", objectArray);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String c(long l10, int n10) {
        StringBuilder stringBuilder;
        int n11;
        int n12;
        String string2;
        String string3;
        int n13;
        String string4;
        BigDecimal bigDecimal;
        double d10;
        block10: {
            int n14;
            block11: {
                block7: {
                    block8: {
                        String string5;
                        block9: {
                            long l11;
                            long l12;
                            long l13;
                            d10 = l10;
                            int n15 = 0;
                            bigDecimal = null;
                            while ((l13 = (l12 = (l10 /= 1000L) - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                                ++n15;
                            }
                            string4 = h;
                            n13 = 0x40000000;
                            string3 = f;
                            string2 = e;
                            n12 = 4;
                            n11 = 2;
                            string5 = g;
                            n14 = 1;
                            if (n15 == 0) break block7;
                            if (n15 == n14) break block8;
                            if (n15 == n11) break block9;
                            int n16 = 3;
                            if (n15 == n16 || n15 == n12) break block10;
                            string4 = string5;
                            break block11;
                        }
                        n13 = 0x100000;
                        string4 = string5;
                        break block10;
                    }
                    n13 = 1024;
                    string4 = string3;
                    break block10;
                }
                string4 = string2;
            }
            n13 = n14;
        }
        bigDecimal = new BigDecimal(d10);
        Comparable<BigDecimal> comparable = new Comparable<BigDecimal>(n13);
        d10 = bigDecimal.divide((BigDecimal)comparable, n10, n12).doubleValue();
        String string6 = Double.toString(d10);
        int n17 = -1;
        int n18 = 46;
        if (n10 == 0) {
            n10 = string6.indexOf(n18);
            if (n17 == n10) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string6);
                stringBuilder2.append(string4);
                return stringBuilder2.toString();
            }
            comparable = new Comparable<BigDecimal>();
            string6 = string6.substring(0, n10);
            ((StringBuilder)comparable).append(string6);
            ((StringBuilder)comparable).append(string4);
            return ((StringBuilder)comparable).toString();
        }
        n10 = (int)(string4.equals(string2) ? 1 : 0);
        if (n10 != 0) {
            n10 = string6.indexOf(n18);
            string6 = string6.substring(0, n10);
        }
        if ((n10 = (int)(string4.equals(string3) ? 1 : 0)) != 0) {
            n10 = string6.indexOf(n18);
            if (n10 != n17) {
                string6 = string6.substring(0, n10 += n11);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string6);
                stringBuilder.append(".0");
                string6 = stringBuilder.toString();
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(string6);
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public static String d(float f10, int n10, String string2) {
        double d10 = f10 * 100.0f;
        BigDecimal bigDecimal = new BigDecimal(d10);
        BigDecimal bigDecimal2 = new BigDecimal(1);
        int n11 = 4;
        bigDecimal2 = bigDecimal.divide(bigDecimal2, n10, n11);
        f10 = bigDecimal2.floatValue();
        double d11 = -n10;
        double d12 = 10.0;
        float f11 = (float)(d11 = Math.pow(d12, d11));
        n10 = Float.compare(f10, f11);
        if (n10 < 0) {
            return string2;
        }
        return String.valueOf(f10);
    }

    public static String[] e(long l10, int n10) {
        n10 = 2;
        String[] stringArray = new String[n10];
        CharSequence charSequence = q1.c(l10, 0);
        int n11 = ((String)charSequence).length();
        int n12 = 1;
        String string2 = ((String)charSequence).substring(n11 -= n12);
        int n13 = ((String)charSequence).lastIndexOf(string2);
        charSequence = ((String)charSequence).substring(0, n13);
        stringArray[0] = charSequence;
        charSequence = e;
        boolean bl2 = string2.equals(charSequence);
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            string2 = "/s";
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            stringArray[n12] = charSequence;
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            string2 = "B/s";
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            stringArray[n12] = charSequence;
        }
        return stringArray;
    }

    public static String f(double d10) {
        double d11 = 1024.0;
        double d12 = d10 / d11;
        double d13 = 1.0;
        double d14 = d12 - d13;
        Object object = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
        if (object < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d10);
            stringBuilder.append(e);
            return stringBuilder.toString();
        }
        d10 = d12 / d11;
        object = d10 == d13 ? 0 : (d10 < d13 ? -1 : 1);
        int n10 = 4;
        int n11 = 2;
        if (object < 0) {
            CharSequence charSequence = Double.toString(d12);
            Object object2 = new BigDecimal((String)charSequence);
            charSequence = new StringBuilder();
            object2 = ((BigDecimal)object2).setScale(n11, n10).toPlainString();
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(f);
            return ((StringBuilder)charSequence).toString();
        }
        d12 = d10 / d11;
        double d15 = d12 - d13;
        object = d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1);
        if (object < 0) {
            CharSequence charSequence = Double.toString(d10);
            BigDecimal bigDecimal = new BigDecimal((String)charSequence);
            charSequence = new StringBuilder();
            String string2 = bigDecimal.setScale(n11, n10).toPlainString();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(g);
            return ((StringBuilder)charSequence).toString();
        }
        d10 = d12 / d11;
        double d16 = d10 - d13;
        Object object3 = d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1);
        if (object3 < 0) {
            CharSequence charSequence = Double.toString(d12);
            Object object4 = new BigDecimal((String)charSequence);
            charSequence = new StringBuilder();
            object4 = ((BigDecimal)object4).setScale(n11, n10).toPlainString();
            ((StringBuilder)charSequence).append((String)object4);
            ((StringBuilder)charSequence).append(h);
            return ((StringBuilder)charSequence).toString();
        }
        BigDecimal bigDecimal = new BigDecimal(d10);
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = bigDecimal.setScale(n11, n10).toPlainString();
        stringBuilder.append(string3);
        stringBuilder.append("T");
        return stringBuilder.toString();
    }
}


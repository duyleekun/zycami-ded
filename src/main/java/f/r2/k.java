/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.f0;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public final class k {
    private static final DecimalFormatSymbols a;
    private static final DecimalFormatSymbols b;
    private static final ThreadLocal[] c;
    private static final ThreadLocal d;

    static {
        ThreadLocal[] threadLocalArray = Locale.ROOT;
        ThreadLocal threadLocal = new ThreadLocal((Locale)threadLocalArray);
        ((DecimalFormatSymbols)((Object)threadLocal)).setExponentSeparator("e");
        a = threadLocal;
        threadLocal = new ThreadLocal((Locale)threadLocalArray);
        ((DecimalFormatSymbols)((Object)threadLocal)).setExponentSeparator("e+");
        b = threadLocal;
        int n10 = 4;
        threadLocalArray = new ThreadLocal[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            ThreadLocal threadLocal2;
            threadLocalArray[i10] = threadLocal2 = new ThreadLocal();
        }
        c = threadLocalArray;
        d = threadLocal = new ThreadLocal();
    }

    private static final DecimalFormat a(int n10) {
        DecimalFormatSymbols decimalFormatSymbols = a;
        String string2 = "0";
        DecimalFormat decimalFormat = new DecimalFormat(string2, decimalFormatSymbols);
        if (n10 > 0) {
            decimalFormat.setMinimumFractionDigits(n10);
        }
        RoundingMode roundingMode = RoundingMode.HALF_UP;
        decimalFormat.setRoundingMode(roundingMode);
        return decimalFormat;
    }

    public static final String b(double d10) {
        double d11;
        Object object = d;
        Object object2 = ((ThreadLocal)object).get();
        if (object2 == null) {
            DecimalFormatSymbols decimalFormatSymbols = a;
            String string2 = "0E0";
            object2 = new DecimalFormat(string2, decimalFormatSymbols);
            int n10 = 2;
            ((DecimalFormat)object2).setMinimumFractionDigits(n10);
            ((ThreadLocal)object).set(object2);
        }
        object2 = (DecimalFormat)object2;
        double d12 = 1.0;
        double d13 = d10 == d12 ? 0 : (d10 > d12 ? 1 : -1);
        object = d13 < 0 && (d13 = (d11 = d10 - (d12 = (double)-1)) == 0.0 ? 0 : (d11 < 0.0 ? -1 : 1)) > 0 ? a : b;
        ((DecimalFormat)object2).setDecimalFormatSymbols((DecimalFormatSymbols)object);
        String string3 = ((NumberFormat)object2).format(d10);
        f0.o(string3, "scientificFormat.getOrSe\u2026 }\n        .format(value)");
        return string3;
    }

    public static final String c(double d10, int n10) {
        DecimalFormat decimalFormat;
        Object object = c;
        int n11 = ((ThreadLocal[])object).length;
        if (n10 < n11) {
            decimalFormat = ((ThreadLocal)(object = object[n10])).get();
            if (decimalFormat == null) {
                decimalFormat = k.a(n10);
                ((ThreadLocal)object).set(decimalFormat);
            }
        } else {
            decimalFormat = k.a(n10);
        }
        String string2 = decimalFormat.format(d10);
        f0.o(string2, "format.format(value)");
        return string2;
    }

    public static final String d(double d10, int n10) {
        DecimalFormat decimalFormat = k.a(0);
        decimalFormat.setMaximumFractionDigits(n10);
        String string2 = decimalFormat.format(d10);
        f0.o(string2, "createFormatForDecimals(\u2026 }\n        .format(value)");
        return string2;
    }
}


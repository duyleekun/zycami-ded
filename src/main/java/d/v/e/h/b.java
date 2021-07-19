/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.h;

public final class b {
    private b() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static double a(String string2) {
        return b.b(string2, 0.0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static double b(String string2, double d10) {
        if (string2 == null) {
            return d10;
        }
        try {
            return Double.parseDouble(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return d10;
        }
    }

    public static double c(Double d10) {
        return b.d(d10, 0.0);
    }

    public static double d(Double d10, double d11) {
        if (d10 != null) {
            d11 = d10;
        }
        return d11;
    }
}


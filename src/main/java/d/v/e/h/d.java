/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.h;

public final class d {
    private d() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static int a(String string2) {
        return d.b(string2, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int b(String string2, int n10) {
        if (string2 == null) {
            return n10;
        }
        try {
            return Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return n10;
        }
    }

    public static int c(Integer n10) {
        return d.d(n10, 0);
    }

    public static int d(Integer n10, int n11) {
        if (n10 != null) {
            n11 = n10;
        }
        return n11;
    }
}


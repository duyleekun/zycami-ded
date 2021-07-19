/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.h;

public final class a {
    private a() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static boolean a(String string2) {
        return a.b(string2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean b(String string2, boolean bl2) {
        if (string2 == null) {
            return bl2;
        }
        try {
            return Boolean.parseBoolean(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return bl2;
        }
    }

    public static boolean c(Boolean bl2) {
        return a.d(bl2, false);
    }

    public static boolean d(Boolean bl2, boolean bl3) {
        if (bl2 != null) {
            bl3 = bl2;
        }
        return bl3;
    }
}


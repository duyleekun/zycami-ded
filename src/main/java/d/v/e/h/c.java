/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.h;

public final class c {
    private c() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static float a(String string2) {
        return c.b(string2, 0.0f);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static float b(String string2, float f10) {
        if (string2 == null) {
            return f10;
        }
        try {
            return Float.parseFloat(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return f10;
        }
    }

    public static float c(Float f10) {
        return c.d(f10, 0.0f);
    }

    public static float d(Float f10, float f11) {
        if (f10 != null) {
            f11 = f10.floatValue();
        }
        return f11;
    }
}


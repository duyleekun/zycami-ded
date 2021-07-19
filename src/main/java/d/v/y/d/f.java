/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.d;

public final class f {
    private f() {
    }

    public static float a(String string2) {
        return f.b(string2, 0.0f);
    }

    public static float b(String string2, float f10) {
        try {
            return Float.parseFloat(string2);
        }
        catch (NullPointerException | NumberFormatException runtimeException) {
            return f10;
        }
    }

    public static int c(String string2) {
        return f.d(string2, 0);
    }

    public static int d(String string2, int n10) {
        try {
            return Integer.parseInt(string2);
        }
        catch (NullPointerException | NumberFormatException runtimeException) {
            return n10;
        }
    }
}


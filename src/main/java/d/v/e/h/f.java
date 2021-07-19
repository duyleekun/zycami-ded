/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.h;

public final class f {
    private f() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static boolean a(String string2, String string3) {
        boolean bl2;
        boolean bl3 = true;
        if (string2 == null && string3 == null) {
            return bl3;
        }
        if (string2 == null || !(bl2 = string2.equals(string3))) {
            bl3 = false;
        }
        return bl3;
    }

    public static boolean b(String string2) {
        boolean bl2;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}


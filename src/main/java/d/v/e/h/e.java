/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.h;

public final class e {
    private e() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static Long a(String string2) {
        Long l10 = 0L;
        return e.b(string2, l10);
    }

    public static Long b(String string2, Long l10) {
        long l11;
        if (string2 == null) {
            l11 = l10;
        } else {
            l11 = Long.parseLong(string2);
        }
        try {
            return l11;
        }
        catch (NumberFormatException numberFormatException) {
            return l10;
        }
    }

    public static Long c(Long l10) {
        Long l11 = 0L;
        return e.d(l10, l11);
    }

    public static Long d(Long l10, Long l11) {
        if (l10 == null) {
            l10 = l11;
        }
        return l10;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package l.a.l;

public final class a {
    public static int a(int n10, int n11) {
        int n12;
        if (n11 >= 0 && n11 <= (n12 = 255)) {
            return (n10 &= 0xFFFFFF) | (n11 <<= 24);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("alpha must be between 0 and 255.");
        throw illegalArgumentException;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

public final class l {
    private l() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static boolean a(int n10) {
        int n11;
        n10 = (n10 &= (n11 = n10 + -1)) == 0 ? 1 : 0;
        return n10 != 0;
    }

    public static int b(int n10) {
        int n11 = 1;
        n10 = Integer.numberOfLeadingZeros(n10 - n11);
        n10 = 32 - n10;
        return n11 << n10;
    }
}


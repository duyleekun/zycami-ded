/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

public final class o0 {
    private static volatile int a = 1;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int a() {
        Class<o0> clazz = o0.class;
        synchronized (clazz) {
            int n10 = a;
            int n11 = -1 >>> 1;
            if (n10 >= n11) {
                a = n10 = 1;
            }
            n10 = a;
            a = n11 = n10 + 1;
            return n10;
        }
    }
}


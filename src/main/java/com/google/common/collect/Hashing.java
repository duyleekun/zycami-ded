/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

public final class Hashing {
    private static final long C1 = 3432918353L;
    private static final long C2 = 461845907L;
    private static final int MAX_TABLE_SIZE = 0x40000000;

    private Hashing() {
    }

    public static int closedTableSize(int n10, double d10) {
        int n11;
        double d11;
        int n12;
        if ((n10 = Math.max(n10, 2)) > (n12 = (int)(d10 *= (d11 = (double)(n11 = Integer.highestOneBit(n10)))))) {
            n10 = n11 << 1;
            if (n10 <= 0) {
                n10 = 0x40000000;
            }
            return n10;
        }
        return n11;
    }

    public static boolean needsResizing(int n10, int n11, double d10) {
        double d11 = n10;
        double d12 = n11;
        double d13 = d11 - (d10 *= d12);
        n10 = (n10 = (int)(d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1))) > 0 && n11 < (n10 = 0x40000000) ? 1 : 0;
        return n10 != 0;
    }

    public static int smear(int n10) {
        return (int)((long)Integer.rotateLeft((int)((long)n10 * 3432918353L), 15) * 461845907L);
    }

    public static int smearedHash(Object object) {
        int n10;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        return Hashing.smear(n10);
    }
}


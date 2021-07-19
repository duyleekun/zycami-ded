/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.u;

public final class j$a {
    private j$a() {
    }

    public /* synthetic */ j$a(u u10) {
        this();
    }

    public final int a(int n10, int n11) {
        int n12;
        int n13 = n10 >> 1;
        if ((n13 = (n10 += n13) - n11) < 0) {
            n10 = n11;
        }
        if ((n12 = n10 - (n13 = 0x7FFFFFF7)) > 0) {
            n10 = n11 > n13 ? -1 >>> 1 : n13;
        }
        return n10;
    }
}


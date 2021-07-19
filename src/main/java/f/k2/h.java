/*
 * Decompiled with CFR 0.151.
 */
package f.k2;

import f.k2.e;
import f.k2.f;

public final class h
extends e {
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public h(int n10, int n11) {
        int n12 = ~n10;
        int n13 = n10 << 10;
        int n14 = n11 >>> 4;
        int n15 = n13 ^ n14;
        n14 = n10;
        this(n10, n11, 0, 0, n12, n15);
    }

    public h(int n10, int n11, int n12, int n13, int n14, int n15) {
        IllegalArgumentException illegalArgumentException;
        this.c = n10;
        this.d = n11;
        this.e = n12;
        this.f = n13;
        this.g = n14;
        this.h = n15;
        n10 = n10 | n11 | n12 | n13 | n14;
        n11 = 0;
        String string2 = null;
        if (n10 != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            illegalArgumentException = null;
        }
        if (n10 != 0) {
            n10 = 64;
            while (n11 < n10) {
                this.l();
                ++n11;
            }
            return;
        }
        string2 = "Initial state must have at least one non-zero element.".toString();
        illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public int b(int n10) {
        return f.k2.f.j(this.l(), n10);
    }

    public int l() {
        int n10 = this.c;
        int n11 = n10 >>> 2;
        n10 ^= n11;
        this.c = n11 = this.d;
        this.d = n11 = this.e;
        this.e = n11 = this.f;
        this.f = n11 = this.g;
        int n12 = n10 << 1;
        n10 = n10 ^ n12 ^ n11;
        this.g = n10 ^= (n11 <<= 4);
        this.h = n11 = this.h + 362437;
        return n10 + n11;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package f.k2;

import f.h2.t.f0;
import f.k2.e;
import f.k2.f;
import java.util.Random;

public abstract class a
extends e {
    public int b(int n10) {
        return f.j(this.r().nextInt(), n10);
    }

    public boolean c() {
        return this.r().nextBoolean();
    }

    public byte[] e(byte[] byArray) {
        f0.p(byArray, "array");
        this.r().nextBytes(byArray);
        return byArray;
    }

    public double h() {
        return this.r().nextDouble();
    }

    public float k() {
        return this.r().nextFloat();
    }

    public int l() {
        return this.r().nextInt();
    }

    public int m(int n10) {
        return this.r().nextInt(n10);
    }

    public long o() {
        return this.r().nextLong();
    }

    public abstract Random r();
}


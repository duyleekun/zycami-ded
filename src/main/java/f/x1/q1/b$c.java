/*
 * Decompiled with CFR 0.151.
 */
package f.x1.q1;

import f.x1.c;
import f.z0;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;

public final class b$c
extends c
implements RandomAccess {
    public final /* synthetic */ byte[] b;

    public b$c(byte[] byArray) {
        this.b = byArray;
    }

    public int b() {
        return z0.n(this.b);
    }

    public boolean c(byte by2) {
        return z0.h(this.b, by2);
    }

    public byte e(int n10) {
        return z0.l(this.b, n10);
    }

    public int f(byte by2) {
        return ArraysKt___ArraysKt.Xe(this.b, by2);
    }

    public int g(byte by2) {
        return ArraysKt___ArraysKt.bh(this.b, by2);
    }

    public boolean isEmpty() {
        return z0.q(this.b);
    }
}


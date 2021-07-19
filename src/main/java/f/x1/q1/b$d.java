/*
 * Decompiled with CFR 0.151.
 */
package f.x1.q1;

import f.n1;
import f.x1.c;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;

public final class b$d
extends c
implements RandomAccess {
    public final /* synthetic */ short[] b;

    public b$d(short[] sArray) {
        this.b = sArray;
    }

    public int b() {
        return n1.n(this.b);
    }

    public boolean c(short s10) {
        return n1.h(this.b, s10);
    }

    public short e(int n10) {
        return n1.l(this.b, n10);
    }

    public int f(short s10) {
        return ArraysKt___ArraysKt.ef(this.b, s10);
    }

    public int g(short s10) {
        return ArraysKt___ArraysKt.ih(this.b, s10);
    }

    public boolean isEmpty() {
        return n1.q(this.b);
    }
}


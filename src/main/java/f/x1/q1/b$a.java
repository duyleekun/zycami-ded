/*
 * Decompiled with CFR 0.151.
 */
package f.x1.q1;

import f.d1;
import f.x1.c;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;

public final class b$a
extends c
implements RandomAccess {
    public final /* synthetic */ int[] b;

    public b$a(int[] nArray) {
        this.b = nArray;
    }

    public int b() {
        return d1.n(this.b);
    }

    public boolean c(int n10) {
        return d1.h(this.b, n10);
    }

    public int e(int n10) {
        return d1.l(this.b, n10);
    }

    public int f(int n10) {
        return ArraysKt___ArraysKt.bf(this.b, n10);
    }

    public int g(int n10) {
        return ArraysKt___ArraysKt.fh(this.b, n10);
    }

    public boolean isEmpty() {
        return d1.q(this.b);
    }
}


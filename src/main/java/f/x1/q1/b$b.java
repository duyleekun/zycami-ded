/*
 * Decompiled with CFR 0.151.
 */
package f.x1.q1;

import f.h1;
import f.x1.c;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;

public final class b$b
extends c
implements RandomAccess {
    public final /* synthetic */ long[] b;

    public b$b(long[] lArray) {
        this.b = lArray;
    }

    public int b() {
        return h1.n(this.b);
    }

    public boolean c(long l10) {
        return h1.h(this.b, l10);
    }

    public long e(int n10) {
        return h1.l(this.b, n10);
    }

    public int f(long l10) {
        return ArraysKt___ArraysKt.cf(this.b, l10);
    }

    public int g(long l10) {
        return ArraysKt___ArraysKt.gh(this.b, l10);
    }

    public boolean isEmpty() {
        return h1.q(this.b);
    }
}


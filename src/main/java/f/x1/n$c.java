/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.x1.c;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;

public final class n$c
extends c
implements RandomAccess {
    public final /* synthetic */ int[] b;

    public n$c(int[] nArray) {
        this.b = nArray;
    }

    public int b() {
        return this.b.length;
    }

    public boolean c(int n10) {
        return ArraysKt___ArraysKt.N7(this.b, n10);
    }

    public Integer e(int n10) {
        return this.b[n10];
    }

    public int f(int n10) {
        return ArraysKt___ArraysKt.bf(this.b, n10);
    }

    public int g(int n10) {
        return ArraysKt___ArraysKt.fh(this.b, n10);
    }

    public boolean isEmpty() {
        int[] nArray = this.b;
        boolean bl2 = nArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            nArray = null;
        }
        return bl2;
    }
}


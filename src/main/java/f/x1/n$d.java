/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.x1.c;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;

public final class n$d
extends c
implements RandomAccess {
    public final /* synthetic */ long[] b;

    public n$d(long[] lArray) {
        this.b = lArray;
    }

    public int b() {
        return this.b.length;
    }

    public boolean c(long l10) {
        return ArraysKt___ArraysKt.O7(this.b, l10);
    }

    public Long e(int n10) {
        return this.b[n10];
    }

    public int f(long l10) {
        return ArraysKt___ArraysKt.cf(this.b, l10);
    }

    public int g(long l10) {
        return ArraysKt___ArraysKt.gh(this.b, l10);
    }

    public boolean isEmpty() {
        long[] lArray = this.b;
        boolean bl2 = lArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            lArray = null;
        }
        return bl2;
    }
}


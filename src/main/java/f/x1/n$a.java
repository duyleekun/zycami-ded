/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.x1.c;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;

public final class n$a
extends c
implements RandomAccess {
    public final /* synthetic */ byte[] b;

    public n$a(byte[] byArray) {
        this.b = byArray;
    }

    public int b() {
        return this.b.length;
    }

    public boolean c(byte by2) {
        return ArraysKt___ArraysKt.J7(this.b, by2);
    }

    public Byte e(int n10) {
        return this.b[n10];
    }

    public int f(byte by2) {
        return ArraysKt___ArraysKt.Xe(this.b, by2);
    }

    public int g(byte by2) {
        return ArraysKt___ArraysKt.bh(this.b, by2);
    }

    public boolean isEmpty() {
        byte[] byArray = this.b;
        boolean bl2 = byArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            byArray = null;
        }
        return bl2;
    }
}


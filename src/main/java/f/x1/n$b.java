/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.x1.c;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;

public final class n$b
extends c
implements RandomAccess {
    public final /* synthetic */ short[] b;

    public n$b(short[] sArray) {
        this.b = sArray;
    }

    public int b() {
        return this.b.length;
    }

    public boolean c(short s10) {
        return ArraysKt___ArraysKt.Q7(this.b, s10);
    }

    public Short e(int n10) {
        return this.b[n10];
    }

    public int f(short s10) {
        return ArraysKt___ArraysKt.ef(this.b, s10);
    }

    public int g(short s10) {
        return ArraysKt___ArraysKt.ih(this.b, s10);
    }

    public boolean isEmpty() {
        short[] sArray = this.b;
        boolean bl2 = sArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            sArray = null;
        }
        return bl2;
    }
}


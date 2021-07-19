/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.x1.c;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;

public final class n$g
extends c
implements RandomAccess {
    public final /* synthetic */ boolean[] b;

    public n$g(boolean[] blArray) {
        this.b = blArray;
    }

    public int b() {
        return this.b.length;
    }

    public boolean c(boolean bl2) {
        return ArraysKt___ArraysKt.R7(this.b, bl2);
    }

    public Boolean e(int n10) {
        return this.b[n10];
    }

    public int f(boolean bl2) {
        return ArraysKt___ArraysKt.ff(this.b, bl2);
    }

    public int g(boolean bl2) {
        return ArraysKt___ArraysKt.jh(this.b, bl2);
    }

    public boolean isEmpty() {
        boolean[] blArray = this.b;
        boolean bl2 = blArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            blArray = null;
        }
        return bl2;
    }
}


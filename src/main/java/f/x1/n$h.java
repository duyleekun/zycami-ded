/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.x1.c;
import java.util.RandomAccess;
import kotlin.collections.ArraysKt___ArraysKt;

public final class n$h
extends c
implements RandomAccess {
    public final /* synthetic */ char[] b;

    public n$h(char[] cArray) {
        this.b = cArray;
    }

    public int b() {
        return this.b.length;
    }

    public boolean c(char c10) {
        return ArraysKt___ArraysKt.K7(this.b, c10);
    }

    public Character e(int n10) {
        return Character.valueOf(this.b[n10]);
    }

    public int f(char c10) {
        return ArraysKt___ArraysKt.Ye(this.b, c10);
    }

    public int g(char c10) {
        return ArraysKt___ArraysKt.ch(this.b, c10);
    }

    public boolean isEmpty() {
        char[] cArray = this.b;
        boolean bl2 = cArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            cArray = null;
        }
        return bl2;
    }
}


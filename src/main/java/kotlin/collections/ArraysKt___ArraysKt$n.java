/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.i;
import f.n2.m;
import java.util.Iterator;

public final class ArraysKt___ArraysKt$n
implements m {
    public final /* synthetic */ long[] a;

    public ArraysKt___ArraysKt$n(long[] lArray) {
        this.a = lArray;
    }

    public Iterator iterator() {
        return i.g(this.a);
    }
}


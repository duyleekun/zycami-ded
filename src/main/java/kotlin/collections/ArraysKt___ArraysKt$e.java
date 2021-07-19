/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.i;
import f.h2.t.x0.a;
import java.util.Iterator;

public final class ArraysKt___ArraysKt$e
implements Iterable,
a {
    public final /* synthetic */ long[] a;

    public ArraysKt___ArraysKt$e(long[] lArray) {
        this.a = lArray;
    }

    public Iterator iterator() {
        return i.g(this.a);
    }
}


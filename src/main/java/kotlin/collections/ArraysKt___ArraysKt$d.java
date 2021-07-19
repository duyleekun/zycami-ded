/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.i;
import f.h2.t.x0.a;
import java.util.Iterator;

public final class ArraysKt___ArraysKt$d
implements Iterable,
a {
    public final /* synthetic */ int[] a;

    public ArraysKt___ArraysKt$d(int[] nArray) {
        this.a = nArray;
    }

    public Iterator iterator() {
        return i.f(this.a);
    }
}


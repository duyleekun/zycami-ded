/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.i;
import f.h2.t.x0.a;
import java.util.Iterator;

public final class ArraysKt___ArraysKt$f
implements Iterable,
a {
    public final /* synthetic */ float[] a;

    public ArraysKt___ArraysKt$f(float[] fArray) {
        this.a = fArray;
    }

    public Iterator iterator() {
        return i.e(this.a);
    }
}


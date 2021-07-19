/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.i;
import f.h2.t.x0.a;
import java.util.Iterator;

public final class ArraysKt___ArraysKt$h
implements Iterable,
a {
    public final /* synthetic */ boolean[] a;

    public ArraysKt___ArraysKt$h(boolean[] blArray) {
        this.a = blArray;
    }

    public Iterator iterator() {
        return i.a(this.a);
    }
}


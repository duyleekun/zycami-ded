/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.i;
import f.h2.t.x0.a;
import java.util.Iterator;

public final class ArraysKt___ArraysKt$c
implements Iterable,
a {
    public final /* synthetic */ short[] a;

    public ArraysKt___ArraysKt$c(short[] sArray) {
        this.a = sArray;
    }

    public Iterator iterator() {
        return i.h(this.a);
    }
}


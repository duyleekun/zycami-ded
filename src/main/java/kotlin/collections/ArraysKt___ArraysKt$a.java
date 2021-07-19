/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.h;
import f.h2.t.x0.a;
import java.util.Iterator;

public final class ArraysKt___ArraysKt$a
implements Iterable,
a {
    public final /* synthetic */ Object[] a;

    public ArraysKt___ArraysKt$a(Object[] objectArray) {
        this.a = objectArray;
    }

    public Iterator iterator() {
        return h.a(this.a);
    }
}


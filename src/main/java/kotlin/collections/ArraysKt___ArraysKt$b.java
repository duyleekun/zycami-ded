/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.i;
import f.h2.t.x0.a;
import java.util.Iterator;

public final class ArraysKt___ArraysKt$b
implements Iterable,
a {
    public final /* synthetic */ byte[] a;

    public ArraysKt___ArraysKt$b(byte[] byArray) {
        this.a = byArray;
    }

    public Iterator iterator() {
        return i.b(this.a);
    }
}


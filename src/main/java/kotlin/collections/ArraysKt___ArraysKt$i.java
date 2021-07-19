/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.i;
import f.h2.t.x0.a;
import java.util.Iterator;

public final class ArraysKt___ArraysKt$i
implements Iterable,
a {
    public final /* synthetic */ char[] a;

    public ArraysKt___ArraysKt$i(char[] cArray) {
        this.a = cArray;
    }

    public Iterator iterator() {
        return i.c(this.a);
    }
}


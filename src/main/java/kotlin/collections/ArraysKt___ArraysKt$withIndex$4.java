/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import f.h2.t.i;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class ArraysKt___ArraysKt$withIndex$4
extends Lambda
implements a {
    public final /* synthetic */ int[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$4(int[] nArray) {
        this.$this_withIndex = nArray;
        super(0);
    }

    public final Iterator invoke() {
        return i.f(this.$this_withIndex);
    }
}


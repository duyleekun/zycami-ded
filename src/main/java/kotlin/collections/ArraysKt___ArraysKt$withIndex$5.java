/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import f.h2.t.i;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class ArraysKt___ArraysKt$withIndex$5
extends Lambda
implements a {
    public final /* synthetic */ long[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$5(long[] lArray) {
        this.$this_withIndex = lArray;
        super(0);
    }

    public final Iterator invoke() {
        return i.g(this.$this_withIndex);
    }
}


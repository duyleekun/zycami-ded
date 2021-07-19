/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import f.h2.t.i;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class ArraysKt___ArraysKt$withIndex$7
extends Lambda
implements a {
    public final /* synthetic */ double[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$7(double[] dArray) {
        this.$this_withIndex = dArray;
        super(0);
    }

    public final Iterator invoke() {
        return i.d(this.$this_withIndex);
    }
}


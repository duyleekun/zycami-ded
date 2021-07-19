/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import f.h2.t.i;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class ArraysKt___ArraysKt$withIndex$6
extends Lambda
implements a {
    public final /* synthetic */ float[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$6(float[] fArray) {
        this.$this_withIndex = fArray;
        super(0);
    }

    public final Iterator invoke() {
        return i.e(this.$this_withIndex);
    }
}


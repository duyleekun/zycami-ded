/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import f.h2.t.i;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class ArraysKt___ArraysKt$withIndex$3
extends Lambda
implements a {
    public final /* synthetic */ short[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$3(short[] sArray) {
        this.$this_withIndex = sArray;
        super(0);
    }

    public final Iterator invoke() {
        return i.h(this.$this_withIndex);
    }
}


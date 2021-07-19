/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import f.h2.t.h;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class ArraysKt___ArraysKt$withIndex$1
extends Lambda
implements a {
    public final /* synthetic */ Object[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$1(Object[] objectArray) {
        this.$this_withIndex = objectArray;
        super(0);
    }

    public final Iterator invoke() {
        return h.a(this.$this_withIndex);
    }
}


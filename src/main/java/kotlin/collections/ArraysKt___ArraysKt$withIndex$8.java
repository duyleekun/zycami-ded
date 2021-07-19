/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import f.h2.t.i;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class ArraysKt___ArraysKt$withIndex$8
extends Lambda
implements a {
    public final /* synthetic */ boolean[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$8(boolean[] blArray) {
        this.$this_withIndex = blArray;
        super(0);
    }

    public final Iterator invoke() {
        return i.a(this.$this_withIndex);
    }
}


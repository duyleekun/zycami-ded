/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import f.h2.t.i;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class ArraysKt___ArraysKt$withIndex$2
extends Lambda
implements a {
    public final /* synthetic */ byte[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$2(byte[] byArray) {
        this.$this_withIndex = byArray;
        super(0);
    }

    public final Iterator invoke() {
        return i.b(this.$this_withIndex);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import f.h2.t.i;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class ArraysKt___ArraysKt$withIndex$9
extends Lambda
implements a {
    public final /* synthetic */ char[] $this_withIndex;

    public ArraysKt___ArraysKt$withIndex$9(char[] cArray) {
        this.$this_withIndex = cArray;
        super(0);
    }

    public final Iterator invoke() {
        return i.c(this.$this_withIndex);
    }
}


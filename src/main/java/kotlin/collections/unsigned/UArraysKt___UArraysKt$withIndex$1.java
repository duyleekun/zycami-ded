/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections.unsigned;

import f.d1;
import f.h2.s.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class UArraysKt___UArraysKt$withIndex$1
extends Lambda
implements a {
    public final /* synthetic */ int[] $this_withIndex;

    public UArraysKt___UArraysKt$withIndex$1(int[] nArray) {
        this.$this_withIndex = nArray;
        super(0);
    }

    public final Iterator invoke() {
        return d1.s(this.$this_withIndex);
    }
}


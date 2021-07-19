/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections.unsigned;

import f.h1;
import f.h2.s.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class UArraysKt___UArraysKt$withIndex$2
extends Lambda
implements a {
    public final /* synthetic */ long[] $this_withIndex;

    public UArraysKt___UArraysKt$withIndex$2(long[] lArray) {
        this.$this_withIndex = lArray;
        super(0);
    }

    public final Iterator invoke() {
        return h1.s(this.$this_withIndex);
    }
}


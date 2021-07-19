/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections.unsigned;

import f.h2.s.a;
import f.n1;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class UArraysKt___UArraysKt$withIndex$4
extends Lambda
implements a {
    public final /* synthetic */ short[] $this_withIndex;

    public UArraysKt___UArraysKt$withIndex$4(short[] sArray) {
        this.$this_withIndex = sArray;
        super(0);
    }

    public final Iterator invoke() {
        return n1.s(this.$this_withIndex);
    }
}


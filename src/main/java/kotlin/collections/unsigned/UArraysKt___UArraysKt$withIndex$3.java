/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections.unsigned;

import f.h2.s.a;
import f.z0;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class UArraysKt___UArraysKt$withIndex$3
extends Lambda
implements a {
    public final /* synthetic */ byte[] $this_withIndex;

    public UArraysKt___UArraysKt$withIndex$3(byte[] byArray) {
        this.$this_withIndex = byArray;
        super(0);
    }

    public final Iterator invoke() {
        return z0.s(this.$this_withIndex);
    }
}


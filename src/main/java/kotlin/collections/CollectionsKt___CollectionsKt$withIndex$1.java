/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;

public final class CollectionsKt___CollectionsKt$withIndex$1
extends Lambda
implements a {
    public final /* synthetic */ Iterable $this_withIndex;

    public CollectionsKt___CollectionsKt$withIndex$1(Iterable iterable) {
        this.$this_withIndex = iterable;
        super(0);
    }

    public final Iterator invoke() {
        return this.$this_withIndex.iterator();
    }
}


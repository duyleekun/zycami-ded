/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Lists$TransformingRandomAccessList;
import com.google.common.collect.TransformedListIterator;
import java.util.ListIterator;

public class Lists$TransformingRandomAccessList$1
extends TransformedListIterator {
    public final /* synthetic */ Lists$TransformingRandomAccessList this$0;

    public Lists$TransformingRandomAccessList$1(Lists$TransformingRandomAccessList lists$TransformingRandomAccessList, ListIterator listIterator) {
        this.this$0 = lists$TransformingRandomAccessList;
        super(listIterator);
    }

    public Object transform(Object object) {
        return this.this$0.function.apply(object);
    }
}


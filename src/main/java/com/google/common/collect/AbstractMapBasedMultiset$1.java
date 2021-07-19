/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.AbstractMapBasedMultiset$Itr;

public class AbstractMapBasedMultiset$1
extends AbstractMapBasedMultiset$Itr {
    public final /* synthetic */ AbstractMapBasedMultiset this$0;

    public AbstractMapBasedMultiset$1(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        this.this$0 = abstractMapBasedMultiset;
        super(abstractMapBasedMultiset);
    }

    public Object result(int n10) {
        return this.this$0.backingMap.getKey(n10);
    }
}


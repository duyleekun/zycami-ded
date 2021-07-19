/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList;
import java.util.List;
import java.util.RandomAccess;

public class AbstractMapBasedMultimap$RandomAccessWrappedList
extends AbstractMapBasedMultimap$WrappedList
implements RandomAccess {
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$RandomAccessWrappedList(AbstractMapBasedMultimap abstractMapBasedMultimap, Object object, List list, AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, object, list, abstractMapBasedMultimap$WrappedCollection);
    }
}


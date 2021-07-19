/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import com.google.common.collect.CollectPreconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class AbstractMapBasedMultimap$AsMap$AsMapIterator
implements Iterator {
    public Collection collection;
    public final Iterator delegateIterator;
    public final /* synthetic */ AbstractMapBasedMultimap$AsMap this$1;

    public AbstractMapBasedMultimap$AsMap$AsMapIterator(AbstractMapBasedMultimap$AsMap object) {
        this.this$1 = object;
        this.delegateIterator = object = ((AbstractMapBasedMultimap$AsMap)object).submap.entrySet().iterator();
    }

    public boolean hasNext() {
        return this.delegateIterator.hasNext();
    }

    public Map.Entry next() {
        Collection collection;
        Map.Entry entry = (Map.Entry)this.delegateIterator.next();
        this.collection = collection = (Collection)entry.getValue();
        return this.this$1.wrapEntry(entry);
    }

    public void remove() {
        boolean bl2;
        Object object = this.collection;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        CollectPreconditions.checkRemove(bl2);
        this.delegateIterator.remove();
        object = this.this$1.this$0;
        int n10 = AbstractMapBasedMultimap.access$200((AbstractMapBasedMultimap)object);
        int n11 = this.collection.size();
        AbstractMapBasedMultimap.access$202((AbstractMapBasedMultimap)object, n10 -= n11);
        this.collection.clear();
        this.collection = null;
    }
}


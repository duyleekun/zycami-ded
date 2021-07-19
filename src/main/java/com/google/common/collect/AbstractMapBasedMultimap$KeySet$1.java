/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet;
import com.google.common.collect.CollectPreconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class AbstractMapBasedMultimap$KeySet$1
implements Iterator {
    public Map.Entry entry;
    public final /* synthetic */ AbstractMapBasedMultimap$KeySet this$1;
    public final /* synthetic */ Iterator val$entryIterator;

    public AbstractMapBasedMultimap$KeySet$1(AbstractMapBasedMultimap$KeySet keySet, Iterator iterator2) {
        this.this$1 = keySet;
        this.val$entryIterator = iterator2;
    }

    public boolean hasNext() {
        return this.val$entryIterator.hasNext();
    }

    public Object next() {
        Map.Entry entry;
        this.entry = entry = (Map.Entry)this.val$entryIterator.next();
        return entry.getKey();
    }

    public void remove() {
        boolean bl2;
        Object object = this.entry;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        CollectPreconditions.checkRemove(bl2);
        object = (Collection)this.entry.getValue();
        this.val$entryIterator.remove();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$1.this$0;
        int n10 = AbstractMapBasedMultimap.access$200(abstractMapBasedMultimap);
        int n11 = object.size();
        AbstractMapBasedMultimap.access$202(abstractMapBasedMultimap, n10 -= n11);
        object.clear();
        this.entry = null;
    }
}


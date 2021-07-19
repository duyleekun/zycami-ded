/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractMapBasedMultimap$Itr
implements Iterator {
    public Collection collection;
    public Object key;
    public final Iterator keyIterator;
    public final /* synthetic */ AbstractMapBasedMultimap this$0;
    public Iterator valueIterator;

    public AbstractMapBasedMultimap$Itr(AbstractMapBasedMultimap object) {
        this.this$0 = object;
        this.keyIterator = object = AbstractMapBasedMultimap.access$000((AbstractMapBasedMultimap)object).entrySet().iterator();
        this.key = null;
        this.collection = null;
        this.valueIterator = object = Iterators.emptyModifiableIterator();
    }

    public boolean hasNext() {
        Iterator iterator2 = this.keyIterator;
        boolean bl2 = iterator2.hasNext();
        if (!bl2 && !(bl2 = (iterator2 = this.valueIterator).hasNext())) {
            bl2 = false;
            iterator2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object next() {
        Object object;
        Iterator iterator2 = this.valueIterator;
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            iterator2 = (Map.Entry)this.keyIterator.next();
            object = iterator2.getKey();
            this.key = object;
            iterator2 = (Collection)iterator2.getValue();
            this.collection = iterator2;
            this.valueIterator = iterator2 = iterator2.iterator();
        }
        iterator2 = this.key;
        object = this.valueIterator.next();
        return this.output(iterator2, object);
    }

    public abstract Object output(Object var1, Object var2);

    public void remove() {
        this.valueIterator.remove();
        Object object = this.collection;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object = this.keyIterator;
            object.remove();
        }
        AbstractMapBasedMultimap.access$210(this.this$0);
    }
}


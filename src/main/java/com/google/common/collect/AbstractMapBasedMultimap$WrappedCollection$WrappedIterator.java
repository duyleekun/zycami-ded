/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class AbstractMapBasedMultimap$WrappedCollection$WrappedIterator
implements Iterator {
    public final Iterator delegateIterator;
    public final Collection originalDelegate;
    public final /* synthetic */ AbstractMapBasedMultimap$WrappedCollection this$1;

    public AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(AbstractMapBasedMultimap$WrappedCollection object) {
        this.this$1 = object;
        object = ((AbstractMapBasedMultimap$WrappedCollection)object).delegate;
        this.originalDelegate = object;
        this.delegateIterator = object = AbstractMapBasedMultimap.access$100((Collection)object);
    }

    public AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(AbstractMapBasedMultimap$WrappedCollection collection, Iterator iterator2) {
        this.this$1 = collection;
        collection = collection.delegate;
        this.originalDelegate = collection;
        this.delegateIterator = iterator2;
    }

    public Iterator getDelegateIterator() {
        this.validateIterator();
        return this.delegateIterator;
    }

    public boolean hasNext() {
        this.validateIterator();
        return this.delegateIterator.hasNext();
    }

    public Object next() {
        this.validateIterator();
        return this.delegateIterator.next();
    }

    public void remove() {
        this.delegateIterator.remove();
        AbstractMapBasedMultimap.access$210(this.this$1.this$0);
        this.this$1.removeIfEmpty();
    }

    public void validateIterator() {
        this.this$1.refreshIfEmpty();
        Object object = this.this$1.delegate;
        Collection collection = this.originalDelegate;
        if (object == collection) {
            return;
        }
        object = new ConcurrentModificationException();
        throw object;
    }
}


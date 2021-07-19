/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class AbstractMapBasedMultimap$WrappedCollection
extends AbstractCollection {
    public final AbstractMapBasedMultimap$WrappedCollection ancestor;
    public final Collection ancestorDelegate;
    public Collection delegate;
    public final Object key;
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$WrappedCollection(AbstractMapBasedMultimap object, Object object2, Collection collection, AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$0 = object;
        this.key = object2;
        this.delegate = collection;
        this.ancestor = abstractMapBasedMultimap$WrappedCollection;
        object = abstractMapBasedMultimap$WrappedCollection == null ? null : abstractMapBasedMultimap$WrappedCollection.getDelegate();
        this.ancestorDelegate = object;
    }

    public boolean add(Object object) {
        this.refreshIfEmpty();
        Collection collection = this.delegate;
        boolean bl2 = collection.isEmpty();
        Object object2 = this.delegate;
        boolean bl3 = object2.add(object);
        if (bl3) {
            object2 = this.this$0;
            AbstractMapBasedMultimap.access$208((AbstractMapBasedMultimap)object2);
            if (bl2) {
                this.addToMap();
            }
        }
        return bl3;
    }

    public boolean addAll(Collection collection) {
        int n10 = collection.isEmpty();
        if (n10 != 0) {
            return false;
        }
        n10 = this.size();
        Collection collection2 = this.delegate;
        boolean bl2 = collection2.addAll(collection);
        if (bl2) {
            collection2 = this.delegate;
            int n11 = collection2.size();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
            int n12 = AbstractMapBasedMultimap.access$200(abstractMapBasedMultimap);
            AbstractMapBasedMultimap.access$202(abstractMapBasedMultimap, n12 += (n11 -= n10));
            if (n10 == 0) {
                this.addToMap();
            }
        }
        return bl2;
    }

    public void addToMap() {
        Object object = this.ancestor;
        if (object != null) {
            ((AbstractMapBasedMultimap$WrappedCollection)object).addToMap();
        } else {
            object = AbstractMapBasedMultimap.access$000(this.this$0);
            Object object2 = this.key;
            Collection collection = this.delegate;
            object.put(object2, collection);
        }
    }

    public void clear() {
        int n10 = this.size();
        if (n10 == 0) {
            return;
        }
        this.delegate.clear();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        int n11 = AbstractMapBasedMultimap.access$200(abstractMapBasedMultimap) - n10;
        AbstractMapBasedMultimap.access$202(abstractMapBasedMultimap, n11);
        this.removeIfEmpty();
    }

    public boolean contains(Object object) {
        this.refreshIfEmpty();
        return this.delegate.contains(object);
    }

    public boolean containsAll(Collection collection) {
        this.refreshIfEmpty();
        return this.delegate.containsAll(collection);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        this.refreshIfEmpty();
        return this.delegate.equals(object);
    }

    public AbstractMapBasedMultimap$WrappedCollection getAncestor() {
        return this.ancestor;
    }

    public Collection getDelegate() {
        return this.delegate;
    }

    public Object getKey() {
        return this.key;
    }

    public int hashCode() {
        this.refreshIfEmpty();
        return this.delegate.hashCode();
    }

    public Iterator iterator() {
        this.refreshIfEmpty();
        AbstractMapBasedMultimap$WrappedCollection$WrappedIterator abstractMapBasedMultimap$WrappedCollection$WrappedIterator = new AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(this);
        return abstractMapBasedMultimap$WrappedCollection$WrappedIterator;
    }

    public void refreshIfEmpty() {
        Object object = this.ancestor;
        if (object != null) {
            ((AbstractMapBasedMultimap$WrappedCollection)object).refreshIfEmpty();
            object = this.ancestor.getDelegate();
            Collection collection = this.ancestorDelegate;
            if (object != collection) {
                object = new ConcurrentModificationException();
                throw object;
            }
        } else {
            object = this.delegate;
            boolean bl2 = object.isEmpty();
            if (bl2) {
                object = AbstractMapBasedMultimap.access$000(this.this$0);
                Object object2 = this.key;
                if ((object = (Collection)object.get(object2)) != null) {
                    this.delegate = object;
                }
            }
        }
    }

    public boolean remove(Object object) {
        this.refreshIfEmpty();
        Object object2 = this.delegate;
        boolean bl2 = object2.remove(object);
        if (bl2) {
            object2 = this.this$0;
            AbstractMapBasedMultimap.access$210((AbstractMapBasedMultimap)object2);
            this.removeIfEmpty();
        }
        return bl2;
    }

    public boolean removeAll(Collection collection) {
        int n10 = collection.isEmpty();
        if (n10 != 0) {
            return false;
        }
        n10 = this.size();
        Collection collection2 = this.delegate;
        boolean bl2 = collection2.removeAll(collection);
        if (bl2) {
            collection2 = this.delegate;
            int n11 = collection2.size();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
            int n12 = AbstractMapBasedMultimap.access$200(abstractMapBasedMultimap);
            AbstractMapBasedMultimap.access$202(abstractMapBasedMultimap, n12 += (n11 -= n10));
            this.removeIfEmpty();
        }
        return bl2;
    }

    public void removeIfEmpty() {
        Object object = this.ancestor;
        if (object != null) {
            ((AbstractMapBasedMultimap$WrappedCollection)object).removeIfEmpty();
        } else {
            object = this.delegate;
            boolean bl2 = object.isEmpty();
            if (bl2) {
                object = AbstractMapBasedMultimap.access$000(this.this$0);
                Object object2 = this.key;
                object.remove(object2);
            }
        }
    }

    public boolean retainAll(Collection collection) {
        Preconditions.checkNotNull(collection);
        int n10 = this.size();
        Collection collection2 = this.delegate;
        boolean bl2 = collection2.retainAll(collection);
        if (bl2) {
            collection2 = this.delegate;
            int n11 = collection2.size();
            AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
            int n12 = AbstractMapBasedMultimap.access$200(abstractMapBasedMultimap);
            AbstractMapBasedMultimap.access$202(abstractMapBasedMultimap, n12 += (n11 -= n10));
            this.removeIfEmpty();
        }
        return bl2;
    }

    public int size() {
        this.refreshIfEmpty();
        return this.delegate.size();
    }

    public String toString() {
        this.refreshIfEmpty();
        return this.delegate.toString();
    }
}


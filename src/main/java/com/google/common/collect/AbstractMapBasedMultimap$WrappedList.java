/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList$WrappedListIterator;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class AbstractMapBasedMultimap$WrappedList
extends AbstractMapBasedMultimap$WrappedCollection
implements List {
    public final /* synthetic */ AbstractMapBasedMultimap this$0;

    public AbstractMapBasedMultimap$WrappedList(AbstractMapBasedMultimap abstractMapBasedMultimap, Object object, List list, AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, object, list, abstractMapBasedMultimap$WrappedCollection);
    }

    public void add(int n10, Object object) {
        this.refreshIfEmpty();
        Collection collection = this.getDelegate();
        boolean bl2 = collection.isEmpty();
        List list = this.getListDelegate();
        list.add(n10, object);
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        AbstractMapBasedMultimap.access$208(abstractMapBasedMultimap);
        if (bl2) {
            this.addToMap();
        }
    }

    public boolean addAll(int n10, Collection collection) {
        int n11 = collection.isEmpty();
        if (n11 != 0) {
            return false;
        }
        n11 = this.size();
        Object object = this.getListDelegate();
        n10 = (int)(object.addAll(n10, collection) ? 1 : 0);
        if (n10 != 0) {
            collection = this.getDelegate();
            int n12 = collection.size();
            object = this.this$0;
            int n13 = AbstractMapBasedMultimap.access$200((AbstractMapBasedMultimap)object);
            AbstractMapBasedMultimap.access$202((AbstractMapBasedMultimap)object, n13 += (n12 -= n11));
            if (n11 == 0) {
                this.addToMap();
            }
        }
        return n10 != 0;
    }

    public Object get(int n10) {
        this.refreshIfEmpty();
        return this.getListDelegate().get(n10);
    }

    public List getListDelegate() {
        return (List)this.getDelegate();
    }

    public int indexOf(Object object) {
        this.refreshIfEmpty();
        return this.getListDelegate().indexOf(object);
    }

    public int lastIndexOf(Object object) {
        this.refreshIfEmpty();
        return this.getListDelegate().lastIndexOf(object);
    }

    public ListIterator listIterator() {
        this.refreshIfEmpty();
        AbstractMapBasedMultimap$WrappedList$WrappedListIterator abstractMapBasedMultimap$WrappedList$WrappedListIterator = new AbstractMapBasedMultimap$WrappedList$WrappedListIterator(this);
        return abstractMapBasedMultimap$WrappedList$WrappedListIterator;
    }

    public ListIterator listIterator(int n10) {
        this.refreshIfEmpty();
        AbstractMapBasedMultimap$WrappedList$WrappedListIterator abstractMapBasedMultimap$WrappedList$WrappedListIterator = new AbstractMapBasedMultimap$WrappedList$WrappedListIterator(this, n10);
        return abstractMapBasedMultimap$WrappedList$WrappedListIterator;
    }

    public Object remove(int n10) {
        this.refreshIfEmpty();
        Object e10 = this.getListDelegate().remove(n10);
        AbstractMapBasedMultimap.access$210(this.this$0);
        this.removeIfEmpty();
        return e10;
    }

    public Object set(int n10, Object object) {
        this.refreshIfEmpty();
        return this.getListDelegate().set(n10, object);
    }

    public List subList(int n10, int n11) {
        this.refreshIfEmpty();
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$0;
        Object object = this.getKey();
        List list = this.getListDelegate();
        List list2 = list.subList(n10, n11);
        AbstractMapBasedMultimap$WrappedCollection abstractMapBasedMultimap$WrappedCollection = this.getAncestor();
        abstractMapBasedMultimap$WrappedCollection = abstractMapBasedMultimap$WrappedCollection == null ? this : this.getAncestor();
        return abstractMapBasedMultimap.wrapList(object, list2, abstractMapBasedMultimap$WrappedCollection);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator;
import com.google.common.collect.AbstractMapBasedMultimap$WrappedList;
import java.util.ListIterator;

public class AbstractMapBasedMultimap$WrappedList$WrappedListIterator
extends AbstractMapBasedMultimap$WrappedCollection$WrappedIterator
implements ListIterator {
    public final /* synthetic */ AbstractMapBasedMultimap$WrappedList this$1;

    public AbstractMapBasedMultimap$WrappedList$WrappedListIterator(AbstractMapBasedMultimap$WrappedList abstractMapBasedMultimap$WrappedList) {
        this.this$1 = abstractMapBasedMultimap$WrappedList;
        super(abstractMapBasedMultimap$WrappedList);
    }

    public AbstractMapBasedMultimap$WrappedList$WrappedListIterator(AbstractMapBasedMultimap$WrappedList abstractMapBasedMultimap$WrappedList, int n10) {
        this.this$1 = abstractMapBasedMultimap$WrappedList;
        ListIterator listIterator = abstractMapBasedMultimap$WrappedList.getListDelegate().listIterator(n10);
        super(abstractMapBasedMultimap$WrappedList, listIterator);
    }

    private ListIterator getDelegateListIterator() {
        return (ListIterator)this.getDelegateIterator();
    }

    public void add(Object object) {
        AbstractMapBasedMultimap$WrappedList abstractMapBasedMultimap$WrappedList = this.this$1;
        boolean bl2 = abstractMapBasedMultimap$WrappedList.isEmpty();
        ListIterator listIterator = this.getDelegateListIterator();
        listIterator.add(object);
        object = this.this$1.this$0;
        AbstractMapBasedMultimap.access$208((AbstractMapBasedMultimap)object);
        if (bl2) {
            object = this.this$1;
            ((AbstractMapBasedMultimap$WrappedCollection)object).addToMap();
        }
    }

    public boolean hasPrevious() {
        return this.getDelegateListIterator().hasPrevious();
    }

    public int nextIndex() {
        return this.getDelegateListIterator().nextIndex();
    }

    public Object previous() {
        return this.getDelegateListIterator().previous();
    }

    public int previousIndex() {
        return this.getDelegateListIterator().previousIndex();
    }

    public void set(Object object) {
        this.getDelegateListIterator().set(object);
    }
}


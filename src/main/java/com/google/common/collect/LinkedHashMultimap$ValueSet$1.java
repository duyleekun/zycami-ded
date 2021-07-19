/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSet;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedHashMultimap$ValueSet$1
implements Iterator {
    public int expectedModCount;
    public LinkedHashMultimap$ValueSetLink nextEntry;
    public final /* synthetic */ LinkedHashMultimap$ValueSet this$1;
    public LinkedHashMultimap$ValueEntry toRemove;

    public LinkedHashMultimap$ValueSet$1(LinkedHashMultimap$ValueSet linkedHashMultimap$ValueSet) {
        int n10;
        LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink;
        this.this$1 = linkedHashMultimap$ValueSet;
        this.nextEntry = linkedHashMultimap$ValueSetLink = LinkedHashMultimap$ValueSet.access$000(linkedHashMultimap$ValueSet);
        this.expectedModCount = n10 = LinkedHashMultimap$ValueSet.access$100(linkedHashMultimap$ValueSet);
    }

    private void checkForComodification() {
        int n10;
        Object object = this.this$1;
        int n11 = LinkedHashMultimap$ValueSet.access$100((LinkedHashMultimap$ValueSet)object);
        if (n11 == (n10 = this.expectedModCount)) {
            return;
        }
        object = new ConcurrentModificationException();
        throw object;
    }

    public boolean hasNext() {
        boolean bl2;
        this.checkForComodification();
        LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink = this.nextEntry;
        LinkedHashMultimap$ValueSet linkedHashMultimap$ValueSet = this.this$1;
        if (linkedHashMultimap$ValueSetLink != linkedHashMultimap$ValueSet) {
            bl2 = true;
        } else {
            bl2 = false;
            linkedHashMultimap$ValueSetLink = null;
        }
        return bl2;
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink = (LinkedHashMultimap$ValueEntry)this.nextEntry;
            Object object = linkedHashMultimap$ValueSetLink.getValue();
            this.toRemove = linkedHashMultimap$ValueSetLink;
            linkedHashMultimap$ValueSetLink = linkedHashMultimap$ValueSetLink.getSuccessorInValueSet();
            this.nextEntry = linkedHashMultimap$ValueSetLink;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        int n10;
        this.checkForComodification();
        LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink = this.toRemove;
        if (linkedHashMultimap$ValueSetLink != null) {
            n10 = 1;
        } else {
            n10 = 0;
            linkedHashMultimap$ValueSetLink = null;
        }
        CollectPreconditions.checkRemove(n10 != 0);
        linkedHashMultimap$ValueSetLink = this.this$1;
        Object object = this.toRemove.getValue();
        ((LinkedHashMultimap$ValueSet)linkedHashMultimap$ValueSetLink).remove(object);
        this.expectedModCount = n10 = LinkedHashMultimap$ValueSet.access$100(this.this$1);
        this.toRemove = null;
    }
}


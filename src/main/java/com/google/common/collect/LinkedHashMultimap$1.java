/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class LinkedHashMultimap$1
implements Iterator {
    public LinkedHashMultimap$ValueEntry nextEntry;
    public final /* synthetic */ LinkedHashMultimap this$0;
    public LinkedHashMultimap$ValueEntry toRemove;

    public LinkedHashMultimap$1(LinkedHashMultimap serializable) {
        this.this$0 = serializable;
        serializable = LinkedHashMultimap.access$300((LinkedHashMultimap)serializable).successorInMultimap;
        this.nextEntry = serializable;
    }

    public boolean hasNext() {
        boolean bl2;
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry = this.nextEntry;
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2 = LinkedHashMultimap.access$300(this.this$0);
        if (linkedHashMultimap$ValueEntry != linkedHashMultimap$ValueEntry2) {
            bl2 = true;
        } else {
            bl2 = false;
            linkedHashMultimap$ValueEntry = null;
        }
        return bl2;
    }

    public Map.Entry next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry;
            LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2;
            this.toRemove = linkedHashMultimap$ValueEntry2 = this.nextEntry;
            this.nextEntry = linkedHashMultimap$ValueEntry = linkedHashMultimap$ValueEntry2.successorInMultimap;
            return linkedHashMultimap$ValueEntry2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        boolean bl2;
        Serializable serializable = this.toRemove;
        if (serializable != null) {
            bl2 = true;
        } else {
            bl2 = false;
            serializable = null;
        }
        CollectPreconditions.checkRemove(bl2);
        serializable = this.this$0;
        Object object = this.toRemove.getKey();
        Object object2 = this.toRemove.getValue();
        ((LinkedHashMultimap)serializable).remove(object, object2);
        this.toRemove = null;
    }
}


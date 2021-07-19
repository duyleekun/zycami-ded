/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ForwardingNavigableMap$StandardDescendingMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class ForwardingNavigableMap$StandardDescendingMap$1
implements Iterator {
    private Map.Entry nextOrNull;
    public final /* synthetic */ ForwardingNavigableMap$StandardDescendingMap this$1;
    private Map.Entry toRemove = null;

    public ForwardingNavigableMap$StandardDescendingMap$1(ForwardingNavigableMap$StandardDescendingMap object) {
        this.this$1 = object;
        this.nextOrNull = object = ((ForwardingNavigableMap$StandardDescendingMap)object).forward().lastEntry();
    }

    public boolean hasNext() {
        boolean bl2;
        Map.Entry entry = this.nextOrNull;
        if (entry != null) {
            bl2 = true;
        } else {
            bl2 = false;
            entry = null;
        }
        return bl2;
    }

    public Map.Entry next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            try {
                Map.Entry entry;
                this.toRemove = entry = this.nextOrNull;
                Object object = this.this$1.forward();
                Object k10 = this.nextOrNull.getKey();
                this.nextOrNull = object = object.lowerEntry(k10);
                return entry;
            }
            catch (Throwable throwable) {
                Map.Entry entry = this.nextOrNull;
                this.toRemove = entry;
                entry = this.this$1.forward();
                Object k11 = this.nextOrNull.getKey();
                this.nextOrNull = entry = entry.lowerEntry(k11);
                throw throwable;
            }
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        boolean bl2;
        Object object = this.toRemove;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        CollectPreconditions.checkRemove(bl2);
        object = this.this$1.forward();
        Object k10 = this.toRemove.getKey();
        object.remove(k10);
        this.toRemove = null;
    }
}


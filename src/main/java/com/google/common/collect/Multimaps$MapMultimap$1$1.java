/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multimaps$MapMultimap$1;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Multimaps$MapMultimap$1$1
implements Iterator {
    public int i;
    public final /* synthetic */ Multimaps$MapMultimap$1 this$1;

    public Multimaps$MapMultimap$1$1(Multimaps$MapMultimap$1 var1_1) {
        this.this$1 = var1_1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean hasNext() {
        int n10 = this.i;
        if (n10 != 0) return 0 != 0;
        Object object = this.this$1;
        Map map = object.this$0.map;
        object = ((Multimaps$MapMultimap$1)object).val$key;
        n10 = map.containsKey(object);
        if (n10 == 0) return 0 != 0;
        return 1 != 0;
    }

    public Object next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            this.i = n10 = this.i + 1;
            Object object = this.this$1;
            Map map = object.this$0.map;
            object = ((Multimaps$MapMultimap$1)object).val$key;
            return map.get(object);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        Map map;
        int n10 = this.i;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
            map = null;
        }
        CollectPreconditions.checkRemove(n11 != 0);
        this.i = -1;
        Object object = this.this$1;
        map = object.this$0.map;
        object = ((Multimaps$MapMultimap$1)object).val$key;
        map.remove(object);
    }
}


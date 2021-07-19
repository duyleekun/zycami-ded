/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.FlowIterator;
import com.mob.tools.java8.MapFlow$MapItem;
import java.util.Iterator;
import java.util.Map;

public class FlowIterator$MapIterator
implements FlowIterator {
    private Iterator it;

    public FlowIterator$MapIterator(Map object) {
        this.it = object = object.entrySet().iterator();
    }

    public void finish() {
    }

    public boolean hasNext() {
        return this.it.hasNext();
    }

    public MapFlow$MapItem next() {
        MapFlow$MapItem mapFlow$MapItem = new MapFlow$MapItem();
        Map.Entry entry = (Map.Entry)this.it.next();
        Object k10 = entry.getKey();
        mapFlow$MapItem.key = k10;
        entry = entry.getValue();
        mapFlow$MapItem.value = entry;
        return mapFlow$MapItem;
    }
}


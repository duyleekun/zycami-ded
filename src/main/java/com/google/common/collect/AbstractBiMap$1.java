/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$BiMapEntry;
import com.google.common.collect.CollectPreconditions;
import java.util.Iterator;
import java.util.Map;

public class AbstractBiMap$1
implements Iterator {
    public Map.Entry entry;
    public final /* synthetic */ AbstractBiMap this$0;
    public final /* synthetic */ Iterator val$iterator;

    public AbstractBiMap$1(AbstractBiMap abstractBiMap, Iterator iterator2) {
        this.this$0 = abstractBiMap;
        this.val$iterator = iterator2;
    }

    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Map.Entry next() {
        Map.Entry entry;
        this.entry = entry = (Map.Entry)this.val$iterator.next();
        AbstractBiMap abstractBiMap = this.this$0;
        AbstractBiMap$BiMapEntry abstractBiMap$BiMapEntry = new AbstractBiMap$BiMapEntry(abstractBiMap, entry);
        return abstractBiMap$BiMapEntry;
    }

    public void remove() {
        boolean bl2;
        Map.Entry entry = this.entry;
        if (entry != null) {
            bl2 = true;
        } else {
            bl2 = false;
            entry = null;
        }
        CollectPreconditions.checkRemove(bl2);
        entry = this.entry.getValue();
        this.val$iterator.remove();
        AbstractBiMap.access$600(this.this$0, entry);
        this.entry = null;
    }
}


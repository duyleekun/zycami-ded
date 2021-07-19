/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.StandardTable$Column$EntrySetIterator;
import java.util.Map;

public class StandardTable$Column$EntrySetIterator$1EntryImpl
extends AbstractMapEntry {
    public final /* synthetic */ StandardTable$Column$EntrySetIterator this$2;
    public final /* synthetic */ Map.Entry val$entry;

    public StandardTable$Column$EntrySetIterator$1EntryImpl(StandardTable$Column$EntrySetIterator standardTable$Column$EntrySetIterator, Map.Entry entry) {
        this.this$2 = standardTable$Column$EntrySetIterator;
        this.val$entry = entry;
    }

    public Object getKey() {
        return this.val$entry.getKey();
    }

    public Object getValue() {
        Map map = (Map)this.val$entry.getValue();
        Object object = this.this$2.this$1.columnKey;
        return map.get(object);
    }

    public Object setValue(Object object) {
        Map map = (Map)this.val$entry.getValue();
        Object object2 = this.this$2.this$1.columnKey;
        object = Preconditions.checkNotNull(object);
        return map.put(object2, object);
    }
}


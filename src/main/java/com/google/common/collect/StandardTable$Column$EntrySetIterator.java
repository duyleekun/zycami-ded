/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$Column;
import com.google.common.collect.StandardTable$Column$EntrySetIterator$1EntryImpl;
import java.util.Iterator;
import java.util.Map;

public class StandardTable$Column$EntrySetIterator
extends AbstractIterator {
    public final Iterator iterator;
    public final /* synthetic */ StandardTable$Column this$1;

    private StandardTable$Column$EntrySetIterator(StandardTable$Column object) {
        this.this$1 = object;
        this.iterator = object = object.this$0.backingMap.entrySet().iterator();
    }

    public /* synthetic */ StandardTable$Column$EntrySetIterator(StandardTable$Column standardTable$Column, StandardTable$1 standardTable$1) {
        this(standardTable$Column);
    }

    public Map.Entry computeNext() {
        Object object;
        boolean bl2;
        while (bl2 = (object = this.iterator).hasNext()) {
            Object object2;
            object = (Map.Entry)this.iterator.next();
            Object object3 = (Map)object.getValue();
            boolean bl3 = object3.containsKey(object2 = this.this$1.columnKey);
            if (!bl3) continue;
            object3 = new StandardTable$Column$EntrySetIterator$1EntryImpl(this, (Map.Entry)object);
            return object3;
        }
        return (Map.Entry)this.endOfData();
    }
}


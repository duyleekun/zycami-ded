/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import java.util.Iterator;
import java.util.Map;

public class StandardTable$ColumnKeyIterator
extends AbstractIterator {
    public Iterator entryIterator;
    public final Iterator mapIterator;
    public final Map seen;
    public final /* synthetic */ StandardTable this$0;

    private StandardTable$ColumnKeyIterator(StandardTable object) {
        Map map;
        this.this$0 = object;
        this.seen = map = (Map)((StandardTable)object).factory.get();
        this.mapIterator = object = ((StandardTable)object).backingMap.values().iterator();
        this.entryIterator = object = Iterators.emptyIterator();
    }

    public /* synthetic */ StandardTable$ColumnKeyIterator(StandardTable standardTable, StandardTable$1 standardTable$1) {
        this(standardTable);
    }

    public Object computeNext() {
        while (true) {
            Object object;
            boolean bl2;
            if (bl2 = (object = this.entryIterator).hasNext()) {
                Map map = this.seen;
                object = (Map.Entry)this.entryIterator.next();
                Object k10 = object.getKey();
                boolean bl3 = map.containsKey(k10);
                if (bl3) continue;
                map = this.seen;
                k10 = object.getKey();
                Object v10 = object.getValue();
                map.put(k10, v10);
                return object.getKey();
            }
            object = this.mapIterator;
            bl2 = object.hasNext();
            if (!bl2) break;
            this.entryIterator = object = ((Map)this.mapIterator.next()).entrySet().iterator();
        }
        return this.endOfData();
    }
}


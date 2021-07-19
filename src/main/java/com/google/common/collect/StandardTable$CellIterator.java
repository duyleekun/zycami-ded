/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import java.util.Iterator;
import java.util.Map;

public class StandardTable$CellIterator
implements Iterator {
    public Iterator columnIterator;
    public Map.Entry rowEntry;
    public final Iterator rowIterator;
    public final /* synthetic */ StandardTable this$0;

    private StandardTable$CellIterator(StandardTable object) {
        this.this$0 = object;
        this.rowIterator = object = ((StandardTable)object).backingMap.entrySet().iterator();
        this.columnIterator = object = Iterators.emptyModifiableIterator();
    }

    public /* synthetic */ StandardTable$CellIterator(StandardTable standardTable, StandardTable$1 standardTable$1) {
        this(standardTable);
    }

    public boolean hasNext() {
        Iterator iterator2 = this.rowIterator;
        boolean bl2 = iterator2.hasNext();
        if (!bl2 && !(bl2 = (iterator2 = this.columnIterator).hasNext())) {
            bl2 = false;
            iterator2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Table$Cell next() {
        Iterator iterator2 = this.columnIterator;
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            iterator2 = (Map.Entry)this.rowIterator.next();
            this.rowEntry = iterator2;
            this.columnIterator = iterator2 = ((Map)iterator2.getValue()).entrySet().iterator();
        }
        iterator2 = (Map.Entry)this.columnIterator.next();
        Object k10 = this.rowEntry.getKey();
        Object k11 = iterator2.getKey();
        iterator2 = iterator2.getValue();
        return Tables.immutableCell(k10, k11, iterator2);
    }

    public void remove() {
        this.columnIterator.remove();
        Map map = (Map)this.rowEntry.getValue();
        boolean bl2 = map.isEmpty();
        if (bl2) {
            this.rowIterator.remove();
            bl2 = false;
            map = null;
            this.rowEntry = null;
        }
    }
}


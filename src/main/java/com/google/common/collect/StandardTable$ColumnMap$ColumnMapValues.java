/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$ColumnMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class StandardTable$ColumnMap$ColumnMapValues
extends Maps$Values {
    public final /* synthetic */ StandardTable$ColumnMap this$1;

    public StandardTable$ColumnMap$ColumnMapValues(StandardTable$ColumnMap standardTable$ColumnMap) {
        this.this$1 = standardTable$ColumnMap;
        super(standardTable$ColumnMap);
    }

    public boolean remove(Object object) {
        boolean bl2;
        Iterator<Object> iterator2 = this.this$1.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            Map map = (Map)entry.getValue();
            boolean bl3 = map.equals(object);
            if (!bl3) continue;
            object = this.this$1.this$0;
            iterator2 = entry.getKey();
            StandardTable.access$900((StandardTable)object, iterator2);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        boolean bl2;
        Preconditions.checkNotNull(collection);
        Iterator iterator2 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
        boolean bl3 = false;
        StandardTable standardTable = null;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            Map map = this.this$1.this$0.column(e10);
            boolean bl4 = collection.contains(map);
            if (!bl4) continue;
            standardTable = this.this$1.this$0;
            StandardTable.access$900(standardTable, e10);
            bl3 = true;
        }
        return bl3;
    }

    public boolean retainAll(Collection collection) {
        boolean bl2;
        Preconditions.checkNotNull(collection);
        Iterator iterator2 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
        boolean bl3 = false;
        StandardTable standardTable = null;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            Map map = this.this$1.this$0.column(e10);
            boolean bl4 = collection.contains(map);
            if (bl4) continue;
            standardTable = this.this$1.this$0;
            StandardTable.access$900(standardTable, e10);
            bl3 = true;
        }
        return bl3;
    }
}


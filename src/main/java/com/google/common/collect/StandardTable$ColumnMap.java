/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapValues;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class StandardTable$ColumnMap
extends Maps$ViewCachingAbstractMap {
    public final /* synthetic */ StandardTable this$0;

    private StandardTable$ColumnMap(StandardTable standardTable) {
        this.this$0 = standardTable;
    }

    public /* synthetic */ StandardTable$ColumnMap(StandardTable standardTable, StandardTable$1 standardTable$1) {
        this(standardTable);
    }

    public boolean containsKey(Object object) {
        return this.this$0.containsColumn(object);
    }

    public Set createEntrySet() {
        StandardTable$ColumnMap$ColumnMapEntrySet standardTable$ColumnMap$ColumnMapEntrySet = new StandardTable$ColumnMap$ColumnMapEntrySet(this);
        return standardTable$ColumnMap$ColumnMapEntrySet;
    }

    public Collection createValues() {
        StandardTable$ColumnMap$ColumnMapValues standardTable$ColumnMap$ColumnMapValues = new StandardTable$ColumnMap$ColumnMapValues(this);
        return standardTable$ColumnMap$ColumnMapValues;
    }

    public Map get(Object object) {
        StandardTable standardTable = this.this$0;
        boolean bl2 = standardTable.containsColumn(object);
        if (bl2) {
            standardTable = this.this$0;
            object = standardTable.column(object);
        } else {
            object = null;
        }
        return object;
    }

    public Set keySet() {
        return this.this$0.columnKeySet();
    }

    public Map remove(Object object) {
        StandardTable standardTable = this.this$0;
        boolean bl2 = standardTable.containsColumn(object);
        if (bl2) {
            standardTable = this.this$0;
            object = StandardTable.access$900(standardTable, object);
        } else {
            object = null;
        }
        return object;
    }
}


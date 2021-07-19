/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$RowMap;
import com.google.common.collect.StandardTable$RowMap$EntrySet$1;
import com.google.common.collect.StandardTable$TableSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StandardTable$RowMap$EntrySet
extends StandardTable$TableSet {
    public final /* synthetic */ StandardTable$RowMap this$1;

    public StandardTable$RowMap$EntrySet(StandardTable$RowMap object) {
        this.this$1 = object;
        object = ((StandardTable$RowMap)object).this$0;
        super((StandardTable)object, null);
    }

    public boolean contains(Object object) {
        boolean bl2;
        Object object2;
        boolean bl3 = object instanceof Map.Entry;
        boolean bl4 = false;
        if (bl3 && (object2 = (object = (Map.Entry)object).getKey()) != null && (bl3 = (object2 = object.getValue()) instanceof Map) && (bl2 = Collections2.safeContains(object2 = this.this$1.this$0.backingMap.entrySet(), object))) {
            bl4 = true;
        }
        return bl4;
    }

    public Iterator iterator() {
        Set set = this.this$1.this$0.backingMap.keySet();
        StandardTable$RowMap$EntrySet$1 standardTable$RowMap$EntrySet$1 = new StandardTable$RowMap$EntrySet$1(this);
        return Maps.asMapEntryIterator(set, standardTable$RowMap$EntrySet$1);
    }

    public boolean remove(Object object) {
        boolean bl2;
        Object object2;
        boolean bl3 = object instanceof Map.Entry;
        boolean bl4 = false;
        if (bl3 && (object2 = (object = (Map.Entry)object).getKey()) != null && (bl3 = (object2 = object.getValue()) instanceof Map) && (bl2 = (object2 = this.this$1.this$0.backingMap.entrySet()).remove(object))) {
            bl4 = true;
        }
        return bl4;
    }

    public int size() {
        return this.this$1.this$0.backingMap.size();
    }
}


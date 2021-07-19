/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractTable;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Table$Cell;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class AbstractTable$CellSet
extends AbstractSet {
    public final /* synthetic */ AbstractTable this$0;

    public AbstractTable$CellSet(AbstractTable abstractTable) {
        this.this$0 = abstractTable;
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Object object) {
        boolean bl2 = object instanceof Table$Cell;
        boolean bl3 = false;
        if (bl2) {
            object = (Table$Cell)object;
            Object object2 = this.this$0.rowMap();
            Object object3 = object.getRowKey();
            if ((object2 = (Map)Maps.safeGet((Map)object2, object3)) != null) {
                object2 = object2.entrySet();
                object3 = object.getColumnKey();
                object = object.getValue();
                boolean bl4 = Collections2.safeContains((Collection)object2, object = Maps.immutableEntry(object3, object));
                if (bl4) {
                    bl3 = true;
                }
            }
        }
        return bl3;
    }

    public Iterator iterator() {
        return this.this$0.cellIterator();
    }

    public boolean remove(Object object) {
        boolean bl2 = object instanceof Table$Cell;
        boolean bl3 = false;
        if (bl2) {
            object = (Table$Cell)object;
            Object object2 = this.this$0.rowMap();
            Object object3 = object.getRowKey();
            if ((object2 = (Map)Maps.safeGet((Map)object2, object3)) != null) {
                object2 = object2.entrySet();
                object3 = object.getColumnKey();
                object = object.getValue();
                boolean bl4 = Collections2.safeRemove((Collection)object2, object = Maps.immutableEntry(object3, object));
                if (bl4) {
                    bl3 = true;
                }
            }
        }
        return bl3;
    }

    public int size() {
        return this.this$0.size();
    }
}


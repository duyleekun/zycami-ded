/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Table$Cell;

public abstract class Tables$AbstractCell
implements Table$Cell {
    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof Table$Cell;
        if (bl3) {
            boolean bl4;
            Object object2;
            object = (Table$Cell)object;
            Object object3 = this.getRowKey();
            bl3 = Objects.equal(object3, object2 = object.getRowKey());
            if (!(bl3 && (bl3 = Objects.equal(object3 = this.getColumnKey(), object2 = object.getColumnKey())) && (bl4 = Objects.equal(object3 = this.getValue(), object = object.getValue())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object object = this.getRowKey();
        Object[] objectArray = new Object[]{object, object = this.getColumnKey(), object = this.getValue()};
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        Object object = this.getRowKey();
        stringBuilder.append(object);
        stringBuilder.append(",");
        object = this.getColumnKey();
        stringBuilder.append(object);
        stringBuilder.append(")=");
        object = this.getValue();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}


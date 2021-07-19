/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Tables$AbstractCell;
import java.io.Serializable;

public final class Tables$ImmutableCell
extends Tables$AbstractCell
implements Serializable {
    private static final long serialVersionUID;
    private final Object columnKey;
    private final Object rowKey;
    private final Object value;

    public Tables$ImmutableCell(Object object, Object object2, Object object3) {
        this.rowKey = object;
        this.columnKey = object2;
        this.value = object3;
    }

    public Object getColumnKey() {
        return this.columnKey;
    }

    public Object getRowKey() {
        return this.rowKey;
    }

    public Object getValue() {
        return this.value;
    }
}


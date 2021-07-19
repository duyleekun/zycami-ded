/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;

public final class Tables$TransposeTable$1
implements Function {
    public Table$Cell apply(Table$Cell object) {
        Object object2 = object.getColumnKey();
        Object object3 = object.getRowKey();
        object = object.getValue();
        return Tables.immutableCell(object2, object3, object);
    }
}


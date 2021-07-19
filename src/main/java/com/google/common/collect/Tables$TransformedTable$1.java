/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import com.google.common.collect.Tables$TransformedTable;

public class Tables$TransformedTable$1
implements Function {
    public final /* synthetic */ Tables$TransformedTable this$0;

    public Tables$TransformedTable$1(Tables$TransformedTable tables$TransformedTable) {
        this.this$0 = tables$TransformedTable;
    }

    public Table$Cell apply(Table$Cell object) {
        Object object2 = object.getRowKey();
        Object object3 = object.getColumnKey();
        Function function = this.this$0.function;
        object = object.getValue();
        object = function.apply(object);
        return Tables.immutableCell(object2, object3, object);
    }
}


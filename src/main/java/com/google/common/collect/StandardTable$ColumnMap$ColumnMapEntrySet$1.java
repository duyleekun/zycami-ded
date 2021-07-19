/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet;
import java.util.Map;

public class StandardTable$ColumnMap$ColumnMapEntrySet$1
implements Function {
    public final /* synthetic */ StandardTable$ColumnMap$ColumnMapEntrySet this$2;

    public StandardTable$ColumnMap$ColumnMapEntrySet$1(StandardTable$ColumnMap$ColumnMapEntrySet columnMapEntrySet) {
        this.this$2 = columnMapEntrySet;
    }

    public Map apply(Object object) {
        return this.this$2.this$1.this$0.column(object);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.StandardTable$RowMap$EntrySet;
import java.util.Map;

public class StandardTable$RowMap$EntrySet$1
implements Function {
    public final /* synthetic */ StandardTable$RowMap$EntrySet this$2;

    public StandardTable$RowMap$EntrySet$1(StandardTable$RowMap$EntrySet entrySet) {
        this.this$2 = entrySet;
    }

    public Map apply(Object object) {
        return this.this$2.this$1.this$0.row(object);
    }
}


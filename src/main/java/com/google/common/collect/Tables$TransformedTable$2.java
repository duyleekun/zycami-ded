/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Tables$TransformedTable;
import java.util.Map;

public class Tables$TransformedTable$2
implements Function {
    public final /* synthetic */ Tables$TransformedTable this$0;

    public Tables$TransformedTable$2(Tables$TransformedTable tables$TransformedTable) {
        this.this$0 = tables$TransformedTable;
    }

    public Map apply(Map map) {
        Function function = this.this$0.function;
        return Maps.transformValues(map, function);
    }
}


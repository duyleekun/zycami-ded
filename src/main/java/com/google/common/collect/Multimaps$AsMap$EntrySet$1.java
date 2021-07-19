/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multimaps$AsMap$EntrySet;
import java.util.Collection;

public class Multimaps$AsMap$EntrySet$1
implements Function {
    public final /* synthetic */ Multimaps$AsMap$EntrySet this$1;

    public Multimaps$AsMap$EntrySet$1(Multimaps$AsMap$EntrySet entrySet) {
        this.this$1 = entrySet;
    }

    public Collection apply(Object object) {
        return Multimaps$AsMap.access$200(this.this$1.this$0).get(object);
    }
}


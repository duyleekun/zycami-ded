/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.BaseGraph;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graph;
import com.google.common.graph.Graphs$TransposedGraph$1;

public class Graphs$TransposedGraph$1$1
implements Function {
    public final /* synthetic */ Graphs$TransposedGraph$1 this$1;

    public Graphs$TransposedGraph$1$1(Graphs$TransposedGraph$1 var1_1) {
        this.this$1 = var1_1;
    }

    public EndpointPair apply(EndpointPair object) {
        BaseGraph baseGraph = this.this$1.this$0.delegate();
        Object object2 = ((EndpointPair)object).nodeV();
        object = ((EndpointPair)object).nodeU();
        return EndpointPair.of((Graph)baseGraph, object2, object);
    }
}


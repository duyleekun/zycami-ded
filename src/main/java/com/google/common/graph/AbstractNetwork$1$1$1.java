/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.AbstractNetwork$1$1;
import com.google.common.graph.EndpointPair;

public class AbstractNetwork$1$1$1
implements Function {
    public final /* synthetic */ AbstractNetwork$1$1 this$2;

    public AbstractNetwork$1$1$1(AbstractNetwork$1$1 abstractNetwork$1$1) {
        this.this$2 = abstractNetwork$1$1;
    }

    public EndpointPair apply(Object object) {
        return this.this$2.this$1.this$0.incidentNodes(object);
    }
}


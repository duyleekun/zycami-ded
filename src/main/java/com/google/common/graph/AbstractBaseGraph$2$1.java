/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.AbstractBaseGraph$2;
import com.google.common.graph.EndpointPair;

public class AbstractBaseGraph$2$1
implements Function {
    public final /* synthetic */ AbstractBaseGraph$2 this$1;

    public AbstractBaseGraph$2$1(AbstractBaseGraph$2 var1_1) {
        this.this$1 = var1_1;
    }

    public EndpointPair apply(Object object) {
        Object object2 = this.this$1.node;
        return EndpointPair.ordered(object, object2);
    }
}


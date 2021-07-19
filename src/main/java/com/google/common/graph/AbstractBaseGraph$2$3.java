/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.AbstractBaseGraph$2;
import com.google.common.graph.EndpointPair;

public class AbstractBaseGraph$2$3
implements Function {
    public final /* synthetic */ AbstractBaseGraph$2 this$1;

    public AbstractBaseGraph$2$3(AbstractBaseGraph$2 abstractBaseGraph$2) {
        this.this$1 = abstractBaseGraph$2;
    }

    public EndpointPair apply(Object object) {
        return EndpointPair.unordered(this.this$1.node, object);
    }
}


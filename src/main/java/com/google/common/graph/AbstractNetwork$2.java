/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Predicate;
import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.EndpointPair;

public class AbstractNetwork$2
implements Predicate {
    public final /* synthetic */ AbstractNetwork this$0;
    public final /* synthetic */ Object val$nodePresent;
    public final /* synthetic */ Object val$nodeToCheck;

    public AbstractNetwork$2(AbstractNetwork abstractNetwork, Object object, Object object2) {
        this.this$0 = abstractNetwork;
        this.val$nodePresent = object;
        this.val$nodeToCheck = object2;
    }

    public boolean apply(Object object) {
        object = this.this$0.incidentNodes(object);
        Object object2 = this.val$nodePresent;
        object = ((EndpointPair)object).adjacentNode(object2);
        object2 = this.val$nodeToCheck;
        return object.equals(object2);
    }
}


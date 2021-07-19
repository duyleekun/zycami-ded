/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.Iterators;
import com.google.common.graph.AbstractBaseGraph;
import com.google.common.graph.AbstractNetwork$1;
import com.google.common.graph.AbstractNetwork$1$1$1;
import com.google.common.graph.EndpointPair;
import java.util.AbstractSet;
import java.util.Iterator;

public class AbstractNetwork$1$1
extends AbstractSet {
    public final /* synthetic */ AbstractNetwork$1 this$1;

    public AbstractNetwork$1$1(AbstractNetwork$1 var1_1) {
        this.this$1 = var1_1;
    }

    public boolean contains(Object object) {
        Object object2;
        boolean bl2 = object instanceof EndpointPair;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        Object object3 = this.this$1;
        bl2 = ((AbstractBaseGraph)object3).isOrderingCompatible((EndpointPair)(object = (EndpointPair)object));
        if (bl2 && (bl2 = (object3 = this.this$1.nodes()).contains(object2 = ((EndpointPair)object).nodeU()))) {
            object3 = this.this$1;
            object2 = ((EndpointPair)object).nodeU();
            boolean bl4 = (object3 = ((AbstractNetwork$1)object3).successors(object2)).contains(object = ((EndpointPair)object).nodeV());
            if (bl4) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.this$1.this$0.edges().iterator();
        AbstractNetwork$1$1$1 abstractNetwork$1$1$1 = new AbstractNetwork$1$1$1(this);
        return Iterators.transform(iterator2, abstractNetwork$1$1$1);
    }

    public int size() {
        return this.this$1.this$0.edges().size();
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.AbstractBaseGraph;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.EndpointPairIterator;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;

public class AbstractBaseGraph$1
extends AbstractSet {
    public final /* synthetic */ AbstractBaseGraph this$0;

    public AbstractBaseGraph$1(AbstractBaseGraph abstractBaseGraph) {
        this.this$0 = abstractBaseGraph;
    }

    public boolean contains(Object object) {
        Object object2;
        boolean bl2 = object instanceof EndpointPair;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        Object object3 = this.this$0;
        bl2 = ((AbstractBaseGraph)object3).isOrderingCompatible((EndpointPair)(object = (EndpointPair)object));
        if (bl2 && (bl2 = (object3 = this.this$0.nodes()).contains(object2 = ((EndpointPair)object).nodeU()))) {
            object3 = this.this$0;
            object2 = ((EndpointPair)object).nodeU();
            boolean bl4 = (object3 = object3.successors(object2)).contains(object = ((EndpointPair)object).nodeV());
            if (bl4) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public UnmodifiableIterator iterator() {
        return EndpointPairIterator.of(this.this$0);
    }

    public boolean remove(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public int size() {
        return Ints.saturatedCast(this.this$0.edgeCount());
    }
}


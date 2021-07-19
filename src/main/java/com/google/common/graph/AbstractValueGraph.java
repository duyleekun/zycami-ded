/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.graph.AbstractBaseGraph;
import com.google.common.graph.AbstractValueGraph$1;
import com.google.common.graph.AbstractValueGraph$2;
import com.google.common.graph.Graph;
import com.google.common.graph.ValueGraph;
import java.util.Map;
import java.util.Set;

public abstract class AbstractValueGraph
extends AbstractBaseGraph
implements ValueGraph {
    private static Map edgeValueMap(ValueGraph valueGraph) {
        AbstractValueGraph$2 abstractValueGraph$2 = new AbstractValueGraph$2(valueGraph);
        return Maps.asMap(valueGraph.edges(), (Function)abstractValueGraph$2);
    }

    public Graph asGraph() {
        AbstractValueGraph$1 abstractValueGraph$1 = new AbstractValueGraph$1(this);
        return abstractValueGraph$1;
    }

    public final boolean equals(Object object) {
        boolean bl2;
        Set set;
        Object object2;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof ValueGraph;
        if (!bl5) {
            return false;
        }
        object = (ValueGraph)object;
        bl5 = this.isDirected();
        if (bl5 != (bl3 = object.isDirected()) || !(bl5 = (object2 = this.nodes()).equals(set = object.nodes())) || !(bl2 = (object2 = AbstractValueGraph.edgeValueMap(this)).equals(object = AbstractValueGraph.edgeValueMap((ValueGraph)object)))) {
            bl4 = false;
        }
        return bl4;
    }

    public final int hashCode() {
        return AbstractValueGraph.edgeValueMap(this).hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isDirected: ");
        boolean bl2 = this.isDirected();
        stringBuilder.append(bl2);
        stringBuilder.append(", allowsSelfLoops: ");
        bl2 = this.allowsSelfLoops();
        stringBuilder.append(bl2);
        stringBuilder.append(", nodes: ");
        Object object = this.nodes();
        stringBuilder.append(object);
        stringBuilder.append(", edges: ");
        object = AbstractValueGraph.edgeValueMap(this);
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}


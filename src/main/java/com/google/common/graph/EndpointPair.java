/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.EndpointPair$1;
import com.google.common.graph.EndpointPair$Ordered;
import com.google.common.graph.EndpointPair$Unordered;
import com.google.common.graph.Graph;
import com.google.common.graph.Network;

public abstract class EndpointPair
implements Iterable {
    private final Object nodeU;
    private final Object nodeV;

    private EndpointPair(Object object, Object object2) {
        this.nodeU = object = Preconditions.checkNotNull(object);
        this.nodeV = object = Preconditions.checkNotNull(object2);
    }

    public /* synthetic */ EndpointPair(Object object, Object object2, EndpointPair$1 endpointPair$1) {
        this(object, object2);
    }

    public static EndpointPair of(Graph object, Object object2, Object object3) {
        boolean bl2 = object.isDirected();
        object = bl2 ? EndpointPair.ordered(object2, object3) : EndpointPair.unordered(object2, object3);
        return object;
    }

    public static EndpointPair of(Network object, Object object2, Object object3) {
        boolean bl2 = object.isDirected();
        object = bl2 ? EndpointPair.ordered(object2, object3) : EndpointPair.unordered(object2, object3);
        return object;
    }

    public static EndpointPair ordered(Object object, Object object2) {
        EndpointPair$Ordered endpointPair$Ordered = new EndpointPair$Ordered(object, object2, null);
        return endpointPair$Ordered;
    }

    public static EndpointPair unordered(Object object, Object object2) {
        EndpointPair$Unordered endpointPair$Unordered = new EndpointPair$Unordered(object2, object, null);
        return endpointPair$Unordered;
    }

    public final Object adjacentNode(Object object) {
        Object object2 = this.nodeU;
        boolean bl2 = object.equals(object2);
        if (bl2) {
            return this.nodeV;
        }
        object2 = this.nodeV;
        bl2 = object.equals(object2);
        if (bl2) {
            return this.nodeU;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EndpointPair ");
        stringBuilder.append(this);
        stringBuilder.append(" does not contain node ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public abstract boolean equals(Object var1);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public final UnmodifiableIterator iterator() {
        Object object = this.nodeU;
        object = this.nodeV;
        Object[] objectArray = new Object[]{object, object};
        return Iterators.forArray(objectArray);
    }

    public final Object nodeU() {
        return this.nodeU;
    }

    public final Object nodeV() {
        return this.nodeV;
    }

    public abstract Object source();

    public abstract Object target();
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.EndpointPair$1;

public final class EndpointPair$Unordered
extends EndpointPair {
    private EndpointPair$Unordered(Object object, Object object2) {
        super(object, object2, null);
    }

    public /* synthetic */ EndpointPair$Unordered(Object object, Object object2, EndpointPair$1 endpointPair$1) {
        this(object, object2);
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof EndpointPair;
        if (!bl5) {
            return false;
        }
        object = (EndpointPair)object;
        bl5 = this.isOrdered();
        if (bl5 != (bl3 = ((EndpointPair)object).isOrdered())) {
            return false;
        }
        Object object3 = this.nodeU();
        bl5 = object3.equals(object2 = ((EndpointPair)object).nodeU());
        if (bl5) {
            Object object4 = this.nodeV();
            object = ((EndpointPair)object).nodeV();
            return object4.equals(object);
        }
        object3 = this.nodeU();
        bl5 = object3.equals(object2 = ((EndpointPair)object).nodeV());
        if (!bl5 || !(bl2 = (object3 = this.nodeV()).equals(object = ((EndpointPair)object).nodeU()))) {
            bl4 = false;
            Object var7_8 = null;
        }
        return bl4;
    }

    public int hashCode() {
        int n10 = this.nodeU().hashCode();
        int n11 = this.nodeV().hashCode();
        return n10 + n11;
    }

    public boolean isOrdered() {
        return false;
    }

    public Object source() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        throw unsupportedOperationException;
    }

    public Object target() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        throw unsupportedOperationException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Object object = this.nodeU();
        stringBuilder.append(object);
        stringBuilder.append(", ");
        object = this.nodeV();
        stringBuilder.append(object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}


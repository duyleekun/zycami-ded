/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.EndpointPair$1;

public final class EndpointPair$Ordered
extends EndpointPair {
    private EndpointPair$Ordered(Object object, Object object2) {
        super(object, object2, null);
    }

    public /* synthetic */ EndpointPair$Ordered(Object object, Object object2, EndpointPair$1 endpointPair$1) {
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
        Object object3 = this.source();
        bl5 = object3.equals(object2 = ((EndpointPair)object).source());
        if (!bl5 || !(bl2 = (object3 = this.target()).equals(object = ((EndpointPair)object).target()))) {
            bl4 = false;
        }
        return bl4;
    }

    public int hashCode() {
        Object object = this.source();
        Object[] objectArray = new Object[]{object, object = this.target()};
        return Objects.hashCode(objectArray);
    }

    public boolean isOrdered() {
        return true;
    }

    public Object source() {
        return this.nodeU();
    }

    public Object target() {
        return this.nodeV();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        Object object = this.source();
        stringBuilder.append(object);
        stringBuilder.append(" -> ");
        object = this.target();
        stringBuilder.append(object);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}


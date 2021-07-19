/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.AbstractBaseGraph;
import com.google.common.graph.Graph;
import java.util.Set;

public abstract class AbstractGraph
extends AbstractBaseGraph
implements Graph {
    public final boolean equals(Object object) {
        boolean bl2;
        Set set;
        Set set2;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Graph;
        if (!bl5) {
            return false;
        }
        object = (Graph)object;
        bl5 = this.isDirected();
        if (bl5 != (bl3 = object.isDirected()) || !(bl5 = (set2 = this.nodes()).equals(set = object.nodes())) || !(bl2 = (set2 = this.edges()).equals(object = object.edges()))) {
            bl4 = false;
        }
        return bl4;
    }

    public final int hashCode() {
        return this.edges().hashCode();
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
        Set set = this.nodes();
        stringBuilder.append(set);
        stringBuilder.append(", edges: ");
        set = this.edges();
        stringBuilder.append(set);
        return stringBuilder.toString();
    }
}


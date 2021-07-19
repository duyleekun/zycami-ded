/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.graph.BaseGraph;
import com.google.common.graph.Graphs$TransposedGraph;
import com.google.common.graph.Graphs$TransposedGraph$1$1;
import com.google.common.graph.IncidentEdgeSet;
import java.util.Iterator;

public class Graphs$TransposedGraph$1
extends IncidentEdgeSet {
    public final /* synthetic */ Graphs$TransposedGraph this$0;

    public Graphs$TransposedGraph$1(Graphs$TransposedGraph graphs$TransposedGraph, BaseGraph baseGraph, Object object) {
        this.this$0 = graphs$TransposedGraph;
        super(baseGraph, object);
    }

    public Iterator iterator() {
        Object object = this.this$0.delegate();
        Object object2 = this.node;
        object = object.incidentEdges(object2).iterator();
        object2 = new Graphs$TransposedGraph$1$1(this);
        return Iterators.transform((Iterator)object, (Function)object2);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.BaseGraph;
import com.google.common.graph.ConfigurableValueGraph;
import com.google.common.graph.GraphConnections;
import com.google.common.graph.IncidentEdgeSet;
import java.util.Iterator;

public class ConfigurableValueGraph$1
extends IncidentEdgeSet {
    public final /* synthetic */ ConfigurableValueGraph this$0;
    public final /* synthetic */ GraphConnections val$connections;

    public ConfigurableValueGraph$1(ConfigurableValueGraph configurableValueGraph, BaseGraph baseGraph, Object object, GraphConnections graphConnections) {
        this.this$0 = configurableValueGraph;
        this.val$connections = graphConnections;
        super(baseGraph, object);
    }

    public Iterator iterator() {
        GraphConnections graphConnections = this.val$connections;
        Object object = this.node;
        return graphConnections.incidentEdgeIterator(object);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.AbstractBaseGraph;
import com.google.common.graph.AbstractBaseGraph$2$1;
import com.google.common.graph.AbstractBaseGraph$2$2;
import com.google.common.graph.AbstractBaseGraph$2$3;
import com.google.common.graph.BaseGraph;
import com.google.common.graph.IncidentEdgeSet;
import java.util.Iterator;
import java.util.Set;

public class AbstractBaseGraph$2
extends IncidentEdgeSet {
    public final /* synthetic */ AbstractBaseGraph this$0;

    public AbstractBaseGraph$2(AbstractBaseGraph abstractBaseGraph, BaseGraph baseGraph, Object object) {
        this.this$0 = abstractBaseGraph;
        super(baseGraph, object);
    }

    public UnmodifiableIterator iterator() {
        Object object = this.graph;
        boolean bl2 = object.isDirected();
        if (bl2) {
            object = this.graph;
            Object object2 = this.node;
            object = object.predecessors(object2).iterator();
            object2 = new AbstractBaseGraph$2$1(this);
            object = Iterators.transform(object, (Function)object2);
            object2 = this.graph;
            Object object3 = this.node;
            object2 = object2.successors(object3);
            object3 = ImmutableSet.of(this.node);
            object2 = Sets.difference((Set)object2, (Set)object3).iterator();
            object3 = new AbstractBaseGraph$2$2(this);
            object2 = Iterators.transform((Iterator)object2, (Function)object3);
            return Iterators.unmodifiableIterator(Iterators.concat((Iterator)object, (Iterator)object2));
        }
        object = this.graph;
        Object object4 = this.node;
        object = object.adjacentNodes(object4).iterator();
        object4 = new AbstractBaseGraph$2$3(this);
        return Iterators.unmodifiableIterator(Iterators.transform(object, (Function)object4));
    }
}


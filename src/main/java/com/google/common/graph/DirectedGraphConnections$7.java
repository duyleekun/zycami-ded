/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.EndpointPair;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class DirectedGraphConnections$7
extends AbstractIterator {
    public final /* synthetic */ DirectedGraphConnections this$0;
    public final /* synthetic */ AtomicBoolean val$alreadySeenSelfLoop;
    public final /* synthetic */ Iterator val$resultWithDoubleSelfLoop;

    public DirectedGraphConnections$7(DirectedGraphConnections directedGraphConnections, Iterator iterator2, AtomicBoolean atomicBoolean) {
        this.this$0 = directedGraphConnections;
        this.val$resultWithDoubleSelfLoop = iterator2;
        this.val$alreadySeenSelfLoop = atomicBoolean;
    }

    public EndpointPair computeNext() {
        Object object;
        boolean bl2;
        while (bl2 = (object = this.val$resultWithDoubleSelfLoop).hasNext()) {
            boolean bl3;
            Object object2;
            object = (EndpointPair)this.val$resultWithDoubleSelfLoop.next();
            Object object3 = ((EndpointPair)object).nodeU();
            boolean bl4 = object3.equals(object2 = ((EndpointPair)object).nodeV());
            if (bl4 && (bl4 = ((AtomicBoolean)(object3 = this.val$alreadySeenSelfLoop)).getAndSet(bl3 = true))) continue;
            return object;
        }
        return (EndpointPair)this.endOfData();
    }
}


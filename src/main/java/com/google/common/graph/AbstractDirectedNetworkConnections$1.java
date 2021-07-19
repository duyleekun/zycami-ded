/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.AbstractDirectedNetworkConnections;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;

public class AbstractDirectedNetworkConnections$1
extends AbstractSet {
    public final /* synthetic */ AbstractDirectedNetworkConnections this$0;

    public AbstractDirectedNetworkConnections$1(AbstractDirectedNetworkConnections abstractDirectedNetworkConnections) {
        this.this$0 = abstractDirectedNetworkConnections;
    }

    public boolean contains(Object object) {
        boolean bl2;
        Map map = this.this$0.inEdgeMap;
        boolean bl3 = map.containsKey(object);
        if (!bl3 && !(bl2 = (map = this.this$0.outEdgeMap).containsKey(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public UnmodifiableIterator iterator() {
        Object object = this.this$0;
        int n10 = AbstractDirectedNetworkConnections.access$000((AbstractDirectedNetworkConnections)object);
        if (n10 == 0) {
            object = this.this$0.inEdgeMap.keySet();
            Set set = this.this$0.outEdgeMap.keySet();
            object = Iterables.concat(object, set);
        } else {
            object = this.this$0.inEdgeMap.keySet();
            Set set = this.this$0.outEdgeMap.keySet();
            object = Sets.union(object, set);
        }
        return Iterators.unmodifiableIterator(object.iterator());
    }

    public int size() {
        int n10 = this.this$0.inEdgeMap.size();
        int n11 = this.this$0.outEdgeMap.size();
        int n12 = AbstractDirectedNetworkConnections.access$000(this.this$0);
        return IntMath.saturatedAdd(n10, n11 -= n12);
    }
}


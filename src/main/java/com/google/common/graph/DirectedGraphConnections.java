/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.Iterators;
import com.google.common.graph.DirectedGraphConnections$1;
import com.google.common.graph.DirectedGraphConnections$2;
import com.google.common.graph.DirectedGraphConnections$3;
import com.google.common.graph.DirectedGraphConnections$4;
import com.google.common.graph.DirectedGraphConnections$5;
import com.google.common.graph.DirectedGraphConnections$6;
import com.google.common.graph.DirectedGraphConnections$7;
import com.google.common.graph.DirectedGraphConnections$8;
import com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred;
import com.google.common.graph.DirectedGraphConnections$NodeConnection$Succ;
import com.google.common.graph.DirectedGraphConnections$PredAndSucc;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.ElementOrder$Type;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.GraphConnections;
import com.google.common.graph.Graphs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class DirectedGraphConnections
implements GraphConnections {
    private static final Object PRED;
    private final Map adjacentNodeValues;
    private final List orderedNodeConnections;
    private int predecessorCount;
    private int successorCount;

    static {
        Object object;
        PRED = object = new Object();
    }

    private DirectedGraphConnections(Map map, List list, int n10, int n11) {
        int n12;
        int n13;
        Map map2;
        this.adjacentNodeValues = map2 = (Map)Preconditions.checkNotNull(map);
        this.orderedNodeConnections = list;
        this.predecessorCount = n13 = Graphs.checkNonNegative(n10);
        this.successorCount = n13 = Graphs.checkNonNegative(n11);
        n13 = map.size();
        if (n10 <= n13 && n11 <= (n12 = map.size())) {
            n12 = 1;
        } else {
            n12 = 0;
            map = null;
        }
        Preconditions.checkState(n12 != 0);
    }

    public static /* synthetic */ List access$000(DirectedGraphConnections directedGraphConnections) {
        return directedGraphConnections.orderedNodeConnections;
    }

    public static /* synthetic */ Map access$100(DirectedGraphConnections directedGraphConnections) {
        return directedGraphConnections.adjacentNodeValues;
    }

    public static /* synthetic */ boolean access$200(Object object) {
        return DirectedGraphConnections.isPredecessor(object);
    }

    public static /* synthetic */ int access$300(DirectedGraphConnections directedGraphConnections) {
        return directedGraphConnections.predecessorCount;
    }

    public static /* synthetic */ boolean access$400(Object object) {
        return DirectedGraphConnections.isSuccessor(object);
    }

    public static /* synthetic */ int access$500(DirectedGraphConnections directedGraphConnections) {
        return directedGraphConnections.successorCount;
    }

    private static boolean isPredecessor(Object object) {
        boolean bl2;
        Object object2 = PRED;
        if (object != object2 && !(bl2 = object instanceof DirectedGraphConnections$PredAndSucc)) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static boolean isSuccessor(Object object) {
        boolean bl2;
        Object object2 = PRED;
        if (object != object2 && object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static DirectedGraphConnections of(ElementOrder object) {
        void var0_4;
        int[] nArray = DirectedGraphConnections$8.$SwitchMap$com$google$common$graph$ElementOrder$Type;
        ElementOrder$Type elementOrder$Type = ((ElementOrder)object).type();
        int n10 = elementOrder$Type.ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                ElementOrder$Type elementOrder$Type2 = ((ElementOrder)object).type();
                AssertionError assertionError = new AssertionError((Object)elementOrder$Type2);
                throw assertionError;
            }
            ArrayList arrayList = new ArrayList();
        } else {
            Object var0_3 = null;
        }
        HashMap hashMap = new HashMap(4, 1.0f);
        return new DirectedGraphConnections(hashMap, (List)var0_4, 0, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static DirectedGraphConnections ofImmutable(Object object, Iterable object2, Function function) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        object2 = object2.iterator();
        int n10 = 0;
        int n11 = 0;
        while (true) {
            boolean bl2;
            if (!(bl2 = object2.hasNext())) {
                object2 = immutableList$Builder.build();
                return new DirectedGraphConnections(hashMap, (List)object2, n10, n11);
            }
            Object object3 = (EndpointPair)object2.next();
            Object object4 = ((EndpointPair)object3).nodeU();
            boolean bl3 = object4.equals(object);
            if (bl3 && (bl3 = (object4 = ((EndpointPair)object3).nodeV()).equals(object))) {
                object4 = function.apply(object);
                object3 = new DirectedGraphConnections$PredAndSucc(object4);
                hashMap.put(object, object3);
                object3 = new DirectedGraphConnections$NodeConnection$Pred(object);
                immutableList$Builder.add(object3);
                object3 = new DirectedGraphConnections$NodeConnection$Succ(object);
                immutableList$Builder.add(object3);
                ++n10;
            } else {
                Object object5;
                object4 = ((EndpointPair)object3).nodeV();
                bl3 = object4.equals(object);
                if (bl3) {
                    object3 = ((EndpointPair)object3).nodeU();
                    object4 = PRED;
                    if ((object4 = hashMap.put(object3, object4)) != null) {
                        object5 = new DirectedGraphConnections$PredAndSucc(object4);
                        hashMap.put(object3, object5);
                    }
                    object4 = new DirectedGraphConnections$NodeConnection$Pred(object3);
                    immutableList$Builder.add(object4);
                    ++n10;
                    continue;
                }
                bl3 = ((EndpointPair)object3).nodeU().equals(object);
                Preconditions.checkArgument(bl3);
                object3 = ((EndpointPair)object3).nodeV();
                object4 = function.apply(object3);
                object5 = hashMap.put(object3, object4);
                if (object5 != null) {
                    boolean bl4;
                    Object object6 = PRED;
                    if (object5 == object6) {
                        bl4 = true;
                    } else {
                        bl4 = false;
                        object5 = null;
                    }
                    Preconditions.checkArgument(bl4);
                    object5 = new DirectedGraphConnections$PredAndSucc(object4);
                    hashMap.put(object3, object5);
                }
                object4 = new DirectedGraphConnections$NodeConnection$Succ(object3);
                immutableList$Builder.add(object4);
            }
            ++n11;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void addPredecessor(Object object, Object object2) {
        int n10;
        int n11;
        Object object3;
        block7: {
            block5: {
                DirectedGraphConnections$PredAndSucc directedGraphConnections$PredAndSucc;
                block6: {
                    object2 = this.adjacentNodeValues;
                    object3 = PRED;
                    object2 = object2.put(object, object3);
                    n11 = 0;
                    directedGraphConnections$PredAndSucc = null;
                    n10 = 1;
                    if (object2 == null) break block5;
                    boolean bl2 = object2 instanceof DirectedGraphConnections$PredAndSucc;
                    if (!bl2) break block6;
                    object3 = this.adjacentNodeValues;
                    object3.put(object, object2);
                    break block7;
                }
                if (object2 == object3) break block7;
                object3 = this.adjacentNodeValues;
                directedGraphConnections$PredAndSucc = new DirectedGraphConnections$PredAndSucc(object2);
                object3.put(object, directedGraphConnections$PredAndSucc);
            }
            n11 = n10;
        }
        if (n11 != 0) {
            int n12;
            this.predecessorCount = n12 = this.predecessorCount + n10;
            Graphs.checkPositive(n12);
            object2 = this.orderedNodeConnections;
            if (object2 != null) {
                object3 = new DirectedGraphConnections$NodeConnection$Pred(object);
                object2.add(object3);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public Object addSuccessor(Object object, Object object2) {
        Object object3;
        Object object4;
        block7: {
            block5: {
                block6: {
                    object4 = this.adjacentNodeValues.put(object, object2);
                    object3 = null;
                    if (object4 == null) break block5;
                    boolean bl2 = object4 instanceof DirectedGraphConnections$PredAndSucc;
                    if (!bl2) break block6;
                    object3 = this.adjacentNodeValues;
                    DirectedGraphConnections$PredAndSucc directedGraphConnections$PredAndSucc = new DirectedGraphConnections$PredAndSucc(object2);
                    object3.put(object, directedGraphConnections$PredAndSucc);
                    object4 = DirectedGraphConnections$PredAndSucc.access$600((DirectedGraphConnections$PredAndSucc)object4);
                    break block7;
                }
                Object object5 = PRED;
                if (object4 != object5) break block7;
                object4 = this.adjacentNodeValues;
                object5 = new DirectedGraphConnections$PredAndSucc(object2);
                object4.put(object, object5);
            }
            object4 = null;
        }
        if (object4 == null) {
            int n10;
            this.successorCount = n10 = this.successorCount + 1;
            Graphs.checkPositive(n10);
            object2 = this.orderedNodeConnections;
            if (object2 != null) {
                object3 = new DirectedGraphConnections$NodeConnection$Succ(object);
                object2.add(object3);
            }
        }
        return object4;
    }

    public Set adjacentNodes() {
        Collection collection = this.orderedNodeConnections;
        if (collection == null) {
            return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
        }
        collection = new DirectedGraphConnections$1(this);
        return collection;
    }

    public Iterator incidentEdgeIterator(Object object) {
        Object object2;
        Object object3 = this.orderedNodeConnections;
        if (object3 == null) {
            object3 = this.predecessors().iterator();
            object2 = new DirectedGraphConnections$4(this, object);
            object3 = Iterators.transform(object3, (Function)object2);
            object2 = this.successors().iterator();
            DirectedGraphConnections$5 directedGraphConnections$5 = new DirectedGraphConnections$5(this, object);
            object = Iterators.transform((Iterator)object2, directedGraphConnections$5);
            object = Iterators.concat((Iterator)object3, (Iterator)object);
        } else {
            object3 = object3.iterator();
            object2 = new DirectedGraphConnections$6(this, object);
            object = Iterators.transform(object3, (Function)object2);
        }
        object3 = new AtomicBoolean(false);
        object2 = new DirectedGraphConnections$7(this, (Iterator)object, (AtomicBoolean)object3);
        return object2;
    }

    public Set predecessors() {
        DirectedGraphConnections$2 directedGraphConnections$2 = new DirectedGraphConnections$2(this);
        return directedGraphConnections$2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void removePredecessor(Object object) {
        Object object2 = this.adjacentNodeValues.get(object);
        Object object3 = PRED;
        int n10 = 1;
        if (object2 == object3) {
            object2 = this.adjacentNodeValues;
            object2.remove(object);
        } else {
            boolean bl2 = object2 instanceof DirectedGraphConnections$PredAndSucc;
            if (!bl2) return;
            object3 = this.adjacentNodeValues;
            object2 = DirectedGraphConnections$PredAndSucc.access$600((DirectedGraphConnections$PredAndSucc)object2);
            object3.put(object, object2);
        }
        int n11 = n10;
        if (n11 == 0) return;
        this.predecessorCount = n11 = this.predecessorCount - n10;
        Graphs.checkNonNegative(n11);
        object2 = this.orderedNodeConnections;
        if (object2 == null) return;
        object3 = new DirectedGraphConnections$NodeConnection$Pred(object);
        object2.remove(object3);
    }

    public Object removeSuccessor(Object object) {
        Object object2;
        Object object3;
        Object object4 = this.adjacentNodeValues.get(object);
        if (object4 != null && object4 != (object3 = PRED)) {
            boolean bl2 = object4 instanceof DirectedGraphConnections$PredAndSucc;
            if (bl2) {
                object2 = this.adjacentNodeValues;
                object2.put(object, object3);
                object4 = DirectedGraphConnections$PredAndSucc.access$600((DirectedGraphConnections$PredAndSucc)object4);
            } else {
                object3 = this.adjacentNodeValues;
                object3.remove(object);
            }
        } else {
            object4 = null;
        }
        if (object4 != null) {
            int n10;
            this.successorCount = n10 = this.successorCount + -1;
            Graphs.checkNonNegative(n10);
            object3 = this.orderedNodeConnections;
            if (object3 != null) {
                object2 = new DirectedGraphConnections$NodeConnection$Succ(object);
                object3.remove(object2);
            }
        }
        return object4;
    }

    public Set successors() {
        DirectedGraphConnections$3 directedGraphConnections$3 = new DirectedGraphConnections$3(this);
        return directedGraphConnections$3;
    }

    public Object value(Object object) {
        Object object2;
        if ((object = this.adjacentNodeValues.get(object)) == (object2 = PRED)) {
            return null;
        }
        boolean bl2 = object instanceof DirectedGraphConnections$PredAndSucc;
        if (bl2) {
            object = DirectedGraphConnections$PredAndSucc.access$600((DirectedGraphConnections$PredAndSucc)object);
        }
        return object;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$Pool;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class DirectedAcyclicGraph {
    private final SimpleArrayMap mGraph;
    private final Pools$Pool mListPool;
    private final ArrayList mSortResult;
    private final HashSet mSortTmpMarked;

    public DirectedAcyclicGraph() {
        AbstractCollection abstractCollection = new AbstractCollection(10);
        this.mListPool = abstractCollection;
        abstractCollection = new AbstractCollection();
        this.mGraph = abstractCollection;
        this.mSortResult = abstractCollection = new AbstractCollection();
        this.mSortTmpMarked = abstractCollection;
    }

    private void dfs(Object object, ArrayList arrayList, HashSet hashSet) {
        boolean bl2 = arrayList.contains(object);
        if (bl2) {
            return;
        }
        bl2 = hashSet.contains(object);
        if (!bl2) {
            hashSet.add(object);
            ArrayList arrayList2 = (ArrayList)this.mGraph.get(object);
            if (arrayList2 != null) {
                int n10 = arrayList2.size();
                for (int i10 = 0; i10 < n10; ++i10) {
                    Object e10 = arrayList2.get(i10);
                    this.dfs(e10, arrayList, hashSet);
                }
            }
            hashSet.remove(object);
            arrayList.add(object);
            return;
        }
        object = new RuntimeException("This graph contains cyclic dependencies");
        throw object;
    }

    private ArrayList getEmptyList() {
        ArrayList arrayList = (ArrayList)this.mListPool.acquire();
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    private void poolList(ArrayList arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(Object object, Object object2) {
        Object object3 = this.mGraph;
        boolean bl2 = ((SimpleArrayMap)object3).containsKey(object);
        if (bl2 && (bl2 = ((SimpleArrayMap)(object3 = this.mGraph)).containsKey(object2))) {
            object3 = (ArrayList)this.mGraph.get(object);
            if (object3 == null) {
                object3 = this.getEmptyList();
                SimpleArrayMap simpleArrayMap = this.mGraph;
                simpleArrayMap.put(object, object3);
            }
            ((ArrayList)object3).add(object2);
            return;
        }
        object = new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        throw object;
    }

    public void addNode(Object object) {
        SimpleArrayMap simpleArrayMap = this.mGraph;
        boolean bl2 = simpleArrayMap.containsKey(object);
        if (!bl2) {
            simpleArrayMap = this.mGraph;
            simpleArrayMap.put(object, null);
        }
    }

    public void clear() {
        SimpleArrayMap simpleArrayMap = this.mGraph;
        int n10 = simpleArrayMap.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ArrayList arrayList = (ArrayList)this.mGraph.valueAt(i10);
            if (arrayList == null) continue;
            this.poolList(arrayList);
        }
        this.mGraph.clear();
    }

    public boolean contains(Object object) {
        return this.mGraph.containsKey(object);
    }

    public List getIncomingEdges(Object object) {
        return (List)this.mGraph.get(object);
    }

    public List getOutgoingEdges(Object object) {
        SimpleArrayMap simpleArrayMap = this.mGraph;
        int n10 = simpleArrayMap.size();
        ArrayList<Object> arrayList = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            Object object2 = (ArrayList)this.mGraph.valueAt(i10);
            if (object2 == null || !(bl2 = ((ArrayList)object2).contains(object))) continue;
            if (arrayList == null) {
                arrayList = new ArrayList<Object>();
            }
            object2 = this.mGraph.keyAt(i10);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public ArrayList getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        SimpleArrayMap simpleArrayMap = this.mGraph;
        int n10 = simpleArrayMap.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = this.mGraph.keyAt(i10);
            ArrayList arrayList = this.mSortResult;
            HashSet hashSet = this.mSortTmpMarked;
            this.dfs(object, arrayList, hashSet);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(Object object) {
        SimpleArrayMap simpleArrayMap = this.mGraph;
        int n10 = simpleArrayMap.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            ArrayList arrayList = (ArrayList)this.mGraph.valueAt(i10);
            if (arrayList == null || !(bl2 = arrayList.contains(object))) continue;
            return true;
        }
        return false;
    }

    public int size() {
        return this.mGraph.size();
    }
}


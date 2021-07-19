/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.common.collect.Cut;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TreeRangeMap$SubRangeMap$SubRangeMapAsMap
extends AbstractMap {
    public final /* synthetic */ TreeRangeMap$SubRangeMap this$1;

    public TreeRangeMap$SubRangeMap$SubRangeMapAsMap(TreeRangeMap$SubRangeMap subRangeMap) {
        this.this$1 = subRangeMap;
    }

    public static /* synthetic */ boolean access$400(TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap, Predicate predicate) {
        return treeRangeMap$SubRangeMap$SubRangeMapAsMap.removeEntryIf(predicate);
    }

    private boolean removeEntryIf(Predicate object) {
        boolean bl2;
        Object object2;
        boolean bl3;
        ArrayList arrayList = Lists.newArrayList();
        Object object3 = this.entrySet().iterator();
        while (bl3 = object3.hasNext()) {
            object2 = (Map.Entry)object3.next();
            boolean bl4 = object.apply(object2);
            if (!bl4) continue;
            object2 = object2.getKey();
            arrayList.add(object2);
        }
        object = arrayList.iterator();
        while (bl2 = object.hasNext()) {
            object3 = (Range)object.next();
            object2 = this.this$1.this$0;
            ((TreeRangeMap)object2).remove((Range)object3);
        }
        return arrayList.isEmpty() ^ true;
    }

    public void clear() {
        this.this$1.clear();
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        if ((object = this.get(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Iterator entryIterator() {
        Object object = TreeRangeMap$SubRangeMap.access$300(this.this$1);
        boolean bl2 = ((Range)object).isEmpty();
        if (bl2) {
            return Iterators.emptyIterator();
        }
        object = TreeRangeMap.access$000(this.this$1.this$0);
        Object object2 = TreeRangeMap$SubRangeMap.access$300((TreeRangeMap$SubRangeMap)this.this$1).lowerBound;
        object = object.floorKey(object2);
        object2 = TreeRangeMap$SubRangeMap.access$300((TreeRangeMap$SubRangeMap)this.this$1).lowerBound;
        object = (Cut)MoreObjects.firstNonNull(object, object2);
        object = TreeRangeMap.access$000(this.this$1.this$0).tailMap(object, true).values().iterator();
        object2 = new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3(this, (Iterator)object);
        return object2;
    }

    public Set entrySet() {
        TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2 treeRangeMap$SubRangeMap$SubRangeMapAsMap$2 = new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2(this);
        return treeRangeMap$SubRangeMap$SubRangeMapAsMap$2;
    }

    public Object get(Object object) {
        block34: {
            Object object2;
            TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry;
            block37: {
                block35: {
                    block36: {
                        boolean n10 = object instanceof Range;
                        if (!n10) break block34;
                        try {
                            object = (Range)object;
                        }
                        catch (ClassCastException classCastException) {}
                        treeRangeMap$RangeMapEntry = this.this$1;
                        treeRangeMap$RangeMapEntry = TreeRangeMap$SubRangeMap.access$300((TreeRangeMap$SubRangeMap)((Object)treeRangeMap$RangeMapEntry));
                        boolean bl2 = ((Range)((Object)treeRangeMap$RangeMapEntry)).encloses((Range)object);
                        if (!bl2) break block34;
                        boolean bl3 = ((Range)object).isEmpty();
                        if (bl3) break block34;
                        treeRangeMap$RangeMapEntry = ((Range)object).lowerBound;
                        object2 = this.this$1;
                        object2 = TreeRangeMap$SubRangeMap.access$300((TreeRangeMap$SubRangeMap)object2);
                        object2 = ((Range)object2).lowerBound;
                        int n11 = ((Cut)((Object)treeRangeMap$RangeMapEntry)).compareTo((Cut)object2);
                        if (n11 != 0) break block35;
                        treeRangeMap$RangeMapEntry = this.this$1;
                        treeRangeMap$RangeMapEntry = ((TreeRangeMap$SubRangeMap)treeRangeMap$RangeMapEntry).this$0;
                        treeRangeMap$RangeMapEntry = TreeRangeMap.access$000((TreeRangeMap)((Object)treeRangeMap$RangeMapEntry));
                        object2 = ((Range)object).lowerBound;
                        treeRangeMap$RangeMapEntry = treeRangeMap$RangeMapEntry.floorEntry(object2);
                        if (treeRangeMap$RangeMapEntry == null) break block36;
                        treeRangeMap$RangeMapEntry = treeRangeMap$RangeMapEntry.getValue();
                        break block37;
                    }
                    boolean bl4 = false;
                    treeRangeMap$RangeMapEntry = null;
                    break block37;
                }
                treeRangeMap$RangeMapEntry = this.this$1;
                treeRangeMap$RangeMapEntry = ((TreeRangeMap$SubRangeMap)treeRangeMap$RangeMapEntry).this$0;
                treeRangeMap$RangeMapEntry = TreeRangeMap.access$000((TreeRangeMap)((Object)treeRangeMap$RangeMapEntry));
                object2 = ((Range)object).lowerBound;
                treeRangeMap$RangeMapEntry = treeRangeMap$RangeMapEntry.get(object2);
                treeRangeMap$RangeMapEntry = treeRangeMap$RangeMapEntry;
            }
            if (treeRangeMap$RangeMapEntry == null) break block34;
            object2 = treeRangeMap$RangeMapEntry.getKey();
            Object object3 = this.this$1;
            object3 = TreeRangeMap$SubRangeMap.access$300((TreeRangeMap$SubRangeMap)object3);
            boolean bl5 = ((Range)object2).isConnected((Range)object3);
            if (!bl5) break block34;
            object2 = treeRangeMap$RangeMapEntry.getKey();
            object3 = this.this$1;
            object3 = TreeRangeMap$SubRangeMap.access$300((TreeRangeMap$SubRangeMap)object3);
            object2 = ((Range)object2).intersection((Range)object3);
            boolean bl6 = ((Range)object2).equals(object);
            if (!bl6) break block34;
            return treeRangeMap$RangeMapEntry.getValue();
        }
        return null;
    }

    public Set keySet() {
        TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1 treeRangeMap$SubRangeMap$SubRangeMapAsMap$1 = new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1(this, this);
        return treeRangeMap$SubRangeMap$SubRangeMapAsMap$1;
    }

    public Object remove(Object object) {
        Object object2 = this.get(object);
        if (object2 != null) {
            object = (Range)object;
            this.this$1.this$0.remove((Range)object);
            return object2;
        }
        return null;
    }

    public Collection values() {
        TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4 treeRangeMap$SubRangeMap$SubRangeMapAsMap$4 = new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4(this, this);
        return treeRangeMap$SubRangeMap$SubRangeMapAsMap$4;
    }
}


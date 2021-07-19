/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class ImmutableRangeMap$Builder {
    private final List entries;

    public ImmutableRangeMap$Builder() {
        ArrayList arrayList = Lists.newArrayList();
        this.entries = arrayList;
    }

    public ImmutableRangeMap build() {
        Object object;
        int n10;
        Object object2 = this.entries;
        Object object3 = Range.rangeLexOrdering().onKeys();
        Collections.sort(object2, object3);
        int n11 = this.entries.size();
        object2 = new ImmutableList$Builder(n11);
        int n12 = this.entries.size();
        object3 = new ImmutableList$Builder(n12);
        ImmutableRangeMap immutableRangeMap = null;
        for (n12 = 0; n12 < (n10 = (object = this.entries).size()); ++n12) {
            object = (Range)((Map.Entry)this.entries.get(n12)).getKey();
            if (n12 > 0) {
                Range range;
                Object object4 = this.entries;
                int n13 = n12 + -1;
                if ((n13 = (int)(((Range)object).isConnected((Range)(object4 = (Range)((Map.Entry)object4.get(n13)).getKey())) ? 1 : 0)) != 0 && (n13 = (int)((range = ((Range)object).intersection((Range)object4)).isEmpty() ? 1 : 0)) == 0) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Overlapping ranges: range ");
                    ((StringBuilder)object3).append(object4);
                    ((StringBuilder)object3).append(" overlaps with entry ");
                    ((StringBuilder)object3).append(object);
                    object3 = ((StringBuilder)object3).toString();
                    object2 = new IllegalArgumentException((String)object3);
                    throw object2;
                }
            }
            ((ImmutableList$Builder)object2).add(object);
            object = ((Map.Entry)this.entries.get(n12)).getValue();
            ((ImmutableList$Builder)object3).add(object);
        }
        object2 = ((ImmutableList$Builder)object2).build();
        object3 = ((ImmutableList$Builder)object3).build();
        immutableRangeMap = new ImmutableRangeMap((ImmutableList)object2, (ImmutableList)object3);
        return immutableRangeMap;
    }

    public ImmutableRangeMap$Builder put(Range object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Preconditions.checkArgument(((Range)object).isEmpty() ^ true, "Range must not be empty, but was %s", object);
        List list = this.entries;
        object = Maps.immutableEntry(object, object2);
        list.add(object);
        return this;
    }

    public ImmutableRangeMap$Builder putAll(RangeMap object) {
        boolean bl2;
        object = object.asMapOfRanges().entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Range range = (Range)entry.getKey();
            entry = entry.getValue();
            this.put(range, entry);
        }
        return this;
    }
}


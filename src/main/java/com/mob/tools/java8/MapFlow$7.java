/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.MapFlow;
import com.mob.tools.java8.MapFlow$MapItem;
import java.util.Comparator;

public class MapFlow$7
implements Comparator {
    public final /* synthetic */ MapFlow this$0;

    public MapFlow$7(MapFlow mapFlow) {
        this.this$0 = mapFlow;
    }

    public int compare(MapFlow$MapItem mapFlow$MapItem, MapFlow$MapItem mapFlow$MapItem2) {
        return mapFlow$MapItem.compareTo(mapFlow$MapItem2);
    }
}


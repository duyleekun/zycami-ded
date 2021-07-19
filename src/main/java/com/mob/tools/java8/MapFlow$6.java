/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.MapFlow;
import com.mob.tools.java8.MapFlow$MapItem;
import java.util.Comparator;

public class MapFlow$6
implements Comparator {
    public final /* synthetic */ MapFlow this$0;
    public final /* synthetic */ Comparator val$fun;

    public MapFlow$6(MapFlow mapFlow, Comparator comparator) {
        this.this$0 = mapFlow;
        this.val$fun = comparator;
    }

    public int compare(MapFlow$MapItem object, MapFlow$MapItem object2) {
        Comparator comparator = this.val$fun;
        object = ((MapFlow$MapItem)object).key;
        object2 = ((MapFlow$MapItem)object2).key;
        return comparator.compare(object, object2);
    }
}


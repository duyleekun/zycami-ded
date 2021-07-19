/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Map;
import com.mob.tools.java8.Map$MapMap;
import com.mob.tools.java8.MapFlow;
import com.mob.tools.java8.MapFlow$MapItem;

public class MapFlow$2
implements Map {
    public final /* synthetic */ MapFlow this$0;
    public final /* synthetic */ Map$MapMap val$fun;

    public MapFlow$2(MapFlow mapFlow, Map$MapMap map$MapMap) {
        this.this$0 = mapFlow;
        this.val$fun = map$MapMap;
    }

    public MapFlow$MapItem map(MapFlow$MapItem mapFlow$MapItem) {
        Object object = this.val$fun;
        Object object2 = mapFlow$MapItem.key;
        Object object3 = mapFlow$MapItem.value;
        mapFlow$MapItem.value = object = object.map(object2, object3);
        return mapFlow$MapItem;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Filter;
import com.mob.tools.java8.Filter$MapFilter;
import com.mob.tools.java8.MapFlow;
import com.mob.tools.java8.MapFlow$MapItem;

public class MapFlow$1
implements Filter {
    public final /* synthetic */ MapFlow this$0;
    public final /* synthetic */ Filter$MapFilter val$fun;

    public MapFlow$1(MapFlow mapFlow, Filter$MapFilter filter$MapFilter) {
        this.this$0 = mapFlow;
        this.val$fun = filter$MapFilter;
    }

    public boolean filter(MapFlow$MapItem object) {
        Filter$MapFilter filter$MapFilter = this.val$fun;
        Object object2 = ((MapFlow$MapItem)object).key;
        object = ((MapFlow$MapItem)object).value;
        return filter$MapFilter.filter(object2, object);
    }
}


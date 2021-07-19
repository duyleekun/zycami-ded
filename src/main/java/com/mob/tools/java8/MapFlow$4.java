/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Collect;
import com.mob.tools.java8.Collect$MapCollect;
import com.mob.tools.java8.Flow;
import com.mob.tools.java8.MapFlow;
import com.mob.tools.java8.MapFlow$MapItem;

public class MapFlow$4
implements Collect {
    public final /* synthetic */ MapFlow this$0;
    public final /* synthetic */ Collect$MapCollect val$fun;

    public MapFlow$4(MapFlow mapFlow, Collect$MapCollect collect$MapCollect) {
        this.this$0 = mapFlow;
        this.val$fun = collect$MapCollect;
    }

    public Flow collect(MapFlow$MapItem object) {
        Collect$MapCollect collect$MapCollect = this.val$fun;
        Object object2 = ((MapFlow$MapItem)object).key;
        object = ((MapFlow$MapItem)object).value;
        return collect$MapCollect.collect((Object)object2, (Object)object).flow;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Each;
import com.mob.tools.java8.Each$MapEach;
import com.mob.tools.java8.MapFlow;
import com.mob.tools.java8.MapFlow$MapItem;

public class MapFlow$8
implements Each {
    public final /* synthetic */ MapFlow this$0;
    public final /* synthetic */ Each$MapEach val$fun;

    public MapFlow$8(MapFlow mapFlow, Each$MapEach each$MapEach) {
        this.this$0 = mapFlow;
        this.val$fun = each$MapEach;
    }

    public void each(MapFlow$MapItem object) {
        Each$MapEach each$MapEach = this.val$fun;
        Object object2 = ((MapFlow$MapItem)object).key;
        object = ((MapFlow$MapItem)object).value;
        each$MapEach.each(object2, object);
    }
}


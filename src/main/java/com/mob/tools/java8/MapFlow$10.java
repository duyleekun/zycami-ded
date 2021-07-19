/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Inject;
import com.mob.tools.java8.Inject$MapInject;
import com.mob.tools.java8.MapFlow;
import com.mob.tools.java8.MapFlow$MapItem;

public class MapFlow$10
implements Inject {
    public final /* synthetic */ MapFlow this$0;
    public final /* synthetic */ Inject$MapInject val$fun;

    public MapFlow$10(MapFlow mapFlow, Inject$MapInject inject$MapInject) {
        this.this$0 = mapFlow;
        this.val$fun = inject$MapInject;
    }

    public Object inject(MapFlow$MapItem object, Object object2) {
        Inject$MapInject inject$MapInject = this.val$fun;
        Object object3 = ((MapFlow$MapItem)object).key;
        object = ((MapFlow$MapItem)object).value;
        return inject$MapInject.inject(object3, object, object2);
    }
}


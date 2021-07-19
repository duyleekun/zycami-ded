/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure1V;
import com.mob.tools.java8.Closure$IClosure2V;
import com.mob.tools.java8.MapFlow;
import com.mob.tools.java8.MapFlow$MapItem;

public class MapFlow$11
implements Closure$IClosure1V {
    public final /* synthetic */ MapFlow this$0;
    public final /* synthetic */ Closure$IClosure2V val$consumer;

    public MapFlow$11(MapFlow mapFlow, Closure$IClosure2V closure$IClosure2V) {
        this.this$0 = mapFlow;
        this.val$consumer = closure$IClosure2V;
    }

    public void call(MapFlow$MapItem object) {
        Closure$IClosure2V closure$IClosure2V = this.val$consumer;
        Object object2 = ((MapFlow$MapItem)object).key;
        object = ((MapFlow$MapItem)object).value;
        closure$IClosure2V.call(object2, object);
    }
}


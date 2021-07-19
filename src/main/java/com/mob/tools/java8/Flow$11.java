/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Each;
import com.mob.tools.java8.Flow;
import com.mob.tools.java8.MapMaker;
import java.util.HashMap;

public class Flow$11
implements Each {
    public final /* synthetic */ Flow this$0;
    public final /* synthetic */ MapMaker val$fun;
    public final /* synthetic */ HashMap val$map;

    public Flow$11(Flow flow, MapMaker mapMaker, HashMap hashMap) {
        this.this$0 = flow;
        this.val$fun = mapMaker;
        this.val$map = hashMap;
    }

    public void each(Object object) {
        MapMaker mapMaker = this.val$fun;
        HashMap hashMap = this.val$map;
        mapMaker.toMap(object, hashMap);
    }
}


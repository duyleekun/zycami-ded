/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Each$MapEach;
import com.mob.tools.java8.MapFlow;
import java.util.Map;

public class MapFlow$9
implements Each$MapEach {
    public final /* synthetic */ MapFlow this$0;
    public final /* synthetic */ Map val$map;

    public MapFlow$9(MapFlow mapFlow, Map map) {
        this.this$0 = mapFlow;
        this.val$map = map;
    }

    public void each(Object object, Object object2) {
        this.val$map.put(object, object2);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.MapFlow;
import com.mob.tools.java8.MapFlow$MapItem;
import com.mob.tools.java8.Peek;
import com.mob.tools.java8.Peek$MapPeek;

public class MapFlow$5
implements Peek {
    public final /* synthetic */ MapFlow this$0;
    public final /* synthetic */ Peek$MapPeek val$fun;

    public MapFlow$5(MapFlow mapFlow, Peek$MapPeek peek$MapPeek) {
        this.this$0 = mapFlow;
        this.val$fun = peek$MapPeek;
    }

    public void peek(MapFlow$MapItem object) {
        Peek$MapPeek peek$MapPeek = this.val$fun;
        Object object2 = ((MapFlow$MapItem)object).key;
        object = ((MapFlow$MapItem)object).value;
        peek$MapPeek.peek(object2, object);
    }
}


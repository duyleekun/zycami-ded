/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Each;
import com.mob.tools.java8.Flow;
import com.mob.tools.java8.Inject;

public class Flow$10
implements Each {
    public final /* synthetic */ Flow this$0;
    public final /* synthetic */ Inject val$fun;
    public final /* synthetic */ Object[] val$previous;

    public Flow$10(Flow flow, Object[] objectArray, Inject inject) {
        this.this$0 = flow;
        this.val$previous = objectArray;
        this.val$fun = inject;
    }

    public void each(Object object) {
        Object[] objectArray = this.val$previous;
        Inject inject = this.val$fun;
        Object object2 = objectArray[0];
        objectArray[0] = object = inject.inject(object, object2);
    }
}


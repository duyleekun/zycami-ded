/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Each;
import com.mob.tools.java8.Flow;

public class Flow$9
implements Each {
    public final /* synthetic */ Flow this$0;
    public final /* synthetic */ int[] val$count;

    public Flow$9(Flow flow, int[] nArray) {
        this.this$0 = flow;
        this.val$count = nArray;
    }

    public void each(Object object) {
        reference var2_2;
        object = this.val$count;
        object[0] = var2_2 = object[0] + true;
    }
}


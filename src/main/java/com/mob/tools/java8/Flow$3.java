/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Collect;
import com.mob.tools.java8.Flow;
import java.util.List;

public class Flow$3
implements Collect {
    public final /* synthetic */ Flow this$0;

    public Flow$3(Flow flow) {
        this.this$0 = flow;
    }

    public Flow collect(List list) {
        return Flow.of(list);
    }
}


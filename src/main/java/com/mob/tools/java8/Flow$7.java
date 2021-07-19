/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Each;
import com.mob.tools.java8.Flow;
import java.util.HashSet;

public class Flow$7
implements Each {
    public final /* synthetic */ Flow this$0;
    public final /* synthetic */ HashSet val$set;

    public Flow$7(Flow flow, HashSet hashSet) {
        this.this$0 = flow;
        this.val$set = hashSet;
    }

    public void each(Object object) {
        this.val$set.add(object);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Each;
import com.mob.tools.java8.Flow;
import java.util.LinkedList;

public class Flow$8
implements Each {
    public final /* synthetic */ Flow this$0;
    public final /* synthetic */ LinkedList val$list;

    public Flow$8(Flow flow, LinkedList linkedList) {
        this.this$0 = flow;
        this.val$list = linkedList;
    }

    public void each(Object object) {
        this.val$list.add(object);
    }
}


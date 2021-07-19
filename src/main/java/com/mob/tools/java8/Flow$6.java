/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure;
import com.mob.tools.java8.Flow;
import java.util.List;

public class Flow$6
implements Closure$IClosure {
    private int index;
    public final /* synthetic */ Flow this$0;
    public final /* synthetic */ List val$list;
    public final /* synthetic */ int val$size;

    public Flow$6(Flow flow, int n10, List list) {
        this.this$0 = flow;
        this.val$size = n10;
        this.val$list = list;
    }

    public Object call() {
        Object var4_4;
        int n10 = this.index;
        int n11 = this.val$size;
        if (n10 < n11) {
            List list = this.val$list;
            var4_4 = list.get(n10);
        } else {
            n10 = 0;
            var4_4 = null;
        }
        this.index = n11 = this.index + 1;
        return var4_4;
    }
}


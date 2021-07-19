/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Flow$4;
import com.mob.tools.java8.FlowIterator;
import java.util.Iterator;

public class Flow$4$1
implements FlowIterator {
    public final /* synthetic */ Flow$4 this$1;
    public final /* synthetic */ Iterator val$it;

    public Flow$4$1(Flow$4 flow$4, Iterator iterator2) {
        this.this$1 = flow$4;
        this.val$it = iterator2;
    }

    public void finish() {
    }

    public boolean hasNext() {
        return this.val$it.hasNext();
    }

    public Object next() {
        return this.val$it.next();
    }
}


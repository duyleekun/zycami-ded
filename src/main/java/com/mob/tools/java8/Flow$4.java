/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Flow;
import com.mob.tools.java8.Flow$4$1;
import com.mob.tools.java8.FlowIterator;
import com.mob.tools.java8.FlowIterator$FlowIteratorWrapper;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Flow$4
extends FlowIterator$FlowIteratorWrapper {
    public final /* synthetic */ Flow this$0;
    public final /* synthetic */ Comparator val$fun;
    public final /* synthetic */ Flow val$self;

    public Flow$4(Flow flow, Flow flow2, Comparator comparator) {
        this.this$0 = flow;
        this.val$self = flow2;
        this.val$fun = comparator;
    }

    public FlowIterator initIterator() {
        Object object = this.val$self.toList();
        Object object2 = this.val$fun;
        Collections.sort(object, object2);
        object = object.iterator();
        object2 = new Flow$4$1(this, (Iterator)object);
        return object2;
    }
}


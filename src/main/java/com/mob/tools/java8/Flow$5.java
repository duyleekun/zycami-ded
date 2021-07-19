/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Flow;
import com.mob.tools.java8.Flow$5$1;
import com.mob.tools.java8.FlowIterator;
import com.mob.tools.java8.FlowIterator$FlowIteratorWrapper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Flow$5
extends FlowIterator$FlowIteratorWrapper {
    public final /* synthetic */ Flow this$0;
    public final /* synthetic */ Flow val$self;

    public Flow$5(Flow flow, Flow flow2) {
        this.this$0 = flow;
        this.val$self = flow2;
    }

    public FlowIterator initIterator() {
        int n10;
        Object object = this.val$self.toList();
        Object object2 = new Random();
        LinkedList linkedList = new LinkedList();
        while ((n10 = object.size()) > 0) {
            n10 = object.size();
            n10 = ((Random)object2).nextInt(n10);
            Object e10 = object.remove(n10);
            linkedList.add(e10);
        }
        object = linkedList.iterator();
        object2 = new Flow$5$1(this, (Iterator)object);
        return object2;
    }
}


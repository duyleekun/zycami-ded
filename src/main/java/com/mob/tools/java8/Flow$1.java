/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Flow;
import java.util.LinkedList;

public final class Flow$1
extends Flow {
    public final /* synthetic */ Flow[] val$flows;

    public Flow$1(Flow[] flowArray) {
        this.val$flows = flowArray;
        super((Flow$1)null);
    }

    public void evaluate() {
        for (Flow flow : this.val$flows) {
            LinkedList linkedList = flow.functions;
            LinkedList linkedList2 = this.functions;
            linkedList.addAll(linkedList2);
            flow.evaluate();
        }
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Function;
import java.util.LinkedList;

public class Batch
implements Function {
    private int limit;
    public LinkedList output;

    public Batch(int n10) {
        LinkedList linkedList;
        this.limit = n10;
        this.output = linkedList = new LinkedList();
    }

    public LinkedList output() {
        return this.output;
    }

    public int test(Object object) {
        this.output.add(object);
        int n10 = this.limit;
        int n11 = -1;
        if (n10 == n11) {
            return 0;
        }
        object = this.output;
        n10 = ((LinkedList)object).size();
        if (n10 == (n11 = this.limit)) {
            return 1;
        }
        object = this.output;
        n10 = ((LinkedList)object).size();
        if (n10 > (n11 = this.limit)) {
            this.output.removeLast();
            return 2;
        }
        return 0;
    }
}


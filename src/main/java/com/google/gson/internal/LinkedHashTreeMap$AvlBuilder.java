/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap$Node;

public final class LinkedHashTreeMap$AvlBuilder {
    private int leavesSkipped;
    private int leavesToSkip;
    private int size;
    private LinkedHashTreeMap$Node stack;

    public void add(LinkedHashTreeMap$Node linkedHashTreeMap$Node) {
        int n10;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2;
        int n11;
        int n12;
        int n13;
        linkedHashTreeMap$Node.right = null;
        linkedHashTreeMap$Node.parent = null;
        linkedHashTreeMap$Node.left = null;
        linkedHashTreeMap$Node.height = n13 = 1;
        int n14 = this.leavesToSkip;
        if (n14 > 0 && (n12 = (n11 = this.size) & 1) == 0) {
            this.size = n11 += n13;
            this.leavesToSkip = n14 -= n13;
            this.leavesSkipped = n14 = this.leavesSkipped + n13;
        }
        linkedHashTreeMap$Node.parent = linkedHashTreeMap$Node2 = this.stack;
        this.stack = linkedHashTreeMap$Node;
        this.size = n10 = this.size + n13;
        n14 = this.leavesToSkip;
        if (n14 > 0 && (n11 = n10 & 1) == 0) {
            this.size = n10 += n13;
            this.leavesToSkip = n14 -= n13;
            this.leavesSkipped = n10 = this.leavesSkipped + n13;
        }
        n10 = 4;
        while (true) {
            int n15;
            LinkedHashTreeMap$Node linkedHashTreeMap$Node3;
            LinkedHashTreeMap$Node linkedHashTreeMap$Node4;
            n14 = this.size;
            n11 = n10 + -1;
            if ((n14 &= n11) != n11) break;
            n14 = this.leavesSkipped;
            if (n14 == 0) {
                LinkedHashTreeMap$Node linkedHashTreeMap$Node5;
                linkedHashTreeMap$Node2 = this.stack;
                linkedHashTreeMap$Node4 = linkedHashTreeMap$Node2.parent;
                linkedHashTreeMap$Node3 = linkedHashTreeMap$Node4.parent;
                linkedHashTreeMap$Node4.parent = linkedHashTreeMap$Node5 = linkedHashTreeMap$Node3.parent;
                this.stack = linkedHashTreeMap$Node4;
                linkedHashTreeMap$Node4.left = linkedHashTreeMap$Node3;
                linkedHashTreeMap$Node4.right = linkedHashTreeMap$Node2;
                linkedHashTreeMap$Node4.height = n15 = linkedHashTreeMap$Node2.height + n13;
                linkedHashTreeMap$Node3.parent = linkedHashTreeMap$Node4;
                linkedHashTreeMap$Node2.parent = linkedHashTreeMap$Node4;
            } else {
                n11 = 0;
                linkedHashTreeMap$Node4 = null;
                if (n14 == n13) {
                    linkedHashTreeMap$Node2 = this.stack;
                    this.stack = linkedHashTreeMap$Node3 = linkedHashTreeMap$Node2.parent;
                    linkedHashTreeMap$Node3.right = linkedHashTreeMap$Node2;
                    linkedHashTreeMap$Node3.height = n15 = linkedHashTreeMap$Node2.height + n13;
                    linkedHashTreeMap$Node2.parent = linkedHashTreeMap$Node3;
                    this.leavesSkipped = 0;
                } else {
                    n12 = 2;
                    if (n14 == n12) {
                        this.leavesSkipped = 0;
                    }
                }
            }
            n10 *= 2;
        }
    }

    public void reset(int n10) {
        int n11;
        this.leavesToSkip = n11 = Integer.highestOneBit(n10) * 2 + -1 - n10;
        this.size = 0;
        this.leavesSkipped = 0;
        this.stack = null;
    }

    public LinkedHashTreeMap$Node root() {
        Object object = this.stack;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node = ((LinkedHashTreeMap$Node)object).parent;
        if (linkedHashTreeMap$Node == null) {
            return object;
        }
        object = new IllegalStateException();
        throw object;
    }
}


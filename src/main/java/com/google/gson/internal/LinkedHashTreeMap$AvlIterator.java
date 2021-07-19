/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap$Node;

public class LinkedHashTreeMap$AvlIterator {
    private LinkedHashTreeMap$Node stackTop;

    public LinkedHashTreeMap$Node next() {
        LinkedHashTreeMap$Node linkedHashTreeMap$Node;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = this.stackTop;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node3 = null;
        if (linkedHashTreeMap$Node2 == null) {
            return null;
        }
        LinkedHashTreeMap$Node linkedHashTreeMap$Node4 = linkedHashTreeMap$Node2.parent;
        linkedHashTreeMap$Node2.parent = null;
        linkedHashTreeMap$Node3 = linkedHashTreeMap$Node2.right;
        while (true) {
            linkedHashTreeMap$Node = linkedHashTreeMap$Node4;
            linkedHashTreeMap$Node4 = linkedHashTreeMap$Node3;
            linkedHashTreeMap$Node3 = linkedHashTreeMap$Node;
            if (linkedHashTreeMap$Node4 == null) break;
            linkedHashTreeMap$Node4.parent = linkedHashTreeMap$Node;
            linkedHashTreeMap$Node3 = linkedHashTreeMap$Node4.left;
        }
        this.stackTop = linkedHashTreeMap$Node;
        return linkedHashTreeMap$Node2;
    }

    public void reset(LinkedHashTreeMap$Node linkedHashTreeMap$Node) {
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = null;
        while (linkedHashTreeMap$Node != null) {
            linkedHashTreeMap$Node.parent = linkedHashTreeMap$Node2;
            LinkedHashTreeMap$Node linkedHashTreeMap$Node3 = linkedHashTreeMap$Node.left;
            linkedHashTreeMap$Node2 = linkedHashTreeMap$Node;
            linkedHashTreeMap$Node = linkedHashTreeMap$Node3;
        }
        this.stackTop = linkedHashTreeMap$Node2;
    }
}


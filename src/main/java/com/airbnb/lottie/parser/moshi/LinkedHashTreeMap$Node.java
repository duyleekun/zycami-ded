/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser.moshi;

import java.util.Map;

public final class LinkedHashTreeMap$Node
implements Map.Entry {
    public final int hash;
    public int height;
    public final Object key;
    public LinkedHashTreeMap$Node left;
    public LinkedHashTreeMap$Node next;
    public LinkedHashTreeMap$Node parent;
    public LinkedHashTreeMap$Node prev;
    public LinkedHashTreeMap$Node right;
    public Object value;

    public LinkedHashTreeMap$Node() {
        this.key = null;
        this.hash = -1;
        this.prev = this;
        this.next = this;
    }

    public LinkedHashTreeMap$Node(LinkedHashTreeMap$Node linkedHashTreeMap$Node, Object object, int n10, LinkedHashTreeMap$Node linkedHashTreeMap$Node2, LinkedHashTreeMap$Node linkedHashTreeMap$Node3) {
        this.parent = linkedHashTreeMap$Node;
        this.key = object;
        this.hash = n10;
        this.height = 1;
        this.next = linkedHashTreeMap$Node2;
        this.prev = linkedHashTreeMap$Node3;
        linkedHashTreeMap$Node3.next = this;
        linkedHashTreeMap$Node2.prev = this;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Map.Entry;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            Object k10;
            object = (Map.Entry)object;
            Object object2 = this.key;
            if ((object2 == null ? (object2 = object.getKey()) == null : (bl2 = object2.equals(k10 = object.getKey()))) && ((object2 = this.value) == null ? (object = object.getValue()) == null : (bl4 = object2.equals(object = object.getValue())))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public LinkedHashTreeMap$Node first() {
        LinkedHashTreeMap$Node linkedHashTreeMap$Node = this.left;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = this;
        while (linkedHashTreeMap$Node != null) {
            LinkedHashTreeMap$Node linkedHashTreeMap$Node3 = linkedHashTreeMap$Node.left;
            linkedHashTreeMap$Node2 = linkedHashTreeMap$Node;
            linkedHashTreeMap$Node = linkedHashTreeMap$Node3;
        }
        return linkedHashTreeMap$Node2;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int n10;
        Object object = this.key;
        int n11 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        Object object2 = this.value;
        if (object2 != null) {
            n11 = object2.hashCode();
        }
        return n10 ^ n11;
    }

    public LinkedHashTreeMap$Node last() {
        LinkedHashTreeMap$Node linkedHashTreeMap$Node = this.right;
        LinkedHashTreeMap$Node linkedHashTreeMap$Node2 = this;
        while (linkedHashTreeMap$Node != null) {
            LinkedHashTreeMap$Node linkedHashTreeMap$Node3 = linkedHashTreeMap$Node.right;
            linkedHashTreeMap$Node2 = linkedHashTreeMap$Node;
            linkedHashTreeMap$Node = linkedHashTreeMap$Node3;
        }
        return linkedHashTreeMap$Node2;
    }

    public Object setValue(Object object) {
        Object object2 = this.value;
        this.value = object;
        return object2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.key;
        stringBuilder.append(object);
        stringBuilder.append("=");
        object = this.value;
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import java.util.Map;

public final class LinkedTreeMap$Node
implements Map.Entry {
    public int height;
    public final Object key;
    public LinkedTreeMap$Node left;
    public LinkedTreeMap$Node next;
    public LinkedTreeMap$Node parent;
    public LinkedTreeMap$Node prev;
    public LinkedTreeMap$Node right;
    public Object value;

    public LinkedTreeMap$Node() {
        this.key = null;
        this.prev = this;
        this.next = this;
    }

    public LinkedTreeMap$Node(LinkedTreeMap$Node linkedTreeMap$Node, Object object, LinkedTreeMap$Node linkedTreeMap$Node2, LinkedTreeMap$Node linkedTreeMap$Node3) {
        this.parent = linkedTreeMap$Node;
        this.key = object;
        this.height = 1;
        this.next = linkedTreeMap$Node2;
        this.prev = linkedTreeMap$Node3;
        linkedTreeMap$Node3.next = this;
        linkedTreeMap$Node2.prev = this;
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

    public LinkedTreeMap$Node first() {
        LinkedTreeMap$Node linkedTreeMap$Node = this.left;
        LinkedTreeMap$Node linkedTreeMap$Node2 = this;
        while (linkedTreeMap$Node != null) {
            LinkedTreeMap$Node linkedTreeMap$Node3 = linkedTreeMap$Node.left;
            linkedTreeMap$Node2 = linkedTreeMap$Node;
            linkedTreeMap$Node = linkedTreeMap$Node3;
        }
        return linkedTreeMap$Node2;
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

    public LinkedTreeMap$Node last() {
        LinkedTreeMap$Node linkedTreeMap$Node = this.right;
        LinkedTreeMap$Node linkedTreeMap$Node2 = this;
        while (linkedTreeMap$Node != null) {
            LinkedTreeMap$Node linkedTreeMap$Node3 = linkedTreeMap$Node.right;
            linkedTreeMap$Node2 = linkedTreeMap$Node;
            linkedTreeMap$Node = linkedTreeMap$Node3;
        }
        return linkedTreeMap$Node2;
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


/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;

public final class LinkedListMultimap$Node
extends AbstractMapEntry {
    public final Object key;
    public LinkedListMultimap$Node next;
    public LinkedListMultimap$Node nextSibling;
    public LinkedListMultimap$Node previous;
    public LinkedListMultimap$Node previousSibling;
    public Object value;

    public LinkedListMultimap$Node(Object object, Object object2) {
        this.key = object;
        this.value = object2;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public Object setValue(Object object) {
        Object object2 = this.value;
        this.value = object;
        return object2;
    }
}


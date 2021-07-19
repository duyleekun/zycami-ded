/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap$Node;

public class LinkedListMultimap$KeyList {
    public int count;
    public LinkedListMultimap$Node head;
    public LinkedListMultimap$Node tail;

    public LinkedListMultimap$KeyList(LinkedListMultimap$Node linkedListMultimap$Node) {
        this.head = linkedListMultimap$Node;
        this.tail = linkedListMultimap$Node;
        linkedListMultimap$Node.previousSibling = null;
        linkedListMultimap$Node.nextSibling = null;
        this.count = 1;
    }
}


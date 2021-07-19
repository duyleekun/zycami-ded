/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.AbstractList;
import java.util.List;

public class RepeatedFieldBuilder$MessageExternalList
extends AbstractList
implements List {
    public RepeatedFieldBuilder builder;

    public RepeatedFieldBuilder$MessageExternalList(RepeatedFieldBuilder repeatedFieldBuilder) {
        this.builder = repeatedFieldBuilder;
    }

    public GeneratedMessage get(int n10) {
        return this.builder.getMessage(n10);
    }

    public void incrementModCount() {
        int n10;
        this.modCount = n10 = this.modCount + 1;
    }

    public int size() {
        return this.builder.getCount();
    }
}


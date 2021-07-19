/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.RepeatedFieldBuilder;
import java.util.AbstractList;
import java.util.List;

public class RepeatedFieldBuilder$MessageOrBuilderExternalList
extends AbstractList
implements List {
    public RepeatedFieldBuilder builder;

    public RepeatedFieldBuilder$MessageOrBuilderExternalList(RepeatedFieldBuilder repeatedFieldBuilder) {
        this.builder = repeatedFieldBuilder;
    }

    public MessageOrBuilder get(int n10) {
        return this.builder.getMessageOrBuilder(n10);
    }

    public void incrementModCount() {
        int n10;
        this.modCount = n10 = this.modCount + 1;
    }

    public int size() {
        return this.builder.getCount();
    }
}


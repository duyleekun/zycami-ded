/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.RepeatedFieldBuilderV3;
import java.util.AbstractList;
import java.util.List;

public class RepeatedFieldBuilderV3$MessageOrBuilderExternalList
extends AbstractList
implements List {
    public RepeatedFieldBuilderV3 builder;

    public RepeatedFieldBuilderV3$MessageOrBuilderExternalList(RepeatedFieldBuilderV3 repeatedFieldBuilderV3) {
        this.builder = repeatedFieldBuilderV3;
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


/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.RepeatedFieldBuilderV3;
import java.util.AbstractList;
import java.util.List;

public class RepeatedFieldBuilderV3$MessageExternalList
extends AbstractList
implements List {
    public RepeatedFieldBuilderV3 builder;

    public RepeatedFieldBuilderV3$MessageExternalList(RepeatedFieldBuilderV3 repeatedFieldBuilderV3) {
        this.builder = repeatedFieldBuilderV3;
    }

    public AbstractMessage get(int n10) {
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


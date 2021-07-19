/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.RepeatedFieldBuilderV3;
import java.util.AbstractList;
import java.util.List;

public class RepeatedFieldBuilderV3$BuilderExternalList
extends AbstractList
implements List {
    public RepeatedFieldBuilderV3 builder;

    public RepeatedFieldBuilderV3$BuilderExternalList(RepeatedFieldBuilderV3 repeatedFieldBuilderV3) {
        this.builder = repeatedFieldBuilderV3;
    }

    public AbstractMessage$Builder get(int n10) {
        return this.builder.getBuilder(n10);
    }

    public void incrementModCount() {
        int n10;
        this.modCount = n10 = this.modCount + 1;
    }

    public int size() {
        return this.builder.getCount();
    }
}


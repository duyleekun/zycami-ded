/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Value;
import com.google.protobuf.ValueOrBuilder;
import java.util.List;

public interface ListValueOrBuilder
extends MessageOrBuilder {
    public Value getValues(int var1);

    public int getValuesCount();

    public List getValuesList();

    public ValueOrBuilder getValuesOrBuilder(int var1);

    public List getValuesOrBuilderList();
}


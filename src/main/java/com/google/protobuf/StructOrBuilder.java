/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Value;
import java.util.Map;

public interface StructOrBuilder
extends MessageOrBuilder {
    public boolean containsFields(String var1);

    public Map getFields();

    public int getFieldsCount();

    public Map getFieldsMap();

    public Value getFieldsOrDefault(String var1, Value var2);

    public Value getFieldsOrThrow(String var1);
}


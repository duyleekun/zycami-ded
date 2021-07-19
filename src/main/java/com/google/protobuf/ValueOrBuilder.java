/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.Value$KindCase;

public interface ValueOrBuilder
extends MessageOrBuilder {
    public boolean getBoolValue();

    public Value$KindCase getKindCase();

    public ListValue getListValue();

    public ListValueOrBuilder getListValueOrBuilder();

    public NullValue getNullValue();

    public int getNullValueValue();

    public double getNumberValue();

    public String getStringValue();

    public ByteString getStringValueBytes();

    public Struct getStructValue();

    public StructOrBuilder getStructValueOrBuilder();

    public boolean hasListValue();

    public boolean hasStructValue();
}


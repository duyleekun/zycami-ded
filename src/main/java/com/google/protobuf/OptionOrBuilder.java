/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface OptionOrBuilder
extends MessageOrBuilder {
    public String getName();

    public ByteString getNameBytes();

    public Any getValue();

    public AnyOrBuilder getValueOrBuilder();

    public boolean hasValue();
}


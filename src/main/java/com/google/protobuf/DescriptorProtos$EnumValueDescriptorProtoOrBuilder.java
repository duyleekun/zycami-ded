/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.DescriptorProtos$EnumValueOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$EnumValueDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public String getName();

    public ByteString getNameBytes();

    public int getNumber();

    public DescriptorProtos$EnumValueOptions getOptions();

    public DescriptorProtos.EnumValueOptionsOrBuilder getOptionsOrBuilder();

    public boolean hasName();

    public boolean hasNumber();

    public boolean hasOptions();
}


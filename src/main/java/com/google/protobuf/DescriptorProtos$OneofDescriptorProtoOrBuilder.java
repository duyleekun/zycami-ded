/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$OneofOptions;
import com.google.protobuf.DescriptorProtos$OneofOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$OneofDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public String getName();

    public ByteString getNameBytes();

    public DescriptorProtos$OneofOptions getOptions();

    public DescriptorProtos.OneofOptionsOrBuilder getOptionsOrBuilder();

    public boolean hasName();

    public boolean hasOptions();
}


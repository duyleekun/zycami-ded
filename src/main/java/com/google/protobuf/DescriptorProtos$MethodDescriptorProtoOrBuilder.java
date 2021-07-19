/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$MethodDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public boolean getClientStreaming();

    public String getInputType();

    public ByteString getInputTypeBytes();

    public String getName();

    public ByteString getNameBytes();

    public DescriptorProtos$MethodOptions getOptions();

    public DescriptorProtos.MethodOptionsOrBuilder getOptionsOrBuilder();

    public String getOutputType();

    public ByteString getOutputTypeBytes();

    public boolean getServerStreaming();

    public boolean hasClientStreaming();

    public boolean hasInputType();

    public boolean hasName();

    public boolean hasOptions();

    public boolean hasOutputType();

    public boolean hasServerStreaming();
}


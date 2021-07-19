/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodDescriptorProtoOrBuilder;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.DescriptorProtos$ServiceOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$ServiceDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public DescriptorProtos$MethodDescriptorProto getMethod(int var1);

    public int getMethodCount();

    public List getMethodList();

    public DescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(int var1);

    public List getMethodOrBuilderList();

    public String getName();

    public ByteString getNameBytes();

    public DescriptorProtos$ServiceOptions getOptions();

    public DescriptorProtos.ServiceOptionsOrBuilder getOptionsOrBuilder();

    public boolean hasName();

    public boolean hasOptions();
}


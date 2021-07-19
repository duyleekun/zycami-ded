/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumOptionsOrBuilder;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProtoOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$EnumDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public String getName();

    public ByteString getNameBytes();

    public DescriptorProtos$EnumOptions getOptions();

    public DescriptorProtos.EnumOptionsOrBuilder getOptionsOrBuilder();

    public String getReservedName(int var1);

    public ByteString getReservedNameBytes(int var1);

    public int getReservedNameCount();

    public List getReservedNameList();

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRange getReservedRange(int var1);

    public int getReservedRangeCount();

    public List getReservedRangeList();

    public DescriptorProtos$EnumDescriptorProto$EnumReservedRangeOrBuilder getReservedRangeOrBuilder(int var1);

    public List getReservedRangeOrBuilderList();

    public DescriptorProtos$EnumValueDescriptorProto getValue(int var1);

    public int getValueCount();

    public List getValueList();

    public DescriptorProtos$EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int var1);

    public List getValueOrBuilderList();

    public boolean hasName();

    public boolean hasOptions();
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$FieldDescriptorProtoOrBuilder
extends MessageOrBuilder {
    public String getDefaultValue();

    public ByteString getDefaultValueBytes();

    public String getExtendee();

    public ByteString getExtendeeBytes();

    public String getJsonName();

    public ByteString getJsonNameBytes();

    public DescriptorProtos$FieldDescriptorProto$Label getLabel();

    public String getName();

    public ByteString getNameBytes();

    public int getNumber();

    public int getOneofIndex();

    public DescriptorProtos$FieldOptions getOptions();

    public DescriptorProtos$FieldOptionsOrBuilder getOptionsOrBuilder();

    public DescriptorProtos$FieldDescriptorProto$Type getType();

    public String getTypeName();

    public ByteString getTypeNameBytes();

    public boolean hasDefaultValue();

    public boolean hasExtendee();

    public boolean hasJsonName();

    public boolean hasLabel();

    public boolean hasName();

    public boolean hasNumber();

    public boolean hasOneofIndex();

    public boolean hasOptions();

    public boolean hasType();

    public boolean hasTypeName();
}


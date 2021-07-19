/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.Map;

public interface MessageOrBuilder
extends MessageLiteOrBuilder {
    public List findInitializationErrors();

    public Map getAllFields();

    public Message getDefaultInstanceForType();

    public Descriptors$Descriptor getDescriptorForType();

    public Object getField(Descriptors$FieldDescriptor var1);

    public String getInitializationErrorString();

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1);

    public Object getRepeatedField(Descriptors$FieldDescriptor var1, int var2);

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor var1);

    public UnknownFieldSet getUnknownFields();

    public boolean hasField(Descriptors$FieldDescriptor var1);

    public boolean hasOneof(Descriptors$OneofDescriptor var1);
}


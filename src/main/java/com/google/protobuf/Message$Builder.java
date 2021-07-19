/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;

public interface Message$Builder
extends MessageLite$Builder,
MessageOrBuilder {
    public Message$Builder addRepeatedField(Descriptors$FieldDescriptor var1, Object var2);

    public Message build();

    public Message buildPartial();

    public Message$Builder clear();

    public Message$Builder clearField(Descriptors$FieldDescriptor var1);

    public Message$Builder clearOneof(Descriptors$OneofDescriptor var1);

    public Message$Builder clone();

    public Descriptors$Descriptor getDescriptorForType();

    public Message$Builder getFieldBuilder(Descriptors$FieldDescriptor var1);

    public Message$Builder getRepeatedFieldBuilder(Descriptors$FieldDescriptor var1, int var2);

    public boolean mergeDelimitedFrom(InputStream var1);

    public boolean mergeDelimitedFrom(InputStream var1, ExtensionRegistryLite var2);

    public Message$Builder mergeFrom(ByteString var1);

    public Message$Builder mergeFrom(ByteString var1, ExtensionRegistryLite var2);

    public Message$Builder mergeFrom(CodedInputStream var1);

    public Message$Builder mergeFrom(CodedInputStream var1, ExtensionRegistryLite var2);

    public Message$Builder mergeFrom(Message var1);

    public Message$Builder mergeFrom(InputStream var1);

    public Message$Builder mergeFrom(InputStream var1, ExtensionRegistryLite var2);

    public Message$Builder mergeFrom(byte[] var1);

    public Message$Builder mergeFrom(byte[] var1, int var2, int var3);

    public Message$Builder mergeFrom(byte[] var1, int var2, int var3, ExtensionRegistryLite var4);

    public Message$Builder mergeFrom(byte[] var1, ExtensionRegistryLite var2);

    public Message$Builder mergeUnknownFields(UnknownFieldSet var1);

    public Message$Builder newBuilderForField(Descriptors$FieldDescriptor var1);

    public Message$Builder setField(Descriptors$FieldDescriptor var1, Object var2);

    public Message$Builder setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3);

    public Message$Builder setUnknownFields(UnknownFieldSet var1);
}


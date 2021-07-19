/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Message;
import com.google.protobuf.MessageReflection$MergeTarget$ContainerType;
import com.google.protobuf.WireFormat$Utf8Validation;

public interface MessageReflection$MergeTarget {
    public MessageReflection$MergeTarget addRepeatedField(Descriptors$FieldDescriptor var1, Object var2);

    public MessageReflection$MergeTarget clearField(Descriptors$FieldDescriptor var1);

    public MessageReflection$MergeTarget clearOneof(Descriptors$OneofDescriptor var1);

    public ExtensionRegistry$ExtensionInfo findExtensionByName(ExtensionRegistry var1, String var2);

    public ExtensionRegistry$ExtensionInfo findExtensionByNumber(ExtensionRegistry var1, Descriptors$Descriptor var2, int var3);

    public Object finish();

    public MessageReflection$MergeTarget$ContainerType getContainerType();

    public Descriptors$Descriptor getDescriptorForType();

    public Object getField(Descriptors$FieldDescriptor var1);

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor var1);

    public WireFormat$Utf8Validation getUtf8Validation(Descriptors$FieldDescriptor var1);

    public boolean hasField(Descriptors$FieldDescriptor var1);

    public boolean hasOneof(Descriptors$OneofDescriptor var1);

    public MessageReflection$MergeTarget newEmptyTargetForField(Descriptors$FieldDescriptor var1, Message var2);

    public MessageReflection$MergeTarget newMergeTargetForField(Descriptors$FieldDescriptor var1, Message var2);

    public Object parseGroup(CodedInputStream var1, ExtensionRegistryLite var2, Descriptors$FieldDescriptor var3, Message var4);

    public Object parseMessage(CodedInputStream var1, ExtensionRegistryLite var2, Descriptors$FieldDescriptor var3, Message var4);

    public Object parseMessageFromBytes(ByteString var1, ExtensionRegistryLite var2, Descriptors$FieldDescriptor var3, Message var4);

    public MessageReflection$MergeTarget setField(Descriptors$FieldDescriptor var1, Object var2);

    public MessageReflection$MergeTarget setRepeatedField(Descriptors$FieldDescriptor var1, int var2, Object var3);
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

public final class GeneratedMessageLite$ExtensionDescriptor
implements FieldSet$FieldDescriptorLite {
    public final Internal$EnumLiteMap enumTypeMap;
    public final boolean isPacked;
    public final boolean isRepeated;
    public final int number;
    public final WireFormat$FieldType type;

    public GeneratedMessageLite$ExtensionDescriptor(Internal$EnumLiteMap internal$EnumLiteMap, int n10, WireFormat$FieldType wireFormat$FieldType, boolean bl2, boolean bl3) {
        this.enumTypeMap = internal$EnumLiteMap;
        this.number = n10;
        this.type = wireFormat$FieldType;
        this.isRepeated = bl2;
        this.isPacked = bl3;
    }

    public int compareTo(GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor) {
        int n10 = this.number;
        int n11 = generatedMessageLite$ExtensionDescriptor.number;
        return n10 - n11;
    }

    public Internal$EnumLiteMap getEnumType() {
        return this.enumTypeMap;
    }

    public WireFormat$JavaType getLiteJavaType() {
        return this.type.getJavaType();
    }

    public WireFormat$FieldType getLiteType() {
        return this.type;
    }

    public int getNumber() {
        return this.number;
    }

    public MessageLite$Builder internalMergeFrom(MessageLite$Builder messageLite$Builder, MessageLite messageLite) {
        messageLite$Builder = (GeneratedMessageLite$Builder)messageLite$Builder;
        messageLite = (GeneratedMessageLite)messageLite;
        return ((GeneratedMessageLite$Builder)messageLite$Builder).mergeFrom((GeneratedMessageLite)messageLite);
    }

    public boolean isPacked() {
        return this.isPacked;
    }

    public boolean isRepeated() {
        return this.isRepeated;
    }
}


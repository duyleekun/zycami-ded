/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

public interface FieldSet$FieldDescriptorLite
extends Comparable {
    public Internal$EnumLiteMap getEnumType();

    public WireFormat$JavaType getLiteJavaType();

    public WireFormat$FieldType getLiteType();

    public int getNumber();

    public MessageLite$Builder internalMergeFrom(MessageLite$Builder var1, MessageLite var2);

    public boolean isPacked();

    public boolean isRepeated();
}


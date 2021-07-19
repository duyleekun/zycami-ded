/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLite;

public interface ProtocolMessageEnum
extends Internal$EnumLite {
    public Descriptors$EnumDescriptor getDescriptorForType();

    public int getNumber();

    public Descriptors$EnumValueDescriptor getValueDescriptor();
}


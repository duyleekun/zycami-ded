/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Extension$ExtensionType;
import com.google.protobuf.Extension$MessageType;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.Message;

public abstract class Extension
extends ExtensionLite {
    public abstract Object fromReflectionType(Object var1);

    public abstract Descriptors$FieldDescriptor getDescriptor();

    public abstract Extension$ExtensionType getExtensionType();

    public abstract Message getMessageDefaultInstance();

    public Extension$MessageType getMessageType() {
        return Extension$MessageType.PROTO2;
    }

    public final boolean isLite() {
        return false;
    }

    public abstract Object singularFromReflectionType(Object var1);

    public abstract Object singularToReflectionType(Object var1);

    public abstract Object toReflectionType(Object var1);
}


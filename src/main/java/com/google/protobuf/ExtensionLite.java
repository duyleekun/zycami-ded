/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$FieldType;

public abstract class ExtensionLite {
    public abstract Object getDefaultValue();

    public abstract WireFormat$FieldType getLiteType();

    public abstract MessageLite getMessageDefaultInstance();

    public abstract int getNumber();

    public boolean isLite() {
        return true;
    }

    public abstract boolean isRepeated();
}


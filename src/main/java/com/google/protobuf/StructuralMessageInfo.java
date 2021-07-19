/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.FieldInfo;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageInfo;
import com.google.protobuf.MessageLite;
import com.google.protobuf.ProtoSyntax;
import com.google.protobuf.StructuralMessageInfo$Builder;

public final class StructuralMessageInfo
implements MessageInfo {
    private final int[] checkInitialized;
    private final MessageLite defaultInstance;
    private final FieldInfo[] fields;
    private final boolean messageSetWireFormat;
    private final ProtoSyntax syntax;

    public StructuralMessageInfo(ProtoSyntax object, boolean bl2, int[] nArray, FieldInfo[] fieldInfoArray, Object object2) {
        this.syntax = object;
        this.messageSetWireFormat = bl2;
        this.checkInitialized = nArray;
        this.fields = fieldInfoArray;
        object = (MessageLite)Internal.checkNotNull(object2, "defaultInstance");
        this.defaultInstance = object;
    }

    public static StructuralMessageInfo$Builder newBuilder() {
        StructuralMessageInfo$Builder structuralMessageInfo$Builder = new StructuralMessageInfo$Builder();
        return structuralMessageInfo$Builder;
    }

    public static StructuralMessageInfo$Builder newBuilder(int n10) {
        StructuralMessageInfo$Builder structuralMessageInfo$Builder = new StructuralMessageInfo$Builder(n10);
        return structuralMessageInfo$Builder;
    }

    public int[] getCheckInitialized() {
        return this.checkInitialized;
    }

    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public FieldInfo[] getFields() {
        return this.fields;
    }

    public ProtoSyntax getSyntax() {
        return this.syntax;
    }

    public boolean isMessageSetWireFormat() {
        return this.messageSetWireFormat;
    }
}


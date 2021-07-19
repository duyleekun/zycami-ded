/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldMask;

public final class FieldMask$1
extends AbstractParser {
    public FieldMask parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        FieldMask fieldMask = new FieldMask(codedInputStream, extensionRegistryLite, null);
        return fieldMask;
    }
}


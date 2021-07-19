/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.BoolValue;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class BoolValue$1
extends AbstractParser {
    public BoolValue parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BoolValue boolValue = new BoolValue(codedInputStream, extensionRegistryLite, null);
        return boolValue;
    }
}


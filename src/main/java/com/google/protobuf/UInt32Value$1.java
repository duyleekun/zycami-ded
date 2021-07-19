/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.UInt32Value;

public final class UInt32Value$1
extends AbstractParser {
    public UInt32Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        UInt32Value uInt32Value = new UInt32Value(codedInputStream, extensionRegistryLite, null);
        return uInt32Value;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.UInt64Value;

public final class UInt64Value$1
extends AbstractParser {
    public UInt64Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        UInt64Value uInt64Value = new UInt64Value(codedInputStream, extensionRegistryLite, null);
        return uInt64Value;
    }
}


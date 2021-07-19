/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Int64Value;

public final class Int64Value$1
extends AbstractParser {
    public Int64Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Int64Value int64Value = new Int64Value(codedInputStream, extensionRegistryLite, null);
        return int64Value;
    }
}


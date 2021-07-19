/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Int32Value;

public final class Int32Value$1
extends AbstractParser {
    public Int32Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Int32Value int32Value = new Int32Value(codedInputStream, extensionRegistryLite, null);
        return int32Value;
    }
}


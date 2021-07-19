/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.BytesValue;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class BytesValue$1
extends AbstractParser {
    public BytesValue parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        BytesValue bytesValue = new BytesValue(codedInputStream, extensionRegistryLite, null);
        return bytesValue;
    }
}


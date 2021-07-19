/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.StringValue;

public final class StringValue$1
extends AbstractParser {
    public StringValue parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        StringValue stringValue = new StringValue(codedInputStream, extensionRegistryLite, null);
        return stringValue;
    }
}


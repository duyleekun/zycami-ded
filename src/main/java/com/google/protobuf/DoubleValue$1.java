/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.ExtensionRegistryLite;

public final class DoubleValue$1
extends AbstractParser {
    public DoubleValue parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DoubleValue doubleValue = new DoubleValue(codedInputStream, extensionRegistryLite, null);
        return doubleValue;
    }
}


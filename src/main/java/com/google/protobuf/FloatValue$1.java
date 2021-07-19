/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FloatValue;

public final class FloatValue$1
extends AbstractParser {
    public FloatValue parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        FloatValue floatValue = new FloatValue(codedInputStream, extensionRegistryLite, null);
        return floatValue;
    }
}


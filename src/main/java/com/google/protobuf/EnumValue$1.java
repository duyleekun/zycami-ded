/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.EnumValue;
import com.google.protobuf.ExtensionRegistryLite;

public final class EnumValue$1
extends AbstractParser {
    public EnumValue parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        EnumValue enumValue = new EnumValue(codedInputStream, extensionRegistryLite, null);
        return enumValue;
    }
}


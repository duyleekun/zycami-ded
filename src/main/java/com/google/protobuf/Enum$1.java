/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Enum;
import com.google.protobuf.ExtensionRegistryLite;

public final class Enum$1
extends AbstractParser {
    public Enum parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Enum enum_ = new Enum(codedInputStream, extensionRegistryLite, null);
        return enum_;
    }
}


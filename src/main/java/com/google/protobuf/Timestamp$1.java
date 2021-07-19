/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Timestamp;

public final class Timestamp$1
extends AbstractParser {
    public Timestamp parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Timestamp timestamp = new Timestamp(codedInputStream, extensionRegistryLite, null);
        return timestamp;
    }
}


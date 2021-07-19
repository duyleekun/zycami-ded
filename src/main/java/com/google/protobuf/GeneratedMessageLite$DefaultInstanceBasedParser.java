/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;

public class GeneratedMessageLite$DefaultInstanceBasedParser
extends AbstractParser {
    private final GeneratedMessageLite defaultInstance;

    public GeneratedMessageLite$DefaultInstanceBasedParser(GeneratedMessageLite generatedMessageLite) {
        this.defaultInstance = generatedMessageLite;
    }

    public GeneratedMessageLite parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, codedInputStream, extensionRegistryLite);
    }

    public GeneratedMessageLite parsePartialFrom(byte[] byArray, int n10, int n11, ExtensionRegistryLite extensionRegistryLite) {
        return GeneratedMessageLite.parsePartialFrom(this.defaultInstance, byArray, n10, n11, extensionRegistryLite);
    }
}


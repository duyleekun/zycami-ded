/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.SourceContext;

public final class SourceContext$1
extends AbstractParser {
    public SourceContext parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        SourceContext sourceContext = new SourceContext(codedInputStream, extensionRegistryLite, null);
        return sourceContext;
    }
}


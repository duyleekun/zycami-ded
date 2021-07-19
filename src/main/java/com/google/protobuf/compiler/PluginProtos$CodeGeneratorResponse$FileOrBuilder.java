/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface PluginProtos$CodeGeneratorResponse$FileOrBuilder
extends MessageOrBuilder {
    public String getContent();

    public ByteString getContentBytes();

    public String getInsertionPoint();

    public ByteString getInsertionPointBytes();

    public String getName();

    public ByteString getNameBytes();

    public boolean hasContent();

    public boolean hasInsertionPoint();

    public boolean hasName();
}


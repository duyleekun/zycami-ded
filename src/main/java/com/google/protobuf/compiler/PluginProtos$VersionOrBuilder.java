/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface PluginProtos$VersionOrBuilder
extends MessageOrBuilder {
    public int getMajor();

    public int getMinor();

    public int getPatch();

    public String getSuffix();

    public ByteString getSuffixBytes();

    public boolean hasMajor();

    public boolean hasMinor();

    public boolean hasPatch();

    public boolean hasSuffix();
}


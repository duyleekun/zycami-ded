/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.compiler.PluginProtos$Version;

public final class PluginProtos$Version$1
extends AbstractParser {
    public PluginProtos$Version parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        PluginProtos$Version pluginProtos$Version = new PluginProtos$Version(codedInputStream, extensionRegistryLite, null);
        return pluginProtos$Version;
    }
}


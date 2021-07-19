/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorRequest;

public final class PluginProtos$CodeGeneratorRequest$1
extends AbstractParser {
    public PluginProtos$CodeGeneratorRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        PluginProtos$CodeGeneratorRequest pluginProtos$CodeGeneratorRequest = new PluginProtos$CodeGeneratorRequest(codedInputStream, extensionRegistryLite, null);
        return pluginProtos$CodeGeneratorRequest;
    }
}


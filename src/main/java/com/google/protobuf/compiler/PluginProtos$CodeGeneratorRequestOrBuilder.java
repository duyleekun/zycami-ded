/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProtoOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.compiler.PluginProtos$Version;
import com.google.protobuf.compiler.PluginProtos$VersionOrBuilder;
import java.util.List;

public interface PluginProtos$CodeGeneratorRequestOrBuilder
extends MessageOrBuilder {
    public PluginProtos.Version getCompilerVersion();

    public PluginProtos.VersionOrBuilder getCompilerVersionOrBuilder();

    public String getFileToGenerate(int var1);

    public ByteString getFileToGenerateBytes(int var1);

    public int getFileToGenerateCount();

    public List getFileToGenerateList();

    public String getParameter();

    public ByteString getParameterBytes();

    public DescriptorProtos$FileDescriptorProto getProtoFile(int var1);

    public int getProtoFileCount();

    public List getProtoFileList();

    public DescriptorProtos$FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int var1);

    public List getProtoFileOrBuilderList();

    public boolean hasCompilerVersion();

    public boolean hasParameter();
}


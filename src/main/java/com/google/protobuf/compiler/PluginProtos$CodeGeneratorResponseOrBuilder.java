/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$FileOrBuilder;
import java.util.List;

public interface PluginProtos$CodeGeneratorResponseOrBuilder
extends MessageOrBuilder {
    public String getError();

    public ByteString getErrorBytes();

    public PluginProtos$CodeGeneratorResponse$File getFile(int var1);

    public int getFileCount();

    public List getFileList();

    public PluginProtos$CodeGeneratorResponse$FileOrBuilder getFileOrBuilder(int var1);

    public List getFileOrBuilderList();

    public boolean hasError();
}


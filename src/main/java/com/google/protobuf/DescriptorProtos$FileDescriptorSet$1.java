/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos$FileDescriptorSet;
import com.google.protobuf.ExtensionRegistryLite;

public final class DescriptorProtos$FileDescriptorSet$1
extends AbstractParser {
    public DescriptorProtos$FileDescriptorSet parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        DescriptorProtos$FileDescriptorSet descriptorProtos$FileDescriptorSet = new DescriptorProtos$FileDescriptorSet(codedInputStream, extensionRegistryLite, null);
        return descriptorProtos$FileDescriptorSet;
    }
}


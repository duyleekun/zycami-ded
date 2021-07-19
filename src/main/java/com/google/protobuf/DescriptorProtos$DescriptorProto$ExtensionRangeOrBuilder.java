/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$ExtensionRangeOptions;
import com.google.protobuf.DescriptorProtos$ExtensionRangeOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$DescriptorProto$ExtensionRangeOrBuilder
extends MessageOrBuilder {
    public int getEnd();

    public DescriptorProtos.ExtensionRangeOptions getOptions();

    public DescriptorProtos.ExtensionRangeOptionsOrBuilder getOptionsOrBuilder();

    public int getStart();

    public boolean hasEnd();

    public boolean hasOptions();

    public boolean hasStart();
}


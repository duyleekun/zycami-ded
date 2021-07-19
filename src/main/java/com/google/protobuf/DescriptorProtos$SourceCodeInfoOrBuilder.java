/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$SourceCodeInfo$Location;
import com.google.protobuf.DescriptorProtos$SourceCodeInfo$LocationOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$SourceCodeInfoOrBuilder
extends MessageOrBuilder {
    public DescriptorProtos$SourceCodeInfo$Location getLocation(int var1);

    public int getLocationCount();

    public List getLocationList();

    public DescriptorProtos$SourceCodeInfo$LocationOrBuilder getLocationOrBuilder(int var1);

    public List getLocationOrBuilderList();
}


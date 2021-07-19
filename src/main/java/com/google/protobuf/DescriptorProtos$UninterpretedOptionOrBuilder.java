/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePart;
import com.google.protobuf.DescriptorProtos$UninterpretedOption$NamePartOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$UninterpretedOptionOrBuilder
extends MessageOrBuilder {
    public String getAggregateValue();

    public ByteString getAggregateValueBytes();

    public double getDoubleValue();

    public String getIdentifierValue();

    public ByteString getIdentifierValueBytes();

    public DescriptorProtos$UninterpretedOption$NamePart getName(int var1);

    public int getNameCount();

    public List getNameList();

    public DescriptorProtos$UninterpretedOption$NamePartOrBuilder getNameOrBuilder(int var1);

    public List getNameOrBuilderList();

    public long getNegativeIntValue();

    public long getPositiveIntValue();

    public ByteString getStringValue();

    public boolean hasAggregateValue();

    public boolean hasDoubleValue();

    public boolean hasIdentifierValue();

    public boolean hasNegativeIntValue();

    public boolean hasPositiveIntValue();

    public boolean hasStringValue();
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldOptions$CType;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType;
import com.google.protobuf.DescriptorProtos$UninterpretedOption;
import com.google.protobuf.DescriptorProtos$UninterpretedOptionOrBuilder;
import com.google.protobuf.GeneratedMessageV3$ExtendableMessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$FieldOptionsOrBuilder
extends GeneratedMessageV3$ExtendableMessageOrBuilder {
    public DescriptorProtos$FieldOptions$CType getCtype();

    public boolean getDeprecated();

    public DescriptorProtos$FieldOptions$JSType getJstype();

    public boolean getLazy();

    public boolean getPacked();

    public DescriptorProtos$UninterpretedOption getUninterpretedOption(int var1);

    public int getUninterpretedOptionCount();

    public List getUninterpretedOptionList();

    public DescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int var1);

    public List getUninterpretedOptionOrBuilderList();

    public boolean getWeak();

    public boolean hasCtype();

    public boolean hasDeprecated();

    public boolean hasJstype();

    public boolean hasLazy();

    public boolean hasPacked();

    public boolean hasWeak();
}


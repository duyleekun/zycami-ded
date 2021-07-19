/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import java.util.List;

public interface EnumValueOrBuilder
extends MessageOrBuilder {
    public String getName();

    public ByteString getNameBytes();

    public int getNumber();

    public Option getOptions(int var1);

    public int getOptionsCount();

    public List getOptionsList();

    public OptionOrBuilder getOptionsOrBuilder(int var1);

    public List getOptionsOrBuilderList();
}


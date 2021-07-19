/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValueOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Syntax;
import java.util.List;

public interface EnumOrBuilder
extends MessageOrBuilder {
    public EnumValue getEnumvalue(int var1);

    public int getEnumvalueCount();

    public List getEnumvalueList();

    public EnumValueOrBuilder getEnumvalueOrBuilder(int var1);

    public List getEnumvalueOrBuilderList();

    public String getName();

    public ByteString getNameBytes();

    public Option getOptions(int var1);

    public int getOptionsCount();

    public List getOptionsList();

    public OptionOrBuilder getOptionsOrBuilder(int var1);

    public List getOptionsOrBuilderList();

    public SourceContext getSourceContext();

    public SourceContextOrBuilder getSourceContextOrBuilder();

    public Syntax getSyntax();

    public int getSyntaxValue();

    public boolean hasSourceContext();
}


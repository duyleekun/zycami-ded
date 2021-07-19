/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Field;
import com.google.protobuf.FieldOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Syntax;
import java.util.List;

public interface TypeOrBuilder
extends MessageOrBuilder {
    public Field getFields(int var1);

    public int getFieldsCount();

    public List getFieldsList();

    public FieldOrBuilder getFieldsOrBuilder(int var1);

    public List getFieldsOrBuilderList();

    public String getName();

    public ByteString getNameBytes();

    public String getOneofs(int var1);

    public ByteString getOneofsBytes(int var1);

    public int getOneofsCount();

    public List getOneofsList();

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


/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Field$Cardinality;
import com.google.protobuf.Field$Kind;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import java.util.List;

public interface FieldOrBuilder
extends MessageOrBuilder {
    public Field$Cardinality getCardinality();

    public int getCardinalityValue();

    public String getDefaultValue();

    public ByteString getDefaultValueBytes();

    public String getJsonName();

    public ByteString getJsonNameBytes();

    public Field$Kind getKind();

    public int getKindValue();

    public String getName();

    public ByteString getNameBytes();

    public int getNumber();

    public int getOneofIndex();

    public Option getOptions(int var1);

    public int getOptionsCount();

    public List getOptionsList();

    public OptionOrBuilder getOptionsOrBuilder(int var1);

    public List getOptionsOrBuilderList();

    public boolean getPacked();

    public String getTypeUrl();

    public ByteString getTypeUrlBytes();
}


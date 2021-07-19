/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Method;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Mixin;
import com.google.protobuf.MixinOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.Syntax;
import java.util.List;

public interface ApiOrBuilder
extends MessageOrBuilder {
    public Method getMethods(int var1);

    public int getMethodsCount();

    public List getMethodsList();

    public MethodOrBuilder getMethodsOrBuilder(int var1);

    public List getMethodsOrBuilderList();

    public Mixin getMixins(int var1);

    public int getMixinsCount();

    public List getMixinsList();

    public MixinOrBuilder getMixinsOrBuilder(int var1);

    public List getMixinsOrBuilderList();

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

    public String getVersion();

    public ByteString getVersionBytes();

    public boolean hasSourceContext();
}


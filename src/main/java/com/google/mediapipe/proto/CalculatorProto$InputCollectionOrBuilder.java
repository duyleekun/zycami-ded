/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$InputCollection$InputType;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface CalculatorProto$InputCollectionOrBuilder
extends MessageLiteOrBuilder {
    public String getExternalInputName(int var1);

    public ByteString getExternalInputNameBytes(int var1);

    public int getExternalInputNameCount();

    public List getExternalInputNameList();

    public String getFileName();

    public ByteString getFileNameBytes();

    public CalculatorProto$InputCollection$InputType getInputType();

    public int getInputTypeValue();

    public String getName();

    public ByteString getNameBytes();

    public String getSidePacketName(int var1);

    public ByteString getSidePacketNameBytes(int var1);

    public int getSidePacketNameCount();

    public List getSidePacketNameList();
}


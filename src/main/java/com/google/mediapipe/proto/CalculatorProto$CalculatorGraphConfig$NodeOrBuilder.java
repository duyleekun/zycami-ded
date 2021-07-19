/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.google.mediapipe.proto.CalculatorOptionsProto$CalculatorOptions
 *  mediapipe.StreamHandler$InputStreamHandlerConfig
 *  mediapipe.StreamHandler$OutputStreamHandlerConfig
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.proto.CalculatorProto$InputStreamInfo;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;
import mediapipe.StreamHandler;

public interface CalculatorProto$CalculatorGraphConfig$NodeOrBuilder
extends MessageLiteOrBuilder {
    public int getBufferSizeHint();

    public String getCalculator();

    public ByteString getCalculatorBytes();

    public String getExecutor();

    public ByteString getExecutorBytes();

    public String getExternalInput(int var1);

    public ByteString getExternalInputBytes(int var1);

    public int getExternalInputCount();

    public List getExternalInputList();

    public String getInputSidePacket(int var1);

    public ByteString getInputSidePacketBytes(int var1);

    public int getInputSidePacketCount();

    public List getInputSidePacketList();

    public String getInputStream(int var1);

    public ByteString getInputStreamBytes(int var1);

    public int getInputStreamCount();

    public StreamHandler.InputStreamHandlerConfig getInputStreamHandler();

    public CalculatorProto.InputStreamInfo getInputStreamInfo(int var1);

    public int getInputStreamInfoCount();

    public List getInputStreamInfoList();

    public List getInputStreamList();

    public int getMaxInFlight();

    public String getName();

    public ByteString getNameBytes();

    public Any getNodeOptions(int var1);

    public int getNodeOptionsCount();

    public List getNodeOptionsList();

    public CalculatorOptionsProto.CalculatorOptions getOptions();

    public String getOutputSidePacket(int var1);

    public ByteString getOutputSidePacketBytes(int var1);

    public int getOutputSidePacketCount();

    public List getOutputSidePacketList();

    public String getOutputStream(int var1);

    public ByteString getOutputStreamBytes(int var1);

    public int getOutputStreamCount();

    public StreamHandler.OutputStreamHandlerConfig getOutputStreamHandler();

    public List getOutputStreamList();

    public CalculatorProto.ProfilerConfig getProfilerConfig();

    public int getSourceLayer();

    public boolean hasInputStreamHandler();

    public boolean hasOptions();

    public boolean hasOutputStreamHandler();

    public boolean hasProfilerConfig();
}


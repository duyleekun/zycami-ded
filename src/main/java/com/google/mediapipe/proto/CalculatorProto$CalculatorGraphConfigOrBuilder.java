/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  mediapipe.MediapipeOptions$MediaPipeOptions
 *  mediapipe.PacketFactory$PacketFactoryConfig
 *  mediapipe.PacketGenerator$PacketGeneratorConfig
 *  mediapipe.StatusHandler$StatusHandlerConfig
 *  mediapipe.StreamHandler$InputStreamHandlerConfig
 *  mediapipe.StreamHandler$OutputStreamHandlerConfig
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$Node;
import com.google.mediapipe.proto.CalculatorProto$ExecutorConfig;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;
import mediapipe.MediapipeOptions;
import mediapipe.PacketFactory;
import mediapipe.PacketGenerator;
import mediapipe.StatusHandler;
import mediapipe.StreamHandler;

public interface CalculatorProto$CalculatorGraphConfigOrBuilder
extends MessageLiteOrBuilder {
    public CalculatorProto.ExecutorConfig getExecutor(int var1);

    public int getExecutorCount();

    public List getExecutorList();

    public String getInputSidePacket(int var1);

    public ByteString getInputSidePacketBytes(int var1);

    public int getInputSidePacketCount();

    public List getInputSidePacketList();

    public String getInputStream(int var1);

    public ByteString getInputStreamBytes(int var1);

    public int getInputStreamCount();

    public StreamHandler.InputStreamHandlerConfig getInputStreamHandler();

    public List getInputStreamList();

    public int getMaxQueueSize();

    public CalculatorProto$CalculatorGraphConfig$Node getNode(int var1);

    public int getNodeCount();

    public List getNodeList();

    public int getNumThreads();

    public MediapipeOptions.MediaPipeOptions getOptions();

    public String getOutputSidePacket(int var1);

    public ByteString getOutputSidePacketBytes(int var1);

    public int getOutputSidePacketCount();

    public List getOutputSidePacketList();

    public String getOutputStream(int var1);

    public ByteString getOutputStreamBytes(int var1);

    public int getOutputStreamCount();

    public StreamHandler.OutputStreamHandlerConfig getOutputStreamHandler();

    public List getOutputStreamList();

    public String getPackage();

    public ByteString getPackageBytes();

    public PacketFactory.PacketFactoryConfig getPacketFactory(int var1);

    public int getPacketFactoryCount();

    public List getPacketFactoryList();

    public PacketGenerator.PacketGeneratorConfig getPacketGenerator(int var1);

    public int getPacketGeneratorCount();

    public List getPacketGeneratorList();

    public CalculatorProto$ProfilerConfig getProfilerConfig();

    public boolean getReportDeadlock();

    public StatusHandler.StatusHandlerConfig getStatusHandler(int var1);

    public int getStatusHandlerCount();

    public List getStatusHandlerList();

    public String getType();

    public ByteString getTypeBytes();

    public boolean hasInputStreamHandler();

    public boolean hasOptions();

    public boolean hasOutputStreamHandler();

    public boolean hasProfilerConfig();
}


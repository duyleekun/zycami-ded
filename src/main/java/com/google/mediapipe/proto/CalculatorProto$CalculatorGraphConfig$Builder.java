/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  mediapipe.MediapipeOptions$MediaPipeOptions
 *  mediapipe.MediapipeOptions$MediaPipeOptions$Builder
 *  mediapipe.PacketFactory$PacketFactoryConfig
 *  mediapipe.PacketFactory$PacketFactoryConfig$Builder
 *  mediapipe.PacketGenerator$PacketGeneratorConfig
 *  mediapipe.PacketGenerator$PacketGeneratorConfig$Builder
 *  mediapipe.StatusHandler$StatusHandlerConfig
 *  mediapipe.StatusHandler$StatusHandlerConfig$Builder
 *  mediapipe.StreamHandler$InputStreamHandlerConfig
 *  mediapipe.StreamHandler$InputStreamHandlerConfig$Builder
 *  mediapipe.StreamHandler$OutputStreamHandlerConfig
 *  mediapipe.StreamHandler$OutputStreamHandlerConfig$Builder
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$Node;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$Node$Builder;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfigOrBuilder;
import com.google.mediapipe.proto.CalculatorProto$ExecutorConfig;
import com.google.mediapipe.proto.CalculatorProto$ExecutorConfig$Builder;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;
import mediapipe.MediapipeOptions;
import mediapipe.PacketFactory;
import mediapipe.PacketGenerator;
import mediapipe.StatusHandler;
import mediapipe.StreamHandler;

public final class CalculatorProto$CalculatorGraphConfig$Builder
extends GeneratedMessageLite$Builder
implements CalculatorProto$CalculatorGraphConfigOrBuilder {
    private CalculatorProto$CalculatorGraphConfig$Builder() {
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = CalculatorProto$CalculatorGraphConfig.access$15000();
        super(calculatorProto$CalculatorGraphConfig);
    }

    public /* synthetic */ CalculatorProto$CalculatorGraphConfig$Builder(CalculatorProto$1 calculatorProto$1) {
        this();
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addAllExecutor(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$21000((CalculatorProto$CalculatorGraphConfig)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addAllInputSidePacket(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$18900((CalculatorProto$CalculatorGraphConfig)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addAllInputStream(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$17900((CalculatorProto$CalculatorGraphConfig)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addAllNode(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$15400((CalculatorProto$CalculatorGraphConfig)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addAllOutputSidePacket(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$19400((CalculatorProto$CalculatorGraphConfig)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addAllOutputStream(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$18400((CalculatorProto$CalculatorGraphConfig)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addAllPacketFactory(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$16000((CalculatorProto$CalculatorGraphConfig)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addAllPacketGenerator(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$16600((CalculatorProto$CalculatorGraphConfig)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addAllStatusHandler(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$17400((CalculatorProto$CalculatorGraphConfig)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addExecutor(int n10, CalculatorProto$ExecutorConfig$Builder calculatorProto$ExecutorConfigOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        calculatorProto$ExecutorConfigOrBuilder = (CalculatorProto$ExecutorConfig)calculatorProto$ExecutorConfigOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig.access$20900(calculatorProto$CalculatorGraphConfig, n10, (CalculatorProto$ExecutorConfig)calculatorProto$ExecutorConfigOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addExecutor(int n10, CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$20900((CalculatorProto$CalculatorGraphConfig)this.instance, n10, calculatorProto$ExecutorConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addExecutor(CalculatorProto$ExecutorConfig$Builder calculatorProto$ExecutorConfigOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        calculatorProto$ExecutorConfigOrBuilder = (CalculatorProto$ExecutorConfig)calculatorProto$ExecutorConfigOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig.access$20800(calculatorProto$CalculatorGraphConfig, (CalculatorProto$ExecutorConfig)calculatorProto$ExecutorConfigOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addExecutor(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$20800((CalculatorProto$CalculatorGraphConfig)this.instance, calculatorProto$ExecutorConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addInputSidePacket(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$18800((CalculatorProto$CalculatorGraphConfig)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addInputSidePacketBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$19100((CalculatorProto$CalculatorGraphConfig)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addInputStream(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$17800((CalculatorProto$CalculatorGraphConfig)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addInputStreamBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$18100((CalculatorProto$CalculatorGraphConfig)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addNode(int n10, CalculatorProto$CalculatorGraphConfig$Node$Builder calculatorProto$CalculatorGraphConfig$NodeOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        calculatorProto$CalculatorGraphConfig$NodeOrBuilder = (CalculatorProto$CalculatorGraphConfig$Node)calculatorProto$CalculatorGraphConfig$NodeOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig.access$15300(calculatorProto$CalculatorGraphConfig, n10, (CalculatorProto$CalculatorGraphConfig$Node)calculatorProto$CalculatorGraphConfig$NodeOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addNode(int n10, CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$15300((CalculatorProto$CalculatorGraphConfig)this.instance, n10, calculatorProto$CalculatorGraphConfig$Node);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addNode(CalculatorProto$CalculatorGraphConfig$Node$Builder calculatorProto$CalculatorGraphConfig$NodeOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        calculatorProto$CalculatorGraphConfig$NodeOrBuilder = (CalculatorProto$CalculatorGraphConfig$Node)calculatorProto$CalculatorGraphConfig$NodeOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig.access$15200(calculatorProto$CalculatorGraphConfig, (CalculatorProto$CalculatorGraphConfig$Node)calculatorProto$CalculatorGraphConfig$NodeOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addNode(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$15200((CalculatorProto$CalculatorGraphConfig)this.instance, calculatorProto$CalculatorGraphConfig$Node);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addOutputSidePacket(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$19300((CalculatorProto$CalculatorGraphConfig)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addOutputSidePacketBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$19600((CalculatorProto$CalculatorGraphConfig)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addOutputStream(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$18300((CalculatorProto$CalculatorGraphConfig)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addOutputStreamBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$18600((CalculatorProto$CalculatorGraphConfig)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addPacketFactory(int n10, PacketFactory.PacketFactoryConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (PacketFactory.PacketFactoryConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$15900(calculatorProto$CalculatorGraphConfig, n10, (PacketFactory.PacketFactoryConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addPacketFactory(int n10, PacketFactory.PacketFactoryConfig packetFactoryConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$15900((CalculatorProto$CalculatorGraphConfig)this.instance, n10, packetFactoryConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addPacketFactory(PacketFactory.PacketFactoryConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (PacketFactory.PacketFactoryConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$15800(calculatorProto$CalculatorGraphConfig, (PacketFactory.PacketFactoryConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addPacketFactory(PacketFactory.PacketFactoryConfig packetFactoryConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$15800((CalculatorProto$CalculatorGraphConfig)this.instance, packetFactoryConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addPacketGenerator(int n10, PacketGenerator.PacketGeneratorConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (PacketGenerator.PacketGeneratorConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$16500(calculatorProto$CalculatorGraphConfig, n10, (PacketGenerator.PacketGeneratorConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addPacketGenerator(int n10, PacketGenerator.PacketGeneratorConfig packetGeneratorConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$16500((CalculatorProto$CalculatorGraphConfig)this.instance, n10, packetGeneratorConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addPacketGenerator(PacketGenerator.PacketGeneratorConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (PacketGenerator.PacketGeneratorConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$16400(calculatorProto$CalculatorGraphConfig, (PacketGenerator.PacketGeneratorConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addPacketGenerator(PacketGenerator.PacketGeneratorConfig packetGeneratorConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$16400((CalculatorProto$CalculatorGraphConfig)this.instance, packetGeneratorConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addStatusHandler(int n10, StatusHandler.StatusHandlerConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (StatusHandler.StatusHandlerConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$17300(calculatorProto$CalculatorGraphConfig, n10, (StatusHandler.StatusHandlerConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addStatusHandler(int n10, StatusHandler.StatusHandlerConfig statusHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$17300((CalculatorProto$CalculatorGraphConfig)this.instance, n10, statusHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addStatusHandler(StatusHandler.StatusHandlerConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (StatusHandler.StatusHandlerConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$17200(calculatorProto$CalculatorGraphConfig, (StatusHandler.StatusHandlerConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder addStatusHandler(StatusHandler.StatusHandlerConfig statusHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$17200((CalculatorProto$CalculatorGraphConfig)this.instance, statusHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearExecutor() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$21100((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearInputSidePacket() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$19000((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearInputStream() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$18000((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearInputStreamHandler() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$20300((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearMaxQueueSize() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$19800((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearNode() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$15500((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearNumThreads() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$17000((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearOptions() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$22400((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearOutputSidePacket() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$19500((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearOutputStream() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$18500((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearOutputStreamHandler() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$20600((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearPackage() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$21700((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearPacketFactory() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$16100((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearPacketGenerator() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$16700((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearProfilerConfig() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$21500((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearReportDeadlock() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$20000((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearStatusHandler() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$17500((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder clearType() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$22000((CalculatorProto$CalculatorGraphConfig)this.instance);
        return this;
    }

    public CalculatorProto$ExecutorConfig getExecutor(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getExecutor(n10);
    }

    public int getExecutorCount() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getExecutorCount();
    }

    public List getExecutorList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig)this.instance).getExecutorList());
    }

    public String getInputSidePacket(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getInputSidePacket(n10);
    }

    public ByteString getInputSidePacketBytes(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getInputSidePacketBytes(n10);
    }

    public int getInputSidePacketCount() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getInputSidePacketCount();
    }

    public List getInputSidePacketList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig)this.instance).getInputSidePacketList());
    }

    public String getInputStream(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getInputStream(n10);
    }

    public ByteString getInputStreamBytes(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getInputStreamBytes(n10);
    }

    public int getInputStreamCount() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getInputStreamCount();
    }

    public StreamHandler.InputStreamHandlerConfig getInputStreamHandler() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getInputStreamHandler();
    }

    public List getInputStreamList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig)this.instance).getInputStreamList());
    }

    public int getMaxQueueSize() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getMaxQueueSize();
    }

    public CalculatorProto$CalculatorGraphConfig$Node getNode(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getNode(n10);
    }

    public int getNodeCount() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getNodeCount();
    }

    public List getNodeList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig)this.instance).getNodeList());
    }

    public int getNumThreads() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getNumThreads();
    }

    public MediapipeOptions.MediaPipeOptions getOptions() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getOptions();
    }

    public String getOutputSidePacket(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getOutputSidePacket(n10);
    }

    public ByteString getOutputSidePacketBytes(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getOutputSidePacketBytes(n10);
    }

    public int getOutputSidePacketCount() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getOutputSidePacketCount();
    }

    public List getOutputSidePacketList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig)this.instance).getOutputSidePacketList());
    }

    public String getOutputStream(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getOutputStream(n10);
    }

    public ByteString getOutputStreamBytes(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getOutputStreamBytes(n10);
    }

    public int getOutputStreamCount() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getOutputStreamCount();
    }

    public StreamHandler.OutputStreamHandlerConfig getOutputStreamHandler() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getOutputStreamHandler();
    }

    public List getOutputStreamList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig)this.instance).getOutputStreamList());
    }

    public String getPackage() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getPackage();
    }

    public ByteString getPackageBytes() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getPackageBytes();
    }

    public PacketFactory.PacketFactoryConfig getPacketFactory(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getPacketFactory(n10);
    }

    public int getPacketFactoryCount() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getPacketFactoryCount();
    }

    public List getPacketFactoryList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig)this.instance).getPacketFactoryList());
    }

    public PacketGenerator.PacketGeneratorConfig getPacketGenerator(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getPacketGenerator(n10);
    }

    public int getPacketGeneratorCount() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getPacketGeneratorCount();
    }

    public List getPacketGeneratorList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig)this.instance).getPacketGeneratorList());
    }

    public CalculatorProto$ProfilerConfig getProfilerConfig() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getProfilerConfig();
    }

    public boolean getReportDeadlock() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getReportDeadlock();
    }

    public StatusHandler.StatusHandlerConfig getStatusHandler(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getStatusHandler(n10);
    }

    public int getStatusHandlerCount() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getStatusHandlerCount();
    }

    public List getStatusHandlerList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig)this.instance).getStatusHandlerList());
    }

    public String getType() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getType();
    }

    public ByteString getTypeBytes() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).getTypeBytes();
    }

    public boolean hasInputStreamHandler() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).hasInputStreamHandler();
    }

    public boolean hasOptions() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).hasOptions();
    }

    public boolean hasOutputStreamHandler() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).hasOutputStreamHandler();
    }

    public boolean hasProfilerConfig() {
        return ((CalculatorProto$CalculatorGraphConfig)this.instance).hasProfilerConfig();
    }

    public CalculatorProto$CalculatorGraphConfig$Builder mergeInputStreamHandler(StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$20200((CalculatorProto$CalculatorGraphConfig)this.instance, inputStreamHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder mergeOptions(MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$22300((CalculatorProto$CalculatorGraphConfig)this.instance, mediaPipeOptions);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder mergeOutputStreamHandler(StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$20500((CalculatorProto$CalculatorGraphConfig)this.instance, outputStreamHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder mergeProfilerConfig(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$21400((CalculatorProto$CalculatorGraphConfig)this.instance, calculatorProto$ProfilerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder removeExecutor(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$21200((CalculatorProto$CalculatorGraphConfig)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder removeNode(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$15600((CalculatorProto$CalculatorGraphConfig)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder removePacketFactory(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$16200((CalculatorProto$CalculatorGraphConfig)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder removePacketGenerator(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$16800((CalculatorProto$CalculatorGraphConfig)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder removeStatusHandler(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$17600((CalculatorProto$CalculatorGraphConfig)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setExecutor(int n10, CalculatorProto$ExecutorConfig$Builder calculatorProto$ExecutorConfigOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        calculatorProto$ExecutorConfigOrBuilder = (CalculatorProto$ExecutorConfig)calculatorProto$ExecutorConfigOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig.access$20700(calculatorProto$CalculatorGraphConfig, n10, (CalculatorProto$ExecutorConfig)calculatorProto$ExecutorConfigOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setExecutor(int n10, CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$20700((CalculatorProto$CalculatorGraphConfig)this.instance, n10, calculatorProto$ExecutorConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setInputSidePacket(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$18700((CalculatorProto$CalculatorGraphConfig)this.instance, n10, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setInputStream(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$17700((CalculatorProto$CalculatorGraphConfig)this.instance, n10, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setInputStreamHandler(StreamHandler.InputStreamHandlerConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (StreamHandler.InputStreamHandlerConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$20100(calculatorProto$CalculatorGraphConfig, (StreamHandler.InputStreamHandlerConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setInputStreamHandler(StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$20100((CalculatorProto$CalculatorGraphConfig)this.instance, inputStreamHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setMaxQueueSize(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$19700((CalculatorProto$CalculatorGraphConfig)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setNode(int n10, CalculatorProto$CalculatorGraphConfig$Node$Builder calculatorProto$CalculatorGraphConfig$NodeOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        calculatorProto$CalculatorGraphConfig$NodeOrBuilder = (CalculatorProto$CalculatorGraphConfig$Node)calculatorProto$CalculatorGraphConfig$NodeOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig.access$15100(calculatorProto$CalculatorGraphConfig, n10, (CalculatorProto$CalculatorGraphConfig$Node)calculatorProto$CalculatorGraphConfig$NodeOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setNode(int n10, CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$15100((CalculatorProto$CalculatorGraphConfig)this.instance, n10, calculatorProto$CalculatorGraphConfig$Node);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setNumThreads(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$16900((CalculatorProto$CalculatorGraphConfig)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setOptions(MediapipeOptions.MediaPipeOptions.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (MediapipeOptions.MediaPipeOptions)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$22200(calculatorProto$CalculatorGraphConfig, (MediapipeOptions.MediaPipeOptions)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setOptions(MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$22200((CalculatorProto$CalculatorGraphConfig)this.instance, mediaPipeOptions);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setOutputSidePacket(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$19200((CalculatorProto$CalculatorGraphConfig)this.instance, n10, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setOutputStream(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$18200((CalculatorProto$CalculatorGraphConfig)this.instance, n10, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setOutputStreamHandler(StreamHandler.OutputStreamHandlerConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (StreamHandler.OutputStreamHandlerConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$20400(calculatorProto$CalculatorGraphConfig, (StreamHandler.OutputStreamHandlerConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setOutputStreamHandler(StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$20400((CalculatorProto$CalculatorGraphConfig)this.instance, outputStreamHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setPackage(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$21600((CalculatorProto$CalculatorGraphConfig)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setPackageBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$21800((CalculatorProto$CalculatorGraphConfig)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setPacketFactory(int n10, PacketFactory.PacketFactoryConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (PacketFactory.PacketFactoryConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$15700(calculatorProto$CalculatorGraphConfig, n10, (PacketFactory.PacketFactoryConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setPacketFactory(int n10, PacketFactory.PacketFactoryConfig packetFactoryConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$15700((CalculatorProto$CalculatorGraphConfig)this.instance, n10, packetFactoryConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setPacketGenerator(int n10, PacketGenerator.PacketGeneratorConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (PacketGenerator.PacketGeneratorConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$16300(calculatorProto$CalculatorGraphConfig, n10, (PacketGenerator.PacketGeneratorConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setPacketGenerator(int n10, PacketGenerator.PacketGeneratorConfig packetGeneratorConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$16300((CalculatorProto$CalculatorGraphConfig)this.instance, n10, packetGeneratorConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setProfilerConfig(CalculatorProto$ProfilerConfig$Builder calculatorProto$ProfilerConfigOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        calculatorProto$ProfilerConfigOrBuilder = (CalculatorProto$ProfilerConfig)calculatorProto$ProfilerConfigOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig.access$21300(calculatorProto$CalculatorGraphConfig, (CalculatorProto$ProfilerConfig)calculatorProto$ProfilerConfigOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setProfilerConfig(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$21300((CalculatorProto$CalculatorGraphConfig)this.instance, calculatorProto$ProfilerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setReportDeadlock(boolean bl2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$19900((CalculatorProto$CalculatorGraphConfig)this.instance, bl2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setStatusHandler(int n10, StatusHandler.StatusHandlerConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig = (CalculatorProto$CalculatorGraphConfig)this.instance;
        builder = (StatusHandler.StatusHandlerConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig.access$17100(calculatorProto$CalculatorGraphConfig, n10, (StatusHandler.StatusHandlerConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setStatusHandler(int n10, StatusHandler.StatusHandlerConfig statusHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$17100((CalculatorProto$CalculatorGraphConfig)this.instance, n10, statusHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setType(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$21900((CalculatorProto$CalculatorGraphConfig)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Builder setTypeBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig.access$22100((CalculatorProto$CalculatorGraphConfig)this.instance, byteString);
        return this;
    }
}


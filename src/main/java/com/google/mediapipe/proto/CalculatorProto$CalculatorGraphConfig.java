/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  mediapipe.MediapipeOptions$MediaPipeOptions
 *  mediapipe.MediapipeOptions$MediaPipeOptions$Builder
 *  mediapipe.PacketFactory$PacketFactoryConfig
 *  mediapipe.PacketFactory$PacketFactoryConfigOrBuilder
 *  mediapipe.PacketGenerator$PacketGeneratorConfig
 *  mediapipe.PacketGenerator$PacketGeneratorConfigOrBuilder
 *  mediapipe.StatusHandler$StatusHandlerConfig
 *  mediapipe.StatusHandler$StatusHandlerConfigOrBuilder
 *  mediapipe.StreamHandler$InputStreamHandlerConfig
 *  mediapipe.StreamHandler$InputStreamHandlerConfig$Builder
 *  mediapipe.StreamHandler$OutputStreamHandlerConfig
 *  mediapipe.StreamHandler$OutputStreamHandlerConfig$Builder
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$Builder;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$Node;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$NodeOrBuilder;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfigOrBuilder;
import com.google.mediapipe.proto.CalculatorProto$ExecutorConfig;
import com.google.mediapipe.proto.CalculatorProto$ExecutorConfigOrBuilder;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig$Builder;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfigOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import mediapipe.MediapipeOptions;
import mediapipe.PacketFactory;
import mediapipe.PacketGenerator;
import mediapipe.StatusHandler;
import mediapipe.StreamHandler;

public final class CalculatorProto$CalculatorGraphConfig
extends GeneratedMessageLite
implements CalculatorProto$CalculatorGraphConfigOrBuilder {
    private static final CalculatorProto$CalculatorGraphConfig DEFAULT_INSTANCE;
    public static final int EXECUTOR_FIELD_NUMBER = 14;
    public static final int INPUT_SIDE_PACKET_FIELD_NUMBER = 16;
    public static final int INPUT_STREAM_FIELD_NUMBER = 10;
    public static final int INPUT_STREAM_HANDLER_FIELD_NUMBER = 12;
    public static final int MAX_QUEUE_SIZE_FIELD_NUMBER = 11;
    public static final int NODE_FIELD_NUMBER = 1;
    public static final int NUM_THREADS_FIELD_NUMBER = 8;
    public static final int OPTIONS_FIELD_NUMBER = 1001;
    public static final int OUTPUT_SIDE_PACKET_FIELD_NUMBER = 17;
    public static final int OUTPUT_STREAM_FIELD_NUMBER = 15;
    public static final int OUTPUT_STREAM_HANDLER_FIELD_NUMBER = 13;
    public static final int PACKAGE_FIELD_NUMBER = 19;
    public static final int PACKET_FACTORY_FIELD_NUMBER = 6;
    public static final int PACKET_GENERATOR_FIELD_NUMBER = 7;
    private static volatile Parser PARSER;
    public static final int PROFILER_CONFIG_FIELD_NUMBER = 18;
    public static final int REPORT_DEADLOCK_FIELD_NUMBER = 21;
    public static final int STATUS_HANDLER_FIELD_NUMBER = 9;
    public static final int TYPE_FIELD_NUMBER = 20;
    private Internal$ProtobufList executor_;
    private Internal$ProtobufList inputSidePacket_;
    private StreamHandler.InputStreamHandlerConfig inputStreamHandler_;
    private Internal$ProtobufList inputStream_;
    private int maxQueueSize_;
    private byte memoizedIsInitialized = (byte)2;
    private Internal$ProtobufList node_;
    private int numThreads_;
    private MediapipeOptions.MediaPipeOptions options_;
    private Internal$ProtobufList outputSidePacket_;
    private StreamHandler.OutputStreamHandlerConfig outputStreamHandler_;
    private Internal$ProtobufList outputStream_;
    private String package_;
    private Internal$ProtobufList packetFactory_;
    private Internal$ProtobufList packetGenerator_;
    private CalculatorProto$ProfilerConfig profilerConfig_;
    private boolean reportDeadlock_;
    private Internal$ProtobufList statusHandler_;
    private String type_;

    static {
        CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig;
        DEFAULT_INSTANCE = calculatorProto$CalculatorGraphConfig = new CalculatorProto$CalculatorGraphConfig();
        GeneratedMessageLite.registerDefaultInstance(CalculatorProto$CalculatorGraphConfig.class, calculatorProto$CalculatorGraphConfig);
    }

    private CalculatorProto$CalculatorGraphConfig() {
        Object object = GeneratedMessageLite.emptyProtobufList();
        this.node_ = object;
        object = GeneratedMessageLite.emptyProtobufList();
        this.packetFactory_ = object;
        object = GeneratedMessageLite.emptyProtobufList();
        this.packetGenerator_ = object;
        object = GeneratedMessageLite.emptyProtobufList();
        this.statusHandler_ = object;
        object = GeneratedMessageLite.emptyProtobufList();
        this.inputStream_ = object;
        object = GeneratedMessageLite.emptyProtobufList();
        this.outputStream_ = object;
        object = GeneratedMessageLite.emptyProtobufList();
        this.inputSidePacket_ = object;
        object = GeneratedMessageLite.emptyProtobufList();
        this.outputSidePacket_ = object;
        object = GeneratedMessageLite.emptyProtobufList();
        this.executor_ = object;
        this.package_ = object = "";
        this.type_ = object;
    }

    public static /* synthetic */ CalculatorProto$CalculatorGraphConfig access$15000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$15100(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig.setNode(n10, calculatorProto$CalculatorGraphConfig$Node);
    }

    public static /* synthetic */ void access$15200(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig.addNode(calculatorProto$CalculatorGraphConfig$Node);
    }

    public static /* synthetic */ void access$15300(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig.addNode(n10, calculatorProto$CalculatorGraphConfig$Node);
    }

    public static /* synthetic */ void access$15400(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig.addAllNode(iterable);
    }

    public static /* synthetic */ void access$15500(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearNode();
    }

    public static /* synthetic */ void access$15600(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10) {
        calculatorProto$CalculatorGraphConfig.removeNode(n10);
    }

    public static /* synthetic */ void access$15700(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, PacketFactory.PacketFactoryConfig packetFactoryConfig) {
        calculatorProto$CalculatorGraphConfig.setPacketFactory(n10, packetFactoryConfig);
    }

    public static /* synthetic */ void access$15800(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, PacketFactory.PacketFactoryConfig packetFactoryConfig) {
        calculatorProto$CalculatorGraphConfig.addPacketFactory(packetFactoryConfig);
    }

    public static /* synthetic */ void access$15900(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, PacketFactory.PacketFactoryConfig packetFactoryConfig) {
        calculatorProto$CalculatorGraphConfig.addPacketFactory(n10, packetFactoryConfig);
    }

    public static /* synthetic */ void access$16000(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig.addAllPacketFactory(iterable);
    }

    public static /* synthetic */ void access$16100(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearPacketFactory();
    }

    public static /* synthetic */ void access$16200(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10) {
        calculatorProto$CalculatorGraphConfig.removePacketFactory(n10);
    }

    public static /* synthetic */ void access$16300(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, PacketGenerator.PacketGeneratorConfig packetGeneratorConfig) {
        calculatorProto$CalculatorGraphConfig.setPacketGenerator(n10, packetGeneratorConfig);
    }

    public static /* synthetic */ void access$16400(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, PacketGenerator.PacketGeneratorConfig packetGeneratorConfig) {
        calculatorProto$CalculatorGraphConfig.addPacketGenerator(packetGeneratorConfig);
    }

    public static /* synthetic */ void access$16500(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, PacketGenerator.PacketGeneratorConfig packetGeneratorConfig) {
        calculatorProto$CalculatorGraphConfig.addPacketGenerator(n10, packetGeneratorConfig);
    }

    public static /* synthetic */ void access$16600(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig.addAllPacketGenerator(iterable);
    }

    public static /* synthetic */ void access$16700(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearPacketGenerator();
    }

    public static /* synthetic */ void access$16800(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10) {
        calculatorProto$CalculatorGraphConfig.removePacketGenerator(n10);
    }

    public static /* synthetic */ void access$16900(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10) {
        calculatorProto$CalculatorGraphConfig.setNumThreads(n10);
    }

    public static /* synthetic */ void access$17000(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearNumThreads();
    }

    public static /* synthetic */ void access$17100(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, StatusHandler.StatusHandlerConfig statusHandlerConfig) {
        calculatorProto$CalculatorGraphConfig.setStatusHandler(n10, statusHandlerConfig);
    }

    public static /* synthetic */ void access$17200(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, StatusHandler.StatusHandlerConfig statusHandlerConfig) {
        calculatorProto$CalculatorGraphConfig.addStatusHandler(statusHandlerConfig);
    }

    public static /* synthetic */ void access$17300(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, StatusHandler.StatusHandlerConfig statusHandlerConfig) {
        calculatorProto$CalculatorGraphConfig.addStatusHandler(n10, statusHandlerConfig);
    }

    public static /* synthetic */ void access$17400(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig.addAllStatusHandler(iterable);
    }

    public static /* synthetic */ void access$17500(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearStatusHandler();
    }

    public static /* synthetic */ void access$17600(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10) {
        calculatorProto$CalculatorGraphConfig.removeStatusHandler(n10);
    }

    public static /* synthetic */ void access$17700(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, String string2) {
        calculatorProto$CalculatorGraphConfig.setInputStream(n10, string2);
    }

    public static /* synthetic */ void access$17800(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, String string2) {
        calculatorProto$CalculatorGraphConfig.addInputStream(string2);
    }

    public static /* synthetic */ void access$17900(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig.addAllInputStream(iterable);
    }

    public static /* synthetic */ void access$18000(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearInputStream();
    }

    public static /* synthetic */ void access$18100(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig.addInputStreamBytes(byteString);
    }

    public static /* synthetic */ void access$18200(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, String string2) {
        calculatorProto$CalculatorGraphConfig.setOutputStream(n10, string2);
    }

    public static /* synthetic */ void access$18300(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, String string2) {
        calculatorProto$CalculatorGraphConfig.addOutputStream(string2);
    }

    public static /* synthetic */ void access$18400(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig.addAllOutputStream(iterable);
    }

    public static /* synthetic */ void access$18500(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearOutputStream();
    }

    public static /* synthetic */ void access$18600(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig.addOutputStreamBytes(byteString);
    }

    public static /* synthetic */ void access$18700(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, String string2) {
        calculatorProto$CalculatorGraphConfig.setInputSidePacket(n10, string2);
    }

    public static /* synthetic */ void access$18800(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, String string2) {
        calculatorProto$CalculatorGraphConfig.addInputSidePacket(string2);
    }

    public static /* synthetic */ void access$18900(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig.addAllInputSidePacket(iterable);
    }

    public static /* synthetic */ void access$19000(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearInputSidePacket();
    }

    public static /* synthetic */ void access$19100(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig.addInputSidePacketBytes(byteString);
    }

    public static /* synthetic */ void access$19200(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, String string2) {
        calculatorProto$CalculatorGraphConfig.setOutputSidePacket(n10, string2);
    }

    public static /* synthetic */ void access$19300(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, String string2) {
        calculatorProto$CalculatorGraphConfig.addOutputSidePacket(string2);
    }

    public static /* synthetic */ void access$19400(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig.addAllOutputSidePacket(iterable);
    }

    public static /* synthetic */ void access$19500(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearOutputSidePacket();
    }

    public static /* synthetic */ void access$19600(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig.addOutputSidePacketBytes(byteString);
    }

    public static /* synthetic */ void access$19700(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10) {
        calculatorProto$CalculatorGraphConfig.setMaxQueueSize(n10);
    }

    public static /* synthetic */ void access$19800(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearMaxQueueSize();
    }

    public static /* synthetic */ void access$19900(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, boolean bl2) {
        calculatorProto$CalculatorGraphConfig.setReportDeadlock(bl2);
    }

    public static /* synthetic */ void access$20000(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearReportDeadlock();
    }

    public static /* synthetic */ void access$20100(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig) {
        calculatorProto$CalculatorGraphConfig.setInputStreamHandler(inputStreamHandlerConfig);
    }

    public static /* synthetic */ void access$20200(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig) {
        calculatorProto$CalculatorGraphConfig.mergeInputStreamHandler(inputStreamHandlerConfig);
    }

    public static /* synthetic */ void access$20300(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearInputStreamHandler();
    }

    public static /* synthetic */ void access$20400(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig) {
        calculatorProto$CalculatorGraphConfig.setOutputStreamHandler(outputStreamHandlerConfig);
    }

    public static /* synthetic */ void access$20500(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig) {
        calculatorProto$CalculatorGraphConfig.mergeOutputStreamHandler(outputStreamHandlerConfig);
    }

    public static /* synthetic */ void access$20600(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearOutputStreamHandler();
    }

    public static /* synthetic */ void access$20700(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        calculatorProto$CalculatorGraphConfig.setExecutor(n10, calculatorProto$ExecutorConfig);
    }

    public static /* synthetic */ void access$20800(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        calculatorProto$CalculatorGraphConfig.addExecutor(calculatorProto$ExecutorConfig);
    }

    public static /* synthetic */ void access$20900(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10, CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        calculatorProto$CalculatorGraphConfig.addExecutor(n10, calculatorProto$ExecutorConfig);
    }

    public static /* synthetic */ void access$21000(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig.addAllExecutor(iterable);
    }

    public static /* synthetic */ void access$21100(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearExecutor();
    }

    public static /* synthetic */ void access$21200(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, int n10) {
        calculatorProto$CalculatorGraphConfig.removeExecutor(n10);
    }

    public static /* synthetic */ void access$21300(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$CalculatorGraphConfig.setProfilerConfig(calculatorProto$ProfilerConfig);
    }

    public static /* synthetic */ void access$21400(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$CalculatorGraphConfig.mergeProfilerConfig(calculatorProto$ProfilerConfig);
    }

    public static /* synthetic */ void access$21500(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearProfilerConfig();
    }

    public static /* synthetic */ void access$21600(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, String string2) {
        calculatorProto$CalculatorGraphConfig.setPackage(string2);
    }

    public static /* synthetic */ void access$21700(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearPackage();
    }

    public static /* synthetic */ void access$21800(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig.setPackageBytes(byteString);
    }

    public static /* synthetic */ void access$21900(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, String string2) {
        calculatorProto$CalculatorGraphConfig.setType(string2);
    }

    public static /* synthetic */ void access$22000(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearType();
    }

    public static /* synthetic */ void access$22100(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig.setTypeBytes(byteString);
    }

    public static /* synthetic */ void access$22200(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        calculatorProto$CalculatorGraphConfig.setOptions(mediaPipeOptions);
    }

    public static /* synthetic */ void access$22300(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig, MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        calculatorProto$CalculatorGraphConfig.mergeOptions(mediaPipeOptions);
    }

    public static /* synthetic */ void access$22400(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        calculatorProto$CalculatorGraphConfig.clearOptions();
    }

    private void addAllExecutor(Iterable iterable) {
        this.ensureExecutorIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.executor_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllInputSidePacket(Iterable iterable) {
        this.ensureInputSidePacketIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.inputSidePacket_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllInputStream(Iterable iterable) {
        this.ensureInputStreamIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.inputStream_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllNode(Iterable iterable) {
        this.ensureNodeIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.node_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllOutputSidePacket(Iterable iterable) {
        this.ensureOutputSidePacketIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.outputSidePacket_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllOutputStream(Iterable iterable) {
        this.ensureOutputStreamIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.outputStream_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllPacketFactory(Iterable iterable) {
        this.ensurePacketFactoryIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.packetFactory_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllPacketGenerator(Iterable iterable) {
        this.ensurePacketGeneratorIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.packetGenerator_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllStatusHandler(Iterable iterable) {
        this.ensureStatusHandlerIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.statusHandler_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addExecutor(int n10, CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        calculatorProto$ExecutorConfig.getClass();
        this.ensureExecutorIsMutable();
        this.executor_.add(n10, calculatorProto$ExecutorConfig);
    }

    private void addExecutor(CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        calculatorProto$ExecutorConfig.getClass();
        this.ensureExecutorIsMutable();
        this.executor_.add(calculatorProto$ExecutorConfig);
    }

    private void addInputSidePacket(String string2) {
        string2.getClass();
        this.ensureInputSidePacketIsMutable();
        this.inputSidePacket_.add(string2);
    }

    private void addInputSidePacketBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.ensureInputSidePacketIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.inputSidePacket_;
        object = ((ByteString)object).toStringUtf8();
        internal$ProtobufList.add(object);
    }

    private void addInputStream(String string2) {
        string2.getClass();
        this.ensureInputStreamIsMutable();
        this.inputStream_.add(string2);
    }

    private void addInputStreamBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.ensureInputStreamIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.inputStream_;
        object = ((ByteString)object).toStringUtf8();
        internal$ProtobufList.add(object);
    }

    private void addNode(int n10, CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.getClass();
        this.ensureNodeIsMutable();
        this.node_.add(n10, calculatorProto$CalculatorGraphConfig$Node);
    }

    private void addNode(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.getClass();
        this.ensureNodeIsMutable();
        this.node_.add(calculatorProto$CalculatorGraphConfig$Node);
    }

    private void addOutputSidePacket(String string2) {
        string2.getClass();
        this.ensureOutputSidePacketIsMutable();
        this.outputSidePacket_.add(string2);
    }

    private void addOutputSidePacketBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.ensureOutputSidePacketIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.outputSidePacket_;
        object = ((ByteString)object).toStringUtf8();
        internal$ProtobufList.add(object);
    }

    private void addOutputStream(String string2) {
        string2.getClass();
        this.ensureOutputStreamIsMutable();
        this.outputStream_.add(string2);
    }

    private void addOutputStreamBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.ensureOutputStreamIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.outputStream_;
        object = ((ByteString)object).toStringUtf8();
        internal$ProtobufList.add(object);
    }

    private void addPacketFactory(int n10, PacketFactory.PacketFactoryConfig packetFactoryConfig) {
        packetFactoryConfig.getClass();
        this.ensurePacketFactoryIsMutable();
        this.packetFactory_.add(n10, packetFactoryConfig);
    }

    private void addPacketFactory(PacketFactory.PacketFactoryConfig packetFactoryConfig) {
        packetFactoryConfig.getClass();
        this.ensurePacketFactoryIsMutable();
        this.packetFactory_.add(packetFactoryConfig);
    }

    private void addPacketGenerator(int n10, PacketGenerator.PacketGeneratorConfig packetGeneratorConfig) {
        packetGeneratorConfig.getClass();
        this.ensurePacketGeneratorIsMutable();
        this.packetGenerator_.add(n10, packetGeneratorConfig);
    }

    private void addPacketGenerator(PacketGenerator.PacketGeneratorConfig packetGeneratorConfig) {
        packetGeneratorConfig.getClass();
        this.ensurePacketGeneratorIsMutable();
        this.packetGenerator_.add(packetGeneratorConfig);
    }

    private void addStatusHandler(int n10, StatusHandler.StatusHandlerConfig statusHandlerConfig) {
        statusHandlerConfig.getClass();
        this.ensureStatusHandlerIsMutable();
        this.statusHandler_.add(n10, statusHandlerConfig);
    }

    private void addStatusHandler(StatusHandler.StatusHandlerConfig statusHandlerConfig) {
        statusHandlerConfig.getClass();
        this.ensureStatusHandlerIsMutable();
        this.statusHandler_.add(statusHandlerConfig);
    }

    private void clearExecutor() {
        Internal$ProtobufList internal$ProtobufList;
        this.executor_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearInputSidePacket() {
        Internal$ProtobufList internal$ProtobufList;
        this.inputSidePacket_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearInputStream() {
        Internal$ProtobufList internal$ProtobufList;
        this.inputStream_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearInputStreamHandler() {
        this.inputStreamHandler_ = null;
    }

    private void clearMaxQueueSize() {
        this.maxQueueSize_ = 0;
    }

    private void clearNode() {
        Internal$ProtobufList internal$ProtobufList;
        this.node_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearNumThreads() {
        this.numThreads_ = 0;
    }

    private void clearOptions() {
        this.options_ = null;
    }

    private void clearOutputSidePacket() {
        Internal$ProtobufList internal$ProtobufList;
        this.outputSidePacket_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOutputStream() {
        Internal$ProtobufList internal$ProtobufList;
        this.outputStream_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOutputStreamHandler() {
        this.outputStreamHandler_ = null;
    }

    private void clearPackage() {
        String string2;
        this.package_ = string2 = CalculatorProto$CalculatorGraphConfig.getDefaultInstance().getPackage();
    }

    private void clearPacketFactory() {
        Internal$ProtobufList internal$ProtobufList;
        this.packetFactory_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPacketGenerator() {
        Internal$ProtobufList internal$ProtobufList;
        this.packetGenerator_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearProfilerConfig() {
        this.profilerConfig_ = null;
    }

    private void clearReportDeadlock() {
        this.reportDeadlock_ = false;
    }

    private void clearStatusHandler() {
        Internal$ProtobufList internal$ProtobufList;
        this.statusHandler_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearType() {
        String string2;
        this.type_ = string2 = CalculatorProto$CalculatorGraphConfig.getDefaultInstance().getType();
    }

    private void ensureExecutorIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.executor_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.executor_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.executor_);
        }
    }

    private void ensureInputSidePacketIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.inputSidePacket_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.inputSidePacket_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.inputSidePacket_);
        }
    }

    private void ensureInputStreamIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.inputStream_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.inputStream_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.inputStream_);
        }
    }

    private void ensureNodeIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.node_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.node_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.node_);
        }
    }

    private void ensureOutputSidePacketIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.outputSidePacket_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.outputSidePacket_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.outputSidePacket_);
        }
    }

    private void ensureOutputStreamIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.outputStream_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.outputStream_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.outputStream_);
        }
    }

    private void ensurePacketFactoryIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.packetFactory_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.packetFactory_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.packetFactory_);
        }
    }

    private void ensurePacketGeneratorIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.packetGenerator_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.packetGenerator_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.packetGenerator_);
        }
    }

    private void ensureStatusHandlerIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.statusHandler_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.statusHandler_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.statusHandler_);
        }
    }

    public static CalculatorProto$CalculatorGraphConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInputStreamHandler(StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig) {
        StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig2;
        inputStreamHandlerConfig.getClass();
        StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig3 = this.inputStreamHandler_;
        if (inputStreamHandlerConfig3 != null && inputStreamHandlerConfig3 != (inputStreamHandlerConfig2 = StreamHandler.InputStreamHandlerConfig.getDefaultInstance())) {
            inputStreamHandlerConfig3 = StreamHandler.InputStreamHandlerConfig.newBuilder((StreamHandler.InputStreamHandlerConfig)this.inputStreamHandler_);
            this.inputStreamHandler_ = inputStreamHandlerConfig = (StreamHandler.InputStreamHandlerConfig)((StreamHandler.InputStreamHandlerConfig.Builder)inputStreamHandlerConfig3.mergeFrom((GeneratedMessageLite)inputStreamHandlerConfig)).buildPartial();
        } else {
            this.inputStreamHandler_ = inputStreamHandlerConfig;
        }
    }

    private void mergeOptions(MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        MediapipeOptions.MediaPipeOptions mediaPipeOptions2;
        mediaPipeOptions.getClass();
        MediapipeOptions.MediaPipeOptions mediaPipeOptions3 = this.options_;
        if (mediaPipeOptions3 != null && mediaPipeOptions3 != (mediaPipeOptions2 = MediapipeOptions.MediaPipeOptions.getDefaultInstance())) {
            mediaPipeOptions3 = MediapipeOptions.MediaPipeOptions.newBuilder((MediapipeOptions.MediaPipeOptions)this.options_);
            this.options_ = mediaPipeOptions = (MediapipeOptions.MediaPipeOptions)((MediapipeOptions.MediaPipeOptions.Builder)mediaPipeOptions3.mergeFrom((GeneratedMessageLite)mediaPipeOptions)).buildPartial();
        } else {
            this.options_ = mediaPipeOptions;
        }
    }

    private void mergeOutputStreamHandler(StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig) {
        StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig2;
        outputStreamHandlerConfig.getClass();
        StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig3 = this.outputStreamHandler_;
        if (outputStreamHandlerConfig3 != null && outputStreamHandlerConfig3 != (outputStreamHandlerConfig2 = StreamHandler.OutputStreamHandlerConfig.getDefaultInstance())) {
            outputStreamHandlerConfig3 = StreamHandler.OutputStreamHandlerConfig.newBuilder((StreamHandler.OutputStreamHandlerConfig)this.outputStreamHandler_);
            this.outputStreamHandler_ = outputStreamHandlerConfig = (StreamHandler.OutputStreamHandlerConfig)((StreamHandler.OutputStreamHandlerConfig.Builder)outputStreamHandlerConfig3.mergeFrom((GeneratedMessageLite)outputStreamHandlerConfig)).buildPartial();
        } else {
            this.outputStreamHandler_ = outputStreamHandlerConfig;
        }
    }

    private void mergeProfilerConfig(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig2;
        calculatorProto$ProfilerConfig.getClass();
        CalculatorProto$ProfilerConfigOrBuilder calculatorProto$ProfilerConfigOrBuilder = this.profilerConfig_;
        if (calculatorProto$ProfilerConfigOrBuilder != null && calculatorProto$ProfilerConfigOrBuilder != (calculatorProto$ProfilerConfig2 = CalculatorProto$ProfilerConfig.getDefaultInstance())) {
            calculatorProto$ProfilerConfigOrBuilder = CalculatorProto$ProfilerConfig.newBuilder(this.profilerConfig_);
            this.profilerConfig_ = calculatorProto$ProfilerConfig = (CalculatorProto$ProfilerConfig)((CalculatorProto$ProfilerConfig$Builder)((GeneratedMessageLite$Builder)((Object)calculatorProto$ProfilerConfigOrBuilder)).mergeFrom(calculatorProto$ProfilerConfig)).buildPartial();
        } else {
            this.profilerConfig_ = calculatorProto$ProfilerConfig;
        }
    }

    public static CalculatorProto$CalculatorGraphConfig$Builder newBuilder() {
        return (CalculatorProto$CalculatorGraphConfig$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static CalculatorProto$CalculatorGraphConfig$Builder newBuilder(CalculatorProto$CalculatorGraphConfig calculatorProto$CalculatorGraphConfig) {
        return (CalculatorProto$CalculatorGraphConfig$Builder)DEFAULT_INSTANCE.createBuilder(calculatorProto$CalculatorGraphConfig);
    }

    public static CalculatorProto$CalculatorGraphConfig parseDelimitedFrom(InputStream inputStream) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$CalculatorGraphConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$CalculatorGraphConfig parseFrom(ByteString byteString) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static CalculatorProto$CalculatorGraphConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CalculatorProto$CalculatorGraphConfig parseFrom(CodedInputStream codedInputStream) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static CalculatorProto$CalculatorGraphConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CalculatorProto$CalculatorGraphConfig parseFrom(InputStream inputStream) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$CalculatorGraphConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$CalculatorGraphConfig parseFrom(ByteBuffer byteBuffer) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static CalculatorProto$CalculatorGraphConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CalculatorProto$CalculatorGraphConfig parseFrom(byte[] byArray) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static CalculatorProto$CalculatorGraphConfig parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeExecutor(int n10) {
        this.ensureExecutorIsMutable();
        this.executor_.remove(n10);
    }

    private void removeNode(int n10) {
        this.ensureNodeIsMutable();
        this.node_.remove(n10);
    }

    private void removePacketFactory(int n10) {
        this.ensurePacketFactoryIsMutable();
        this.packetFactory_.remove(n10);
    }

    private void removePacketGenerator(int n10) {
        this.ensurePacketGeneratorIsMutable();
        this.packetGenerator_.remove(n10);
    }

    private void removeStatusHandler(int n10) {
        this.ensureStatusHandlerIsMutable();
        this.statusHandler_.remove(n10);
    }

    private void setExecutor(int n10, CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig) {
        calculatorProto$ExecutorConfig.getClass();
        this.ensureExecutorIsMutable();
        this.executor_.set(n10, calculatorProto$ExecutorConfig);
    }

    private void setInputSidePacket(int n10, String string2) {
        string2.getClass();
        this.ensureInputSidePacketIsMutable();
        this.inputSidePacket_.set(n10, string2);
    }

    private void setInputStream(int n10, String string2) {
        string2.getClass();
        this.ensureInputStreamIsMutable();
        this.inputStream_.set(n10, string2);
    }

    private void setInputStreamHandler(StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig) {
        inputStreamHandlerConfig.getClass();
        this.inputStreamHandler_ = inputStreamHandlerConfig;
    }

    private void setMaxQueueSize(int n10) {
        this.maxQueueSize_ = n10;
    }

    private void setNode(int n10, CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.getClass();
        this.ensureNodeIsMutable();
        this.node_.set(n10, calculatorProto$CalculatorGraphConfig$Node);
    }

    private void setNumThreads(int n10) {
        this.numThreads_ = n10;
    }

    private void setOptions(MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        mediaPipeOptions.getClass();
        this.options_ = mediaPipeOptions;
    }

    private void setOutputSidePacket(int n10, String string2) {
        string2.getClass();
        this.ensureOutputSidePacketIsMutable();
        this.outputSidePacket_.set(n10, string2);
    }

    private void setOutputStream(int n10, String string2) {
        string2.getClass();
        this.ensureOutputStreamIsMutable();
        this.outputStream_.set(n10, string2);
    }

    private void setOutputStreamHandler(StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig) {
        outputStreamHandlerConfig.getClass();
        this.outputStreamHandler_ = outputStreamHandlerConfig;
    }

    private void setPackage(String string2) {
        string2.getClass();
        this.package_ = string2;
    }

    private void setPackageBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.package_ = object = ((ByteString)object).toStringUtf8();
    }

    private void setPacketFactory(int n10, PacketFactory.PacketFactoryConfig packetFactoryConfig) {
        packetFactoryConfig.getClass();
        this.ensurePacketFactoryIsMutable();
        this.packetFactory_.set(n10, packetFactoryConfig);
    }

    private void setPacketGenerator(int n10, PacketGenerator.PacketGeneratorConfig packetGeneratorConfig) {
        packetGeneratorConfig.getClass();
        this.ensurePacketGeneratorIsMutable();
        this.packetGenerator_.set(n10, packetGeneratorConfig);
    }

    private void setProfilerConfig(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.getClass();
        this.profilerConfig_ = calculatorProto$ProfilerConfig;
    }

    private void setReportDeadlock(boolean bl2) {
        this.reportDeadlock_ = bl2;
    }

    private void setStatusHandler(int n10, StatusHandler.StatusHandlerConfig statusHandlerConfig) {
        statusHandlerConfig.getClass();
        this.ensureStatusHandlerIsMutable();
        this.statusHandler_.set(n10, statusHandlerConfig);
    }

    private void setType(String string2) {
        string2.getClass();
        this.type_ = string2;
    }

    private void setTypeBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.type_ = object = ((ByteString)object).toStringUtf8();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        object = CalculatorProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        Object object2 = objectArray.ordinal();
        object2 = object[object2];
        int n10 = 1;
        switch (object2) {
            default: {
                objectArray = new UnsupportedOperationException();
                throw objectArray;
            }
            case 7: {
                if (clazz == null) {
                    n10 = 0;
                    object = null;
                }
                object2 = (byte)n10;
                this.memoizedIsInitialized = (byte)object2;
                return null;
            }
            case 6: {
                return this.memoizedIsInitialized;
            }
            case 5: {
                objectArray = PARSER;
                if (objectArray != null) return objectArray;
                clazz = CalculatorProto$CalculatorGraphConfig.class;
                synchronized (clazz) {
                    objectArray = PARSER;
                    if (objectArray != null) return objectArray;
                    object = DEFAULT_INSTANCE;
                    PARSER = objectArray = new GeneratedMessageLite$DefaultInstanceBasedParser((GeneratedMessageLite)object);
                    return objectArray;
                }
            }
            case 4: {
                return DEFAULT_INSTANCE;
            }
            case 3: {
                objectArray = new Object[23];
                objectArray[0] = "node_";
                objectArray[n10] = CalculatorProto$CalculatorGraphConfig$Node.class;
                objectArray[2] = "packetFactory_";
                objectArray[3] = PacketFactory.PacketFactoryConfig.class;
                objectArray[4] = "packetGenerator_";
                objectArray[5] = PacketGenerator.PacketGeneratorConfig.class;
                objectArray[6] = "numThreads_";
                objectArray[7] = "statusHandler_";
                objectArray[8] = StatusHandler.StatusHandlerConfig.class;
                objectArray[9] = "inputStream_";
                objectArray[10] = "maxQueueSize_";
                objectArray[11] = "inputStreamHandler_";
                objectArray[12] = "outputStreamHandler_";
                objectArray[13] = "executor_";
                objectArray[14] = CalculatorProto$ExecutorConfig.class;
                objectArray[15] = "outputStream_";
                objectArray[16] = "inputSidePacket_";
                objectArray[17] = "outputSidePacket_";
                objectArray[18] = "profilerConfig_";
                objectArray[19] = "package_";
                objectArray[20] = "type_";
                objectArray[21] = "reportDeadlock_";
                objectArray[22] = "options_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0012\u0000\u0000\u0001\u03e9\u0012\u0000\t\b\u0001\u041b\u0006\u041b\u0007\u041b\b\u0004\t\u041b\n\u021a\u000b\u0004\f\u0409\r\u0409\u000e\u041b\u000f\u021a\u0010\u021a\u0011\u021a\u0012\t\u0013\u0208\u0014\u0208\u0015\u0007\u03e9\u0409", objectArray);
            }
            case 2: {
                return new CalculatorProto$CalculatorGraphConfig$Builder(null);
            }
            case 1: 
        }
        return new CalculatorProto$CalculatorGraphConfig();
    }

    public CalculatorProto$ExecutorConfig getExecutor(int n10) {
        return (CalculatorProto$ExecutorConfig)this.executor_.get(n10);
    }

    public int getExecutorCount() {
        return this.executor_.size();
    }

    public List getExecutorList() {
        return this.executor_;
    }

    public CalculatorProto$ExecutorConfigOrBuilder getExecutorOrBuilder(int n10) {
        return (CalculatorProto$ExecutorConfigOrBuilder)this.executor_.get(n10);
    }

    public List getExecutorOrBuilderList() {
        return this.executor_;
    }

    public String getInputSidePacket(int n10) {
        return (String)this.inputSidePacket_.get(n10);
    }

    public ByteString getInputSidePacketBytes(int n10) {
        return ByteString.copyFromUtf8((String)this.inputSidePacket_.get(n10));
    }

    public int getInputSidePacketCount() {
        return this.inputSidePacket_.size();
    }

    public List getInputSidePacketList() {
        return this.inputSidePacket_;
    }

    public String getInputStream(int n10) {
        return (String)this.inputStream_.get(n10);
    }

    public ByteString getInputStreamBytes(int n10) {
        return ByteString.copyFromUtf8((String)this.inputStream_.get(n10));
    }

    public int getInputStreamCount() {
        return this.inputStream_.size();
    }

    public StreamHandler.InputStreamHandlerConfig getInputStreamHandler() {
        StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig = this.inputStreamHandler_;
        if (inputStreamHandlerConfig == null) {
            inputStreamHandlerConfig = StreamHandler.InputStreamHandlerConfig.getDefaultInstance();
        }
        return inputStreamHandlerConfig;
    }

    public List getInputStreamList() {
        return this.inputStream_;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize_;
    }

    public CalculatorProto$CalculatorGraphConfig$Node getNode(int n10) {
        return (CalculatorProto$CalculatorGraphConfig$Node)this.node_.get(n10);
    }

    public int getNodeCount() {
        return this.node_.size();
    }

    public List getNodeList() {
        return this.node_;
    }

    public CalculatorProto$CalculatorGraphConfig$NodeOrBuilder getNodeOrBuilder(int n10) {
        return (CalculatorProto$CalculatorGraphConfig$NodeOrBuilder)this.node_.get(n10);
    }

    public List getNodeOrBuilderList() {
        return this.node_;
    }

    public int getNumThreads() {
        return this.numThreads_;
    }

    public MediapipeOptions.MediaPipeOptions getOptions() {
        MediapipeOptions.MediaPipeOptions mediaPipeOptions = this.options_;
        if (mediaPipeOptions == null) {
            mediaPipeOptions = MediapipeOptions.MediaPipeOptions.getDefaultInstance();
        }
        return mediaPipeOptions;
    }

    public String getOutputSidePacket(int n10) {
        return (String)this.outputSidePacket_.get(n10);
    }

    public ByteString getOutputSidePacketBytes(int n10) {
        return ByteString.copyFromUtf8((String)this.outputSidePacket_.get(n10));
    }

    public int getOutputSidePacketCount() {
        return this.outputSidePacket_.size();
    }

    public List getOutputSidePacketList() {
        return this.outputSidePacket_;
    }

    public String getOutputStream(int n10) {
        return (String)this.outputStream_.get(n10);
    }

    public ByteString getOutputStreamBytes(int n10) {
        return ByteString.copyFromUtf8((String)this.outputStream_.get(n10));
    }

    public int getOutputStreamCount() {
        return this.outputStream_.size();
    }

    public StreamHandler.OutputStreamHandlerConfig getOutputStreamHandler() {
        StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig = this.outputStreamHandler_;
        if (outputStreamHandlerConfig == null) {
            outputStreamHandlerConfig = StreamHandler.OutputStreamHandlerConfig.getDefaultInstance();
        }
        return outputStreamHandlerConfig;
    }

    public List getOutputStreamList() {
        return this.outputStream_;
    }

    public String getPackage() {
        return this.package_;
    }

    public ByteString getPackageBytes() {
        return ByteString.copyFromUtf8(this.package_);
    }

    public PacketFactory.PacketFactoryConfig getPacketFactory(int n10) {
        return (PacketFactory.PacketFactoryConfig)this.packetFactory_.get(n10);
    }

    public int getPacketFactoryCount() {
        return this.packetFactory_.size();
    }

    public List getPacketFactoryList() {
        return this.packetFactory_;
    }

    public PacketFactory.PacketFactoryConfigOrBuilder getPacketFactoryOrBuilder(int n10) {
        return (PacketFactory.PacketFactoryConfigOrBuilder)this.packetFactory_.get(n10);
    }

    public List getPacketFactoryOrBuilderList() {
        return this.packetFactory_;
    }

    public PacketGenerator.PacketGeneratorConfig getPacketGenerator(int n10) {
        return (PacketGenerator.PacketGeneratorConfig)this.packetGenerator_.get(n10);
    }

    public int getPacketGeneratorCount() {
        return this.packetGenerator_.size();
    }

    public List getPacketGeneratorList() {
        return this.packetGenerator_;
    }

    public PacketGenerator.PacketGeneratorConfigOrBuilder getPacketGeneratorOrBuilder(int n10) {
        return (PacketGenerator.PacketGeneratorConfigOrBuilder)this.packetGenerator_.get(n10);
    }

    public List getPacketGeneratorOrBuilderList() {
        return this.packetGenerator_;
    }

    public CalculatorProto$ProfilerConfig getProfilerConfig() {
        CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig = this.profilerConfig_;
        if (calculatorProto$ProfilerConfig == null) {
            calculatorProto$ProfilerConfig = CalculatorProto$ProfilerConfig.getDefaultInstance();
        }
        return calculatorProto$ProfilerConfig;
    }

    public boolean getReportDeadlock() {
        return this.reportDeadlock_;
    }

    public StatusHandler.StatusHandlerConfig getStatusHandler(int n10) {
        return (StatusHandler.StatusHandlerConfig)this.statusHandler_.get(n10);
    }

    public int getStatusHandlerCount() {
        return this.statusHandler_.size();
    }

    public List getStatusHandlerList() {
        return this.statusHandler_;
    }

    public StatusHandler.StatusHandlerConfigOrBuilder getStatusHandlerOrBuilder(int n10) {
        return (StatusHandler.StatusHandlerConfigOrBuilder)this.statusHandler_.get(n10);
    }

    public List getStatusHandlerOrBuilderList() {
        return this.statusHandler_;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public boolean hasInputStreamHandler() {
        boolean bl2;
        StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig = this.inputStreamHandler_;
        if (inputStreamHandlerConfig != null) {
            bl2 = true;
        } else {
            bl2 = false;
            inputStreamHandlerConfig = null;
        }
        return bl2;
    }

    public boolean hasOptions() {
        boolean bl2;
        MediapipeOptions.MediaPipeOptions mediaPipeOptions = this.options_;
        if (mediaPipeOptions != null) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaPipeOptions = null;
        }
        return bl2;
    }

    public boolean hasOutputStreamHandler() {
        boolean bl2;
        StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig = this.outputStreamHandler_;
        if (outputStreamHandlerConfig != null) {
            bl2 = true;
        } else {
            bl2 = false;
            outputStreamHandlerConfig = null;
        }
        return bl2;
    }

    public boolean hasProfilerConfig() {
        boolean bl2;
        CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig = this.profilerConfig_;
        if (calculatorProto$ProfilerConfig != null) {
            bl2 = true;
        } else {
            bl2 = false;
            calculatorProto$ProfilerConfig = null;
        }
        return bl2;
    }
}


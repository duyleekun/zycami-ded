/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.google.mediapipe.proto.CalculatorOptionsProto$CalculatorOptions
 *  com.google.mediapipe.proto.CalculatorOptionsProto$CalculatorOptions$Builder
 *  mediapipe.StreamHandler$InputStreamHandlerConfig
 *  mediapipe.StreamHandler$InputStreamHandlerConfig$Builder
 *  mediapipe.StreamHandler$OutputStreamHandlerConfig
 *  mediapipe.StreamHandler$OutputStreamHandlerConfig$Builder
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$Node$Builder;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$NodeOrBuilder;
import com.google.mediapipe.proto.CalculatorProto$InputStreamInfo;
import com.google.mediapipe.proto.CalculatorProto$InputStreamInfoOrBuilder;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig$Builder;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfigOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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
import mediapipe.StreamHandler;

public final class CalculatorProto$CalculatorGraphConfig$Node
extends GeneratedMessageLite
implements CalculatorProto$CalculatorGraphConfig$NodeOrBuilder {
    public static final int BUFFER_SIZE_HINT_FIELD_NUMBER = 10;
    public static final int CALCULATOR_FIELD_NUMBER = 2;
    private static final CalculatorProto$CalculatorGraphConfig$Node DEFAULT_INSTANCE;
    public static final int EXECUTOR_FIELD_NUMBER = 14;
    public static final int EXTERNAL_INPUT_FIELD_NUMBER = 1005;
    public static final int INPUT_SIDE_PACKET_FIELD_NUMBER = 5;
    public static final int INPUT_STREAM_FIELD_NUMBER = 3;
    public static final int INPUT_STREAM_HANDLER_FIELD_NUMBER = 11;
    public static final int INPUT_STREAM_INFO_FIELD_NUMBER = 13;
    public static final int MAX_IN_FLIGHT_FIELD_NUMBER = 16;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NODE_OPTIONS_FIELD_NUMBER = 8;
    public static final int OPTIONS_FIELD_NUMBER = 7;
    public static final int OUTPUT_SIDE_PACKET_FIELD_NUMBER = 6;
    public static final int OUTPUT_STREAM_FIELD_NUMBER = 4;
    public static final int OUTPUT_STREAM_HANDLER_FIELD_NUMBER = 12;
    private static volatile Parser PARSER;
    public static final int PROFILER_CONFIG_FIELD_NUMBER = 15;
    public static final int SOURCE_LAYER_FIELD_NUMBER = 9;
    private int bufferSizeHint_;
    private String calculator_;
    private String executor_;
    private Internal$ProtobufList externalInput_;
    private Internal$ProtobufList inputSidePacket_;
    private StreamHandler.InputStreamHandlerConfig inputStreamHandler_;
    private Internal$ProtobufList inputStreamInfo_;
    private Internal$ProtobufList inputStream_;
    private int maxInFlight_;
    private byte memoizedIsInitialized = (byte)2;
    private String name_;
    private Internal$ProtobufList nodeOptions_;
    private CalculatorOptionsProto.CalculatorOptions options_;
    private Internal$ProtobufList outputSidePacket_;
    private StreamHandler.OutputStreamHandlerConfig outputStreamHandler_;
    private Internal$ProtobufList outputStream_;
    private CalculatorProto$ProfilerConfig profilerConfig_;
    private int sourceLayer_;

    static {
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node;
        DEFAULT_INSTANCE = calculatorProto$CalculatorGraphConfig$Node = new CalculatorProto$CalculatorGraphConfig$Node();
        GeneratedMessageLite.registerDefaultInstance(CalculatorProto$CalculatorGraphConfig$Node.class, calculatorProto$CalculatorGraphConfig$Node);
    }

    private CalculatorProto$CalculatorGraphConfig$Node() {
        Internal$ProtobufList internal$ProtobufList;
        Object object = "";
        this.name_ = object;
        this.calculator_ = object;
        this.inputStream_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
        this.outputStream_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
        this.inputSidePacket_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
        this.outputSidePacket_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
        this.nodeOptions_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
        this.inputStreamInfo_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
        this.executor_ = object;
        this.externalInput_ = object = GeneratedMessageLite.emptyProtobufList();
    }

    public static /* synthetic */ void access$10000(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig$Node.addOutputStreamBytes(byteString);
    }

    public static /* synthetic */ void access$10100(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.setInputSidePacket(n10, string2);
    }

    public static /* synthetic */ void access$10200(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.addInputSidePacket(string2);
    }

    public static /* synthetic */ void access$10300(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig$Node.addAllInputSidePacket(iterable);
    }

    public static /* synthetic */ void access$10400(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearInputSidePacket();
    }

    public static /* synthetic */ void access$10500(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig$Node.addInputSidePacketBytes(byteString);
    }

    public static /* synthetic */ void access$10600(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.setOutputSidePacket(n10, string2);
    }

    public static /* synthetic */ void access$10700(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.addOutputSidePacket(string2);
    }

    public static /* synthetic */ void access$10800(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig$Node.addAllOutputSidePacket(iterable);
    }

    public static /* synthetic */ void access$10900(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearOutputSidePacket();
    }

    public static /* synthetic */ void access$11000(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig$Node.addOutputSidePacketBytes(byteString);
    }

    public static /* synthetic */ void access$11100(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, CalculatorOptionsProto.CalculatorOptions calculatorOptions) {
        calculatorProto$CalculatorGraphConfig$Node.setOptions(calculatorOptions);
    }

    public static /* synthetic */ void access$11200(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, CalculatorOptionsProto.CalculatorOptions calculatorOptions) {
        calculatorProto$CalculatorGraphConfig$Node.mergeOptions(calculatorOptions);
    }

    public static /* synthetic */ void access$11300(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearOptions();
    }

    public static /* synthetic */ void access$11400(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10, Any any) {
        calculatorProto$CalculatorGraphConfig$Node.setNodeOptions(n10, any);
    }

    public static /* synthetic */ void access$11500(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, Any any) {
        calculatorProto$CalculatorGraphConfig$Node.addNodeOptions(any);
    }

    public static /* synthetic */ void access$11600(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10, Any any) {
        calculatorProto$CalculatorGraphConfig$Node.addNodeOptions(n10, any);
    }

    public static /* synthetic */ void access$11700(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig$Node.addAllNodeOptions(iterable);
    }

    public static /* synthetic */ void access$11800(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearNodeOptions();
    }

    public static /* synthetic */ void access$11900(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10) {
        calculatorProto$CalculatorGraphConfig$Node.removeNodeOptions(n10);
    }

    public static /* synthetic */ void access$12000(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10) {
        calculatorProto$CalculatorGraphConfig$Node.setSourceLayer(n10);
    }

    public static /* synthetic */ void access$12100(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearSourceLayer();
    }

    public static /* synthetic */ void access$12200(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10) {
        calculatorProto$CalculatorGraphConfig$Node.setBufferSizeHint(n10);
    }

    public static /* synthetic */ void access$12300(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearBufferSizeHint();
    }

    public static /* synthetic */ void access$12400(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig) {
        calculatorProto$CalculatorGraphConfig$Node.setInputStreamHandler(inputStreamHandlerConfig);
    }

    public static /* synthetic */ void access$12500(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig) {
        calculatorProto$CalculatorGraphConfig$Node.mergeInputStreamHandler(inputStreamHandlerConfig);
    }

    public static /* synthetic */ void access$12600(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearInputStreamHandler();
    }

    public static /* synthetic */ void access$12700(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig) {
        calculatorProto$CalculatorGraphConfig$Node.setOutputStreamHandler(outputStreamHandlerConfig);
    }

    public static /* synthetic */ void access$12800(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig) {
        calculatorProto$CalculatorGraphConfig$Node.mergeOutputStreamHandler(outputStreamHandlerConfig);
    }

    public static /* synthetic */ void access$12900(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearOutputStreamHandler();
    }

    public static /* synthetic */ void access$13000(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10, CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        calculatorProto$CalculatorGraphConfig$Node.setInputStreamInfo(n10, calculatorProto$InputStreamInfo);
    }

    public static /* synthetic */ void access$13100(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        calculatorProto$CalculatorGraphConfig$Node.addInputStreamInfo(calculatorProto$InputStreamInfo);
    }

    public static /* synthetic */ void access$13200(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10, CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        calculatorProto$CalculatorGraphConfig$Node.addInputStreamInfo(n10, calculatorProto$InputStreamInfo);
    }

    public static /* synthetic */ void access$13300(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig$Node.addAllInputStreamInfo(iterable);
    }

    public static /* synthetic */ void access$13400(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearInputStreamInfo();
    }

    public static /* synthetic */ void access$13500(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10) {
        calculatorProto$CalculatorGraphConfig$Node.removeInputStreamInfo(n10);
    }

    public static /* synthetic */ void access$13600(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.setExecutor(string2);
    }

    public static /* synthetic */ void access$13700(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearExecutor();
    }

    public static /* synthetic */ void access$13800(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig$Node.setExecutorBytes(byteString);
    }

    public static /* synthetic */ void access$13900(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$CalculatorGraphConfig$Node.setProfilerConfig(calculatorProto$ProfilerConfig);
    }

    public static /* synthetic */ void access$14000(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$CalculatorGraphConfig$Node.mergeProfilerConfig(calculatorProto$ProfilerConfig);
    }

    public static /* synthetic */ void access$14100(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearProfilerConfig();
    }

    public static /* synthetic */ void access$14200(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10) {
        calculatorProto$CalculatorGraphConfig$Node.setMaxInFlight(n10);
    }

    public static /* synthetic */ void access$14300(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearMaxInFlight();
    }

    public static /* synthetic */ void access$14400(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.setExternalInput(n10, string2);
    }

    public static /* synthetic */ void access$14500(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.addExternalInput(string2);
    }

    public static /* synthetic */ void access$14600(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig$Node.addAllExternalInput(iterable);
    }

    public static /* synthetic */ void access$14700(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearExternalInput();
    }

    public static /* synthetic */ void access$14800(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig$Node.addExternalInputBytes(byteString);
    }

    public static /* synthetic */ CalculatorProto$CalculatorGraphConfig$Node access$8400() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$8500(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.setName(string2);
    }

    public static /* synthetic */ void access$8600(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearName();
    }

    public static /* synthetic */ void access$8700(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig$Node.setNameBytes(byteString);
    }

    public static /* synthetic */ void access$8800(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.setCalculator(string2);
    }

    public static /* synthetic */ void access$8900(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearCalculator();
    }

    public static /* synthetic */ void access$9000(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig$Node.setCalculatorBytes(byteString);
    }

    public static /* synthetic */ void access$9100(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.setInputStream(n10, string2);
    }

    public static /* synthetic */ void access$9200(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.addInputStream(string2);
    }

    public static /* synthetic */ void access$9300(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig$Node.addAllInputStream(iterable);
    }

    public static /* synthetic */ void access$9400(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearInputStream();
    }

    public static /* synthetic */ void access$9500(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, ByteString byteString) {
        calculatorProto$CalculatorGraphConfig$Node.addInputStreamBytes(byteString);
    }

    public static /* synthetic */ void access$9600(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, int n10, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.setOutputStream(n10, string2);
    }

    public static /* synthetic */ void access$9700(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, String string2) {
        calculatorProto$CalculatorGraphConfig$Node.addOutputStream(string2);
    }

    public static /* synthetic */ void access$9800(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node, Iterable iterable) {
        calculatorProto$CalculatorGraphConfig$Node.addAllOutputStream(iterable);
    }

    public static /* synthetic */ void access$9900(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        calculatorProto$CalculatorGraphConfig$Node.clearOutputStream();
    }

    private void addAllExternalInput(Iterable iterable) {
        this.ensureExternalInputIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.externalInput_;
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

    private void addAllInputStreamInfo(Iterable iterable) {
        this.ensureInputStreamInfoIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.inputStreamInfo_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllNodeOptions(Iterable iterable) {
        this.ensureNodeOptionsIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.nodeOptions_;
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

    private void addExternalInput(String string2) {
        string2.getClass();
        this.ensureExternalInputIsMutable();
        this.externalInput_.add(string2);
    }

    private void addExternalInputBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.ensureExternalInputIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.externalInput_;
        object = ((ByteString)object).toStringUtf8();
        internal$ProtobufList.add(object);
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

    private void addInputStreamInfo(int n10, CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        calculatorProto$InputStreamInfo.getClass();
        this.ensureInputStreamInfoIsMutable();
        this.inputStreamInfo_.add(n10, calculatorProto$InputStreamInfo);
    }

    private void addInputStreamInfo(CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        calculatorProto$InputStreamInfo.getClass();
        this.ensureInputStreamInfoIsMutable();
        this.inputStreamInfo_.add(calculatorProto$InputStreamInfo);
    }

    private void addNodeOptions(int n10, Any any) {
        any.getClass();
        this.ensureNodeOptionsIsMutable();
        this.nodeOptions_.add(n10, any);
    }

    private void addNodeOptions(Any any) {
        any.getClass();
        this.ensureNodeOptionsIsMutable();
        this.nodeOptions_.add(any);
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

    private void clearBufferSizeHint() {
        this.bufferSizeHint_ = 0;
    }

    private void clearCalculator() {
        String string2;
        this.calculator_ = string2 = CalculatorProto$CalculatorGraphConfig$Node.getDefaultInstance().getCalculator();
    }

    private void clearExecutor() {
        String string2;
        this.executor_ = string2 = CalculatorProto$CalculatorGraphConfig$Node.getDefaultInstance().getExecutor();
    }

    private void clearExternalInput() {
        Internal$ProtobufList internal$ProtobufList;
        this.externalInput_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
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

    private void clearInputStreamInfo() {
        Internal$ProtobufList internal$ProtobufList;
        this.inputStreamInfo_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMaxInFlight() {
        this.maxInFlight_ = 0;
    }

    private void clearName() {
        String string2;
        this.name_ = string2 = CalculatorProto$CalculatorGraphConfig$Node.getDefaultInstance().getName();
    }

    private void clearNodeOptions() {
        Internal$ProtobufList internal$ProtobufList;
        this.nodeOptions_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
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

    private void clearProfilerConfig() {
        this.profilerConfig_ = null;
    }

    private void clearSourceLayer() {
        this.sourceLayer_ = 0;
    }

    private void ensureExternalInputIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.externalInput_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.externalInput_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.externalInput_);
        }
    }

    private void ensureInputSidePacketIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.inputSidePacket_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.inputSidePacket_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.inputSidePacket_);
        }
    }

    private void ensureInputStreamInfoIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.inputStreamInfo_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.inputStreamInfo_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.inputStreamInfo_);
        }
    }

    private void ensureInputStreamIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.inputStream_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.inputStream_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.inputStream_);
        }
    }

    private void ensureNodeOptionsIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.nodeOptions_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.nodeOptions_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.nodeOptions_);
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

    public static CalculatorProto$CalculatorGraphConfig$Node getDefaultInstance() {
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

    private void mergeOptions(CalculatorOptionsProto.CalculatorOptions calculatorOptions) {
        CalculatorOptionsProto.CalculatorOptions calculatorOptions2;
        calculatorOptions.getClass();
        CalculatorOptionsProto.CalculatorOptions calculatorOptions3 = this.options_;
        if (calculatorOptions3 != null && calculatorOptions3 != (calculatorOptions2 = CalculatorOptionsProto.CalculatorOptions.getDefaultInstance())) {
            calculatorOptions3 = CalculatorOptionsProto.CalculatorOptions.newBuilder((CalculatorOptionsProto.CalculatorOptions)this.options_);
            this.options_ = calculatorOptions = (CalculatorOptionsProto.CalculatorOptions)((CalculatorOptionsProto.CalculatorOptions.Builder)calculatorOptions3.mergeFrom((GeneratedMessageLite)calculatorOptions)).buildPartial();
        } else {
            this.options_ = calculatorOptions;
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

    public static CalculatorProto$CalculatorGraphConfig$Node$Builder newBuilder() {
        return (CalculatorProto$CalculatorGraphConfig$Node$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static CalculatorProto$CalculatorGraphConfig$Node$Builder newBuilder(CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node) {
        return (CalculatorProto$CalculatorGraphConfig$Node$Builder)DEFAULT_INSTANCE.createBuilder(calculatorProto$CalculatorGraphConfig$Node);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseDelimitedFrom(InputStream inputStream) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseFrom(ByteString byteString) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseFrom(CodedInputStream codedInputStream) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseFrom(InputStream inputStream) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseFrom(ByteBuffer byteBuffer) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseFrom(byte[] byArray) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static CalculatorProto$CalculatorGraphConfig$Node parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$CalculatorGraphConfig$Node)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeInputStreamInfo(int n10) {
        this.ensureInputStreamInfoIsMutable();
        this.inputStreamInfo_.remove(n10);
    }

    private void removeNodeOptions(int n10) {
        this.ensureNodeOptionsIsMutable();
        this.nodeOptions_.remove(n10);
    }

    private void setBufferSizeHint(int n10) {
        this.bufferSizeHint_ = n10;
    }

    private void setCalculator(String string2) {
        string2.getClass();
        this.calculator_ = string2;
    }

    private void setCalculatorBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.calculator_ = object = ((ByteString)object).toStringUtf8();
    }

    private void setExecutor(String string2) {
        string2.getClass();
        this.executor_ = string2;
    }

    private void setExecutorBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.executor_ = object = ((ByteString)object).toStringUtf8();
    }

    private void setExternalInput(int n10, String string2) {
        string2.getClass();
        this.ensureExternalInputIsMutable();
        this.externalInput_.set(n10, string2);
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

    private void setInputStreamInfo(int n10, CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        calculatorProto$InputStreamInfo.getClass();
        this.ensureInputStreamInfoIsMutable();
        this.inputStreamInfo_.set(n10, calculatorProto$InputStreamInfo);
    }

    private void setMaxInFlight(int n10) {
        this.maxInFlight_ = n10;
    }

    private void setName(String string2) {
        string2.getClass();
        this.name_ = string2;
    }

    private void setNameBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.name_ = object = ((ByteString)object).toStringUtf8();
    }

    private void setNodeOptions(int n10, Any any) {
        any.getClass();
        this.ensureNodeOptionsIsMutable();
        this.nodeOptions_.set(n10, any);
    }

    private void setOptions(CalculatorOptionsProto.CalculatorOptions calculatorOptions) {
        calculatorOptions.getClass();
        this.options_ = calculatorOptions;
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

    private void setProfilerConfig(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.getClass();
        this.profilerConfig_ = calculatorProto$ProfilerConfig;
    }

    private void setSourceLayer(int n10) {
        this.sourceLayer_ = n10;
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
                clazz = CalculatorProto$CalculatorGraphConfig$Node.class;
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
                objectArray = new Object[19];
                objectArray[0] = "name_";
                objectArray[n10] = "calculator_";
                objectArray[2] = "inputStream_";
                objectArray[3] = "outputStream_";
                objectArray[4] = "inputSidePacket_";
                objectArray[5] = "outputSidePacket_";
                objectArray[6] = "options_";
                objectArray[7] = "nodeOptions_";
                objectArray[8] = Any.class;
                objectArray[9] = "sourceLayer_";
                objectArray[10] = "bufferSizeHint_";
                objectArray[11] = "inputStreamHandler_";
                objectArray[12] = "outputStreamHandler_";
                objectArray[13] = "inputStreamInfo_";
                objectArray[14] = CalculatorProto$InputStreamInfo.class;
                objectArray[15] = "executor_";
                objectArray[16] = "profilerConfig_";
                objectArray[17] = "maxInFlight_";
                objectArray[18] = "externalInput_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0011\u0000\u0000\u0001\u03ed\u0011\u0000\u0007\u0003\u0001\u0208\u0002\u0208\u0003\u021a\u0004\u021a\u0005\u021a\u0006\u021a\u0007\u0409\b\u001b\t\u0004\n\u0004\u000b\u0409\f\u0409\r\u001b\u000e\u0208\u000f\t\u0010\u0004\u03ed\u021a", objectArray);
            }
            case 2: {
                return new CalculatorProto$CalculatorGraphConfig$Node$Builder(null);
            }
            case 1: 
        }
        return new CalculatorProto$CalculatorGraphConfig$Node();
    }

    public int getBufferSizeHint() {
        return this.bufferSizeHint_;
    }

    public String getCalculator() {
        return this.calculator_;
    }

    public ByteString getCalculatorBytes() {
        return ByteString.copyFromUtf8(this.calculator_);
    }

    public String getExecutor() {
        return this.executor_;
    }

    public ByteString getExecutorBytes() {
        return ByteString.copyFromUtf8(this.executor_);
    }

    public String getExternalInput(int n10) {
        return (String)this.externalInput_.get(n10);
    }

    public ByteString getExternalInputBytes(int n10) {
        return ByteString.copyFromUtf8((String)this.externalInput_.get(n10));
    }

    public int getExternalInputCount() {
        return this.externalInput_.size();
    }

    public List getExternalInputList() {
        return this.externalInput_;
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

    public CalculatorProto$InputStreamInfo getInputStreamInfo(int n10) {
        return (CalculatorProto$InputStreamInfo)this.inputStreamInfo_.get(n10);
    }

    public int getInputStreamInfoCount() {
        return this.inputStreamInfo_.size();
    }

    public List getInputStreamInfoList() {
        return this.inputStreamInfo_;
    }

    public CalculatorProto$InputStreamInfoOrBuilder getInputStreamInfoOrBuilder(int n10) {
        return (CalculatorProto$InputStreamInfoOrBuilder)this.inputStreamInfo_.get(n10);
    }

    public List getInputStreamInfoOrBuilderList() {
        return this.inputStreamInfo_;
    }

    public List getInputStreamList() {
        return this.inputStream_;
    }

    public int getMaxInFlight() {
        return this.maxInFlight_;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public Any getNodeOptions(int n10) {
        return (Any)this.nodeOptions_.get(n10);
    }

    public int getNodeOptionsCount() {
        return this.nodeOptions_.size();
    }

    public List getNodeOptionsList() {
        return this.nodeOptions_;
    }

    public AnyOrBuilder getNodeOptionsOrBuilder(int n10) {
        return (AnyOrBuilder)this.nodeOptions_.get(n10);
    }

    public List getNodeOptionsOrBuilderList() {
        return this.nodeOptions_;
    }

    public CalculatorOptionsProto.CalculatorOptions getOptions() {
        CalculatorOptionsProto.CalculatorOptions calculatorOptions = this.options_;
        if (calculatorOptions == null) {
            calculatorOptions = CalculatorOptionsProto.CalculatorOptions.getDefaultInstance();
        }
        return calculatorOptions;
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

    public CalculatorProto$ProfilerConfig getProfilerConfig() {
        CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig = this.profilerConfig_;
        if (calculatorProto$ProfilerConfig == null) {
            calculatorProto$ProfilerConfig = CalculatorProto$ProfilerConfig.getDefaultInstance();
        }
        return calculatorProto$ProfilerConfig;
    }

    public int getSourceLayer() {
        return this.sourceLayer_;
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
        CalculatorOptionsProto.CalculatorOptions calculatorOptions = this.options_;
        if (calculatorOptions != null) {
            bl2 = true;
        } else {
            bl2 = false;
            calculatorOptions = null;
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


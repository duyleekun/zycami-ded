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
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$Node;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$NodeOrBuilder;
import com.google.mediapipe.proto.CalculatorProto$InputStreamInfo;
import com.google.mediapipe.proto.CalculatorProto$InputStreamInfo$Builder;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig$Builder;
import com.google.protobuf.Any;
import com.google.protobuf.Any$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;
import mediapipe.StreamHandler;

public final class CalculatorProto$CalculatorGraphConfig$Node$Builder
extends GeneratedMessageLite$Builder
implements CalculatorProto$CalculatorGraphConfig$NodeOrBuilder {
    private CalculatorProto$CalculatorGraphConfig$Node$Builder() {
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = CalculatorProto$CalculatorGraphConfig$Node.access$8400();
        super(calculatorProto$CalculatorGraphConfig$Node);
    }

    public /* synthetic */ CalculatorProto$CalculatorGraphConfig$Node$Builder(CalculatorProto$1 calculatorProto$1) {
        this();
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addAllExternalInput(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$14600((CalculatorProto$CalculatorGraphConfig$Node)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addAllInputSidePacket(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$10300((CalculatorProto$CalculatorGraphConfig$Node)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addAllInputStream(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$9300((CalculatorProto$CalculatorGraphConfig$Node)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addAllInputStreamInfo(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$13300((CalculatorProto$CalculatorGraphConfig$Node)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addAllNodeOptions(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$11700((CalculatorProto$CalculatorGraphConfig$Node)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addAllOutputSidePacket(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$10800((CalculatorProto$CalculatorGraphConfig$Node)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addAllOutputStream(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$9800((CalculatorProto$CalculatorGraphConfig$Node)this.instance, iterable);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addExternalInput(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$14500((CalculatorProto$CalculatorGraphConfig$Node)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addExternalInputBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$14800((CalculatorProto$CalculatorGraphConfig$Node)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addInputSidePacket(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$10200((CalculatorProto$CalculatorGraphConfig$Node)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addInputSidePacketBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$10500((CalculatorProto$CalculatorGraphConfig$Node)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addInputStream(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$9200((CalculatorProto$CalculatorGraphConfig$Node)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addInputStreamBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$9500((CalculatorProto$CalculatorGraphConfig$Node)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addInputStreamInfo(int n10, CalculatorProto$InputStreamInfo$Builder calculatorProto$InputStreamInfoOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = (CalculatorProto$CalculatorGraphConfig$Node)this.instance;
        calculatorProto$InputStreamInfoOrBuilder = (CalculatorProto$InputStreamInfo)calculatorProto$InputStreamInfoOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig$Node.access$13200(calculatorProto$CalculatorGraphConfig$Node, n10, (CalculatorProto$InputStreamInfo)calculatorProto$InputStreamInfoOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addInputStreamInfo(int n10, CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$13200((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10, calculatorProto$InputStreamInfo);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addInputStreamInfo(CalculatorProto$InputStreamInfo$Builder calculatorProto$InputStreamInfoOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = (CalculatorProto$CalculatorGraphConfig$Node)this.instance;
        calculatorProto$InputStreamInfoOrBuilder = (CalculatorProto$InputStreamInfo)calculatorProto$InputStreamInfoOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig$Node.access$13100(calculatorProto$CalculatorGraphConfig$Node, (CalculatorProto$InputStreamInfo)calculatorProto$InputStreamInfoOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addInputStreamInfo(CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$13100((CalculatorProto$CalculatorGraphConfig$Node)this.instance, calculatorProto$InputStreamInfo);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addNodeOptions(int n10, Any$Builder anyOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = (CalculatorProto$CalculatorGraphConfig$Node)this.instance;
        anyOrBuilder = (Any)anyOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig$Node.access$11600(calculatorProto$CalculatorGraphConfig$Node, n10, (Any)anyOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addNodeOptions(int n10, Any any) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$11600((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10, any);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addNodeOptions(Any$Builder anyOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = (CalculatorProto$CalculatorGraphConfig$Node)this.instance;
        anyOrBuilder = (Any)anyOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig$Node.access$11500(calculatorProto$CalculatorGraphConfig$Node, (Any)anyOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addNodeOptions(Any any) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$11500((CalculatorProto$CalculatorGraphConfig$Node)this.instance, any);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addOutputSidePacket(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$10700((CalculatorProto$CalculatorGraphConfig$Node)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addOutputSidePacketBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$11000((CalculatorProto$CalculatorGraphConfig$Node)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addOutputStream(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$9700((CalculatorProto$CalculatorGraphConfig$Node)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder addOutputStreamBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$10000((CalculatorProto$CalculatorGraphConfig$Node)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearBufferSizeHint() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$12300((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearCalculator() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$8900((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearExecutor() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$13700((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearExternalInput() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$14700((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearInputSidePacket() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$10400((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearInputStream() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$9400((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearInputStreamHandler() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$12600((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearInputStreamInfo() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$13400((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearMaxInFlight() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$14300((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearName() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$8600((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearNodeOptions() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$11800((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearOptions() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$11300((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearOutputSidePacket() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$10900((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearOutputStream() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$9900((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearOutputStreamHandler() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$12900((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearProfilerConfig() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$14100((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder clearSourceLayer() {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$12100((CalculatorProto$CalculatorGraphConfig$Node)this.instance);
        return this;
    }

    public int getBufferSizeHint() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getBufferSizeHint();
    }

    public String getCalculator() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getCalculator();
    }

    public ByteString getCalculatorBytes() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getCalculatorBytes();
    }

    public String getExecutor() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getExecutor();
    }

    public ByteString getExecutorBytes() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getExecutorBytes();
    }

    public String getExternalInput(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getExternalInput(n10);
    }

    public ByteString getExternalInputBytes(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getExternalInputBytes(n10);
    }

    public int getExternalInputCount() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getExternalInputCount();
    }

    public List getExternalInputList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getExternalInputList());
    }

    public String getInputSidePacket(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputSidePacket(n10);
    }

    public ByteString getInputSidePacketBytes(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputSidePacketBytes(n10);
    }

    public int getInputSidePacketCount() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputSidePacketCount();
    }

    public List getInputSidePacketList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputSidePacketList());
    }

    public String getInputStream(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputStream(n10);
    }

    public ByteString getInputStreamBytes(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputStreamBytes(n10);
    }

    public int getInputStreamCount() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputStreamCount();
    }

    public StreamHandler.InputStreamHandlerConfig getInputStreamHandler() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputStreamHandler();
    }

    public CalculatorProto$InputStreamInfo getInputStreamInfo(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputStreamInfo(n10);
    }

    public int getInputStreamInfoCount() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputStreamInfoCount();
    }

    public List getInputStreamInfoList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputStreamInfoList());
    }

    public List getInputStreamList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getInputStreamList());
    }

    public int getMaxInFlight() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getMaxInFlight();
    }

    public String getName() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getName();
    }

    public ByteString getNameBytes() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getNameBytes();
    }

    public Any getNodeOptions(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getNodeOptions(n10);
    }

    public int getNodeOptionsCount() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getNodeOptionsCount();
    }

    public List getNodeOptionsList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getNodeOptionsList());
    }

    public CalculatorOptionsProto.CalculatorOptions getOptions() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getOptions();
    }

    public String getOutputSidePacket(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getOutputSidePacket(n10);
    }

    public ByteString getOutputSidePacketBytes(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getOutputSidePacketBytes(n10);
    }

    public int getOutputSidePacketCount() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getOutputSidePacketCount();
    }

    public List getOutputSidePacketList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getOutputSidePacketList());
    }

    public String getOutputStream(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getOutputStream(n10);
    }

    public ByteString getOutputStreamBytes(int n10) {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getOutputStreamBytes(n10);
    }

    public int getOutputStreamCount() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getOutputStreamCount();
    }

    public StreamHandler.OutputStreamHandlerConfig getOutputStreamHandler() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getOutputStreamHandler();
    }

    public List getOutputStreamList() {
        return Collections.unmodifiableList(((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getOutputStreamList());
    }

    public CalculatorProto$ProfilerConfig getProfilerConfig() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getProfilerConfig();
    }

    public int getSourceLayer() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).getSourceLayer();
    }

    public boolean hasInputStreamHandler() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).hasInputStreamHandler();
    }

    public boolean hasOptions() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).hasOptions();
    }

    public boolean hasOutputStreamHandler() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).hasOutputStreamHandler();
    }

    public boolean hasProfilerConfig() {
        return ((CalculatorProto$CalculatorGraphConfig$Node)this.instance).hasProfilerConfig();
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder mergeInputStreamHandler(StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$12500((CalculatorProto$CalculatorGraphConfig$Node)this.instance, inputStreamHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder mergeOptions(CalculatorOptionsProto.CalculatorOptions calculatorOptions) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$11200((CalculatorProto$CalculatorGraphConfig$Node)this.instance, calculatorOptions);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder mergeOutputStreamHandler(StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$12800((CalculatorProto$CalculatorGraphConfig$Node)this.instance, outputStreamHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder mergeProfilerConfig(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$14000((CalculatorProto$CalculatorGraphConfig$Node)this.instance, calculatorProto$ProfilerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder removeInputStreamInfo(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$13500((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder removeNodeOptions(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$11900((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setBufferSizeHint(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$12200((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setCalculator(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$8800((CalculatorProto$CalculatorGraphConfig$Node)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setCalculatorBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$9000((CalculatorProto$CalculatorGraphConfig$Node)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setExecutor(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$13600((CalculatorProto$CalculatorGraphConfig$Node)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setExecutorBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$13800((CalculatorProto$CalculatorGraphConfig$Node)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setExternalInput(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$14400((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setInputSidePacket(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$10100((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setInputStream(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$9100((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setInputStreamHandler(StreamHandler.InputStreamHandlerConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = (CalculatorProto$CalculatorGraphConfig$Node)this.instance;
        builder = (StreamHandler.InputStreamHandlerConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig$Node.access$12400(calculatorProto$CalculatorGraphConfig$Node, (StreamHandler.InputStreamHandlerConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setInputStreamHandler(StreamHandler.InputStreamHandlerConfig inputStreamHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$12400((CalculatorProto$CalculatorGraphConfig$Node)this.instance, inputStreamHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setInputStreamInfo(int n10, CalculatorProto$InputStreamInfo$Builder calculatorProto$InputStreamInfoOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = (CalculatorProto$CalculatorGraphConfig$Node)this.instance;
        calculatorProto$InputStreamInfoOrBuilder = (CalculatorProto$InputStreamInfo)calculatorProto$InputStreamInfoOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig$Node.access$13000(calculatorProto$CalculatorGraphConfig$Node, n10, (CalculatorProto$InputStreamInfo)calculatorProto$InputStreamInfoOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setInputStreamInfo(int n10, CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$13000((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10, calculatorProto$InputStreamInfo);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setMaxInFlight(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$14200((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setName(String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$8500((CalculatorProto$CalculatorGraphConfig$Node)this.instance, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setNameBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$8700((CalculatorProto$CalculatorGraphConfig$Node)this.instance, byteString);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setNodeOptions(int n10, Any$Builder anyOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = (CalculatorProto$CalculatorGraphConfig$Node)this.instance;
        anyOrBuilder = (Any)anyOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig$Node.access$11400(calculatorProto$CalculatorGraphConfig$Node, n10, (Any)anyOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setNodeOptions(int n10, Any any) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$11400((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10, any);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setOptions(CalculatorOptionsProto.CalculatorOptions.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = (CalculatorProto$CalculatorGraphConfig$Node)this.instance;
        builder = (CalculatorOptionsProto.CalculatorOptions)builder.build();
        CalculatorProto$CalculatorGraphConfig$Node.access$11100(calculatorProto$CalculatorGraphConfig$Node, (CalculatorOptionsProto.CalculatorOptions)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setOptions(CalculatorOptionsProto.CalculatorOptions calculatorOptions) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$11100((CalculatorProto$CalculatorGraphConfig$Node)this.instance, calculatorOptions);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setOutputSidePacket(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$10600((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setOutputStream(int n10, String string2) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$9600((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10, string2);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setOutputStreamHandler(StreamHandler.OutputStreamHandlerConfig.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = (CalculatorProto$CalculatorGraphConfig$Node)this.instance;
        builder = (StreamHandler.OutputStreamHandlerConfig)builder.build();
        CalculatorProto$CalculatorGraphConfig$Node.access$12700(calculatorProto$CalculatorGraphConfig$Node, (StreamHandler.OutputStreamHandlerConfig)builder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setOutputStreamHandler(StreamHandler.OutputStreamHandlerConfig outputStreamHandlerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$12700((CalculatorProto$CalculatorGraphConfig$Node)this.instance, outputStreamHandlerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setProfilerConfig(CalculatorProto$ProfilerConfig$Builder calculatorProto$ProfilerConfigOrBuilder) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node calculatorProto$CalculatorGraphConfig$Node = (CalculatorProto$CalculatorGraphConfig$Node)this.instance;
        calculatorProto$ProfilerConfigOrBuilder = (CalculatorProto$ProfilerConfig)calculatorProto$ProfilerConfigOrBuilder.build();
        CalculatorProto$CalculatorGraphConfig$Node.access$13900(calculatorProto$CalculatorGraphConfig$Node, (CalculatorProto$ProfilerConfig)calculatorProto$ProfilerConfigOrBuilder);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setProfilerConfig(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$13900((CalculatorProto$CalculatorGraphConfig$Node)this.instance, calculatorProto$ProfilerConfig);
        return this;
    }

    public CalculatorProto$CalculatorGraphConfig$Node$Builder setSourceLayer(int n10) {
        this.copyOnWrite();
        CalculatorProto$CalculatorGraphConfig$Node.access$12000((CalculatorProto$CalculatorGraphConfig$Node)this.instance, n10);
        return this;
    }
}


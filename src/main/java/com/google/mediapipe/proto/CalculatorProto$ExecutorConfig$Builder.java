/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  mediapipe.MediapipeOptions$MediaPipeOptions
 *  mediapipe.MediapipeOptions$MediaPipeOptions$Builder
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$ExecutorConfig;
import com.google.mediapipe.proto.CalculatorProto$ExecutorConfigOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import mediapipe.MediapipeOptions;

public final class CalculatorProto$ExecutorConfig$Builder
extends GeneratedMessageLite$Builder
implements CalculatorProto$ExecutorConfigOrBuilder {
    private CalculatorProto$ExecutorConfig$Builder() {
        CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig = CalculatorProto$ExecutorConfig.access$000();
        super(calculatorProto$ExecutorConfig);
    }

    public /* synthetic */ CalculatorProto$ExecutorConfig$Builder(CalculatorProto$1 calculatorProto$1) {
        this();
    }

    public CalculatorProto$ExecutorConfig$Builder clearName() {
        this.copyOnWrite();
        CalculatorProto$ExecutorConfig.access$200((CalculatorProto$ExecutorConfig)this.instance);
        return this;
    }

    public CalculatorProto$ExecutorConfig$Builder clearOptions() {
        this.copyOnWrite();
        CalculatorProto$ExecutorConfig.access$900((CalculatorProto$ExecutorConfig)this.instance);
        return this;
    }

    public CalculatorProto$ExecutorConfig$Builder clearType() {
        this.copyOnWrite();
        CalculatorProto$ExecutorConfig.access$500((CalculatorProto$ExecutorConfig)this.instance);
        return this;
    }

    public String getName() {
        return ((CalculatorProto$ExecutorConfig)this.instance).getName();
    }

    public ByteString getNameBytes() {
        return ((CalculatorProto$ExecutorConfig)this.instance).getNameBytes();
    }

    public MediapipeOptions.MediaPipeOptions getOptions() {
        return ((CalculatorProto$ExecutorConfig)this.instance).getOptions();
    }

    public String getType() {
        return ((CalculatorProto$ExecutorConfig)this.instance).getType();
    }

    public ByteString getTypeBytes() {
        return ((CalculatorProto$ExecutorConfig)this.instance).getTypeBytes();
    }

    public boolean hasOptions() {
        return ((CalculatorProto$ExecutorConfig)this.instance).hasOptions();
    }

    public CalculatorProto$ExecutorConfig$Builder mergeOptions(MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        this.copyOnWrite();
        CalculatorProto$ExecutorConfig.access$800((CalculatorProto$ExecutorConfig)this.instance, mediaPipeOptions);
        return this;
    }

    public CalculatorProto$ExecutorConfig$Builder setName(String string2) {
        this.copyOnWrite();
        CalculatorProto$ExecutorConfig.access$100((CalculatorProto$ExecutorConfig)this.instance, string2);
        return this;
    }

    public CalculatorProto$ExecutorConfig$Builder setNameBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$ExecutorConfig.access$300((CalculatorProto$ExecutorConfig)this.instance, byteString);
        return this;
    }

    public CalculatorProto$ExecutorConfig$Builder setOptions(MediapipeOptions.MediaPipeOptions.Builder builder) {
        this.copyOnWrite();
        CalculatorProto$ExecutorConfig calculatorProto$ExecutorConfig = (CalculatorProto$ExecutorConfig)this.instance;
        builder = (MediapipeOptions.MediaPipeOptions)builder.build();
        CalculatorProto$ExecutorConfig.access$700(calculatorProto$ExecutorConfig, (MediapipeOptions.MediaPipeOptions)builder);
        return this;
    }

    public CalculatorProto$ExecutorConfig$Builder setOptions(MediapipeOptions.MediaPipeOptions mediaPipeOptions) {
        this.copyOnWrite();
        CalculatorProto$ExecutorConfig.access$700((CalculatorProto$ExecutorConfig)this.instance, mediaPipeOptions);
        return this;
    }

    public CalculatorProto$ExecutorConfig$Builder setType(String string2) {
        this.copyOnWrite();
        CalculatorProto$ExecutorConfig.access$400((CalculatorProto$ExecutorConfig)this.instance, string2);
        return this;
    }

    public CalculatorProto$ExecutorConfig$Builder setTypeBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$ExecutorConfig.access$600((CalculatorProto$ExecutorConfig)this.instance, byteString);
        return this;
    }
}


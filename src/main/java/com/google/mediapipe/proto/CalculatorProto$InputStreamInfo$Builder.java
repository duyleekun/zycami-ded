/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$InputStreamInfo;
import com.google.mediapipe.proto.CalculatorProto$InputStreamInfoOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class CalculatorProto$InputStreamInfo$Builder
extends GeneratedMessageLite$Builder
implements CalculatorProto$InputStreamInfoOrBuilder {
    private CalculatorProto$InputStreamInfo$Builder() {
        CalculatorProto$InputStreamInfo calculatorProto$InputStreamInfo = CalculatorProto$InputStreamInfo.access$4000();
        super(calculatorProto$InputStreamInfo);
    }

    public /* synthetic */ CalculatorProto$InputStreamInfo$Builder(CalculatorProto$1 calculatorProto$1) {
        this();
    }

    public CalculatorProto$InputStreamInfo$Builder clearBackEdge() {
        this.copyOnWrite();
        CalculatorProto$InputStreamInfo.access$4500((CalculatorProto$InputStreamInfo)this.instance);
        return this;
    }

    public CalculatorProto$InputStreamInfo$Builder clearTagIndex() {
        this.copyOnWrite();
        CalculatorProto$InputStreamInfo.access$4200((CalculatorProto$InputStreamInfo)this.instance);
        return this;
    }

    public boolean getBackEdge() {
        return ((CalculatorProto$InputStreamInfo)this.instance).getBackEdge();
    }

    public String getTagIndex() {
        return ((CalculatorProto$InputStreamInfo)this.instance).getTagIndex();
    }

    public ByteString getTagIndexBytes() {
        return ((CalculatorProto$InputStreamInfo)this.instance).getTagIndexBytes();
    }

    public CalculatorProto$InputStreamInfo$Builder setBackEdge(boolean bl2) {
        this.copyOnWrite();
        CalculatorProto$InputStreamInfo.access$4400((CalculatorProto$InputStreamInfo)this.instance, bl2);
        return this;
    }

    public CalculatorProto$InputStreamInfo$Builder setTagIndex(String string2) {
        this.copyOnWrite();
        CalculatorProto$InputStreamInfo.access$4100((CalculatorProto$InputStreamInfo)this.instance, string2);
        return this;
    }

    public CalculatorProto$InputStreamInfo$Builder setTagIndexBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$InputStreamInfo.access$4300((CalculatorProto$InputStreamInfo)this.instance, byteString);
        return this;
    }
}


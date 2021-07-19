/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LandmarkProto$1;
import com.google.mediapipe.formats.proto.LandmarkProto$Landmark;
import com.google.mediapipe.formats.proto.LandmarkProto$LandmarkOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class LandmarkProto$Landmark$Builder
extends GeneratedMessageLite$Builder
implements LandmarkProto$LandmarkOrBuilder {
    private LandmarkProto$Landmark$Builder() {
        LandmarkProto$Landmark landmarkProto$Landmark = LandmarkProto$Landmark.access$000();
        super(landmarkProto$Landmark);
    }

    public /* synthetic */ LandmarkProto$Landmark$Builder(LandmarkProto$1 landmarkProto$1) {
        this();
    }

    public LandmarkProto$Landmark$Builder clearX() {
        this.copyOnWrite();
        LandmarkProto$Landmark.access$200((LandmarkProto$Landmark)this.instance);
        return this;
    }

    public LandmarkProto$Landmark$Builder clearY() {
        this.copyOnWrite();
        LandmarkProto$Landmark.access$400((LandmarkProto$Landmark)this.instance);
        return this;
    }

    public LandmarkProto$Landmark$Builder clearZ() {
        this.copyOnWrite();
        LandmarkProto$Landmark.access$600((LandmarkProto$Landmark)this.instance);
        return this;
    }

    public float getX() {
        return ((LandmarkProto$Landmark)this.instance).getX();
    }

    public float getY() {
        return ((LandmarkProto$Landmark)this.instance).getY();
    }

    public float getZ() {
        return ((LandmarkProto$Landmark)this.instance).getZ();
    }

    public boolean hasX() {
        return ((LandmarkProto$Landmark)this.instance).hasX();
    }

    public boolean hasY() {
        return ((LandmarkProto$Landmark)this.instance).hasY();
    }

    public boolean hasZ() {
        return ((LandmarkProto$Landmark)this.instance).hasZ();
    }

    public LandmarkProto$Landmark$Builder setX(float f10) {
        this.copyOnWrite();
        LandmarkProto$Landmark.access$100((LandmarkProto$Landmark)this.instance, f10);
        return this;
    }

    public LandmarkProto$Landmark$Builder setY(float f10) {
        this.copyOnWrite();
        LandmarkProto$Landmark.access$300((LandmarkProto$Landmark)this.instance, f10);
        return this;
    }

    public LandmarkProto$Landmark$Builder setZ(float f10) {
        this.copyOnWrite();
        LandmarkProto$Landmark.access$500((LandmarkProto$Landmark)this.instance, f10);
        return this;
    }
}


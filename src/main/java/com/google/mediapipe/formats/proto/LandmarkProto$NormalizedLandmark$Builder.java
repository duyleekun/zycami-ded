/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LandmarkProto$1;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmark;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmarkOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class LandmarkProto$NormalizedLandmark$Builder
extends GeneratedMessageLite$Builder
implements LandmarkProto$NormalizedLandmarkOrBuilder {
    private LandmarkProto$NormalizedLandmark$Builder() {
        LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark = LandmarkProto$NormalizedLandmark.access$1600();
        super(landmarkProto$NormalizedLandmark);
    }

    public /* synthetic */ LandmarkProto$NormalizedLandmark$Builder(LandmarkProto$1 landmarkProto$1) {
        this();
    }

    public LandmarkProto$NormalizedLandmark$Builder clearX() {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmark.access$1800((LandmarkProto$NormalizedLandmark)this.instance);
        return this;
    }

    public LandmarkProto$NormalizedLandmark$Builder clearY() {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmark.access$2000((LandmarkProto$NormalizedLandmark)this.instance);
        return this;
    }

    public LandmarkProto$NormalizedLandmark$Builder clearZ() {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmark.access$2200((LandmarkProto$NormalizedLandmark)this.instance);
        return this;
    }

    public float getX() {
        return ((LandmarkProto$NormalizedLandmark)this.instance).getX();
    }

    public float getY() {
        return ((LandmarkProto$NormalizedLandmark)this.instance).getY();
    }

    public float getZ() {
        return ((LandmarkProto$NormalizedLandmark)this.instance).getZ();
    }

    public boolean hasX() {
        return ((LandmarkProto$NormalizedLandmark)this.instance).hasX();
    }

    public boolean hasY() {
        return ((LandmarkProto$NormalizedLandmark)this.instance).hasY();
    }

    public boolean hasZ() {
        return ((LandmarkProto$NormalizedLandmark)this.instance).hasZ();
    }

    public LandmarkProto$NormalizedLandmark$Builder setX(float f10) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmark.access$1700((LandmarkProto$NormalizedLandmark)this.instance, f10);
        return this;
    }

    public LandmarkProto$NormalizedLandmark$Builder setY(float f10) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmark.access$1900((LandmarkProto$NormalizedLandmark)this.instance, f10);
        return this;
    }

    public LandmarkProto$NormalizedLandmark$Builder setZ(float f10) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmark.access$2100((LandmarkProto$NormalizedLandmark)this.instance, f10);
        return this;
    }
}


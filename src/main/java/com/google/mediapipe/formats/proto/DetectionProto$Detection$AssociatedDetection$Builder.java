/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.DetectionProto$1;
import com.google.mediapipe.formats.proto.DetectionProto$Detection$AssociatedDetection;
import com.google.mediapipe.formats.proto.DetectionProto$Detection$AssociatedDetectionOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class DetectionProto$Detection$AssociatedDetection$Builder
extends GeneratedMessageLite$Builder
implements DetectionProto$Detection$AssociatedDetectionOrBuilder {
    private DetectionProto$Detection$AssociatedDetection$Builder() {
        DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection = DetectionProto$Detection$AssociatedDetection.access$000();
        super(detectionProto$Detection$AssociatedDetection);
    }

    public /* synthetic */ DetectionProto$Detection$AssociatedDetection$Builder(DetectionProto$1 detectionProto$1) {
        this();
    }

    public DetectionProto$Detection$AssociatedDetection$Builder clearConfidence() {
        this.copyOnWrite();
        DetectionProto$Detection$AssociatedDetection.access$400((DetectionProto$Detection$AssociatedDetection)this.instance);
        return this;
    }

    public DetectionProto$Detection$AssociatedDetection$Builder clearId() {
        this.copyOnWrite();
        DetectionProto$Detection$AssociatedDetection.access$200((DetectionProto$Detection$AssociatedDetection)this.instance);
        return this;
    }

    public float getConfidence() {
        return ((DetectionProto$Detection$AssociatedDetection)this.instance).getConfidence();
    }

    public int getId() {
        return ((DetectionProto$Detection$AssociatedDetection)this.instance).getId();
    }

    public boolean hasConfidence() {
        return ((DetectionProto$Detection$AssociatedDetection)this.instance).hasConfidence();
    }

    public boolean hasId() {
        return ((DetectionProto$Detection$AssociatedDetection)this.instance).hasId();
    }

    public DetectionProto$Detection$AssociatedDetection$Builder setConfidence(float f10) {
        this.copyOnWrite();
        DetectionProto$Detection$AssociatedDetection.access$300((DetectionProto$Detection$AssociatedDetection)this.instance, f10);
        return this;
    }

    public DetectionProto$Detection$AssociatedDetection$Builder setId(int n10) {
        this.copyOnWrite();
        DetectionProto$Detection$AssociatedDetection.access$100((DetectionProto$Detection$AssociatedDetection)this.instance, n10);
        return this;
    }
}


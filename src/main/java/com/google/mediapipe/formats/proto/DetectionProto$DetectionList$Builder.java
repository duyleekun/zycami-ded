/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.DetectionProto$1;
import com.google.mediapipe.formats.proto.DetectionProto$Detection;
import com.google.mediapipe.formats.proto.DetectionProto$Detection$Builder;
import com.google.mediapipe.formats.proto.DetectionProto$DetectionList;
import com.google.mediapipe.formats.proto.DetectionProto$DetectionListOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;

public final class DetectionProto$DetectionList$Builder
extends GeneratedMessageLite$Builder
implements DetectionProto$DetectionListOrBuilder {
    private DetectionProto$DetectionList$Builder() {
        DetectionProto$DetectionList detectionProto$DetectionList = DetectionProto$DetectionList.access$4500();
        super(detectionProto$DetectionList);
    }

    public /* synthetic */ DetectionProto$DetectionList$Builder(DetectionProto$1 detectionProto$1) {
        this();
    }

    public DetectionProto$DetectionList$Builder addAllDetection(Iterable iterable) {
        this.copyOnWrite();
        DetectionProto$DetectionList.access$4900((DetectionProto$DetectionList)this.instance, iterable);
        return this;
    }

    public DetectionProto$DetectionList$Builder addDetection(int n10, DetectionProto$Detection$Builder detectionProto$DetectionOrBuilder) {
        this.copyOnWrite();
        DetectionProto$DetectionList detectionProto$DetectionList = (DetectionProto$DetectionList)this.instance;
        detectionProto$DetectionOrBuilder = (DetectionProto$Detection)detectionProto$DetectionOrBuilder.build();
        DetectionProto$DetectionList.access$4800(detectionProto$DetectionList, n10, (DetectionProto$Detection)detectionProto$DetectionOrBuilder);
        return this;
    }

    public DetectionProto$DetectionList$Builder addDetection(int n10, DetectionProto$Detection detectionProto$Detection) {
        this.copyOnWrite();
        DetectionProto$DetectionList.access$4800((DetectionProto$DetectionList)this.instance, n10, detectionProto$Detection);
        return this;
    }

    public DetectionProto$DetectionList$Builder addDetection(DetectionProto$Detection$Builder detectionProto$DetectionOrBuilder) {
        this.copyOnWrite();
        DetectionProto$DetectionList detectionProto$DetectionList = (DetectionProto$DetectionList)this.instance;
        detectionProto$DetectionOrBuilder = (DetectionProto$Detection)detectionProto$DetectionOrBuilder.build();
        DetectionProto$DetectionList.access$4700(detectionProto$DetectionList, (DetectionProto$Detection)detectionProto$DetectionOrBuilder);
        return this;
    }

    public DetectionProto$DetectionList$Builder addDetection(DetectionProto$Detection detectionProto$Detection) {
        this.copyOnWrite();
        DetectionProto$DetectionList.access$4700((DetectionProto$DetectionList)this.instance, detectionProto$Detection);
        return this;
    }

    public DetectionProto$DetectionList$Builder clearDetection() {
        this.copyOnWrite();
        DetectionProto$DetectionList.access$5000((DetectionProto$DetectionList)this.instance);
        return this;
    }

    public DetectionProto$Detection getDetection(int n10) {
        return ((DetectionProto$DetectionList)this.instance).getDetection(n10);
    }

    public int getDetectionCount() {
        return ((DetectionProto$DetectionList)this.instance).getDetectionCount();
    }

    public List getDetectionList() {
        return Collections.unmodifiableList(((DetectionProto$DetectionList)this.instance).getDetectionList());
    }

    public DetectionProto$DetectionList$Builder removeDetection(int n10) {
        this.copyOnWrite();
        DetectionProto$DetectionList.access$5100((DetectionProto$DetectionList)this.instance, n10);
        return this;
    }

    public DetectionProto$DetectionList$Builder setDetection(int n10, DetectionProto$Detection$Builder detectionProto$DetectionOrBuilder) {
        this.copyOnWrite();
        DetectionProto$DetectionList detectionProto$DetectionList = (DetectionProto$DetectionList)this.instance;
        detectionProto$DetectionOrBuilder = (DetectionProto$Detection)detectionProto$DetectionOrBuilder.build();
        DetectionProto$DetectionList.access$4600(detectionProto$DetectionList, n10, (DetectionProto$Detection)detectionProto$DetectionOrBuilder);
        return this;
    }

    public DetectionProto$DetectionList$Builder setDetection(int n10, DetectionProto$Detection detectionProto$Detection) {
        this.copyOnWrite();
        DetectionProto$DetectionList.access$4600((DetectionProto$DetectionList)this.instance, n10, detectionProto$Detection);
        return this;
    }
}


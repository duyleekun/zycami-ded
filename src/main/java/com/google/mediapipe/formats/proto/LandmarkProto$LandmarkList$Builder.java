/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LandmarkProto$1;
import com.google.mediapipe.formats.proto.LandmarkProto$Landmark;
import com.google.mediapipe.formats.proto.LandmarkProto$Landmark$Builder;
import com.google.mediapipe.formats.proto.LandmarkProto$LandmarkList;
import com.google.mediapipe.formats.proto.LandmarkProto$LandmarkListOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;

public final class LandmarkProto$LandmarkList$Builder
extends GeneratedMessageLite$Builder
implements LandmarkProto$LandmarkListOrBuilder {
    private LandmarkProto$LandmarkList$Builder() {
        LandmarkProto$LandmarkList landmarkProto$LandmarkList = LandmarkProto$LandmarkList.access$800();
        super(landmarkProto$LandmarkList);
    }

    public /* synthetic */ LandmarkProto$LandmarkList$Builder(LandmarkProto$1 landmarkProto$1) {
        this();
    }

    public LandmarkProto$LandmarkList$Builder addAllLandmark(Iterable iterable) {
        this.copyOnWrite();
        LandmarkProto$LandmarkList.access$1200((LandmarkProto$LandmarkList)this.instance, iterable);
        return this;
    }

    public LandmarkProto$LandmarkList$Builder addLandmark(int n10, LandmarkProto$Landmark$Builder landmarkProto$LandmarkOrBuilder) {
        this.copyOnWrite();
        LandmarkProto$LandmarkList landmarkProto$LandmarkList = (LandmarkProto$LandmarkList)this.instance;
        landmarkProto$LandmarkOrBuilder = (LandmarkProto$Landmark)landmarkProto$LandmarkOrBuilder.build();
        LandmarkProto$LandmarkList.access$1100(landmarkProto$LandmarkList, n10, (LandmarkProto$Landmark)landmarkProto$LandmarkOrBuilder);
        return this;
    }

    public LandmarkProto$LandmarkList$Builder addLandmark(int n10, LandmarkProto$Landmark landmarkProto$Landmark) {
        this.copyOnWrite();
        LandmarkProto$LandmarkList.access$1100((LandmarkProto$LandmarkList)this.instance, n10, landmarkProto$Landmark);
        return this;
    }

    public LandmarkProto$LandmarkList$Builder addLandmark(LandmarkProto$Landmark$Builder landmarkProto$LandmarkOrBuilder) {
        this.copyOnWrite();
        LandmarkProto$LandmarkList landmarkProto$LandmarkList = (LandmarkProto$LandmarkList)this.instance;
        landmarkProto$LandmarkOrBuilder = (LandmarkProto$Landmark)landmarkProto$LandmarkOrBuilder.build();
        LandmarkProto$LandmarkList.access$1000(landmarkProto$LandmarkList, (LandmarkProto$Landmark)landmarkProto$LandmarkOrBuilder);
        return this;
    }

    public LandmarkProto$LandmarkList$Builder addLandmark(LandmarkProto$Landmark landmarkProto$Landmark) {
        this.copyOnWrite();
        LandmarkProto$LandmarkList.access$1000((LandmarkProto$LandmarkList)this.instance, landmarkProto$Landmark);
        return this;
    }

    public LandmarkProto$LandmarkList$Builder clearLandmark() {
        this.copyOnWrite();
        LandmarkProto$LandmarkList.access$1300((LandmarkProto$LandmarkList)this.instance);
        return this;
    }

    public LandmarkProto$Landmark getLandmark(int n10) {
        return ((LandmarkProto$LandmarkList)this.instance).getLandmark(n10);
    }

    public int getLandmarkCount() {
        return ((LandmarkProto$LandmarkList)this.instance).getLandmarkCount();
    }

    public List getLandmarkList() {
        return Collections.unmodifiableList(((LandmarkProto$LandmarkList)this.instance).getLandmarkList());
    }

    public LandmarkProto$LandmarkList$Builder removeLandmark(int n10) {
        this.copyOnWrite();
        LandmarkProto$LandmarkList.access$1400((LandmarkProto$LandmarkList)this.instance, n10);
        return this;
    }

    public LandmarkProto$LandmarkList$Builder setLandmark(int n10, LandmarkProto$Landmark$Builder landmarkProto$LandmarkOrBuilder) {
        this.copyOnWrite();
        LandmarkProto$LandmarkList landmarkProto$LandmarkList = (LandmarkProto$LandmarkList)this.instance;
        landmarkProto$LandmarkOrBuilder = (LandmarkProto$Landmark)landmarkProto$LandmarkOrBuilder.build();
        LandmarkProto$LandmarkList.access$900(landmarkProto$LandmarkList, n10, (LandmarkProto$Landmark)landmarkProto$LandmarkOrBuilder);
        return this;
    }

    public LandmarkProto$LandmarkList$Builder setLandmark(int n10, LandmarkProto$Landmark landmarkProto$Landmark) {
        this.copyOnWrite();
        LandmarkProto$LandmarkList.access$900((LandmarkProto$LandmarkList)this.instance, n10, landmarkProto$Landmark);
        return this;
    }
}


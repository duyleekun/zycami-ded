/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LandmarkProto$1;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmark;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmark$Builder;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmarkList;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmarkListOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;

public final class LandmarkProto$NormalizedLandmarkList$Builder
extends GeneratedMessageLite$Builder
implements LandmarkProto$NormalizedLandmarkListOrBuilder {
    private LandmarkProto$NormalizedLandmarkList$Builder() {
        LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList = LandmarkProto$NormalizedLandmarkList.access$2400();
        super(landmarkProto$NormalizedLandmarkList);
    }

    public /* synthetic */ LandmarkProto$NormalizedLandmarkList$Builder(LandmarkProto$1 landmarkProto$1) {
        this();
    }

    public LandmarkProto$NormalizedLandmarkList$Builder addAllLandmark(Iterable iterable) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmarkList.access$2800((LandmarkProto$NormalizedLandmarkList)this.instance, iterable);
        return this;
    }

    public LandmarkProto$NormalizedLandmarkList$Builder addLandmark(int n10, LandmarkProto$NormalizedLandmark$Builder landmarkProto$NormalizedLandmarkOrBuilder) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList = (LandmarkProto$NormalizedLandmarkList)this.instance;
        landmarkProto$NormalizedLandmarkOrBuilder = (LandmarkProto$NormalizedLandmark)landmarkProto$NormalizedLandmarkOrBuilder.build();
        LandmarkProto$NormalizedLandmarkList.access$2700(landmarkProto$NormalizedLandmarkList, n10, (LandmarkProto$NormalizedLandmark)landmarkProto$NormalizedLandmarkOrBuilder);
        return this;
    }

    public LandmarkProto$NormalizedLandmarkList$Builder addLandmark(int n10, LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmarkList.access$2700((LandmarkProto$NormalizedLandmarkList)this.instance, n10, landmarkProto$NormalizedLandmark);
        return this;
    }

    public LandmarkProto$NormalizedLandmarkList$Builder addLandmark(LandmarkProto$NormalizedLandmark$Builder landmarkProto$NormalizedLandmarkOrBuilder) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList = (LandmarkProto$NormalizedLandmarkList)this.instance;
        landmarkProto$NormalizedLandmarkOrBuilder = (LandmarkProto$NormalizedLandmark)landmarkProto$NormalizedLandmarkOrBuilder.build();
        LandmarkProto$NormalizedLandmarkList.access$2600(landmarkProto$NormalizedLandmarkList, (LandmarkProto$NormalizedLandmark)landmarkProto$NormalizedLandmarkOrBuilder);
        return this;
    }

    public LandmarkProto$NormalizedLandmarkList$Builder addLandmark(LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmarkList.access$2600((LandmarkProto$NormalizedLandmarkList)this.instance, landmarkProto$NormalizedLandmark);
        return this;
    }

    public LandmarkProto$NormalizedLandmarkList$Builder clearLandmark() {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmarkList.access$2900((LandmarkProto$NormalizedLandmarkList)this.instance);
        return this;
    }

    public LandmarkProto$NormalizedLandmark getLandmark(int n10) {
        return ((LandmarkProto$NormalizedLandmarkList)this.instance).getLandmark(n10);
    }

    public int getLandmarkCount() {
        return ((LandmarkProto$NormalizedLandmarkList)this.instance).getLandmarkCount();
    }

    public List getLandmarkList() {
        return Collections.unmodifiableList(((LandmarkProto$NormalizedLandmarkList)this.instance).getLandmarkList());
    }

    public LandmarkProto$NormalizedLandmarkList$Builder removeLandmark(int n10) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmarkList.access$3000((LandmarkProto$NormalizedLandmarkList)this.instance, n10);
        return this;
    }

    public LandmarkProto$NormalizedLandmarkList$Builder setLandmark(int n10, LandmarkProto$NormalizedLandmark$Builder landmarkProto$NormalizedLandmarkOrBuilder) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList = (LandmarkProto$NormalizedLandmarkList)this.instance;
        landmarkProto$NormalizedLandmarkOrBuilder = (LandmarkProto$NormalizedLandmark)landmarkProto$NormalizedLandmarkOrBuilder.build();
        LandmarkProto$NormalizedLandmarkList.access$2500(landmarkProto$NormalizedLandmarkList, n10, (LandmarkProto$NormalizedLandmark)landmarkProto$NormalizedLandmarkOrBuilder);
        return this;
    }

    public LandmarkProto$NormalizedLandmarkList$Builder setLandmark(int n10, LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        this.copyOnWrite();
        LandmarkProto$NormalizedLandmarkList.access$2500((LandmarkProto$NormalizedLandmarkList)this.instance, n10, landmarkProto$NormalizedLandmark);
        return this;
    }
}


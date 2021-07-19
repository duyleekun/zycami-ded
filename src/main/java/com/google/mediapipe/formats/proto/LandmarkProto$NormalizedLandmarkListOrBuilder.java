/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmark;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface LandmarkProto$NormalizedLandmarkListOrBuilder
extends MessageLiteOrBuilder {
    public LandmarkProto.NormalizedLandmark getLandmark(int var1);

    public int getLandmarkCount();

    public List getLandmarkList();
}


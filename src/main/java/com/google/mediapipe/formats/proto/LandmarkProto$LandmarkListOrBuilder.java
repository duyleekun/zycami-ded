/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LandmarkProto$Landmark;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface LandmarkProto$LandmarkListOrBuilder
extends MessageLiteOrBuilder {
    public LandmarkProto.Landmark getLandmark(int var1);

    public int getLandmarkCount();

    public List getLandmarkList();
}


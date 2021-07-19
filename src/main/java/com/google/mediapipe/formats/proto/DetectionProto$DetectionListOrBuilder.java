/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.DetectionProto$Detection;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface DetectionProto$DetectionListOrBuilder
extends MessageLiteOrBuilder {
    public DetectionProto.Detection getDetection(int var1);

    public int getDetectionCount();

    public List getDetectionList();
}


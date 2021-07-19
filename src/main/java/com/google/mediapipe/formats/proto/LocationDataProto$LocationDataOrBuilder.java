/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BinaryMask;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$BoundingBox;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$Format;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeBoundingBox;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeKeypoint;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface LocationDataProto$LocationDataOrBuilder
extends MessageLiteOrBuilder {
    public LocationDataProto$LocationData.BoundingBox getBoundingBox();

    public LocationDataProto$LocationData$Format getFormat();

    public LocationDataProto$LocationData.BinaryMask getMask();

    public LocationDataProto$LocationData.RelativeBoundingBox getRelativeBoundingBox();

    public LocationDataProto$LocationData.RelativeKeypoint getRelativeKeypoints(int var1);

    public int getRelativeKeypointsCount();

    public List getRelativeKeypointsList();

    public boolean hasBoundingBox();

    public boolean hasFormat();

    public boolean hasMask();

    public boolean hasRelativeBoundingBox();
}


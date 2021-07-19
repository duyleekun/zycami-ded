/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization;
import com.google.protobuf.MessageLiteOrBuilder;

public interface LocationDataProto$LocationData$BinaryMaskOrBuilder
extends MessageLiteOrBuilder {
    public int getHeight();

    public RasterizationProto.Rasterization getRasterization();

    public int getWidth();

    public boolean hasHeight();

    public boolean hasRasterization();

    public boolean hasWidth();
}


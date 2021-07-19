/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface LocationDataProto$LocationData$RelativeKeypointOrBuilder
extends MessageLiteOrBuilder {
    public String getKeypointLabel();

    public ByteString getKeypointLabelBytes();

    public float getScore();

    public float getX();

    public float getY();

    public boolean hasKeypointLabel();

    public boolean hasScore();

    public boolean hasX();

    public boolean hasY();
}


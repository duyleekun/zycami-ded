/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LocationDataProto$1;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeKeypoint;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$RelativeKeypointOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class LocationDataProto$LocationData$RelativeKeypoint$Builder
extends GeneratedMessageLite$Builder
implements LocationDataProto$LocationData$RelativeKeypointOrBuilder {
    private LocationDataProto$LocationData$RelativeKeypoint$Builder() {
        LocationDataProto$LocationData$RelativeKeypoint locationDataProto$LocationData$RelativeKeypoint = LocationDataProto$LocationData$RelativeKeypoint.access$2900();
        super(locationDataProto$LocationData$RelativeKeypoint);
    }

    public /* synthetic */ LocationDataProto$LocationData$RelativeKeypoint$Builder(LocationDataProto$1 locationDataProto$1) {
        this();
    }

    public LocationDataProto$LocationData$RelativeKeypoint$Builder clearKeypointLabel() {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeKeypoint.access$3500((LocationDataProto$LocationData$RelativeKeypoint)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$RelativeKeypoint$Builder clearScore() {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeKeypoint.access$3800((LocationDataProto$LocationData$RelativeKeypoint)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$RelativeKeypoint$Builder clearX() {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeKeypoint.access$3100((LocationDataProto$LocationData$RelativeKeypoint)this.instance);
        return this;
    }

    public LocationDataProto$LocationData$RelativeKeypoint$Builder clearY() {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeKeypoint.access$3300((LocationDataProto$LocationData$RelativeKeypoint)this.instance);
        return this;
    }

    public String getKeypointLabel() {
        return ((LocationDataProto$LocationData$RelativeKeypoint)this.instance).getKeypointLabel();
    }

    public ByteString getKeypointLabelBytes() {
        return ((LocationDataProto$LocationData$RelativeKeypoint)this.instance).getKeypointLabelBytes();
    }

    public float getScore() {
        return ((LocationDataProto$LocationData$RelativeKeypoint)this.instance).getScore();
    }

    public float getX() {
        return ((LocationDataProto$LocationData$RelativeKeypoint)this.instance).getX();
    }

    public float getY() {
        return ((LocationDataProto$LocationData$RelativeKeypoint)this.instance).getY();
    }

    public boolean hasKeypointLabel() {
        return ((LocationDataProto$LocationData$RelativeKeypoint)this.instance).hasKeypointLabel();
    }

    public boolean hasScore() {
        return ((LocationDataProto$LocationData$RelativeKeypoint)this.instance).hasScore();
    }

    public boolean hasX() {
        return ((LocationDataProto$LocationData$RelativeKeypoint)this.instance).hasX();
    }

    public boolean hasY() {
        return ((LocationDataProto$LocationData$RelativeKeypoint)this.instance).hasY();
    }

    public LocationDataProto$LocationData$RelativeKeypoint$Builder setKeypointLabel(String string2) {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeKeypoint.access$3400((LocationDataProto$LocationData$RelativeKeypoint)this.instance, string2);
        return this;
    }

    public LocationDataProto$LocationData$RelativeKeypoint$Builder setKeypointLabelBytes(ByteString byteString) {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeKeypoint.access$3600((LocationDataProto$LocationData$RelativeKeypoint)this.instance, byteString);
        return this;
    }

    public LocationDataProto$LocationData$RelativeKeypoint$Builder setScore(float f10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeKeypoint.access$3700((LocationDataProto$LocationData$RelativeKeypoint)this.instance, f10);
        return this;
    }

    public LocationDataProto$LocationData$RelativeKeypoint$Builder setX(float f10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeKeypoint.access$3000((LocationDataProto$LocationData$RelativeKeypoint)this.instance, f10);
        return this;
    }

    public LocationDataProto$LocationData$RelativeKeypoint$Builder setY(float f10) {
        this.copyOnWrite();
        LocationDataProto$LocationData$RelativeKeypoint.access$3200((LocationDataProto$LocationData$RelativeKeypoint)this.instance, f10);
        return this;
    }
}


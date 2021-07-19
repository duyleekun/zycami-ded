/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.DetectionProto$Detection$AssociatedDetection;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface DetectionProto$DetectionOrBuilder
extends MessageLiteOrBuilder {
    public DetectionProto$Detection.AssociatedDetection getAssociatedDetections(int var1);

    public int getAssociatedDetectionsCount();

    public List getAssociatedDetectionsList();

    public long getDetectionId();

    public String getDisplayName(int var1);

    public ByteString getDisplayNameBytes(int var1);

    public int getDisplayNameCount();

    public List getDisplayNameList();

    public String getFeatureTag();

    public ByteString getFeatureTagBytes();

    public String getLabel(int var1);

    public ByteString getLabelBytes(int var1);

    public int getLabelCount();

    public int getLabelId(int var1);

    public int getLabelIdCount();

    public List getLabelIdList();

    public List getLabelList();

    public LocationDataProto.LocationData getLocationData();

    public float getScore(int var1);

    public int getScoreCount();

    public List getScoreList();

    public long getTimestampUsec();

    public String getTrackId();

    public ByteString getTrackIdBytes();

    public boolean hasDetectionId();

    public boolean hasFeatureTag();

    public boolean hasLocationData();

    public boolean hasTimestampUsec();

    public boolean hasTrackId();
}


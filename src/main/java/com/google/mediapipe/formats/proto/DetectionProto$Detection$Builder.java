/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.DetectionProto$1;
import com.google.mediapipe.formats.proto.DetectionProto$Detection;
import com.google.mediapipe.formats.proto.DetectionProto$Detection$AssociatedDetection;
import com.google.mediapipe.formats.proto.DetectionProto$Detection$AssociatedDetection$Builder;
import com.google.mediapipe.formats.proto.DetectionProto$DetectionOrBuilder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;

public final class DetectionProto$Detection$Builder
extends GeneratedMessageLite$Builder
implements DetectionProto$DetectionOrBuilder {
    private DetectionProto$Detection$Builder() {
        DetectionProto$Detection detectionProto$Detection = DetectionProto$Detection.access$600();
        super(detectionProto$Detection);
    }

    public /* synthetic */ DetectionProto$Detection$Builder(DetectionProto$1 detectionProto$1) {
        this();
    }

    public DetectionProto$Detection$Builder addAllAssociatedDetections(Iterable iterable) {
        this.copyOnWrite();
        DetectionProto$Detection.access$3400((DetectionProto$Detection)this.instance, iterable);
        return this;
    }

    public DetectionProto$Detection$Builder addAllDisplayName(Iterable iterable) {
        this.copyOnWrite();
        DetectionProto$Detection.access$3900((DetectionProto$Detection)this.instance, iterable);
        return this;
    }

    public DetectionProto$Detection$Builder addAllLabel(Iterable iterable) {
        this.copyOnWrite();
        DetectionProto$Detection.access$900((DetectionProto$Detection)this.instance, iterable);
        return this;
    }

    public DetectionProto$Detection$Builder addAllLabelId(Iterable iterable) {
        this.copyOnWrite();
        DetectionProto$Detection.access$1400((DetectionProto$Detection)this.instance, iterable);
        return this;
    }

    public DetectionProto$Detection$Builder addAllScore(Iterable iterable) {
        this.copyOnWrite();
        DetectionProto$Detection.access$1800((DetectionProto$Detection)this.instance, iterable);
        return this;
    }

    public DetectionProto$Detection$Builder addAssociatedDetections(int n10, DetectionProto$Detection$AssociatedDetection$Builder detectionProto$Detection$AssociatedDetectionOrBuilder) {
        this.copyOnWrite();
        DetectionProto$Detection detectionProto$Detection = (DetectionProto$Detection)this.instance;
        detectionProto$Detection$AssociatedDetectionOrBuilder = (DetectionProto$Detection$AssociatedDetection)detectionProto$Detection$AssociatedDetectionOrBuilder.build();
        DetectionProto$Detection.access$3300(detectionProto$Detection, n10, (DetectionProto$Detection$AssociatedDetection)detectionProto$Detection$AssociatedDetectionOrBuilder);
        return this;
    }

    public DetectionProto$Detection$Builder addAssociatedDetections(int n10, DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        this.copyOnWrite();
        DetectionProto$Detection.access$3300((DetectionProto$Detection)this.instance, n10, detectionProto$Detection$AssociatedDetection);
        return this;
    }

    public DetectionProto$Detection$Builder addAssociatedDetections(DetectionProto$Detection$AssociatedDetection$Builder detectionProto$Detection$AssociatedDetectionOrBuilder) {
        this.copyOnWrite();
        DetectionProto$Detection detectionProto$Detection = (DetectionProto$Detection)this.instance;
        detectionProto$Detection$AssociatedDetectionOrBuilder = (DetectionProto$Detection$AssociatedDetection)detectionProto$Detection$AssociatedDetectionOrBuilder.build();
        DetectionProto$Detection.access$3200(detectionProto$Detection, (DetectionProto$Detection$AssociatedDetection)detectionProto$Detection$AssociatedDetectionOrBuilder);
        return this;
    }

    public DetectionProto$Detection$Builder addAssociatedDetections(DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        this.copyOnWrite();
        DetectionProto$Detection.access$3200((DetectionProto$Detection)this.instance, detectionProto$Detection$AssociatedDetection);
        return this;
    }

    public DetectionProto$Detection$Builder addDisplayName(String string2) {
        this.copyOnWrite();
        DetectionProto$Detection.access$3800((DetectionProto$Detection)this.instance, string2);
        return this;
    }

    public DetectionProto$Detection$Builder addDisplayNameBytes(ByteString byteString) {
        this.copyOnWrite();
        DetectionProto$Detection.access$4100((DetectionProto$Detection)this.instance, byteString);
        return this;
    }

    public DetectionProto$Detection$Builder addLabel(String string2) {
        this.copyOnWrite();
        DetectionProto$Detection.access$800((DetectionProto$Detection)this.instance, string2);
        return this;
    }

    public DetectionProto$Detection$Builder addLabelBytes(ByteString byteString) {
        this.copyOnWrite();
        DetectionProto$Detection.access$1100((DetectionProto$Detection)this.instance, byteString);
        return this;
    }

    public DetectionProto$Detection$Builder addLabelId(int n10) {
        this.copyOnWrite();
        DetectionProto$Detection.access$1300((DetectionProto$Detection)this.instance, n10);
        return this;
    }

    public DetectionProto$Detection$Builder addScore(float f10) {
        this.copyOnWrite();
        DetectionProto$Detection.access$1700((DetectionProto$Detection)this.instance, f10);
        return this;
    }

    public DetectionProto$Detection$Builder clearAssociatedDetections() {
        this.copyOnWrite();
        DetectionProto$Detection.access$3500((DetectionProto$Detection)this.instance);
        return this;
    }

    public DetectionProto$Detection$Builder clearDetectionId() {
        this.copyOnWrite();
        DetectionProto$Detection.access$3000((DetectionProto$Detection)this.instance);
        return this;
    }

    public DetectionProto$Detection$Builder clearDisplayName() {
        this.copyOnWrite();
        DetectionProto$Detection.access$4000((DetectionProto$Detection)this.instance);
        return this;
    }

    public DetectionProto$Detection$Builder clearFeatureTag() {
        this.copyOnWrite();
        DetectionProto$Detection.access$2400((DetectionProto$Detection)this.instance);
        return this;
    }

    public DetectionProto$Detection$Builder clearLabel() {
        this.copyOnWrite();
        DetectionProto$Detection.access$1000((DetectionProto$Detection)this.instance);
        return this;
    }

    public DetectionProto$Detection$Builder clearLabelId() {
        this.copyOnWrite();
        DetectionProto$Detection.access$1500((DetectionProto$Detection)this.instance);
        return this;
    }

    public DetectionProto$Detection$Builder clearLocationData() {
        this.copyOnWrite();
        DetectionProto$Detection.access$2200((DetectionProto$Detection)this.instance);
        return this;
    }

    public DetectionProto$Detection$Builder clearScore() {
        this.copyOnWrite();
        DetectionProto$Detection.access$1900((DetectionProto$Detection)this.instance);
        return this;
    }

    public DetectionProto$Detection$Builder clearTimestampUsec() {
        this.copyOnWrite();
        DetectionProto$Detection.access$4300((DetectionProto$Detection)this.instance);
        return this;
    }

    public DetectionProto$Detection$Builder clearTrackId() {
        this.copyOnWrite();
        DetectionProto$Detection.access$2700((DetectionProto$Detection)this.instance);
        return this;
    }

    public DetectionProto$Detection$AssociatedDetection getAssociatedDetections(int n10) {
        return ((DetectionProto$Detection)this.instance).getAssociatedDetections(n10);
    }

    public int getAssociatedDetectionsCount() {
        return ((DetectionProto$Detection)this.instance).getAssociatedDetectionsCount();
    }

    public List getAssociatedDetectionsList() {
        return Collections.unmodifiableList(((DetectionProto$Detection)this.instance).getAssociatedDetectionsList());
    }

    public long getDetectionId() {
        return ((DetectionProto$Detection)this.instance).getDetectionId();
    }

    public String getDisplayName(int n10) {
        return ((DetectionProto$Detection)this.instance).getDisplayName(n10);
    }

    public ByteString getDisplayNameBytes(int n10) {
        return ((DetectionProto$Detection)this.instance).getDisplayNameBytes(n10);
    }

    public int getDisplayNameCount() {
        return ((DetectionProto$Detection)this.instance).getDisplayNameCount();
    }

    public List getDisplayNameList() {
        return Collections.unmodifiableList(((DetectionProto$Detection)this.instance).getDisplayNameList());
    }

    public String getFeatureTag() {
        return ((DetectionProto$Detection)this.instance).getFeatureTag();
    }

    public ByteString getFeatureTagBytes() {
        return ((DetectionProto$Detection)this.instance).getFeatureTagBytes();
    }

    public String getLabel(int n10) {
        return ((DetectionProto$Detection)this.instance).getLabel(n10);
    }

    public ByteString getLabelBytes(int n10) {
        return ((DetectionProto$Detection)this.instance).getLabelBytes(n10);
    }

    public int getLabelCount() {
        return ((DetectionProto$Detection)this.instance).getLabelCount();
    }

    public int getLabelId(int n10) {
        return ((DetectionProto$Detection)this.instance).getLabelId(n10);
    }

    public int getLabelIdCount() {
        return ((DetectionProto$Detection)this.instance).getLabelIdCount();
    }

    public List getLabelIdList() {
        return Collections.unmodifiableList(((DetectionProto$Detection)this.instance).getLabelIdList());
    }

    public List getLabelList() {
        return Collections.unmodifiableList(((DetectionProto$Detection)this.instance).getLabelList());
    }

    public LocationDataProto$LocationData getLocationData() {
        return ((DetectionProto$Detection)this.instance).getLocationData();
    }

    public float getScore(int n10) {
        return ((DetectionProto$Detection)this.instance).getScore(n10);
    }

    public int getScoreCount() {
        return ((DetectionProto$Detection)this.instance).getScoreCount();
    }

    public List getScoreList() {
        return Collections.unmodifiableList(((DetectionProto$Detection)this.instance).getScoreList());
    }

    public long getTimestampUsec() {
        return ((DetectionProto$Detection)this.instance).getTimestampUsec();
    }

    public String getTrackId() {
        return ((DetectionProto$Detection)this.instance).getTrackId();
    }

    public ByteString getTrackIdBytes() {
        return ((DetectionProto$Detection)this.instance).getTrackIdBytes();
    }

    public boolean hasDetectionId() {
        return ((DetectionProto$Detection)this.instance).hasDetectionId();
    }

    public boolean hasFeatureTag() {
        return ((DetectionProto$Detection)this.instance).hasFeatureTag();
    }

    public boolean hasLocationData() {
        return ((DetectionProto$Detection)this.instance).hasLocationData();
    }

    public boolean hasTimestampUsec() {
        return ((DetectionProto$Detection)this.instance).hasTimestampUsec();
    }

    public boolean hasTrackId() {
        return ((DetectionProto$Detection)this.instance).hasTrackId();
    }

    public DetectionProto$Detection$Builder mergeLocationData(LocationDataProto$LocationData locationDataProto$LocationData) {
        this.copyOnWrite();
        DetectionProto$Detection.access$2100((DetectionProto$Detection)this.instance, locationDataProto$LocationData);
        return this;
    }

    public DetectionProto$Detection$Builder removeAssociatedDetections(int n10) {
        this.copyOnWrite();
        DetectionProto$Detection.access$3600((DetectionProto$Detection)this.instance, n10);
        return this;
    }

    public DetectionProto$Detection$Builder setAssociatedDetections(int n10, DetectionProto$Detection$AssociatedDetection$Builder detectionProto$Detection$AssociatedDetectionOrBuilder) {
        this.copyOnWrite();
        DetectionProto$Detection detectionProto$Detection = (DetectionProto$Detection)this.instance;
        detectionProto$Detection$AssociatedDetectionOrBuilder = (DetectionProto$Detection$AssociatedDetection)detectionProto$Detection$AssociatedDetectionOrBuilder.build();
        DetectionProto$Detection.access$3100(detectionProto$Detection, n10, (DetectionProto$Detection$AssociatedDetection)detectionProto$Detection$AssociatedDetectionOrBuilder);
        return this;
    }

    public DetectionProto$Detection$Builder setAssociatedDetections(int n10, DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        this.copyOnWrite();
        DetectionProto$Detection.access$3100((DetectionProto$Detection)this.instance, n10, detectionProto$Detection$AssociatedDetection);
        return this;
    }

    public DetectionProto$Detection$Builder setDetectionId(long l10) {
        this.copyOnWrite();
        DetectionProto$Detection.access$2900((DetectionProto$Detection)this.instance, l10);
        return this;
    }

    public DetectionProto$Detection$Builder setDisplayName(int n10, String string2) {
        this.copyOnWrite();
        DetectionProto$Detection.access$3700((DetectionProto$Detection)this.instance, n10, string2);
        return this;
    }

    public DetectionProto$Detection$Builder setFeatureTag(String string2) {
        this.copyOnWrite();
        DetectionProto$Detection.access$2300((DetectionProto$Detection)this.instance, string2);
        return this;
    }

    public DetectionProto$Detection$Builder setFeatureTagBytes(ByteString byteString) {
        this.copyOnWrite();
        DetectionProto$Detection.access$2500((DetectionProto$Detection)this.instance, byteString);
        return this;
    }

    public DetectionProto$Detection$Builder setLabel(int n10, String string2) {
        this.copyOnWrite();
        DetectionProto$Detection.access$700((DetectionProto$Detection)this.instance, n10, string2);
        return this;
    }

    public DetectionProto$Detection$Builder setLabelId(int n10, int n11) {
        this.copyOnWrite();
        DetectionProto$Detection.access$1200((DetectionProto$Detection)this.instance, n10, n11);
        return this;
    }

    public DetectionProto$Detection$Builder setLocationData(LocationDataProto$LocationData$Builder locationDataProto$LocationDataOrBuilder) {
        this.copyOnWrite();
        DetectionProto$Detection detectionProto$Detection = (DetectionProto$Detection)this.instance;
        locationDataProto$LocationDataOrBuilder = (LocationDataProto$LocationData)locationDataProto$LocationDataOrBuilder.build();
        DetectionProto$Detection.access$2000(detectionProto$Detection, (LocationDataProto$LocationData)locationDataProto$LocationDataOrBuilder);
        return this;
    }

    public DetectionProto$Detection$Builder setLocationData(LocationDataProto$LocationData locationDataProto$LocationData) {
        this.copyOnWrite();
        DetectionProto$Detection.access$2000((DetectionProto$Detection)this.instance, locationDataProto$LocationData);
        return this;
    }

    public DetectionProto$Detection$Builder setScore(int n10, float f10) {
        this.copyOnWrite();
        DetectionProto$Detection.access$1600((DetectionProto$Detection)this.instance, n10, f10);
        return this;
    }

    public DetectionProto$Detection$Builder setTimestampUsec(long l10) {
        this.copyOnWrite();
        DetectionProto$Detection.access$4200((DetectionProto$Detection)this.instance, l10);
        return this;
    }

    public DetectionProto$Detection$Builder setTrackId(String string2) {
        this.copyOnWrite();
        DetectionProto$Detection.access$2600((DetectionProto$Detection)this.instance, string2);
        return this;
    }

    public DetectionProto$Detection$Builder setTrackIdBytes(ByteString byteString) {
        this.copyOnWrite();
        DetectionProto$Detection.access$2800((DetectionProto$Detection)this.instance, byteString);
        return this;
    }
}


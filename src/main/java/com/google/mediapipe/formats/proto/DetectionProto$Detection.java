/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.DetectionProto$1;
import com.google.mediapipe.formats.proto.DetectionProto$Detection$AssociatedDetection;
import com.google.mediapipe.formats.proto.DetectionProto$Detection$AssociatedDetectionOrBuilder;
import com.google.mediapipe.formats.proto.DetectionProto$Detection$Builder;
import com.google.mediapipe.formats.proto.DetectionProto$DetectionOrBuilder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationData$Builder;
import com.google.mediapipe.formats.proto.LocationDataProto$LocationDataOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Internal$FloatList;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DetectionProto$Detection
extends GeneratedMessageLite
implements DetectionProto$DetectionOrBuilder {
    public static final int ASSOCIATED_DETECTIONS_FIELD_NUMBER = 8;
    private static final DetectionProto$Detection DEFAULT_INSTANCE;
    public static final int DETECTION_ID_FIELD_NUMBER = 7;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 9;
    public static final int FEATURE_TAG_FIELD_NUMBER = 5;
    public static final int LABEL_FIELD_NUMBER = 1;
    public static final int LABEL_ID_FIELD_NUMBER = 2;
    public static final int LOCATION_DATA_FIELD_NUMBER = 4;
    private static volatile Parser PARSER;
    public static final int SCORE_FIELD_NUMBER = 3;
    public static final int TIMESTAMP_USEC_FIELD_NUMBER = 10;
    public static final int TRACK_ID_FIELD_NUMBER = 6;
    private Internal$ProtobufList associatedDetections_;
    private int bitField0_;
    private long detectionId_;
    private Internal$ProtobufList displayName_;
    private String featureTag_;
    private int labelIdMemoizedSerializedSize;
    private Internal$IntList labelId_;
    private Internal$ProtobufList label_;
    private LocationDataProto$LocationData locationData_;
    private byte memoizedIsInitialized;
    private int scoreMemoizedSerializedSize;
    private Internal$FloatList score_;
    private long timestampUsec_;
    private String trackId_;

    static {
        DetectionProto$Detection detectionProto$Detection;
        DEFAULT_INSTANCE = detectionProto$Detection = new DetectionProto$Detection();
        GeneratedMessageLite.registerDefaultInstance(DetectionProto$Detection.class, detectionProto$Detection);
    }

    private DetectionProto$Detection() {
        int n10;
        this.labelIdMemoizedSerializedSize = n10 = -1;
        this.scoreMemoizedSerializedSize = n10;
        this.memoizedIsInitialized = (byte)2;
        Object object = GeneratedMessageLite.emptyProtobufList();
        this.label_ = object;
        object = GeneratedMessageLite.emptyIntList();
        this.labelId_ = object;
        object = GeneratedMessageLite.emptyFloatList();
        this.score_ = object;
        this.featureTag_ = object = "";
        this.trackId_ = object;
        this.associatedDetections_ = object = GeneratedMessageLite.emptyProtobufList();
        this.displayName_ = object = GeneratedMessageLite.emptyProtobufList();
    }

    public static /* synthetic */ void access$1000(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.clearLabel();
    }

    public static /* synthetic */ void access$1100(DetectionProto$Detection detectionProto$Detection, ByteString byteString) {
        detectionProto$Detection.addLabelBytes(byteString);
    }

    public static /* synthetic */ void access$1200(DetectionProto$Detection detectionProto$Detection, int n10, int n11) {
        detectionProto$Detection.setLabelId(n10, n11);
    }

    public static /* synthetic */ void access$1300(DetectionProto$Detection detectionProto$Detection, int n10) {
        detectionProto$Detection.addLabelId(n10);
    }

    public static /* synthetic */ void access$1400(DetectionProto$Detection detectionProto$Detection, Iterable iterable) {
        detectionProto$Detection.addAllLabelId(iterable);
    }

    public static /* synthetic */ void access$1500(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.clearLabelId();
    }

    public static /* synthetic */ void access$1600(DetectionProto$Detection detectionProto$Detection, int n10, float f10) {
        detectionProto$Detection.setScore(n10, f10);
    }

    public static /* synthetic */ void access$1700(DetectionProto$Detection detectionProto$Detection, float f10) {
        detectionProto$Detection.addScore(f10);
    }

    public static /* synthetic */ void access$1800(DetectionProto$Detection detectionProto$Detection, Iterable iterable) {
        detectionProto$Detection.addAllScore(iterable);
    }

    public static /* synthetic */ void access$1900(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.clearScore();
    }

    public static /* synthetic */ void access$2000(DetectionProto$Detection detectionProto$Detection, LocationDataProto$LocationData locationDataProto$LocationData) {
        detectionProto$Detection.setLocationData(locationDataProto$LocationData);
    }

    public static /* synthetic */ void access$2100(DetectionProto$Detection detectionProto$Detection, LocationDataProto$LocationData locationDataProto$LocationData) {
        detectionProto$Detection.mergeLocationData(locationDataProto$LocationData);
    }

    public static /* synthetic */ void access$2200(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.clearLocationData();
    }

    public static /* synthetic */ void access$2300(DetectionProto$Detection detectionProto$Detection, String string2) {
        detectionProto$Detection.setFeatureTag(string2);
    }

    public static /* synthetic */ void access$2400(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.clearFeatureTag();
    }

    public static /* synthetic */ void access$2500(DetectionProto$Detection detectionProto$Detection, ByteString byteString) {
        detectionProto$Detection.setFeatureTagBytes(byteString);
    }

    public static /* synthetic */ void access$2600(DetectionProto$Detection detectionProto$Detection, String string2) {
        detectionProto$Detection.setTrackId(string2);
    }

    public static /* synthetic */ void access$2700(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.clearTrackId();
    }

    public static /* synthetic */ void access$2800(DetectionProto$Detection detectionProto$Detection, ByteString byteString) {
        detectionProto$Detection.setTrackIdBytes(byteString);
    }

    public static /* synthetic */ void access$2900(DetectionProto$Detection detectionProto$Detection, long l10) {
        detectionProto$Detection.setDetectionId(l10);
    }

    public static /* synthetic */ void access$3000(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.clearDetectionId();
    }

    public static /* synthetic */ void access$3100(DetectionProto$Detection detectionProto$Detection, int n10, DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        detectionProto$Detection.setAssociatedDetections(n10, detectionProto$Detection$AssociatedDetection);
    }

    public static /* synthetic */ void access$3200(DetectionProto$Detection detectionProto$Detection, DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        detectionProto$Detection.addAssociatedDetections(detectionProto$Detection$AssociatedDetection);
    }

    public static /* synthetic */ void access$3300(DetectionProto$Detection detectionProto$Detection, int n10, DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        detectionProto$Detection.addAssociatedDetections(n10, detectionProto$Detection$AssociatedDetection);
    }

    public static /* synthetic */ void access$3400(DetectionProto$Detection detectionProto$Detection, Iterable iterable) {
        detectionProto$Detection.addAllAssociatedDetections(iterable);
    }

    public static /* synthetic */ void access$3500(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.clearAssociatedDetections();
    }

    public static /* synthetic */ void access$3600(DetectionProto$Detection detectionProto$Detection, int n10) {
        detectionProto$Detection.removeAssociatedDetections(n10);
    }

    public static /* synthetic */ void access$3700(DetectionProto$Detection detectionProto$Detection, int n10, String string2) {
        detectionProto$Detection.setDisplayName(n10, string2);
    }

    public static /* synthetic */ void access$3800(DetectionProto$Detection detectionProto$Detection, String string2) {
        detectionProto$Detection.addDisplayName(string2);
    }

    public static /* synthetic */ void access$3900(DetectionProto$Detection detectionProto$Detection, Iterable iterable) {
        detectionProto$Detection.addAllDisplayName(iterable);
    }

    public static /* synthetic */ void access$4000(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.clearDisplayName();
    }

    public static /* synthetic */ void access$4100(DetectionProto$Detection detectionProto$Detection, ByteString byteString) {
        detectionProto$Detection.addDisplayNameBytes(byteString);
    }

    public static /* synthetic */ void access$4200(DetectionProto$Detection detectionProto$Detection, long l10) {
        detectionProto$Detection.setTimestampUsec(l10);
    }

    public static /* synthetic */ void access$4300(DetectionProto$Detection detectionProto$Detection) {
        detectionProto$Detection.clearTimestampUsec();
    }

    public static /* synthetic */ DetectionProto$Detection access$600() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$700(DetectionProto$Detection detectionProto$Detection, int n10, String string2) {
        detectionProto$Detection.setLabel(n10, string2);
    }

    public static /* synthetic */ void access$800(DetectionProto$Detection detectionProto$Detection, String string2) {
        detectionProto$Detection.addLabel(string2);
    }

    public static /* synthetic */ void access$900(DetectionProto$Detection detectionProto$Detection, Iterable iterable) {
        detectionProto$Detection.addAllLabel(iterable);
    }

    private void addAllAssociatedDetections(Iterable iterable) {
        this.ensureAssociatedDetectionsIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.associatedDetections_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllDisplayName(Iterable iterable) {
        this.ensureDisplayNameIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.displayName_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllLabel(Iterable iterable) {
        this.ensureLabelIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.label_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllLabelId(Iterable iterable) {
        this.ensureLabelIdIsMutable();
        Internal$IntList internal$IntList = this.labelId_;
        AbstractMessageLite.addAll(iterable, internal$IntList);
    }

    private void addAllScore(Iterable iterable) {
        this.ensureScoreIsMutable();
        Internal$FloatList internal$FloatList = this.score_;
        AbstractMessageLite.addAll(iterable, internal$FloatList);
    }

    private void addAssociatedDetections(int n10, DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        detectionProto$Detection$AssociatedDetection.getClass();
        this.ensureAssociatedDetectionsIsMutable();
        this.associatedDetections_.add(n10, detectionProto$Detection$AssociatedDetection);
    }

    private void addAssociatedDetections(DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        detectionProto$Detection$AssociatedDetection.getClass();
        this.ensureAssociatedDetectionsIsMutable();
        this.associatedDetections_.add(detectionProto$Detection$AssociatedDetection);
    }

    private void addDisplayName(String string2) {
        string2.getClass();
        this.ensureDisplayNameIsMutable();
        this.displayName_.add(string2);
    }

    private void addDisplayNameBytes(ByteString object) {
        this.ensureDisplayNameIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.displayName_;
        object = ((ByteString)object).toStringUtf8();
        internal$ProtobufList.add(object);
    }

    private void addLabel(String string2) {
        string2.getClass();
        this.ensureLabelIsMutable();
        this.label_.add(string2);
    }

    private void addLabelBytes(ByteString object) {
        this.ensureLabelIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.label_;
        object = ((ByteString)object).toStringUtf8();
        internal$ProtobufList.add(object);
    }

    private void addLabelId(int n10) {
        this.ensureLabelIdIsMutable();
        this.labelId_.addInt(n10);
    }

    private void addScore(float f10) {
        this.ensureScoreIsMutable();
        this.score_.addFloat(f10);
    }

    private void clearAssociatedDetections() {
        Internal$ProtobufList internal$ProtobufList;
        this.associatedDetections_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearDetectionId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.detectionId_ = 0L;
    }

    private void clearDisplayName() {
        Internal$ProtobufList internal$ProtobufList;
        this.displayName_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearFeatureTag() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.featureTag_ = string2 = DetectionProto$Detection.getDefaultInstance().getFeatureTag();
    }

    private void clearLabel() {
        Internal$ProtobufList internal$ProtobufList;
        this.label_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearLabelId() {
        Internal$IntList internal$IntList;
        this.labelId_ = internal$IntList = GeneratedMessageLite.emptyIntList();
    }

    private void clearLocationData() {
        int n10;
        this.locationData_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
    }

    private void clearScore() {
        Internal$FloatList internal$FloatList;
        this.score_ = internal$FloatList = GeneratedMessageLite.emptyFloatList();
    }

    private void clearTimestampUsec() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.timestampUsec_ = 0L;
    }

    private void clearTrackId() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.trackId_ = string2 = DetectionProto$Detection.getDefaultInstance().getTrackId();
    }

    private void ensureAssociatedDetectionsIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.associatedDetections_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.associatedDetections_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.associatedDetections_);
        }
    }

    private void ensureDisplayNameIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.displayName_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.displayName_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.displayName_);
        }
    }

    private void ensureLabelIdIsMutable() {
        Internal$IntList internal$IntList = this.labelId_;
        boolean bl2 = internal$IntList.isModifiable();
        if (!bl2) {
            this.labelId_ = internal$IntList = GeneratedMessageLite.mutableCopy(this.labelId_);
        }
    }

    private void ensureLabelIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.label_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.label_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.label_);
        }
    }

    private void ensureScoreIsMutable() {
        Internal$FloatList internal$FloatList = this.score_;
        boolean bl2 = internal$FloatList.isModifiable();
        if (!bl2) {
            this.score_ = internal$FloatList = GeneratedMessageLite.mutableCopy(this.score_);
        }
    }

    public static DetectionProto$Detection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLocationData(LocationDataProto$LocationData locationDataProto$LocationData) {
        int n10;
        LocationDataProto$LocationData locationDataProto$LocationData2;
        locationDataProto$LocationData.getClass();
        LocationDataProto$LocationDataOrBuilder locationDataProto$LocationDataOrBuilder = this.locationData_;
        if (locationDataProto$LocationDataOrBuilder != null && locationDataProto$LocationDataOrBuilder != (locationDataProto$LocationData2 = LocationDataProto$LocationData.getDefaultInstance())) {
            locationDataProto$LocationDataOrBuilder = LocationDataProto$LocationData.newBuilder(this.locationData_);
            this.locationData_ = locationDataProto$LocationData = (LocationDataProto$LocationData)((LocationDataProto$LocationData$Builder)((GeneratedMessageLite$Builder)((Object)locationDataProto$LocationDataOrBuilder)).mergeFrom(locationDataProto$LocationData)).buildPartial();
        } else {
            this.locationData_ = locationDataProto$LocationData;
        }
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    public static DetectionProto$Detection$Builder newBuilder() {
        return (DetectionProto$Detection$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static DetectionProto$Detection$Builder newBuilder(DetectionProto$Detection detectionProto$Detection) {
        return (DetectionProto$Detection$Builder)DEFAULT_INSTANCE.createBuilder(detectionProto$Detection);
    }

    public static DetectionProto$Detection parseDelimitedFrom(InputStream inputStream) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DetectionProto$Detection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DetectionProto$Detection parseFrom(ByteString byteString) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static DetectionProto$Detection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DetectionProto$Detection parseFrom(CodedInputStream codedInputStream) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static DetectionProto$Detection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static DetectionProto$Detection parseFrom(InputStream inputStream) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static DetectionProto$Detection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DetectionProto$Detection parseFrom(ByteBuffer byteBuffer) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static DetectionProto$Detection parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DetectionProto$Detection parseFrom(byte[] byArray) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static DetectionProto$Detection parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (DetectionProto$Detection)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAssociatedDetections(int n10) {
        this.ensureAssociatedDetectionsIsMutable();
        this.associatedDetections_.remove(n10);
    }

    private void setAssociatedDetections(int n10, DetectionProto$Detection$AssociatedDetection detectionProto$Detection$AssociatedDetection) {
        detectionProto$Detection$AssociatedDetection.getClass();
        this.ensureAssociatedDetectionsIsMutable();
        this.associatedDetections_.set(n10, detectionProto$Detection$AssociatedDetection);
    }

    private void setDetectionId(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.detectionId_ = l10;
    }

    private void setDisplayName(int n10, String string2) {
        string2.getClass();
        this.ensureDisplayNameIsMutable();
        this.displayName_.set(n10, string2);
    }

    private void setFeatureTag(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.featureTag_ = string2;
    }

    private void setFeatureTagBytes(ByteString object) {
        int n10;
        this.featureTag_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 2;
    }

    private void setLabel(int n10, String string2) {
        string2.getClass();
        this.ensureLabelIsMutable();
        this.label_.set(n10, string2);
    }

    private void setLabelId(int n10, int n11) {
        this.ensureLabelIdIsMutable();
        this.labelId_.setInt(n10, n11);
    }

    private void setLocationData(LocationDataProto$LocationData locationDataProto$LocationData) {
        int n10;
        locationDataProto$LocationData.getClass();
        this.locationData_ = locationDataProto$LocationData;
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    private void setScore(int n10, float f10) {
        this.ensureScoreIsMutable();
        this.score_.setFloat(n10, f10);
    }

    private void setTimestampUsec(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.timestampUsec_ = l10;
    }

    private void setTrackId(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.trackId_ = string2;
    }

    private void setTrackIdBytes(ByteString object) {
        int n10;
        this.trackId_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        object = DetectionProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        Object object2 = objectArray.ordinal();
        object2 = object[object2];
        int n10 = 1;
        switch (object2) {
            default: {
                objectArray = new UnsupportedOperationException();
                throw objectArray;
            }
            case 7: {
                if (clazz == null) {
                    n10 = 0;
                    object = null;
                }
                object2 = (byte)n10;
                this.memoizedIsInitialized = (byte)object2;
                return null;
            }
            case 6: {
                return this.memoizedIsInitialized;
            }
            case 5: {
                objectArray = PARSER;
                if (objectArray != null) return objectArray;
                clazz = DetectionProto$Detection.class;
                synchronized (clazz) {
                    objectArray = PARSER;
                    if (objectArray != null) return objectArray;
                    object = DEFAULT_INSTANCE;
                    PARSER = objectArray = new GeneratedMessageLite$DefaultInstanceBasedParser((GeneratedMessageLite)object);
                    return objectArray;
                }
            }
            case 4: {
                return DEFAULT_INSTANCE;
            }
            case 3: {
                objectArray = new Object[12];
                objectArray[0] = "bitField0_";
                objectArray[n10] = "label_";
                objectArray[2] = "labelId_";
                objectArray[3] = "score_";
                objectArray[4] = "locationData_";
                objectArray[5] = "featureTag_";
                objectArray[6] = "trackId_";
                objectArray[7] = "detectionId_";
                objectArray[8] = "associatedDetections_";
                objectArray[9] = DetectionProto$Detection$AssociatedDetection.class;
                objectArray[10] = "displayName_";
                objectArray[11] = "timestampUsec_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0005\u0001\u0001\u001a\u0002'\u0003$\u0004\u0409\u0000\u0005\b\u0001\u0006\b\u0002\u0007\u0002\u0003\b\u001b\t\u001a\n\u0002\u0004", objectArray);
            }
            case 2: {
                return new DetectionProto$Detection$Builder(null);
            }
            case 1: 
        }
        return new DetectionProto$Detection();
    }

    public DetectionProto$Detection$AssociatedDetection getAssociatedDetections(int n10) {
        return (DetectionProto$Detection$AssociatedDetection)this.associatedDetections_.get(n10);
    }

    public int getAssociatedDetectionsCount() {
        return this.associatedDetections_.size();
    }

    public List getAssociatedDetectionsList() {
        return this.associatedDetections_;
    }

    public DetectionProto$Detection$AssociatedDetectionOrBuilder getAssociatedDetectionsOrBuilder(int n10) {
        return (DetectionProto$Detection$AssociatedDetectionOrBuilder)this.associatedDetections_.get(n10);
    }

    public List getAssociatedDetectionsOrBuilderList() {
        return this.associatedDetections_;
    }

    public long getDetectionId() {
        return this.detectionId_;
    }

    public String getDisplayName(int n10) {
        return (String)this.displayName_.get(n10);
    }

    public ByteString getDisplayNameBytes(int n10) {
        return ByteString.copyFromUtf8((String)this.displayName_.get(n10));
    }

    public int getDisplayNameCount() {
        return this.displayName_.size();
    }

    public List getDisplayNameList() {
        return this.displayName_;
    }

    public String getFeatureTag() {
        return this.featureTag_;
    }

    public ByteString getFeatureTagBytes() {
        return ByteString.copyFromUtf8(this.featureTag_);
    }

    public String getLabel(int n10) {
        return (String)this.label_.get(n10);
    }

    public ByteString getLabelBytes(int n10) {
        return ByteString.copyFromUtf8((String)this.label_.get(n10));
    }

    public int getLabelCount() {
        return this.label_.size();
    }

    public int getLabelId(int n10) {
        return this.labelId_.getInt(n10);
    }

    public int getLabelIdCount() {
        return this.labelId_.size();
    }

    public List getLabelIdList() {
        return this.labelId_;
    }

    public List getLabelList() {
        return this.label_;
    }

    public LocationDataProto$LocationData getLocationData() {
        LocationDataProto$LocationData locationDataProto$LocationData = this.locationData_;
        if (locationDataProto$LocationData == null) {
            locationDataProto$LocationData = LocationDataProto$LocationData.getDefaultInstance();
        }
        return locationDataProto$LocationData;
    }

    public float getScore(int n10) {
        return this.score_.getFloat(n10);
    }

    public int getScoreCount() {
        return this.score_.size();
    }

    public List getScoreList() {
        return this.score_;
    }

    public long getTimestampUsec() {
        return this.timestampUsec_;
    }

    public String getTrackId() {
        return this.trackId_;
    }

    public ByteString getTrackIdBytes() {
        return ByteString.copyFromUtf8(this.trackId_);
    }

    public boolean hasDetectionId() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasFeatureTag() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasLocationData() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasTimestampUsec() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasTrackId() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }
}


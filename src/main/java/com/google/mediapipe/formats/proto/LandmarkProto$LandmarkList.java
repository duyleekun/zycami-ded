/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LandmarkProto$1;
import com.google.mediapipe.formats.proto.LandmarkProto$Landmark;
import com.google.mediapipe.formats.proto.LandmarkProto$LandmarkList$Builder;
import com.google.mediapipe.formats.proto.LandmarkProto$LandmarkListOrBuilder;
import com.google.mediapipe.formats.proto.LandmarkProto$LandmarkOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class LandmarkProto$LandmarkList
extends GeneratedMessageLite
implements LandmarkProto$LandmarkListOrBuilder {
    private static final LandmarkProto$LandmarkList DEFAULT_INSTANCE;
    public static final int LANDMARK_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    private Internal$ProtobufList landmark_;

    static {
        LandmarkProto$LandmarkList landmarkProto$LandmarkList;
        DEFAULT_INSTANCE = landmarkProto$LandmarkList = new LandmarkProto$LandmarkList();
        GeneratedMessageLite.registerDefaultInstance(LandmarkProto$LandmarkList.class, landmarkProto$LandmarkList);
    }

    private LandmarkProto$LandmarkList() {
        Internal$ProtobufList internal$ProtobufList;
        this.landmark_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    public static /* synthetic */ void access$1000(LandmarkProto$LandmarkList landmarkProto$LandmarkList, LandmarkProto$Landmark landmarkProto$Landmark) {
        landmarkProto$LandmarkList.addLandmark(landmarkProto$Landmark);
    }

    public static /* synthetic */ void access$1100(LandmarkProto$LandmarkList landmarkProto$LandmarkList, int n10, LandmarkProto$Landmark landmarkProto$Landmark) {
        landmarkProto$LandmarkList.addLandmark(n10, landmarkProto$Landmark);
    }

    public static /* synthetic */ void access$1200(LandmarkProto$LandmarkList landmarkProto$LandmarkList, Iterable iterable) {
        landmarkProto$LandmarkList.addAllLandmark(iterable);
    }

    public static /* synthetic */ void access$1300(LandmarkProto$LandmarkList landmarkProto$LandmarkList) {
        landmarkProto$LandmarkList.clearLandmark();
    }

    public static /* synthetic */ void access$1400(LandmarkProto$LandmarkList landmarkProto$LandmarkList, int n10) {
        landmarkProto$LandmarkList.removeLandmark(n10);
    }

    public static /* synthetic */ LandmarkProto$LandmarkList access$800() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$900(LandmarkProto$LandmarkList landmarkProto$LandmarkList, int n10, LandmarkProto$Landmark landmarkProto$Landmark) {
        landmarkProto$LandmarkList.setLandmark(n10, landmarkProto$Landmark);
    }

    private void addAllLandmark(Iterable iterable) {
        this.ensureLandmarkIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.landmark_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addLandmark(int n10, LandmarkProto$Landmark landmarkProto$Landmark) {
        landmarkProto$Landmark.getClass();
        this.ensureLandmarkIsMutable();
        this.landmark_.add(n10, landmarkProto$Landmark);
    }

    private void addLandmark(LandmarkProto$Landmark landmarkProto$Landmark) {
        landmarkProto$Landmark.getClass();
        this.ensureLandmarkIsMutable();
        this.landmark_.add(landmarkProto$Landmark);
    }

    private void clearLandmark() {
        Internal$ProtobufList internal$ProtobufList;
        this.landmark_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureLandmarkIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.landmark_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.landmark_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.landmark_);
        }
    }

    public static LandmarkProto$LandmarkList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static LandmarkProto$LandmarkList$Builder newBuilder() {
        return (LandmarkProto$LandmarkList$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static LandmarkProto$LandmarkList$Builder newBuilder(LandmarkProto$LandmarkList landmarkProto$LandmarkList) {
        return (LandmarkProto$LandmarkList$Builder)DEFAULT_INSTANCE.createBuilder(landmarkProto$LandmarkList);
    }

    public static LandmarkProto$LandmarkList parseDelimitedFrom(InputStream inputStream) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LandmarkProto$LandmarkList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LandmarkProto$LandmarkList parseFrom(ByteString byteString) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static LandmarkProto$LandmarkList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LandmarkProto$LandmarkList parseFrom(CodedInputStream codedInputStream) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static LandmarkProto$LandmarkList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static LandmarkProto$LandmarkList parseFrom(InputStream inputStream) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static LandmarkProto$LandmarkList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LandmarkProto$LandmarkList parseFrom(ByteBuffer byteBuffer) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static LandmarkProto$LandmarkList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LandmarkProto$LandmarkList parseFrom(byte[] byArray) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static LandmarkProto$LandmarkList parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$LandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeLandmark(int n10) {
        this.ensureLandmarkIsMutable();
        this.landmark_.remove(n10);
    }

    private void setLandmark(int n10, LandmarkProto$Landmark landmarkProto$Landmark) {
        landmarkProto$Landmark.getClass();
        this.ensureLandmarkIsMutable();
        this.landmark_.set(n10, landmarkProto$Landmark);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<LandmarkProto$LandmarkList>)LandmarkProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        Object object2 = objectArray.ordinal();
        object2 = clazz[object2];
        byte by2 = 1;
        object = null;
        switch (object2) {
            default: {
                objectArray = new UnsupportedOperationException();
                throw objectArray;
            }
            case 7: {
                return null;
            }
            case 6: {
                return by2;
            }
            case 5: {
                objectArray = PARSER;
                if (objectArray != null) return objectArray;
                clazz = LandmarkProto$LandmarkList.class;
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
                objectArray = new Object[2];
                objectArray[0] = "landmark_";
                objectArray[by2] = LandmarkProto$Landmark.class;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new LandmarkProto$LandmarkList$Builder(null);
            }
            case 1: 
        }
        return new LandmarkProto$LandmarkList();
    }

    public LandmarkProto$Landmark getLandmark(int n10) {
        return (LandmarkProto$Landmark)this.landmark_.get(n10);
    }

    public int getLandmarkCount() {
        return this.landmark_.size();
    }

    public List getLandmarkList() {
        return this.landmark_;
    }

    public LandmarkProto$LandmarkOrBuilder getLandmarkOrBuilder(int n10) {
        return (LandmarkProto$LandmarkOrBuilder)this.landmark_.get(n10);
    }

    public List getLandmarkOrBuilderList() {
        return this.landmark_;
    }
}


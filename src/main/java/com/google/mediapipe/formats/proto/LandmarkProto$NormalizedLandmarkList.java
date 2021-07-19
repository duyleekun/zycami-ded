/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.proto.LandmarkProto$1;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmark;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmarkList$Builder;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmarkListOrBuilder;
import com.google.mediapipe.formats.proto.LandmarkProto$NormalizedLandmarkOrBuilder;
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

public final class LandmarkProto$NormalizedLandmarkList
extends GeneratedMessageLite
implements LandmarkProto$NormalizedLandmarkListOrBuilder {
    private static final LandmarkProto$NormalizedLandmarkList DEFAULT_INSTANCE;
    public static final int LANDMARK_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    private Internal$ProtobufList landmark_;

    static {
        LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList;
        DEFAULT_INSTANCE = landmarkProto$NormalizedLandmarkList = new LandmarkProto$NormalizedLandmarkList();
        GeneratedMessageLite.registerDefaultInstance(LandmarkProto$NormalizedLandmarkList.class, landmarkProto$NormalizedLandmarkList);
    }

    private LandmarkProto$NormalizedLandmarkList() {
        Internal$ProtobufList internal$ProtobufList;
        this.landmark_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    public static /* synthetic */ LandmarkProto$NormalizedLandmarkList access$2400() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$2500(LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList, int n10, LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        landmarkProto$NormalizedLandmarkList.setLandmark(n10, landmarkProto$NormalizedLandmark);
    }

    public static /* synthetic */ void access$2600(LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList, LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        landmarkProto$NormalizedLandmarkList.addLandmark(landmarkProto$NormalizedLandmark);
    }

    public static /* synthetic */ void access$2700(LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList, int n10, LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        landmarkProto$NormalizedLandmarkList.addLandmark(n10, landmarkProto$NormalizedLandmark);
    }

    public static /* synthetic */ void access$2800(LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList, Iterable iterable) {
        landmarkProto$NormalizedLandmarkList.addAllLandmark(iterable);
    }

    public static /* synthetic */ void access$2900(LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList) {
        landmarkProto$NormalizedLandmarkList.clearLandmark();
    }

    public static /* synthetic */ void access$3000(LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList, int n10) {
        landmarkProto$NormalizedLandmarkList.removeLandmark(n10);
    }

    private void addAllLandmark(Iterable iterable) {
        this.ensureLandmarkIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.landmark_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addLandmark(int n10, LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        landmarkProto$NormalizedLandmark.getClass();
        this.ensureLandmarkIsMutable();
        this.landmark_.add(n10, landmarkProto$NormalizedLandmark);
    }

    private void addLandmark(LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        landmarkProto$NormalizedLandmark.getClass();
        this.ensureLandmarkIsMutable();
        this.landmark_.add(landmarkProto$NormalizedLandmark);
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

    public static LandmarkProto$NormalizedLandmarkList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static LandmarkProto$NormalizedLandmarkList$Builder newBuilder() {
        return (LandmarkProto$NormalizedLandmarkList$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static LandmarkProto$NormalizedLandmarkList$Builder newBuilder(LandmarkProto$NormalizedLandmarkList landmarkProto$NormalizedLandmarkList) {
        return (LandmarkProto$NormalizedLandmarkList$Builder)DEFAULT_INSTANCE.createBuilder(landmarkProto$NormalizedLandmarkList);
    }

    public static LandmarkProto$NormalizedLandmarkList parseDelimitedFrom(InputStream inputStream) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LandmarkProto$NormalizedLandmarkList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LandmarkProto$NormalizedLandmarkList parseFrom(ByteString byteString) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static LandmarkProto$NormalizedLandmarkList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LandmarkProto$NormalizedLandmarkList parseFrom(CodedInputStream codedInputStream) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static LandmarkProto$NormalizedLandmarkList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static LandmarkProto$NormalizedLandmarkList parseFrom(InputStream inputStream) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static LandmarkProto$NormalizedLandmarkList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LandmarkProto$NormalizedLandmarkList parseFrom(ByteBuffer byteBuffer) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static LandmarkProto$NormalizedLandmarkList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LandmarkProto$NormalizedLandmarkList parseFrom(byte[] byArray) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static LandmarkProto$NormalizedLandmarkList parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (LandmarkProto$NormalizedLandmarkList)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeLandmark(int n10) {
        this.ensureLandmarkIsMutable();
        this.landmark_.remove(n10);
    }

    private void setLandmark(int n10, LandmarkProto$NormalizedLandmark landmarkProto$NormalizedLandmark) {
        landmarkProto$NormalizedLandmark.getClass();
        this.ensureLandmarkIsMutable();
        this.landmark_.set(n10, landmarkProto$NormalizedLandmark);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<LandmarkProto$NormalizedLandmarkList>)LandmarkProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = LandmarkProto$NormalizedLandmarkList.class;
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
                objectArray[by2] = LandmarkProto$NormalizedLandmark.class;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objectArray);
            }
            case 2: {
                return new LandmarkProto$NormalizedLandmarkList$Builder(null);
            }
            case 1: 
        }
        return new LandmarkProto$NormalizedLandmarkList();
    }

    public LandmarkProto$NormalizedLandmark getLandmark(int n10) {
        return (LandmarkProto$NormalizedLandmark)this.landmark_.get(n10);
    }

    public int getLandmarkCount() {
        return this.landmark_.size();
    }

    public List getLandmarkList() {
        return this.landmark_;
    }

    public LandmarkProto$NormalizedLandmarkOrBuilder getLandmarkOrBuilder(int n10) {
        return (LandmarkProto$NormalizedLandmarkOrBuilder)this.landmark_.get(n10);
    }

    public List getLandmarkOrBuilderList() {
        return this.landmark_;
    }
}


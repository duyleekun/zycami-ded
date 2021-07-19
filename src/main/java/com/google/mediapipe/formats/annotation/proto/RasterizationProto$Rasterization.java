/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.annotation.proto;

import com.google.mediapipe.formats.annotation.proto.RasterizationProto$1;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$Builder;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$Interval;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$IntervalOrBuilder;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$RasterizationOrBuilder;
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

public final class RasterizationProto$Rasterization
extends GeneratedMessageLite
implements RasterizationProto$RasterizationOrBuilder {
    private static final RasterizationProto$Rasterization DEFAULT_INSTANCE;
    public static final int INTERVAL_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    private Internal$ProtobufList interval_;
    private byte memoizedIsInitialized = (byte)2;

    static {
        RasterizationProto$Rasterization rasterizationProto$Rasterization;
        DEFAULT_INSTANCE = rasterizationProto$Rasterization = new RasterizationProto$Rasterization();
        GeneratedMessageLite.registerDefaultInstance(RasterizationProto$Rasterization.class, rasterizationProto$Rasterization);
    }

    private RasterizationProto$Rasterization() {
        Internal$ProtobufList internal$ProtobufList;
        this.interval_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    public static /* synthetic */ void access$1000(RasterizationProto$Rasterization rasterizationProto$Rasterization, RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        rasterizationProto$Rasterization.addInterval(rasterizationProto$Rasterization$Interval);
    }

    public static /* synthetic */ void access$1100(RasterizationProto$Rasterization rasterizationProto$Rasterization, int n10, RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        rasterizationProto$Rasterization.addInterval(n10, rasterizationProto$Rasterization$Interval);
    }

    public static /* synthetic */ void access$1200(RasterizationProto$Rasterization rasterizationProto$Rasterization, Iterable iterable) {
        rasterizationProto$Rasterization.addAllInterval(iterable);
    }

    public static /* synthetic */ void access$1300(RasterizationProto$Rasterization rasterizationProto$Rasterization) {
        rasterizationProto$Rasterization.clearInterval();
    }

    public static /* synthetic */ void access$1400(RasterizationProto$Rasterization rasterizationProto$Rasterization, int n10) {
        rasterizationProto$Rasterization.removeInterval(n10);
    }

    public static /* synthetic */ RasterizationProto$Rasterization access$800() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$900(RasterizationProto$Rasterization rasterizationProto$Rasterization, int n10, RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        rasterizationProto$Rasterization.setInterval(n10, rasterizationProto$Rasterization$Interval);
    }

    private void addAllInterval(Iterable iterable) {
        this.ensureIntervalIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.interval_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addInterval(int n10, RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        rasterizationProto$Rasterization$Interval.getClass();
        this.ensureIntervalIsMutable();
        this.interval_.add(n10, rasterizationProto$Rasterization$Interval);
    }

    private void addInterval(RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        rasterizationProto$Rasterization$Interval.getClass();
        this.ensureIntervalIsMutable();
        this.interval_.add(rasterizationProto$Rasterization$Interval);
    }

    private void clearInterval() {
        Internal$ProtobufList internal$ProtobufList;
        this.interval_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureIntervalIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.interval_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.interval_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(this.interval_);
        }
    }

    public static RasterizationProto$Rasterization getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static RasterizationProto$Rasterization$Builder newBuilder() {
        return (RasterizationProto$Rasterization$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static RasterizationProto$Rasterization$Builder newBuilder(RasterizationProto$Rasterization rasterizationProto$Rasterization) {
        return (RasterizationProto$Rasterization$Builder)DEFAULT_INSTANCE.createBuilder(rasterizationProto$Rasterization);
    }

    public static RasterizationProto$Rasterization parseDelimitedFrom(InputStream inputStream) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RasterizationProto$Rasterization parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RasterizationProto$Rasterization parseFrom(ByteString byteString) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static RasterizationProto$Rasterization parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RasterizationProto$Rasterization parseFrom(CodedInputStream codedInputStream) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static RasterizationProto$Rasterization parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static RasterizationProto$Rasterization parseFrom(InputStream inputStream) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static RasterizationProto$Rasterization parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RasterizationProto$Rasterization parseFrom(ByteBuffer byteBuffer) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static RasterizationProto$Rasterization parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RasterizationProto$Rasterization parseFrom(byte[] byArray) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static RasterizationProto$Rasterization parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeInterval(int n10) {
        this.ensureIntervalIsMutable();
        this.interval_.remove(n10);
    }

    private void setInterval(int n10, RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        rasterizationProto$Rasterization$Interval.getClass();
        this.ensureIntervalIsMutable();
        this.interval_.set(n10, rasterizationProto$Rasterization$Interval);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        object = RasterizationProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = RasterizationProto$Rasterization.class;
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
                objectArray[0] = "interval_";
                objectArray[n10] = RasterizationProto$Rasterization$Interval.class;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u041b", objectArray);
            }
            case 2: {
                return new RasterizationProto$Rasterization$Builder(null);
            }
            case 1: 
        }
        return new RasterizationProto$Rasterization();
    }

    public RasterizationProto$Rasterization$Interval getInterval(int n10) {
        return (RasterizationProto$Rasterization$Interval)this.interval_.get(n10);
    }

    public int getIntervalCount() {
        return this.interval_.size();
    }

    public List getIntervalList() {
        return this.interval_;
    }

    public RasterizationProto$Rasterization$IntervalOrBuilder getIntervalOrBuilder(int n10) {
        return (RasterizationProto$Rasterization$IntervalOrBuilder)this.interval_.get(n10);
    }

    public List getIntervalOrBuilderList() {
        return this.interval_;
    }
}


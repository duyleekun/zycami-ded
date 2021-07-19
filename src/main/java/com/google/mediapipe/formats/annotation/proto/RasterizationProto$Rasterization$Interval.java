/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.formats.annotation.proto;

import com.google.mediapipe.formats.annotation.proto.RasterizationProto$1;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$Interval$Builder;
import com.google.mediapipe.formats.annotation.proto.RasterizationProto$Rasterization$IntervalOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class RasterizationProto$Rasterization$Interval
extends GeneratedMessageLite
implements RasterizationProto$Rasterization$IntervalOrBuilder {
    private static final RasterizationProto$Rasterization$Interval DEFAULT_INSTANCE;
    public static final int LEFT_X_FIELD_NUMBER = 2;
    private static volatile Parser PARSER;
    public static final int RIGHT_X_FIELD_NUMBER = 3;
    public static final int Y_FIELD_NUMBER = 1;
    private int bitField0_;
    private int leftX_;
    private byte memoizedIsInitialized = (byte)2;
    private int rightX_;
    private int y_;

    static {
        RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval;
        DEFAULT_INSTANCE = rasterizationProto$Rasterization$Interval = new RasterizationProto$Rasterization$Interval();
        GeneratedMessageLite.registerDefaultInstance(RasterizationProto$Rasterization$Interval.class, rasterizationProto$Rasterization$Interval);
    }

    private RasterizationProto$Rasterization$Interval() {
    }

    public static /* synthetic */ RasterizationProto$Rasterization$Interval access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval, int n10) {
        rasterizationProto$Rasterization$Interval.setY(n10);
    }

    public static /* synthetic */ void access$200(RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        rasterizationProto$Rasterization$Interval.clearY();
    }

    public static /* synthetic */ void access$300(RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval, int n10) {
        rasterizationProto$Rasterization$Interval.setLeftX(n10);
    }

    public static /* synthetic */ void access$400(RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        rasterizationProto$Rasterization$Interval.clearLeftX();
    }

    public static /* synthetic */ void access$500(RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval, int n10) {
        rasterizationProto$Rasterization$Interval.setRightX(n10);
    }

    public static /* synthetic */ void access$600(RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        rasterizationProto$Rasterization$Interval.clearRightX();
    }

    private void clearLeftX() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.leftX_ = 0;
    }

    private void clearRightX() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.rightX_ = 0;
    }

    private void clearY() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.y_ = 0;
    }

    public static RasterizationProto$Rasterization$Interval getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static RasterizationProto$Rasterization$Interval$Builder newBuilder() {
        return (RasterizationProto$Rasterization$Interval$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static RasterizationProto$Rasterization$Interval$Builder newBuilder(RasterizationProto$Rasterization$Interval rasterizationProto$Rasterization$Interval) {
        return (RasterizationProto$Rasterization$Interval$Builder)DEFAULT_INSTANCE.createBuilder(rasterizationProto$Rasterization$Interval);
    }

    public static RasterizationProto$Rasterization$Interval parseDelimitedFrom(InputStream inputStream) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RasterizationProto$Rasterization$Interval parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RasterizationProto$Rasterization$Interval parseFrom(ByteString byteString) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static RasterizationProto$Rasterization$Interval parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RasterizationProto$Rasterization$Interval parseFrom(CodedInputStream codedInputStream) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static RasterizationProto$Rasterization$Interval parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static RasterizationProto$Rasterization$Interval parseFrom(InputStream inputStream) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static RasterizationProto$Rasterization$Interval parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RasterizationProto$Rasterization$Interval parseFrom(ByteBuffer byteBuffer) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static RasterizationProto$Rasterization$Interval parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RasterizationProto$Rasterization$Interval parseFrom(byte[] byArray) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static RasterizationProto$Rasterization$Interval parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (RasterizationProto$Rasterization$Interval)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLeftX(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.leftX_ = n10;
    }

    private void setRightX(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 4;
        this.rightX_ = n10;
    }

    private void setY(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.y_ = n10;
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
                clazz = RasterizationProto$Rasterization$Interval.class;
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
                objectArray = new Object[4];
                objectArray[0] = "bitField0_";
                objectArray[n10] = "y_";
                objectArray[2] = "leftX_";
                objectArray[3] = "rightX_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001\u0504\u0000\u0002\u0504\u0001\u0003\u0504\u0002", objectArray);
            }
            case 2: {
                return new RasterizationProto$Rasterization$Interval$Builder(null);
            }
            case 1: 
        }
        return new RasterizationProto$Rasterization$Interval();
    }

    public int getLeftX() {
        return this.leftX_;
    }

    public int getRightX() {
        return this.rightX_;
    }

    public int getY() {
        return this.y_;
    }

    public boolean hasLeftX() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasRightX() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasY() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }
}


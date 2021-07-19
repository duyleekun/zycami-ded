/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidMemoryReading$1;
import com.google.firebase.perf.v1.AndroidMemoryReading$Builder;
import com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class AndroidMemoryReading
extends GeneratedMessageLite
implements AndroidMemoryReadingOrBuilder {
    public static final int CLIENT_TIME_US_FIELD_NUMBER = 1;
    private static final AndroidMemoryReading DEFAULT_INSTANCE;
    private static volatile Parser PARSER;
    public static final int USED_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 2;
    private int bitField0_;
    private long clientTimeUs_;
    private int usedAppJavaHeapMemoryKb_;

    static {
        AndroidMemoryReading androidMemoryReading;
        DEFAULT_INSTANCE = androidMemoryReading = new AndroidMemoryReading();
        GeneratedMessageLite.registerDefaultInstance(AndroidMemoryReading.class, androidMemoryReading);
    }

    private AndroidMemoryReading() {
    }

    public static /* synthetic */ AndroidMemoryReading access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(AndroidMemoryReading androidMemoryReading, long l10) {
        androidMemoryReading.setClientTimeUs(l10);
    }

    public static /* synthetic */ void access$200(AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.clearClientTimeUs();
    }

    public static /* synthetic */ void access$300(AndroidMemoryReading androidMemoryReading, int n10) {
        androidMemoryReading.setUsedAppJavaHeapMemoryKb(n10);
    }

    public static /* synthetic */ void access$400(AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.clearUsedAppJavaHeapMemoryKb();
    }

    private void clearClientTimeUs() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.clientTimeUs_ = 0L;
    }

    private void clearUsedAppJavaHeapMemoryKb() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.usedAppJavaHeapMemoryKb_ = 0;
    }

    public static AndroidMemoryReading getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static AndroidMemoryReading$Builder newBuilder() {
        return (AndroidMemoryReading$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static AndroidMemoryReading$Builder newBuilder(AndroidMemoryReading androidMemoryReading) {
        return (AndroidMemoryReading$Builder)DEFAULT_INSTANCE.createBuilder(androidMemoryReading);
    }

    public static AndroidMemoryReading parseDelimitedFrom(InputStream inputStream) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AndroidMemoryReading parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AndroidMemoryReading parseFrom(ByteString byteString) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static AndroidMemoryReading parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AndroidMemoryReading parseFrom(CodedInputStream codedInputStream) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static AndroidMemoryReading parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static AndroidMemoryReading parseFrom(InputStream inputStream) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static AndroidMemoryReading parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AndroidMemoryReading parseFrom(ByteBuffer byteBuffer) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static AndroidMemoryReading parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AndroidMemoryReading parseFrom(byte[] byArray) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static AndroidMemoryReading parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (AndroidMemoryReading)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setClientTimeUs(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.clientTimeUs_ = l10;
    }

    private void setUsedAppJavaHeapMemoryKb(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.usedAppJavaHeapMemoryKb_ = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<AndroidMemoryReading>)AndroidMemoryReading$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = AndroidMemoryReading.class;
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
                objectArray = new Object[3];
                objectArray[0] = "bitField0_";
                objectArray[by2] = "clientTimeUs_";
                objectArray[2] = "usedAppJavaHeapMemoryKb_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1002\u0000\u0002\u1004\u0001", objectArray);
            }
            case 2: {
                return new AndroidMemoryReading$Builder(null);
            }
            case 1: 
        }
        return new AndroidMemoryReading();
    }

    public long getClientTimeUs() {
        return this.clientTimeUs_;
    }

    public int getUsedAppJavaHeapMemoryKb() {
        return this.usedAppJavaHeapMemoryKb_;
    }

    public boolean hasClientTimeUs() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean hasUsedAppJavaHeapMemoryKb() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkConnectionInfo$1;
import com.google.firebase.perf.v1.NetworkConnectionInfo$Builder;
import com.google.firebase.perf.v1.NetworkConnectionInfo$MobileSubtype;
import com.google.firebase.perf.v1.NetworkConnectionInfo$NetworkType;
import com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class NetworkConnectionInfo
extends GeneratedMessageLite
implements NetworkConnectionInfoOrBuilder {
    private static final NetworkConnectionInfo DEFAULT_INSTANCE;
    public static final int MOBILE_SUBTYPE_FIELD_NUMBER = 2;
    public static final int NETWORK_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    private int bitField0_;
    private int mobileSubtype_;
    private int networkType_ = -1;

    static {
        NetworkConnectionInfo networkConnectionInfo;
        DEFAULT_INSTANCE = networkConnectionInfo = new NetworkConnectionInfo();
        GeneratedMessageLite.registerDefaultInstance(NetworkConnectionInfo.class, networkConnectionInfo);
    }

    private NetworkConnectionInfo() {
    }

    public static /* synthetic */ NetworkConnectionInfo access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(NetworkConnectionInfo networkConnectionInfo, NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType) {
        networkConnectionInfo.setNetworkType(networkConnectionInfo$NetworkType);
    }

    public static /* synthetic */ void access$200(NetworkConnectionInfo networkConnectionInfo) {
        networkConnectionInfo.clearNetworkType();
    }

    public static /* synthetic */ void access$300(NetworkConnectionInfo networkConnectionInfo, NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype) {
        networkConnectionInfo.setMobileSubtype(networkConnectionInfo$MobileSubtype);
    }

    public static /* synthetic */ void access$400(NetworkConnectionInfo networkConnectionInfo) {
        networkConnectionInfo.clearMobileSubtype();
    }

    private void clearMobileSubtype() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.mobileSubtype_ = 0;
    }

    private void clearNetworkType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.networkType_ = -1;
    }

    public static NetworkConnectionInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static NetworkConnectionInfo$Builder newBuilder() {
        return (NetworkConnectionInfo$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static NetworkConnectionInfo$Builder newBuilder(NetworkConnectionInfo networkConnectionInfo) {
        return (NetworkConnectionInfo$Builder)DEFAULT_INSTANCE.createBuilder(networkConnectionInfo);
    }

    public static NetworkConnectionInfo parseDelimitedFrom(InputStream inputStream) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkConnectionInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NetworkConnectionInfo parseFrom(ByteString byteString) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static NetworkConnectionInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NetworkConnectionInfo parseFrom(CodedInputStream codedInputStream) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static NetworkConnectionInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static NetworkConnectionInfo parseFrom(InputStream inputStream) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkConnectionInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NetworkConnectionInfo parseFrom(ByteBuffer byteBuffer) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static NetworkConnectionInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NetworkConnectionInfo parseFrom(byte[] byArray) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static NetworkConnectionInfo parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (NetworkConnectionInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMobileSubtype(NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype) {
        int n10;
        this.mobileSubtype_ = n10 = networkConnectionInfo$MobileSubtype.getNumber();
        this.bitField0_ = n10 = this.bitField0_ | 2;
    }

    private void setNetworkType(NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType) {
        int n10;
        this.networkType_ = n10 = networkConnectionInfo$NetworkType.getNumber();
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<NetworkConnectionInfo>)NetworkConnectionInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = NetworkConnectionInfo.class;
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
                objectArray = new Object[5];
                objectArray[0] = "bitField0_";
                objectArray[by2] = "networkType_";
                objectArray[2] = object = NetworkConnectionInfo$NetworkType.internalGetVerifier();
                objectArray[3] = "mobileSubtype_";
                objectArray[4] = object = NetworkConnectionInfo$MobileSubtype.internalGetVerifier();
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u100c\u0001", objectArray);
            }
            case 2: {
                return new NetworkConnectionInfo$Builder(null);
            }
            case 1: 
        }
        return new NetworkConnectionInfo();
    }

    public NetworkConnectionInfo$MobileSubtype getMobileSubtype() {
        int n10 = this.mobileSubtype_;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype = NetworkConnectionInfo$MobileSubtype.forNumber(n10);
        if (networkConnectionInfo$MobileSubtype == null) {
            networkConnectionInfo$MobileSubtype = NetworkConnectionInfo$MobileSubtype.UNKNOWN_MOBILE_SUBTYPE;
        }
        return networkConnectionInfo$MobileSubtype;
    }

    public NetworkConnectionInfo$NetworkType getNetworkType() {
        int n10 = this.networkType_;
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType = NetworkConnectionInfo$NetworkType.forNumber(n10);
        if (networkConnectionInfo$NetworkType == null) {
            networkConnectionInfo$NetworkType = NetworkConnectionInfo$NetworkType.NONE;
        }
        return networkConnectionInfo$NetworkType;
    }

    public boolean hasMobileSubtype() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasNetworkType() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }
}


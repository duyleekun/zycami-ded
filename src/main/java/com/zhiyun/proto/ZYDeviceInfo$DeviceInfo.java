/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.zhiyun.proto.ZYDeviceInfo$DeviceInfo$a;
import com.zhiyun.proto.ZYDeviceInfo$DeviceInfo$b;
import com.zhiyun.proto.ZYDeviceInfo$a;
import com.zhiyun.proto.ZYDeviceInfo$b;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ZYDeviceInfo$DeviceInfo
extends GeneratedMessageLite
implements ZYDeviceInfo$b {
    private static final ZYDeviceInfo$DeviceInfo DEFAULT_INSTANCE;
    public static final int DEVICEINFO_FIELD_NUMBER = 2;
    public static final int ERRORCODE_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    private MapFieldLite deviceInfo_;
    private int errorCode_;

    static {
        ZYDeviceInfo$DeviceInfo zYDeviceInfo$DeviceInfo;
        DEFAULT_INSTANCE = zYDeviceInfo$DeviceInfo = new ZYDeviceInfo$DeviceInfo();
        GeneratedMessageLite.registerDefaultInstance(ZYDeviceInfo$DeviceInfo.class, zYDeviceInfo$DeviceInfo);
    }

    private ZYDeviceInfo$DeviceInfo() {
        MapFieldLite mapFieldLite;
        this.deviceInfo_ = mapFieldLite = MapFieldLite.emptyMapField();
    }

    public static /* synthetic */ ZYDeviceInfo$DeviceInfo access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(ZYDeviceInfo$DeviceInfo zYDeviceInfo$DeviceInfo, int n10) {
        zYDeviceInfo$DeviceInfo.setErrorCodeValue(n10);
    }

    public static /* synthetic */ void access$200(ZYDeviceInfo$DeviceInfo zYDeviceInfo$DeviceInfo, ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        zYDeviceInfo$DeviceInfo.setErrorCode(zYEnumDefine$ErrorCode);
    }

    public static /* synthetic */ void access$300(ZYDeviceInfo$DeviceInfo zYDeviceInfo$DeviceInfo) {
        zYDeviceInfo$DeviceInfo.clearErrorCode();
    }

    public static /* synthetic */ Map access$400(ZYDeviceInfo$DeviceInfo zYDeviceInfo$DeviceInfo) {
        return zYDeviceInfo$DeviceInfo.getMutableDeviceInfoMap();
    }

    private void clearErrorCode() {
        this.errorCode_ = 0;
    }

    public static ZYDeviceInfo$DeviceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map getMutableDeviceInfoMap() {
        return this.internalGetMutableDeviceInfo();
    }

    private MapFieldLite internalGetDeviceInfo() {
        return this.deviceInfo_;
    }

    private MapFieldLite internalGetMutableDeviceInfo() {
        MapFieldLite mapFieldLite = this.deviceInfo_;
        boolean bl2 = mapFieldLite.isMutable();
        if (!bl2) {
            this.deviceInfo_ = mapFieldLite = this.deviceInfo_.mutableCopy();
        }
        return this.deviceInfo_;
    }

    public static ZYDeviceInfo$DeviceInfo$a newBuilder() {
        return (ZYDeviceInfo$DeviceInfo$a)DEFAULT_INSTANCE.createBuilder();
    }

    public static ZYDeviceInfo$DeviceInfo$a newBuilder(ZYDeviceInfo$DeviceInfo zYDeviceInfo$DeviceInfo) {
        return (ZYDeviceInfo$DeviceInfo$a)DEFAULT_INSTANCE.createBuilder(zYDeviceInfo$DeviceInfo);
    }

    public static ZYDeviceInfo$DeviceInfo parseDelimitedFrom(InputStream inputStream) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ZYDeviceInfo$DeviceInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ZYDeviceInfo$DeviceInfo parseFrom(ByteString byteString) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static ZYDeviceInfo$DeviceInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ZYDeviceInfo$DeviceInfo parseFrom(CodedInputStream codedInputStream) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static ZYDeviceInfo$DeviceInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ZYDeviceInfo$DeviceInfo parseFrom(InputStream inputStream) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static ZYDeviceInfo$DeviceInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ZYDeviceInfo$DeviceInfo parseFrom(ByteBuffer byteBuffer) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static ZYDeviceInfo$DeviceInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ZYDeviceInfo$DeviceInfo parseFrom(byte[] byArray) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static ZYDeviceInfo$DeviceInfo parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYDeviceInfo$DeviceInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setErrorCode(ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        int n10;
        Objects.requireNonNull(zYEnumDefine$ErrorCode);
        this.errorCode_ = n10 = zYEnumDefine$ErrorCode.getNumber();
    }

    private void setErrorCodeValue(int n10) {
        this.errorCode_ = n10;
    }

    public boolean containsDeviceInfo(String string2) {
        Objects.requireNonNull(string2);
        return this.internalGetDeviceInfo().containsKey(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<ZYDeviceInfo$DeviceInfo>)ZYDeviceInfo$a.a;
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
                clazz = ZYDeviceInfo$DeviceInfo.class;
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
                objectArray[0] = "errorCode_";
                objectArray[by2] = "deviceInfo_";
                objectArray[2] = object = ZYDeviceInfo$DeviceInfo$b.a;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001\f\u00022", objectArray);
            }
            case 2: {
                return new ZYDeviceInfo$DeviceInfo$a(null);
            }
            case 1: 
        }
        return new ZYDeviceInfo$DeviceInfo();
    }

    public Map getDeviceInfo() {
        return this.getDeviceInfoMap();
    }

    public int getDeviceInfoCount() {
        return this.internalGetDeviceInfo().size();
    }

    public Map getDeviceInfoMap() {
        return Collections.unmodifiableMap(this.internalGetDeviceInfo());
    }

    public String getDeviceInfoOrDefault(String string2, String string3) {
        Objects.requireNonNull(string2);
        MapFieldLite mapFieldLite = this.internalGetDeviceInfo();
        boolean bl2 = mapFieldLite.containsKey(string2);
        if (bl2) {
            string3 = string2 = mapFieldLite.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getDeviceInfoOrThrow(String object) {
        Objects.requireNonNull(object);
        MapFieldLite mapFieldLite = this.internalGetDeviceInfo();
        boolean bl2 = mapFieldLite.containsKey(object);
        if (bl2) {
            return (String)mapFieldLite.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public ZYEnumDefine$ErrorCode getErrorCode() {
        int n10 = this.errorCode_;
        ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode = ZYEnumDefine$ErrorCode.forNumber(n10);
        if (zYEnumDefine$ErrorCode == null) {
            zYEnumDefine$ErrorCode = ZYEnumDefine$ErrorCode.UNRECOGNIZED;
        }
        return zYEnumDefine$ErrorCode;
    }

    public int getErrorCodeValue() {
        return this.errorCode_;
    }
}


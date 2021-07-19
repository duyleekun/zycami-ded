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
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.proto.ZYHeartbeat$Heartbeat$a;
import com.zhiyun.proto.ZYHeartbeat$Heartbeat$b;
import com.zhiyun.proto.ZYHeartbeat$a;
import com.zhiyun.proto.ZYHeartbeat$b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ZYHeartbeat$Heartbeat
extends GeneratedMessageLite
implements ZYHeartbeat$b {
    private static final ZYHeartbeat$Heartbeat DEFAULT_INSTANCE;
    public static final int ERRORCODE_FIELD_NUMBER = 1;
    public static final int HEARTBEATINFO_FIELD_NUMBER = 2;
    private static volatile Parser PARSER;
    private int errorCode_;
    private MapFieldLite heartbeatInfo_;

    static {
        ZYHeartbeat$Heartbeat zYHeartbeat$Heartbeat;
        DEFAULT_INSTANCE = zYHeartbeat$Heartbeat = new ZYHeartbeat$Heartbeat();
        GeneratedMessageLite.registerDefaultInstance(ZYHeartbeat$Heartbeat.class, zYHeartbeat$Heartbeat);
    }

    private ZYHeartbeat$Heartbeat() {
        MapFieldLite mapFieldLite;
        this.heartbeatInfo_ = mapFieldLite = MapFieldLite.emptyMapField();
    }

    public static /* synthetic */ ZYHeartbeat$Heartbeat access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(ZYHeartbeat$Heartbeat zYHeartbeat$Heartbeat, int n10) {
        zYHeartbeat$Heartbeat.setErrorCodeValue(n10);
    }

    public static /* synthetic */ void access$200(ZYHeartbeat$Heartbeat zYHeartbeat$Heartbeat, ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        zYHeartbeat$Heartbeat.setErrorCode(zYEnumDefine$ErrorCode);
    }

    public static /* synthetic */ void access$300(ZYHeartbeat$Heartbeat zYHeartbeat$Heartbeat) {
        zYHeartbeat$Heartbeat.clearErrorCode();
    }

    public static /* synthetic */ Map access$400(ZYHeartbeat$Heartbeat zYHeartbeat$Heartbeat) {
        return zYHeartbeat$Heartbeat.getMutableHeartbeatInfoMap();
    }

    private void clearErrorCode() {
        this.errorCode_ = 0;
    }

    public static ZYHeartbeat$Heartbeat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map getMutableHeartbeatInfoMap() {
        return this.internalGetMutableHeartbeatInfo();
    }

    private MapFieldLite internalGetHeartbeatInfo() {
        return this.heartbeatInfo_;
    }

    private MapFieldLite internalGetMutableHeartbeatInfo() {
        MapFieldLite mapFieldLite = this.heartbeatInfo_;
        boolean bl2 = mapFieldLite.isMutable();
        if (!bl2) {
            this.heartbeatInfo_ = mapFieldLite = this.heartbeatInfo_.mutableCopy();
        }
        return this.heartbeatInfo_;
    }

    public static ZYHeartbeat$Heartbeat$a newBuilder() {
        return (ZYHeartbeat$Heartbeat$a)DEFAULT_INSTANCE.createBuilder();
    }

    public static ZYHeartbeat$Heartbeat$a newBuilder(ZYHeartbeat$Heartbeat zYHeartbeat$Heartbeat) {
        return (ZYHeartbeat$Heartbeat$a)DEFAULT_INSTANCE.createBuilder(zYHeartbeat$Heartbeat);
    }

    public static ZYHeartbeat$Heartbeat parseDelimitedFrom(InputStream inputStream) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ZYHeartbeat$Heartbeat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ZYHeartbeat$Heartbeat parseFrom(ByteString byteString) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static ZYHeartbeat$Heartbeat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ZYHeartbeat$Heartbeat parseFrom(CodedInputStream codedInputStream) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static ZYHeartbeat$Heartbeat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ZYHeartbeat$Heartbeat parseFrom(InputStream inputStream) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static ZYHeartbeat$Heartbeat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ZYHeartbeat$Heartbeat parseFrom(ByteBuffer byteBuffer) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static ZYHeartbeat$Heartbeat parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ZYHeartbeat$Heartbeat parseFrom(byte[] byArray) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static ZYHeartbeat$Heartbeat parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYHeartbeat$Heartbeat)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
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

    public boolean containsHeartbeatInfo(String string2) {
        Objects.requireNonNull(string2);
        return this.internalGetHeartbeatInfo().containsKey(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<ZYHeartbeat$Heartbeat>)ZYHeartbeat$a.a;
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
                clazz = ZYHeartbeat$Heartbeat.class;
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
                objectArray[by2] = "heartbeatInfo_";
                objectArray[2] = object = ZYHeartbeat$Heartbeat$b.a;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001\f\u00022", objectArray);
            }
            case 2: {
                return new ZYHeartbeat$Heartbeat$a(null);
            }
            case 1: 
        }
        return new ZYHeartbeat$Heartbeat();
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

    public Map getHeartbeatInfo() {
        return this.getHeartbeatInfoMap();
    }

    public int getHeartbeatInfoCount() {
        return this.internalGetHeartbeatInfo().size();
    }

    public Map getHeartbeatInfoMap() {
        return Collections.unmodifiableMap(this.internalGetHeartbeatInfo());
    }

    public String getHeartbeatInfoOrDefault(String string2, String string3) {
        Objects.requireNonNull(string2);
        MapFieldLite mapFieldLite = this.internalGetHeartbeatInfo();
        boolean bl2 = mapFieldLite.containsKey(string2);
        if (bl2) {
            string3 = string2 = mapFieldLite.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getHeartbeatInfoOrThrow(String object) {
        Objects.requireNonNull(object);
        MapFieldLite mapFieldLite = this.internalGetHeartbeatInfo();
        boolean bl2 = mapFieldLite.containsKey(object);
        if (bl2) {
            return (String)mapFieldLite.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }
}


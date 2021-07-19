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
import com.zhiyun.proto.ZYConnect$Connect$a;
import com.zhiyun.proto.ZYConnect$Connect$b;
import com.zhiyun.proto.ZYConnect$a;
import com.zhiyun.proto.ZYConnect$b;
import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ZYConnect$Connect
extends GeneratedMessageLite
implements ZYConnect$b {
    public static final int CONNECTACTION_FIELD_NUMBER = 2;
    public static final int CONNECTEXTROINFO_FIELD_NUMBER = 3;
    private static final ZYConnect$Connect DEFAULT_INSTANCE;
    public static final int ERRORCODE_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    private int connectAction_;
    private MapFieldLite connectExtroInfo_;
    private int errorCode_;

    static {
        ZYConnect$Connect zYConnect$Connect;
        DEFAULT_INSTANCE = zYConnect$Connect = new ZYConnect$Connect();
        GeneratedMessageLite.registerDefaultInstance(ZYConnect$Connect.class, zYConnect$Connect);
    }

    private ZYConnect$Connect() {
        MapFieldLite mapFieldLite;
        this.connectExtroInfo_ = mapFieldLite = MapFieldLite.emptyMapField();
    }

    public static /* synthetic */ ZYConnect$Connect access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(ZYConnect$Connect zYConnect$Connect, int n10) {
        zYConnect$Connect.setErrorCodeValue(n10);
    }

    public static /* synthetic */ void access$200(ZYConnect$Connect zYConnect$Connect, ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        zYConnect$Connect.setErrorCode(zYEnumDefine$ErrorCode);
    }

    public static /* synthetic */ void access$300(ZYConnect$Connect zYConnect$Connect) {
        zYConnect$Connect.clearErrorCode();
    }

    public static /* synthetic */ void access$400(ZYConnect$Connect zYConnect$Connect, int n10) {
        zYConnect$Connect.setConnectActionValue(n10);
    }

    public static /* synthetic */ void access$500(ZYConnect$Connect zYConnect$Connect, ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        zYConnect$Connect.setConnectAction(zYEnumDefine$ConnectAction);
    }

    public static /* synthetic */ void access$600(ZYConnect$Connect zYConnect$Connect) {
        zYConnect$Connect.clearConnectAction();
    }

    public static /* synthetic */ Map access$700(ZYConnect$Connect zYConnect$Connect) {
        return zYConnect$Connect.getMutableConnectExtroInfoMap();
    }

    private void clearConnectAction() {
        this.connectAction_ = 0;
    }

    private void clearErrorCode() {
        this.errorCode_ = 0;
    }

    public static ZYConnect$Connect getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map getMutableConnectExtroInfoMap() {
        return this.internalGetMutableConnectExtroInfo();
    }

    private MapFieldLite internalGetConnectExtroInfo() {
        return this.connectExtroInfo_;
    }

    private MapFieldLite internalGetMutableConnectExtroInfo() {
        MapFieldLite mapFieldLite = this.connectExtroInfo_;
        boolean bl2 = mapFieldLite.isMutable();
        if (!bl2) {
            this.connectExtroInfo_ = mapFieldLite = this.connectExtroInfo_.mutableCopy();
        }
        return this.connectExtroInfo_;
    }

    public static ZYConnect$Connect$a newBuilder() {
        return (ZYConnect$Connect$a)DEFAULT_INSTANCE.createBuilder();
    }

    public static ZYConnect$Connect$a newBuilder(ZYConnect$Connect zYConnect$Connect) {
        return (ZYConnect$Connect$a)DEFAULT_INSTANCE.createBuilder(zYConnect$Connect);
    }

    public static ZYConnect$Connect parseDelimitedFrom(InputStream inputStream) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ZYConnect$Connect parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ZYConnect$Connect parseFrom(ByteString byteString) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static ZYConnect$Connect parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ZYConnect$Connect parseFrom(CodedInputStream codedInputStream) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static ZYConnect$Connect parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ZYConnect$Connect parseFrom(InputStream inputStream) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static ZYConnect$Connect parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ZYConnect$Connect parseFrom(ByteBuffer byteBuffer) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static ZYConnect$Connect parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ZYConnect$Connect parseFrom(byte[] byArray) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static ZYConnect$Connect parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYConnect$Connect)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConnectAction(ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        int n10;
        Objects.requireNonNull(zYEnumDefine$ConnectAction);
        this.connectAction_ = n10 = zYEnumDefine$ConnectAction.getNumber();
    }

    private void setConnectActionValue(int n10) {
        this.connectAction_ = n10;
    }

    private void setErrorCode(ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        int n10;
        Objects.requireNonNull(zYEnumDefine$ErrorCode);
        this.errorCode_ = n10 = zYEnumDefine$ErrorCode.getNumber();
    }

    private void setErrorCodeValue(int n10) {
        this.errorCode_ = n10;
    }

    public boolean containsConnectExtroInfo(String string2) {
        Objects.requireNonNull(string2);
        return this.internalGetConnectExtroInfo().containsKey(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<ZYConnect$Connect>)ZYConnect$a.a;
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
                clazz = ZYConnect$Connect.class;
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
                objectArray[0] = "errorCode_";
                objectArray[by2] = "connectAction_";
                objectArray[2] = "connectExtroInfo_";
                objectArray[3] = object = ZYConnect$Connect$b.a;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001\f\u0002\f\u00032", objectArray);
            }
            case 2: {
                return new ZYConnect$Connect$a(null);
            }
            case 1: 
        }
        return new ZYConnect$Connect();
    }

    public ZYEnumDefine$ConnectAction getConnectAction() {
        int n10 = this.connectAction_;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.forNumber(n10);
        if (zYEnumDefine$ConnectAction == null) {
            zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.UNRECOGNIZED;
        }
        return zYEnumDefine$ConnectAction;
    }

    public int getConnectActionValue() {
        return this.connectAction_;
    }

    public Map getConnectExtroInfo() {
        return this.getConnectExtroInfoMap();
    }

    public int getConnectExtroInfoCount() {
        return this.internalGetConnectExtroInfo().size();
    }

    public Map getConnectExtroInfoMap() {
        return Collections.unmodifiableMap(this.internalGetConnectExtroInfo());
    }

    public String getConnectExtroInfoOrDefault(String string2, String string3) {
        Objects.requireNonNull(string2);
        MapFieldLite mapFieldLite = this.internalGetConnectExtroInfo();
        boolean bl2 = mapFieldLite.containsKey(string2);
        if (bl2) {
            string3 = string2 = mapFieldLite.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getConnectExtroInfoOrThrow(String object) {
        Objects.requireNonNull(object);
        MapFieldLite mapFieldLite = this.internalGetConnectExtroInfo();
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


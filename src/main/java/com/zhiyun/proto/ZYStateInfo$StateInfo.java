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
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction;
import com.zhiyun.proto.ZYStateInfo$StateInfo$a;
import com.zhiyun.proto.ZYStateInfo$StateInfo$b;
import com.zhiyun.proto.ZYStateInfo$a;
import com.zhiyun.proto.ZYStateInfo$b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ZYStateInfo$StateInfo
extends GeneratedMessageLite
implements ZYStateInfo$b {
    public static final int ACTION_FIELD_NUMBER = 2;
    private static final ZYStateInfo$StateInfo DEFAULT_INSTANCE;
    public static final int ERRORCODE_FIELD_NUMBER = 1;
    private static volatile Parser PARSER;
    public static final int STATELIST_FIELD_NUMBER = 3;
    private int action_;
    private int errorCode_;
    private MapFieldLite stateList_;

    static {
        ZYStateInfo$StateInfo zYStateInfo$StateInfo;
        DEFAULT_INSTANCE = zYStateInfo$StateInfo = new ZYStateInfo$StateInfo();
        GeneratedMessageLite.registerDefaultInstance(ZYStateInfo$StateInfo.class, zYStateInfo$StateInfo);
    }

    private ZYStateInfo$StateInfo() {
        MapFieldLite mapFieldLite;
        this.stateList_ = mapFieldLite = MapFieldLite.emptyMapField();
    }

    public static /* synthetic */ ZYStateInfo$StateInfo access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(ZYStateInfo$StateInfo zYStateInfo$StateInfo, int n10) {
        zYStateInfo$StateInfo.setErrorCodeValue(n10);
    }

    public static /* synthetic */ void access$200(ZYStateInfo$StateInfo zYStateInfo$StateInfo, ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        zYStateInfo$StateInfo.setErrorCode(zYEnumDefine$ErrorCode);
    }

    public static /* synthetic */ void access$300(ZYStateInfo$StateInfo zYStateInfo$StateInfo) {
        zYStateInfo$StateInfo.clearErrorCode();
    }

    public static /* synthetic */ void access$400(ZYStateInfo$StateInfo zYStateInfo$StateInfo, int n10) {
        zYStateInfo$StateInfo.setActionValue(n10);
    }

    public static /* synthetic */ void access$500(ZYStateInfo$StateInfo zYStateInfo$StateInfo, ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction) {
        zYStateInfo$StateInfo.setAction(zYEnumDefine$EventTypeAction);
    }

    public static /* synthetic */ void access$600(ZYStateInfo$StateInfo zYStateInfo$StateInfo) {
        zYStateInfo$StateInfo.clearAction();
    }

    public static /* synthetic */ Map access$700(ZYStateInfo$StateInfo zYStateInfo$StateInfo) {
        return zYStateInfo$StateInfo.getMutableStateListMap();
    }

    private void clearAction() {
        this.action_ = 0;
    }

    private void clearErrorCode() {
        this.errorCode_ = 0;
    }

    public static ZYStateInfo$StateInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map getMutableStateListMap() {
        return this.internalGetMutableStateList();
    }

    private MapFieldLite internalGetMutableStateList() {
        MapFieldLite mapFieldLite = this.stateList_;
        boolean bl2 = mapFieldLite.isMutable();
        if (!bl2) {
            this.stateList_ = mapFieldLite = this.stateList_.mutableCopy();
        }
        return this.stateList_;
    }

    private MapFieldLite internalGetStateList() {
        return this.stateList_;
    }

    public static ZYStateInfo$StateInfo$a newBuilder() {
        return (ZYStateInfo$StateInfo$a)DEFAULT_INSTANCE.createBuilder();
    }

    public static ZYStateInfo$StateInfo$a newBuilder(ZYStateInfo$StateInfo zYStateInfo$StateInfo) {
        return (ZYStateInfo$StateInfo$a)DEFAULT_INSTANCE.createBuilder(zYStateInfo$StateInfo);
    }

    public static ZYStateInfo$StateInfo parseDelimitedFrom(InputStream inputStream) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ZYStateInfo$StateInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ZYStateInfo$StateInfo parseFrom(ByteString byteString) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static ZYStateInfo$StateInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ZYStateInfo$StateInfo parseFrom(CodedInputStream codedInputStream) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static ZYStateInfo$StateInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ZYStateInfo$StateInfo parseFrom(InputStream inputStream) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static ZYStateInfo$StateInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ZYStateInfo$StateInfo parseFrom(ByteBuffer byteBuffer) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static ZYStateInfo$StateInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ZYStateInfo$StateInfo parseFrom(byte[] byArray) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static ZYStateInfo$StateInfo parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYStateInfo$StateInfo)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAction(ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction) {
        int n10;
        Objects.requireNonNull(zYEnumDefine$EventTypeAction);
        this.action_ = n10 = zYEnumDefine$EventTypeAction.getNumber();
    }

    private void setActionValue(int n10) {
        this.action_ = n10;
    }

    private void setErrorCode(ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        int n10;
        Objects.requireNonNull(zYEnumDefine$ErrorCode);
        this.errorCode_ = n10 = zYEnumDefine$ErrorCode.getNumber();
    }

    private void setErrorCodeValue(int n10) {
        this.errorCode_ = n10;
    }

    public boolean containsStateList(String string2) {
        Objects.requireNonNull(string2);
        return this.internalGetStateList().containsKey(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<ZYStateInfo$StateInfo>)ZYStateInfo$a.a;
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
                clazz = ZYStateInfo$StateInfo.class;
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
                objectArray[by2] = "action_";
                objectArray[2] = "stateList_";
                objectArray[3] = object = ZYStateInfo$StateInfo$b.a;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001\f\u0002\f\u00032", objectArray);
            }
            case 2: {
                return new ZYStateInfo$StateInfo$a(null);
            }
            case 1: 
        }
        return new ZYStateInfo$StateInfo();
    }

    public ZYEnumDefine$EventTypeAction getAction() {
        int n10 = this.action_;
        ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction = ZYEnumDefine$EventTypeAction.forNumber(n10);
        if (zYEnumDefine$EventTypeAction == null) {
            zYEnumDefine$EventTypeAction = ZYEnumDefine$EventTypeAction.UNRECOGNIZED;
        }
        return zYEnumDefine$EventTypeAction;
    }

    public int getActionValue() {
        return this.action_;
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

    public Map getStateList() {
        return this.getStateListMap();
    }

    public int getStateListCount() {
        return this.internalGetStateList().size();
    }

    public Map getStateListMap() {
        return Collections.unmodifiableMap(this.internalGetStateList());
    }

    public String getStateListOrDefault(String string2, String string3) {
        Objects.requireNonNull(string2);
        MapFieldLite mapFieldLite = this.internalGetStateList();
        boolean bl2 = mapFieldLite.containsKey(string2);
        if (bl2) {
            string3 = string2 = mapFieldLite.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getStateListOrThrow(String object) {
        Objects.requireNonNull(object);
        MapFieldLite mapFieldLite = this.internalGetStateList();
        boolean bl2 = mapFieldLite.containsKey(object);
        if (bl2) {
            return (String)mapFieldLite.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }
}


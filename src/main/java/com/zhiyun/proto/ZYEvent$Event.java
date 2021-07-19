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
import com.zhiyun.proto.ZYEvent$Event$a;
import com.zhiyun.proto.ZYEvent$Event$b;
import com.zhiyun.proto.ZYEvent$a;
import com.zhiyun.proto.ZYEvent$b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ZYEvent$Event
extends GeneratedMessageLite
implements ZYEvent$b {
    private static final ZYEvent$Event DEFAULT_INSTANCE;
    public static final int ERRORCODE_FIELD_NUMBER = 1;
    public static final int EVENTLIST_FIELD_NUMBER = 3;
    private static volatile Parser PARSER;
    private int errorCode_;
    private MapFieldLite eventList_;

    static {
        ZYEvent$Event zYEvent$Event;
        DEFAULT_INSTANCE = zYEvent$Event = new ZYEvent$Event();
        GeneratedMessageLite.registerDefaultInstance(ZYEvent$Event.class, zYEvent$Event);
    }

    private ZYEvent$Event() {
        MapFieldLite mapFieldLite;
        this.eventList_ = mapFieldLite = MapFieldLite.emptyMapField();
    }

    public static /* synthetic */ ZYEvent$Event access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(ZYEvent$Event zYEvent$Event, int n10) {
        zYEvent$Event.setErrorCodeValue(n10);
    }

    public static /* synthetic */ void access$200(ZYEvent$Event zYEvent$Event, ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        zYEvent$Event.setErrorCode(zYEnumDefine$ErrorCode);
    }

    public static /* synthetic */ void access$300(ZYEvent$Event zYEvent$Event) {
        zYEvent$Event.clearErrorCode();
    }

    public static /* synthetic */ Map access$400(ZYEvent$Event zYEvent$Event) {
        return zYEvent$Event.getMutableEventListMap();
    }

    private void clearErrorCode() {
        this.errorCode_ = 0;
    }

    public static ZYEvent$Event getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map getMutableEventListMap() {
        return this.internalGetMutableEventList();
    }

    private MapFieldLite internalGetEventList() {
        return this.eventList_;
    }

    private MapFieldLite internalGetMutableEventList() {
        MapFieldLite mapFieldLite = this.eventList_;
        boolean bl2 = mapFieldLite.isMutable();
        if (!bl2) {
            this.eventList_ = mapFieldLite = this.eventList_.mutableCopy();
        }
        return this.eventList_;
    }

    public static ZYEvent$Event$a newBuilder() {
        return (ZYEvent$Event$a)DEFAULT_INSTANCE.createBuilder();
    }

    public static ZYEvent$Event$a newBuilder(ZYEvent$Event zYEvent$Event) {
        return (ZYEvent$Event$a)DEFAULT_INSTANCE.createBuilder(zYEvent$Event);
    }

    public static ZYEvent$Event parseDelimitedFrom(InputStream inputStream) {
        return (ZYEvent$Event)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ZYEvent$Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYEvent$Event)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ZYEvent$Event parseFrom(ByteString byteString) {
        return (ZYEvent$Event)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static ZYEvent$Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYEvent$Event)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ZYEvent$Event parseFrom(CodedInputStream codedInputStream) {
        return (ZYEvent$Event)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static ZYEvent$Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYEvent$Event)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static ZYEvent$Event parseFrom(InputStream inputStream) {
        return (ZYEvent$Event)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static ZYEvent$Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYEvent$Event)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ZYEvent$Event parseFrom(ByteBuffer byteBuffer) {
        return (ZYEvent$Event)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static ZYEvent$Event parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYEvent$Event)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ZYEvent$Event parseFrom(byte[] byArray) {
        return (ZYEvent$Event)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static ZYEvent$Event parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (ZYEvent$Event)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
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

    public boolean containsEventList(String string2) {
        Objects.requireNonNull(string2);
        return this.internalGetEventList().containsKey(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<ZYEvent$Event>)ZYEvent$a.a;
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
                clazz = ZYEvent$Event.class;
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
                objectArray[by2] = "eventList_";
                objectArray[2] = object = ZYEvent$Event$b.a;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0001\u0000\u0000\u0001\f\u00032", objectArray);
            }
            case 2: {
                return new ZYEvent$Event$a(null);
            }
            case 1: 
        }
        return new ZYEvent$Event();
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

    public Map getEventList() {
        return this.getEventListMap();
    }

    public int getEventListCount() {
        return this.internalGetEventList().size();
    }

    public Map getEventListMap() {
        return Collections.unmodifiableMap(this.internalGetEventList());
    }

    public String getEventListOrDefault(String string2, String string3) {
        Objects.requireNonNull(string2);
        MapFieldLite mapFieldLite = this.internalGetEventList();
        boolean bl2 = mapFieldLite.containsKey(string2);
        if (bl2) {
            string3 = string2 = mapFieldLite.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getEventListOrThrow(String object) {
        Objects.requireNonNull(object);
        MapFieldLite mapFieldLite = this.internalGetEventList();
        boolean bl2 = mapFieldLite.containsKey(object);
        if (bl2) {
            return (String)mapFieldLite.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }
}


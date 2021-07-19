/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.GeneratedMessageLite$Builder;
import com.zhiyun.proto.ZYDeviceInfo$DeviceInfo;
import com.zhiyun.proto.ZYDeviceInfo$a;
import com.zhiyun.proto.ZYDeviceInfo$b;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ZYDeviceInfo$DeviceInfo$a
extends GeneratedMessageLite$Builder
implements ZYDeviceInfo$b {
    private ZYDeviceInfo$DeviceInfo$a() {
        ZYDeviceInfo$DeviceInfo zYDeviceInfo$DeviceInfo = ZYDeviceInfo$DeviceInfo.access$000();
        super(zYDeviceInfo$DeviceInfo);
    }

    public /* synthetic */ ZYDeviceInfo$DeviceInfo$a(ZYDeviceInfo$a zYDeviceInfo$a) {
        this();
    }

    public ZYDeviceInfo$DeviceInfo$a a() {
        this.copyOnWrite();
        ZYDeviceInfo$DeviceInfo.access$400((ZYDeviceInfo$DeviceInfo)this.instance).clear();
        return this;
    }

    public ZYDeviceInfo$DeviceInfo$a b() {
        this.copyOnWrite();
        ZYDeviceInfo$DeviceInfo.access$300((ZYDeviceInfo$DeviceInfo)this.instance);
        return this;
    }

    public ZYDeviceInfo$DeviceInfo$a c(Map map) {
        this.copyOnWrite();
        ZYDeviceInfo$DeviceInfo.access$400((ZYDeviceInfo$DeviceInfo)this.instance).putAll(map);
        return this;
    }

    public boolean containsDeviceInfo(String string2) {
        Objects.requireNonNull(string2);
        return ((ZYDeviceInfo$DeviceInfo)this.instance).getDeviceInfoMap().containsKey(string2);
    }

    public ZYDeviceInfo$DeviceInfo$a d(String string2, String string3) {
        Objects.requireNonNull(string2);
        Objects.requireNonNull(string3);
        this.copyOnWrite();
        ZYDeviceInfo$DeviceInfo.access$400((ZYDeviceInfo$DeviceInfo)this.instance).put(string2, string3);
        return this;
    }

    public ZYDeviceInfo$DeviceInfo$a e(String string2) {
        Objects.requireNonNull(string2);
        this.copyOnWrite();
        ZYDeviceInfo$DeviceInfo.access$400((ZYDeviceInfo$DeviceInfo)this.instance).remove(string2);
        return this;
    }

    public ZYDeviceInfo$DeviceInfo$a f(ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        this.copyOnWrite();
        ZYDeviceInfo$DeviceInfo.access$200((ZYDeviceInfo$DeviceInfo)this.instance, zYEnumDefine$ErrorCode);
        return this;
    }

    public ZYDeviceInfo$DeviceInfo$a g(int n10) {
        this.copyOnWrite();
        ZYDeviceInfo$DeviceInfo.access$100((ZYDeviceInfo$DeviceInfo)this.instance, n10);
        return this;
    }

    public Map getDeviceInfo() {
        return this.getDeviceInfoMap();
    }

    public int getDeviceInfoCount() {
        return ((ZYDeviceInfo$DeviceInfo)this.instance).getDeviceInfoMap().size();
    }

    public Map getDeviceInfoMap() {
        return Collections.unmodifiableMap(((ZYDeviceInfo$DeviceInfo)this.instance).getDeviceInfoMap());
    }

    public String getDeviceInfoOrDefault(String string2, String string3) {
        Objects.requireNonNull(string2);
        Map map = ((ZYDeviceInfo$DeviceInfo)this.instance).getDeviceInfoMap();
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            string3 = string2 = map.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getDeviceInfoOrThrow(String object) {
        Objects.requireNonNull(object);
        Map map = ((ZYDeviceInfo$DeviceInfo)this.instance).getDeviceInfoMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            return (String)map.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public ZYEnumDefine$ErrorCode getErrorCode() {
        return ((ZYDeviceInfo$DeviceInfo)this.instance).getErrorCode();
    }

    public int getErrorCodeValue() {
        return ((ZYDeviceInfo$DeviceInfo)this.instance).getErrorCodeValue();
    }
}


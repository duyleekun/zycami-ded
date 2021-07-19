/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.GeneratedMessageLite$Builder;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.proto.ZYHeartbeat$Heartbeat;
import com.zhiyun.proto.ZYHeartbeat$a;
import com.zhiyun.proto.ZYHeartbeat$b;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ZYHeartbeat$Heartbeat$a
extends GeneratedMessageLite$Builder
implements ZYHeartbeat$b {
    private ZYHeartbeat$Heartbeat$a() {
        ZYHeartbeat$Heartbeat zYHeartbeat$Heartbeat = ZYHeartbeat$Heartbeat.access$000();
        super(zYHeartbeat$Heartbeat);
    }

    public /* synthetic */ ZYHeartbeat$Heartbeat$a(ZYHeartbeat$a zYHeartbeat$a) {
        this();
    }

    public ZYHeartbeat$Heartbeat$a a() {
        this.copyOnWrite();
        ZYHeartbeat$Heartbeat.access$300((ZYHeartbeat$Heartbeat)this.instance);
        return this;
    }

    public ZYHeartbeat$Heartbeat$a b() {
        this.copyOnWrite();
        ZYHeartbeat$Heartbeat.access$400((ZYHeartbeat$Heartbeat)this.instance).clear();
        return this;
    }

    public ZYHeartbeat$Heartbeat$a c(Map map) {
        this.copyOnWrite();
        ZYHeartbeat$Heartbeat.access$400((ZYHeartbeat$Heartbeat)this.instance).putAll(map);
        return this;
    }

    public boolean containsHeartbeatInfo(String string2) {
        Objects.requireNonNull(string2);
        return ((ZYHeartbeat$Heartbeat)this.instance).getHeartbeatInfoMap().containsKey(string2);
    }

    public ZYHeartbeat$Heartbeat$a d(String string2, String string3) {
        Objects.requireNonNull(string2);
        Objects.requireNonNull(string3);
        this.copyOnWrite();
        ZYHeartbeat$Heartbeat.access$400((ZYHeartbeat$Heartbeat)this.instance).put(string2, string3);
        return this;
    }

    public ZYHeartbeat$Heartbeat$a e(String string2) {
        Objects.requireNonNull(string2);
        this.copyOnWrite();
        ZYHeartbeat$Heartbeat.access$400((ZYHeartbeat$Heartbeat)this.instance).remove(string2);
        return this;
    }

    public ZYHeartbeat$Heartbeat$a f(ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        this.copyOnWrite();
        ZYHeartbeat$Heartbeat.access$200((ZYHeartbeat$Heartbeat)this.instance, zYEnumDefine$ErrorCode);
        return this;
    }

    public ZYHeartbeat$Heartbeat$a g(int n10) {
        this.copyOnWrite();
        ZYHeartbeat$Heartbeat.access$100((ZYHeartbeat$Heartbeat)this.instance, n10);
        return this;
    }

    public ZYEnumDefine$ErrorCode getErrorCode() {
        return ((ZYHeartbeat$Heartbeat)this.instance).getErrorCode();
    }

    public int getErrorCodeValue() {
        return ((ZYHeartbeat$Heartbeat)this.instance).getErrorCodeValue();
    }

    public Map getHeartbeatInfo() {
        return this.getHeartbeatInfoMap();
    }

    public int getHeartbeatInfoCount() {
        return ((ZYHeartbeat$Heartbeat)this.instance).getHeartbeatInfoMap().size();
    }

    public Map getHeartbeatInfoMap() {
        return Collections.unmodifiableMap(((ZYHeartbeat$Heartbeat)this.instance).getHeartbeatInfoMap());
    }

    public String getHeartbeatInfoOrDefault(String string2, String string3) {
        Objects.requireNonNull(string2);
        Map map = ((ZYHeartbeat$Heartbeat)this.instance).getHeartbeatInfoMap();
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            string3 = string2 = map.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getHeartbeatInfoOrThrow(String object) {
        Objects.requireNonNull(object);
        Map map = ((ZYHeartbeat$Heartbeat)this.instance).getHeartbeatInfoMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            return (String)map.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }
}


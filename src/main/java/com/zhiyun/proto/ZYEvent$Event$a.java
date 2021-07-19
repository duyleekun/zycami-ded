/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.GeneratedMessageLite$Builder;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.proto.ZYEvent$Event;
import com.zhiyun.proto.ZYEvent$a;
import com.zhiyun.proto.ZYEvent$b;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ZYEvent$Event$a
extends GeneratedMessageLite$Builder
implements ZYEvent$b {
    private ZYEvent$Event$a() {
        ZYEvent$Event zYEvent$Event = ZYEvent$Event.access$000();
        super(zYEvent$Event);
    }

    public /* synthetic */ ZYEvent$Event$a(ZYEvent$a zYEvent$a) {
        this();
    }

    public ZYEvent$Event$a a() {
        this.copyOnWrite();
        ZYEvent$Event.access$300((ZYEvent$Event)this.instance);
        return this;
    }

    public ZYEvent$Event$a b() {
        this.copyOnWrite();
        ZYEvent$Event.access$400((ZYEvent$Event)this.instance).clear();
        return this;
    }

    public ZYEvent$Event$a c(Map map) {
        this.copyOnWrite();
        ZYEvent$Event.access$400((ZYEvent$Event)this.instance).putAll(map);
        return this;
    }

    public boolean containsEventList(String string2) {
        Objects.requireNonNull(string2);
        return ((ZYEvent$Event)this.instance).getEventListMap().containsKey(string2);
    }

    public ZYEvent$Event$a d(String string2, String string3) {
        Objects.requireNonNull(string2);
        Objects.requireNonNull(string3);
        this.copyOnWrite();
        ZYEvent$Event.access$400((ZYEvent$Event)this.instance).put(string2, string3);
        return this;
    }

    public ZYEvent$Event$a e(String string2) {
        Objects.requireNonNull(string2);
        this.copyOnWrite();
        ZYEvent$Event.access$400((ZYEvent$Event)this.instance).remove(string2);
        return this;
    }

    public ZYEvent$Event$a f(ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        this.copyOnWrite();
        ZYEvent$Event.access$200((ZYEvent$Event)this.instance, zYEnumDefine$ErrorCode);
        return this;
    }

    public ZYEvent$Event$a g(int n10) {
        this.copyOnWrite();
        ZYEvent$Event.access$100((ZYEvent$Event)this.instance, n10);
        return this;
    }

    public ZYEnumDefine$ErrorCode getErrorCode() {
        return ((ZYEvent$Event)this.instance).getErrorCode();
    }

    public int getErrorCodeValue() {
        return ((ZYEvent$Event)this.instance).getErrorCodeValue();
    }

    public Map getEventList() {
        return this.getEventListMap();
    }

    public int getEventListCount() {
        return ((ZYEvent$Event)this.instance).getEventListMap().size();
    }

    public Map getEventListMap() {
        return Collections.unmodifiableMap(((ZYEvent$Event)this.instance).getEventListMap());
    }

    public String getEventListOrDefault(String string2, String string3) {
        Objects.requireNonNull(string2);
        Map map = ((ZYEvent$Event)this.instance).getEventListMap();
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            string3 = string2 = map.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getEventListOrThrow(String object) {
        Objects.requireNonNull(object);
        Map map = ((ZYEvent$Event)this.instance).getEventListMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            return (String)map.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }
}


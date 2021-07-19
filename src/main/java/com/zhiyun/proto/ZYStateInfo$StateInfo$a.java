/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.GeneratedMessageLite$Builder;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction;
import com.zhiyun.proto.ZYStateInfo$StateInfo;
import com.zhiyun.proto.ZYStateInfo$a;
import com.zhiyun.proto.ZYStateInfo$b;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ZYStateInfo$StateInfo$a
extends GeneratedMessageLite$Builder
implements ZYStateInfo$b {
    private ZYStateInfo$StateInfo$a() {
        ZYStateInfo$StateInfo zYStateInfo$StateInfo = ZYStateInfo$StateInfo.access$000();
        super(zYStateInfo$StateInfo);
    }

    public /* synthetic */ ZYStateInfo$StateInfo$a(ZYStateInfo$a zYStateInfo$a) {
        this();
    }

    public ZYStateInfo$StateInfo$a a() {
        this.copyOnWrite();
        ZYStateInfo$StateInfo.access$600((ZYStateInfo$StateInfo)this.instance);
        return this;
    }

    public ZYStateInfo$StateInfo$a b() {
        this.copyOnWrite();
        ZYStateInfo$StateInfo.access$300((ZYStateInfo$StateInfo)this.instance);
        return this;
    }

    public ZYStateInfo$StateInfo$a c() {
        this.copyOnWrite();
        ZYStateInfo$StateInfo.access$700((ZYStateInfo$StateInfo)this.instance).clear();
        return this;
    }

    public boolean containsStateList(String string2) {
        Objects.requireNonNull(string2);
        return ((ZYStateInfo$StateInfo)this.instance).getStateListMap().containsKey(string2);
    }

    public ZYStateInfo$StateInfo$a d(Map map) {
        this.copyOnWrite();
        ZYStateInfo$StateInfo.access$700((ZYStateInfo$StateInfo)this.instance).putAll(map);
        return this;
    }

    public ZYStateInfo$StateInfo$a e(String string2, String string3) {
        Objects.requireNonNull(string2);
        Objects.requireNonNull(string3);
        this.copyOnWrite();
        ZYStateInfo$StateInfo.access$700((ZYStateInfo$StateInfo)this.instance).put(string2, string3);
        return this;
    }

    public ZYStateInfo$StateInfo$a f(String string2) {
        Objects.requireNonNull(string2);
        this.copyOnWrite();
        ZYStateInfo$StateInfo.access$700((ZYStateInfo$StateInfo)this.instance).remove(string2);
        return this;
    }

    public ZYStateInfo$StateInfo$a g(ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction) {
        this.copyOnWrite();
        ZYStateInfo$StateInfo.access$500((ZYStateInfo$StateInfo)this.instance, zYEnumDefine$EventTypeAction);
        return this;
    }

    public ZYEnumDefine$EventTypeAction getAction() {
        return ((ZYStateInfo$StateInfo)this.instance).getAction();
    }

    public int getActionValue() {
        return ((ZYStateInfo$StateInfo)this.instance).getActionValue();
    }

    public ZYEnumDefine$ErrorCode getErrorCode() {
        return ((ZYStateInfo$StateInfo)this.instance).getErrorCode();
    }

    public int getErrorCodeValue() {
        return ((ZYStateInfo$StateInfo)this.instance).getErrorCodeValue();
    }

    public Map getStateList() {
        return this.getStateListMap();
    }

    public int getStateListCount() {
        return ((ZYStateInfo$StateInfo)this.instance).getStateListMap().size();
    }

    public Map getStateListMap() {
        return Collections.unmodifiableMap(((ZYStateInfo$StateInfo)this.instance).getStateListMap());
    }

    public String getStateListOrDefault(String string2, String string3) {
        Objects.requireNonNull(string2);
        Map map = ((ZYStateInfo$StateInfo)this.instance).getStateListMap();
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            string3 = string2 = map.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getStateListOrThrow(String object) {
        Objects.requireNonNull(object);
        Map map = ((ZYStateInfo$StateInfo)this.instance).getStateListMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            return (String)map.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public ZYStateInfo$StateInfo$a i(int n10) {
        this.copyOnWrite();
        ZYStateInfo$StateInfo.access$400((ZYStateInfo$StateInfo)this.instance, n10);
        return this;
    }

    public ZYStateInfo$StateInfo$a j(ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        this.copyOnWrite();
        ZYStateInfo$StateInfo.access$200((ZYStateInfo$StateInfo)this.instance, zYEnumDefine$ErrorCode);
        return this;
    }

    public ZYStateInfo$StateInfo$a k(int n10) {
        this.copyOnWrite();
        ZYStateInfo$StateInfo.access$100((ZYStateInfo$StateInfo)this.instance, n10);
        return this;
    }
}


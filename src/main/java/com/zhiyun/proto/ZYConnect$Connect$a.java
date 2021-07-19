/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.GeneratedMessageLite$Builder;
import com.zhiyun.proto.ZYConnect$Connect;
import com.zhiyun.proto.ZYConnect$a;
import com.zhiyun.proto.ZYConnect$b;
import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class ZYConnect$Connect$a
extends GeneratedMessageLite$Builder
implements ZYConnect$b {
    private ZYConnect$Connect$a() {
        ZYConnect$Connect zYConnect$Connect = ZYConnect$Connect.access$000();
        super(zYConnect$Connect);
    }

    public /* synthetic */ ZYConnect$Connect$a(ZYConnect$a zYConnect$a) {
        this();
    }

    public ZYConnect$Connect$a a() {
        this.copyOnWrite();
        ZYConnect$Connect.access$600((ZYConnect$Connect)this.instance);
        return this;
    }

    public ZYConnect$Connect$a b() {
        this.copyOnWrite();
        ZYConnect$Connect.access$700((ZYConnect$Connect)this.instance).clear();
        return this;
    }

    public ZYConnect$Connect$a c() {
        this.copyOnWrite();
        ZYConnect$Connect.access$300((ZYConnect$Connect)this.instance);
        return this;
    }

    public boolean containsConnectExtroInfo(String string2) {
        Objects.requireNonNull(string2);
        return ((ZYConnect$Connect)this.instance).getConnectExtroInfoMap().containsKey(string2);
    }

    public ZYConnect$Connect$a d(Map map) {
        this.copyOnWrite();
        ZYConnect$Connect.access$700((ZYConnect$Connect)this.instance).putAll(map);
        return this;
    }

    public ZYConnect$Connect$a e(String string2, String string3) {
        Objects.requireNonNull(string2);
        Objects.requireNonNull(string3);
        this.copyOnWrite();
        ZYConnect$Connect.access$700((ZYConnect$Connect)this.instance).put(string2, string3);
        return this;
    }

    public ZYConnect$Connect$a f(String string2) {
        Objects.requireNonNull(string2);
        this.copyOnWrite();
        ZYConnect$Connect.access$700((ZYConnect$Connect)this.instance).remove(string2);
        return this;
    }

    public ZYConnect$Connect$a g(ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        this.copyOnWrite();
        ZYConnect$Connect.access$500((ZYConnect$Connect)this.instance, zYEnumDefine$ConnectAction);
        return this;
    }

    public ZYEnumDefine$ConnectAction getConnectAction() {
        return ((ZYConnect$Connect)this.instance).getConnectAction();
    }

    public int getConnectActionValue() {
        return ((ZYConnect$Connect)this.instance).getConnectActionValue();
    }

    public Map getConnectExtroInfo() {
        return this.getConnectExtroInfoMap();
    }

    public int getConnectExtroInfoCount() {
        return ((ZYConnect$Connect)this.instance).getConnectExtroInfoMap().size();
    }

    public Map getConnectExtroInfoMap() {
        return Collections.unmodifiableMap(((ZYConnect$Connect)this.instance).getConnectExtroInfoMap());
    }

    public String getConnectExtroInfoOrDefault(String string2, String string3) {
        Objects.requireNonNull(string2);
        Map map = ((ZYConnect$Connect)this.instance).getConnectExtroInfoMap();
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            string3 = string2 = map.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getConnectExtroInfoOrThrow(String object) {
        Objects.requireNonNull(object);
        Map map = ((ZYConnect$Connect)this.instance).getConnectExtroInfoMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            return (String)map.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public ZYEnumDefine$ErrorCode getErrorCode() {
        return ((ZYConnect$Connect)this.instance).getErrorCode();
    }

    public int getErrorCodeValue() {
        return ((ZYConnect$Connect)this.instance).getErrorCodeValue();
    }

    public ZYConnect$Connect$a i(int n10) {
        this.copyOnWrite();
        ZYConnect$Connect.access$400((ZYConnect$Connect)this.instance, n10);
        return this;
    }

    public ZYConnect$Connect$a j(ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode) {
        this.copyOnWrite();
        ZYConnect$Connect.access$200((ZYConnect$Connect)this.instance, zYEnumDefine$ErrorCode);
        return this;
    }

    public ZYConnect$Connect$a k(int n10) {
        this.copyOnWrite();
        ZYConnect$Connect.access$100((ZYConnect$Connect)this.instance, n10);
        return this;
    }
}


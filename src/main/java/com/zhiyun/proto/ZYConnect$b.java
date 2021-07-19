/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import java.util.Map;

public interface ZYConnect$b
extends MessageLiteOrBuilder {
    public boolean containsConnectExtroInfo(String var1);

    public ZYEnumDefine$ConnectAction getConnectAction();

    public int getConnectActionValue();

    public Map getConnectExtroInfo();

    public int getConnectExtroInfoCount();

    public Map getConnectExtroInfoMap();

    public String getConnectExtroInfoOrDefault(String var1, String var2);

    public String getConnectExtroInfoOrThrow(String var1);

    public ZYEnumDefine$ErrorCode getErrorCode();

    public int getErrorCodeValue();
}


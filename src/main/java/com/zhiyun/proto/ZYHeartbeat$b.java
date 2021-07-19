/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import java.util.Map;

public interface ZYHeartbeat$b
extends MessageLiteOrBuilder {
    public boolean containsHeartbeatInfo(String var1);

    public ZYEnumDefine$ErrorCode getErrorCode();

    public int getErrorCodeValue();

    public Map getHeartbeatInfo();

    public int getHeartbeatInfoCount();

    public Map getHeartbeatInfoMap();

    public String getHeartbeatInfoOrDefault(String var1, String var2);

    public String getHeartbeatInfoOrThrow(String var1);
}


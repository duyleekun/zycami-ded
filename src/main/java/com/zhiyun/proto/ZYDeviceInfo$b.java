/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import java.util.Map;

public interface ZYDeviceInfo$b
extends MessageLiteOrBuilder {
    public boolean containsDeviceInfo(String var1);

    public Map getDeviceInfo();

    public int getDeviceInfoCount();

    public Map getDeviceInfoMap();

    public String getDeviceInfoOrDefault(String var1, String var2);

    public String getDeviceInfoOrThrow(String var1);

    public ZYEnumDefine$ErrorCode getErrorCode();

    public int getErrorCodeValue();
}


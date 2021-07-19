/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import java.util.Map;

public interface ZYEvent$b
extends MessageLiteOrBuilder {
    public boolean containsEventList(String var1);

    public ZYEnumDefine$ErrorCode getErrorCode();

    public int getErrorCodeValue();

    public Map getEventList();

    public int getEventListCount();

    public Map getEventListMap();

    public String getEventListOrDefault(String var1, String var2);

    public String getEventListOrThrow(String var1);
}


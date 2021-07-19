/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction;
import java.util.Map;

public interface ZYStateInfo$b
extends MessageLiteOrBuilder {
    public boolean containsStateList(String var1);

    public ZYEnumDefine$EventTypeAction getAction();

    public int getActionValue();

    public ZYEnumDefine$ErrorCode getErrorCode();

    public int getErrorCodeValue();

    public Map getStateList();

    public int getStateListCount();

    public Map getStateListMap();

    public String getStateListOrDefault(String var1, String var2);

    public String getStateListOrThrow(String var1);
}


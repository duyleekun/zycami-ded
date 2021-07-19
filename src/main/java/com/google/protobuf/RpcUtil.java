/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcUtil$1;
import com.google.protobuf.RpcUtil$2;

public final class RpcUtil {
    private RpcUtil() {
    }

    public static /* synthetic */ Message access$000(Message message, Message message2) {
        return RpcUtil.copyAsType(message, message2);
    }

    private static Message copyAsType(Message message, Message message2) {
        return message.newBuilderForType().mergeFrom(message2).build();
    }

    public static RpcCallback generalizeCallback(RpcCallback rpcCallback, Class clazz, Message message) {
        RpcUtil$1 rpcUtil$1 = new RpcUtil$1(clazz, message, rpcCallback);
        return rpcUtil$1;
    }

    public static RpcCallback newOneTimeCallback(RpcCallback rpcCallback) {
        RpcUtil$2 rpcUtil$2 = new RpcUtil$2(rpcCallback);
        return rpcUtil$2;
    }

    public static RpcCallback specializeCallback(RpcCallback rpcCallback) {
        return rpcCallback;
    }
}


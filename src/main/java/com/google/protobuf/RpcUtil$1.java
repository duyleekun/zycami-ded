/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcUtil;

public final class RpcUtil$1
implements RpcCallback {
    public final /* synthetic */ Message val$defaultInstance;
    public final /* synthetic */ RpcCallback val$originalCallback;
    public final /* synthetic */ Class val$originalClass;

    public RpcUtil$1(Class clazz, Message message, RpcCallback rpcCallback) {
        this.val$originalClass = clazz;
        this.val$defaultInstance = message;
        this.val$originalCallback = rpcCallback;
    }

    public void run(Message message) {
        Object object = this.val$originalClass;
        object = ((Class)object).cast(message);
        try {
            object = (Message)object;
        }
        catch (ClassCastException classCastException) {
            object = RpcUtil.access$000(this.val$defaultInstance, message);
        }
        this.val$originalCallback.run(object);
    }
}


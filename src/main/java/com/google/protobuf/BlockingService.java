/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$MethodDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.RpcController;

public interface BlockingService {
    public Message callBlockingMethod(Descriptors$MethodDescriptor var1, RpcController var2, Message var3);

    public Descriptors.ServiceDescriptor getDescriptorForType();

    public Message getRequestPrototype(Descriptors$MethodDescriptor var1);

    public Message getResponsePrototype(Descriptors$MethodDescriptor var1);
}


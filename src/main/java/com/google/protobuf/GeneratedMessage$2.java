/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage$CachedDescriptorRetriever;
import com.google.protobuf.Message;
import java.util.List;

public final class GeneratedMessage$2
extends GeneratedMessage$CachedDescriptorRetriever {
    public final /* synthetic */ int val$descriptorIndex;
    public final /* synthetic */ Message val$scope;

    public GeneratedMessage$2(Message message, int n10) {
        this.val$scope = message;
        this.val$descriptorIndex = n10;
        super(null);
    }

    public Descriptors$FieldDescriptor loadDescriptor() {
        List list = this.val$scope.getDescriptorForType().getExtensions();
        int n10 = this.val$descriptorIndex;
        return (Descriptors$FieldDescriptor)list.get(n10);
    }
}


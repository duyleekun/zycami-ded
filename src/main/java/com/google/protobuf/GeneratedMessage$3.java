/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage$CachedDescriptorRetriever;
import com.google.protobuf.Message;

public final class GeneratedMessage$3
extends GeneratedMessage$CachedDescriptorRetriever {
    public final /* synthetic */ String val$name;
    public final /* synthetic */ Message val$scope;

    public GeneratedMessage$3(Message message, String string2) {
        this.val$scope = message;
        this.val$name = string2;
        super(null);
    }

    public Descriptors$FieldDescriptor loadDescriptor() {
        Descriptors$Descriptor descriptors$Descriptor = this.val$scope.getDescriptorForType();
        String string2 = this.val$name;
        return descriptors$Descriptor.findFieldByName(string2);
    }
}


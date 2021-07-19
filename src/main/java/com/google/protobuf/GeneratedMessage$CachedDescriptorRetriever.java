/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever;

public abstract class GeneratedMessage$CachedDescriptorRetriever
implements GeneratedMessage$ExtensionDescriptorRetriever {
    private volatile Descriptors$FieldDescriptor descriptor;

    private GeneratedMessage$CachedDescriptorRetriever() {
    }

    public /* synthetic */ GeneratedMessage$CachedDescriptorRetriever(GeneratedMessage$1 generatedMessage$1) {
        this();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Descriptors$FieldDescriptor getDescriptor() {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.descriptor;
        if (descriptors$FieldDescriptor != null) return this.descriptor;
        synchronized (this) {
            descriptors$FieldDescriptor = this.descriptor;
            if (descriptors$FieldDescriptor != null) return this.descriptor;
            this.descriptor = descriptors$FieldDescriptor = this.loadDescriptor();
            return this.descriptor;
        }
    }

    public abstract Descriptors$FieldDescriptor loadDescriptor();
}


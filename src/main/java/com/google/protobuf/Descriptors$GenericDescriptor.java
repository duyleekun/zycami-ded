/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Message;

public abstract class Descriptors$GenericDescriptor {
    private Descriptors$GenericDescriptor() {
    }

    public /* synthetic */ Descriptors$GenericDescriptor(Descriptors$1 descriptors$1) {
        this();
    }

    public abstract Descriptors$FileDescriptor getFile();

    public abstract String getFullName();

    public abstract String getName();

    public abstract Message toProto();
}


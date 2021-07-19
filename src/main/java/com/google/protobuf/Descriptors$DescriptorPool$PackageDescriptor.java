/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Message;

public final class Descriptors$DescriptorPool$PackageDescriptor
extends Descriptors$GenericDescriptor {
    private final Descriptors$FileDescriptor file;
    private final String fullName;
    private final String name;

    public Descriptors$DescriptorPool$PackageDescriptor(String string2, String string3, Descriptors$FileDescriptor descriptors$FileDescriptor) {
        super(null);
        this.file = descriptors$FileDescriptor;
        this.fullName = string3;
        this.name = string2;
    }

    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getName() {
        return this.name;
    }

    public Message toProto() {
        return this.file.toProto();
    }
}


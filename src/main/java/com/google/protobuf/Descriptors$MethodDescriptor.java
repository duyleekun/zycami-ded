/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$DescriptorPool$SearchFilter;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;

public final class Descriptors$MethodDescriptor
extends Descriptors$GenericDescriptor {
    private final Descriptors$FileDescriptor file;
    private final String fullName;
    private final int index;
    private Descriptors$Descriptor inputType;
    private Descriptors$Descriptor outputType;
    private DescriptorProtos$MethodDescriptorProto proto;
    private final Descriptors$ServiceDescriptor service;

    private Descriptors$MethodDescriptor(DescriptorProtos$MethodDescriptorProto object, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$ServiceDescriptor object2, int n10) {
        super(null);
        this.index = n10;
        this.proto = object;
        this.file = descriptors$FileDescriptor;
        this.service = object2;
        StringBuilder stringBuilder = new StringBuilder();
        object2 = ((Descriptors$ServiceDescriptor)object2).getFullName();
        stringBuilder.append((String)object2);
        stringBuilder.append('.');
        object = ((DescriptorProtos$MethodDescriptorProto)object).getName();
        stringBuilder.append((String)object);
        this.fullName = object = stringBuilder.toString();
        Descriptors$FileDescriptor.access$1500(descriptors$FileDescriptor).addSymbol(this);
    }

    public /* synthetic */ Descriptors$MethodDescriptor(DescriptorProtos$MethodDescriptorProto methodDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$ServiceDescriptor descriptors$ServiceDescriptor, int n10, Descriptors$1 descriptors$1) {
        this(methodDescriptorProto, descriptors$FileDescriptor, descriptors$ServiceDescriptor, n10);
    }

    public static /* synthetic */ void access$3000(Descriptors$MethodDescriptor descriptors$MethodDescriptor) {
        descriptors$MethodDescriptor.crossLink();
    }

    public static /* synthetic */ void access$3100(Descriptors$MethodDescriptor descriptors$MethodDescriptor, DescriptorProtos$MethodDescriptorProto methodDescriptorProto) {
        descriptors$MethodDescriptor.setProto(methodDescriptorProto);
    }

    private void crossLink() {
        Object object = Descriptors$FileDescriptor.access$1500(this.file);
        CharSequence charSequence = this.proto.getInputType();
        Object object2 = Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY;
        object = ((Descriptors$DescriptorPool)object).lookupSymbol((String)charSequence, this, (Descriptors$DescriptorPool$SearchFilter)((Object)object2));
        boolean bl2 = object instanceof Descriptors$Descriptor;
        String string2 = "\" is not a message type.";
        char c10 = '\"';
        if (bl2) {
            this.inputType = object = (Descriptors$Descriptor)object;
            object = Descriptors$FileDescriptor.access$1500(this.file);
            charSequence = this.proto.getOutputType();
            bl2 = (object = ((Descriptors$DescriptorPool)object).lookupSymbol((String)charSequence, this, (Descriptors$DescriptorPool$SearchFilter)((Object)object2))) instanceof Descriptors$Descriptor;
            if (bl2) {
                this.outputType = object = (Descriptors$Descriptor)object;
                return;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(c10);
            object2 = this.proto.getOutputType();
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            object = new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, (String)charSequence, null);
            throw object;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(c10);
        object2 = this.proto.getInputType();
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        object = new Descriptors$DescriptorValidationException((Descriptors$GenericDescriptor)this, (String)charSequence, null);
        throw object;
    }

    private void setProto(DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto) {
        this.proto = descriptorProtos$MethodDescriptorProto;
    }

    public Descriptors$FileDescriptor getFile() {
        return this.file;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getIndex() {
        return this.index;
    }

    public Descriptors$Descriptor getInputType() {
        return this.inputType;
    }

    public String getName() {
        return this.proto.getName();
    }

    public DescriptorProtos.MethodOptions getOptions() {
        return this.proto.getOptions();
    }

    public Descriptors$Descriptor getOutputType() {
        return this.outputType;
    }

    public Descriptors$ServiceDescriptor getService() {
        return this.service;
    }

    public boolean isClientStreaming() {
        return this.proto.getClientStreaming();
    }

    public boolean isServerStreaming() {
        return this.proto.getServerStreaming();
    }

    public DescriptorProtos$MethodDescriptorProto toProto() {
        return this.proto;
    }
}


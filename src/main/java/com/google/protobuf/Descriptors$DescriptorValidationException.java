/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Message;

public class Descriptors$DescriptorValidationException
extends Exception {
    private static final long serialVersionUID = 5750205775490483148L;
    private final String description;
    private final String name;
    private final Message proto;

    private Descriptors$DescriptorValidationException(Descriptors$FileDescriptor object, String string2) {
        CharSequence charSequence = new StringBuilder();
        String string3 = ((Descriptors$FileDescriptor)object).getName();
        charSequence.append(string3);
        charSequence.append(": ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        super((String)charSequence);
        charSequence = ((Descriptors$FileDescriptor)object).getName();
        this.name = charSequence;
        this.proto = object = ((Descriptors$FileDescriptor)object).toProto();
        this.description = string2;
    }

    public /* synthetic */ Descriptors$DescriptorValidationException(Descriptors$FileDescriptor descriptors$FileDescriptor, String string2, Descriptors$1 descriptors$1) {
        this(descriptors$FileDescriptor, string2);
    }

    private Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor object, String string2) {
        CharSequence charSequence = new StringBuilder();
        String string3 = ((Descriptors$GenericDescriptor)object).getFullName();
        charSequence.append(string3);
        charSequence.append(": ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        super((String)charSequence);
        charSequence = ((Descriptors$GenericDescriptor)object).getFullName();
        this.name = charSequence;
        this.proto = object = ((Descriptors$GenericDescriptor)object).toProto();
        this.description = string2;
    }

    public /* synthetic */ Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor descriptors$GenericDescriptor, String string2, Descriptors$1 descriptors$1) {
        this(descriptors$GenericDescriptor, string2);
    }

    private Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor descriptors$GenericDescriptor, String string2, Throwable throwable) {
        this(descriptors$GenericDescriptor, string2);
        this.initCause(throwable);
    }

    public /* synthetic */ Descriptors$DescriptorValidationException(Descriptors$GenericDescriptor descriptors$GenericDescriptor, String string2, Throwable throwable, Descriptors$1 descriptors$1) {
        this(descriptors$GenericDescriptor, string2, throwable);
    }

    public String getDescription() {
        return this.description;
    }

    public Message getProblemProto() {
        return this.proto;
    }

    public String getProblemSymbolName() {
        return this.name;
    }
}


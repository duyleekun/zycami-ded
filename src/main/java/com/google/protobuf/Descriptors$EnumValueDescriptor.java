/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$EnumValueOptions;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Internal$EnumLite;

public final class Descriptors$EnumValueDescriptor
extends Descriptors$GenericDescriptor
implements Internal$EnumLite {
    private final Descriptors$FileDescriptor file;
    private final String fullName;
    private final int index;
    private DescriptorProtos$EnumValueDescriptorProto proto;
    private final Descriptors$EnumDescriptor type;

    private Descriptors$EnumValueDescriptor(DescriptorProtos$EnumValueDescriptorProto object, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$EnumDescriptor object2, int n10) {
        super(null);
        this.index = n10;
        this.proto = object;
        this.file = descriptors$FileDescriptor;
        this.type = object2;
        StringBuilder stringBuilder = new StringBuilder();
        object2 = ((Descriptors$EnumDescriptor)object2).getFullName();
        stringBuilder.append((String)object2);
        stringBuilder.append('.');
        object = ((DescriptorProtos$EnumValueDescriptorProto)object).getName();
        stringBuilder.append((String)object);
        this.fullName = object = stringBuilder.toString();
        Descriptors$FileDescriptor.access$1500(descriptors$FileDescriptor).addSymbol(this);
        Descriptors$FileDescriptor.access$1500(descriptors$FileDescriptor).addEnumValueByNumber(this);
    }

    public /* synthetic */ Descriptors$EnumValueDescriptor(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$EnumDescriptor descriptors$EnumDescriptor, int n10, Descriptors$1 descriptors$1) {
        this(descriptorProtos$EnumValueDescriptorProto, descriptors$FileDescriptor, descriptors$EnumDescriptor, n10);
    }

    private Descriptors$EnumValueDescriptor(Descriptors$FileDescriptor object, Descriptors$EnumDescriptor object2, Integer serializable) {
        super(null);
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("UNKNOWN_ENUM_VALUE_");
        String string2 = ((Descriptors$EnumDescriptor)object2).getName();
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append("_");
        ((StringBuilder)object3).append(serializable);
        object3 = ((StringBuilder)object3).toString();
        object3 = DescriptorProtos$EnumValueDescriptorProto.newBuilder().setName((String)object3);
        int n10 = (Integer)serializable;
        serializable = ((DescriptorProtos$EnumValueDescriptorProto$Builder)object3).setNumber(n10).build();
        this.index = -1;
        this.proto = serializable;
        this.file = object;
        this.type = object2;
        object = new StringBuilder();
        object2 = ((Descriptors$EnumDescriptor)object2).getFullName();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append('.');
        object2 = ((DescriptorProtos$EnumValueDescriptorProto)serializable).getName();
        ((StringBuilder)object).append((String)object2);
        this.fullName = object = ((StringBuilder)object).toString();
    }

    public /* synthetic */ Descriptors$EnumValueDescriptor(Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$EnumDescriptor descriptors$EnumDescriptor, Integer n10, Descriptors$1 descriptors$1) {
        this(descriptors$FileDescriptor, descriptors$EnumDescriptor, n10);
    }

    public static /* synthetic */ void access$2800(Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor, DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        descriptors$EnumValueDescriptor.setProto(descriptorProtos$EnumValueDescriptorProto);
    }

    private void setProto(DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto) {
        this.proto = descriptorProtos$EnumValueDescriptorProto;
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

    public String getName() {
        return this.proto.getName();
    }

    public int getNumber() {
        return this.proto.getNumber();
    }

    public DescriptorProtos.EnumValueOptions getOptions() {
        return this.proto.getOptions();
    }

    public Descriptors$EnumDescriptor getType() {
        return this.type;
    }

    public DescriptorProtos$EnumValueDescriptorProto toProto() {
        return this.proto;
    }

    public String toString() {
        return this.proto.getName();
    }
}


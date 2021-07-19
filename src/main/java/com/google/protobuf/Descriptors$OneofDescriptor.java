/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.DescriptorProtos$OneofOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Descriptors$OneofDescriptor
extends Descriptors$GenericDescriptor {
    private Descriptors$Descriptor containingType;
    private int fieldCount;
    private Descriptors$FieldDescriptor[] fields;
    private final Descriptors$FileDescriptor file;
    private final String fullName;
    private final int index;
    private DescriptorProtos$OneofDescriptorProto proto;

    private Descriptors$OneofDescriptor(DescriptorProtos$OneofDescriptorProto object, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n10) {
        super(null);
        this.proto = object;
        object = ((DescriptorProtos$OneofDescriptorProto)object).getName();
        this.fullName = object = Descriptors.access$1700(descriptors$FileDescriptor, descriptors$Descriptor, (String)object);
        this.file = descriptors$FileDescriptor;
        this.index = n10;
        this.containingType = descriptors$Descriptor;
        this.fieldCount = 0;
    }

    public /* synthetic */ Descriptors$OneofDescriptor(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n10, Descriptors$1 descriptors$1) {
        this(descriptorProtos$OneofDescriptorProto, descriptors$FileDescriptor, descriptors$Descriptor, n10);
    }

    public static /* synthetic */ Descriptors$FieldDescriptor[] access$1900(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return descriptors$OneofDescriptor.fields;
    }

    public static /* synthetic */ Descriptors$FieldDescriptor[] access$1902(Descriptors$OneofDescriptor descriptors$OneofDescriptor, Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray) {
        descriptors$OneofDescriptor.fields = descriptors$FieldDescriptorArray;
        return descriptors$FieldDescriptorArray;
    }

    public static /* synthetic */ int access$2002(Descriptors$OneofDescriptor descriptors$OneofDescriptor, int n10) {
        descriptors$OneofDescriptor.fieldCount = n10;
        return n10;
    }

    public static /* synthetic */ int access$2008(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        int n10;
        int n11 = descriptors$OneofDescriptor.fieldCount;
        descriptors$OneofDescriptor.fieldCount = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ void access$2100(Descriptors$OneofDescriptor descriptors$OneofDescriptor, DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        descriptors$OneofDescriptor.setProto(descriptorProtos$OneofDescriptorProto);
    }

    private void setProto(DescriptorProtos$OneofDescriptorProto descriptorProtos$OneofDescriptorProto) {
        this.proto = descriptorProtos$OneofDescriptorProto;
    }

    public Descriptors$Descriptor getContainingType() {
        return this.containingType;
    }

    public Descriptors$FieldDescriptor getField(int n10) {
        return this.fields[n10];
    }

    public int getFieldCount() {
        return this.fieldCount;
    }

    public List getFields() {
        return Collections.unmodifiableList(Arrays.asList(this.fields));
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

    public DescriptorProtos.OneofOptions getOptions() {
        return this.proto.getOptions();
    }

    public DescriptorProtos$OneofDescriptorProto toProto() {
        return this.proto;
    }
}


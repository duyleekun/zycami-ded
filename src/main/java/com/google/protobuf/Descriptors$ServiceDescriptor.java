/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$MethodDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.DescriptorProtos$ServiceOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$MethodDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Descriptors$ServiceDescriptor
extends Descriptors$GenericDescriptor {
    private final Descriptors$FileDescriptor file;
    private final String fullName;
    private final int index;
    private Descriptors$MethodDescriptor[] methods;
    private DescriptorProtos$ServiceDescriptorProto proto;

    private Descriptors$ServiceDescriptor(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, int n10) {
        int n11 = 0;
        super(null);
        this.index = n10;
        this.proto = descriptorProtos$ServiceDescriptorProto;
        Descriptors$MethodDescriptor[] descriptors$MethodDescriptorArray = descriptorProtos$ServiceDescriptorProto.getName();
        descriptors$MethodDescriptorArray = Descriptors.access$1700(descriptors$FileDescriptor, null, (String)descriptors$MethodDescriptorArray);
        this.fullName = descriptors$MethodDescriptorArray;
        this.file = descriptors$FileDescriptor;
        descriptors$MethodDescriptorArray = new Descriptors$MethodDescriptor[descriptorProtos$ServiceDescriptorProto.getMethodCount()];
        this.methods = descriptors$MethodDescriptorArray;
        descriptors$MethodDescriptorArray = null;
        for (n10 = 0; n10 < (n11 = descriptorProtos$ServiceDescriptorProto.getMethodCount()); ++n10) {
            Descriptors$MethodDescriptor descriptors$MethodDescriptor;
            Descriptors$MethodDescriptor[] descriptors$MethodDescriptorArray2 = this.methods;
            DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = descriptorProtos$ServiceDescriptorProto.getMethod(n10);
            descriptors$MethodDescriptorArray2[n10] = descriptors$MethodDescriptor = new Descriptors$MethodDescriptor(descriptorProtos$MethodDescriptorProto, descriptors$FileDescriptor, this, n10, null);
        }
        Descriptors$FileDescriptor.access$1500(descriptors$FileDescriptor).addSymbol(this);
    }

    public /* synthetic */ Descriptors$ServiceDescriptor(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, int n10, Descriptors$1 descriptors$1) {
        this(descriptorProtos$ServiceDescriptorProto, descriptors$FileDescriptor, n10);
    }

    public static /* synthetic */ void access$1300(Descriptors$ServiceDescriptor descriptors$ServiceDescriptor, DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        descriptors$ServiceDescriptor.setProto(descriptorProtos$ServiceDescriptorProto);
    }

    public static /* synthetic */ void access$900(Descriptors$ServiceDescriptor descriptors$ServiceDescriptor) {
        descriptors$ServiceDescriptor.crossLink();
    }

    private void crossLink() {
        for (Descriptors$MethodDescriptor descriptors$MethodDescriptor : this.methods) {
            Descriptors$MethodDescriptor.access$3000(descriptors$MethodDescriptor);
        }
    }

    private void setProto(DescriptorProtos$ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto) {
        Object object;
        int n10;
        this.proto = descriptorProtos$ServiceDescriptorProto;
        for (int i10 = 0; i10 < (n10 = ((Descriptors$MethodDescriptor[])(object = this.methods)).length); ++i10) {
            object = object[i10];
            DescriptorProtos$MethodDescriptorProto descriptorProtos$MethodDescriptorProto = descriptorProtos$ServiceDescriptorProto.getMethod(i10);
            Descriptors$MethodDescriptor.access$3100((Descriptors$MethodDescriptor)object, descriptorProtos$MethodDescriptorProto);
        }
    }

    public Descriptors$MethodDescriptor findMethodByName(String object) {
        boolean bl2;
        Descriptors$DescriptorPool descriptors$DescriptorPool = Descriptors$FileDescriptor.access$1500(this.file);
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.fullName;
        stringBuilder.append(string2);
        char c10 = '.';
        stringBuilder.append(c10);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object = descriptors$DescriptorPool.findSymbol((String)object);
        if (object != null && (bl2 = object instanceof Descriptors$MethodDescriptor)) {
            return (Descriptors$MethodDescriptor)object;
        }
        return null;
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

    public List getMethods() {
        return Collections.unmodifiableList(Arrays.asList(this.methods));
    }

    public String getName() {
        return this.proto.getName();
    }

    public DescriptorProtos.ServiceOptions getOptions() {
        return this.proto.getOptions();
    }

    public DescriptorProtos$ServiceDescriptorProto toProto() {
        return this.proto;
    }
}


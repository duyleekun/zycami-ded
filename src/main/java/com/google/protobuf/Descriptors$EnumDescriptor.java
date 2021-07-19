/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumOptions;
import com.google.protobuf.DescriptorProtos$EnumValueDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$DescriptorPool$DescriptorIntPair;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public final class Descriptors$EnumDescriptor
extends Descriptors$GenericDescriptor
implements Internal$EnumLiteMap {
    private final Descriptors$Descriptor containingType;
    private final Descriptors$FileDescriptor file;
    private final String fullName;
    private final int index;
    private DescriptorProtos$EnumDescriptorProto proto;
    private final WeakHashMap unknownValues;
    private Descriptors$EnumValueDescriptor[] values;

    private Descriptors$EnumDescriptor(DescriptorProtos$EnumDescriptorProto serializable, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$EnumValueDescriptorArray, int n10) {
        super(null);
        Object object = new WeakHashMap();
        this.unknownValues = object;
        this.index = n10;
        this.proto = serializable;
        Descriptors$EnumValueDescriptor[] descriptors$EnumValueDescriptorArray2 = ((DescriptorProtos$EnumDescriptorProto)serializable).getName();
        descriptors$EnumValueDescriptorArray2 = Descriptors.access$1700(descriptors$FileDescriptor, (Descriptors$Descriptor)descriptors$EnumValueDescriptorArray, (String)descriptors$EnumValueDescriptorArray2);
        this.fullName = descriptors$EnumValueDescriptorArray2;
        this.file = descriptors$FileDescriptor;
        this.containingType = descriptors$EnumValueDescriptorArray;
        int n11 = ((DescriptorProtos$EnumDescriptorProto)serializable).getValueCount();
        if (n11 != 0) {
            descriptors$EnumValueDescriptorArray = new Descriptors$EnumValueDescriptor[((DescriptorProtos$EnumDescriptorProto)serializable).getValueCount()];
            this.values = descriptors$EnumValueDescriptorArray;
            descriptors$EnumValueDescriptorArray = null;
            for (n11 = 0; n11 < (n10 = ((DescriptorProtos$EnumDescriptorProto)serializable).getValueCount()); ++n11) {
                Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor;
                descriptors$EnumValueDescriptorArray2 = this.values;
                object = ((DescriptorProtos$EnumDescriptorProto)serializable).getValue(n11);
                descriptors$EnumValueDescriptorArray2[n11] = descriptors$EnumValueDescriptor = new Descriptors$EnumValueDescriptor((DescriptorProtos$EnumValueDescriptorProto)object, descriptors$FileDescriptor, this, n11, null);
            }
            Descriptors$FileDescriptor.access$1500(descriptors$FileDescriptor).addSymbol(this);
            return;
        }
        super((Descriptors$GenericDescriptor)this, "Enums must contain at least one value.", (Descriptors$1)null);
        throw serializable;
    }

    public /* synthetic */ Descriptors$EnumDescriptor(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n10, Descriptors$1 descriptors$1) {
        this(descriptorProtos$EnumDescriptorProto, descriptors$FileDescriptor, descriptors$Descriptor, n10);
    }

    public static /* synthetic */ void access$1200(Descriptors$EnumDescriptor descriptors$EnumDescriptor, DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        descriptors$EnumDescriptor.setProto(descriptorProtos$EnumDescriptorProto);
    }

    private void setProto(DescriptorProtos$EnumDescriptorProto descriptorProtos$EnumDescriptorProto) {
        Object object;
        int n10;
        this.proto = descriptorProtos$EnumDescriptorProto;
        for (int i10 = 0; i10 < (n10 = ((Descriptors$EnumValueDescriptor[])(object = this.values)).length); ++i10) {
            object = object[i10];
            DescriptorProtos$EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto = descriptorProtos$EnumDescriptorProto.getValue(i10);
            Descriptors$EnumValueDescriptor.access$2800((Descriptors$EnumValueDescriptor)object, descriptorProtos$EnumValueDescriptorProto);
        }
    }

    public Descriptors$EnumValueDescriptor findValueByName(String object) {
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
        if (object != null && (bl2 = object instanceof Descriptors$EnumValueDescriptor)) {
            return (Descriptors$EnumValueDescriptor)object;
        }
        return null;
    }

    public Descriptors$EnumValueDescriptor findValueByNumber(int n10) {
        Map map = Descriptors$DescriptorPool.access$2500(Descriptors$FileDescriptor.access$1500(this.file));
        Descriptors$DescriptorPool$DescriptorIntPair descriptors$DescriptorPool$DescriptorIntPair = new Descriptors$DescriptorPool$DescriptorIntPair(this, n10);
        return (Descriptors$EnumValueDescriptor)map.get(descriptors$DescriptorPool$DescriptorIntPair);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Descriptors$EnumValueDescriptor findValueByNumberCreatingIfUnknown(int n10) {
        Object object = this.findValueByNumber(n10);
        if (object != null) {
            return object;
        }
        synchronized (this) {
            Integer n11 = new Integer(n10);
            Object object2 = this.unknownValues;
            object2 = ((WeakHashMap)object2).get(n11);
            object2 = (WeakReference)object2;
            if (object2 != null) {
                object = object2 = ((Reference)object2).get();
                object = (Descriptors$EnumValueDescriptor)object2;
            }
            if (object == null) {
                object2 = this.file;
                WeakReference<Object> weakReference = null;
                object = new Descriptors$EnumValueDescriptor((Descriptors$FileDescriptor)object2, this, n11, null);
                object2 = this.unknownValues;
                weakReference = new WeakReference<Object>(object);
                ((WeakHashMap)object2).put(n11, weakReference);
            }
            return object;
        }
    }

    public Descriptors$Descriptor getContainingType() {
        return this.containingType;
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

    public DescriptorProtos.EnumOptions getOptions() {
        return this.proto.getOptions();
    }

    public int getUnknownEnumValueDescriptorCount() {
        return this.unknownValues.size();
    }

    public List getValues() {
        return Collections.unmodifiableList(Arrays.asList(this.values));
    }

    public DescriptorProtos$EnumDescriptorProto toProto() {
        return this.proto;
    }
}


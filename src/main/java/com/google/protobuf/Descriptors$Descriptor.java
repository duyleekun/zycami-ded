/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$DescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange;
import com.google.protobuf.DescriptorProtos$DescriptorProto$ReservedRange;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.DescriptorProtos$OneofDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$DescriptorPool$DescriptorIntPair;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Descriptors$Descriptor
extends Descriptors$GenericDescriptor {
    private final Descriptors$Descriptor containingType;
    private final Descriptors$EnumDescriptor[] enumTypes;
    private final Descriptors$FieldDescriptor[] extensions;
    private final Descriptors$FieldDescriptor[] fields;
    private final Descriptors$FileDescriptor file;
    private final String fullName;
    private final int index;
    private final Descriptors$Descriptor[] nestedTypes;
    private final Descriptors$OneofDescriptor[] oneofs;
    private DescriptorProtos$DescriptorProto proto;

    private Descriptors$Descriptor(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$OneofDescriptorArray, int n10) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor;
        Object object;
        Object object2;
        boolean bl2;
        Object object3;
        Descriptors$GenericDescriptor[] descriptors$GenericDescriptorArray;
        int n11 = 0;
        Object object4 = null;
        super(null);
        this.index = n10;
        this.proto = descriptorProtos$DescriptorProto;
        Object object5 = descriptorProtos$DescriptorProto.getName();
        object5 = Descriptors.access$1700(descriptors$FileDescriptor, (Descriptors$Descriptor)descriptors$OneofDescriptorArray, (String)object5);
        this.fullName = object5;
        this.file = descriptors$FileDescriptor;
        this.containingType = descriptors$OneofDescriptorArray;
        descriptors$OneofDescriptorArray = new Descriptors$OneofDescriptor[descriptorProtos$DescriptorProto.getOneofDeclCount()];
        this.oneofs = descriptors$OneofDescriptorArray;
        int n12 = 0;
        descriptors$OneofDescriptorArray = null;
        object5 = null;
        for (n10 = 0; n10 < (n11 = descriptorProtos$DescriptorProto.getOneofDeclCount()); ++n10) {
            descriptors$GenericDescriptorArray = this.oneofs;
            object3 = descriptorProtos$DescriptorProto.getOneofDecl(n10);
            bl2 = false;
            object4 = object2;
            object = descriptors$FileDescriptor;
            super((DescriptorProtos$OneofDescriptorProto)object3, descriptors$FileDescriptor, this, n10, null);
            descriptors$GenericDescriptorArray[n10] = object2;
        }
        object5 = new Descriptors$Descriptor[descriptorProtos$DescriptorProto.getNestedTypeCount()];
        this.nestedTypes = object5;
        object5 = null;
        for (n10 = 0; n10 < (n11 = descriptorProtos$DescriptorProto.getNestedTypeCount()); ++n10) {
            object4 = this.nestedTypes;
            object = descriptorProtos$DescriptorProto.getNestedType(n10);
            object4[n10] = object3 = new Descriptors$Descriptor((DescriptorProtos$DescriptorProto)object, descriptors$FileDescriptor, this, n10);
        }
        object5 = new Descriptors$EnumDescriptor[descriptorProtos$DescriptorProto.getEnumTypeCount()];
        this.enumTypes = object5;
        object5 = null;
        for (n10 = 0; n10 < (n11 = descriptorProtos$DescriptorProto.getEnumTypeCount()); ++n10) {
            descriptors$GenericDescriptorArray = this.enumTypes;
            object3 = descriptorProtos$DescriptorProto.getEnumType(n10);
            bl2 = false;
            object4 = object2;
            object = descriptors$FileDescriptor;
            super((DescriptorProtos$EnumDescriptorProto)object3, descriptors$FileDescriptor, this, n10, null);
            descriptors$GenericDescriptorArray[n10] = object2;
        }
        object5 = new Descriptors$FieldDescriptor[descriptorProtos$DescriptorProto.getFieldCount()];
        this.fields = object5;
        object5 = null;
        for (n10 = 0; n10 < (n11 = descriptorProtos$DescriptorProto.getFieldCount()); ++n10) {
            object2 = this.fields;
            object3 = descriptorProtos$DescriptorProto.getField(n10);
            bl2 = false;
            descriptors$GenericDescriptorArray = null;
            object4 = descriptors$FieldDescriptor;
            object = descriptors$FileDescriptor;
            descriptors$FieldDescriptor = new Descriptors$FieldDescriptor((DescriptorProtos$FieldDescriptorProto)object3, descriptors$FileDescriptor, this, n10, false, null);
            object2[n10] = descriptors$FieldDescriptor;
        }
        object5 = new Descriptors$FieldDescriptor[descriptorProtos$DescriptorProto.getExtensionCount()];
        this.extensions = object5;
        object5 = null;
        for (n10 = 0; n10 < (n11 = descriptorProtos$DescriptorProto.getExtensionCount()); ++n10) {
            object2 = this.extensions;
            object3 = descriptorProtos$DescriptorProto.getExtension(n10);
            bl2 = true;
            descriptors$GenericDescriptorArray = null;
            object4 = descriptors$FieldDescriptor;
            object = descriptors$FileDescriptor;
            descriptors$FieldDescriptor = new Descriptors$FieldDescriptor((DescriptorProtos$FieldDescriptorProto)object3, descriptors$FileDescriptor, this, n10, bl2, null);
            object2[n10] = descriptors$FieldDescriptor;
        }
        object5 = null;
        for (n10 = 0; n10 < (n11 = descriptorProtos$DescriptorProto.getOneofDeclCount()); ++n10) {
            object4 = this.oneofs;
            object3 = object4[n10];
            n11 = ((Descriptors$OneofDescriptor)((Object)object4[n10])).getFieldCount();
            object4 = new Descriptors$FieldDescriptor[n11];
            Descriptors$OneofDescriptor.access$1902((Descriptors$OneofDescriptor)object3, (Descriptors$FieldDescriptor[])object4);
            object4 = this.oneofs[n10];
            Descriptors$OneofDescriptor.access$2002((Descriptors$OneofDescriptor)object4, 0);
        }
        while (n12 < (n10 = descriptorProtos$DescriptorProto.getFieldCount())) {
            object5 = this.fields[n12].getContainingOneof();
            if (object5 != null) {
                object4 = Descriptors$OneofDescriptor.access$1900((Descriptors$OneofDescriptor)object5);
                n10 = Descriptors$OneofDescriptor.access$2008((Descriptors$OneofDescriptor)object5);
                object4[n10] = object3 = this.fields[n12];
            }
            ++n12;
        }
        Descriptors$FileDescriptor.access$1500(descriptors$FileDescriptor).addSymbol(this);
    }

    public /* synthetic */ Descriptors$Descriptor(DescriptorProtos$DescriptorProto descriptorProto, Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, int n10, Descriptors$1 descriptors$1) {
        this(descriptorProto, descriptors$FileDescriptor, descriptors$Descriptor, n10);
    }

    public Descriptors$Descriptor(String object) {
        super(null);
        String string2;
        Object object2;
        int n10 = object.lastIndexOf(46);
        int n11 = -1;
        if (n10 != n11) {
            n11 = n10 + 1;
            object2 = object.substring(n11);
            string2 = object.substring(0, n10);
        } else {
            string2 = "";
            object2 = object;
        }
        this.index = 0;
        object2 = DescriptorProtos$DescriptorProto.newBuilder().setName((String)object2);
        DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = DescriptorProtos$DescriptorProto$ExtensionRange.newBuilder().setStart(1).setEnd(0x20000000).build();
        this.proto = object2 = ((DescriptorProtos$DescriptorProto$Builder)object2).addExtensionRange(descriptorProtos$DescriptorProto$ExtensionRange).build();
        this.fullName = object;
        this.containingType = null;
        object = new Descriptors$Descriptor[]{};
        this.nestedTypes = object;
        object = new Descriptors$EnumDescriptor[]{};
        this.enumTypes = object;
        object = new Descriptors$FieldDescriptor[]{};
        this.fields = object;
        object = new Descriptors$FieldDescriptor[]{};
        this.extensions = object;
        object = new Descriptors$OneofDescriptor[]{};
        this.oneofs = object;
        super(string2, this);
        this.file = object;
    }

    public static /* synthetic */ void access$1100(Descriptors$Descriptor descriptors$Descriptor, DescriptorProtos$DescriptorProto descriptorProto) {
        descriptors$Descriptor.setProto(descriptorProto);
    }

    public static /* synthetic */ void access$800(Descriptors$Descriptor descriptors$Descriptor) {
        descriptors$Descriptor.crossLink();
    }

    private void crossLink() {
        Descriptors$GenericDescriptor descriptors$GenericDescriptor;
        int n10;
        Descriptors$GenericDescriptor[] descriptors$GenericDescriptorArray = this.nestedTypes;
        int n11 = descriptors$GenericDescriptorArray.length;
        int n12 = 0;
        Descriptors$GenericDescriptor descriptors$GenericDescriptor2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            descriptors$GenericDescriptor = descriptors$GenericDescriptorArray[n10];
            descriptors$GenericDescriptor.crossLink();
        }
        descriptors$GenericDescriptorArray = this.fields;
        n11 = descriptors$GenericDescriptorArray.length;
        descriptors$GenericDescriptor2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            descriptors$GenericDescriptor = descriptors$GenericDescriptorArray[n10];
            Descriptors$FieldDescriptor.access$1000((Descriptors$FieldDescriptor)descriptors$GenericDescriptor);
        }
        descriptors$GenericDescriptorArray = this.extensions;
        n11 = descriptors$GenericDescriptorArray.length;
        while (n12 < n11) {
            descriptors$GenericDescriptor2 = descriptors$GenericDescriptorArray[n12];
            Descriptors$FieldDescriptor.access$1000((Descriptors$FieldDescriptor)descriptors$GenericDescriptor2);
            ++n12;
        }
    }

    private void setProto(DescriptorProtos$DescriptorProto descriptorProtos$DescriptorProto) {
        int n10;
        GeneratedMessageV3 generatedMessageV3;
        Object object;
        int n11;
        int n12;
        this.proto = descriptorProtos$DescriptorProto;
        int n13 = 0;
        Object object2 = null;
        for (n12 = 0; n12 < (n11 = ((Descriptors$Descriptor[])(object = this.nestedTypes)).length); ++n12) {
            object = object[n12];
            generatedMessageV3 = descriptorProtos$DescriptorProto.getNestedType(n12);
            super.setProto((DescriptorProtos$DescriptorProto)generatedMessageV3);
        }
        object2 = null;
        for (n12 = 0; n12 < (n11 = ((Descriptors$Descriptor[])(object = this.oneofs)).length); ++n12) {
            object = object[n12];
            generatedMessageV3 = descriptorProtos$DescriptorProto.getOneofDecl(n12);
            Descriptors$OneofDescriptor.access$2100((Descriptors$OneofDescriptor)object, (DescriptorProtos$OneofDescriptorProto)generatedMessageV3);
        }
        object2 = null;
        for (n12 = 0; n12 < (n11 = ((Object)(object = this.enumTypes)).length); ++n12) {
            object = object[n12];
            generatedMessageV3 = descriptorProtos$DescriptorProto.getEnumType(n12);
            Descriptors$EnumDescriptor.access$1200((Descriptors$EnumDescriptor)object, (DescriptorProtos$EnumDescriptorProto)generatedMessageV3);
        }
        object2 = null;
        for (n12 = 0; n12 < (n11 = ((Object)(object = this.fields)).length); ++n12) {
            object = object[n12];
            generatedMessageV3 = descriptorProtos$DescriptorProto.getField(n12);
            Descriptors$FieldDescriptor.access$1400((Descriptors$FieldDescriptor)object, (DescriptorProtos$FieldDescriptorProto)generatedMessageV3);
        }
        while (n13 < (n10 = ((Descriptors$FieldDescriptor[])(object2 = this.extensions)).length)) {
            object2 = object2[n13];
            object = descriptorProtos$DescriptorProto.getExtension(n13);
            Descriptors$FieldDescriptor.access$1400((Descriptors$FieldDescriptor)object2, (DescriptorProtos$FieldDescriptorProto)object);
            ++n13;
        }
    }

    public Descriptors$EnumDescriptor findEnumTypeByName(String object) {
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
        if (object != null && (bl2 = object instanceof Descriptors$EnumDescriptor)) {
            return (Descriptors$EnumDescriptor)object;
        }
        return null;
    }

    public Descriptors$FieldDescriptor findFieldByName(String object) {
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
        if (object != null && (bl2 = object instanceof Descriptors$FieldDescriptor)) {
            return (Descriptors$FieldDescriptor)object;
        }
        return null;
    }

    public Descriptors$FieldDescriptor findFieldByNumber(int n10) {
        Map map = Descriptors$DescriptorPool.access$1600(Descriptors$FileDescriptor.access$1500(this.file));
        Descriptors$DescriptorPool$DescriptorIntPair descriptors$DescriptorPool$DescriptorIntPair = new Descriptors$DescriptorPool$DescriptorIntPair(this, n10);
        return (Descriptors$FieldDescriptor)map.get(descriptors$DescriptorPool$DescriptorIntPair);
    }

    public Descriptors$Descriptor findNestedTypeByName(String object) {
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
        if (object != null && (bl2 = object instanceof Descriptors$Descriptor)) {
            return (Descriptors$Descriptor)object;
        }
        return null;
    }

    public Descriptors$Descriptor getContainingType() {
        return this.containingType;
    }

    public List getEnumTypes() {
        return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
    }

    public List getExtensions() {
        return Collections.unmodifiableList(Arrays.asList(this.extensions));
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

    public List getNestedTypes() {
        return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
    }

    public List getOneofs() {
        return Collections.unmodifiableList(Arrays.asList(this.oneofs));
    }

    public DescriptorProtos$MessageOptions getOptions() {
        return this.proto.getOptions();
    }

    public boolean isExtendable() {
        List list = this.proto.getExtensionRangeList();
        int n10 = list.size();
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            list = null;
        }
        return n10 != 0;
    }

    public boolean isExtensionNumber(int n10) {
        int n11;
        Iterator iterator2 = this.proto.getExtensionRangeList().iterator();
        while ((n11 = iterator2.hasNext()) != 0) {
            DescriptorProtos$DescriptorProto$ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange = (DescriptorProtos$DescriptorProto$ExtensionRange)iterator2.next();
            int n12 = descriptorProtos$DescriptorProto$ExtensionRange.getStart();
            if (n12 > n10 || n10 >= (n11 = descriptorProtos$DescriptorProto$ExtensionRange.getEnd())) continue;
            return true;
        }
        return false;
    }

    public boolean isReservedName(String string2) {
        boolean bl2;
        Internal.checkNotNull(string2);
        Iterator iterator2 = this.proto.getReservedNameList().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string3 = (String)iterator2.next();
            bl2 = string3.equals(string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public boolean isReservedNumber(int n10) {
        int n11;
        Iterator iterator2 = this.proto.getReservedRangeList().iterator();
        while ((n11 = iterator2.hasNext()) != 0) {
            DescriptorProtos$DescriptorProto$ReservedRange descriptorProtos$DescriptorProto$ReservedRange = (DescriptorProtos$DescriptorProto$ReservedRange)iterator2.next();
            int n12 = descriptorProtos$DescriptorProto$ReservedRange.getStart();
            if (n12 > n10 || n10 >= (n11 = descriptorProtos$DescriptorProto$ReservedRange.getEnd())) continue;
            return true;
        }
        return false;
    }

    public DescriptorProtos$DescriptorProto toProto() {
        return this.proto;
    }
}


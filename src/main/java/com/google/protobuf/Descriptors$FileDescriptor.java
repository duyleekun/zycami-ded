/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$InternalDescriptorAssigner;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public final class Descriptors$FileDescriptor
extends Descriptors$GenericDescriptor {
    private final Descriptors$FileDescriptor[] dependencies;
    private final Descriptors$EnumDescriptor[] enumTypes;
    private final Descriptors$FieldDescriptor[] extensions;
    private final Descriptors$Descriptor[] messageTypes;
    private final Descriptors$DescriptorPool pool;
    private DescriptorProtos$FileDescriptorProto proto;
    private final Descriptors$FileDescriptor[] publicDependencies;
    private final Descriptors$ServiceDescriptor[] services;

    private Descriptors$FileDescriptor(DescriptorProtos$FileDescriptorProto serializable, Descriptors$FileDescriptor[] object, Descriptors$DescriptorPool object2, boolean bl2) {
        super(null);
        boolean bl3;
        int n10;
        int n11;
        Object object3;
        Object object4;
        int n12;
        this.pool = object2;
        this.proto = serializable;
        Object object5 = (Descriptors$FileDescriptor[])object.clone();
        this.dependencies = object5;
        super();
        int n13 = ((Object)object).length;
        int n14 = 0;
        Object object6 = null;
        for (n12 = 0; n12 < n13; ++n12) {
            object4 = object[n12];
            object3 = ((Descriptors$FileDescriptor)object4).getName();
            ((HashMap)object5).put(object3, object4);
        }
        object = new ArrayList();
        for (n13 = 0; n13 < (n12 = ((DescriptorProtos$FileDescriptorProto)serializable).getPublicDependencyCount()); ++n13) {
            int n15;
            n12 = ((DescriptorProtos$FileDescriptorProto)serializable).getPublicDependency(n13);
            if (n12 >= 0 && n12 < (n15 = ((DescriptorProtos$FileDescriptorProto)serializable).getDependencyCount())) {
                object6 = ((DescriptorProtos$FileDescriptorProto)serializable).getDependency(n12);
                object4 = (Descriptors$FileDescriptor)((HashMap)object5).get(object6);
                if (object4 == null) {
                    if (bl2) continue;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Invalid public dependency: ");
                    ((StringBuilder)object).append((String)object6);
                    object = ((StringBuilder)object).toString();
                    super(this, (String)object, null);
                    throw serializable;
                }
                object.add(object4);
                continue;
            }
            super(this, "Invalid public dependency index.", null);
            throw serializable;
        }
        int n16 = object.size();
        Object object7 = new Descriptors$FileDescriptor[n16];
        this.publicDependencies = object7;
        object.toArray((T[])object7);
        object = this.getPackage();
        ((Descriptors$DescriptorPool)object2).addPackage((String)object, this);
        object = new Descriptors$Descriptor[((DescriptorProtos$FileDescriptorProto)serializable).getMessageTypeCount()];
        this.messageTypes = object;
        object = null;
        for (n11 = 0; n11 < (n10 = ((DescriptorProtos$FileDescriptorProto)serializable).getMessageTypeCount()); ++n11) {
            object2 = this.messageTypes;
            object4 = ((DescriptorProtos$FileDescriptorProto)serializable).getMessageType(n11);
            bl3 = false;
            object6 = object7;
            object3 = this;
            super((DescriptorProtos$DescriptorProto)object4, this, null, n11, null);
            object2[n11] = object7;
        }
        object = new Descriptors$EnumDescriptor[((DescriptorProtos$FileDescriptorProto)serializable).getEnumTypeCount()];
        this.enumTypes = object;
        object = null;
        for (n11 = 0; n11 < (n10 = ((DescriptorProtos$FileDescriptorProto)serializable).getEnumTypeCount()); ++n11) {
            object2 = this.enumTypes;
            object4 = ((DescriptorProtos$FileDescriptorProto)serializable).getEnumType(n11);
            bl3 = false;
            object6 = object7;
            object3 = this;
            super((DescriptorProtos$EnumDescriptorProto)object4, this, null, n11, null);
            object2[n11] = object7;
        }
        object = new Descriptors$ServiceDescriptor[((DescriptorProtos$FileDescriptorProto)serializable).getServiceCount()];
        this.services = object;
        object = null;
        for (n11 = 0; n11 < (n10 = ((DescriptorProtos$FileDescriptorProto)serializable).getServiceCount()); ++n11) {
            object2 = this.services;
            object5 = ((DescriptorProtos$FileDescriptorProto)serializable).getService(n11);
            super((DescriptorProtos$ServiceDescriptorProto)object5, this, n11, null);
            object2[n11] = object7;
        }
        n11 = ((DescriptorProtos$FileDescriptorProto)serializable).getExtensionCount();
        object = new Descriptors$FieldDescriptor[n11];
        this.extensions = object;
        while (n14 < (n11 = ((DescriptorProtos$FileDescriptorProto)serializable).getExtensionCount())) {
            object = this.extensions;
            object4 = ((DescriptorProtos$FileDescriptorProto)serializable).getExtension(n14);
            bl3 = true;
            object6 = object2;
            object3 = this;
            object[n14] = object2 = new Descriptors$FieldDescriptor((DescriptorProtos$FieldDescriptorProto)object4, this, null, n14, bl3, null);
            ++n14;
        }
    }

    public Descriptors$FileDescriptor(String string2, Descriptors$Descriptor descriptors$Descriptor) {
        super(null);
        Descriptors$DescriptorPool descriptors$DescriptorPool;
        Object object = new Descriptors$FileDescriptor[]{};
        int n10 = 1;
        this.pool = descriptors$DescriptorPool = new Descriptors$DescriptorPool((Descriptors$FileDescriptor[])object, n10 != 0);
        object = DescriptorProtos$FileDescriptorProto.newBuilder();
        Object object2 = new StringBuilder();
        String string3 = descriptors$Descriptor.getFullName();
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append(".placeholder.proto");
        object2 = ((StringBuilder)object2).toString();
        object = ((DescriptorProtos$FileDescriptorProto$Builder)object).setName((String)object2).setPackage(string2);
        object2 = descriptors$Descriptor.toProto();
        this.proto = object = ((DescriptorProtos$FileDescriptorProto$Builder)object).addMessageType((DescriptorProtos$DescriptorProto)object2).build();
        object = new Descriptors$FileDescriptor[]{};
        this.dependencies = object;
        object = new Descriptors$FileDescriptor[]{};
        this.publicDependencies = object;
        object = new Descriptors$Descriptor[n10];
        object[0] = descriptors$Descriptor;
        this.messageTypes = object;
        object = new Descriptors$EnumDescriptor[]{};
        this.enumTypes = object;
        object = new Descriptors$ServiceDescriptor[]{};
        this.services = object;
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = new Descriptors$FieldDescriptor[]{};
        this.extensions = descriptors$FieldDescriptorArray;
        descriptors$DescriptorPool.addPackage(string2, this);
        descriptors$DescriptorPool.addSymbol(descriptors$Descriptor);
    }

    public static /* synthetic */ Descriptors$DescriptorPool access$1500(Descriptors$FileDescriptor descriptors$FileDescriptor) {
        return descriptors$FileDescriptor.pool;
    }

    public static Descriptors$FileDescriptor buildFrom(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Descriptors$FileDescriptor[] descriptors$FileDescriptorArray) {
        return Descriptors$FileDescriptor.buildFrom(descriptorProtos$FileDescriptorProto, descriptors$FileDescriptorArray, false);
    }

    public static Descriptors$FileDescriptor buildFrom(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Descriptors$FileDescriptor[] descriptors$FileDescriptorArray, boolean bl2) {
        Descriptors$DescriptorPool descriptors$DescriptorPool = new Descriptors$DescriptorPool(descriptors$FileDescriptorArray, bl2);
        Descriptors$FileDescriptor descriptors$FileDescriptor = new Descriptors$FileDescriptor(descriptorProtos$FileDescriptorProto, descriptors$FileDescriptorArray, descriptors$DescriptorPool, bl2);
        descriptors$FileDescriptor.crossLink();
        return descriptors$FileDescriptor;
    }

    private void crossLink() {
        Descriptors$GenericDescriptor descriptors$GenericDescriptor;
        int n10;
        Descriptors$GenericDescriptor[] descriptors$GenericDescriptorArray = this.messageTypes;
        int n11 = descriptors$GenericDescriptorArray.length;
        int n12 = 0;
        Descriptors$GenericDescriptor descriptors$GenericDescriptor2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            descriptors$GenericDescriptor = descriptors$GenericDescriptorArray[n10];
            Descriptors$Descriptor.access$800(descriptors$GenericDescriptor);
        }
        descriptors$GenericDescriptorArray = this.services;
        n11 = descriptors$GenericDescriptorArray.length;
        descriptors$GenericDescriptor2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            descriptors$GenericDescriptor = descriptors$GenericDescriptorArray[n10];
            Descriptors$ServiceDescriptor.access$900((Descriptors$ServiceDescriptor)descriptors$GenericDescriptor);
        }
        descriptors$GenericDescriptorArray = this.extensions;
        n11 = descriptors$GenericDescriptorArray.length;
        while (n12 < n11) {
            descriptors$GenericDescriptor2 = descriptors$GenericDescriptorArray[n12];
            Descriptors$FieldDescriptor.access$1000((Descriptors$FieldDescriptor)descriptors$GenericDescriptor2);
            ++n12;
        }
    }

    private static Descriptors$FileDescriptor[] findDescriptors(Class descriptors$FileDescriptorArray, String[] stringArray, String[] stringArray2) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            Object object = descriptors$FileDescriptorArray.getClassLoader();
            CharSequence charSequence = stringArray[i10];
            object = ((ClassLoader)object).loadClass((String)charSequence);
            charSequence = "descriptor";
            object = ((Class)object).getField((String)charSequence);
            charSequence = null;
            object = ((Field)object).get(null);
            object = (Descriptors$FileDescriptor)object;
            try {
                arrayList.add(object);
                continue;
            }
            catch (Exception exception) {
                object = Descriptors.access$100();
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Descriptors for \"");
                String string2 = stringArray2[i10];
                ((StringBuilder)charSequence).append(string2);
                string2 = "\" can not be found.";
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                ((Logger)object).warning((String)charSequence);
            }
        }
        descriptors$FileDescriptorArray = new Descriptors$FileDescriptor[]{};
        return arrayList.toArray(descriptors$FileDescriptorArray);
    }

    public static Descriptors$FileDescriptor internalBuildGeneratedFileFrom(String[] stringArray, Class descriptors$FileDescriptorArray, String[] stringArray2, String[] stringArray3) {
        descriptors$FileDescriptorArray = Descriptors$FileDescriptor.findDescriptors((Class)descriptors$FileDescriptorArray, stringArray2, stringArray3);
        return Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(stringArray, descriptors$FileDescriptorArray);
    }

    public static Descriptors$FileDescriptor internalBuildGeneratedFileFrom(String[] object, Descriptors$FileDescriptor[] descriptors$FileDescriptorArray) {
        boolean bl2;
        object = Descriptors$FileDescriptor.latin1Cat((String[])object);
        try {
            object = DescriptorProtos$FileDescriptorProto.parseFrom((byte[])object);
            bl2 = true;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            descriptors$FileDescriptorArray = new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", invalidProtocolBufferException);
            throw descriptors$FileDescriptorArray;
        }
        try {
            return Descriptors$FileDescriptor.buildFrom((DescriptorProtos$FileDescriptorProto)object, descriptors$FileDescriptorArray, bl2);
        }
        catch (Descriptors$DescriptorValidationException descriptors$DescriptorValidationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid embedded descriptor for \"");
            object = ((DescriptorProtos$FileDescriptorProto)object).getName();
            stringBuilder.append((String)object);
            stringBuilder.append("\".");
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object, descriptors$DescriptorValidationException);
            throw illegalArgumentException;
        }
    }

    public static void internalBuildGeneratedFileFrom(String[] stringArray, Class descriptors$FileDescriptorArray, String[] stringArray2, String[] stringArray3, Descriptors$FileDescriptor$InternalDescriptorAssigner descriptors$FileDescriptor$InternalDescriptorAssigner) {
        descriptors$FileDescriptorArray = Descriptors$FileDescriptor.findDescriptors((Class)descriptors$FileDescriptorArray, stringArray2, stringArray3);
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(stringArray, descriptors$FileDescriptorArray, descriptors$FileDescriptor$InternalDescriptorAssigner);
    }

    public static void internalBuildGeneratedFileFrom(String[] object, Descriptors$FileDescriptor[] object2, Descriptors$FileDescriptor$InternalDescriptorAssigner object3) {
        block6: {
            boolean bl2;
            DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto;
            String string2 = "Failed to parse protocol buffer descriptor for generated code.";
            object = Descriptors$FileDescriptor.latin1Cat(object);
            try {
                descriptorProtos$FileDescriptorProto = DescriptorProtos$FileDescriptorProto.parseFrom((byte[])object);
                bl2 = true;
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                object2 = new IllegalArgumentException(string2, invalidProtocolBufferException);
                throw object2;
            }
            try {
                object2 = Descriptors$FileDescriptor.buildFrom(descriptorProtos$FileDescriptorProto, object2, bl2);
                object3 = object3.assignDescriptors((Descriptors$FileDescriptor)object2);
                if (object3 == null) break block6;
            }
            catch (Descriptors$DescriptorValidationException descriptors$DescriptorValidationException) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Invalid embedded descriptor for \"");
                string2 = descriptorProtos$FileDescriptorProto.getName();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append("\".");
                object3 = ((StringBuilder)object3).toString();
                object2 = new IllegalArgumentException((String)object3, descriptors$DescriptorValidationException);
                throw object2;
            }
            try {
                object = DescriptorProtos$FileDescriptorProto.parseFrom((byte[])object, (ExtensionRegistryLite)object3);
                super.setProto((DescriptorProtos$FileDescriptorProto)object);
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                object2 = new IllegalArgumentException(string2, invalidProtocolBufferException);
                throw object2;
            }
        }
    }

    public static void internalUpdateFileDescriptor(Descriptors$FileDescriptor descriptors$FileDescriptor, ExtensionRegistry object) {
        ByteString byteString = descriptors$FileDescriptor.proto.toByteString();
        try {
            object = DescriptorProtos$FileDescriptorProto.parseFrom(byteString, (ExtensionRegistryLite)object);
            descriptors$FileDescriptor.setProto((DescriptorProtos$FileDescriptorProto)object);
            return;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            object = new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", invalidProtocolBufferException);
            throw object;
        }
    }

    private static byte[] latin1Cat(String[] object) {
        int n10 = ((String[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            object = object[0];
            Charset charset = Internal.ISO_8859_1;
            return ((String)object).getBytes(charset);
        }
        Comparable<StringBuilder> comparable = new StringBuilder();
        for (Object object2 : object) {
            comparable.append((String)object2);
        }
        object = comparable.toString();
        comparable = Internal.ISO_8859_1;
        return ((String)object).getBytes((Charset)comparable);
    }

    private void setProto(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        int n10;
        GeneratedMessageV3 generatedMessageV3;
        Object object;
        int n11;
        int n12;
        this.proto = descriptorProtos$FileDescriptorProto;
        int n13 = 0;
        Object object2 = null;
        for (n12 = 0; n12 < (n11 = ((Descriptors$Descriptor[])(object = this.messageTypes)).length); ++n12) {
            object = object[n12];
            generatedMessageV3 = descriptorProtos$FileDescriptorProto.getMessageType(n12);
            Descriptors$Descriptor.access$1100((Descriptors$Descriptor)object, generatedMessageV3);
        }
        object2 = null;
        for (n12 = 0; n12 < (n11 = ((Descriptors$Descriptor[])(object = this.enumTypes)).length); ++n12) {
            object = object[n12];
            generatedMessageV3 = descriptorProtos$FileDescriptorProto.getEnumType(n12);
            Descriptors$EnumDescriptor.access$1200((Descriptors$EnumDescriptor)object, (DescriptorProtos$EnumDescriptorProto)generatedMessageV3);
        }
        object2 = null;
        for (n12 = 0; n12 < (n11 = ((Descriptors$Descriptor[])(object = this.services)).length); ++n12) {
            object = object[n12];
            generatedMessageV3 = descriptorProtos$FileDescriptorProto.getService(n12);
            Descriptors$ServiceDescriptor.access$1300((Descriptors$ServiceDescriptor)object, (DescriptorProtos$ServiceDescriptorProto)generatedMessageV3);
        }
        while (n13 < (n10 = ((Descriptors$FieldDescriptor[])(object2 = this.extensions)).length)) {
            object2 = object2[n13];
            object = descriptorProtos$FileDescriptorProto.getExtension(n13);
            Descriptors$FieldDescriptor.access$1400((Descriptors$FieldDescriptor)object2, (DescriptorProtos$FieldDescriptorProto)object);
            ++n13;
        }
    }

    public Descriptors$EnumDescriptor findEnumTypeByName(String object) {
        Object object2;
        int n10;
        char c10 = '.';
        int n11 = ((String)object).indexOf(c10);
        if (n11 != (n10 = -1)) {
            return null;
        }
        String string2 = this.getPackage();
        n10 = (int)(string2.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(c10);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        if ((object = ((Descriptors$DescriptorPool)(object2 = this.pool)).findSymbol((String)object)) != null && (c10 = object instanceof Descriptors$EnumDescriptor) != '\u0000' && (object2 = ((Descriptors$GenericDescriptor)object).getFile()) == this) {
            return (Descriptors$EnumDescriptor)object;
        }
        return null;
    }

    public Descriptors$FieldDescriptor findExtensionByName(String object) {
        Object object2;
        int n10;
        char c10 = '.';
        int n11 = ((String)object).indexOf(c10);
        if (n11 != (n10 = -1)) {
            return null;
        }
        String string2 = this.getPackage();
        n10 = (int)(string2.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(c10);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        if ((object = ((Descriptors$DescriptorPool)(object2 = this.pool)).findSymbol((String)object)) != null && (c10 = object instanceof Descriptors$FieldDescriptor) != '\u0000' && (object2 = ((Descriptors$GenericDescriptor)object).getFile()) == this) {
            return (Descriptors$FieldDescriptor)object;
        }
        return null;
    }

    public Descriptors$Descriptor findMessageTypeByName(String object) {
        Object object2;
        int n10;
        char c10 = '.';
        int n11 = ((String)object).indexOf(c10);
        if (n11 != (n10 = -1)) {
            return null;
        }
        String string2 = this.getPackage();
        n10 = (int)(string2.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(c10);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        if ((object = ((Descriptors$DescriptorPool)(object2 = this.pool)).findSymbol((String)object)) != null && (c10 = object instanceof Descriptors$Descriptor) != '\u0000' && (object2 = ((Descriptors$GenericDescriptor)object).getFile()) == this) {
            return (Descriptors$Descriptor)object;
        }
        return null;
    }

    public Descriptors$ServiceDescriptor findServiceByName(String object) {
        Object object2;
        int n10;
        char c10 = '.';
        int n11 = ((String)object).indexOf(c10);
        if (n11 != (n10 = -1)) {
            return null;
        }
        String string2 = this.getPackage();
        n10 = (int)(string2.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(c10);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        if ((object = ((Descriptors$DescriptorPool)(object2 = this.pool)).findSymbol((String)object)) != null && (c10 = object instanceof Descriptors$ServiceDescriptor) != '\u0000' && (object2 = ((Descriptors$GenericDescriptor)object).getFile()) == this) {
            return (Descriptors$ServiceDescriptor)object;
        }
        return null;
    }

    public List getDependencies() {
        return Collections.unmodifiableList(Arrays.asList(this.dependencies));
    }

    public List getEnumTypes() {
        return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
    }

    public List getExtensions() {
        return Collections.unmodifiableList(Arrays.asList(this.extensions));
    }

    public Descriptors$FileDescriptor getFile() {
        return this;
    }

    public String getFullName() {
        return this.proto.getName();
    }

    public List getMessageTypes() {
        return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
    }

    public String getName() {
        return this.proto.getName();
    }

    public DescriptorProtos$FileOptions getOptions() {
        return this.proto.getOptions();
    }

    public String getPackage() {
        return this.proto.getPackage();
    }

    public List getPublicDependencies() {
        return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
    }

    public List getServices() {
        return Collections.unmodifiableList(Arrays.asList(this.services));
    }

    public Descriptors$FileDescriptor$Syntax getSyntax() {
        String string2;
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax = Descriptors$FileDescriptor$Syntax.PROTO3;
        String string3 = Descriptors$FileDescriptor$Syntax.access$000(descriptors$FileDescriptor$Syntax);
        boolean bl2 = string3.equals(string2 = this.proto.getSyntax());
        if (bl2) {
            return descriptors$FileDescriptor$Syntax;
        }
        return Descriptors$FileDescriptor$Syntax.PROTO2;
    }

    public boolean supportsUnknownEnumValue() {
        boolean bl2;
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax;
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax2 = this.getSyntax();
        if (descriptors$FileDescriptor$Syntax2 == (descriptors$FileDescriptor$Syntax = Descriptors$FileDescriptor$Syntax.PROTO3)) {
            bl2 = true;
        } else {
            bl2 = false;
            descriptors$FileDescriptor$Syntax2 = null;
        }
        return bl2;
    }

    public DescriptorProtos$FileDescriptorProto toProto() {
        return this.proto;
    }
}


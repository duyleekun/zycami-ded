/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Extension;
import com.google.protobuf.Extension$ExtensionType;
import com.google.protobuf.ExtensionRegistry$1;
import com.google.protobuf.ExtensionRegistry$DescriptorIntPair;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$GeneratedExtension;
import com.google.protobuf.Message;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExtensionRegistry
extends ExtensionRegistryLite {
    public static final ExtensionRegistry EMPTY_REGISTRY;
    private final Map immutableExtensionsByName;
    private final Map immutableExtensionsByNumber;
    private final Map mutableExtensionsByName;
    private final Map mutableExtensionsByNumber;

    static {
        ExtensionRegistry extensionRegistry;
        EMPTY_REGISTRY = extensionRegistry = new ExtensionRegistry(true);
    }

    private ExtensionRegistry() {
        HashMap hashMap;
        this.immutableExtensionsByName = hashMap = new HashMap();
        this.mutableExtensionsByName = hashMap = new HashMap();
        this.immutableExtensionsByNumber = hashMap = new HashMap();
        this.mutableExtensionsByNumber = hashMap = new HashMap();
    }

    private ExtensionRegistry(ExtensionRegistry object) {
        super((ExtensionRegistryLite)object);
        Map map;
        this.immutableExtensionsByName = map = Collections.unmodifiableMap(((ExtensionRegistry)object).immutableExtensionsByName);
        this.mutableExtensionsByName = map = Collections.unmodifiableMap(((ExtensionRegistry)object).mutableExtensionsByName);
        this.immutableExtensionsByNumber = map = Collections.unmodifiableMap(((ExtensionRegistry)object).immutableExtensionsByNumber);
        this.mutableExtensionsByNumber = object = Collections.unmodifiableMap(((ExtensionRegistry)object).mutableExtensionsByNumber);
    }

    public ExtensionRegistry(boolean bl2) {
        Map map = ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
        super((ExtensionRegistryLite)((Object)map));
        map = Collections.emptyMap();
        this.immutableExtensionsByName = map;
        this.mutableExtensionsByName = map = Collections.emptyMap();
        this.immutableExtensionsByNumber = map = Collections.emptyMap();
        this.mutableExtensionsByNumber = map = Collections.emptyMap();
    }

    private void add(ExtensionRegistry$ExtensionInfo object, Extension$ExtensionType object2) {
        Object object3 = ((ExtensionRegistry$ExtensionInfo)object).descriptor;
        Object object4 = ((Descriptors$FieldDescriptor)object3).isExtension();
        if (object4 != 0) {
            object3 = ExtensionRegistry$1.$SwitchMap$com$google$protobuf$Extension$ExtensionType;
            Object object5 = ((Enum)object2).ordinal();
            object4 = 1;
            if ((object5 = (Object)object3[object5]) != object4) {
                object4 = 2;
                if (object5 != object4) {
                    return;
                }
                object2 = this.mutableExtensionsByName;
                object3 = this.mutableExtensionsByNumber;
            } else {
                object2 = this.immutableExtensionsByName;
                object3 = this.immutableExtensionsByNumber;
            }
            Object object6 = ((ExtensionRegistry$ExtensionInfo)object).descriptor.getFullName();
            object2.put(object6, object);
            Object object7 = ((ExtensionRegistry$ExtensionInfo)object).descriptor.getContainingType();
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = ((ExtensionRegistry$ExtensionInfo)object).descriptor;
            int n10 = descriptors$FieldDescriptor.getNumber();
            object6 = new ExtensionRegistry$DescriptorIntPair((Descriptors$Descriptor)object7, n10);
            object3.put(object6, object);
            object3 = ((ExtensionRegistry$ExtensionInfo)object).descriptor;
            object6 = ((Descriptors$FieldDescriptor)object3).getContainingType().getOptions();
            boolean bl2 = ((DescriptorProtos$MessageOptions)object6).getMessageSetWireFormat();
            if (bl2 && (object6 = ((Descriptors$FieldDescriptor)object3).getType()) == (object7 = Descriptors$FieldDescriptor$Type.MESSAGE) && (bl2 = ((Descriptors$FieldDescriptor)object3).isOptional()) && (object6 = ((Descriptors$FieldDescriptor)object3).getExtensionScope()) == (object7 = ((Descriptors$FieldDescriptor)object3).getMessageType())) {
                object3 = ((Descriptors$FieldDescriptor)object3).getMessageType().getFullName();
                object2.put(object3, object);
            }
            return;
        }
        object = new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
        throw object;
    }

    public static ExtensionRegistry getEmptyRegistry() {
        return EMPTY_REGISTRY;
    }

    public static ExtensionRegistry$ExtensionInfo newExtensionInfo(Extension object) {
        Object object2;
        Object object3 = ((Extension)object).getDescriptor().getJavaType();
        if (object3 == (object2 = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
            object3 = ((Extension)object).getMessageDefaultInstance();
            if (object3 != null) {
                object2 = ((Extension)object).getDescriptor();
                object = ((Extension)object).getMessageDefaultInstance();
                object3 = new ExtensionRegistry$ExtensionInfo((Descriptors$FieldDescriptor)object2, (Message)object, null);
                return object3;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Registered message-type extension had null default instance: ");
            object = ((Extension)object).getDescriptor().getFullName();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object3 = new IllegalStateException((String)object);
            throw object3;
        }
        object = ((Extension)object).getDescriptor();
        object3 = new ExtensionRegistry$ExtensionInfo((Descriptors$FieldDescriptor)object, null, null);
        return object3;
    }

    public static ExtensionRegistry newInstance() {
        ExtensionRegistry extensionRegistry = new ExtensionRegistry();
        return extensionRegistry;
    }

    public void add(Descriptors$FieldDescriptor object) {
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
        Object object2 = ((Descriptors$FieldDescriptor)object).getJavaType();
        if (object2 != (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
            object2 = new ExtensionRegistry$ExtensionInfo((Descriptors$FieldDescriptor)object, null, null);
            object = Extension$ExtensionType.IMMUTABLE;
            this.add((ExtensionRegistry$ExtensionInfo)object2, (Extension$ExtensionType)((Object)object));
            object = Extension$ExtensionType.MUTABLE;
            this.add((ExtensionRegistry$ExtensionInfo)object2, (Extension$ExtensionType)((Object)object));
            return;
        }
        object = new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
        throw object;
    }

    public void add(Descriptors$FieldDescriptor object, Message message) {
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
        Object object2 = ((Descriptors$FieldDescriptor)object).getJavaType();
        if (object2 == (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
            object2 = new ExtensionRegistry$ExtensionInfo((Descriptors$FieldDescriptor)object, message, null);
            object = Extension$ExtensionType.IMMUTABLE;
            this.add((ExtensionRegistry$ExtensionInfo)object2, (Extension$ExtensionType)((Object)object));
            return;
        }
        object = new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
        throw object;
    }

    public void add(Extension object) {
        Extension$ExtensionType extension$ExtensionType;
        Object object2 = object.getExtensionType();
        if (object2 != (extension$ExtensionType = Extension$ExtensionType.IMMUTABLE) && (object2 = object.getExtensionType()) != (extension$ExtensionType = Extension$ExtensionType.MUTABLE)) {
            return;
        }
        object2 = ExtensionRegistry.newExtensionInfo(object);
        object = object.getExtensionType();
        this.add((ExtensionRegistry$ExtensionInfo)object2, (Extension$ExtensionType)((Object)object));
    }

    public void add(GeneratedMessage$GeneratedExtension generatedMessage$GeneratedExtension) {
        this.add((Extension)generatedMessage$GeneratedExtension);
    }

    public ExtensionRegistry$ExtensionInfo findExtensionByName(String string2) {
        return this.findImmutableExtensionByName(string2);
    }

    public ExtensionRegistry$ExtensionInfo findExtensionByNumber(Descriptors$Descriptor descriptors$Descriptor, int n10) {
        return this.findImmutableExtensionByNumber(descriptors$Descriptor, n10);
    }

    public ExtensionRegistry$ExtensionInfo findImmutableExtensionByName(String string2) {
        return (ExtensionRegistry$ExtensionInfo)this.immutableExtensionsByName.get(string2);
    }

    public ExtensionRegistry$ExtensionInfo findImmutableExtensionByNumber(Descriptors$Descriptor descriptors$Descriptor, int n10) {
        Map map = this.immutableExtensionsByNumber;
        ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair = new ExtensionRegistry$DescriptorIntPair(descriptors$Descriptor, n10);
        return (ExtensionRegistry$ExtensionInfo)map.get(extensionRegistry$DescriptorIntPair);
    }

    public ExtensionRegistry$ExtensionInfo findMutableExtensionByName(String string2) {
        return (ExtensionRegistry$ExtensionInfo)this.mutableExtensionsByName.get(string2);
    }

    public ExtensionRegistry$ExtensionInfo findMutableExtensionByNumber(Descriptors$Descriptor descriptors$Descriptor, int n10) {
        Map map = this.mutableExtensionsByNumber;
        ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair = new ExtensionRegistry$DescriptorIntPair(descriptors$Descriptor, n10);
        return (ExtensionRegistry$ExtensionInfo)map.get(extensionRegistry$DescriptorIntPair);
    }

    public Set getAllImmutableExtensionsByExtendedType(String string2) {
        boolean bl2;
        HashSet<ExtensionRegistry$DescriptorIntPair> hashSet = new HashSet<ExtensionRegistry$DescriptorIntPair>();
        Iterator iterator2 = this.immutableExtensionsByNumber.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair = (ExtensionRegistry$DescriptorIntPair)iterator2.next();
            Object object = ExtensionRegistry$DescriptorIntPair.access$000(extensionRegistry$DescriptorIntPair).getFullName();
            boolean bl3 = ((String)object).equals(string2);
            if (!bl3) continue;
            object = this.immutableExtensionsByNumber;
            extensionRegistry$DescriptorIntPair = object.get(extensionRegistry$DescriptorIntPair);
            hashSet.add(extensionRegistry$DescriptorIntPair);
        }
        return hashSet;
    }

    public Set getAllMutableExtensionsByExtendedType(String string2) {
        boolean bl2;
        HashSet<ExtensionRegistry$DescriptorIntPair> hashSet = new HashSet<ExtensionRegistry$DescriptorIntPair>();
        Iterator iterator2 = this.mutableExtensionsByNumber.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            ExtensionRegistry$DescriptorIntPair extensionRegistry$DescriptorIntPair = (ExtensionRegistry$DescriptorIntPair)iterator2.next();
            Object object = ExtensionRegistry$DescriptorIntPair.access$000(extensionRegistry$DescriptorIntPair).getFullName();
            boolean bl3 = ((String)object).equals(string2);
            if (!bl3) continue;
            object = this.mutableExtensionsByNumber;
            extensionRegistry$DescriptorIntPair = object.get(extensionRegistry$DescriptorIntPair);
            hashSet.add(extensionRegistry$DescriptorIntPair);
        }
        return hashSet;
    }

    public ExtensionRegistry getUnmodifiable() {
        ExtensionRegistry extensionRegistry = new ExtensionRegistry(this);
        return extensionRegistry;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$1;
import com.google.protobuf.MapEntry$Metadata;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.UnknownFieldSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapEntry$Builder
extends AbstractMessage$Builder {
    private boolean hasKey;
    private boolean hasValue;
    private Object key;
    private final MapEntry$Metadata metadata;
    private Object value;

    private MapEntry$Builder(MapEntry$Metadata mapEntry$Metadata) {
        Object object = mapEntry$Metadata.defaultKey;
        Object object2 = mapEntry$Metadata.defaultValue;
        this(mapEntry$Metadata, object, object2, false, false);
    }

    public /* synthetic */ MapEntry$Builder(MapEntry$Metadata mapEntry$Metadata, MapEntry$1 mapEntry$1) {
        this(mapEntry$Metadata);
    }

    private MapEntry$Builder(MapEntry$Metadata mapEntry$Metadata, Object object, Object object2, boolean bl2, boolean bl3) {
        this.metadata = mapEntry$Metadata;
        this.key = object;
        this.value = object2;
        this.hasKey = bl2;
        this.hasValue = bl3;
    }

    public /* synthetic */ MapEntry$Builder(MapEntry$Metadata mapEntry$Metadata, Object object, Object object2, boolean bl2, boolean bl3, MapEntry$1 mapEntry$1) {
        this(mapEntry$Metadata, object, object2, bl2, bl3);
    }

    private void checkFieldDescriptor(Descriptors$FieldDescriptor object) {
        Object object2;
        Object object3 = ((Descriptors$FieldDescriptor)object).getContainingType();
        if (object3 == (object2 = this.metadata.descriptor)) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Wrong FieldDescriptor \"");
        object = ((Descriptors$FieldDescriptor)object).getFullName();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("\" used in message \"");
        object = this.metadata.descriptor.getFullName();
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object3 = new RuntimeException((String)object);
        throw object3;
    }

    public MapEntry$Builder addRepeatedField(Descriptors$FieldDescriptor object, Object object2) {
        object = new RuntimeException("There is no repeated field in a map entry message.");
        throw object;
    }

    public MapEntry build() {
        MapEntry mapEntry = this.buildPartial();
        boolean bl2 = mapEntry.isInitialized();
        if (bl2) {
            return mapEntry;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(mapEntry);
    }

    public MapEntry buildPartial() {
        MapEntry$Metadata mapEntry$Metadata = this.metadata;
        Object object = this.key;
        Object object2 = this.value;
        MapEntry mapEntry = new MapEntry(mapEntry$Metadata, object, object2, null);
        return mapEntry;
    }

    public MapEntry$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        int n10 = descriptors$FieldDescriptor.getNumber();
        int n11 = 1;
        if (n10 == n11) {
            this.clearKey();
        } else {
            this.clearValue();
        }
        return this;
    }

    public MapEntry$Builder clearKey() {
        Object object;
        this.key = object = this.metadata.defaultKey;
        this.hasKey = false;
        return this;
    }

    public MapEntry$Builder clearValue() {
        Object object;
        this.value = object = this.metadata.defaultValue;
        this.hasValue = false;
        return this;
    }

    public MapEntry$Builder clone() {
        MapEntry$Metadata mapEntry$Metadata = this.metadata;
        Object object = this.key;
        Object object2 = this.value;
        boolean bl2 = this.hasKey;
        boolean bl3 = this.hasValue;
        MapEntry$Builder mapEntry$Builder = new MapEntry$Builder(mapEntry$Metadata, object, object2, bl2, bl3);
        return mapEntry$Builder;
    }

    public Map getAllFields() {
        boolean bl2;
        TreeMap<Descriptors$FieldDescriptor, Object> treeMap = new TreeMap<Descriptors$FieldDescriptor, Object>();
        Iterator iterator2 = this.metadata.descriptor.getFields().iterator();
        while (bl2 = iterator2.hasNext()) {
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)iterator2.next();
            boolean bl3 = this.hasField(descriptors$FieldDescriptor);
            if (!bl3) continue;
            Object object = this.getField(descriptors$FieldDescriptor);
            treeMap.put(descriptors$FieldDescriptor, object);
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public MapEntry getDefaultInstanceForType() {
        MapEntry$Metadata mapEntry$Metadata = this.metadata;
        Object object = mapEntry$Metadata.defaultKey;
        Object object2 = mapEntry$Metadata.defaultValue;
        MapEntry mapEntry = new MapEntry(mapEntry$Metadata, object, object2, null);
        return mapEntry;
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return this.metadata.descriptor;
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$GenericDescriptor) {
        this.checkFieldDescriptor((Descriptors$FieldDescriptor)descriptors$GenericDescriptor);
        int n10 = ((Descriptors$FieldDescriptor)descriptors$GenericDescriptor).getNumber();
        int n11 = 1;
        Object object = n10 == n11 ? this.getKey() : this.getValue();
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type = ((Descriptors$FieldDescriptor)descriptors$GenericDescriptor).getType();
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type2 = Descriptors$FieldDescriptor$Type.ENUM;
        if (descriptors$FieldDescriptor$Type == descriptors$FieldDescriptor$Type2) {
            descriptors$GenericDescriptor = ((Descriptors$FieldDescriptor)descriptors$GenericDescriptor).getEnumType();
            n10 = (Integer)object;
            object = ((Descriptors$EnumDescriptor)descriptors$GenericDescriptor).findValueByNumberCreatingIfUnknown(n10);
        }
        return object;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getRepeatedField(Descriptors$FieldDescriptor object, int n10) {
        object = new RuntimeException("There is no repeated field in a map entry message.");
        throw object;
    }

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor object) {
        object = new RuntimeException("There is no repeated field in a map entry message.");
        throw object;
    }

    public UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    public Object getValue() {
        return this.value;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        void var2_5;
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        int bl2 = descriptors$FieldDescriptor.getNumber();
        int n10 = 1;
        if (bl2 == n10) {
            boolean bl3 = this.hasKey;
        } else {
            boolean bl4 = this.hasValue;
        }
        return (boolean)var2_5;
    }

    public boolean isInitialized() {
        MapEntry$Metadata mapEntry$Metadata = this.metadata;
        Object object = this.value;
        return MapEntry.access$600(mapEntry$Metadata, object);
    }

    public Message$Builder newBuilderForField(Descriptors$FieldDescriptor object) {
        Object object2;
        Object object3;
        this.checkFieldDescriptor((Descriptors$FieldDescriptor)object);
        int n10 = ((Descriptors$FieldDescriptor)object).getNumber();
        int n11 = 2;
        if (n10 == n11 && (object3 = ((Descriptors$FieldDescriptor)object).getJavaType()) == (object2 = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
            return ((Message)this.value).newBuilderForType();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("\"");
        object = ((Descriptors$FieldDescriptor)object).getFullName();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("\" is not a message value field.");
        object = ((StringBuilder)object2).toString();
        object3 = new RuntimeException((String)object);
        throw object3;
    }

    public MapEntry$Builder setField(Descriptors$FieldDescriptor object, Object object2) {
        this.checkFieldDescriptor((Descriptors$FieldDescriptor)object);
        int n10 = ((Descriptors$FieldDescriptor)object).getNumber();
        int n11 = 1;
        if (n10 == n11) {
            this.setKey(object2);
        } else {
            boolean bl2;
            Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
            Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type2 = ((Descriptors$FieldDescriptor)object).getType();
            if (descriptors$FieldDescriptor$Type2 == (descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.ENUM)) {
                int n12 = ((Descriptors$EnumValueDescriptor)object2).getNumber();
                object2 = n12;
            } else if ((object = ((Descriptors$FieldDescriptor)object).getType()) == (descriptors$FieldDescriptor$Type2 = Descriptors$FieldDescriptor$Type.MESSAGE) && object2 != null && !(bl2 = ((Class)(object = this.metadata.defaultValue.getClass())).isInstance(object2))) {
                object = ((Message)this.metadata.defaultValue).toBuilder();
                object2 = (Message)object2;
                object = object.mergeFrom((Message)object2);
                object2 = object.build();
            }
            this.setValue(object2);
        }
        return this;
    }

    public MapEntry$Builder setKey(Object object) {
        this.key = object;
        this.hasKey = true;
        return this;
    }

    public MapEntry$Builder setRepeatedField(Descriptors$FieldDescriptor object, int n10, Object object2) {
        object = new RuntimeException("There is no repeated field in a map entry message.");
        throw object;
    }

    public MapEntry$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    public MapEntry$Builder setValue(Object object) {
        this.value = object;
        this.hasValue = true;
        return this;
    }
}


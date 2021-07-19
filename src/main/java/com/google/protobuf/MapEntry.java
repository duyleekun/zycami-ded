/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry$1;
import com.google.protobuf.MapEntry$Builder;
import com.google.protobuf.MapEntry$Metadata;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public final class MapEntry
extends AbstractMessage {
    private volatile int cachedSerializedSize;
    private final Object key;
    private final MapEntry$Metadata metadata;
    private final Object value;

    private MapEntry(Descriptors$Descriptor descriptors$Descriptor, WireFormat$FieldType wireFormat$FieldType, Object object, WireFormat$FieldType wireFormat$FieldType2, Object object2) {
        this.cachedSerializedSize = -1;
        this.key = object;
        this.value = object2;
        this.metadata = object = new MapEntry$Metadata(descriptors$Descriptor, this, wireFormat$FieldType, wireFormat$FieldType2);
    }

    private MapEntry(MapEntry$Metadata object, CodedInputStream object2, ExtensionRegistryLite extensionRegistryLite) {
        int n10;
        this.cachedSerializedSize = n10 = -1;
        this.metadata = object;
        object = MapEntryLite.parseEntry((CodedInputStream)object2, (MapEntryLite$Metadata)object, extensionRegistryLite);
        object2 = object.getKey();
        this.key = object2;
        object = object.getValue();
        try {
            this.value = object;
            return;
        }
        catch (IOException iOException) {
            object2 = new InvalidProtocolBufferException(iOException);
            throw ((InvalidProtocolBufferException)object2).setUnfinishedMessage(this);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.setUnfinishedMessage(this);
        }
    }

    public /* synthetic */ MapEntry(MapEntry$Metadata mapEntry$Metadata, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, MapEntry$1 mapEntry$1) {
        this(mapEntry$Metadata, codedInputStream, extensionRegistryLite);
    }

    private MapEntry(MapEntry$Metadata mapEntry$Metadata, Object object, Object object2) {
        this.cachedSerializedSize = -1;
        this.key = object;
        this.value = object2;
        this.metadata = mapEntry$Metadata;
    }

    public /* synthetic */ MapEntry(MapEntry$Metadata mapEntry$Metadata, Object object, Object object2, MapEntry$1 mapEntry$1) {
        this(mapEntry$Metadata, object, object2);
    }

    public static /* synthetic */ Object access$000(MapEntry mapEntry) {
        return mapEntry.key;
    }

    public static /* synthetic */ Object access$100(MapEntry mapEntry) {
        return mapEntry.value;
    }

    public static /* synthetic */ boolean access$600(MapEntry$Metadata mapEntry$Metadata, Object object) {
        return MapEntry.isInitialized(mapEntry$Metadata, object);
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

    private static boolean isInitialized(MapEntry$Metadata object, Object object2) {
        WireFormat$JavaType wireFormat$JavaType;
        object = object.valueType.getJavaType();
        if (object == (wireFormat$JavaType = WireFormat$JavaType.MESSAGE)) {
            return ((MessageLite)object2).isInitialized();
        }
        return true;
    }

    public static MapEntry newDefaultInstance(Descriptors$Descriptor descriptors$Descriptor, WireFormat$FieldType wireFormat$FieldType, Object object, WireFormat$FieldType wireFormat$FieldType2, Object object2) {
        MapEntry mapEntry = new MapEntry(descriptors$Descriptor, wireFormat$FieldType, object, wireFormat$FieldType2, object2);
        return mapEntry;
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
        MapEntry mapEntry = new MapEntry(mapEntry$Metadata, object, object2);
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

    public final MapEntry$Metadata getMetadata() {
        return this.metadata;
    }

    public Parser getParserForType() {
        return this.metadata.parser;
    }

    public Object getRepeatedField(Descriptors$FieldDescriptor object, int n10) {
        object = new RuntimeException("There is no repeated field in a map entry message.");
        throw object;
    }

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor object) {
        object = new RuntimeException("There is no repeated field in a map entry message.");
        throw object;
    }

    public int getSerializedSize() {
        int n10 = this.cachedSerializedSize;
        int n11 = -1;
        if (n10 != n11) {
            return this.cachedSerializedSize;
        }
        MapEntry$Metadata mapEntry$Metadata = this.metadata;
        Object object = this.key;
        Object object2 = this.value;
        this.cachedSerializedSize = n10 = MapEntryLite.computeSerializedSize(mapEntry$Metadata, object, object2);
        return n10;
    }

    public UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    public Object getValue() {
        return this.value;
    }

    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.checkFieldDescriptor(descriptors$FieldDescriptor);
        return true;
    }

    public boolean isInitialized() {
        MapEntry$Metadata mapEntry$Metadata = this.metadata;
        Object object = this.value;
        return MapEntry.isInitialized(mapEntry$Metadata, object);
    }

    public MapEntry$Builder newBuilderForType() {
        MapEntry$Metadata mapEntry$Metadata = this.metadata;
        MapEntry$Builder mapEntry$Builder = new MapEntry$Builder(mapEntry$Metadata, null);
        return mapEntry$Builder;
    }

    public MapEntry$Builder toBuilder() {
        MapEntry$Metadata mapEntry$Metadata = this.metadata;
        Object object = this.key;
        Object object2 = this.value;
        MapEntry$Builder mapEntry$Builder = new MapEntry$Builder(mapEntry$Metadata, object, object2, true, true, null);
        return mapEntry$Builder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        MapEntry$Metadata mapEntry$Metadata = this.metadata;
        Object object = this.key;
        Object object2 = this.value;
        MapEntryLite.writeTo(codedOutputStream, mapEntry$Metadata, object, object2);
    }
}


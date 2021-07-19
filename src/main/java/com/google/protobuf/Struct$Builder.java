/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.protobuf.Struct$1;
import com.google.protobuf.Struct$FieldsDefaultEntryHolder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.Value;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public final class Struct$Builder
extends GeneratedMessageV3$Builder
implements StructOrBuilder {
    private int bitField0_;
    private MapField fields_;

    private Struct$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Struct$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        super(generatedMessageV3$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Struct$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Struct$1 struct$1) {
        this(generatedMessageV3$BuilderParent);
    }

    public /* synthetic */ Struct$Builder(Struct$1 struct$1) {
        this();
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    private MapField internalGetFields() {
        MapField mapField = this.fields_;
        if (mapField == null) {
            mapField = MapField.emptyMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
        }
        return mapField;
    }

    private MapField internalGetMutableFields() {
        boolean bl2;
        this.onChanged();
        MapField mapField = this.fields_;
        if (mapField == null) {
            this.fields_ = mapField = MapField.newMapField(Struct$FieldsDefaultEntryHolder.defaultEntry);
        }
        if (!(bl2 = (mapField = this.fields_).isMutable())) {
            this.fields_ = mapField = this.fields_.copy();
        }
        return this.fields_;
    }

    private void maybeForceBuilderInitialization() {
    }

    public Struct$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Struct$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Struct build() {
        Message message = this.buildPartial();
        boolean bl2 = ((Struct)message).isInitialized();
        if (bl2) {
            return message;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(message);
    }

    public Struct buildPartial() {
        Struct struct = new Struct(this, null);
        MapField mapField = this.internalGetFields();
        Struct.access$302(struct, mapField);
        Struct.access$300(struct).makeImmutable();
        this.onBuilt();
        return struct;
    }

    public Struct$Builder clear() {
        super.clear();
        this.internalGetMutableFields().clear();
        return this;
    }

    public Struct$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Struct$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Struct$Builder clearFields() {
        this.internalGetMutableFields().getMutableMap().clear();
        return this;
    }

    public Struct$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Struct$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Struct$Builder clone() {
        return (Struct$Builder)super.clone();
    }

    public boolean containsFields(String string2) {
        Objects.requireNonNull(string2);
        return this.internalGetFields().getMap().containsKey(string2);
    }

    public Struct getDefaultInstanceForType() {
        return Struct.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return StructProto.internal_static_google_protobuf_Struct_descriptor;
    }

    public Map getFields() {
        return this.getFieldsMap();
    }

    public int getFieldsCount() {
        return this.internalGetFields().getMap().size();
    }

    public Map getFieldsMap() {
        return this.internalGetFields().getMap();
    }

    public Value getFieldsOrDefault(String string2, Value object) {
        Objects.requireNonNull(string2);
        Map map = this.internalGetFields().getMap();
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            string2 = map.get(string2);
            object = string2;
            object = (Value)((Object)string2);
        }
        return object;
    }

    public Value getFieldsOrThrow(String object) {
        Objects.requireNonNull(object);
        Map map = this.internalGetFields().getMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            return (Value)map.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public Map getMutableFields() {
        return this.internalGetMutableFields().getMutableMap();
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable.ensureFieldAccessorsInitialized(Struct.class, Struct$Builder.class);
    }

    public MapField internalGetMapField(int n10) {
        int n11 = 1;
        if (n10 == n11) {
            return this.internalGetFields();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid map field number: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        RuntimeException runtimeException = new RuntimeException(string2);
        throw runtimeException;
    }

    public MapField internalGetMutableMapField(int n10) {
        int n11 = 1;
        if (n10 == n11) {
            return this.internalGetMutableFields();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid map field number: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        RuntimeException runtimeException = new RuntimeException(string2);
        throw runtimeException;
    }

    public final boolean isInitialized() {
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Struct$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Struct.access$500();
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Struct)object;
            if (object == null) break block7;
            this.mergeFrom((Struct)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Struct)object2;
            }
            try {
                IOException iOException = invalidProtocolBufferException.unwrapIOException();
                throw iOException;
            }
            catch (Throwable throwable) {
                object3 = object2;
            }
        }
        if (object3 != null) {
            this.mergeFrom((Struct)object3);
        }
        throw var1_6;
    }

    public Struct$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Struct;
        if (bl2) {
            message = (Struct)message;
            return this.mergeFrom((Struct)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Struct$Builder mergeFrom(Struct messageLite) {
        Object object = Struct.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = this.internalGetMutableFields();
        MapField mapField = Struct.access$400(messageLite);
        ((MapField)object).mergeFrom(mapField);
        messageLite = messageLite.unknownFields;
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    public final Struct$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Struct$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Struct$Builder putAllFields(Map map) {
        this.internalGetMutableFields().getMutableMap().putAll(map);
        return this;
    }

    public Struct$Builder putFields(String string2, Value value) {
        Objects.requireNonNull(string2);
        Objects.requireNonNull(value);
        this.internalGetMutableFields().getMutableMap().put(string2, value);
        return this;
    }

    public Struct$Builder removeFields(String string2) {
        Objects.requireNonNull(string2);
        this.internalGetMutableFields().getMutableMap().remove(string2);
        return this;
    }

    public Struct$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Struct$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Struct$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Struct$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Struct$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Struct$Builder)super.setUnknownFields(unknownFieldSet);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$Builder;
import com.google.protobuf.MapField;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct$1;
import com.google.protobuf.Struct$Builder;
import com.google.protobuf.Struct$FieldsDefaultEntryHolder;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.StructProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.Value;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public final class Struct
extends GeneratedMessageV3
implements StructOrBuilder {
    private static final Struct DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static final Parser PARSER;
    private static final long serialVersionUID;
    private MapField fields_;
    private byte memoizedIsInitialized = (byte)-1;

    static {
        Object object = new Struct();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Struct$1();
    }

    private Struct() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Struct(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
        Objects.requireNonNull(object2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        boolean bl2 = false;
        int n10 = 0;
        while (true) {
            if (bl2) {
                this.unknownFields = object = unknownFieldSet$Builder.build();
                this.makeExtensionsImmutable();
                return;
            }
            try {
                try {
                    int n11 = ((CodedInputStream)object).readTag();
                    boolean bl3 = true;
                    if (n11 != 0) {
                        int n12 = 10;
                        if (n11 != n12) {
                            if ((n11 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n11) ? 1 : 0)) != 0) continue;
                        } else {
                            Object object3;
                            n11 = n10 & 1;
                            if (n11 == 0) {
                                object3 = Struct$FieldsDefaultEntryHolder.defaultEntry;
                                this.fields_ = object3 = MapField.newMapField((MapEntry)object3);
                                n10 |= 1;
                            }
                            object3 = Struct$FieldsDefaultEntryHolder.defaultEntry;
                            object3 = ((MapEntry)object3).getParserForType();
                            object3 = ((CodedInputStream)object).readMessage((Parser)object3, (ExtensionRegistryLite)object2);
                            object3 = (MapEntry)object3;
                            Object object4 = this.fields_;
                            object4 = ((MapField)object4).getMutableMap();
                            Object object5 = ((MapEntry)object3).getKey();
                            object3 = ((MapEntry)object3).getValue();
                            object4.put(object5, object3);
                            continue;
                        }
                    }
                    bl2 = bl3;
                    continue;
                }
                catch (IOException iOException) {
                    object2 = new InvalidProtocolBufferException(iOException);
                    InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)object2).setUnfinishedMessage(this);
                    throw invalidProtocolBufferException;
                }
                catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                    InvalidProtocolBufferException invalidProtocolBufferException2 = invalidProtocolBufferException.setUnfinishedMessage(this);
                    throw invalidProtocolBufferException2;
                }
            }
            catch (Throwable throwable2) {}
            break;
        }
        this.unknownFields = object2 = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
        throw throwable2;
    }

    public /* synthetic */ Struct(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Struct$1 struct$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Struct(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Struct(GeneratedMessageV3$Builder generatedMessageV3$Builder, Struct$1 struct$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ MapField access$300(Struct struct) {
        return struct.fields_;
    }

    public static /* synthetic */ MapField access$302(Struct struct, MapField mapField) {
        struct.fields_ = mapField;
        return mapField;
    }

    public static /* synthetic */ MapField access$400(Struct struct) {
        return struct.internalGetFields();
    }

    public static /* synthetic */ Parser access$500() {
        return PARSER;
    }

    public static Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static Struct$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Struct$Builder newBuilder(Struct struct) {
        return ((Struct$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(struct);
    }

    public static Struct parseDelimitedFrom(InputStream inputStream) {
        return (Struct)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Struct parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Struct parseFrom(ByteString byteString) {
        return (Struct)PARSER.parseFrom(byteString);
    }

    public static Struct parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Struct parseFrom(CodedInputStream codedInputStream) {
        return (Struct)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Struct parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Struct parseFrom(InputStream inputStream) {
        return (Struct)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Struct parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Struct parseFrom(ByteBuffer byteBuffer) {
        return (Struct)PARSER.parseFrom(byteBuffer);
    }

    public static Struct parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Struct parseFrom(byte[] byArray) {
        return (Struct)PARSER.parseFrom(byArray);
    }

    public static Struct parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Struct)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean containsFields(String string2) {
        Objects.requireNonNull(string2);
        return this.internalGetFields().getMap().containsKey(string2);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof Struct;
        if (!bl3) {
            return super.equals(object);
        }
        object = (Struct)object;
        Object object2 = this.internalGetFields();
        MapField mapField = super.internalGetFields();
        bl3 = ((MapField)object2).equals(mapField);
        mapField = null;
        if (!bl3) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl4 = ((UnknownFieldSet)object2).equals(object);
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public Struct getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = 0;
        Iterator iterator2 = this.internalGetFields().getMap().entrySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object = iterator2.next();
            MapEntry$Builder mapEntry$Builder = Struct$FieldsDefaultEntryHolder.defaultEntry.newBuilderForType();
            Object k10 = object.getKey();
            mapEntry$Builder = mapEntry$Builder.setKey(k10);
            object = object.getValue();
            object = mapEntry$Builder.setValue(object).build();
            int n13 = 1;
            n10 = CodedOutputStream.computeMessageSize(n13, (MessageLite)object);
            n11 += n10;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = Struct.getDescriptor().hashCode();
        n10 = 779 + n11;
        Object object = this.internalGetFields().getMap();
        n11 = (int)(object.isEmpty() ? 1 : 0);
        if (n11 == 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.internalGetFields();
            n11 = ((MapField)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
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

    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Struct$Builder newBuilderForType() {
        return Struct.newBuilder();
    }

    public Struct$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Struct$Builder struct$Builder = new Struct$Builder(generatedMessageV3$BuilderParent, null);
        return struct$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Struct();
        return object;
    }

    public Struct$Builder toBuilder() {
        StructOrBuilder structOrBuilder = DEFAULT_INSTANCE;
        if (this == structOrBuilder) {
            structOrBuilder = new Struct$Builder(null);
        } else {
            structOrBuilder = new Struct$Builder(null);
            structOrBuilder = ((Struct$Builder)structOrBuilder).mergeFrom(this);
        }
        return structOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        MapField mapField = this.internalGetFields();
        MapEntry mapEntry = Struct$FieldsDefaultEntryHolder.defaultEntry;
        GeneratedMessageV3.serializeStringMapTo(codedOutputStream, mapField, mapEntry, 1);
        this.unknownFields.writeTo(codedOutputStream);
    }
}


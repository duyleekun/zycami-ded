/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.BinaryReader;
import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.ExtensionSchema;
import com.google.protobuf.ExtensionSchemaLite$1;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Protobuf;
import com.google.protobuf.Reader;
import com.google.protobuf.Schema;
import com.google.protobuf.SchemaUtil;
import com.google.protobuf.UnknownFieldSchema;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.Writer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ExtensionSchemaLite
extends ExtensionSchema {
    public int extensionNumber(Map.Entry entry) {
        return ((GeneratedMessageLite$ExtensionDescriptor)entry.getKey()).getNumber();
    }

    public Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int n10) {
        return extensionRegistryLite.findLiteExtensionByNumber(messageLite, n10);
    }

    public FieldSet getExtensions(Object object) {
        return ((GeneratedMessageLite$ExtendableMessage)object).extensions;
    }

    public FieldSet getMutableExtensions(Object object) {
        return ((GeneratedMessageLite$ExtendableMessage)object).ensureExtensionsAreMutable();
    }

    public boolean hasExtensions(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageLite$ExtendableMessage;
    }

    public void makeImmutable(Object object) {
        this.getExtensions(object).makeImmutable();
    }

    public Object parseExtension(Reader object, Object object2, ExtensionRegistryLite object3, FieldSet fieldSet, Object object4, UnknownFieldSchema clazz) {
        boolean bl2;
        object2 = (GeneratedMessageLite$GeneratedExtension)object2;
        int n10 = ((GeneratedMessageLite$GeneratedExtension)object2).getNumber();
        Object object5 = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor;
        boolean n11 = ((GeneratedMessageLite$ExtensionDescriptor)object5).isRepeated();
        if (n11 && (bl2 = ((GeneratedMessageLite$ExtensionDescriptor)(object5 = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor)).isPacked())) {
            object3 = ExtensionSchemaLite$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
            object5 = ((GeneratedMessageLite$GeneratedExtension)object2).getLiteType();
            int n12 = ((Enum)object5).ordinal();
            ArrayList arrayList = object3[n12];
            switch (arrayList) {
                default: {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Type cannot be packed: ");
                    object2 = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor.getLiteType();
                    ((StringBuilder)object3).append(object2);
                    object2 = ((StringBuilder)object3).toString();
                    object = new IllegalStateException((String)object2);
                    throw object;
                }
                case 14: {
                    object3 = new ArrayList();
                    object.readEnumList((List)object3);
                    object = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor.getEnumType();
                    object4 = SchemaUtil.filterUnknownEnumList(n10, (List)object3, (Internal$EnumLiteMap)object, object4, clazz);
                    break;
                }
                case 13: {
                    object3 = new ArrayList();
                    object.readSInt64List((List)object3);
                    break;
                }
                case 12: {
                    object3 = new ArrayList();
                    object.readSInt32List((List)object3);
                    break;
                }
                case 11: {
                    object3 = new ArrayList();
                    object.readSFixed64List((List)object3);
                    break;
                }
                case 10: {
                    object3 = new ArrayList();
                    object.readSFixed32List((List)object3);
                    break;
                }
                case 9: {
                    object3 = new ArrayList();
                    object.readUInt32List((List)object3);
                    break;
                }
                case 8: {
                    object3 = new ArrayList();
                    object.readBoolList((List)object3);
                    break;
                }
                case 7: {
                    object3 = new ArrayList();
                    object.readFixed32List((List)object3);
                    break;
                }
                case 6: {
                    object3 = new ArrayList();
                    object.readFixed64List((List)object3);
                    break;
                }
                case 5: {
                    object3 = new ArrayList();
                    object.readInt32List((List)object3);
                    break;
                }
                case 4: {
                    object3 = new ArrayList();
                    object.readUInt64List((List)object3);
                    break;
                }
                case 3: {
                    object3 = new ArrayList();
                    object.readInt64List((List)object3);
                    break;
                }
                case 2: {
                    object3 = new ArrayList();
                    object.readFloatList((List)object3);
                    break;
                }
                case 1: {
                    object3 = new ArrayList();
                    object.readDoubleList((List)object3);
                }
            }
            object = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor;
            fieldSet.setField((FieldSet$FieldDescriptorLite)object, object3);
        } else {
            Object object6;
            WireFormat$FieldType wireFormat$FieldType;
            boolean bl3 = false;
            object5 = null;
            WireFormat$FieldType wireFormat$FieldType2 = ((GeneratedMessageLite$GeneratedExtension)object2).getLiteType();
            if (wireFormat$FieldType2 == (wireFormat$FieldType = WireFormat$FieldType.ENUM)) {
                object6 = object.readInt32();
                object3 = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor.getEnumType().findValueByNumber((int)object6);
                if (object3 == null) {
                    return SchemaUtil.storeUnknownEnum(n10, object6, object4, (UnknownFieldSchema)((Object)clazz));
                }
                object5 = object6;
            } else {
                clazz = (Class<?>)ExtensionSchemaLite$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
                WireFormat$FieldType wireFormat$FieldType3 = ((GeneratedMessageLite$GeneratedExtension)object2).getLiteType();
                n10 = wireFormat$FieldType3.ordinal();
                Object object7 = clazz[n10];
                switch (object7) {
                    default: {
                        break;
                    }
                    case 18: {
                        clazz = ((GeneratedMessageLite$GeneratedExtension)object2).getMessageDefaultInstance().getClass();
                        object5 = object.readMessage(clazz, (ExtensionRegistryLite)object3);
                        break;
                    }
                    case 17: {
                        clazz = ((GeneratedMessageLite$GeneratedExtension)object2).getMessageDefaultInstance().getClass();
                        object5 = object.readGroup(clazz, (ExtensionRegistryLite)object3);
                        break;
                    }
                    case 16: {
                        object5 = object.readString();
                        break;
                    }
                    case 15: {
                        object5 = object.readBytes();
                        break;
                    }
                    case 14: {
                        object = new IllegalStateException("Shouldn't reach here.");
                        throw object;
                    }
                    case 13: {
                        long l13 = object.readSInt64();
                        object5 = l13;
                        break;
                    }
                    case 12: {
                        object6 = object.readSInt32();
                        object5 = object6;
                        break;
                    }
                    case 11: {
                        long l14 = object.readSFixed64();
                        object5 = l14;
                        break;
                    }
                    case 10: {
                        object6 = object.readSFixed32();
                        object5 = object6;
                        break;
                    }
                    case 9: {
                        object6 = object.readUInt32();
                        object5 = object6;
                        break;
                    }
                    case 8: {
                        object6 = object.readBool();
                        object5 = (boolean)object6;
                        break;
                    }
                    case 7: {
                        object6 = object.readFixed32();
                        object5 = object6;
                        break;
                    }
                    case 6: {
                        long l10 = object.readFixed64();
                        object5 = l10;
                        break;
                    }
                    case 5: {
                        object6 = object.readInt32();
                        object5 = object6;
                        break;
                    }
                    case 4: {
                        long l11 = object.readUInt64();
                        object5 = l11;
                        break;
                    }
                    case 3: {
                        long l12 = object.readInt64();
                        object5 = l12;
                        break;
                    }
                    case 2: {
                        float f10 = object.readFloat();
                        object5 = Float.valueOf(f10);
                        break;
                    }
                    case 1: {
                        double d10 = object.readDouble();
                        object5 = d10;
                    }
                }
            }
            object6 = ((GeneratedMessageLite$GeneratedExtension)object2).isRepeated();
            if (object6 != 0) {
                object = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor;
                fieldSet.addRepeatedField((FieldSet$FieldDescriptorLite)object, object5);
            } else {
                object = ExtensionSchemaLite$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
                object3 = ((GeneratedMessageLite$GeneratedExtension)object2).getLiteType();
                int n13 = ((Enum)object3).ordinal();
                object6 = object[n13];
                if (object6 == (n13 = 17) || object6 == (n13 = 18)) {
                    object = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor;
                    if ((object = fieldSet.getField((FieldSet$FieldDescriptorLite)object)) != null) {
                        object5 = Internal.mergeMessage(object, object5);
                    }
                }
                object = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor;
                fieldSet.setField((FieldSet$FieldDescriptorLite)object, object5);
            }
        }
        return object4;
    }

    public void parseLengthPrefixedMessageSetItem(Reader object, Object object2, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) {
        object2 = (GeneratedMessageLite$GeneratedExtension)object2;
        Class<?> clazz = ((GeneratedMessageLite$GeneratedExtension)object2).getMessageDefaultInstance().getClass();
        object = object.readMessage(clazz, extensionRegistryLite);
        object2 = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor;
        fieldSet.setField((FieldSet$FieldDescriptorLite)object2, object);
    }

    public void parseMessageSetItem(ByteString object, Object object2, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) {
        object2 = (GeneratedMessageLite$GeneratedExtension)object2;
        MessageLite messageLite = ((GeneratedMessageLite$GeneratedExtension)object2).getMessageDefaultInstance().newBuilderForType().buildPartial();
        object = ByteBuffer.wrap(((ByteString)object).toByteArray());
        boolean bl2 = true;
        object = BinaryReader.newInstance((ByteBuffer)object, bl2);
        Protobuf protobuf = Protobuf.getInstance();
        protobuf.mergeFrom(messageLite, (Reader)object, extensionRegistryLite);
        object2 = ((GeneratedMessageLite$GeneratedExtension)object2).descriptor;
        fieldSet.setField((FieldSet$FieldDescriptorLite)object2, messageLite);
        int n10 = object.getFieldNumber();
        int n11 = -1 >>> 1;
        if (n10 == n11) {
            return;
        }
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    public void serializeExtension(Writer writer, Map.Entry object) {
        block43: {
            int n10;
            GeneratedMessageLite$ExtensionDescriptor generatedMessageLite$ExtensionDescriptor;
            block42: {
                generatedMessageLite$ExtensionDescriptor = (GeneratedMessageLite$ExtensionDescriptor)object.getKey();
                n10 = generatedMessageLite$ExtensionDescriptor.isRepeated();
                if (n10 == 0) break block42;
                Object object2 = ExtensionSchemaLite$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
                int n11 = generatedMessageLite$ExtensionDescriptor.getLiteType().ordinal();
                n10 = object2[n11];
                n11 = 0;
                Object var7_9 = null;
                switch (n10) {
                    default: {
                        break;
                    }
                    case 18: {
                        boolean bl2;
                        object2 = (List)object.getValue();
                        if (object2 != null && !(bl2 = object2.isEmpty())) {
                            int n12 = generatedMessageLite$ExtensionDescriptor.getNumber();
                            object = (List)object.getValue();
                            Protobuf protobuf = Protobuf.getInstance();
                            object2 = object2.get(0).getClass();
                            object2 = protobuf.schemaFor((Class)object2);
                            SchemaUtil.writeMessageList(n12, (List)object, writer, (Schema)object2);
                            break;
                        }
                        break block43;
                    }
                    case 17: {
                        boolean bl3;
                        object2 = (List)object.getValue();
                        if (object2 != null && !(bl3 = object2.isEmpty())) {
                            int n13 = generatedMessageLite$ExtensionDescriptor.getNumber();
                            object = (List)object.getValue();
                            Protobuf protobuf = Protobuf.getInstance();
                            object2 = object2.get(0).getClass();
                            object2 = protobuf.schemaFor((Class)object2);
                            SchemaUtil.writeGroupList(n13, (List)object, writer, (Schema)object2);
                            break;
                        }
                        break block43;
                    }
                    case 16: {
                        int n14 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        SchemaUtil.writeStringList(n14, object, writer);
                        break;
                    }
                    case 15: {
                        int n15 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        SchemaUtil.writeBytesList(n15, object, writer);
                        break;
                    }
                    case 14: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl4 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeInt32List(n10, object, writer, bl4);
                        break;
                    }
                    case 13: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl5 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeSInt64List(n10, object, writer, bl5);
                        break;
                    }
                    case 12: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl6 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeSInt32List(n10, object, writer, bl6);
                        break;
                    }
                    case 11: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl7 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeSFixed64List(n10, object, writer, bl7);
                        break;
                    }
                    case 10: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl8 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeSFixed32List(n10, object, writer, bl8);
                        break;
                    }
                    case 9: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl9 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeUInt32List(n10, object, writer, bl9);
                        break;
                    }
                    case 8: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl10 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeBoolList(n10, object, writer, bl10);
                        break;
                    }
                    case 7: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl11 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeFixed32List(n10, object, writer, bl11);
                        break;
                    }
                    case 6: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl12 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeFixed64List(n10, object, writer, bl12);
                        break;
                    }
                    case 5: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl13 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeInt32List(n10, object, writer, bl13);
                        break;
                    }
                    case 4: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl14 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeUInt64List(n10, object, writer, bl14);
                        break;
                    }
                    case 3: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl15 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeInt64List(n10, object, writer, bl15);
                        break;
                    }
                    case 2: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl16 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeFloatList(n10, object, writer, bl16);
                        break;
                    }
                    case 1: {
                        n10 = generatedMessageLite$ExtensionDescriptor.getNumber();
                        object = (List)object.getValue();
                        boolean bl17 = generatedMessageLite$ExtensionDescriptor.isPacked();
                        SchemaUtil.writeDoubleList(n10, object, writer, bl17);
                        break;
                    }
                }
                break block43;
            }
            Object object3 = ExtensionSchemaLite$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
            Object object4 = generatedMessageLite$ExtensionDescriptor.getLiteType();
            int n16 = ((Enum)object4).ordinal();
            n10 = object3[n16];
            switch (n10) {
                default: {
                    break;
                }
                case 18: {
                    int n17 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object3 = object.getValue();
                    object4 = Protobuf.getInstance();
                    object = object.getValue().getClass();
                    object = ((Protobuf)object4).schemaFor((Class)object);
                    writer.writeMessage(n17, object3, (Schema)object);
                    break;
                }
                case 17: {
                    int n18 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object3 = object.getValue();
                    object4 = Protobuf.getInstance();
                    object = object.getValue().getClass();
                    object = ((Protobuf)object4).schemaFor((Class)object);
                    writer.writeGroup(n18, object3, (Schema)object);
                    break;
                }
                case 16: {
                    int n19 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (String)object.getValue();
                    writer.writeString(n19, (String)object);
                    break;
                }
                case 15: {
                    int n20 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (ByteString)object.getValue();
                    writer.writeBytes(n20, (ByteString)object);
                    break;
                }
                case 14: {
                    int n21 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Integer)object.getValue();
                    int n22 = (Integer)object;
                    writer.writeInt32(n21, n22);
                    break;
                }
                case 13: {
                    int n23 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Long)object.getValue();
                    long l10 = (Long)object;
                    writer.writeSInt64(n23, l10);
                    break;
                }
                case 12: {
                    int n24 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Integer)object.getValue();
                    int n25 = (Integer)object;
                    writer.writeSInt32(n24, n25);
                    break;
                }
                case 11: {
                    int n26 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Long)object.getValue();
                    long l11 = (Long)object;
                    writer.writeSFixed64(n26, l11);
                    break;
                }
                case 10: {
                    int n27 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Integer)object.getValue();
                    int n28 = (Integer)object;
                    writer.writeSFixed32(n27, n28);
                    break;
                }
                case 9: {
                    int n29 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Integer)object.getValue();
                    int n30 = (Integer)object;
                    writer.writeUInt32(n29, n30);
                    break;
                }
                case 8: {
                    int n31 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Boolean)object.getValue();
                    boolean bl18 = (Boolean)object;
                    writer.writeBool(n31, bl18);
                    break;
                }
                case 7: {
                    int n32 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Integer)object.getValue();
                    int n33 = (Integer)object;
                    writer.writeFixed32(n32, n33);
                    break;
                }
                case 6: {
                    int n34 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Long)object.getValue();
                    long l12 = (Long)object;
                    writer.writeFixed64(n34, l12);
                    break;
                }
                case 5: {
                    int n35 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Integer)object.getValue();
                    int n36 = (Integer)object;
                    writer.writeInt32(n35, n36);
                    break;
                }
                case 4: {
                    int n37 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Long)object.getValue();
                    long l13 = (Long)object;
                    writer.writeUInt64(n37, l13);
                    break;
                }
                case 3: {
                    int n38 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Long)object.getValue();
                    long l14 = (Long)object;
                    writer.writeInt64(n38, l14);
                    break;
                }
                case 2: {
                    int n39 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Float)object.getValue();
                    float f10 = ((Float)object).floatValue();
                    writer.writeFloat(n39, f10);
                    break;
                }
                case 1: {
                    int n40 = generatedMessageLite$ExtensionDescriptor.getNumber();
                    object = (Double)object.getValue();
                    double d10 = (Double)object;
                    writer.writeDouble(n40, d10);
                }
            }
        }
    }

    public void setExtensions(Object object, FieldSet fieldSet) {
        ((GeneratedMessageLite$ExtendableMessage)object).extensions = fieldSet;
    }
}


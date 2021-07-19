/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.BinaryReader;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.ExtensionSchema;
import com.google.protobuf.ExtensionSchemaFull$1;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageV3$ExtendableMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Protobuf;
import com.google.protobuf.Reader;
import com.google.protobuf.SchemaUtil;
import com.google.protobuf.UnknownFieldSchema;
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.Writer;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ExtensionSchemaFull
extends ExtensionSchema {
    private static final long EXTENSION_FIELD_OFFSET = ExtensionSchemaFull.getExtensionsFieldOffset();

    private static long getExtensionsFieldOffset() {
        Object object = GeneratedMessageV3$ExtendableMessage.class;
        String string2 = "extensions";
        try {
            object = ((Class)object).getDeclaredField(string2);
        }
        catch (Throwable throwable) {
            object = new IllegalStateException("Unable to lookup extension field offset");
            throw object;
        }
        return UnsafeUtil.objectFieldOffset((Field)object);
    }

    public int extensionNumber(Map.Entry entry) {
        return ((Descriptors$FieldDescriptor)entry.getKey()).getNumber();
    }

    public Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite object, int n10) {
        extensionRegistryLite = (ExtensionRegistry)extensionRegistryLite;
        object = ((Message)object).getDescriptorForType();
        return ((ExtensionRegistry)extensionRegistryLite).findExtensionByNumber((Descriptors$Descriptor)object, n10);
    }

    public FieldSet getExtensions(Object object) {
        long l10 = EXTENSION_FIELD_OFFSET;
        return (FieldSet)UnsafeUtil.getObject(object, l10);
    }

    public FieldSet getMutableExtensions(Object object) {
        FieldSet fieldSet = this.getExtensions(object);
        boolean bl2 = fieldSet.isImmutable();
        if (bl2) {
            fieldSet = fieldSet.clone();
            this.setExtensions(object, fieldSet);
        }
        return fieldSet;
    }

    public boolean hasExtensions(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageV3$ExtendableMessage;
    }

    public void makeImmutable(Object object) {
        this.getExtensions(object).makeImmutable();
    }

    public Object parseExtension(Reader object, Object object2, ExtensionRegistryLite object3, FieldSet fieldSet, Object object4, UnknownFieldSchema clazz) {
        block47: {
            Object object5;
            WireFormat$FieldType wireFormat$FieldType;
            Object object6;
            int n11;
            Object object7;
            block45: {
                block46: {
                    boolean bl2;
                    object2 = (ExtensionRegistry$ExtensionInfo)object2;
                    object7 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
                    n11 = ((Descriptors$FieldDescriptor)object7).getNumber();
                    object6 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
                    boolean n10 = ((Descriptors$FieldDescriptor)object6).isRepeated();
                    if (!n10 || !(bl2 = ((Descriptors$FieldDescriptor)(object6 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor)).isPacked())) break block45;
                    object3 = ExtensionSchemaFull$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
                    object6 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor.getLiteType();
                    int n12 = ((Enum)object6).ordinal();
                    Object object8 = object3[n12];
                    switch (object8) {
                        default: {
                            object3 = new StringBuilder();
                            ((StringBuilder)object3).append("Type cannot be packed: ");
                            object2 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor.getLiteType();
                            ((StringBuilder)object3).append(object2);
                            object2 = ((StringBuilder)object3).toString();
                            object = new IllegalStateException((String)object2);
                            throw object;
                        }
                        case 14: {
                            int n13;
                            object3 = new ArrayList();
                            object.readEnumList((List)object3);
                            object = new ArrayList();
                            object3 = object3.iterator();
                            while ((n13 = object3.hasNext()) != 0) {
                                object6 = (Integer)object3.next();
                                n13 = (Integer)object6;
                                Descriptors$EnumValueDescriptor descriptors$EnumValueDescriptor = ((ExtensionRegistry$ExtensionInfo)object2).descriptor.getEnumType().findValueByNumber(n13);
                                if (descriptors$EnumValueDescriptor != null) {
                                    object.add(descriptors$EnumValueDescriptor);
                                    continue;
                                }
                                object4 = SchemaUtil.storeUnknownEnum(n11, n13, object4, clazz);
                            }
                            break block46;
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
                    object = object3;
                }
                object2 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
                fieldSet.setField((FieldSet$FieldDescriptorLite)object2, object);
                break block47;
            }
            boolean bl3 = false;
            object6 = null;
            WireFormat$FieldType wireFormat$FieldType2 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor.getLiteType();
            if (wireFormat$FieldType2 == (wireFormat$FieldType = WireFormat$FieldType.ENUM)) {
                object5 = object.readInt32();
                object3 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor.getEnumType();
                object6 = ((Descriptors$EnumDescriptor)object3).findValueByNumber((int)object5);
                if (object6 == null) {
                    return SchemaUtil.storeUnknownEnum(n11, object5, object4, (UnknownFieldSchema)((Object)clazz));
                }
            } else {
                clazz = (Class<?>)ExtensionSchemaFull$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
                object7 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor.getLiteType();
                n11 = ((Enum)object7).ordinal();
                Object object9 = clazz[n11];
                switch (object9) {
                    default: {
                        break;
                    }
                    case 18: {
                        clazz = ((ExtensionRegistry$ExtensionInfo)object2).defaultInstance.getClass();
                        object6 = object.readMessage(clazz, (ExtensionRegistryLite)object3);
                        break;
                    }
                    case 17: {
                        clazz = ((ExtensionRegistry$ExtensionInfo)object2).defaultInstance.getClass();
                        object6 = object.readGroup(clazz, (ExtensionRegistryLite)object3);
                        break;
                    }
                    case 16: {
                        object6 = object.readString();
                        break;
                    }
                    case 15: {
                        object6 = object.readBytes();
                        break;
                    }
                    case 14: {
                        object = new IllegalStateException("Shouldn't reach here.");
                        throw object;
                    }
                    case 13: {
                        long l14 = object.readSInt64();
                        object6 = l14;
                        break;
                    }
                    case 12: {
                        object5 = object.readSInt32();
                        object6 = object5;
                        break;
                    }
                    case 11: {
                        long l10 = object.readSFixed64();
                        object6 = l10;
                        break;
                    }
                    case 10: {
                        object5 = object.readSFixed32();
                        object6 = object5;
                        break;
                    }
                    case 9: {
                        object5 = object.readUInt32();
                        object6 = object5;
                        break;
                    }
                    case 8: {
                        object5 = object.readBool();
                        object6 = (boolean)object5;
                        break;
                    }
                    case 7: {
                        object5 = object.readFixed32();
                        object6 = object5;
                        break;
                    }
                    case 6: {
                        long l11 = object.readFixed64();
                        object6 = l11;
                        break;
                    }
                    case 5: {
                        object5 = object.readInt32();
                        object6 = object5;
                        break;
                    }
                    case 4: {
                        long l12 = object.readUInt64();
                        object6 = l12;
                        break;
                    }
                    case 3: {
                        long l13 = object.readInt64();
                        object6 = l13;
                        break;
                    }
                    case 2: {
                        float f10 = object.readFloat();
                        object6 = Float.valueOf(f10);
                        break;
                    }
                    case 1: {
                        double d10 = object.readDouble();
                        object6 = d10;
                    }
                }
            }
            if ((object5 = (Object)((Descriptors$FieldDescriptor)(object = ((ExtensionRegistry$ExtensionInfo)object2).descriptor)).isRepeated()) != 0) {
                object = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
                fieldSet.addRepeatedField((FieldSet$FieldDescriptorLite)object, object6);
            } else {
                object = ExtensionSchemaFull$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
                object3 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor.getLiteType();
                int n14 = ((Enum)object3).ordinal();
                object5 = object[n14];
                if (object5 == (n14 = 17) || object5 == (n14 = 18)) {
                    object = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
                    if ((object = fieldSet.getField((FieldSet$FieldDescriptorLite)object)) != null) {
                        object6 = Internal.mergeMessage(object, object6);
                    }
                }
                object = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
                fieldSet.setField((FieldSet$FieldDescriptorLite)object, object6);
            }
        }
        return object4;
    }

    public void parseLengthPrefixedMessageSetItem(Reader object, Object object2, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) {
        object2 = (ExtensionRegistry$ExtensionInfo)object2;
        boolean bl2 = ExtensionRegistryLite.isEagerlyParseMessageSets();
        if (bl2) {
            Class<?> clazz = ((ExtensionRegistry$ExtensionInfo)object2).defaultInstance.getClass();
            object = object.readMessage(clazz, extensionRegistryLite);
            object2 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
            fieldSet.setField((FieldSet$FieldDescriptorLite)object2, object);
        } else {
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
            object2 = ((ExtensionRegistry$ExtensionInfo)object2).defaultInstance;
            object = object.readBytes();
            LazyField lazyField = new LazyField((MessageLite)object2, extensionRegistryLite, (ByteString)object);
            fieldSet.setField(descriptors$FieldDescriptor, lazyField);
        }
    }

    public void parseMessageSetItem(ByteString object, Object object2, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) {
        object2 = (ExtensionRegistry$ExtensionInfo)object2;
        Object object3 = ((ExtensionRegistry$ExtensionInfo)object2).defaultInstance.newBuilderForType().buildPartial();
        boolean bl2 = ExtensionRegistryLite.isEagerlyParseMessageSets();
        if (bl2) {
            object = ByteBuffer.wrap(((ByteString)object).toByteArray());
            bl2 = true;
            object = BinaryReader.newInstance((ByteBuffer)object, bl2);
            Protobuf protobuf = Protobuf.getInstance();
            protobuf.mergeFrom(object3, (Reader)object, extensionRegistryLite);
            object2 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
            fieldSet.setField((FieldSet$FieldDescriptorLite)object2, object3);
            int n10 = object.getFieldNumber();
            int n11 = -1 >>> 1;
            if (n10 != n11) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        } else {
            object3 = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
            object2 = ((ExtensionRegistry$ExtensionInfo)object2).defaultInstance;
            LazyField lazyField = new LazyField((MessageLite)object2, extensionRegistryLite, (ByteString)object);
            fieldSet.setField((FieldSet$FieldDescriptorLite)object3, lazyField);
        }
    }

    public void serializeExtension(Writer writer, Map.Entry iterator2) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)iterator2.getKey();
        int n10 = descriptors$FieldDescriptor.isRepeated();
        if (n10 != 0) {
            Object object = ExtensionSchemaFull$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
            Object object2 = descriptors$FieldDescriptor.getLiteType();
            int n11 = object2.ordinal();
            n10 = object[n11];
            switch (n10) {
                default: {
                    break;
                }
                case 18: {
                    int n12 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    SchemaUtil.writeMessageList(n12, (List)((Object)iterator2), writer);
                    break;
                }
                case 17: {
                    int n13 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    SchemaUtil.writeGroupList(n13, (List)((Object)iterator2), writer);
                    break;
                }
                case 16: {
                    int n14 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    SchemaUtil.writeStringList(n14, (List)((Object)iterator2), writer);
                    break;
                }
                case 15: {
                    int n15 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    SchemaUtil.writeBytesList(n15, (List)((Object)iterator2), writer);
                    break;
                }
                case 14: {
                    iterator2 = (List)iterator2.getValue();
                    object = new ArrayList;
                    ((ArrayList)object)();
                    iterator2 = iterator2.iterator();
                    while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                        n11 = ((Descriptors$EnumValueDescriptor)iterator2.next()).getNumber();
                        object2 = n11;
                        object.add(object2);
                    }
                    int n16 = descriptors$FieldDescriptor.getNumber();
                    boolean bl2 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeInt32List(n16, (List)object, writer, bl2);
                    break;
                }
                case 13: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl3 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeSInt64List(n10, iterator2, writer, bl3);
                    break;
                }
                case 12: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl4 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeSInt32List(n10, iterator2, writer, bl4);
                    break;
                }
                case 11: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl5 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeSFixed64List(n10, iterator2, writer, bl5);
                    break;
                }
                case 10: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl6 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeSFixed32List(n10, iterator2, writer, bl6);
                    break;
                }
                case 9: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl7 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeUInt32List(n10, iterator2, writer, bl7);
                    break;
                }
                case 8: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl8 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeBoolList(n10, iterator2, writer, bl8);
                    break;
                }
                case 7: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl9 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeFixed32List(n10, iterator2, writer, bl9);
                    break;
                }
                case 6: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl10 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeFixed64List(n10, iterator2, writer, bl10);
                    break;
                }
                case 5: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl11 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeInt32List(n10, iterator2, writer, bl11);
                    break;
                }
                case 4: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl12 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeUInt64List(n10, iterator2, writer, bl12);
                    break;
                }
                case 3: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl13 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeInt64List(n10, iterator2, writer, bl13);
                    break;
                }
                case 2: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl14 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeFloatList(n10, iterator2, writer, bl14);
                    break;
                }
                case 1: {
                    n10 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (List)iterator2.getValue();
                    boolean bl15 = descriptors$FieldDescriptor.isPacked();
                    SchemaUtil.writeDoubleList(n10, iterator2, writer, bl15);
                    break;
                }
            }
        } else {
            int[] nArray = ExtensionSchemaFull$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
            WireFormat$FieldType wireFormat$FieldType = descriptors$FieldDescriptor.getLiteType();
            int n17 = wireFormat$FieldType.ordinal();
            n10 = nArray[n17];
            switch (n10) {
                default: {
                    break;
                }
                case 18: {
                    int n18 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = iterator2.getValue();
                    writer.writeMessage(n18, iterator2);
                    break;
                }
                case 17: {
                    int n19 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = iterator2.getValue();
                    writer.writeGroup(n19, iterator2);
                    break;
                }
                case 16: {
                    int n20 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (String)iterator2.getValue();
                    writer.writeString(n20, (String)((Object)iterator2));
                    break;
                }
                case 15: {
                    int n21 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (ByteString)iterator2.getValue();
                    writer.writeBytes(n21, (ByteString)((Object)iterator2));
                    break;
                }
                case 14: {
                    int n22 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Descriptors$EnumValueDescriptor)iterator2.getValue();
                    int n23 = ((Descriptors$EnumValueDescriptor)((Object)iterator2)).getNumber();
                    writer.writeInt32(n22, n23);
                    break;
                }
                case 13: {
                    int n24 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Long)iterator2.getValue();
                    long l10 = (Long)((Object)iterator2);
                    writer.writeSInt64(n24, l10);
                    break;
                }
                case 12: {
                    int n25 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Integer)iterator2.getValue();
                    int n26 = (Integer)((Object)iterator2);
                    writer.writeSInt32(n25, n26);
                    break;
                }
                case 11: {
                    int n27 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Long)iterator2.getValue();
                    long l11 = (Long)((Object)iterator2);
                    writer.writeSFixed64(n27, l11);
                    break;
                }
                case 10: {
                    int n28 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Integer)iterator2.getValue();
                    int n29 = (Integer)((Object)iterator2);
                    writer.writeSFixed32(n28, n29);
                    break;
                }
                case 9: {
                    int n30 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Integer)iterator2.getValue();
                    int n31 = (Integer)((Object)iterator2);
                    writer.writeUInt32(n30, n31);
                    break;
                }
                case 8: {
                    int n32 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Boolean)iterator2.getValue();
                    boolean bl16 = (Boolean)((Object)iterator2);
                    writer.writeBool(n32, bl16);
                    break;
                }
                case 7: {
                    int n33 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Integer)iterator2.getValue();
                    int n34 = (Integer)((Object)iterator2);
                    writer.writeFixed32(n33, n34);
                    break;
                }
                case 6: {
                    int n35 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Long)iterator2.getValue();
                    long l12 = (Long)((Object)iterator2);
                    writer.writeFixed64(n35, l12);
                    break;
                }
                case 5: {
                    int n36 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Integer)iterator2.getValue();
                    int n37 = (Integer)((Object)iterator2);
                    writer.writeInt32(n36, n37);
                    break;
                }
                case 4: {
                    int n38 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Long)iterator2.getValue();
                    long l13 = (Long)((Object)iterator2);
                    writer.writeUInt64(n38, l13);
                    break;
                }
                case 3: {
                    int n39 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Long)iterator2.getValue();
                    long l14 = (Long)((Object)iterator2);
                    writer.writeInt64(n39, l14);
                    break;
                }
                case 2: {
                    int n40 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Float)iterator2.getValue();
                    float f10 = ((Float)((Object)iterator2)).floatValue();
                    writer.writeFloat(n40, f10);
                    break;
                }
                case 1: {
                    int n41 = descriptors$FieldDescriptor.getNumber();
                    iterator2 = (Double)iterator2.getValue();
                    double d10 = (Double)((Object)iterator2);
                    writer.writeDouble(n41, d10);
                }
            }
        }
    }

    public void setExtensions(Object object, FieldSet fieldSet) {
        long l10 = EXTENSION_FIELD_OFFSET;
        UnsafeUtil.putObject(object, l10, (Object)fieldSet);
    }
}


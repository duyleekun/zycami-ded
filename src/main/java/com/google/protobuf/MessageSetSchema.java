/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ArrayDecoders$Registers;
import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.ExtensionSchema;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyField$LazyEntry;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Protobuf;
import com.google.protobuf.Reader;
import com.google.protobuf.Schema;
import com.google.protobuf.SchemaUtil;
import com.google.protobuf.UnknownFieldSchema;
import com.google.protobuf.UnknownFieldSetLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$JavaType;
import com.google.protobuf.Writer;
import java.util.Map;

public final class MessageSetSchema
implements Schema {
    private final MessageLite defaultInstance;
    private final ExtensionSchema extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MessageLite messageLite) {
        boolean bl2;
        this.unknownFieldSchema = unknownFieldSchema;
        this.hasExtensions = bl2 = extensionSchema.hasExtensions(messageLite);
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
    }

    private int getUnknownFieldsSerializedSize(UnknownFieldSchema unknownFieldSchema, Object object) {
        object = unknownFieldSchema.getFromMessage(object);
        return unknownFieldSchema.getSerializedSizeAsMessageSet(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void mergeFromHelper(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, Object object, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        Object object2 = unknownFieldSchema.getBuilderFromMessage(object);
        FieldSet fieldSet = extensionSchema.getMutableExtensions(object);
        try {
            int n10;
            do {
                int n11;
                if ((n10 = reader.getFieldNumber()) != (n11 = -1 >>> 1)) continue;
                unknownFieldSchema.setBuilderToMessage(object, object2);
                return;
            } while ((n10 = (int)(this.parseMessageSetItemOrUnknownField(reader, extensionRegistryLite, extensionSchema, fieldSet, unknownFieldSchema, object2) ? 1 : 0)) != 0);
            unknownFieldSchema.setBuilderToMessage(object, object2);
            return;
        }
        catch (Throwable throwable) {
            unknownFieldSchema.setBuilderToMessage(object, object2);
            throw throwable;
        }
    }

    public static MessageSetSchema newSchema(UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MessageLite messageLite) {
        MessageSetSchema messageSetSchema = new MessageSetSchema(unknownFieldSchema, extensionSchema, messageLite);
        return messageSetSchema;
    }

    private boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema extensionSchema, FieldSet fieldSet, UnknownFieldSchema unknownFieldSchema, Object object) {
        int n10;
        int n11;
        int n12;
        int n13 = reader.getTag();
        int n14 = WireFormat.MESSAGE_SET_ITEM_TAG;
        boolean bl2 = true;
        if (n13 != n14) {
            int n15;
            n14 = WireFormat.getTagWireType(n13);
            if (n14 == (n15 = 2)) {
                MessageLite messageLite = this.defaultInstance;
                Object object2 = extensionSchema.findExtensionByNumber(extensionRegistryLite, messageLite, n13 = WireFormat.getTagFieldNumber(n13));
                if (object2 != null) {
                    extensionSchema.parseLengthPrefixedMessageSetItem(reader, object2, extensionRegistryLite, fieldSet);
                    return bl2;
                }
                return unknownFieldSchema.mergeOneFieldFrom(object, reader);
            }
            return reader.skipField();
        }
        n13 = 0;
        Object var12_15 = null;
        n14 = 0;
        Object object3 = null;
        boolean bl3 = false;
        ByteString byteString = null;
        while ((n12 = reader.getFieldNumber()) != (n11 = -1 >>> 1)) {
            n12 = reader.getTag();
            if (n12 == (n11 = WireFormat.MESSAGE_SET_TYPE_ID_TAG)) {
                n13 = reader.readUInt32();
                object3 = this.defaultInstance;
                object3 = extensionSchema.findExtensionByNumber(extensionRegistryLite, (MessageLite)object3, n13);
                continue;
            }
            n11 = WireFormat.MESSAGE_SET_MESSAGE_TAG;
            if (n12 == n11) {
                if (object3 != null) {
                    extensionSchema.parseLengthPrefixedMessageSetItem(reader, object3, extensionRegistryLite, fieldSet);
                    continue;
                }
                byteString = reader.readBytes();
                continue;
            }
            n12 = (int)(reader.skipField() ? 1 : 0);
            if (n12 != 0) continue;
        }
        if ((n10 = reader.getTag()) == (n12 = WireFormat.MESSAGE_SET_ITEM_END_TAG)) {
            if (byteString != null) {
                if (object3 != null) {
                    extensionSchema.parseMessageSetItem(byteString, object3, extensionRegistryLite, fieldSet);
                } else {
                    unknownFieldSchema.addLengthDelimited(object, n13, byteString);
                }
            }
            return bl2;
        }
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    private void writeUnknownFieldsHelper(UnknownFieldSchema unknownFieldSchema, Object object, Writer writer) {
        object = unknownFieldSchema.getFromMessage(object);
        unknownFieldSchema.writeAsMessageSetTo(object, writer);
    }

    public boolean equals(Object object, Object object2) {
        Object object3;
        Object object4 = this.unknownFieldSchema.getFromMessage(object);
        boolean bl2 = object4.equals(object3 = this.unknownFieldSchema.getFromMessage(object2));
        if (!bl2) {
            return false;
        }
        bl2 = this.hasExtensions;
        if (bl2) {
            object = this.extensionSchema.getExtensions(object);
            object2 = this.extensionSchema.getExtensions(object2);
            return ((FieldSet)object).equals(object2);
        }
        return true;
    }

    public int getSerializedSize(Object object) {
        UnknownFieldSchema unknownFieldSchema = this.unknownFieldSchema;
        int n10 = this.getUnknownFieldsSerializedSize(unknownFieldSchema, object) + 0;
        boolean bl2 = this.hasExtensions;
        if (bl2) {
            ExtensionSchema extensionSchema = this.extensionSchema;
            object = extensionSchema.getExtensions(object);
            int n11 = ((FieldSet)object).getMessageSetSerializedSize();
            n10 += n11;
        }
        return n10;
    }

    public int hashCode(Object object) {
        Object object2 = this.unknownFieldSchema.getFromMessage(object);
        int n10 = object2.hashCode();
        boolean bl2 = this.hasExtensions;
        if (bl2) {
            ExtensionSchema extensionSchema = this.extensionSchema;
            object = extensionSchema.getExtensions(object);
            n10 *= 53;
            int n11 = ((FieldSet)object).hashCode();
            n10 += n11;
        }
        return n10;
    }

    public final boolean isInitialized(Object object) {
        return this.extensionSchema.getExtensions(object).isInitialized();
    }

    public void makeImmutable(Object object) {
        this.unknownFieldSchema.makeImmutable(object);
        this.extensionSchema.makeImmutable(object);
    }

    public void mergeFrom(Object object, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        UnknownFieldSchema unknownFieldSchema = this.unknownFieldSchema;
        ExtensionSchema extensionSchema = this.extensionSchema;
        this.mergeFromHelper(unknownFieldSchema, extensionSchema, object, reader, extensionRegistryLite);
    }

    public void mergeFrom(Object object, Object object2) {
        Object object3 = this.unknownFieldSchema;
        SchemaUtil.mergeUnknownFields((UnknownFieldSchema)object3, object, object2);
        boolean bl2 = this.hasExtensions;
        if (bl2) {
            object3 = this.extensionSchema;
            SchemaUtil.mergeExtensions((ExtensionSchema)object3, object, object2);
        }
    }

    public void mergeFrom(Object object, byte[] byArray, int n10, int n11, ArrayDecoders$Registers arrayDecoders$Registers) {
        Object object2 = object;
        object2 = (GeneratedMessageLite)object;
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite)object2).unknownFields;
        Object object3 = UnknownFieldSetLite.getDefaultInstance();
        if (unknownFieldSetLite == object3) {
            ((GeneratedMessageLite)object2).unknownFields = unknownFieldSetLite = UnknownFieldSetLite.newInstance();
        }
        object = ((GeneratedMessageLite$ExtendableMessage)object).ensureExtensionsAreMutable();
        object2 = null;
        object3 = null;
        while (n10 < n11) {
            Object object4;
            Object object5;
            Object object6;
            int n12;
            Object object7;
            int n13 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
            n10 = arrayDecoders$Registers.int1;
            int n14 = WireFormat.MESSAGE_SET_ITEM_TAG;
            int n15 = 2;
            if (n10 != n14) {
                n14 = WireFormat.getTagWireType(n10);
                if (n14 == n15) {
                    object3 = this.extensionSchema;
                    object7 = arrayDecoders$Registers.extensionRegistry;
                    MessageLite messageLite = this.defaultInstance;
                    n12 = WireFormat.getTagFieldNumber(n10);
                    object3 = ((ExtensionSchema)object3).findExtensionByNumber((ExtensionRegistryLite)object7, messageLite, n12);
                    Object object8 = object3;
                    object8 = (GeneratedMessageLite$GeneratedExtension)object3;
                    if (object8 != null) {
                        object6 = Protobuf.getInstance();
                        object3 = ((GeneratedMessageLite$GeneratedExtension)object8).getMessageDefaultInstance().getClass();
                        object6 = ((Protobuf)object6).schemaFor((Class)object3);
                        n10 = ArrayDecoders.decodeMessageField((Schema)object6, byArray, n13, n11, arrayDecoders$Registers);
                        object3 = ((GeneratedMessageLite$GeneratedExtension)object8).descriptor;
                        object7 = arrayDecoders$Registers.object1;
                        ((FieldSet)object).setField((FieldSet$FieldDescriptorLite)object3, object7);
                    } else {
                        object7 = byArray;
                        n15 = n11;
                        object5 = unknownFieldSetLite;
                        object4 = arrayDecoders$Registers;
                        n10 = ArrayDecoders.decodeUnknownField(n10, byArray, n13, n11, unknownFieldSetLite, arrayDecoders$Registers);
                    }
                    object3 = object8;
                    continue;
                }
                n10 = ArrayDecoders.skipField(n10, byArray, n13, n11, arrayDecoders$Registers);
                continue;
            }
            n10 = 0;
            object6 = null;
            n14 = 0;
            object7 = null;
            while (n13 < n11) {
                n13 = ArrayDecoders.decodeVarint32(byArray, n13, arrayDecoders$Registers);
                n12 = arrayDecoders$Registers.int1;
                int n16 = WireFormat.getTagFieldNumber(n12);
                int n17 = WireFormat.getTagWireType(n12);
                if (n16 != n15) {
                    int n18 = 3;
                    if (n16 == n18) {
                        if (object3 != null) {
                            object5 = Protobuf.getInstance();
                            object4 = ((GeneratedMessageLite$GeneratedExtension)object3).getMessageDefaultInstance().getClass();
                            n13 = ArrayDecoders.decodeMessageField(((Protobuf)object5).schemaFor((Class)object4), byArray, n13, n11, arrayDecoders$Registers);
                            object5 = ((GeneratedMessageLite$GeneratedExtension)object3).descriptor;
                            object4 = arrayDecoders$Registers.object1;
                            ((FieldSet)object).setField((FieldSet$FieldDescriptorLite)object5, object4);
                            continue;
                        }
                        if (n17 == n15) {
                            n13 = ArrayDecoders.decodeBytes(byArray, n13, arrayDecoders$Registers);
                            object7 = (ByteString)arrayDecoders$Registers.object1;
                            continue;
                        }
                    }
                } else if (n17 == 0) {
                    n13 = ArrayDecoders.decodeVarint32(byArray, n13, arrayDecoders$Registers);
                    n10 = arrayDecoders$Registers.int1;
                    object3 = this.extensionSchema;
                    object5 = arrayDecoders$Registers.extensionRegistry;
                    object4 = this.defaultInstance;
                    object3 = (GeneratedMessageLite$GeneratedExtension)((ExtensionSchema)object3).findExtensionByNumber((ExtensionRegistryLite)object5, (MessageLite)object4, n10);
                    continue;
                }
                if (n12 == (n16 = WireFormat.MESSAGE_SET_ITEM_END_TAG)) break;
                n13 = ArrayDecoders.skipField(n12, byArray, n13, n11, arrayDecoders$Registers);
            }
            if (object7 != null) {
                n10 = WireFormat.makeTag(n10, n15);
                unknownFieldSetLite.storeField(n10, object7);
            }
            n10 = n13;
        }
        if (n10 == n11) {
            return;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    public Object newInstance() {
        return this.defaultInstance.newBuilderForType().buildPartial();
    }

    public void writeTo(Object object, Writer writer) {
        boolean bl2;
        Object object2 = this.extensionSchema.getExtensions(object).iterator();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            WireFormat$JavaType wireFormat$JavaType;
            Object object3 = (Map.Entry)object2.next();
            FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite)object3.getKey();
            WireFormat$JavaType wireFormat$JavaType2 = fieldSet$FieldDescriptorLite.getLiteJavaType();
            if (wireFormat$JavaType2 == (wireFormat$JavaType = WireFormat$JavaType.MESSAGE) && !(bl3 = fieldSet$FieldDescriptorLite.isRepeated()) && !(bl3 = fieldSet$FieldDescriptorLite.isPacked())) {
                int n10;
                bl3 = object3 instanceof LazyField$LazyEntry;
                if (bl3) {
                    n10 = fieldSet$FieldDescriptorLite.getNumber();
                    object3 = ((LazyField$LazyEntry)object3).getField().toByteString();
                    writer.writeMessageSetItem(n10, object3);
                    continue;
                }
                n10 = fieldSet$FieldDescriptorLite.getNumber();
                object3 = object3.getValue();
                writer.writeMessageSetItem(n10, object3);
                continue;
            }
            object = new IllegalStateException("Found invalid MessageSet item.");
            throw object;
        }
        object2 = this.unknownFieldSchema;
        this.writeUnknownFieldsHelper((UnknownFieldSchema)object2, object, writer);
    }
}


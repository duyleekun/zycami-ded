/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.LazyField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.MessageReflection$1;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.MessageReflection$MergeTarget$ContainerType;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$Utf8Validation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MessageReflection {
    public static String delimitWithCommas(List object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            int n10 = stringBuilder.length();
            if (n10 > 0) {
                String string3 = ", ";
                stringBuilder.append(string3);
            }
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    private static void eagerlyMergeMessageSetExtension(CodedInputStream object, ExtensionRegistry$ExtensionInfo object2, ExtensionRegistryLite extensionRegistryLite, MessageReflection$MergeTarget messageReflection$MergeTarget) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
        object2 = ((ExtensionRegistry$ExtensionInfo)object2).defaultInstance;
        object = messageReflection$MergeTarget.parseMessage((CodedInputStream)object, extensionRegistryLite, descriptors$FieldDescriptor, (Message)object2);
        messageReflection$MergeTarget.setField(descriptors$FieldDescriptor, object);
    }

    public static List findMissingFields(MessageOrBuilder messageOrBuilder) {
        ArrayList arrayList = new ArrayList();
        MessageReflection.findMissingFields(messageOrBuilder, "", arrayList);
        return arrayList;
    }

    private static void findMissingFields(MessageOrBuilder messageOrBuilder, String string2, List list) {
        Object object;
        Object object2;
        boolean bl2;
        Iterator<Object> iterator2 = messageOrBuilder.getDescriptorForType().getFields().iterator();
        while (bl2 = iterator2.hasNext()) {
            object2 = (Descriptors$FieldDescriptor)iterator2.next();
            boolean bl3 = ((Descriptors$FieldDescriptor)object2).isRequired();
            if (!bl3 || (bl3 = messageOrBuilder.hasField((Descriptors$FieldDescriptor)object2))) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            object2 = ((Descriptors$FieldDescriptor)object2).getName();
            ((StringBuilder)object).append((String)object2);
            object2 = ((StringBuilder)object).toString();
            list.add(object2);
        }
        iterator2 = messageOrBuilder.getAllFields().entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object3;
            object2 = (Map.Entry)iterator2.next();
            object = (Descriptors$FieldDescriptor)object2.getKey();
            object2 = object2.getValue();
            Object object4 = ((Descriptors$FieldDescriptor)object).getJavaType();
            if (object4 != (object3 = Descriptors$FieldDescriptor$JavaType.MESSAGE)) continue;
            int n10 = ((Descriptors$FieldDescriptor)object).isRepeated();
            if (n10 != 0) {
                boolean bl4;
                n10 = 0;
                object4 = null;
                object2 = ((List)object2).iterator();
                while (bl4 = object2.hasNext()) {
                    object3 = (MessageOrBuilder)object2.next();
                    int n11 = n10 + 1;
                    object4 = MessageReflection.subMessagePrefix(string2, (Descriptors$FieldDescriptor)object, n10);
                    MessageReflection.findMissingFields((MessageOrBuilder)object3, (String)object4, list);
                    n10 = n11;
                }
                continue;
            }
            n10 = messageOrBuilder.hasField((Descriptors$FieldDescriptor)object);
            if (n10 == 0) continue;
            object2 = (MessageOrBuilder)object2;
            n10 = -1;
            object = MessageReflection.subMessagePrefix(string2, object, n10);
            MessageReflection.findMissingFields((MessageOrBuilder)object2, (String)object, list);
        }
    }

    public static int getSerializedSize(Message messageLite, Map object) {
        int n10;
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = messageLite.getDescriptorForType().getOptions();
        boolean bl2 = descriptorProtos$MessageOptions.getMessageSetWireFormat();
        object = object.entrySet().iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
            Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type2;
            boolean bl3;
            Object object2 = (Map.Entry)object.next();
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)object2.getKey();
            object2 = object2.getValue();
            if (bl2 && (bl3 = descriptors$FieldDescriptor.isExtension()) && (descriptors$FieldDescriptor$Type2 = descriptors$FieldDescriptor.getType()) == (descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.MESSAGE) && !(bl3 = descriptors$FieldDescriptor.isRepeated())) {
                int n12 = descriptors$FieldDescriptor.getNumber();
                object2 = (Message)object2;
                n10 = CodedOutputStream.computeMessageSetExtensionSize(n12, (MessageLite)object2);
            } else {
                n10 = FieldSet.computeFieldSize(descriptors$FieldDescriptor, object2);
            }
            n11 += n10;
        }
        messageLite = messageLite.getUnknownFields();
        int n13 = bl2 ? ((UnknownFieldSet)messageLite).getSerializedSizeAsMessageSet() : ((UnknownFieldSet)messageLite).getSerializedSize();
        return n11 + n13;
    }

    public static boolean isInitialized(MessageOrBuilder object) {
        boolean bl2;
        Object object2;
        boolean bl3;
        Object object3 = object.getDescriptorForType().getFields().iterator();
        while (bl3 = object3.hasNext()) {
            object2 = (Descriptors$FieldDescriptor)object3.next();
            boolean bl4 = ((Descriptors$FieldDescriptor)object2).isRequired();
            if (!bl4 || (bl3 = object.hasField((Descriptors$FieldDescriptor)object2))) continue;
            return false;
        }
        object = object.getAllFields().entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
            object3 = (Map.Entry)object.next();
            object2 = (Descriptors$FieldDescriptor)object3.getKey();
            Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType2 = ((Descriptors$FieldDescriptor)object2).getJavaType();
            if (descriptors$FieldDescriptor$JavaType2 != (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) continue;
            bl3 = ((Descriptors$FieldDescriptor)object2).isRepeated();
            if (bl3) {
                object3 = ((List)object3.getValue()).iterator();
                while (bl3 = object3.hasNext()) {
                    object2 = (Message)object3.next();
                    bl3 = object2.isInitialized();
                    if (bl3) continue;
                    return false;
                }
                continue;
            }
            bl2 = (object3 = (Message)object3.getValue()).isInitialized();
            if (bl2) continue;
            return false;
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static boolean mergeFieldFrom(CodedInputStream var0, UnknownFieldSet$Builder var1_1, ExtensionRegistryLite var2_2, Descriptors$Descriptor var3_3, MessageReflection$MergeTarget var4_4, int var5_5) {
        block32: {
            block31: {
                var6_6 /* !! */  = var3_3.getOptions();
                var7_7 = var6_6 /* !! */ .getMessageSetWireFormat();
                var8_8 = 1;
                if (var7_7 != 0 && var5_5 == (var7_7 = WireFormat.MESSAGE_SET_ITEM_TAG)) {
                    MessageReflection.mergeMessageSetExtensionFromCodedStream((CodedInputStream)var0, (UnknownFieldSet$Builder)var1_1, (ExtensionRegistryLite)var2_2, (Descriptors$Descriptor)var3_3, var4_4);
                    return var8_8;
                }
                var7_7 = WireFormat.getTagWireType(var5_5);
                var9_9 = WireFormat.getTagFieldNumber(var5_5);
                var10_10 = var3_3.isExtensionNumber(var9_9);
                var11_11 = null;
                if (!var10_10) break block31;
                var10_10 = var2_2 instanceof ExtensionRegistry;
                if (!var10_10) ** GOTO lbl-1000
                var12_12 /* !! */  = var2_2;
                var12_12 /* !! */  = (ExtensionRegistry)var2_2;
                if ((var3_3 = var4_4.findExtensionByNumber((ExtensionRegistry)var12_12 /* !! */ , (Descriptors$Descriptor)var3_3, var9_9)) == null) ** GOTO lbl-1000
                var12_12 /* !! */  = var3_3.descriptor;
                var11_11 = var3_3.defaultInstance;
                if (var11_11 == null && (var3_3 = var12_12 /* !! */ .getJavaType()) == (var13_13 = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                    var1_1 = new StringBuilder();
                    var1_1.append("Message-typed extension lacked default instance: ");
                    var2_2 = var12_12 /* !! */ .getFullName();
                    var1_1.append((String)var2_2);
                    var1_1 = var1_1.toString();
                    var0 = new IllegalStateException((String)var1_1);
                    throw var0;
                }
                var3_3 = var11_11;
                var11_11 = var12_12 /* !! */ ;
                break block32;
            }
            var12_12 /* !! */  = var4_4.getContainerType();
            if (var12_12 /* !! */  == (var13_13 = MessageReflection$MergeTarget$ContainerType.MESSAGE)) {
                var11_11 = var3_3.findFieldByNumber(var9_9);
                var14_14 = 0;
                var3_3 = null;
            } else lbl-1000:
            // 3 sources

            {
                var14_14 = 0;
                var3_3 = null;
            }
        }
        var10_10 = 0;
        var12_12 /* !! */  = null;
        if (var11_11 == null) {
            while (true) {
                var7_7 = 0;
                var6_6 /* !! */  = null;
                var10_10 = var8_8;
                break;
            }
        } else {
            var13_13 = var11_11.getLiteType();
            var15_15 = FieldSet.getWireFormatForFieldType((WireFormat$FieldType)var13_13, false);
            if (var7_7 == var15_15) {
                var7_7 = 0;
                var6_6 /* !! */  = null;
            } else {
                if ((var15_15 = (int)var11_11.isPackable()) == 0 || var7_7 != (var15_15 = FieldSet.getWireFormatForFieldType((WireFormat$FieldType)(var13_13 = var11_11.getLiteType()), (boolean)var8_8))) ** continue;
                var7_7 = var8_8;
            }
        }
        if (var10_10) {
            if (var1_1 != null) {
                return var1_1.mergeFieldFrom(var5_5, (CodedInputStream)var0);
            }
            return var0.skipField(var5_5);
        }
        if (var7_7 != 0) {
            var16_16 = var0.readRawVarint32();
            var16_16 = var0.pushLimit(var16_16);
            var3_3 = var11_11.getLiteType();
            if (var3_3 == (var17_18 = WireFormat$FieldType.ENUM)) {
                while ((var14_14 = var0.getBytesUntilLimit()) > 0) {
                    var14_14 = var0.readEnum();
                    var17_18 = var11_11.getFile();
                    var5_5 = (int)var17_18.supportsUnknownEnumValue();
                    if (var5_5 != 0) {
                        var17_18 = var11_11.getEnumType();
                        var3_3 = var17_18.findValueByNumberCreatingIfUnknown(var14_14);
                        var4_4.addRepeatedField((Descriptors$FieldDescriptor)var11_11, var3_3);
                        continue;
                    }
                    var17_18 = var11_11.getEnumType().findValueByNumber(var14_14);
                    if (var17_18 == null) {
                        if (var1_1 == null) continue;
                        var1_1.mergeVarintField(var9_9, var14_14);
                        continue;
                    }
                    var4_4.addRepeatedField((Descriptors$FieldDescriptor)var11_11, var17_18);
                }
            } else {
                while ((var18_20 = var0.getBytesUntilLimit()) > 0) {
                    var1_1 = var11_11.getLiteType();
                    var3_3 = var4_4.getUtf8Validation((Descriptors$FieldDescriptor)var11_11);
                    var1_1 = WireFormat.readPrimitiveField((CodedInputStream)var0, (WireFormat$FieldType)var1_1, (WireFormat$Utf8Validation)var3_3);
                    var4_4.addRepeatedField((Descriptors$FieldDescriptor)var11_11, var1_1);
                }
            }
            var0.popLimit(var16_16);
        } else {
            var17_19 = MessageReflection$1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            var6_6 /* !! */  = var11_11.getType();
            var7_7 = var6_6 /* !! */ .ordinal();
            var5_5 = var17_19[var7_7];
            if (var5_5 != var8_8) {
                var7_7 = 2;
                if (var5_5 != var7_7) {
                    var16_17 = 3;
                    if (var5_5 != var16_17) {
                        var1_1 = var11_11.getLiteType();
                        var2_2 = var4_4.getUtf8Validation((Descriptors$FieldDescriptor)var11_11);
                        var0 = WireFormat.readPrimitiveField((CodedInputStream)var0, (WireFormat$FieldType)var1_1, (WireFormat$Utf8Validation)var2_2);
                    } else {
                        var19_22 = var0.readEnum();
                        var2_2 = var11_11.getFile();
                        var16_17 = (int)var2_2.supportsUnknownEnumValue();
                        if (var16_17 != 0) {
                            var1_1 = var11_11.getEnumType();
                            var0 = var1_1.findValueByNumberCreatingIfUnknown(var19_22);
                        } else {
                            var2_2 = var11_11.getEnumType().findValueByNumber(var19_22);
                            if (var2_2 == null) {
                                if (var1_1 != null) {
                                    var1_1.mergeVarintField(var9_9, var19_22);
                                }
                                return var8_8;
                            }
                            var0 = var2_2;
                        }
                    }
                } else {
                    var0 = var4_4.parseMessage((CodedInputStream)var0, (ExtensionRegistryLite)var2_2, (Descriptors$FieldDescriptor)var11_11, (Message)var3_3);
                }
            } else {
                var0 = var4_4.parseGroup((CodedInputStream)var0, (ExtensionRegistryLite)var2_2, (Descriptors$FieldDescriptor)var11_11, (Message)var3_3);
            }
            var18_21 = var11_11.isRepeated();
            if (var18_21) {
                var4_4.addRepeatedField((Descriptors$FieldDescriptor)var11_11, var0);
            } else {
                var4_4.setField((Descriptors$FieldDescriptor)var11_11, var0);
            }
        }
        return var8_8;
    }

    private static void mergeMessageSetExtensionFromBytes(ByteString object, ExtensionRegistry$ExtensionInfo object2, ExtensionRegistryLite extensionRegistryLite, MessageReflection$MergeTarget messageReflection$MergeTarget) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = ((ExtensionRegistry$ExtensionInfo)object2).descriptor;
        boolean bl2 = messageReflection$MergeTarget.hasField(descriptors$FieldDescriptor);
        if (!bl2 && !(bl2 = ExtensionRegistryLite.isEagerlyParseMessageSets())) {
            object2 = ((ExtensionRegistry$ExtensionInfo)object2).defaultInstance;
            LazyField lazyField = new LazyField((MessageLite)object2, extensionRegistryLite, (ByteString)object);
            messageReflection$MergeTarget.setField(descriptors$FieldDescriptor, lazyField);
        } else {
            object2 = ((ExtensionRegistry$ExtensionInfo)object2).defaultInstance;
            object = messageReflection$MergeTarget.parseMessageFromBytes((ByteString)object, extensionRegistryLite, descriptors$FieldDescriptor, (Message)object2);
            messageReflection$MergeTarget.setField(descriptors$FieldDescriptor, object);
        }
    }

    private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream object, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, Descriptors$Descriptor descriptors$Descriptor, MessageReflection$MergeTarget messageReflection$MergeTarget) {
        int n10;
        int n11 = 0;
        boolean bl2 = false;
        ByteString byteString = null;
        Object object2 = null;
        while ((n10 = ((CodedInputStream)object).readTag()) != 0) {
            int n12 = WireFormat.MESSAGE_SET_TYPE_ID_TAG;
            if (n10 == n12) {
                n11 = ((CodedInputStream)object).readUInt32();
                if (n11 == 0 || (n10 = extensionRegistryLite instanceof ExtensionRegistry) == 0) continue;
                object2 = extensionRegistryLite;
                object2 = (ExtensionRegistry)extensionRegistryLite;
                object2 = messageReflection$MergeTarget.findExtensionByNumber((ExtensionRegistry)object2, descriptors$Descriptor, n11);
                continue;
            }
            n12 = WireFormat.MESSAGE_SET_MESSAGE_TAG;
            if (n10 == n12) {
                if (n11 != 0 && object2 != null && (bl2 = ExtensionRegistryLite.isEagerlyParseMessageSets())) {
                    MessageReflection.eagerlyMergeMessageSetExtension((CodedInputStream)object, (ExtensionRegistry$ExtensionInfo)object2, extensionRegistryLite, messageReflection$MergeTarget);
                    bl2 = false;
                    byteString = null;
                    continue;
                }
                byteString = ((CodedInputStream)object).readBytes();
                continue;
            }
            if ((n10 = (int)(((CodedInputStream)object).skipField(n10) ? 1 : 0)) != 0) continue;
        }
        int n13 = WireFormat.MESSAGE_SET_ITEM_END_TAG;
        ((CodedInputStream)object).checkLastTagWas(n13);
        if (byteString != null && n11 != 0) {
            if (object2 != null) {
                MessageReflection.mergeMessageSetExtensionFromBytes(byteString, (ExtensionRegistry$ExtensionInfo)object2, extensionRegistryLite, messageReflection$MergeTarget);
            } else if (byteString != null && unknownFieldSet$Builder != null) {
                object = UnknownFieldSet$Field.newBuilder().addLengthDelimited(byteString).build();
                unknownFieldSet$Builder.mergeField(n11, (UnknownFieldSet$Field)object);
            }
        }
    }

    private static String subMessagePrefix(String string2, Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        StringBuilder stringBuilder = new StringBuilder(string2);
        int n11 = descriptors$FieldDescriptor.isExtension();
        if (n11 != 0) {
            stringBuilder.append('(');
            string2 = descriptors$FieldDescriptor.getFullName();
            stringBuilder.append(string2);
            n11 = 41;
            stringBuilder.append((char)n11);
        } else {
            string2 = descriptors$FieldDescriptor.getName();
            stringBuilder.append(string2);
        }
        n11 = -1;
        if (n10 != n11) {
            stringBuilder.append('[');
            stringBuilder.append(n10);
            n11 = 93;
            stringBuilder.append((char)n11);
        }
        stringBuilder.append('.');
        return stringBuilder.toString();
    }

    public static void writeMessageTo(Message messageLite, Map object, CodedOutputStream codedOutputStream, boolean bl2) {
        Object object2;
        boolean bl3;
        Descriptors$FieldDescriptor descriptors$FieldDescriptor;
        int n10;
        Object object3;
        DescriptorProtos$MessageOptions descriptorProtos$MessageOptions = messageLite.getDescriptorForType().getOptions();
        boolean bl4 = descriptorProtos$MessageOptions.getMessageSetWireFormat();
        if (bl2) {
            object3 = new TreeMap(object);
            object = messageLite.getDescriptorForType().getFields().iterator();
            while ((n10 = object.hasNext()) != 0) {
                descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)object.next();
                bl3 = descriptors$FieldDescriptor.isRequired();
                if (!bl3 || (bl3 = object3.containsKey(descriptors$FieldDescriptor))) continue;
                object2 = messageLite.getField(descriptors$FieldDescriptor);
                object3.put(descriptors$FieldDescriptor, object2);
            }
            object = object3;
        }
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
            object3 = (Map.Entry)object.next();
            descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)object3.getKey();
            object3 = object3.getValue();
            if (bl4 && (bl3 = descriptors$FieldDescriptor.isExtension()) && (object2 = descriptors$FieldDescriptor.getType()) == (descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.MESSAGE) && !(bl3 = descriptors$FieldDescriptor.isRepeated())) {
                n10 = descriptors$FieldDescriptor.getNumber();
                object3 = (Message)object3;
                codedOutputStream.writeMessageSetExtension(n10, (MessageLite)object3);
                continue;
            }
            FieldSet.writeField(descriptors$FieldDescriptor, object3, codedOutputStream);
        }
        messageLite = messageLite.getUnknownFields();
        if (bl4) {
            ((UnknownFieldSet)messageLite).writeAsMessageSetTo(codedOutputStream);
        } else {
            ((UnknownFieldSet)messageLite).writeTo(codedOutputStream);
        }
    }
}


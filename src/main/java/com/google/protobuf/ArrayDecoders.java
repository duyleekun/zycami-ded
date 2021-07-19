/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ArrayDecoders$1;
import com.google.protobuf.ArrayDecoders$Registers;
import com.google.protobuf.BooleanArrayList;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DoubleArrayList;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.FloatArrayList;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageSchema;
import com.google.protobuf.Protobuf;
import com.google.protobuf.Schema;
import com.google.protobuf.SchemaUtil;
import com.google.protobuf.UnknownFieldSchema;
import com.google.protobuf.UnknownFieldSetLite;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import java.nio.charset.Charset;
import java.util.List;

public final class ArrayDecoders {
    public static int decodeBoolList(int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (BooleanArrayList)internal$ProtobufList;
        n11 = ArrayDecoders.decodeVarint64(byArray, n11, arrayDecoders$Registers);
        long l10 = arrayDecoders$Registers.long1;
        long l11 = 0L;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n13 = 1;
        object = object != false ? (Object)n13 : (Object)0;
        ((BooleanArrayList)internal$ProtobufList).addBoolean((boolean)object);
        while (n11 < n12) {
            object = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n14 = arrayDecoders$Registers.int1;
            if (n10 != n14) break;
            n11 = ArrayDecoders.decodeVarint64(byArray, (int)object, arrayDecoders$Registers);
            long l12 = arrayDecoders$Registers.long1;
            long l13 = l12 - l11;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            object = object != false ? (Object)n13 : (Object)0;
            ((BooleanArrayList)internal$ProtobufList).addBoolean((boolean)object);
        }
        return n11;
    }

    public static int decodeBytes(byte[] object, int n10, ArrayDecoders$Registers arrayDecoders$Registers) {
        n10 = ArrayDecoders.decodeVarint32(object, n10, arrayDecoders$Registers);
        int n11 = arrayDecoders$Registers.int1;
        if (n11 >= 0) {
            int n12 = ((byte[])object).length - n10;
            if (n11 <= n12) {
                if (n11 == 0) {
                    object = ByteString.EMPTY;
                    arrayDecoders$Registers.object1 = object;
                    return n10;
                }
                object = ByteString.copyFrom(object, n10, n11);
                arrayDecoders$Registers.object1 = object;
                return n10 + n11;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int decodeBytesList(int var0, byte[] var1_1, int var2_2, int var3_3, Internal$ProtobufList var4_4, ArrayDecoders$Registers var5_5) {
        block3: {
            var2_2 = ArrayDecoders.decodeVarint32(var1_1, var2_2, var5_5);
            var6_6 = var5_5.int1;
            if (var6_6 < 0) throw InvalidProtocolBufferException.negativeSize();
            var7_7 = var1_1.length - var2_2;
            if (var6_6 > var7_7) throw InvalidProtocolBufferException.truncatedMessage();
            if (var6_6 != 0) break block3;
            var8_8 = ByteString.EMPTY;
            var4_4.add(var8_8);
            ** GOTO lbl17
        }
        var9_9 = ByteString.copyFrom(var1_1, var2_2, var6_6);
        var4_4.add(var9_9);
        block0: while (true) {
            var2_2 += var6_6;
            while (var2_2 < var3_3) {
                var6_6 = ArrayDecoders.decodeVarint32(var1_1, var2_2, var5_5);
                var7_7 = var5_5.int1;
                if (var0 != var7_7) return var2_2;
                var2_2 = ArrayDecoders.decodeVarint32(var1_1, var6_6, var5_5);
                var6_6 = var5_5.int1;
                if (var6_6 < 0) throw InvalidProtocolBufferException.negativeSize();
                var7_7 = var1_1.length - var2_2;
                if (var6_6 > var7_7) throw InvalidProtocolBufferException.truncatedMessage();
                if (var6_6 == 0) {
                    var8_8 = ByteString.EMPTY;
                    var4_4.add(var8_8);
                    continue;
                }
                var9_9 = ByteString.copyFrom(var1_1, var2_2, var6_6);
                var4_4.add(var9_9);
                continue block0;
            }
            break;
        }
        return var2_2;
    }

    public static double decodeDouble(byte[] byArray, int n10) {
        return Double.longBitsToDouble(ArrayDecoders.decodeFixed64(byArray, n10));
    }

    public static int decodeDoubleList(int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (DoubleArrayList)internal$ProtobufList;
        double d10 = ArrayDecoders.decodeDouble(byArray, n11);
        ((DoubleArrayList)internal$ProtobufList).addDouble(d10);
        n11 += 8;
        while (n11 < n12) {
            int n13 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n14 = arrayDecoders$Registers.int1;
            if (n10 != n14) break;
            double d11 = ArrayDecoders.decodeDouble(byArray, n13);
            ((DoubleArrayList)internal$ProtobufList).addDouble(d11);
            n11 = n13 + 8;
        }
        return n11;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static int decodeExtension(int var0, byte[] var1_1, int var2_2, int var3_3, GeneratedMessageLite$ExtendableMessage var4_4, GeneratedMessageLite$GeneratedExtension var5_5, UnknownFieldSchema var6_6, ArrayDecoders$Registers var7_7) {
        block39: {
            block41: {
                block42: {
                    block40: {
                        block38: {
                            var8_8 = var4_4.extensions;
                            var0 >>>= 3;
                            var9_9 /* !! */  = var5_5.descriptor;
                            var10_10 = var9_9 /* !! */ .isRepeated();
                            var11_11 = null;
                            if (var10_10 == 0 || (var10_10 = (var9_9 /* !! */  = var5_5.descriptor).isPacked()) == 0) break block38;
                            var12_12 /* !! */  = ArrayDecoders$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
                            var9_9 /* !! */  = var5_5.getLiteType();
                            var10_10 = var9_9 /* !! */ .ordinal();
                            var3_3 = var12_12 /* !! */ [var10_10];
                            switch (var3_3) {
                                default: {
                                    var1_1 = new StringBuilder();
                                    var1_1.append("Type cannot be packed: ");
                                    var14_27 = var5_5.descriptor.getLiteType();
                                    var1_1.append((Object)var14_27);
                                    var1_1 = var1_1.toString();
                                    var13_14 = new IllegalStateException((String)var1_1);
                                    throw var13_14;
                                }
                                case 14: {
                                    var12_12 /* !! */  = (int[])new IntArrayList;
                                    var12_12 /* !! */ ();
                                    var15_38 = ArrayDecoders.decodePackedVarint32List((byte[])var1_1, var2_2, (Internal$ProtobufList)var12_12 /* !! */ , (ArrayDecoders$Registers)var7_7);
                                    var14_28 = var4_4.unknownFields;
                                    var7_7 = UnknownFieldSetLite.getDefaultInstance();
                                    if (var14_28 != var7_7) {
                                        var11_11 = var14_28;
                                    }
                                    var14_28 = var5_5.descriptor.getEnumType();
                                    var13_15 = (UnknownFieldSetLite)SchemaUtil.filterUnknownEnumList(var0, (List)var12_12 /* !! */ , (Internal$EnumLiteMap)var14_28, var11_11, (UnknownFieldSchema)var6_6);
                                    if (var13_15 != null) {
                                        var4_4.unknownFields = var13_15;
                                    }
                                    var13_15 = var5_5.descriptor;
                                    var8_8.setField((FieldSet$FieldDescriptorLite)var13_15, var12_12 /* !! */ );
                                    break;
                                }
                                case 13: {
                                    var13_16 = new LongArrayList();
                                    var15_38 = ArrayDecoders.decodePackedSInt64List((byte[])var1_1, var2_2, var13_16, (ArrayDecoders$Registers)var7_7);
                                    var14_29 = var5_5.descriptor;
                                    var8_8.setField(var14_29, var13_16);
                                    break;
                                }
                                case 12: {
                                    var13_17 = new IntArrayList();
                                    var15_38 = ArrayDecoders.decodePackedSInt32List((byte[])var1_1, var2_2, var13_17, (ArrayDecoders$Registers)var7_7);
                                    var14_30 = var5_5.descriptor;
                                    var8_8.setField(var14_30, var13_17);
                                    break;
                                }
                                case 11: {
                                    var13_18 = new BooleanArrayList();
                                    var15_38 = ArrayDecoders.decodePackedBoolList((byte[])var1_1, var2_2, var13_18, (ArrayDecoders$Registers)var7_7);
                                    var14_31 = var5_5.descriptor;
                                    var8_8.setField(var14_31, var13_18);
                                    break;
                                }
                                case 9: 
                                case 10: {
                                    var13_19 = new IntArrayList();
                                    var15_38 = ArrayDecoders.decodePackedFixed32List((byte[])var1_1, var2_2, var13_19, (ArrayDecoders$Registers)var7_7);
                                    var14_32 = var5_5.descriptor;
                                    var8_8.setField(var14_32, var13_19);
                                    break;
                                }
                                case 7: 
                                case 8: {
                                    var13_20 = new LongArrayList();
                                    var15_38 = ArrayDecoders.decodePackedFixed64List((byte[])var1_1, var2_2, var13_20, (ArrayDecoders$Registers)var7_7);
                                    var14_33 = var5_5.descriptor;
                                    var8_8.setField(var14_33, var13_20);
                                    break;
                                }
                                case 5: 
                                case 6: {
                                    var13_21 = new IntArrayList();
                                    var15_38 = ArrayDecoders.decodePackedVarint32List((byte[])var1_1, var2_2, var13_21, (ArrayDecoders$Registers)var7_7);
                                    var14_34 = var5_5.descriptor;
                                    var8_8.setField(var14_34, var13_21);
                                    break;
                                }
                                case 3: 
                                case 4: {
                                    var13_22 = new LongArrayList();
                                    var15_38 = ArrayDecoders.decodePackedVarint64List((byte[])var1_1, var2_2, var13_22, (ArrayDecoders$Registers)var7_7);
                                    var14_35 = var5_5.descriptor;
                                    var8_8.setField(var14_35, var13_22);
                                    break;
                                }
                                case 2: {
                                    var13_23 = new FloatArrayList();
                                    var15_38 = ArrayDecoders.decodePackedFloatList((byte[])var1_1, var2_2, var13_23, (ArrayDecoders$Registers)var7_7);
                                    var14_36 = var5_5.descriptor;
                                    var8_8.setField(var14_36, var13_23);
                                    break;
                                }
                                case 1: {
                                    var13_24 = new DoubleArrayList();
                                    var15_38 = ArrayDecoders.decodePackedDoubleList((byte[])var1_1, var2_2, var13_24, (ArrayDecoders$Registers)var7_7);
                                    var14_37 = var5_5.descriptor;
                                    var8_8.setField(var14_37, var13_24);
                                    break;
                                }
                            }
                            break block39;
                        }
                        var9_9 /* !! */  = var5_5.getLiteType();
                        if (var9_9 /* !! */  != (var16_39 = WireFormat$FieldType.ENUM)) break block40;
                        var2_2 = ArrayDecoders.decodeVarint32((byte[])var1_1, var2_2, (ArrayDecoders$Registers)var7_7);
                        var1_1 = var5_5.descriptor.getEnumType();
                        var3_3 = var7_7.int1;
                        if ((var1_1 = var1_1.findValueByNumber(var3_3)) == null) {
                            var1_1 = var4_4.unknownFields;
                            var12_13 = UnknownFieldSetLite.getDefaultInstance();
                            if (var1_1 == var12_13) {
                                var4_4.unknownFields = var1_1 = UnknownFieldSetLite.newInstance();
                            }
                            var3_3 = var7_7.int1;
                            SchemaUtil.storeUnknownEnum(var0, var3_3, var1_1, (UnknownFieldSchema)var6_6);
                            return var2_2;
                        }
                        var0 = var7_7.int1;
                        var11_11 = var0;
                        break block41;
                    }
                    var4_4 = (Class<?>)ArrayDecoders$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
                    var6_6 = var5_5.getLiteType();
                    var17_40 = var6_6.ordinal();
                    var18_41 = var4_4[var17_40];
                    switch (var18_41) {
                        default: {
                            break block41;
                        }
                        case 18: {
                            var13_25 = Protobuf.getInstance();
                            var4_4 = var5_5.getMessageDefaultInstance().getClass();
                            var13_25 = var13_25.schemaFor(var4_4);
                            var2_2 = ArrayDecoders.decodeMessageField((Schema)var13_25, (byte[])var1_1, var2_2, var3_3, (ArrayDecoders$Registers)var7_7);
                            var11_11 = var7_7.object1;
                            break block41;
                        }
                        case 17: {
                            var19_42 = (var0 <<= 3) | 4;
                            var13_25 = Protobuf.getInstance();
                            var4_4 = var5_5.getMessageDefaultInstance().getClass();
                            var9_9 /* !! */  = var13_25.schemaFor(var4_4);
                            var11_11 = var1_1;
                            var2_2 = ArrayDecoders.decodeGroupField((Schema)var9_9 /* !! */ , (byte[])var1_1, var2_2, var3_3, var19_42, (ArrayDecoders$Registers)var7_7);
                            var11_11 = var7_7.object1;
                            break block41;
                        }
                        case 16: {
                            var2_2 = ArrayDecoders.decodeString((byte[])var1_1, var2_2, (ArrayDecoders$Registers)var7_7);
                            var11_11 = var7_7.object1;
                            break block41;
                        }
                        case 15: {
                            var2_2 = ArrayDecoders.decodeBytes((byte[])var1_1, var2_2, (ArrayDecoders$Registers)var7_7);
                            var11_11 = var7_7.object1;
                            break block41;
                        }
                        case 14: {
                            var13_26 = new IllegalStateException("Shouldn't reach here.");
                            throw var13_26;
                        }
                        case 13: {
                            var2_2 = ArrayDecoders.decodeVarint64((byte[])var1_1, var2_2, (ArrayDecoders$Registers)var7_7);
                            var20_43 = CodedInputStream.decodeZigZag64(var7_7.long1);
                            var11_11 = var20_43;
                            break block41;
                        }
                        case 12: {
                            var2_2 = ArrayDecoders.decodeVarint32((byte[])var1_1, var2_2, (ArrayDecoders$Registers)var7_7);
                            var0 = CodedInputStream.decodeZigZag32(var7_7.int1);
                            var11_11 = var0;
                            break block41;
                        }
                        case 11: {
                            var2_2 = ArrayDecoders.decodeVarint64((byte[])var1_1, var2_2, (ArrayDecoders$Registers)var7_7);
                            var20_44 = var7_7.long1;
                            var22_47 = 0L;
                            var0 = (int)(var20_44 == var22_47 ? 0 : (var20_44 < var22_47 ? -1 : 1));
                            if (var0 != 0) {
                                var0 = true;
                                var24_48 = 1.4E-45f;
                            } else {
                                var0 = false;
                                var24_49 = 0.0f;
                                var13_25 = null;
                            }
                            var11_11 = (boolean)var0;
                            break block41;
                        }
                        case 9: 
                        case 10: {
                            var0 = ArrayDecoders.decodeFixed32((byte[])var1_1, var2_2);
                            var11_11 = var0;
                            ** GOTO lbl190
                        }
                        case 7: 
                        case 8: {
                            var20_45 = ArrayDecoders.decodeFixed64((byte[])var1_1, var2_2);
                            var11_11 = var20_45;
                            break block42;
                        }
                        case 5: 
                        case 6: {
                            var2_2 = ArrayDecoders.decodeVarint32((byte[])var1_1, var2_2, (ArrayDecoders$Registers)var7_7);
                            var0 = var7_7.int1;
                            var11_11 = var0;
                            break block41;
                        }
                        case 3: 
                        case 4: {
                            var2_2 = ArrayDecoders.decodeVarint64((byte[])var1_1, var2_2, (ArrayDecoders$Registers)var7_7);
                            var20_46 = var7_7.long1;
                            var11_11 = var20_46;
                            break block41;
                        }
                        case 2: {
                            var24_50 = ArrayDecoders.decodeFloat((byte[])var1_1, var2_2);
                            var11_11 = Float.valueOf(var24_50);
lbl190:
                            // 2 sources

                            var2_2 += 4;
                            break block41;
                        }
                        case 1: 
                    }
                    var25_51 = ArrayDecoders.decodeDouble((byte[])var1_1, var2_2);
                    var11_11 = var25_51;
                }
                var2_2 += 8;
            }
            var0 = (int)var5_5.isRepeated();
            if (var0 != 0) {
                var13_25 = var5_5.descriptor;
                var8_8.addRepeatedField((FieldSet$FieldDescriptorLite)var13_25, var11_11);
            } else {
                var13_25 = ArrayDecoders$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
                var1_1 = var5_5.getLiteType();
                var15_38 = var1_1.ordinal();
                var0 = (int)var13_25[var15_38];
                if (var0 == (var15_38 = 17) || var0 == (var15_38 = 18)) {
                    var13_25 = var5_5.descriptor;
                    if ((var13_25 = var8_8.getField((FieldSet$FieldDescriptorLite)var13_25)) != null) {
                        var11_11 = Internal.mergeMessage(var13_25, var11_11);
                    }
                }
                var13_25 = var5_5.descriptor;
                var8_8.setField((FieldSet$FieldDescriptorLite)var13_25, var11_11);
            }
            var15_38 = var2_2;
        }
        return var15_38;
    }

    public static int decodeExtensionOrUnknownField(int n10, byte[] byArray, int n11, int n12, Object object, MessageLite messageLite, UnknownFieldSchema unknownFieldSchema, ArrayDecoders$Registers arrayDecoders$Registers) {
        Object object2 = arrayDecoders$Registers.extensionRegistry;
        int n13 = n10 >>> 3;
        Object object3 = ((ExtensionRegistryLite)object2).findLiteExtensionByNumber(messageLite, n13);
        if (object3 == null) {
            UnknownFieldSetLite unknownFieldSetLite = MessageSchema.getMutableUnknownFields(object);
            n13 = n10;
            object2 = byArray;
            object3 = arrayDecoders$Registers;
            return ArrayDecoders.decodeUnknownField(n10, byArray, n11, n12, unknownFieldSetLite, arrayDecoders$Registers);
        }
        Object object4 = object;
        object4 = (GeneratedMessageLite$ExtendableMessage)object;
        ((GeneratedMessageLite$ExtendableMessage)object4).ensureExtensionsAreMutable();
        n13 = n10;
        object2 = byArray;
        return ArrayDecoders.decodeExtension(n10, byArray, n11, n12, (GeneratedMessageLite$ExtendableMessage)object4, (GeneratedMessageLite$GeneratedExtension)object3, unknownFieldSchema, arrayDecoders$Registers);
    }

    public static int decodeFixed32(byte[] byArray, int n10) {
        int n11 = byArray[n10] & 0xFF;
        int n12 = n10 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        n11 |= n12;
        n12 = n10 + 2;
        n12 = (byArray[n12] & 0xFF) << 16;
        return (byArray[n10 += 3] & 0xFF) << 24 | (n11 |= n12);
    }

    public static int decodeFixed32List(int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (IntArrayList)internal$ProtobufList;
        int n13 = ArrayDecoders.decodeFixed32(byArray, n11);
        ((IntArrayList)internal$ProtobufList).addInt(n13);
        n11 += 4;
        while (n11 < n12) {
            n13 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n14 = arrayDecoders$Registers.int1;
            if (n10 != n14) break;
            n11 = ArrayDecoders.decodeFixed32(byArray, n13);
            ((IntArrayList)internal$ProtobufList).addInt(n11);
            n11 = n13 + 4;
        }
        return n11;
    }

    public static long decodeFixed64(byte[] byArray, int n10) {
        long l10 = byArray[n10];
        long l11 = 255L;
        l10 &= l11;
        int n11 = n10 + 1;
        long l12 = ((long)byArray[n11] & l11) << 8;
        l10 |= l12;
        n11 = n10 + 2;
        l12 = ((long)byArray[n11] & l11) << 16;
        l10 |= l12;
        n11 = n10 + 3;
        l12 = ((long)byArray[n11] & l11) << 24;
        l10 |= l12;
        n11 = n10 + 4;
        l12 = ((long)byArray[n11] & l11) << 32;
        l10 |= l12;
        n11 = n10 + 5;
        l12 = ((long)byArray[n11] & l11) << 40;
        l10 |= l12;
        n11 = n10 + 6;
        l12 = ((long)byArray[n11] & l11) << 48;
        return ((long)byArray[n10 += 7] & l11) << 56 | (l10 |= l12);
    }

    public static int decodeFixed64List(int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (LongArrayList)internal$ProtobufList;
        long l10 = ArrayDecoders.decodeFixed64(byArray, n11);
        ((LongArrayList)internal$ProtobufList).addLong(l10);
        n11 += 8;
        while (n11 < n12) {
            int n13 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n14 = arrayDecoders$Registers.int1;
            if (n10 != n14) break;
            long l11 = ArrayDecoders.decodeFixed64(byArray, n13);
            ((LongArrayList)internal$ProtobufList).addLong(l11);
            n11 = n13 + 8;
        }
        return n11;
    }

    public static float decodeFloat(byte[] byArray, int n10) {
        return Float.intBitsToFloat(ArrayDecoders.decodeFixed32(byArray, n10));
    }

    public static int decodeFloatList(int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (FloatArrayList)internal$ProtobufList;
        float f10 = ArrayDecoders.decodeFloat(byArray, n11);
        ((FloatArrayList)internal$ProtobufList).addFloat(f10);
        n11 += 4;
        while (n11 < n12) {
            int n13 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n14 = arrayDecoders$Registers.int1;
            if (n10 != n14) break;
            float f11 = ArrayDecoders.decodeFloat(byArray, n13);
            ((FloatArrayList)internal$ProtobufList).addFloat(f11);
            n11 = n13 + 4;
        }
        return n11;
    }

    public static int decodeGroupField(Schema schema, byte[] byArray, int n10, int n11, int n12, ArrayDecoders$Registers arrayDecoders$Registers) {
        schema = (MessageSchema)schema;
        Object object = ((MessageSchema)schema).newInstance();
        int n13 = ((MessageSchema)schema).parseProto2Message(object, byArray, n10, n11, n12, arrayDecoders$Registers);
        ((MessageSchema)schema).makeImmutable(object);
        arrayDecoders$Registers.object1 = object;
        return n13;
    }

    public static int decodeGroupList(Schema schema, int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        int n13 = n10 & 0xFFFFFFF8 | 4;
        Object object = schema;
        int n14 = n11;
        n11 = ArrayDecoders.decodeGroupField(schema, byArray, n11, n12, n13, arrayDecoders$Registers);
        object = arrayDecoders$Registers.object1;
        internal$ProtobufList.add(object);
        while (n11 < n12) {
            n14 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n15 = arrayDecoders$Registers.int1;
            if (n10 != n15) break;
            object = schema;
            n11 = ArrayDecoders.decodeGroupField(schema, byArray, n14, n12, n13, arrayDecoders$Registers);
            object = arrayDecoders$Registers.object1;
            internal$ProtobufList.add(object);
        }
        return n11;
    }

    public static int decodeMessageField(Schema schema, byte[] byArray, int n10, int n11, ArrayDecoders$Registers arrayDecoders$Registers) {
        int n12 = n10 + 1;
        if ((n10 = byArray[n10]) < 0) {
            n12 = ArrayDecoders.decodeVarint32(n10, byArray, n12, arrayDecoders$Registers);
            n10 = arrayDecoders$Registers.int1;
        }
        if (n10 >= 0 && n10 <= (n11 -= n12)) {
            Object object = schema.newInstance();
            schema.mergeFrom(object, byArray, n12, n10 += n12, arrayDecoders$Registers);
            schema.makeImmutable(object);
            arrayDecoders$Registers.object1 = object;
            return n10;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeMessageList(Schema schema, int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        n11 = ArrayDecoders.decodeMessageField(schema, byArray, n11, n12, arrayDecoders$Registers);
        Object object = arrayDecoders$Registers.object1;
        internal$ProtobufList.add(object);
        while (n11 < n12) {
            int n13 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n14 = arrayDecoders$Registers.int1;
            if (n10 != n14) break;
            n11 = ArrayDecoders.decodeMessageField(schema, byArray, n13, n12, arrayDecoders$Registers);
            object = arrayDecoders$Registers.object1;
            internal$ProtobufList.add(object);
        }
        return n11;
    }

    public static int decodePackedBoolList(byte[] byArray, int n10, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (BooleanArrayList)internal$ProtobufList;
        n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
        int n11 = arrayDecoders$Registers.int1 + n10;
        while (n10 < n11) {
            n10 = ArrayDecoders.decodeVarint64(byArray, n10, arrayDecoders$Registers);
            long l10 = arrayDecoders$Registers.long1;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            object = object != false ? (Object)1 : (Object)0;
            ((BooleanArrayList)internal$ProtobufList).addBoolean((boolean)object);
        }
        if (n10 == n11) {
            return n10;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedDoubleList(byte[] byArray, int n10, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (DoubleArrayList)internal$ProtobufList;
        int n11 = arrayDecoders$Registers.int1 + n10;
        for (n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers); n10 < n11; n10 += 8) {
            double d10 = ArrayDecoders.decodeDouble(byArray, n10);
            ((DoubleArrayList)internal$ProtobufList).addDouble(d10);
        }
        if (n10 == n11) {
            return n10;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed32List(byte[] byArray, int n10, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (IntArrayList)internal$ProtobufList;
        int n11 = arrayDecoders$Registers.int1 + n10;
        for (n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers); n10 < n11; n10 += 4) {
            int n12 = ArrayDecoders.decodeFixed32(byArray, n10);
            ((IntArrayList)internal$ProtobufList).addInt(n12);
        }
        if (n10 == n11) {
            return n10;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed64List(byte[] byArray, int n10, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (LongArrayList)internal$ProtobufList;
        int n11 = arrayDecoders$Registers.int1 + n10;
        for (n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers); n10 < n11; n10 += 8) {
            long l10 = ArrayDecoders.decodeFixed64(byArray, n10);
            ((LongArrayList)internal$ProtobufList).addLong(l10);
        }
        if (n10 == n11) {
            return n10;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFloatList(byte[] byArray, int n10, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (FloatArrayList)internal$ProtobufList;
        int n11 = arrayDecoders$Registers.int1 + n10;
        for (n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers); n10 < n11; n10 += 4) {
            float f10 = ArrayDecoders.decodeFloat(byArray, n10);
            ((FloatArrayList)internal$ProtobufList).addFloat(f10);
        }
        if (n10 == n11) {
            return n10;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt32List(byte[] byArray, int n10, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (IntArrayList)internal$ProtobufList;
        n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
        int n11 = arrayDecoders$Registers.int1 + n10;
        while (n10 < n11) {
            n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
            int n12 = CodedInputStream.decodeZigZag32(arrayDecoders$Registers.int1);
            ((IntArrayList)internal$ProtobufList).addInt(n12);
        }
        if (n10 == n11) {
            return n10;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt64List(byte[] byArray, int n10, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (LongArrayList)internal$ProtobufList;
        n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
        int n11 = arrayDecoders$Registers.int1 + n10;
        while (n10 < n11) {
            n10 = ArrayDecoders.decodeVarint64(byArray, n10, arrayDecoders$Registers);
            long l10 = CodedInputStream.decodeZigZag64(arrayDecoders$Registers.long1);
            ((LongArrayList)internal$ProtobufList).addLong(l10);
        }
        if (n10 == n11) {
            return n10;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint32List(byte[] byArray, int n10, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (IntArrayList)internal$ProtobufList;
        n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
        int n11 = arrayDecoders$Registers.int1 + n10;
        while (n10 < n11) {
            n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
            int n12 = arrayDecoders$Registers.int1;
            ((IntArrayList)internal$ProtobufList).addInt(n12);
        }
        if (n10 == n11) {
            return n10;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint64List(byte[] byArray, int n10, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (LongArrayList)internal$ProtobufList;
        n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
        int n11 = arrayDecoders$Registers.int1 + n10;
        while (n10 < n11) {
            n10 = ArrayDecoders.decodeVarint64(byArray, n10, arrayDecoders$Registers);
            long l10 = arrayDecoders$Registers.long1;
            ((LongArrayList)internal$ProtobufList).addLong(l10);
        }
        if (n10 == n11) {
            return n10;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeSInt32List(int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (IntArrayList)internal$ProtobufList;
        n11 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
        int n13 = CodedInputStream.decodeZigZag32(arrayDecoders$Registers.int1);
        ((IntArrayList)internal$ProtobufList).addInt(n13);
        while (n11 < n12) {
            n13 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n14 = arrayDecoders$Registers.int1;
            if (n10 != n14) break;
            n11 = ArrayDecoders.decodeVarint32(byArray, n13, arrayDecoders$Registers);
            n13 = CodedInputStream.decodeZigZag32(arrayDecoders$Registers.int1);
            ((IntArrayList)internal$ProtobufList).addInt(n13);
        }
        return n11;
    }

    public static int decodeSInt64List(int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (LongArrayList)internal$ProtobufList;
        n11 = ArrayDecoders.decodeVarint64(byArray, n11, arrayDecoders$Registers);
        long l10 = CodedInputStream.decodeZigZag64(arrayDecoders$Registers.long1);
        ((LongArrayList)internal$ProtobufList).addLong(l10);
        while (n11 < n12) {
            int n13 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n14 = arrayDecoders$Registers.int1;
            if (n10 != n14) break;
            n11 = ArrayDecoders.decodeVarint64(byArray, n13, arrayDecoders$Registers);
            l10 = CodedInputStream.decodeZigZag64(arrayDecoders$Registers.long1);
            ((LongArrayList)internal$ProtobufList).addLong(l10);
        }
        return n11;
    }

    public static int decodeString(byte[] byArray, int n10, ArrayDecoders$Registers arrayDecoders$Registers) {
        n10 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
        int n11 = arrayDecoders$Registers.int1;
        if (n11 >= 0) {
            if (n11 == 0) {
                arrayDecoders$Registers.object1 = "";
                return n10;
            }
            Charset charset = Internal.UTF_8;
            String string2 = new String(byArray, n10, n11, charset);
            arrayDecoders$Registers.object1 = string2;
            return n10 + n11;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int decodeStringList(int var0, byte[] var1_1, int var2_2, int var3_3, Internal$ProtobufList var4_4, ArrayDecoders$Registers var5_5) {
        block3: {
            var2_2 = ArrayDecoders.decodeVarint32(var1_1, var2_2, var5_5);
            var6_6 = var5_5.int1;
            if (var6_6 < 0) throw InvalidProtocolBufferException.negativeSize();
            var7_7 = "";
            if (var6_6 != 0) break block3;
            var4_4.add(var7_7);
            ** GOTO lbl16
        }
        var9_9 = Internal.UTF_8;
        var8_8 = new String(var1_1, var2_2, var6_6, var9_9);
        var4_4.add(var8_8);
        block0: while (true) {
            var2_2 += var6_6;
            while (var2_2 < var3_3) {
                var6_6 = ArrayDecoders.decodeVarint32(var1_1, var2_2, var5_5);
                var10_10 = var5_5.int1;
                if (var0 != var10_10) return var2_2;
                var2_2 = ArrayDecoders.decodeVarint32(var1_1, var6_6, var5_5);
                var6_6 = var5_5.int1;
                if (var6_6 < 0) throw InvalidProtocolBufferException.negativeSize();
                if (var6_6 == 0) {
                    var4_4.add(var7_7);
                    continue;
                }
                var9_9 = Internal.UTF_8;
                var8_8 = new String(var1_1, var2_2, var6_6, var9_9);
                var4_4.add(var8_8);
                continue block0;
            }
            break;
        }
        return var2_2;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int decodeStringListRequireUtf8(int var0, byte[] var1_1, int var2_2, int var3_3, Internal$ProtobufList var4_4, ArrayDecoders$Registers var5_5) {
        block3: {
            var2_2 = ArrayDecoders.decodeVarint32(var1_1, var2_2, var5_5);
            var6_6 = var5_5.int1;
            if (var6_6 < 0) throw InvalidProtocolBufferException.negativeSize();
            var7_7 = "";
            if (var6_6 != 0) break block3;
            var4_4.add(var7_7);
            ** GOTO lbl19
        }
        var8_8 = var2_2 + var6_6;
        var9_9 = Utf8.isValidUtf8(var1_1, var2_2, var8_8);
        if (!var9_9) throw InvalidProtocolBufferException.invalidUtf8();
        var11_11 = Internal.UTF_8;
        var10_10 = new String(var1_1, var2_2, var6_6, var11_11);
        var4_4.add(var10_10);
        block0: while (true) {
            var2_2 = var8_8;
            while (var2_2 < var3_3) {
                var6_6 = ArrayDecoders.decodeVarint32(var1_1, var2_2, var5_5);
                var8_8 = var5_5.int1;
                if (var0 != var8_8) return var2_2;
                var2_2 = ArrayDecoders.decodeVarint32(var1_1, var6_6, var5_5);
                var6_6 = var5_5.int1;
                if (var6_6 < 0) throw InvalidProtocolBufferException.negativeSize();
                if (var6_6 == 0) {
                    var4_4.add(var7_7);
                    continue;
                }
                var8_8 = var2_2 + var6_6;
                var9_9 = Utf8.isValidUtf8(var1_1, var2_2, var8_8);
                if (!var9_9) throw InvalidProtocolBufferException.invalidUtf8();
                var11_11 = Internal.UTF_8;
                var10_10 = new String(var1_1, var2_2, var6_6, var11_11);
                var4_4.add(var10_10);
                continue block0;
            }
            break;
        }
        return var2_2;
    }

    public static int decodeStringRequireUtf8(byte[] object, int n10, ArrayDecoders$Registers arrayDecoders$Registers) {
        n10 = ArrayDecoders.decodeVarint32(object, n10, arrayDecoders$Registers);
        int n11 = arrayDecoders$Registers.int1;
        if (n11 >= 0) {
            if (n11 == 0) {
                arrayDecoders$Registers.object1 = "";
                return n10;
            }
            object = Utf8.decodeUtf8(object, n10, n11);
            arrayDecoders$Registers.object1 = object;
            return n10 + n11;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public static int decodeUnknownField(int n10, byte[] object, int n11, int n12, UnknownFieldSetLite unknownFieldSetLite, ArrayDecoders$Registers arrayDecoders$Registers) {
        int n13 = WireFormat.getTagFieldNumber(n10);
        if (n13 != 0) {
            n13 = WireFormat.getTagWireType(n10);
            if (n13 != 0) {
                int n14 = 1;
                if (n13 != n14) {
                    n14 = 2;
                    if (n13 != n14) {
                        n14 = 3;
                        if (n13 != n14) {
                            n12 = 5;
                            if (n13 == n12) {
                                object = ArrayDecoders.decodeFixed32(object, n11);
                                unknownFieldSetLite.storeField(n10, object);
                                return n11 + 4;
                            }
                            throw InvalidProtocolBufferException.invalidTag();
                        }
                        UnknownFieldSetLite unknownFieldSetLite2 = UnknownFieldSetLite.newInstance();
                        int n15 = n10 & 0xFFFFFFF8 | 4;
                        n13 = 0;
                        while (n11 < n12) {
                            int n16 = ArrayDecoders.decodeVarint32(object, n11, arrayDecoders$Registers);
                            n11 = arrayDecoders$Registers.int1;
                            if (n11 == n15) {
                                n13 = n11;
                                n11 = n16;
                                break;
                            }
                            n13 = n11;
                            int n17 = ArrayDecoders.decodeUnknownField(n11, object, n16, n12, unknownFieldSetLite2, arrayDecoders$Registers);
                            n13 = n11;
                            n11 = n17;
                        }
                        if (n11 <= n12 && n13 == n15) {
                            unknownFieldSetLite.storeField(n10, unknownFieldSetLite2);
                            return n11;
                        }
                        throw InvalidProtocolBufferException.parseFailure();
                    }
                    n11 = ArrayDecoders.decodeVarint32(object, n11, arrayDecoders$Registers);
                    n12 = arrayDecoders$Registers.int1;
                    if (n12 >= 0) {
                        int n18 = ((byte[])object).length - n11;
                        if (n12 <= n18) {
                            if (n12 == 0) {
                                object = ByteString.EMPTY;
                                unknownFieldSetLite.storeField(n10, object);
                            } else {
                                object = ByteString.copyFrom(object, n11, n12);
                                unknownFieldSetLite.storeField(n10, object);
                            }
                            return n11 + n12;
                        }
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    throw InvalidProtocolBufferException.negativeSize();
                }
                object = ArrayDecoders.decodeFixed64(object, n11);
                unknownFieldSetLite.storeField(n10, object);
                return n11 + 8;
            }
            int n19 = ArrayDecoders.decodeVarint64(object, n11, arrayDecoders$Registers);
            Long l10 = arrayDecoders$Registers.long1;
            unknownFieldSetLite.storeField(n10, l10);
            return n19;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public static int decodeVarint32(int n10, byte[] byArray, int n11, ArrayDecoders$Registers arrayDecoders$Registers) {
        n10 &= 0x7F;
        int n12 = n11 + 1;
        if ((n11 = byArray[n11]) >= 0) {
            int n13 = n11 << 7;
            arrayDecoders$Registers.int1 = n10 |= n13;
            return n12;
        }
        n11 = (n11 & 0x7F) << 7;
        n10 |= n11;
        n11 = n12 + 1;
        if ((n12 = byArray[n12]) >= 0) {
            int n14 = n12 << 14;
            arrayDecoders$Registers.int1 = n10 |= n14;
            return n11;
        }
        n12 = (n12 & 0x7F) << 14;
        n10 |= n12;
        n12 = n11 + 1;
        if ((n11 = byArray[n11]) >= 0) {
            int n15 = n11 << 21;
            arrayDecoders$Registers.int1 = n10 |= n15;
            return n12;
        }
        n11 = (n11 & 0x7F) << 21;
        n10 |= n11;
        n11 = n12 + 1;
        if ((n12 = byArray[n12]) >= 0) {
            int n16 = n12 << 28;
            arrayDecoders$Registers.int1 = n10 |= n16;
            return n11;
        }
        n12 = (n12 & 0x7F) << 28;
        n10 |= n12;
        while (true) {
            n12 = n11 + 1;
            if ((n11 = byArray[n11]) >= 0) break;
            n11 = n12;
        }
        arrayDecoders$Registers.int1 = n10;
        return n12;
    }

    public static int decodeVarint32(byte[] byArray, int n10, ArrayDecoders$Registers arrayDecoders$Registers) {
        int n11 = n10 + 1;
        if ((n10 = byArray[n10]) >= 0) {
            arrayDecoders$Registers.int1 = n10;
            return n11;
        }
        return ArrayDecoders.decodeVarint32(n10, byArray, n11, arrayDecoders$Registers);
    }

    public static int decodeVarint32List(int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (IntArrayList)internal$ProtobufList;
        n11 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
        int n13 = arrayDecoders$Registers.int1;
        ((IntArrayList)internal$ProtobufList).addInt(n13);
        while (n11 < n12) {
            n13 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n14 = arrayDecoders$Registers.int1;
            if (n10 != n14) break;
            n11 = ArrayDecoders.decodeVarint32(byArray, n13, arrayDecoders$Registers);
            n13 = arrayDecoders$Registers.int1;
            ((IntArrayList)internal$ProtobufList).addInt(n13);
        }
        return n11;
    }

    public static int decodeVarint64(long l10, byte[] byArray, int n10, ArrayDecoders$Registers arrayDecoders$Registers) {
        long l11 = 127;
        l10 &= l11;
        int n11 = n10 + 1;
        n10 = byArray[n10];
        long l12 = n10 & 0x7F;
        int n12 = 7;
        l10 |= (l12 <<= n12);
        int n13 = n12;
        while (n10 < 0) {
            n10 = n11 + 1;
            n11 = byArray[n11];
            int n14 = n11 & 0x7F;
            long l13 = (long)n14 << (n13 += n12);
            l10 |= l13;
            int n15 = n11;
            n11 = n10;
            n10 = n15;
        }
        arrayDecoders$Registers.long1 = l10;
        return n11;
    }

    public static int decodeVarint64(byte[] byArray, int n10, ArrayDecoders$Registers arrayDecoders$Registers) {
        int n11 = n10 + 1;
        long l10 = byArray[n10];
        long l11 = 0L;
        long l12 = l10 - l11;
        if ((n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0) {
            arrayDecoders$Registers.long1 = l10;
            return n11;
        }
        return ArrayDecoders.decodeVarint64(l10, byArray, n11, arrayDecoders$Registers);
    }

    public static int decodeVarint64List(int n10, byte[] byArray, int n11, int n12, Internal$ProtobufList internal$ProtobufList, ArrayDecoders$Registers arrayDecoders$Registers) {
        internal$ProtobufList = (LongArrayList)internal$ProtobufList;
        n11 = ArrayDecoders.decodeVarint64(byArray, n11, arrayDecoders$Registers);
        long l10 = arrayDecoders$Registers.long1;
        ((LongArrayList)internal$ProtobufList).addLong(l10);
        while (n11 < n12) {
            int n13 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
            int n14 = arrayDecoders$Registers.int1;
            if (n10 != n14) break;
            n11 = ArrayDecoders.decodeVarint64(byArray, n13, arrayDecoders$Registers);
            l10 = arrayDecoders$Registers.long1;
            ((LongArrayList)internal$ProtobufList).addLong(l10);
        }
        return n11;
    }

    public static int skipField(int n10, byte[] byArray, int n11, int n12, ArrayDecoders$Registers arrayDecoders$Registers) {
        int n13 = WireFormat.getTagFieldNumber(n10);
        if (n13 != 0) {
            n13 = WireFormat.getTagWireType(n10);
            if (n13 != 0) {
                int n14 = 1;
                if (n13 != n14) {
                    n14 = 2;
                    if (n13 != n14) {
                        n14 = 3;
                        if (n13 != n14) {
                            n10 = 5;
                            if (n13 == n10) {
                                return n11 + 4;
                            }
                            throw InvalidProtocolBufferException.invalidTag();
                        }
                        n10 = n10 & 0xFFFFFFF8 | 4;
                        n13 = 0;
                        while (n11 < n12) {
                            n11 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
                            n13 = arrayDecoders$Registers.int1;
                            if (n13 == n10) break;
                            n11 = ArrayDecoders.skipField(n13, byArray, n11, n12, arrayDecoders$Registers);
                        }
                        if (n11 <= n12 && n13 == n10) {
                            return n11;
                        }
                        throw InvalidProtocolBufferException.parseFailure();
                    }
                    n10 = ArrayDecoders.decodeVarint32(byArray, n11, arrayDecoders$Registers);
                    int n15 = arrayDecoders$Registers.int1;
                    return n10 + n15;
                }
                return n11 + 8;
            }
            return ArrayDecoders.decodeVarint64(byArray, n11, arrayDecoders$Registers);
        }
        throw InvalidProtocolBufferException.invalidTag();
    }
}


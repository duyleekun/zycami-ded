/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ArrayDecoders$Registers;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString$CodedBuilder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.ExtensionSchema;
import com.google.protobuf.FieldInfo;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldType;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumVerifier;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListFieldSchema;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.MapFieldSchema;
import com.google.protobuf.MessageInfo;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageSchema$1;
import com.google.protobuf.NewInstanceSchema;
import com.google.protobuf.ProtoSyntax;
import com.google.protobuf.Protobuf;
import com.google.protobuf.RawMessageInfo;
import com.google.protobuf.Reader;
import com.google.protobuf.Schema;
import com.google.protobuf.SchemaUtil;
import com.google.protobuf.StructuralMessageInfo;
import com.google.protobuf.UnknownFieldSchema;
import com.google.protobuf.UnknownFieldSetLite;
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import com.google.protobuf.Writer;
import com.google.protobuf.Writer$FieldOrder;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

public final class MessageSchema
implements Schema {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final int ENFORCE_UTF8_MASK = 0x20000000;
    private static final int FIELD_TYPE_MASK = 0xFF00000;
    private static final int INTS_PER_FIELD = 3;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    public static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 0x10000000;
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema unknownFieldSchema;
    private final boolean useCachedSizeField;

    private MessageSchema(int[] nArray, Object[] objectArray, int n10, int n11, MessageLite messageLite, boolean bl2, boolean bl3, int[] nArray2, int n12, int n13, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        boolean bl4;
        this.buffer = nArray;
        this.objects = objectArray;
        this.minFieldNumber = n10;
        this.maxFieldNumber = n11;
        this.lite = bl4 = messageLite instanceof GeneratedMessageLite;
        this.proto3 = bl2;
        if (extensionSchema != null && (bl4 = extensionSchema.hasExtensions(messageLite))) {
            bl4 = true;
        } else {
            bl4 = false;
            nArray = null;
        }
        this.hasExtensions = bl4;
        this.useCachedSizeField = bl3;
        this.intArray = nArray2;
        this.checkInitializedCount = n12;
        this.repeatedFieldOffsetStart = n13;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(Object object, Object object2, int n10) {
        boolean bl2;
        boolean bl3 = this.isFieldPresent(object, n10);
        if (bl3 == (bl2 = this.isFieldPresent(object2, n10))) {
            bl3 = true;
        } else {
            bl3 = false;
            object = null;
        }
        return bl3;
    }

    private static boolean booleanAt(Object object, long l10) {
        return UnsafeUtil.getBoolean(object, l10);
    }

    private int decodeMapEntry(byte[] byArray, int n10, int n11, MapEntryLite$Metadata mapEntryLite$Metadata, Map map, ArrayDecoders$Registers arrayDecoders$Registers) {
        int n12;
        byte[] byArray2 = byArray;
        int n13 = n11;
        MapEntryLite$Metadata mapEntryLite$Metadata2 = mapEntryLite$Metadata;
        int n14 = n10;
        ArrayDecoders$Registers arrayDecoders$Registers2 = arrayDecoders$Registers;
        n14 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
        int n15 = arrayDecoders$Registers.int1;
        if (n15 >= 0 && n15 <= (n12 = n11 - n14)) {
            int n16 = n14 + n15;
            Object object = mapEntryLite$Metadata.defaultKey;
            Object object2 = mapEntryLite$Metadata.defaultValue;
            Object object3 = object;
            Object object4 = object2;
            while (n14 < n16) {
                Class<?> clazz;
                WireFormat$FieldType wireFormat$FieldType;
                n15 = n14 + 1;
                if ((n14 = byArray2[n14]) < 0) {
                    n14 = ArrayDecoders.decodeVarint32(n14, byArray, n15, arrayDecoders$Registers2);
                    n15 = arrayDecoders$Registers2.int1;
                    n12 = n14;
                    n14 = n15;
                } else {
                    n12 = n15;
                }
                n15 = n14 >>> 3;
                int n17 = n14 & 7;
                int n18 = 1;
                if (n15 != n18) {
                    n18 = 2;
                    if (n15 == n18 && n17 == (n15 = ((WireFormat$FieldType)((Object)(object = mapEntryLite$Metadata2.valueType))).getWireType())) {
                        wireFormat$FieldType = mapEntryLite$Metadata2.valueType;
                        clazz = mapEntryLite$Metadata2.defaultValue.getClass();
                        object = byArray;
                        n17 = n11;
                        n14 = this.decodeMapEntryValue(byArray, n12, n11, wireFormat$FieldType, clazz, arrayDecoders$Registers);
                        object4 = arrayDecoders$Registers2.object1;
                        continue;
                    }
                } else {
                    object = mapEntryLite$Metadata2.keyType;
                    n15 = ((WireFormat$FieldType)((Object)object)).getWireType();
                    if (n17 == n15) {
                        wireFormat$FieldType = mapEntryLite$Metadata2.keyType;
                        clazz = null;
                        object = byArray;
                        n17 = n11;
                        n14 = this.decodeMapEntryValue(byArray, n12, n11, wireFormat$FieldType, null, arrayDecoders$Registers);
                        object3 = arrayDecoders$Registers2.object1;
                        continue;
                    }
                }
                n14 = ArrayDecoders.skipField(n14, byArray, n12, n13, arrayDecoders$Registers2);
            }
            if (n14 == n16) {
                map.put(object3, object4);
                return n16;
            }
            throw InvalidProtocolBufferException.parseFailure();
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int decodeMapEntryValue(byte[] object, int n10, int n11, WireFormat$FieldType object2, Class clazz, ArrayDecoders$Registers arrayDecoders$Registers) {
        Boolean bl2;
        int n12;
        void var6_12;
        int n13;
        void var4_9;
        int[] nArray = MessageSchema$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType;
        int n14 = var4_9.ordinal();
        n14 = nArray[n14];
        switch (n14) {
            default: {
                RuntimeException runtimeException = new RuntimeException("unsupported field type.");
                throw runtimeException;
            }
            case 17: {
                return ArrayDecoders.decodeStringRequireUtf8(object, n13, (ArrayDecoders$Registers)var6_12);
            }
            case 16: {
                n12 = ArrayDecoders.decodeVarint64(object, n13, (ArrayDecoders$Registers)var6_12);
                long l10 = CodedInputStream.decodeZigZag64(var6_12.long1);
                Long l11 = l10;
                var6_12.object1 = l11;
                return n12;
            }
            case 15: {
                n12 = ArrayDecoders.decodeVarint32(object, n13, (ArrayDecoders$Registers)var6_12);
                n13 = CodedInputStream.decodeZigZag32(var6_12.int1);
                Integer n15 = n13;
                var6_12.object1 = n15;
                return n12;
            }
            case 14: {
                void var3_8;
                void var5_11;
                Schema schema = Protobuf.getInstance().schemaFor((Class)var5_11);
                return ArrayDecoders.decodeMessageField(schema, object, n13, (int)var3_8, (ArrayDecoders$Registers)var6_12);
            }
            case 12: 
            case 13: {
                n12 = ArrayDecoders.decodeVarint64(object, n13, (ArrayDecoders$Registers)var6_12);
                long l12 = var6_12.long1;
                Long l13 = l12;
                var6_12.object1 = l13;
                return n12;
            }
            case 9: 
            case 10: 
            case 11: {
                n12 = ArrayDecoders.decodeVarint32(object, n13, (ArrayDecoders$Registers)var6_12);
                n13 = var6_12.int1;
                Integer n16 = n13;
                var6_12.object1 = n16;
                return n12;
            }
            case 8: {
                float f10 = ArrayDecoders.decodeFloat(object, n13);
                Float f11 = Float.valueOf(f10);
                var6_12.object1 = f11;
                return n13 + 4;
            }
            case 6: 
            case 7: {
                long l14 = ArrayDecoders.decodeFixed64(object, n13);
                Long l15 = l14;
                var6_12.object1 = l15;
                return n13 + 8;
            }
            case 4: 
            case 5: {
                n12 = ArrayDecoders.decodeFixed32(object, n13);
                Integer n17 = n12;
                var6_12.object1 = n17;
                return n13 + 4;
            }
            case 3: {
                double d10 = ArrayDecoders.decodeDouble(object, n13);
                Double d11 = d10;
                var6_12.object1 = d11;
                return n13 + 8;
            }
            case 2: {
                return ArrayDecoders.decodeBytes(object, n13, (ArrayDecoders$Registers)var6_12);
            }
            case 1: 
        }
        n12 = ArrayDecoders.decodeVarint64(object, n13, (ArrayDecoders$Registers)var6_12);
        long l16 = var6_12.long1;
        long l17 = 0L;
        n13 = (int)(l16 == l17 ? 0 : (l16 < l17 ? -1 : 1));
        if (n13 != 0) {
            n13 = 1;
        } else {
            n13 = 0;
            bl2 = null;
        }
        bl2 = n13 != 0;
        var6_12.object1 = bl2;
        return n12;
    }

    private static double doubleAt(Object object, long l10) {
        return UnsafeUtil.getDouble(object, l10);
    }

    private boolean equals(Object object, Object object2, int n10) {
        double d10;
        long l10;
        double d11;
        long l11;
        long l12;
        long l13;
        int n11 = this.typeAndOffsetAt(n10);
        long l14 = MessageSchema.offset(n11);
        n11 = MessageSchema.type(n11);
        boolean bl2 = false;
        boolean bl3 = true;
        switch (n11) {
            default: {
                return bl3;
            }
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: 
            case 58: 
            case 59: 
            case 60: 
            case 61: 
            case 62: 
            case 63: 
            case 64: 
            case 65: 
            case 66: 
            case 67: 
            case 68: {
                boolean bl4;
                n10 = (int)(this.isOneofCaseEqual(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (bl4 = SchemaUtil.safeEquals(object = UnsafeUtil.getObject(object, l14), object2 = UnsafeUtil.getObject(object2, l14)))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 50: {
                object = UnsafeUtil.getObject(object, l14);
                object2 = UnsafeUtil.getObject(object2, l14);
                return SchemaUtil.safeEquals(object, object2);
            }
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 47: 
            case 48: 
            case 49: {
                object = UnsafeUtil.getObject(object, l14);
                object2 = UnsafeUtil.getObject(object2, l14);
                return SchemaUtil.safeEquals(object, object2);
            }
            case 17: {
                boolean bl5;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (bl5 = SchemaUtil.safeEquals(object = UnsafeUtil.getObject(object, l14), object2 = UnsafeUtil.getObject(object2, l14)))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 16: {
                long l15;
                long l16;
                long l17;
                long l18;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (l18 = (l17 = (l16 = UnsafeUtil.getLong(object, l14)) - (l15 = UnsafeUtil.getLong(object2, l14))) == 0L ? 0 : (l17 < 0L ? -1 : 1)) == false) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 15: {
                int n12;
                int n13;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (n13 = UnsafeUtil.getInt(object, l14)) == (n12 = UnsafeUtil.getInt(object2, l14))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 14: {
                long l19;
                long l20;
                long l21;
                long l22;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (l22 = (l21 = (l20 = UnsafeUtil.getLong(object, l14)) - (l19 = UnsafeUtil.getLong(object2, l14))) == 0L ? 0 : (l21 < 0L ? -1 : 1)) == false) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 13: {
                int n14;
                int n15;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (n15 = UnsafeUtil.getInt(object, l14)) == (n14 = UnsafeUtil.getInt(object2, l14))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 12: {
                int n16;
                int n17;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (n17 = UnsafeUtil.getInt(object, l14)) == (n16 = UnsafeUtil.getInt(object2, l14))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 11: {
                int n18;
                int n19;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (n19 = UnsafeUtil.getInt(object, l14)) == (n18 = UnsafeUtil.getInt(object2, l14))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 10: {
                boolean bl6;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (bl6 = SchemaUtil.safeEquals(object = UnsafeUtil.getObject(object, l14), object2 = UnsafeUtil.getObject(object2, l14)))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 9: {
                boolean bl7;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (bl7 = SchemaUtil.safeEquals(object = UnsafeUtil.getObject(object, l14), object2 = UnsafeUtil.getObject(object2, l14)))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 8: {
                boolean bl8;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (bl8 = SchemaUtil.safeEquals(object = UnsafeUtil.getObject(object, l14), object2 = UnsafeUtil.getObject(object2, l14)))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 7: {
                boolean bl9;
                boolean bl10;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (bl10 = UnsafeUtil.getBoolean(object, l14)) == (bl9 = UnsafeUtil.getBoolean(object2, l14))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 6: {
                int n20;
                int n21;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (n21 = UnsafeUtil.getInt(object, l14)) == (n20 = UnsafeUtil.getInt(object2, l14))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 5: {
                long l23;
                long l24;
                long l25;
                long l26;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (l26 = (l25 = (l24 = UnsafeUtil.getLong(object, l14)) - (l23 = UnsafeUtil.getLong(object2, l14))) == 0L ? 0 : (l25 < 0L ? -1 : 1)) == false) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 4: {
                int n22;
                int n23;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (n23 = UnsafeUtil.getInt(object, l14)) == (n22 = UnsafeUtil.getInt(object2, l14))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 3: {
                long l27;
                long l28;
                long l29;
                long l30;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (l30 = (l29 = (l28 = UnsafeUtil.getLong(object, l14)) - (l27 = UnsafeUtil.getLong(object2, l14))) == 0L ? 0 : (l29 < 0L ? -1 : 1)) == false) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 2: {
                long l31;
                long l32;
                long l33;
                long l34;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (l34 = (l33 = (l32 = UnsafeUtil.getLong(object, l14)) - (l31 = UnsafeUtil.getLong(object2, l14))) == 0L ? 0 : (l33 < 0L ? -1 : 1)) == false) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 1: {
                float f10;
                int n24;
                float f11;
                int n25;
                n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
                if (n10 != 0 && (n25 = Float.floatToIntBits(f11 = UnsafeUtil.getFloat(object, l14))) == (n24 = Float.floatToIntBits(f10 = UnsafeUtil.getFloat(object2, l14)))) {
                    bl2 = bl3;
                }
                return bl2;
            }
            case 0: 
        }
        n10 = (int)(this.arePresentForEquals(object, object2, n10) ? 1 : 0);
        if (n10 != 0 && (l13 = (l12 = (l11 = Double.doubleToLongBits(d11 = UnsafeUtil.getDouble(object, l14))) - (l10 = Double.doubleToLongBits(d10 = UnsafeUtil.getDouble(object2, l14)))) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            bl2 = bl3;
        }
        return bl2;
    }

    private final Object filterMapUnknownEnumValues(Object object, int n10, Object object2, UnknownFieldSchema unknownFieldSchema) {
        int n11 = this.numberAt(n10);
        int n12 = this.typeAndOffsetAt(n10);
        long l10 = MessageSchema.offset(n12);
        if ((object = UnsafeUtil.getObject(object, l10)) == null) {
            return object2;
        }
        Internal$EnumVerifier internal$EnumVerifier = this.getEnumFieldVerifier(n10);
        if (internal$EnumVerifier == null) {
            return object2;
        }
        Map map = this.mapFieldSchema.forMutableMapData(object);
        return this.filterUnknownEnumMap(n10, n11, map, internal$EnumVerifier, object2, unknownFieldSchema);
    }

    private final Object filterUnknownEnumMap(int n10, int n11, Map object, Internal$EnumVerifier internal$EnumVerifier, Object object2, UnknownFieldSchema unknownFieldSchema) {
        boolean bl2;
        Object object3 = this.mapFieldSchema;
        Object object4 = this.getMapFieldDefaultEntry(n10);
        object4 = object3.forMapMetadata(object4);
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object k10;
            object3 = (Map.Entry)object.next();
            Object object5 = (Integer)object3.getValue();
            int n12 = (Integer)object5;
            if ((n12 = (int)(internal$EnumVerifier.isInRange(n12) ? 1 : 0)) != 0) continue;
            if (object2 == null) {
                object2 = unknownFieldSchema.newBuilder();
            }
            object5 = object3.getKey();
            Object object6 = object3.getValue();
            n12 = MapEntryLite.computeSerializedSize((MapEntryLite$Metadata)object4, object5, object6);
            object5 = ByteString.newCodedBuilder(n12);
            object6 = ((ByteString$CodedBuilder)object5).getCodedOutput();
            try {
                k10 = object3.getKey();
            }
            catch (IOException iOException) {
                RuntimeException runtimeException = new RuntimeException(iOException);
                throw runtimeException;
            }
            object3 = object3.getValue();
            MapEntryLite.writeTo(object6, (MapEntryLite$Metadata)object4, k10, object3);
            object3 = ((ByteString$CodedBuilder)object5).build();
            unknownFieldSchema.addLengthDelimited(object2, n11, (ByteString)object3);
            object.remove();
        }
        return object2;
    }

    private static float floatAt(Object object, long l10) {
        return UnsafeUtil.getFloat(object, l10);
    }

    private Internal$EnumVerifier getEnumFieldVerifier(int n10) {
        Object[] objectArray = this.objects;
        n10 = n10 / 3 * 2 + 1;
        return (Internal$EnumVerifier)objectArray[n10];
    }

    private Object getMapFieldDefaultEntry(int n10) {
        Object[] objectArray = this.objects;
        n10 = n10 / 3 * 2;
        return objectArray[n10];
    }

    private Schema getMessageFieldSchema(int n10) {
        Object object = (Schema)this.objects[n10 = n10 / 3 * 2];
        if (object != null) {
            return object;
        }
        object = Protobuf.getInstance();
        Object object2 = this.objects;
        int n11 = n10 + 1;
        object2 = (Class)object2[n11];
        this.objects[n10] = object = ((Protobuf)object).schemaFor((Class)object2);
        return object;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object object) {
        object = (GeneratedMessageLite)object;
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite)object).unknownFields;
        UnknownFieldSetLite unknownFieldSetLite2 = UnknownFieldSetLite.getDefaultInstance();
        if (unknownFieldSetLite == unknownFieldSetLite2) {
            ((GeneratedMessageLite)object).unknownFields = unknownFieldSetLite = UnknownFieldSetLite.newInstance();
        }
        return unknownFieldSetLite;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private int getSerializedSizeProto2(Object var1_1) {
        var2_2 = this;
        var3_3 = var1_1;
        var4_4 = MessageSchema.UNSAFE;
        var5_5 = -1;
        var7_7 = 0;
        var8_8 = 0;
        for (var6_6 = 0; var6_6 < (var10_10 = (var9_9 /* !! */  = var2_2.buffer).length); var6_6 += 3) {
            block99: {
                block100: {
                    var10_10 = var2_2.typeAndOffsetAt(var6_6);
                    var11_11 = var2_2.numberAt(var6_6);
                    var12_12 = MessageSchema.type(var10_10);
                    var13_13 /* !! */  = 17;
                    var14_14 = 1048575;
                    var15_15 = 1;
                    if (var12_12 <= var13_13 /* !! */ ) {
                        var16_16 /* !! */  = var2_2.buffer;
                        var17_17 = var6_6 + 2;
                        var13_13 /* !! */  = (int)var16_16 /* !! */ [var17_17];
                        var17_17 = var13_13 /* !! */  >>> 20;
                        var18_18 = var17_17 = var15_15 << var17_17;
                        if ((var14_14 &= var13_13 /* !! */ ) != var5_5) {
                            var19_19 = var14_14;
                            var8_8 = var4_4.getInt(var3_3, var19_19);
                            var5_5 = var14_14;
                        }
                        var17_17 = var18_18;
                    } else {
                        var13_13 /* !! */  = (int)var2_2.useCachedSizeField;
                        if (var13_13 /* !! */  != 0 && var12_12 >= (var13_13 /* !! */  = (var16_16 /* !! */  = (int[])FieldType.DOUBLE_LIST_PACKED).id()) && var12_12 <= (var13_13 /* !! */  = (var16_16 /* !! */  = FieldType.SINT64_LIST_PACKED).id())) {
                            var16_16 /* !! */  = var2_2.buffer;
                            var15_15 = var6_6 + 2;
                            var13_13 /* !! */  = var16_16 /* !! */ [var15_15] & var14_14;
                        } else {
                            var13_13 /* !! */  = 0;
                            var16_16 /* !! */  = null;
                        }
                        var17_17 = 0;
                    }
                    var21_20 = MessageSchema.offset(var10_10);
                    var10_10 = 0;
                    var9_9 /* !! */  = null;
                    var23_21 = var5_5;
                    var24_22 = 0L;
                    var26_23 = 0.0;
                    switch (var12_12) {
                        default: {
                            ** GOTO lbl425
                        }
                        case 68: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var29_25 = (MessageLite)var4_4.getObject(var3_3, var21_20);
                            var30_26 = var2_2.getMessageFieldSchema(var6_6);
                            var28_24 = CodedOutputStream.computeGroupSize(var11_11, (MessageLite)var29_25, (Schema)var30_26);
                            ** GOTO lbl423
                        }
                        case 67: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var24_22 = MessageSchema.oneofLongAt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeSInt64Size(var11_11, var24_22);
                            ** GOTO lbl423
                        }
                        case 66: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = MessageSchema.oneofIntAt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeSInt32Size(var11_11, var28_24);
                            ** GOTO lbl423
                        }
                        case 65: {
                            var10_10 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var10_10 == 0) ** GOTO lbl425
                            var28_24 = CodedOutputStream.computeSFixed64Size(var11_11, var24_22);
                            ** GOTO lbl423
                        }
                        case 64: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = 0;
                            var29_25 = null;
                            var5_5 = CodedOutputStream.computeSFixed32Size(var11_11, 0);
                            ** GOTO lbl458
                        }
                        case 63: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = MessageSchema.oneofIntAt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeEnumSize(var11_11, var28_24);
                            ** GOTO lbl423
                        }
                        case 62: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = MessageSchema.oneofIntAt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeUInt32Size(var11_11, var28_24);
                            ** GOTO lbl423
                        }
                        case 61: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var29_25 = (ByteString)var4_4.getObject(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeBytesSize(var11_11, (ByteString)var29_25);
                            ** GOTO lbl423
                        }
                        case 60: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var29_25 = var4_4.getObject(var3_3, var21_20);
                            var30_26 = var2_2.getMessageFieldSchema(var6_6);
                            var28_24 = SchemaUtil.computeSizeMessage(var11_11, var29_25, (Schema)var30_26);
                            ** GOTO lbl423
                        }
                        case 59: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var29_25 = var4_4.getObject(var3_3, var21_20);
                            var5_5 = var29_25 instanceof ByteString;
                            if (var5_5 != 0) {
                                var29_25 = (ByteString)var29_25;
                                var28_24 = CodedOutputStream.computeBytesSize(var11_11, (ByteString)var29_25);
                            } else {
                                var29_25 = (String)var29_25;
                                var28_24 = CodedOutputStream.computeStringSize(var11_11, (String)var29_25);
                            }
                            ** GOTO lbl423
                        }
                        case 58: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = CodedOutputStream.computeBoolSize(var11_11, true);
                            ** GOTO lbl423
                        }
                        case 57: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = 0;
                            var29_25 = null;
                            var5_5 = CodedOutputStream.computeFixed32Size(var11_11, 0);
                            ** GOTO lbl458
                        }
                        case 56: {
                            var10_10 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var10_10 == 0) ** GOTO lbl425
                            var28_24 = CodedOutputStream.computeFixed64Size(var11_11, var24_22);
                            ** GOTO lbl423
                        }
                        case 55: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = MessageSchema.oneofIntAt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeInt32Size(var11_11, var28_24);
                            ** GOTO lbl423
                        }
                        case 54: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var24_22 = MessageSchema.oneofLongAt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeUInt64Size(var11_11, var24_22);
                            ** GOTO lbl423
                        }
                        case 53: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var24_22 = MessageSchema.oneofLongAt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeInt64Size(var11_11, var24_22);
                            ** GOTO lbl423
                        }
                        case 52: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = CodedOutputStream.computeFloatSize(var11_11, 0.0f);
                            ** GOTO lbl423
                        }
                        case 51: {
                            var28_24 = (int)var2_2.isOneofPresent(var3_3, var11_11, var6_6);
                            if (var28_24 == 0) ** GOTO lbl425
                            var24_22 = 0L;
                            var26_23 = 0.0;
                            var28_24 = CodedOutputStream.computeDoubleSize(var11_11, var26_23);
                            ** GOTO lbl423
                        }
                        case 50: {
                            var29_25 = var2_2.mapFieldSchema;
                            var30_26 = var4_4.getObject(var3_3, var21_20);
                            var9_9 /* !! */  = (int[])var2_2.getMapFieldDefaultEntry(var6_6);
                            var28_24 = var29_25.getSerializedSize(var11_11, var30_26, var9_9 /* !! */ );
                            ** GOTO lbl423
                        }
                        case 49: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var30_26 = var2_2.getMessageFieldSchema(var6_6);
                            var28_24 = SchemaUtil.computeSizeGroupList(var11_11, (List)var29_25, (Schema)var30_26);
                            ** GOTO lbl423
                        }
                        case 48: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeSInt64ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 47: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeSInt32ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 46: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed64ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 45: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed32ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 44: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeEnumListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 43: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeUInt32ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 42: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeBoolListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 41: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed32ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 40: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed64ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 39: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeInt32ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 38: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeUInt64ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 37: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeInt64ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 36: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed32ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
                            ** GOTO lbl323
                        }
                        case 35: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed64ListNoTag((List)var29_25);
                            if (var28_24 <= 0) ** GOTO lbl425
                            var5_5 = (int)var2_2.useCachedSizeField;
                            if (var5_5 != 0) {
                                var31_27 = var13_13 /* !! */ ;
                                var4_4.putInt(var3_3, var31_27, var28_24);
                            }
                            var5_5 = CodedOutputStream.computeTagSize(var11_11);
                            var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var28_24);
lbl323:
                            // 14 sources

                            var5_5 = var5_5 + var10_10 + var28_24;
                            ** GOTO lbl458
                        }
                        case 34: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var5_5 = 0;
                            var30_26 = null;
                            var28_24 = SchemaUtil.computeSizeSInt64List(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 33: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeSInt32List(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 32: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed64List(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 31: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed32List(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 30: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeEnumList(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 29: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeUInt32List(var11_11, (List)var29_25, false);
                            ** GOTO lbl423
                        }
                        case 28: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeByteStringList(var11_11, (List)var29_25);
                            ** GOTO lbl423
                        }
                        case 27: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var30_26 = var2_2.getMessageFieldSchema(var6_6);
                            var28_24 = SchemaUtil.computeSizeMessageList(var11_11, (List)var29_25, (Schema)var30_26);
                            ** GOTO lbl423
                        }
                        case 26: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeStringList(var11_11, (List)var29_25);
                            ** GOTO lbl423
                        }
                        case 25: {
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var5_5 = 0;
                            var30_26 = null;
                            var28_24 = SchemaUtil.computeSizeBoolList(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 24: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed32List(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 23: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed64List(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 22: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeInt32List(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 21: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeUInt64List(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 20: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeInt64List(var11_11, (List)var29_25, false);
                            ** GOTO lbl415
                        }
                        case 19: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed32List(var11_11, (List)var29_25, false);
lbl415:
                            // 12 sources

                            var7_7 += var28_24;
                            var12_12 = 0;
                            break block99;
                        }
                        case 18: {
                            var5_5 = 0;
                            var30_26 = null;
                            var29_25 = (List)var4_4.getObject(var3_3, var21_20);
                            var28_24 = SchemaUtil.computeSizeFixed64List(var11_11, (List)var29_25, false);
lbl423:
                            // 35 sources

                            while (true) {
                                var7_7 += var28_24;
lbl425:
                                // 47 sources

                                while (true) {
                                    var12_12 = 0;
                                    break block99;
                                    break;
                                }
                                break;
                            }
                        }
                        case 17: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) ** GOTO lbl425
                            var29_25 = (MessageLite)var4_4.getObject(var3_3, var21_20);
                            var30_26 = var2_2.getMessageFieldSchema(var6_6);
                            var28_24 = CodedOutputStream.computeGroupSize(var11_11, (MessageLite)var29_25, (Schema)var30_26);
                            ** GOTO lbl423
                        }
                        case 16: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) ** GOTO lbl425
                            var24_22 = var4_4.getLong(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeSInt64Size(var11_11, var24_22);
                            ** GOTO lbl423
                        }
                        case 15: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = var4_4.getInt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeSInt32Size(var11_11, var28_24);
                            ** GOTO lbl423
                        }
                        case 14: {
                            var10_10 = var8_8 & var17_17;
                            if (var10_10 == 0) ** GOTO lbl425
                            var28_24 = CodedOutputStream.computeSFixed64Size(var11_11, var24_22);
                            ** GOTO lbl423
                        }
                        case 13: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = 0;
                            var29_25 = null;
                            var5_5 = CodedOutputStream.computeSFixed32Size(var11_11, 0);
lbl458:
                            // 4 sources

                            var7_7 += var5_5;
                            ** GOTO lbl425
                        }
                        case 12: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = var4_4.getInt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeEnumSize(var11_11, var28_24);
                            ** GOTO lbl423
                        }
                        case 11: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = var4_4.getInt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeUInt32Size(var11_11, var28_24);
                            ** GOTO lbl423
                        }
                        case 10: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) ** GOTO lbl425
                            var29_25 = (ByteString)var4_4.getObject(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeBytesSize(var11_11, (ByteString)var29_25);
                            ** GOTO lbl423
                        }
                        case 9: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) ** GOTO lbl425
                            var29_25 = var4_4.getObject(var3_3, var21_20);
                            var30_26 = var2_2.getMessageFieldSchema(var6_6);
                            var28_24 = SchemaUtil.computeSizeMessage(var11_11, var29_25, (Schema)var30_26);
                            ** GOTO lbl423
                        }
                        case 8: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) ** GOTO lbl425
                            var29_25 = var4_4.getObject(var3_3, var21_20);
                            var5_5 = var29_25 instanceof ByteString;
                            if (var5_5 == 0) ** GOTO lbl494
                            var29_25 = (ByteString)var29_25;
                            var28_24 = CodedOutputStream.computeBytesSize(var11_11, (ByteString)var29_25);
                            ** GOTO lbl423
lbl494:
                            // 1 sources

                            var29_25 = (String)var29_25;
                            var28_24 = CodedOutputStream.computeStringSize(var11_11, (String)var29_25);
                            ** GOTO lbl423
                        }
                        case 7: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) ** GOTO lbl425
                            var28_24 = CodedOutputStream.computeBoolSize(var11_11, true);
                            ** continue;
                        }
                        case 6: {
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 != 0) ** break;
                            ** continue;
                            var12_12 = 0;
                            var28_24 = CodedOutputStream.computeFixed32Size(var11_11, 0);
                            break block100;
                        }
                        case 5: {
                            var12_12 = 0;
                            var10_10 = var8_8 & var17_17;
                            if (var10_10 == 0) break block99;
                            var28_24 = CodedOutputStream.computeFixed64Size(var11_11, var24_22);
                            break block100;
                        }
                        case 4: {
                            var12_12 = 0;
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) break block99;
                            var28_24 = var4_4.getInt(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeInt32Size(var11_11, var28_24);
                            break block100;
                        }
                        case 3: {
                            var12_12 = 0;
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) break block99;
                            var24_22 = var4_4.getLong(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeUInt64Size(var11_11, var24_22);
                            break block100;
                        }
                        case 2: {
                            var12_12 = 0;
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) break block99;
                            var24_22 = var4_4.getLong(var3_3, var21_20);
                            var28_24 = CodedOutputStream.computeInt64Size(var11_11, var24_22);
                            break block100;
                        }
                        case 1: {
                            var12_12 = 0;
                            var28_24 = var8_8 & var17_17;
                            if (var28_24 == 0) break block99;
                            var28_24 = CodedOutputStream.computeFloatSize(var11_11, 0.0f);
                            break block100;
                        }
                        case 0: 
                    }
                    var12_12 = 0;
                    var28_24 = var8_8 & var17_17;
                    if (var28_24 == 0) break block99;
                    var24_22 = 0L;
                    var26_23 = 0.0;
                    var28_24 = CodedOutputStream.computeDoubleSize(var11_11, var26_23);
                }
                var7_7 += var28_24;
            }
            var5_5 = var23_21;
        }
        var4_4 = var2_2.unknownFieldSchema;
        var33_28 = var2_2.getUnknownFieldsSerializedSize((UnknownFieldSchema)var4_4, var3_3);
        var7_7 += var33_28;
        var33_28 = (int)var2_2.hasExtensions;
        if (var33_28 != 0) {
            var4_4 = var2_2.extensionSchema;
            var3_3 = var4_4.getExtensions(var3_3);
            var34_29 = var3_3.getSerializedSize();
            var7_7 += var34_29;
        }
        return var7_7;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private int getSerializedSizeProto3(Object var1_1) {
        var2_2 = this;
        var3_3 = var1_1;
        var4_4 = MessageSchema.UNSAFE;
        var6_6 = 0;
        block71: for (var5_5 = 0; var5_5 < (var8_8 = (var7_7 /* !! */  = var2_2.buffer).length); var5_5 += 3) {
            var8_8 = this.typeAndOffsetAt(var5_5);
            var9_9 = MessageSchema.type(var8_8);
            var10_10 = this.numberAt(var5_5);
            var11_11 = MessageSchema.offset(var8_8);
            var7_7 /* !! */  = (int[])FieldType.DOUBLE_LIST_PACKED;
            var8_8 = var7_7 /* !! */ .id();
            if (var9_9 >= var8_8 && var9_9 <= (var8_8 = (var7_7 /* !! */  = FieldType.SINT64_LIST_PACKED).id())) {
                var7_7 /* !! */  = var2_2.buffer;
                var13_12 = var5_5 + 2;
                var8_8 = var7_7 /* !! */ [var13_12];
                var13_12 = 1048575;
                var8_8 &= var13_12;
            } else {
                var8_8 = 0;
                var7_7 /* !! */  = null;
            }
            var13_12 = 1;
            var14_13 = 0L;
            switch (var9_9) {
                default: {
                    continue block71;
                }
                case 68: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var7_7 /* !! */  = (int[])((MessageLite)UnsafeUtil.getObject(var3_3, var11_11));
                    var16_14 = this.getMessageFieldSchema(var5_5);
                    var8_8 = CodedOutputStream.computeGroupSize(var10_10, (MessageLite)var7_7 /* !! */ , (Schema)var16_14);
                    ** GOTO lbl371
                }
                case 67: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var17_15 = MessageSchema.oneofLongAt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeSInt64Size(var10_10, var17_15);
                    ** GOTO lbl371
                }
                case 66: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = MessageSchema.oneofIntAt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeSInt32Size(var10_10, var8_8);
                    ** GOTO lbl371
                }
                case 65: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeSFixed64Size(var10_10, var14_13);
                    ** GOTO lbl371
                }
                case 64: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeSFixed32Size(var10_10, 0);
                    ** GOTO lbl371
                }
                case 63: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = MessageSchema.oneofIntAt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeEnumSize(var10_10, var8_8);
                    ** GOTO lbl371
                }
                case 62: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = MessageSchema.oneofIntAt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeUInt32Size(var10_10, var8_8);
                    ** GOTO lbl371
                }
                case 61: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var7_7 /* !! */  = (int[])((ByteString)UnsafeUtil.getObject(var3_3, var11_11));
                    var8_8 = CodedOutputStream.computeBytesSize(var10_10, (ByteString)var7_7 /* !! */ );
                    ** GOTO lbl371
                }
                case 60: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var7_7 /* !! */  = (int[])UnsafeUtil.getObject(var3_3, var11_11);
                    var16_14 = this.getMessageFieldSchema(var5_5);
                    var8_8 = SchemaUtil.computeSizeMessage(var10_10, var7_7 /* !! */ , (Schema)var16_14);
                    ** GOTO lbl371
                }
                case 59: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var7_7 /* !! */  = (int[])UnsafeUtil.getObject(var3_3, var11_11);
                    var9_9 = var7_7 /* !! */  instanceof ByteString;
                    if (var9_9 != 0) {
                        var7_7 /* !! */  = (int[])((ByteString)var7_7 /* !! */ );
                        var8_8 = CodedOutputStream.computeBytesSize(var10_10, (ByteString)var7_7 /* !! */ );
                    } else {
                        var7_7 /* !! */  = (int[])((String)var7_7 /* !! */ );
                        var8_8 = CodedOutputStream.computeStringSize(var10_10, (String)var7_7 /* !! */ );
                    }
                    ** GOTO lbl371
                }
                case 58: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeBoolSize(var10_10, (boolean)var13_12);
                    ** GOTO lbl371
                }
                case 57: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeFixed32Size(var10_10, 0);
                    ** GOTO lbl371
                }
                case 56: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeFixed64Size(var10_10, var14_13);
                    ** GOTO lbl371
                }
                case 55: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = MessageSchema.oneofIntAt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeInt32Size(var10_10, var8_8);
                    ** GOTO lbl371
                }
                case 54: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var17_15 = MessageSchema.oneofLongAt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeUInt64Size(var10_10, var17_15);
                    ** GOTO lbl371
                }
                case 53: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var17_15 = MessageSchema.oneofLongAt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeInt64Size(var10_10, var17_15);
                    ** GOTO lbl371
                }
                case 52: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeFloatSize(var10_10, 0.0f);
                    ** GOTO lbl371
                }
                case 51: {
                    var8_8 = (int)this.isOneofPresent(var3_3, var10_10, var5_5);
                    if (var8_8 == 0) continue block71;
                    var17_15 = 0L;
                    var19_16 = 0.0;
                    var8_8 = CodedOutputStream.computeDoubleSize(var10_10, var19_16);
                    ** GOTO lbl371
                }
                case 50: {
                    var7_7 /* !! */  = (int[])var2_2.mapFieldSchema;
                    var16_14 = UnsafeUtil.getObject(var3_3, var11_11);
                    var21_17 = this.getMapFieldDefaultEntry(var5_5);
                    var8_8 = var7_7 /* !! */ .getSerializedSize(var10_10, var16_14, var21_17);
                    ** GOTO lbl371
                }
                case 49: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var16_14 = this.getMessageFieldSchema(var5_5);
                    var8_8 = SchemaUtil.computeSizeGroupList(var10_10, (List)var7_7 /* !! */ , (Schema)var16_14);
                    ** GOTO lbl371
                }
                case 48: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeSInt64ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 47: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeSInt32ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 46: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeFixed64ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 45: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeFixed32ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 44: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeEnumListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 43: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeUInt32ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 42: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeBoolListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 41: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeFixed32ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 40: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeFixed64ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 39: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeInt32ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 38: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeUInt64ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 37: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeInt64ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 36: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeFixed32ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
                    ** GOTO lbl301
                }
                case 35: {
                    var16_14 = (List)var4_4.getObject(var3_3, var11_11);
                    var9_9 = SchemaUtil.computeSizeFixed64ListNoTag((List)var16_14);
                    if (var9_9 <= 0) continue block71;
                    var22_18 = var2_2.useCachedSizeField;
                    if (var22_18) {
                        var11_11 = var8_8;
                        var4_4.putInt(var3_3, var11_11, var9_9);
                    }
                    var8_8 = CodedOutputStream.computeTagSize(var10_10);
                    var10_10 = CodedOutputStream.computeUInt32SizeNoTag(var9_9);
lbl301:
                    // 14 sources

                    var8_8 = var8_8 + var10_10 + var9_9;
                    ** GOTO lbl371
                }
                case 34: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeSInt64List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 33: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeSInt32List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 32: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeFixed64List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 31: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeFixed32List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 30: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeEnumList(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 29: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeUInt32List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 28: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeByteStringList(var10_10, (List)var7_7 /* !! */ );
                    ** GOTO lbl371
                }
                case 27: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var16_14 = this.getMessageFieldSchema(var5_5);
                    var8_8 = SchemaUtil.computeSizeMessageList(var10_10, (List)var7_7 /* !! */ , (Schema)var16_14);
                    ** GOTO lbl371
                }
                case 26: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeStringList(var10_10, (List)var7_7 /* !! */ );
                    ** GOTO lbl371
                }
                case 25: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeBoolList(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 24: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeFixed32List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 23: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeFixed64List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 22: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeInt32List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 21: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeUInt64List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 20: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeInt64List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 19: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeFixed32List(var10_10, (List)var7_7 /* !! */ , false);
                    ** GOTO lbl371
                }
                case 18: {
                    var7_7 /* !! */  = (int[])MessageSchema.listAt(var3_3, var11_11);
                    var8_8 = SchemaUtil.computeSizeFixed64List(var10_10, (List)var7_7 /* !! */ , false);
lbl371:
                    // 58 sources

                    while (true) {
                        var6_6 += var8_8;
                        continue block71;
                        break;
                    }
                }
                case 17: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var7_7 /* !! */  = (int[])((MessageLite)UnsafeUtil.getObject(var3_3, var11_11));
                    var16_14 = this.getMessageFieldSchema(var5_5);
                    var8_8 = CodedOutputStream.computeGroupSize(var10_10, (MessageLite)var7_7 /* !! */ , (Schema)var16_14);
                    ** GOTO lbl371
                }
                case 16: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var17_15 = UnsafeUtil.getLong(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeSInt64Size(var10_10, var17_15);
                    ** GOTO lbl371
                }
                case 15: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = UnsafeUtil.getInt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeSInt32Size(var10_10, var8_8);
                    ** GOTO lbl371
                }
                case 14: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeSFixed64Size(var10_10, var14_13);
                    ** GOTO lbl371
                }
                case 13: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeSFixed32Size(var10_10, 0);
                    ** GOTO lbl371
                }
                case 12: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = UnsafeUtil.getInt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeEnumSize(var10_10, var8_8);
                    ** GOTO lbl371
                }
                case 11: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = UnsafeUtil.getInt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeUInt32Size(var10_10, var8_8);
                    ** GOTO lbl371
                }
                case 10: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var7_7 /* !! */  = (int[])((ByteString)UnsafeUtil.getObject(var3_3, var11_11));
                    var8_8 = CodedOutputStream.computeBytesSize(var10_10, (ByteString)var7_7 /* !! */ );
                    ** GOTO lbl371
                }
                case 9: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var7_7 /* !! */  = (int[])UnsafeUtil.getObject(var3_3, var11_11);
                    var16_14 = this.getMessageFieldSchema(var5_5);
                    var8_8 = SchemaUtil.computeSizeMessage(var10_10, var7_7 /* !! */ , (Schema)var16_14);
                    ** GOTO lbl371
                }
                case 8: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var7_7 /* !! */  = (int[])UnsafeUtil.getObject(var3_3, var11_11);
                    var9_9 = var7_7 /* !! */  instanceof ByteString;
                    if (var9_9 == 0) ** GOTO lbl437
                    var7_7 /* !! */  = (int[])((ByteString)var7_7 /* !! */ );
                    var8_8 = CodedOutputStream.computeBytesSize(var10_10, (ByteString)var7_7 /* !! */ );
                    ** GOTO lbl371
lbl437:
                    // 1 sources

                    var7_7 /* !! */  = (int[])((String)var7_7 /* !! */ );
                    var8_8 = CodedOutputStream.computeStringSize(var10_10, (String)var7_7 /* !! */ );
                    ** GOTO lbl371
                }
                case 7: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeBoolSize(var10_10, (boolean)var13_12);
                    ** GOTO lbl371
                }
                case 6: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeFixed32Size(var10_10, 0);
                    ** GOTO lbl371
                }
                case 5: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeFixed64Size(var10_10, var14_13);
                    ** GOTO lbl371
                }
                case 4: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = UnsafeUtil.getInt(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeInt32Size(var10_10, var8_8);
                    ** GOTO lbl371
                }
                case 3: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var17_15 = UnsafeUtil.getLong(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeUInt64Size(var10_10, var17_15);
                    ** GOTO lbl371
                }
                case 2: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var17_15 = UnsafeUtil.getLong(var3_3, var11_11);
                    var8_8 = CodedOutputStream.computeInt64Size(var10_10, var17_15);
                    ** GOTO lbl371
                }
                case 1: {
                    var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
                    if (var8_8 == 0) continue block71;
                    var8_8 = CodedOutputStream.computeFloatSize(var10_10, 0.0f);
                    ** GOTO lbl371
                }
                case 0: 
            }
            var8_8 = (int)this.isFieldPresent(var3_3, var5_5);
            if (var8_8 == 0) continue;
            var17_15 = 0L;
            var19_16 = 0.0;
            var8_8 = CodedOutputStream.computeDoubleSize(var10_10, var19_16);
            ** continue;
        }
        var4_4 = var2_2.unknownFieldSchema;
        var23_19 = this.getUnknownFieldsSerializedSize((UnknownFieldSchema)var4_4, var3_3);
        return var6_6 + var23_19;
    }

    private int getUnknownFieldsSerializedSize(UnknownFieldSchema unknownFieldSchema, Object object) {
        object = unknownFieldSchema.getFromMessage(object);
        return unknownFieldSchema.getSerializedSize(object);
    }

    private static int intAt(Object object, long l10) {
        return UnsafeUtil.getInt(object, l10);
    }

    private static boolean isEnforceUtf8(int n10) {
        int n11 = 0x20000000;
        n10 = (n10 &= n11) != 0 ? 1 : 0;
        return n10 != 0;
    }

    private boolean isFieldPresent(Object object, int n10) {
        int n11 = this.proto3;
        int n12 = 0;
        int n13 = 1;
        if (n11 != 0) {
            n10 = this.typeAndOffsetAt(n10);
            long l10 = MessageSchema.offset(n10);
            n10 = MessageSchema.type(n10);
            long l11 = 0L;
            switch (n10) {
                default: {
                    object = new IllegalArgumentException();
                    throw object;
                }
                case 17: {
                    object = UnsafeUtil.getObject(object, l10);
                    if (object != null) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 16: {
                    long l12 = UnsafeUtil.getLong(object, l10);
                    long l13 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                    if (l13 != false) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 15: {
                    int n14 = UnsafeUtil.getInt(object, l10);
                    if (n14 != 0) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 14: {
                    long l14 = UnsafeUtil.getLong(object, l10);
                    long l15 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
                    if (l15 != false) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 13: {
                    int n15 = UnsafeUtil.getInt(object, l10);
                    if (n15 != 0) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 12: {
                    int n16 = UnsafeUtil.getInt(object, l10);
                    if (n16 != 0) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 11: {
                    int n17 = UnsafeUtil.getInt(object, l10);
                    if (n17 != 0) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 10: {
                    ByteString byteString = ByteString.EMPTY;
                    object = UnsafeUtil.getObject(object, l10);
                    return byteString.equals(object) ^ n13;
                }
                case 9: {
                    object = UnsafeUtil.getObject(object, l10);
                    if (object != null) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 8: {
                    object = UnsafeUtil.getObject(object, l10);
                    n10 = object instanceof String;
                    if (n10 != 0) {
                        return ((String)object).isEmpty() ^ n13;
                    }
                    n10 = object instanceof ByteString;
                    if (n10 != 0) {
                        return ByteString.EMPTY.equals(object) ^ n13;
                    }
                    object = new IllegalArgumentException();
                    throw object;
                }
                case 7: {
                    return UnsafeUtil.getBoolean(object, l10);
                }
                case 6: {
                    int n18 = UnsafeUtil.getInt(object, l10);
                    if (n18 != 0) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 5: {
                    long l16 = UnsafeUtil.getLong(object, l10);
                    long l17 = l16 == l11 ? 0 : (l16 < l11 ? -1 : 1);
                    if (l17 != false) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 4: {
                    int n19 = UnsafeUtil.getInt(object, l10);
                    if (n19 != 0) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 3: {
                    long l18 = UnsafeUtil.getLong(object, l10);
                    long l19 = l18 == l11 ? 0 : (l18 < l11 ? -1 : 1);
                    if (l19 != false) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 2: {
                    long l20 = UnsafeUtil.getLong(object, l10);
                    long l21 = l20 == l11 ? 0 : (l20 < l11 ? -1 : 1);
                    if (l21 != false) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 1: {
                    float f10 = UnsafeUtil.getFloat(object, l10);
                    n10 = 0;
                    Object var13_29 = null;
                    float f11 = f10 - 0.0f;
                    float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
                    if (f12 != false) {
                        n12 = n13;
                    }
                    return n12 != 0;
                }
                case 0: 
            }
            double d10 = UnsafeUtil.getDouble(object, l10);
            l10 = 0L;
            double d11 = 0.0;
            double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
            if (d12 != false) {
                n12 = n13;
            }
            return n12 != 0;
        }
        n10 = this.presenceMaskAndOffsetAt(n10);
        n11 = n10 >>> 20;
        n11 = n13 << n11;
        int n20 = 1048575;
        long l22 = n10 &= n20;
        int n21 = UnsafeUtil.getInt(object, l22) & n11;
        if (n21 != 0) {
            n12 = n13;
        }
        return n12 != 0;
    }

    private boolean isFieldPresent(Object object, int n10, int n11, int n12) {
        boolean bl2 = this.proto3;
        if (bl2) {
            return this.isFieldPresent(object, n10);
        }
        int n13 = n11 & n12;
        if (n13) {
            n13 = 1;
        } else {
            n13 = 0;
            object = null;
        }
        return n13 != 0;
    }

    private static boolean isInitialized(Object object, int n10, Schema schema) {
        long l10 = MessageSchema.offset(n10);
        object = UnsafeUtil.getObject(object, l10);
        return schema.isInitialized(object);
    }

    private boolean isListInitialized(Object object, int n10, int n11) {
        int n12;
        long l10 = MessageSchema.offset(n10);
        object = (List)UnsafeUtil.getObject(object, l10);
        n10 = (int)(object.isEmpty() ? 1 : 0);
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        Schema schema = this.getMessageFieldSchema(n11);
        n11 = 0;
        for (int i10 = 0; i10 < (n12 = object.size()); ++i10) {
            Object e10 = object.get(i10);
            n12 = (int)(schema.isInitialized(e10) ? 1 : 0);
            if (n12 != 0) continue;
            return false;
        }
        return bl2;
    }

    private boolean isMapInitialized(Object iterator2, int n10, int n11) {
        WireFormat$JavaType wireFormat$JavaType;
        MapFieldSchema mapFieldSchema = this.mapFieldSchema;
        long l10 = MessageSchema.offset(n10);
        iterator2 = UnsafeUtil.getObject(iterator2, l10);
        iterator2 = mapFieldSchema.forMapData(iterator2);
        n10 = (int)(iterator2.isEmpty() ? 1 : 0);
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        Object object = this.getMapFieldDefaultEntry(n11);
        object = this.mapFieldSchema.forMapMetadata((Object)object).valueType.getJavaType();
        if (object != (wireFormat$JavaType = WireFormat$JavaType.MESSAGE)) {
            return bl2;
        }
        n10 = 0;
        object = null;
        iterator2 = iterator2.values().iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            wireFormat$JavaType = iterator2.next();
            if (object == null) {
                object = Protobuf.getInstance();
                Class<?> clazz = ((Object)((Object)wireFormat$JavaType)).getClass();
                object = ((Protobuf)object).schemaFor(clazz);
            }
            if ((n11 = (int)(object.isInitialized((Object)wireFormat$JavaType) ? 1 : 0)) != 0) continue;
            return false;
        }
        return bl2;
    }

    private boolean isOneofCaseEqual(Object object, Object object2, int n10) {
        int n11;
        n10 = this.presenceMaskAndOffsetAt(n10);
        int n12 = 1048575;
        long l10 = n10 &= n12;
        int n13 = UnsafeUtil.getInt(object, l10);
        if (n13 == (n11 = UnsafeUtil.getInt(object2, l10))) {
            n13 = 1;
        } else {
            n13 = 0;
            object = null;
        }
        return n13 != 0;
    }

    private boolean isOneofPresent(Object object, int n10, int n11) {
        n11 = this.presenceMaskAndOffsetAt(n11);
        int n12 = 1048575;
        long l10 = n11 &= n12;
        int n13 = UnsafeUtil.getInt(object, l10);
        if (n13 == n10) {
            n13 = 1;
        } else {
            n13 = 0;
            object = null;
        }
        return n13 != 0;
    }

    private static boolean isRequired(int n10) {
        int n11 = 0x10000000;
        n10 = (n10 &= n11) != 0 ? 1 : 0;
        return n10 != 0;
    }

    private static List listAt(Object object, long l10) {
        return (List)UnsafeUtil.getObject(object, l10);
    }

    private static long longAt(Object object, long l10) {
        return UnsafeUtil.getLong(object, l10);
    }

    /*
     * Exception decompiling
     */
    private void mergeFromHelper(UnknownFieldSchema var1_1, ExtensionSchema var2_2, Object var3_3, Reader var4_4, ExtensionRegistryLite var5_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [277[CASE]], but top level block is 18[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private final void mergeMap(Object object, int n10, Object object2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long l10 = MessageSchema.offset(n10 = this.typeAndOffsetAt(n10));
        Object object3 = UnsafeUtil.getObject(object, l10);
        if (object3 == null) {
            object3 = this.mapFieldSchema.newMapField(object2);
            UnsafeUtil.putObject(object, l10, object3);
        } else {
            Object object4 = this.mapFieldSchema;
            boolean bl2 = object4.isImmutable(object3);
            if (bl2) {
                object4 = this.mapFieldSchema.newMapField(object2);
                MapFieldSchema mapFieldSchema = this.mapFieldSchema;
                mapFieldSchema.mergeFrom(object4, object3);
                UnsafeUtil.putObject(object, l10, object4);
                object3 = object4;
            }
        }
        object = this.mapFieldSchema.forMutableMapData(object3);
        object3 = this.mapFieldSchema.forMapMetadata(object2);
        reader.readMap((Map)object, (MapEntryLite$Metadata)object3, extensionRegistryLite);
    }

    private void mergeMessage(Object object, Object object2, int n10) {
        int n11 = this.typeAndOffsetAt(n10);
        long l10 = MessageSchema.offset(n11);
        boolean bl2 = this.isFieldPresent(object2, n10);
        if (!bl2) {
            return;
        }
        Object object3 = UnsafeUtil.getObject(object, l10);
        object2 = UnsafeUtil.getObject(object2, l10);
        if (object3 != null && object2 != null) {
            object2 = Internal.mergeMessage(object3, object2);
            UnsafeUtil.putObject(object, l10, object2);
            this.setFieldPresent(object, n10);
        } else if (object2 != null) {
            UnsafeUtil.putObject(object, l10, object2);
            this.setFieldPresent(object, n10);
        }
    }

    private void mergeOneofMessage(Object object, Object object2, int n10) {
        int n11 = this.typeAndOffsetAt(n10);
        int n12 = this.numberAt(n10);
        long l10 = MessageSchema.offset(n11);
        n11 = (int)(this.isOneofPresent(object2, n12, n10) ? 1 : 0);
        if (n11 == 0) {
            return;
        }
        Object object3 = UnsafeUtil.getObject(object, l10);
        object2 = UnsafeUtil.getObject(object2, l10);
        if (object3 != null && object2 != null) {
            object2 = Internal.mergeMessage(object3, object2);
            UnsafeUtil.putObject(object, l10, object2);
            this.setOneofPresent(object, n12, n10);
        } else if (object2 != null) {
            UnsafeUtil.putObject(object, l10, object2);
            this.setOneofPresent(object, n12, n10);
        }
    }

    private void mergeSingleField(Object object, Object object2, int n10) {
        int n11 = this.typeAndOffsetAt(n10);
        long l10 = MessageSchema.offset(n11);
        int n12 = this.numberAt(n10);
        n11 = MessageSchema.type(n11);
        switch (n11) {
            default: {
                break;
            }
            case 68: {
                this.mergeOneofMessage(object, object2, n10);
                break;
            }
            case 61: 
            case 62: 
            case 63: 
            case 64: 
            case 65: 
            case 66: 
            case 67: {
                n11 = (int)(this.isOneofPresent(object2, n12, n10) ? 1 : 0);
                if (n11 == 0) break;
                object2 = UnsafeUtil.getObject(object2, l10);
                UnsafeUtil.putObject(object, l10, object2);
                this.setOneofPresent(object, n12, n10);
                break;
            }
            case 60: {
                this.mergeOneofMessage(object, object2, n10);
                break;
            }
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: 
            case 58: 
            case 59: {
                n11 = (int)(this.isOneofPresent(object2, n12, n10) ? 1 : 0);
                if (n11 == 0) break;
                object2 = UnsafeUtil.getObject(object2, l10);
                UnsafeUtil.putObject(object, l10, object2);
                this.setOneofPresent(object, n12, n10);
                break;
            }
            case 50: {
                MapFieldSchema mapFieldSchema = this.mapFieldSchema;
                SchemaUtil.mergeMap(mapFieldSchema, object, object2, l10);
                break;
            }
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 47: 
            case 48: 
            case 49: {
                ListFieldSchema listFieldSchema = this.listFieldSchema;
                listFieldSchema.mergeListsAt(object, object2, l10);
                break;
            }
            case 17: {
                this.mergeMessage(object, object2, n10);
                break;
            }
            case 16: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                long l11 = UnsafeUtil.getLong(object2, l10);
                UnsafeUtil.putLong(object, l10, l11);
                this.setFieldPresent(object, n10);
                break;
            }
            case 15: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                int n13 = UnsafeUtil.getInt(object2, l10);
                UnsafeUtil.putInt(object, l10, n13);
                this.setFieldPresent(object, n10);
                break;
            }
            case 14: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                long l12 = UnsafeUtil.getLong(object2, l10);
                UnsafeUtil.putLong(object, l10, l12);
                this.setFieldPresent(object, n10);
                break;
            }
            case 13: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                int n14 = UnsafeUtil.getInt(object2, l10);
                UnsafeUtil.putInt(object, l10, n14);
                this.setFieldPresent(object, n10);
                break;
            }
            case 12: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                int n15 = UnsafeUtil.getInt(object2, l10);
                UnsafeUtil.putInt(object, l10, n15);
                this.setFieldPresent(object, n10);
                break;
            }
            case 11: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                int n16 = UnsafeUtil.getInt(object2, l10);
                UnsafeUtil.putInt(object, l10, n16);
                this.setFieldPresent(object, n10);
                break;
            }
            case 10: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                object2 = UnsafeUtil.getObject(object2, l10);
                UnsafeUtil.putObject(object, l10, object2);
                this.setFieldPresent(object, n10);
                break;
            }
            case 9: {
                this.mergeMessage(object, object2, n10);
                break;
            }
            case 8: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                object2 = UnsafeUtil.getObject(object2, l10);
                UnsafeUtil.putObject(object, l10, object2);
                this.setFieldPresent(object, n10);
                break;
            }
            case 7: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                boolean bl2 = UnsafeUtil.getBoolean(object2, l10);
                UnsafeUtil.putBoolean(object, l10, bl2);
                this.setFieldPresent(object, n10);
                break;
            }
            case 6: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                int n17 = UnsafeUtil.getInt(object2, l10);
                UnsafeUtil.putInt(object, l10, n17);
                this.setFieldPresent(object, n10);
                break;
            }
            case 5: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                long l13 = UnsafeUtil.getLong(object2, l10);
                UnsafeUtil.putLong(object, l10, l13);
                this.setFieldPresent(object, n10);
                break;
            }
            case 4: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                int n18 = UnsafeUtil.getInt(object2, l10);
                UnsafeUtil.putInt(object, l10, n18);
                this.setFieldPresent(object, n10);
                break;
            }
            case 3: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                long l14 = UnsafeUtil.getLong(object2, l10);
                UnsafeUtil.putLong(object, l10, l14);
                this.setFieldPresent(object, n10);
                break;
            }
            case 2: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                long l15 = UnsafeUtil.getLong(object2, l10);
                UnsafeUtil.putLong(object, l10, l15);
                this.setFieldPresent(object, n10);
                break;
            }
            case 1: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                float f10 = UnsafeUtil.getFloat(object2, l10);
                UnsafeUtil.putFloat(object, l10, f10);
                this.setFieldPresent(object, n10);
                break;
            }
            case 0: {
                n11 = (int)(this.isFieldPresent(object2, n10) ? 1 : 0);
                if (n11 == 0) break;
                double d10 = UnsafeUtil.getDouble(object2, l10);
                UnsafeUtil.putDouble(object, l10, d10);
                this.setFieldPresent(object, n10);
            }
        }
    }

    public static MessageSchema newSchema(Class clazz, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        boolean bl2 = messageInfo instanceof RawMessageInfo;
        if (bl2) {
            return MessageSchema.newSchemaForRawMessageInfo((RawMessageInfo)messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return MessageSchema.newSchemaForMessageInfo((StructuralMessageInfo)messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static MessageSchema newSchemaForMessageInfo(StructuralMessageInfo var0, NewInstanceSchema var1_1, ListFieldSchema var2_2, UnknownFieldSchema var3_3, ExtensionSchema var4_4, MapFieldSchema var5_5) {
        var6_6 /* !! */  = var0.getSyntax();
        var7_7 /* !! */  = ProtoSyntax.PROTO3;
        var8_8 = 1;
        var9_9 = 0;
        var10_10 = null;
        var11_11 = var6_6 /* !! */  == var7_7 /* !! */  ? var8_8 : 0;
        var6_6 /* !! */  = var0.getFields();
        var12_12 = var6_6 /* !! */ .length;
        if (var12_12 == 0) {
            var13_13 = 0;
            var14_14 = 0;
        } else {
            var7_7 /* !! */  = var6_6 /* !! */ [0];
            var12_12 = var7_7 /* !! */ .getFieldNumber();
            var15_15 = var6_6 /* !! */ .length - var8_8;
            var16_16 = var6_6 /* !! */ [var15_15];
            var8_8 = var16_16.getFieldNumber();
            var13_13 = var12_12;
            var14_14 = var8_8;
        }
        var12_12 = var6_6 /* !! */ .length;
        var17_17 = new int[var12_12 * 3];
        var18_18 = new Object[var12_12 * 2];
        var12_12 = var6_6 /* !! */ .length;
        var8_8 = 0;
        var16_16 = null;
        var15_15 = 0;
        var19_19 /* !! */  = null;
        var20_20 = 0;
        var21_21 = null;
        while (true) {
            var22_22 = 49;
            var23_23 = 18;
            if (var8_8 >= var12_12) break;
            var24_24 = var6_6 /* !! */ [var8_8];
            var25_25 = var24_24.getType();
            if (var25_25 == (var26_26 /* !! */  = FieldType.MAP)) {
                ++var15_15;
            } else {
                var25_25 = var24_24.getType();
                var27_27 = var25_25.id();
                if (var27_27 >= var23_23 && (var23_23 = (var28_28 /* !! */  = var24_24.getType()).id()) <= var22_22) {
                    ++var20_20;
                }
            }
            ++var8_8;
        }
        var12_12 = 0;
        var7_7 /* !! */  = null;
        if (var15_15 > 0) {
            var16_16 = new int[var15_15];
        } else {
            var8_8 = 0;
            var16_16 = null;
        }
        if (var20_20 > 0) {
            var7_7 /* !! */  = (ProtoSyntax)new int[var20_20];
        }
        if ((var19_19 /* !! */  = var0.getCheckInitialized()) == null) {
            var19_19 /* !! */  = MessageSchema.EMPTY_INT_ARRAY;
        }
        var21_21 = null;
        var29_29 = 0;
        var24_24 = null;
        var27_27 = 0;
        var25_25 = null;
        var30_30 = 0;
        var26_26 /* !! */  = null;
        var31_31 = 0;
        for (var20_20 = 0; var20_20 < (var9_9 = var6_6 /* !! */ .length); ++var20_20) {
            var10_10 = var6_6 /* !! */ [var20_20];
            var22_22 = var10_10.getFieldNumber();
            MessageSchema.storeFieldData((FieldInfo)var10_10, var17_17, var29_29, (boolean)var11_11, var18_18);
            var23_23 = var19_19 /* !! */ .length;
            if (var27_27 < var23_23 && (var23_23 = var19_19 /* !! */ [var27_27]) == var22_22) {
                var22_22 = var27_27 + 1;
                var19_19 /* !! */ [var27_27] = var29_29;
                var27_27 = var22_22;
            }
            if ((var32_32 = var10_10.getType()) == (var28_28 /* !! */  = FieldType.MAP)) {
                var9_9 = var30_30 + 1;
                var16_16[var30_30] = var29_29;
                var30_30 = var9_9;
                while (true) {
                    var33_33 = var29_29;
                    break;
                }
            } else {
                if ((var22_22 = (var32_32 = var10_10.getType()).id()) < (var23_23 = 18) || (var22_22 = (var32_32 = var10_10.getType()).id()) > (var23_23 = 49)) ** continue;
                var22_22 = var31_31 + 1;
                var10_10 = var10_10.getField();
                var33_33 = var29_29;
                var34_34 = UnsafeUtil.objectFieldOffset((Field)var10_10);
                var9_9 = (int)var34_34;
                var7_7 /* !! */ [var31_31] = (ProtoSyntax)var9_9;
                var31_31 = var22_22;
            }
            var29_29 = var33_33 + 3;
            var22_22 = 49;
            var23_23 = 18;
        }
        if (var16_16 == null) {
            var16_16 = MessageSchema.EMPTY_INT_ARRAY;
        }
        if (var7_7 /* !! */  == null) {
            var7_7 /* !! */  = (ProtoSyntax)MessageSchema.EMPTY_INT_ARRAY;
        }
        var36_35 = var19_19 /* !! */ .length;
        var9_9 = ((Object)var16_16).length;
        var36_35 += var9_9;
        var9_9 = ((ProtoSyntax)var7_7 /* !! */ ).length;
        var28_28 /* !! */  = (FieldType)new int[var36_35 + var9_9];
        var36_35 = var19_19 /* !! */ .length;
        System.arraycopy(var19_19 /* !! */ , 0, (Object)var28_28 /* !! */ , 0, var36_35);
        var36_35 = var19_19 /* !! */ .length;
        var20_20 = ((Object)var16_16).length;
        System.arraycopy(var16_16, 0, (Object)var28_28 /* !! */ , var36_35, var20_20);
        var36_35 = var19_19 /* !! */ .length;
        var20_20 = ((Object)var16_16).length;
        var36_35 += var20_20;
        var20_20 = ((ProtoSyntax)var7_7 /* !! */ ).length;
        System.arraycopy((Object)var7_7 /* !! */ , 0, (Object)var28_28 /* !! */ , var36_35, var20_20);
        var21_21 = var0.getDefaultInstance();
        var29_29 = var19_19 /* !! */ .length;
        var12_12 = var19_19 /* !! */ .length;
        var8_8 = ((Object)var16_16).length;
        var27_27 = var12_12 + var8_8;
        var19_19 /* !! */  = (int[])var6_6 /* !! */ ;
        var26_26 /* !! */  = var1_1;
        var6_6 /* !! */  = new MessageSchema(var17_17, var18_18, var13_13, var14_14, var21_21, (boolean)var11_11, true, (int[])var28_28 /* !! */ , var29_29, var27_27, var1_1, var2_2, var3_3, var4_4, var5_5);
        return var6_6 /* !! */ ;
    }

    public static MessageSchema newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        float f10;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int[] nArray;
        int n15;
        Object object;
        int n16;
        Object[] objectArray;
        int n17;
        int[] nArray2;
        Object object2;
        int n18;
        int n19;
        int n20;
        int n21;
        Object object3;
        float f11;
        int n22;
        Object object4 = rawMessageInfo.getSyntax();
        ProtoSyntax protoSyntax = ProtoSyntax.PROTO3;
        int n23 = 0;
        int[] nArray3 = null;
        if (object4 == protoSyntax) {
            n22 = 1;
            f11 = Float.MIN_VALUE;
        } else {
            n22 = 0;
            object3 = null;
            f11 = 0.0f;
        }
        object4 = rawMessageInfo.getStringInfo();
        int n24 = ((String)object4).length();
        int n25 = ((String)object4).charAt(0);
        int n26 = 55296;
        if (n25 >= n26) {
            n25 &= 0x1FFF;
            n21 = 1;
            n20 = 13;
            while (true) {
                n19 = n21 + 1;
                if ((n21 = (int)((String)object4).charAt(n21)) < n26) break;
                n21 = (n21 & 0x1FFF) << n20;
                n25 |= n21;
                n20 += 13;
                n21 = n19;
            }
            n25 |= (n21 <<= n20);
        } else {
            n19 = 1;
        }
        n21 = n19 + 1;
        n20 = ((String)object4).charAt(n19);
        if (n20 >= n26) {
            n20 &= 0x1FFF;
            n19 = 13;
            while (true) {
                n18 = n21 + 1;
                if ((n21 = (int)((String)object4).charAt(n21)) < n26) break;
                n21 = (n21 & 0x1FFF) << n19;
                n20 |= n21;
                n19 += 13;
                n21 = n18;
            }
            n20 |= (n21 <<= n19);
            n21 = n18;
        }
        if (n20 == 0) {
            int[] nArray4 = EMPTY_INT_ARRAY;
            n19 = 0;
            object2 = null;
            n18 = 0;
            nArray2 = null;
            n17 = 0;
            objectArray = null;
            n16 = 0;
            object = null;
            n15 = 0;
            nArray = nArray4;
            n20 = 0;
            nArray4 = null;
        } else {
            int n27;
            n20 = n21 + 1;
            if ((n21 = (int)((String)object4).charAt(n21)) >= n26) {
                n21 &= 0x1FFF;
                n19 = 13;
                while (true) {
                    n18 = n20 + 1;
                    if ((n20 = (int)((String)object4).charAt(n20)) < n26) break;
                    n20 = (n20 & 0x1FFF) << n19;
                    n21 |= n20;
                    n19 += 13;
                    n20 = n18;
                }
                n21 |= (n20 <<= n19);
                n20 = n18;
            }
            n19 = n20 + 1;
            if ((n20 = (int)((String)object4).charAt(n20)) >= n26) {
                n20 &= 0x1FFF;
                n18 = 13;
                while (true) {
                    n17 = n19 + 1;
                    if ((n19 = (int)((String)object4).charAt(n19)) < n26) break;
                    n19 = (n19 & 0x1FFF) << n18;
                    n20 |= n19;
                    n18 += 13;
                    n19 = n17;
                }
                n20 |= (n19 <<= n18);
                n19 = n17;
            }
            n18 = n19 + 1;
            if ((n19 = (int)((String)object4).charAt(n19)) >= n26) {
                n19 &= 0x1FFF;
                n17 = 13;
                while (true) {
                    n14 = n18 + 1;
                    if ((n18 = (int)((String)object4).charAt(n18)) < n26) break;
                    n18 = (n18 & 0x1FFF) << n17;
                    n19 |= n18;
                    n17 += 13;
                    n18 = n14;
                }
                n19 |= (n18 <<= n17);
                n18 = n14;
            }
            n17 = n18 + 1;
            if ((n18 = (int)((String)object4).charAt(n18)) >= n26) {
                n18 &= 0x1FFF;
                n14 = 13;
                while (true) {
                    n16 = n17 + 1;
                    if ((n17 = (int)((String)object4).charAt(n17)) < n26) break;
                    n17 = (n17 & 0x1FFF) << n14;
                    n18 |= n17;
                    n14 += 13;
                    n17 = n16;
                }
                n18 |= (n17 <<= n14);
                n17 = n16;
            }
            n14 = n17 + 1;
            if ((n17 = (int)((String)object4).charAt(n17)) >= n26) {
                n17 &= 0x1FFF;
                n16 = 13;
                while (true) {
                    n15 = n14 + 1;
                    if ((n14 = (int)((String)object4).charAt(n14)) < n26) break;
                    n14 = (n14 & 0x1FFF) << n16;
                    n17 |= n14;
                    n16 += 13;
                    n14 = n15;
                }
                n17 |= (n14 <<= n16);
                n14 = n15;
            }
            n16 = n14 + 1;
            if ((n14 = (int)((String)object4).charAt(n14)) >= n26) {
                n14 &= 0x1FFF;
                n15 = 13;
                while (true) {
                    n27 = n16 + 1;
                    if ((n16 = (int)((String)object4).charAt(n16)) < n26) break;
                    n16 = (n16 & 0x1FFF) << n15;
                    n14 |= n16;
                    n15 += 13;
                    n16 = n27;
                }
                n14 |= (n16 <<= n15);
                n16 = n27;
            }
            n15 = n16 + 1;
            if ((n16 = (int)((String)object4).charAt(n16)) >= n26) {
                int n28;
                n16 &= 0x1FFF;
                n27 = 13;
                while (true) {
                    n28 = n15 + 1;
                    if ((n15 = (int)((String)object4).charAt(n15)) < n26) break;
                    n15 = (n15 & 0x1FFF) << n27;
                    n16 |= n15;
                    n27 += 13;
                    n15 = n28;
                }
                n16 |= (n15 <<= n27);
                n15 = n28;
            }
            n27 = n15 + 1;
            if ((n15 = (int)((String)object4).charAt(n15)) >= n26) {
                int n29;
                n15 &= 0x1FFF;
                n23 = n27;
                n27 = 13;
                while (true) {
                    n29 = n23 + 1;
                    if ((n23 = (int)((String)object4).charAt(n23)) < n26) break;
                    n23 = (n23 & 0x1FFF) << n27;
                    n15 |= n23;
                    n27 += 13;
                    n23 = n29;
                }
                n15 |= (n23 <<= n27);
                n27 = n29;
            }
            nArray3 = new int[n15 + n14 + n16];
            n16 = n21 * 2 + n20;
            n20 = n21;
            n21 = n27;
            n13 = n14;
            nArray = nArray3;
            n23 = n19;
            n19 = n14;
        }
        Object object5 = UNSAFE;
        Object object6 = rawMessageInfo.getObjects();
        Class<?> clazz = rawMessageInfo.getDefaultInstance();
        Class<?> clazz2 = clazz.getClass();
        n26 = n17 * 3;
        Object object7 = new int[n26];
        objectArray = new Object[n17 *= 2];
        int n30 = n15 + n19;
        int n31 = n15;
        int n32 = n30;
        n19 = 0;
        object2 = null;
        int n33 = 0;
        while (n21 < n24) {
            int n34;
            int n35;
            Object object8;
            int n36;
            int n37;
            int n38;
            block56: {
                block65: {
                    block66: {
                        block63: {
                            block64: {
                                int n39;
                                int n40;
                                Object object9;
                                block62: {
                                    block60: {
                                        Class<?> clazz3;
                                        block57: {
                                            int n41;
                                            block61: {
                                                block58: {
                                                    block59: {
                                                        int n42;
                                                        block52: {
                                                            int n43;
                                                            block54: {
                                                                block55: {
                                                                    block53: {
                                                                        n12 = n21 + 1;
                                                                        n21 = ((String)object4).charAt(n21);
                                                                        n38 = n24;
                                                                        n24 = 55296;
                                                                        if (n21 >= n24) {
                                                                            n21 &= 0x1FFF;
                                                                            n24 = n12;
                                                                            n12 = 13;
                                                                            while (true) {
                                                                                n42 = n24 + 1;
                                                                                n24 = ((String)object4).charAt(n24);
                                                                                n11 = n15;
                                                                                n15 = 55296;
                                                                                if (n24 < n15) break;
                                                                                n24 = (n24 & 0x1FFF) << n12;
                                                                                n21 |= n24;
                                                                                n12 += 13;
                                                                                n24 = n42;
                                                                                n15 = n11;
                                                                            }
                                                                            n21 |= (n24 <<= n12);
                                                                            n24 = n42;
                                                                        } else {
                                                                            n11 = n15;
                                                                            n24 = n12;
                                                                        }
                                                                        n15 = n24 + 1;
                                                                        n24 = ((String)object4).charAt(n24);
                                                                        n12 = n15;
                                                                        n15 = 55296;
                                                                        if (n24 >= n15) {
                                                                            n24 &= 0x1FFF;
                                                                            n15 = n12;
                                                                            n12 = 13;
                                                                            while (true) {
                                                                                n42 = n15 + 1;
                                                                                n15 = ((String)object4).charAt(n15);
                                                                                n10 = n22;
                                                                                f10 = f11;
                                                                                n22 = 55296;
                                                                                f11 = 7.7486E-41f;
                                                                                if (n15 < n22) break;
                                                                                n22 = (n15 & 0x1FFF) << n12;
                                                                                n24 |= n22;
                                                                                n12 += 13;
                                                                                n15 = n42;
                                                                                n22 = n10;
                                                                                f11 = f10;
                                                                            }
                                                                            n22 = n15 << n12;
                                                                            n24 |= n22;
                                                                            n15 = n42;
                                                                        } else {
                                                                            n10 = n22;
                                                                            f10 = f11;
                                                                            n15 = n12;
                                                                        }
                                                                        n22 = n24 & 0xFF;
                                                                        n12 = n18;
                                                                        n18 = n24 & 0x400;
                                                                        if (n18 != 0) {
                                                                            n18 = n19 + 1;
                                                                            nArray[n19] = n33;
                                                                            n19 = n18;
                                                                        }
                                                                        n18 = 51;
                                                                        n37 = n19;
                                                                        if (n22 < n18) break block52;
                                                                        n18 = n15 + 1;
                                                                        if ((n15 = (int)((String)object4).charAt(n15)) >= (n19 = 55296)) {
                                                                            n15 &= 0x1FFF;
                                                                            n43 = 13;
                                                                            while (true) {
                                                                                n36 = n18 + 1;
                                                                                if ((n18 = (int)((String)object4).charAt(n18)) < n19) break;
                                                                                n19 = (n18 & 0x1FFF) << n43;
                                                                                n15 |= n19;
                                                                                n43 += 13;
                                                                                n18 = n36;
                                                                                n19 = 55296;
                                                                            }
                                                                            n19 = n18 << n43;
                                                                            n15 |= n19;
                                                                            n18 = n36;
                                                                        }
                                                                        n19 = n22 + -51;
                                                                        n43 = n18;
                                                                        n18 = 9;
                                                                        if (n19 == n18 || n19 == (n18 = 17)) break block53;
                                                                        n18 = 12;
                                                                        if (n19 != n18 || (n19 = n25 & 1) != (n18 = 1)) break block54;
                                                                        n19 = n33 / 3 * 2 + n18;
                                                                        n18 = n16 + 1;
                                                                        objectArray[n19] = object = object6[n16];
                                                                        break block55;
                                                                    }
                                                                    n19 = n33 / 3 * 2 + 1;
                                                                    n18 = n16 + 1;
                                                                    objectArray[n19] = object = object6[n16];
                                                                }
                                                                n16 = n18;
                                                            }
                                                            if ((n18 = (object2 = object6[n15 *= 2]) instanceof Field) != 0) {
                                                                object2 = (Field)object2;
                                                            } else {
                                                                object2 = (String)object2;
                                                                object6[n15] = object2 = MessageSchema.reflectField(clazz2, (String)object2);
                                                            }
                                                            nArray2 = object7;
                                                            n36 = n21;
                                                            long l10 = ((Unsafe)object5).objectFieldOffset((Field)object2);
                                                            n26 = (int)l10;
                                                            object9 = object6[++n15];
                                                            n19 = object9 instanceof Field;
                                                            if (n19 != 0) {
                                                                object9 = (Field)object9;
                                                            } else {
                                                                object9 = (String)object9;
                                                                object6[n15] = object9 = MessageSchema.reflectField(clazz2, (String)object9);
                                                            }
                                                            n19 = n26;
                                                            l10 = ((Unsafe)object5).objectFieldOffset((Field)object9);
                                                            n26 = (int)l10;
                                                            object8 = object4;
                                                            clazz = clazz2;
                                                            n35 = n25;
                                                            n34 = n26;
                                                            n26 = n19;
                                                            n19 = n22;
                                                            n21 = n43;
                                                            n15 = 0;
                                                            break block56;
                                                        }
                                                        nArray2 = object7;
                                                        n36 = n21;
                                                        n26 = n16 + 1;
                                                        object9 = (String)object6[n16];
                                                        object9 = MessageSchema.reflectField(clazz2, (String)object9);
                                                        n19 = 49;
                                                        n16 = 9;
                                                        if (n22 == n16 || n22 == (n16 = 17)) break block57;
                                                        n16 = 27;
                                                        if (n22 == n16 || n22 == n19) break block58;
                                                        n16 = 12;
                                                        if (n22 == n16 || n22 == (n16 = 30) || n22 == (n16 = 44)) break block59;
                                                        n16 = 50;
                                                        if (n22 == n16) {
                                                            n16 = n31 + 1;
                                                            nArray[n31] = n33;
                                                            n31 = n33 / 3 * 2;
                                                            n42 = n26 + 1;
                                                            object7 = object6[n26];
                                                            objectArray[n31] = object7;
                                                            n26 = n24 & 0x800;
                                                            if (n26 != 0) {
                                                                Object object10;
                                                                n26 = n42 + 1;
                                                                objectArray[++n31] = object10 = object6[n42];
                                                                n31 = n16;
                                                            } else {
                                                                n31 = n16;
                                                                n26 = n42;
                                                            }
                                                        } else {
                                                            n19 = 1;
                                                        }
                                                        break block60;
                                                    }
                                                    n16 = n25 & 1;
                                                    n19 = 1;
                                                    if (n16 != n19) break block60;
                                                    n16 = n33 / 3 * 2 + n19;
                                                    n41 = n26 + 1;
                                                    object7 = object6[n26];
                                                    objectArray[n16] = object7;
                                                    break block61;
                                                }
                                                n19 = 1;
                                                n16 = n33 / 3 * 2 + n19;
                                                n41 = n26 + 1;
                                                object7 = object6[n26];
                                                objectArray[n16] = object7;
                                            }
                                            n16 = n22;
                                            n26 = n41;
                                            break block62;
                                        }
                                        n19 = 1;
                                        n16 = n33 / 3 * 2 + n19;
                                        objectArray[n16] = clazz3 = ((Field)object9).getType();
                                    }
                                    n16 = n22;
                                }
                                long l11 = ((Unsafe)object5).objectFieldOffset((Field)object9);
                                n21 = (int)l11;
                                n19 = n25 & 1;
                                n22 = 1;
                                f11 = Float.MIN_VALUE;
                                if (n19 != n22) break block63;
                                n19 = n16;
                                if (n19 > (n16 = 17)) break block64;
                                n16 = n15 + 1;
                                n15 = ((String)object4).charAt(n15);
                                n22 = 55296;
                                f11 = 7.7486E-41f;
                                if (n15 >= n22) {
                                    n15 &= 0x1FFF;
                                    n40 = 13;
                                    while (true) {
                                        n39 = n16 + 1;
                                        if ((n16 = (int)((String)object4).charAt(n16)) < n22) break;
                                        n16 = (n16 & 0x1FFF) << n40;
                                        n15 |= n16;
                                        n40 += 13;
                                        n16 = n39;
                                    }
                                    n15 |= (n16 <<= n40);
                                    n16 = n39;
                                }
                                n40 = n20 * 2;
                                n39 = n15 / 32;
                                object3 = object6[n40 += n39];
                                object8 = object4;
                                n35 = object3 instanceof Field;
                                if (n35 != 0) {
                                    object3 = (Field)object3;
                                } else {
                                    object3 = (String)object3;
                                    object6[n40] = object3 = MessageSchema.reflectField(clazz2, (String)object3);
                                }
                                clazz = clazz2;
                                n35 = n25;
                                long l12 = ((Unsafe)object5).objectFieldOffset((Field)object3);
                                n34 = (int)l12;
                                n15 %= 32;
                                break block65;
                            }
                            object8 = object4;
                            clazz = clazz2;
                            n35 = n25;
                            break block66;
                        }
                        object8 = object4;
                        clazz = clazz2;
                        n35 = n25;
                        n19 = n16;
                    }
                    n16 = n15;
                    n34 = 0;
                    clazz2 = null;
                    n15 = 0;
                }
                n25 = 18;
                if (n19 >= n25 && n19 <= (n25 = 49)) {
                    n25 = n32 + 1;
                    nArray[n32] = n21;
                    n32 = n25;
                }
                n13 = n16;
                n16 = n26;
                n26 = n21;
                n21 = n13;
            }
            n25 = n33 + 1;
            nArray2[n33] = n36;
            n22 = n25 + 1;
            n33 = n35;
            n35 = n24 & 0x200;
            if (n35 != 0) {
                n35 = 0x20000000;
            } else {
                n35 = 0;
                object4 = null;
            }
            if ((n24 &= 0x100) != 0) {
                n24 = 0x10000000;
            } else {
                n24 = 0;
                protoSyntax = null;
            }
            n35 |= n24;
            n24 = n19 << 20;
            nArray2[n25] = n35 = n35 | n24 | n26;
            n35 = n22 + 1;
            nArray2[n22] = n24 = n15 << 20 | n34;
            object7 = nArray2;
            clazz2 = clazz;
            n25 = n33;
            n18 = n12;
            n24 = n38;
            n15 = n11;
            n22 = n10;
            f11 = f10;
            n19 = n37;
            n33 = n35;
            object4 = object8;
        }
        n10 = n22;
        f10 = f11;
        n12 = n18;
        n11 = n15;
        nArray2 = object7;
        object2 = rawMessageInfo.getDefaultInstance();
        object5 = object7;
        object7 = objectArray;
        n21 = n23;
        n20 = n18;
        objectArray = nArray;
        n14 = n15;
        n16 = n30;
        object6 = extensionSchema;
        clazz = mapFieldSchema;
        object4 = new MessageSchema(nArray2, (Object[])object7, n23, n18, (MessageLite)object2, n22 != 0, false, nArray, n15, n30, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        return object4;
    }

    private int numberAt(int n10) {
        return this.buffer[n10];
    }

    private static long offset(int n10) {
        return n10 & 0xFFFFF;
    }

    private static boolean oneofBooleanAt(Object object, long l10) {
        return (Boolean)UnsafeUtil.getObject(object, l10);
    }

    private static double oneofDoubleAt(Object object, long l10) {
        return (Double)UnsafeUtil.getObject(object, l10);
    }

    private static float oneofFloatAt(Object object, long l10) {
        return ((Float)UnsafeUtil.getObject(object, l10)).floatValue();
    }

    private static int oneofIntAt(Object object, long l10) {
        return (Integer)UnsafeUtil.getObject(object, l10);
    }

    private static long oneofLongAt(Object object, long l10) {
        return (Long)UnsafeUtil.getObject(object, l10);
    }

    private int parseMapField(Object object, byte[] byArray, int n10, int n11, int n12, long l10, ArrayDecoders$Registers arrayDecoders$Registers) {
        MessageSchema messageSchema = this;
        Unsafe unsafe = UNSAFE;
        Object object2 = this.getMapFieldDefaultEntry(n12);
        Object object3 = this.mapFieldSchema;
        Object object4 = unsafe.getObject(object, l10);
        boolean bl2 = object3.isImmutable(object4);
        if (bl2) {
            object3 = this.mapFieldSchema.newMapField(object2);
            MapFieldSchema mapFieldSchema = this.mapFieldSchema;
            mapFieldSchema.mergeFrom(object3, object4);
            unsafe.putObject(object, l10, object3);
            object4 = object3;
        }
        object2 = messageSchema.mapFieldSchema.forMapMetadata(object2);
        object4 = messageSchema.mapFieldSchema.forMutableMapData(object4);
        object3 = arrayDecoders$Registers;
        return this.decodeMapEntry(byArray, n10, n11, (MapEntryLite$Metadata)object2, (Map)object4, arrayDecoders$Registers);
    }

    /*
     * WARNING - void declaration
     */
    private int parseOneofField(Object object, byte[] byArray, int n10, int n11, int n12, int n13, int n14, int n15, int n16, long l10, int n17, ArrayDecoders$Registers arrayDecoders$Registers) {
        int n18;
        block32: {
            Object object2 = object;
            Object object3 = byArray;
            int n19 = n10;
            n18 = n12;
            int n20 = n13;
            int n21 = n14;
            long l11 = l10;
            ArrayDecoders$Registers arrayDecoders$Registers2 = arrayDecoders$Registers;
            Unsafe unsafe = UNSAFE;
            Object object4 = this.buffer;
            int n22 = n17 + 2;
            int n23 = object4[n22];
            n22 = 1048575;
            long l12 = n23 & n22;
            n23 = 5;
            int bl2 = 2;
            switch (n16) {
                default: {
                    break;
                }
                case 68: {
                    Object object5;
                    n23 = 3;
                    if (n14 != n23) break;
                    n23 = n12 & 0xFFFFFFF8 | 4;
                    Schema f12 = this.getMessageFieldSchema(n17);
                    n21 = n11;
                    object4 = arrayDecoders$Registers;
                    n18 = ArrayDecoders.decodeGroupField(f12, byArray, n10, n11, n23, arrayDecoders$Registers);
                    int n30 = unsafe.getInt(object, l12);
                    if (n30 == n13) {
                        object5 = unsafe.getObject(object, l10);
                    } else {
                        boolean bl3 = false;
                        object5 = null;
                    }
                    if (object5 == null) {
                        object3 = arrayDecoders$Registers2.object1;
                        unsafe.putObject(object2, l11, object3);
                    } else {
                        object3 = arrayDecoders$Registers2.object1;
                        object3 = Internal.mergeMessage(object5, object3);
                        unsafe.putObject(object2, l11, object3);
                    }
                    unsafe.putInt(object2, l12, n20);
                    break block32;
                }
                case 67: {
                    if (n14 != 0) break;
                    n18 = ArrayDecoders.decodeVarint64(byArray, n10, arrayDecoders$Registers);
                    long l13 = CodedInputStream.decodeZigZag64(arrayDecoders$Registers.long1);
                    object3 = l13;
                    unsafe.putObject(object, l10, object3);
                    unsafe.putInt(object, l12, n13);
                    break block32;
                }
                case 66: {
                    if (n14 != 0) break;
                    n18 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
                    int n24 = CodedInputStream.decodeZigZag32(arrayDecoders$Registers.int1);
                    object3 = n24;
                    unsafe.putObject(object, l10, object3);
                    unsafe.putInt(object, l12, n13);
                    break block32;
                }
                case 63: {
                    if (n14 != 0) break;
                    int n25 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
                    n19 = arrayDecoders$Registers.int1;
                    Internal$EnumVerifier internal$EnumVerifier = this.getEnumFieldVerifier(n17);
                    if (internal$EnumVerifier != null && (n21 = (int)(internal$EnumVerifier.isInRange(n19) ? 1 : 0)) == 0) {
                        object2 = MessageSchema.getMutableUnknownFields(object);
                        long l14 = n19;
                        Long l15 = l14;
                        ((UnknownFieldSetLite)object2).storeField(n12, l15);
                    } else {
                        Integer d11 = n19;
                        unsafe.putObject(object2, l11, d11);
                        unsafe.putInt(object2, l12, n20);
                    }
                    n18 = n25;
                    break block32;
                }
                case 61: {
                    if (n14 != bl2) break;
                    n18 = ArrayDecoders.decodeBytes(byArray, n10, arrayDecoders$Registers);
                    object3 = arrayDecoders$Registers.object1;
                    unsafe.putObject(object, l10, object3);
                    unsafe.putInt(object, l12, n13);
                    break block32;
                }
                case 60: {
                    Object object6;
                    if (n14 != bl2) break;
                    Schema schema = this.getMessageFieldSchema(n17);
                    n21 = n11;
                    n18 = ArrayDecoders.decodeMessageField(schema, byArray, n10, n11, arrayDecoders$Registers);
                    int n26 = unsafe.getInt(object, l12);
                    if (n26 == n13) {
                        object6 = unsafe.getObject(object, l10);
                    } else {
                        boolean bl4 = false;
                        object6 = null;
                    }
                    if (object6 == null) {
                        object3 = arrayDecoders$Registers2.object1;
                        unsafe.putObject(object2, l11, object3);
                    } else {
                        object3 = arrayDecoders$Registers2.object1;
                        object3 = Internal.mergeMessage(object6, object3);
                        unsafe.putObject(object2, l11, object3);
                    }
                    unsafe.putInt(object2, l12, n20);
                    break block32;
                }
                case 59: {
                    if (n14 != bl2) break;
                    n18 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
                    n19 = arrayDecoders$Registers.int1;
                    if (n19 == 0) {
                        object3 = "";
                        unsafe.putObject(object, l10, object3);
                    } else {
                        n21 = n15 & 0x20000000;
                        if (n21 != 0) {
                            n21 = n18 + n19;
                            if ((n21 = (int)(Utf8.isValidUtf8(byArray, n18, n21) ? 1 : 0)) == 0) {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        }
                        Charset charset = Internal.UTF_8;
                        String string2 = new String((byte[])object3, n18, n19, charset);
                        unsafe.putObject(object2, l11, string2);
                        n18 += n19;
                    }
                    unsafe.putInt(object2, l12, n20);
                    break block32;
                }
                case 58: {
                    void var29_31;
                    if (n14 != 0) break;
                    n18 = ArrayDecoders.decodeVarint64(byArray, n10, arrayDecoders$Registers);
                    long l16 = arrayDecoders$Registers.long1;
                    long l17 = 0L;
                    long l18 = l16 - l17;
                    Object object7 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                    if (object7 != false) {
                        boolean bl5 = true;
                    } else {
                        boolean bl6 = false;
                        Object var32_47 = null;
                    }
                    object3 = (boolean)var29_31;
                    unsafe.putObject(object2, l11, object3);
                    unsafe.putInt(object2, l12, n20);
                    break block32;
                }
                case 57: 
                case 64: {
                    if (n14 != n23) break;
                    Integer n27 = ArrayDecoders.decodeFixed32(byArray, n10);
                    unsafe.putObject(object, l10, n27);
                    n18 = n10 + 4;
                    unsafe.putInt(object, l12, n13);
                    break block32;
                }
                case 56: 
                case 65: {
                    n18 = 1;
                    float f10 = Float.MIN_VALUE;
                    if (n14 != n18) break;
                    long l19 = ArrayDecoders.decodeFixed64(byArray, n10);
                    Long l20 = l19;
                    unsafe.putObject(object, l10, l20);
                    n18 = n10 + 8;
                    unsafe.putInt(object, l12, n13);
                    break block32;
                }
                case 55: 
                case 62: {
                    if (n14 != 0) break;
                    n18 = ArrayDecoders.decodeVarint32(byArray, n10, arrayDecoders$Registers);
                    int n28 = arrayDecoders$Registers.int1;
                    object3 = n28;
                    unsafe.putObject(object, l10, object3);
                    unsafe.putInt(object, l12, n13);
                    break block32;
                }
                case 53: 
                case 54: {
                    if (n14 != 0) break;
                    n18 = ArrayDecoders.decodeVarint64(byArray, n10, arrayDecoders$Registers);
                    long l21 = arrayDecoders$Registers.long1;
                    object3 = l21;
                    unsafe.putObject(object, l10, object3);
                    unsafe.putInt(object, l12, n13);
                    break block32;
                }
                case 52: {
                    if (n14 != n23) break;
                    float f11 = ArrayDecoders.decodeFloat(byArray, n10);
                    Float f12 = Float.valueOf(f11);
                    unsafe.putObject(object, l10, f12);
                    n18 = n10 + 4;
                    unsafe.putInt(object, l12, n13);
                    break block32;
                }
                case 51: {
                    n18 = 1;
                    float f13 = Float.MIN_VALUE;
                    if (n14 != n18) break;
                    double d10 = ArrayDecoders.decodeDouble(byArray, n10);
                    Double d11 = d10;
                    unsafe.putObject(object, l10, d11);
                    n18 = n10 + 8;
                    unsafe.putInt(object, l12, n13);
                    break block32;
                }
            }
            n18 = n19;
        }
        return n18;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private int parseProto3Message(Object var1_1, byte[] var2_2, int var3_3, int var4_4, ArrayDecoders$Registers var5_5) {
        var6_6 = this;
        var7_7 = var1_1;
        var8_8 = var2_2;
        var9_9 = var4_4;
        var10_10 = var5_5;
        var11_11 = MessageSchema.UNSAFE;
        var12_12 = -1;
        var13_13 = 0.0f / 0.0f;
        var14_14 = var3_3;
        var15_15 = var12_12;
        var16_16 = 0;
        block15: while (var14_14 < var9_9) {
            block47: {
                block35: {
                    block46: {
                        block48: {
                            block44: {
                                block45: {
                                    block43: {
                                        block42: {
                                            block37: {
                                                block36: {
                                                    block38: {
                                                        block40: {
                                                            block39: {
                                                                block41: {
                                                                    block34: {
                                                                        var17_17 = var14_14 + 1;
                                                                        if ((var14_14 = var8_8[var14_14]) < 0) {
                                                                            var14_14 = ArrayDecoders.decodeVarint32(var14_14, var8_8, var17_17, var10_10);
                                                                            var17_17 = var10_10.int1;
                                                                            var18_18 = var14_14;
                                                                            var19_19 = var17_17;
                                                                        } else {
                                                                            var19_19 = var14_14;
                                                                            var18_18 = var17_17;
                                                                        }
                                                                        var20_20 = var19_19 >>> 3;
                                                                        var21_21 = var19_19 & 7;
                                                                        var14_14 = var20_20 > var15_15 ? var6_6.positionForFieldNumber(var20_20, var16_16 /= 3) : var6_6.positionForFieldNumber(var20_20);
                                                                        var22_22 = var14_14;
                                                                        if (var14_14 != var12_12) break block34;
                                                                        var23_23 = var20_20;
                                                                        var16_16 = var18_18;
                                                                        var24_24 = var11_11;
                                                                        var25_25 = var12_12;
                                                                        var26_26 = var13_13;
                                                                        var27_27 = 0;
                                                                        break block35;
                                                                    }
                                                                    var28_28 = var6_6.buffer;
                                                                    var15_15 = var14_14 + 1;
                                                                    var29_29 = var28_28[var15_15];
                                                                    var17_17 = MessageSchema.type(var29_29);
                                                                    var30_30 = MessageSchema.offset(var29_29);
                                                                    var14_14 = 17;
                                                                    var32_31 = 2.4E-44f;
                                                                    var12_12 = 2;
                                                                    var13_13 = 2.8E-45f;
                                                                    if (var17_17 > var14_14) break block36;
                                                                    var14_14 = 1;
                                                                    var32_31 = 1.4E-45f;
                                                                    switch (var17_17) {
                                                                        default: {
                                                                            break block37;
                                                                        }
                                                                        case 16: {
                                                                            if (var21_21 != 0) break block37;
                                                                            var21_21 = ArrayDecoders.decodeVarint64(var8_8, var18_18, var10_10);
                                                                            var33_32 = var30_30;
                                                                            var35_33 = var10_10.long1;
                                                                            var37_34 = CodedInputStream.decodeZigZag64(var35_33);
                                                                            var28_28 = var11_11;
                                                                            var39_35 = var30_30;
                                                                            var41_36 /* !! */  = (byte[])var1_1;
                                                                            var12_12 = var22_22;
                                                                            var42_37 = var37_34;
                                                                            var11_11.putLong(var1_1, var30_30, var37_34);
                                                                            ** GOTO lbl162
                                                                        }
                                                                        case 15: {
                                                                            var39_35 = var30_30;
                                                                            var12_12 = var22_22;
                                                                            if (var21_21 != 0) break block38;
                                                                            var14_14 = ArrayDecoders.decodeVarint32(var8_8, var18_18, var10_10);
                                                                            var15_15 = CodedInputStream.decodeZigZag32(var10_10.int1);
                                                                            var11_11.putInt(var7_7, var30_30, var15_15);
                                                                            break block39;
                                                                        }
                                                                        case 12: {
                                                                            var39_35 = var30_30;
                                                                            var12_12 = var22_22;
                                                                            if (var21_21 != 0) break block38;
                                                                            var14_14 = ArrayDecoders.decodeVarint32(var8_8, var18_18, var10_10);
                                                                            var15_15 = var10_10.int1;
                                                                            var11_11.putInt(var7_7, var30_30, var15_15);
                                                                            break block39;
                                                                        }
                                                                        case 10: {
                                                                            var39_35 = var30_30;
                                                                            if (var21_21 != var12_12) break block37;
                                                                            var14_14 = ArrayDecoders.decodeBytes(var8_8, var18_18, var10_10);
                                                                            var41_36 /* !! */  = (byte[])var10_10.object1;
                                                                            var11_11.putObject(var7_7, var30_30, var41_36 /* !! */ );
                                                                            ** GOTO lbl132
                                                                        }
                                                                        case 9: {
                                                                            var39_35 = var30_30;
                                                                            if (var21_21 != var12_12) break block37;
                                                                            var28_28 = var6_6.getMessageFieldSchema(var22_22);
                                                                            var14_14 = ArrayDecoders.decodeMessageField((Schema)var28_28, var8_8, var18_18, var9_9, var10_10);
                                                                            var41_36 /* !! */  = (byte[])var11_11.getObject(var7_7, var30_30);
                                                                            if (var41_36 /* !! */  == null) {
                                                                                var41_36 /* !! */  = (byte[])var10_10.object1;
                                                                                var11_11.putObject(var7_7, var30_30, var41_36 /* !! */ );
                                                                            } else {
                                                                                var44_38 = var10_10.object1;
                                                                                var41_36 /* !! */  = (byte[])Internal.mergeMessage(var41_36 /* !! */ , var44_38);
                                                                                var11_11.putObject(var7_7, var30_30, var41_36 /* !! */ );
                                                                            }
                                                                            ** GOTO lbl132
                                                                        }
                                                                        case 8: {
                                                                            var39_35 = var30_30;
                                                                            if (var21_21 != var12_12) break block37;
                                                                            var32_31 = 1.0842022E-19f;
                                                                            var14_14 = 0x20000000 & var29_29;
                                                                            var14_14 = var14_14 == 0 ? ArrayDecoders.decodeString(var8_8, var18_18, var10_10) : ArrayDecoders.decodeStringRequireUtf8(var8_8, var18_18, var10_10);
                                                                            var41_36 /* !! */  = (byte[])var10_10.object1;
                                                                            var11_11.putObject(var7_7, var39_35, var41_36 /* !! */ );
                                                                            ** GOTO lbl132
                                                                        }
                                                                        case 7: {
                                                                            var39_35 = var30_30;
                                                                            if (var21_21 != 0) break block37;
                                                                            var15_15 = ArrayDecoders.decodeVarint64(var8_8, var18_18, var10_10);
                                                                            var45_39 = var10_10.long1;
                                                                            var33_32 = 0L;
                                                                            cfr_temp_0 = var45_39 - var33_32;
                                                                            var29_29 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                            if (var29_29 == 0) {
                                                                                var14_14 = 0;
                                                                                var28_28 = null;
                                                                                var32_31 = 0.0f;
                                                                            }
                                                                            UnsafeUtil.putBoolean(var7_7, var39_35, (boolean)var14_14);
                                                                            var14_14 = var15_15;
                                                                            ** GOTO lbl132
                                                                        }
                                                                        case 6: 
                                                                        case 13: {
                                                                            var39_35 = var30_30;
                                                                            var14_14 = 5;
                                                                            var32_31 = 7.0E-45f;
                                                                            if (var21_21 != var14_14) break block37;
                                                                            var14_14 = ArrayDecoders.decodeFixed32(var8_8, var18_18);
                                                                            var11_11.putInt(var7_7, var30_30, var14_14);
                                                                            var14_14 = var18_18 + 4;
lbl132:
                                                                            // 6 sources

                                                                            var16_16 = var22_22;
                                                                            var15_15 = var20_20;
                                                                            break block40;
                                                                        }
                                                                        case 5: 
                                                                        case 14: {
                                                                            var39_35 = var30_30;
                                                                            if (var21_21 != var14_14) break block37;
                                                                            var45_39 = ArrayDecoders.decodeFixed64(var8_8, var18_18);
                                                                            var28_28 = var11_11;
                                                                            var41_36 /* !! */  = (byte[])var1_1;
                                                                            var12_12 = var22_22;
                                                                            var42_37 = var45_39;
                                                                            var11_11.putLong(var1_1, var30_30, var45_39);
                                                                            break block41;
                                                                        }
                                                                        case 4: 
                                                                        case 11: {
                                                                            var39_35 = var30_30;
                                                                            var12_12 = var22_22;
                                                                            if (var21_21 != 0) break block38;
                                                                            var14_14 = ArrayDecoders.decodeVarint32(var8_8, var18_18, var10_10);
                                                                            var15_15 = var10_10.int1;
                                                                            var11_11.putInt(var7_7, var30_30, var15_15);
                                                                            break block39;
                                                                        }
                                                                        case 2: 
                                                                        case 3: {
                                                                            var39_35 = var30_30;
                                                                            var12_12 = var22_22;
                                                                            if (var21_21 != 0) break block38;
                                                                            var21_21 = ArrayDecoders.decodeVarint64(var8_8, var18_18, var10_10);
                                                                            var42_37 = var10_10.long1;
                                                                            var28_28 = var11_11;
                                                                            var41_36 /* !! */  = (byte[])var1_1;
                                                                            var11_11.putLong(var1_1, var30_30, var42_37);
lbl162:
                                                                            // 2 sources

                                                                            var14_14 = var21_21;
                                                                            break block39;
                                                                        }
                                                                        case 1: {
                                                                            var39_35 = var30_30;
                                                                            var12_12 = var22_22;
                                                                            var14_14 = 5;
                                                                            var32_31 = 7.0E-45f;
                                                                            if (var21_21 != var14_14) break block38;
                                                                            var32_31 = ArrayDecoders.decodeFloat(var8_8, var18_18);
                                                                            UnsafeUtil.putFloat(var7_7, var30_30, var32_31);
                                                                            var14_14 = var18_18 + 4;
                                                                            break block39;
                                                                        }
                                                                        case 0: 
                                                                    }
                                                                    var39_35 = var30_30;
                                                                    var12_12 = var22_22;
                                                                    if (var21_21 != var14_14) break block38;
                                                                    var47_40 = ArrayDecoders.decodeDouble(var8_8, var18_18);
                                                                    UnsafeUtil.putDouble(var7_7, var30_30, var47_40);
                                                                }
                                                                var14_14 = var18_18 + 8;
                                                            }
                                                            var15_15 = var20_20;
                                                            var16_16 = var12_12;
                                                        }
lbl186:
                                                        // 2 sources

                                                        while (true) {
                                                            var12_12 = -1;
                                                            var13_13 = 0.0f / 0.0f;
                                                            continue block15;
                                                            break;
                                                        }
                                                    }
                                                    var23_23 = var20_20;
                                                    var49_41 = var18_18;
                                                    var24_24 = var11_11;
                                                    var27_27 = var12_12;
                                                    break block42;
                                                }
                                                var14_14 = 27;
                                                var32_31 = 3.8E-44f;
                                                if (var17_17 == var14_14) {
                                                    if (var21_21 == var12_12) {
                                                        var28_28 = (Internal$ProtobufList)var11_11.getObject(var7_7, var30_30);
                                                        var17_17 = (int)var28_28.isModifiable();
                                                        if (var17_17 == 0) {
                                                            var17_17 = var28_28.size();
                                                            var17_17 = var17_17 == 0 ? 10 : (var17_17 *= 2);
                                                            var28_28 = var28_28.mutableCopyWithCapacity(var17_17);
                                                            var11_11.putObject(var7_7, var30_30, var28_28);
                                                        }
                                                        var44_38 = var28_28;
                                                        var28_28 = var6_6.getMessageFieldSchema(var22_22);
                                                        var15_15 = var19_19;
                                                        var17_17 = var18_18;
                                                        var27_27 = var22_22;
                                                        var22_22 = var4_4;
                                                        var14_14 = ArrayDecoders.decodeMessageList((Schema)var28_28, var19_19, var2_2, var18_18, var4_4, (Internal$ProtobufList)var44_38, var5_5);
                                                        var15_15 = var20_20;
                                                        var16_16 = var27_27;
                                                        ** continue;
                                                    } else {
                                                        ** GOTO lbl219
                                                    }
                                                }
                                                break block43;
                                            }
                                            var27_27 = var22_22;
                                            var23_23 = var20_20;
                                            var49_41 = var18_18;
                                            var24_24 = var11_11;
                                        }
                                        var25_25 = -1;
                                        var26_26 = 0.0f / 0.0f;
                                        break block44;
                                    }
                                    var27_27 = var22_22;
                                    var14_14 = 49;
                                    var32_31 = 6.9E-44f;
                                    if (var17_17 > var14_14) break block45;
                                    var42_37 = var29_29;
                                    var28_28 = this;
                                    var41_36 /* !! */  = (byte[])var1_1;
                                    var12_12 = var17_17;
                                    var17_17 = var18_18;
                                    var22_22 = var4_4;
                                    var29_29 = var19_19;
                                    var3_3 = var21_21;
                                    var21_21 = var20_20;
                                    var23_23 = var20_20;
                                    var20_20 = var3_3;
                                    var49_41 = var18_18;
                                    var18_18 = var27_27;
                                    var24_24 = var11_11;
                                    var50_42 = var12_12;
                                    var25_25 = -1;
                                    var26_26 = 0.0f / 0.0f;
                                    var7_7 = var5_5;
                                    var14_14 = this.parseRepeatedField(var1_1, var2_2, var17_17, var4_4, var19_19, var21_21, var3_3, var27_27, var42_37, var12_12, var30_30, var5_5);
                                    if (var14_14 == var17_17) break block46;
                                    break block47;
                                }
                                var50_42 = var17_17;
                                var3_3 = var21_21;
                                var23_23 = var20_20;
                                var49_41 = var18_18;
                                var24_24 = var11_11;
                                var25_25 = -1;
                                var26_26 = 0.0f / 0.0f;
                                var14_14 = 50;
                                var32_31 = 7.0E-44f;
                                if (var17_17 != var14_14) break block48;
                                var20_20 = var21_21;
                                if (var21_21 != var12_12) break block44;
                                var28_28 = this;
                                var41_36 /* !! */  = (byte[])var1_1;
                                var17_17 = var18_18;
                                var22_22 = var4_4;
                                var29_29 = var27_27;
                                var14_14 = this.parseMapField(var1_1, var2_2, var18_18, var4_4, var27_27, var30_30, var5_5);
                                if (var14_14 == var18_18) break block46;
                                break block47;
                            }
                            var16_16 = var49_41;
                            break block35;
                        }
                        var20_20 = var21_21;
                        var28_28 = this;
                        var41_36 /* !! */  = (byte[])var1_1;
                        var17_17 = var18_18;
                        var22_22 = var4_4;
                        var18_18 = var29_29;
                        var29_29 = var19_19;
                        var21_21 = var23_23;
                        var14_14 = this.parseOneofField(var1_1, var2_2, var49_41, var4_4, var19_19, var23_23, var3_3, var18_18, var50_42, var30_30, var27_27, var5_5);
                        if (var14_14 != var49_41) break block47;
                    }
                    var16_16 = var14_14;
                }
                var51_43 = MessageSchema.getMutableUnknownFields(var1_1);
                var14_14 = var19_19;
                var41_36 /* !! */  = var2_2;
                var17_17 = var4_4;
                var44_38 = var5_5;
                var14_14 = ArrayDecoders.decodeUnknownField(var19_19, var2_2, var16_16, var4_4, var51_43, var5_5);
            }
            var6_6 = this;
            var7_7 = var1_1;
            var8_8 = var2_2;
            var9_9 = var4_4;
            var10_10 = var5_5;
            var11_11 = var24_24;
            var16_16 = var27_27;
            var15_15 = var23_23;
            var12_12 = var25_25;
            var13_13 = var26_26;
        }
        var15_15 = var9_9;
        if (var14_14 == var9_9) {
            return var14_14;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    private int parseRepeatedField(Object object, byte[] byArray, int n10, int n11, int n12, int n13, int n14, int n15, long l10, int n16, long l11, ArrayDecoders$Registers arrayDecoders$Registers) {
        int n17;
        block41: {
            MessageSchema messageSchema = this;
            Object object2 = object;
            Object object3 = byArray;
            int n18 = n10;
            int n19 = n14;
            int n20 = n15;
            long l12 = l11;
            ArrayDecoders$Registers arrayDecoders$Registers2 = arrayDecoders$Registers;
            Unsafe unsafe = UNSAFE;
            Internal$ProtobufList internal$ProtobufList = (Internal$ProtobufList)unsafe.getObject(object, l11);
            int n21 = internal$ProtobufList.isModifiable();
            int n22 = 2;
            if (n21 == 0) {
                n21 = internal$ProtobufList.size();
                n21 = n21 == 0 ? 10 : (n21 *= n22);
                internal$ProtobufList = internal$ProtobufList.mutableCopyWithCapacity(n21);
                unsafe.putObject(object, l12, internal$ProtobufList);
            }
            int n23 = 5;
            int n24 = 1;
            switch (n16) {
                default: {
                    break;
                }
                case 49: {
                    n17 = 3;
                    if (n19 != n17) break;
                    object2 = this.getMessageFieldSchema(n20);
                    n14 = n12;
                    n17 = ArrayDecoders.decodeGroupList((Schema)object2, n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    break block41;
                }
                case 34: 
                case 48: {
                    if (n19 == n22) {
                        n17 = ArrayDecoders.decodePackedSInt64List(byArray, n18, internal$ProtobufList, arrayDecoders$Registers2);
                    } else {
                        if (n19 != 0) break;
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeSInt64List(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    break block41;
                }
                case 33: 
                case 47: {
                    if (n19 == n22) {
                        n17 = ArrayDecoders.decodePackedSInt32List(byArray, n18, internal$ProtobufList, arrayDecoders$Registers2);
                    } else {
                        if (n19 != 0) break;
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeSInt32List(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    break block41;
                }
                case 30: 
                case 44: {
                    if (n19 == n22) {
                        n19 = ArrayDecoders.decodePackedVarint32List(byArray, n18, internal$ProtobufList, arrayDecoders$Registers2);
                    } else {
                        if (n19 != 0) break;
                        n19 = n12;
                        object3 = byArray;
                        n18 = n10;
                        n23 = n11;
                        arrayDecoders$Registers2 = arrayDecoders$Registers;
                        n19 = ArrayDecoders.decodeVarint32List(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    object2 = (GeneratedMessageLite)object2;
                    object3 = ((GeneratedMessageLite)object2).unknownFields;
                    Object object4 = UnknownFieldSetLite.getDefaultInstance();
                    if (object3 == object4) {
                        object3 = null;
                    }
                    object4 = this.getEnumFieldVerifier(n20);
                    UnknownFieldSchema unknownFieldSchema = messageSchema.unknownFieldSchema;
                    n24 = n13;
                    if ((object3 = (Object)((UnknownFieldSetLite)SchemaUtil.filterUnknownEnumList(n13, (List)internal$ProtobufList, (Internal$EnumVerifier)object4, object3, unknownFieldSchema))) != null) {
                        ((GeneratedMessageLite)object2).unknownFields = object3;
                    }
                    n17 = n19;
                    break block41;
                }
                case 28: {
                    if (n19 != n22) break;
                    n14 = n10;
                    n15 = n11;
                    n17 = ArrayDecoders.decodeBytesList(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    break block41;
                }
                case 27: {
                    if (n19 != n22) break;
                    object2 = this.getMessageFieldSchema(n20);
                    n14 = n12;
                    n17 = ArrayDecoders.decodeMessageList((Schema)object2, n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    break block41;
                }
                case 26: {
                    if (n19 != n22) break;
                    long l13 = l10 & 0x20000000L;
                    l12 = 0L;
                    long l14 = l13 - l12;
                    n17 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                    if (n17 == 0) {
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeStringList(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    } else {
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeStringListRequireUtf8(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    break block41;
                }
                case 25: 
                case 42: {
                    if (n19 == n22) {
                        n17 = ArrayDecoders.decodePackedBoolList(byArray, n18, internal$ProtobufList, arrayDecoders$Registers2);
                    } else {
                        if (n19 != 0) break;
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeBoolList(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    break block41;
                }
                case 24: 
                case 31: 
                case 41: 
                case 45: {
                    if (n19 == n22) {
                        n17 = ArrayDecoders.decodePackedFixed32List(byArray, n18, internal$ProtobufList, arrayDecoders$Registers2);
                    } else {
                        if (n19 != n23) break;
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeFixed32List(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    break block41;
                }
                case 23: 
                case 32: 
                case 40: 
                case 46: {
                    if (n19 == n22) {
                        n17 = ArrayDecoders.decodePackedFixed64List(byArray, n18, internal$ProtobufList, arrayDecoders$Registers2);
                    } else {
                        if (n19 != n24) break;
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeFixed64List(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    break block41;
                }
                case 22: 
                case 29: 
                case 39: 
                case 43: {
                    if (n19 == n22) {
                        n17 = ArrayDecoders.decodePackedVarint32List(byArray, n18, internal$ProtobufList, arrayDecoders$Registers2);
                    } else {
                        if (n19 != 0) break;
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeVarint32List(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    break block41;
                }
                case 20: 
                case 21: 
                case 37: 
                case 38: {
                    if (n19 == n22) {
                        n17 = ArrayDecoders.decodePackedVarint64List(byArray, n18, internal$ProtobufList, arrayDecoders$Registers2);
                    } else {
                        if (n19 != 0) break;
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeVarint64List(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    break block41;
                }
                case 19: 
                case 36: {
                    if (n19 == n22) {
                        n17 = ArrayDecoders.decodePackedFloatList(byArray, n18, internal$ProtobufList, arrayDecoders$Registers2);
                    } else {
                        if (n19 != n23) break;
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeFloatList(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    break block41;
                }
                case 18: 
                case 35: {
                    if (n19 == n22) {
                        n17 = ArrayDecoders.decodePackedDoubleList(byArray, n18, internal$ProtobufList, arrayDecoders$Registers2);
                    } else {
                        if (n19 != n24) break;
                        n14 = n10;
                        n15 = n11;
                        n17 = ArrayDecoders.decodeDoubleList(n12, byArray, n10, n11, internal$ProtobufList, arrayDecoders$Registers);
                    }
                    break block41;
                }
            }
            n17 = n18;
        }
        return n17;
    }

    private int positionForFieldNumber(int n10) {
        int n11 = this.minFieldNumber;
        if (n10 >= n11 && n10 <= (n11 = this.maxFieldNumber)) {
            return this.slowPositionForFieldNumber(n10, 0);
        }
        return -1;
    }

    private int positionForFieldNumber(int n10, int n11) {
        int n12 = this.minFieldNumber;
        if (n10 >= n12 && n10 <= (n12 = this.maxFieldNumber)) {
            return this.slowPositionForFieldNumber(n10, n11);
        }
        return -1;
    }

    private int presenceMaskAndOffsetAt(int n10) {
        int[] nArray = this.buffer;
        return nArray[n10 += 2];
    }

    private void readGroupList(Object object, long l10, Reader reader, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        object = this.listFieldSchema.mutableListAt(object, l10);
        reader.readGroupList((List)object, schema, extensionRegistryLite);
    }

    private void readMessageList(Object object, int n10, Reader reader, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        long l10 = MessageSchema.offset(n10);
        object = this.listFieldSchema.mutableListAt(object, l10);
        reader.readMessageList((List)object, schema, extensionRegistryLite);
    }

    private void readString(Object object, int n10, Reader reader) {
        boolean bl2 = MessageSchema.isEnforceUtf8(n10);
        if (bl2) {
            long l10 = MessageSchema.offset(n10);
            String string2 = reader.readStringRequireUtf8();
            UnsafeUtil.putObject(object, l10, (Object)string2);
        } else {
            bl2 = this.lite;
            if (bl2) {
                long l11 = MessageSchema.offset(n10);
                String string3 = reader.readString();
                UnsafeUtil.putObject(object, l11, (Object)string3);
            } else {
                long l12 = MessageSchema.offset(n10);
                ByteString byteString = reader.readBytes();
                UnsafeUtil.putObject(object, l12, (Object)byteString);
            }
        }
    }

    private void readStringList(Object object, int n10, Reader reader) {
        boolean bl2 = MessageSchema.isEnforceUtf8(n10);
        if (bl2) {
            ListFieldSchema listFieldSchema = this.listFieldSchema;
            long l10 = MessageSchema.offset(n10);
            object = listFieldSchema.mutableListAt(object, l10);
            reader.readStringListRequireUtf8((List)object);
        } else {
            ListFieldSchema listFieldSchema = this.listFieldSchema;
            long l11 = MessageSchema.offset(n10);
            object = listFieldSchema.mutableListAt(object, l11);
            reader.readStringList((List)object);
        }
    }

    private static Field reflectField(Class object, String string2) {
        try {
            return ((Class)object).getDeclaredField(string2);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Object[] objectArray = ((Class)object).getDeclaredFields();
            int n10 = objectArray.length;
            StringBuilder stringBuilder = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                Field field = objectArray[i10];
                String string3 = field.getName();
                boolean bl2 = string2.equals(string3);
                if (!bl2) continue;
                return field;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Field ");
            stringBuilder.append(string2);
            stringBuilder.append(" for ");
            object = ((Class)object).getName();
            stringBuilder.append((String)object);
            stringBuilder.append(" not found. Known fields are ");
            object = Arrays.toString(objectArray);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException((String)object);
            throw runtimeException;
        }
    }

    private void setFieldPresent(Object object, int n10) {
        int n11 = this.proto3;
        if (n11 != 0) {
            return;
        }
        n10 = this.presenceMaskAndOffsetAt(n10);
        int n12 = n10 >>> 20;
        n11 = 1 << n12;
        long l10 = n10 & 0xFFFFF;
        n10 = UnsafeUtil.getInt(object, l10) | n11;
        UnsafeUtil.putInt(object, l10, n10);
    }

    private void setOneofPresent(Object object, int n10, int n11) {
        long l10 = this.presenceMaskAndOffsetAt(n11) & 0xFFFFF;
        UnsafeUtil.putInt(object, l10, n10);
    }

    private int slowPositionForFieldNumber(int n10, int n11) {
        int[] nArray = this.buffer;
        int n12 = nArray.length / 3 + -1;
        while (n11 <= n12) {
            int n13 = n12 + n11 >>> 1;
            int n14 = n13 * 3;
            int n15 = this.numberAt(n14);
            if (n10 == n15) {
                return n14;
            }
            if (n10 < n15) {
                n12 = n13 += -1;
                continue;
            }
            n11 = ++n13;
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static void storeFieldData(FieldInfo var0, int[] var1_1, int var2_2, boolean var3_3, Object[] var4_4) {
        var5_5 = var0.getOneof();
        var6_6 = 0;
        if (var5_5 != null) {
            var7_7 /* !! */  = var0.getType();
            var3_3 = var7_7 /* !! */ .id() + 51;
            var8_8 = var5_5.getValueField();
            var9_10 = UnsafeUtil.objectFieldOffset(var8_8);
            var11_12 = (int)var9_10;
            var5_5 = var5_5.getCaseField();
            var12_13 = UnsafeUtil.objectFieldOffset((Field)var5_5);
            var14_14 = (int)var12_13;
lbl12:
            // 2 sources

            while (true) {
                var15_15 = var11_12;
                var11_12 = var14_14;
                var14_14 = 0;
                var5_5 = null;
                break;
            }
        } else {
            var5_5 = var0.getType();
            var8_9 = var0.getField();
            var9_11 = UnsafeUtil.objectFieldOffset(var8_9);
            var11_12 = (int)var9_11;
            var15_15 = var5_5.id();
            if (!(var3_3 || (var3_3 = var5_5.isList()) || (var3_3 = var5_5.isMap()))) {
                var7_7 /* !! */  = var0.getPresenceField();
                var16_16 = UnsafeUtil.objectFieldOffset((Field)var7_7 /* !! */ );
                var14_14 = (int)var16_16;
                var3_3 = Integer.numberOfTrailingZeros(var0.getPresenceMask());
                var18_18 = var14_14;
                var14_14 = (int)var3_3;
                var3_3 = var15_15;
                var15_15 = var11_12;
                var11_12 = var18_18;
            } else {
                var7_7 /* !! */  = var0.getCachedSizeField();
                if (var7_7 /* !! */  == null) {
                    var14_14 = 0;
                    var5_5 = null;
                    var3_3 = var15_15;
                    var15_15 = var11_12;
                    var11_12 = 0;
                    var8_9 = null;
                } else {
                    var7_7 /* !! */  = var0.getCachedSizeField();
                    var16_17 = UnsafeUtil.objectFieldOffset((Field)var7_7 /* !! */ );
                    var14_14 = (int)var16_17;
                    var3_3 = var15_15;
                    ** continue;
                }
            }
        }
        var1_1 /* !! */ [var2_2] = var19_19 = var0.getFieldNumber();
        var19_19 = var2_2 + 1;
        var20_20 = var0.isEnforceUtf8();
        var20_20 = var20_20 != 0 ? 0x20000000 : 0;
        var21_21 = var0.isRequired();
        if (var21_21) {
            var6_6 = 0x10000000;
        }
        var3_3 = var3_3 << 20 | (var6_6 |= var20_20) | var15_15;
        var1_1 /* !! */ [var19_19] = (int)var3_3;
        var3_3 = var2_2 + 2;
        var1_1 /* !! */ [var3_3] = var14_14 = var14_14 << 20 | var11_12;
        var1_1 /* !! */  = (int[])var0.getMessageFieldClass();
        var7_7 /* !! */  = var0.getMapDefaultEntry();
        if (var7_7 /* !! */  != null) {
            var2_2 = var2_2 / 3 * 2;
            var7_7 /* !! */  = var0.getMapDefaultEntry();
            var4_4[var2_2] = var7_7 /* !! */ ;
            if (var1_1 /* !! */  != null) {
                var4_4[++var2_2] = var1_1 /* !! */ ;
            } else {
                var1_1 /* !! */  = (int[])var0.getEnumVerifier();
                if (var1_1 /* !! */  != null) {
                    var4_4[++var2_2] = var0 = var0.getEnumVerifier();
                }
            }
        } else if (var1_1 /* !! */  != null) {
            var2_2 = var2_2 / 3 * 2 + 1;
            var4_4[var2_2] = var1_1 /* !! */ ;
        } else {
            var1_1 /* !! */  = (int[])var0.getEnumVerifier();
            if (var1_1 /* !! */  != null) {
                var2_2 = var2_2 / 3 * 2 + 1;
                var4_4[var2_2] = var0 = var0.getEnumVerifier();
            }
        }
    }

    private static int type(int n10) {
        return (n10 & 0xFF00000) >>> 20;
    }

    private int typeAndOffsetAt(int n10) {
        int[] nArray = this.buffer;
        return nArray[++n10];
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void writeFieldsInAscendingOrderProto2(Object var1_1, Writer var2_2) {
        var3_3 = this;
        var4_4 = var1_1;
        var5_5 = var2_2;
        var6_6 = this.hasExtensions;
        if (var6_6 && (var8_8 = (var7_7 = this.extensionSchema.getExtensions(var1_1)).isEmpty()) == 0) {
            var7_7 = var7_7.iterator();
            var9_9 = (Map.Entry)var7_7.next();
        } else {
            var6_6 = false;
            var7_7 = null;
            var8_8 = 0;
            var9_9 = null;
        }
        var10_10 = -1;
        var11_11 = var3_3.buffer;
        var12_12 = var11_11.length;
        var13_13 = MessageSchema.UNSAFE;
        var15_15 = 0;
        for (var14_14 = 0; var14_14 < var12_12; var14_14 += 3) {
            var16_16 = var3_3.typeAndOffsetAt(var14_14);
            var17_17 = var3_3.numberAt(var14_14);
            var18_18 = MessageSchema.type((int)var16_16);
            var19_19 = var3_3.proto3;
            if (var19_19 == 0 && var18_18 <= (var19_19 = 17)) {
                var20_20 /* !! */  = var3_3.buffer;
                var21_21 = var14_14 + 2;
                var19_19 = var20_20 /* !! */ [var21_21];
                var21_21 = 1048575;
                var22_22 = var19_19 & var21_21;
                var23_23 = var9_9;
                if (var22_22 != var10_10) {
                    var24_24 = var22_22;
                    var15_15 = var13_13.getInt(var4_4, var24_24);
                    var10_10 = var22_22;
                }
                var26_25 = var19_19 >>> 20;
                var8_8 = 1;
                var26_25 = var8_8 << var26_25;
                var9_9 = var23_23;
            } else {
                var23_23 = var9_9;
                var26_25 = 0;
                var27_26 = 0.0f;
                var28_27 = null;
            }
            while (var9_9 != null && (var22_22 = (var29_28 = var3_3.extensionSchema).extensionNumber((Map.Entry)var9_9)) <= var17_17) {
                var29_28 = var3_3.extensionSchema;
                var29_28.serializeExtension(var5_5, (Map.Entry)var9_9);
                var8_8 = var7_7.hasNext();
                if (var8_8 != 0) {
                    var9_9 = (Map.Entry)var7_7.next();
                    continue;
                }
                var8_8 = 0;
                var9_9 = null;
            }
            var20_20 /* !! */  = (int[])var9_9;
            var22_22 = var10_10;
            var30_29 = MessageSchema.offset((int)var16_16);
            switch (var18_18) lbl-1000:
            // 56 sources

            {
                default: {
                    var16_16 = false;
                    break;
                }
                case 68: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var28_27 = var13_13.getObject(var4_4, var30_29);
                    var9_9 = var3_3.getMessageFieldSchema(var14_14);
                    var5_5.writeGroup(var17_17, var28_27, (Schema)var9_9);
                    ** GOTO lbl-1000
                }
                case 67: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var24_24 = MessageSchema.oneofLongAt(var4_4, var30_29);
                    var5_5.writeSInt64(var17_17, var24_24);
                    ** GOTO lbl-1000
                }
                case 66: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var26_25 = MessageSchema.oneofIntAt(var4_4, var30_29);
                    var5_5.writeSInt32(var17_17, var26_25);
                    ** GOTO lbl-1000
                }
                case 65: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var24_24 = MessageSchema.oneofLongAt(var4_4, var30_29);
                    var5_5.writeSFixed64(var17_17, var24_24);
                    ** GOTO lbl-1000
                }
                case 64: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var26_25 = MessageSchema.oneofIntAt(var4_4, var30_29);
                    var5_5.writeSFixed32(var17_17, var26_25);
                    ** GOTO lbl-1000
                }
                case 63: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var26_25 = MessageSchema.oneofIntAt(var4_4, var30_29);
                    var5_5.writeEnum(var17_17, var26_25);
                    ** GOTO lbl-1000
                }
                case 62: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var26_25 = MessageSchema.oneofIntAt(var4_4, var30_29);
                    var5_5.writeUInt32(var17_17, var26_25);
                    ** GOTO lbl-1000
                }
                case 61: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var28_27 = (ByteString)var13_13.getObject(var4_4, var30_29);
                    var5_5.writeBytes(var17_17, (ByteString)var28_27);
                    ** GOTO lbl-1000
                }
                case 60: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var28_27 = var13_13.getObject(var4_4, var30_29);
                    var9_9 = var3_3.getMessageFieldSchema(var14_14);
                    var5_5.writeMessage(var17_17, var28_27, (Schema)var9_9);
                    ** GOTO lbl-1000
                }
                case 59: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var28_27 = var13_13.getObject(var4_4, var30_29);
                    var3_3.writeString(var17_17, var28_27, var5_5);
                    ** GOTO lbl-1000
                }
                case 58: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var26_25 = (int)MessageSchema.oneofBooleanAt(var4_4, var30_29);
                    var5_5.writeBool(var17_17, (boolean)var26_25);
                    ** GOTO lbl-1000
                }
                case 57: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var26_25 = MessageSchema.oneofIntAt(var4_4, var30_29);
                    var5_5.writeFixed32(var17_17, var26_25);
                    ** GOTO lbl-1000
                }
                case 56: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var24_24 = MessageSchema.oneofLongAt(var4_4, var30_29);
                    var5_5.writeFixed64(var17_17, var24_24);
                    ** GOTO lbl-1000
                }
                case 55: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var26_25 = MessageSchema.oneofIntAt(var4_4, var30_29);
                    var5_5.writeInt32(var17_17, var26_25);
                    ** GOTO lbl-1000
                }
                case 54: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var24_24 = MessageSchema.oneofLongAt(var4_4, var30_29);
                    var5_5.writeUInt64(var17_17, var24_24);
                    ** GOTO lbl-1000
                }
                case 53: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var24_24 = MessageSchema.oneofLongAt(var4_4, var30_29);
                    var5_5.writeInt64(var17_17, var24_24);
                    ** GOTO lbl-1000
                }
                case 52: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var27_26 = MessageSchema.oneofFloatAt(var4_4, var30_29);
                    var5_5.writeFloat(var17_17, var27_26);
                    ** GOTO lbl-1000
                }
                case 51: {
                    var26_25 = (int)var3_3.isOneofPresent(var4_4, var17_17, var14_14);
                    if (var26_25 == 0) ** GOTO lbl-1000
                    var32_30 = MessageSchema.oneofDoubleAt(var4_4, var30_29);
                    var5_5.writeDouble(var17_17, var32_30);
                    ** GOTO lbl-1000
                }
                case 50: {
                    var28_27 = var13_13.getObject(var4_4, var30_29);
                    var3_3.writeMapHelper(var5_5, var17_17, var28_27, var14_14);
                    ** GOTO lbl-1000
                }
                case 49: {
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    var34_31 = var3_3.getMessageFieldSchema(var14_14);
                    SchemaUtil.writeGroupList(var26_25, (List)var9_9, var5_5, var34_31);
                    ** GOTO lbl-1000
                }
                case 48: {
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    var16_16 = true;
                    SchemaUtil.writeSInt64List(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 47: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeSInt32List(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 46: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeSFixed64List(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 45: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeSFixed32List(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 44: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeEnumList(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 43: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeUInt32List(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 42: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeBoolList(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 41: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeFixed32List(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 40: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeFixed64List(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 39: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeInt32List(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 38: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeUInt64List(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 37: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeInt64List(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 36: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeFloatList(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 35: {
                    var16_16 = true;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeDoubleList(var26_25, (List)var9_9, var5_5, var16_16);
                    ** GOTO lbl-1000
                }
                case 34: {
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    var16_16 = false;
                    SchemaUtil.writeSInt64List(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 33: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeSInt32List(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 32: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeSFixed64List(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 31: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeSFixed32List(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 30: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeEnumList(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 29: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeUInt32List(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 28: {
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeBytesList(var26_25, (List)var9_9, var5_5);
                    ** GOTO lbl-1000
                }
                case 27: {
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    var34_31 = var3_3.getMessageFieldSchema(var14_14);
                    SchemaUtil.writeMessageList(var26_25, (List)var9_9, var5_5, var34_31);
                    ** GOTO lbl-1000
                }
                case 26: {
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeStringList(var26_25, (List)var9_9, var5_5);
                    ** GOTO lbl-1000
                }
                case 25: {
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    var16_16 = false;
                    SchemaUtil.writeBoolList(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 24: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeFixed32List(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 23: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeFixed64List(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 22: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeInt32List(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 21: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeUInt64List(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 20: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeInt64List(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 19: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeFloatList(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 18: {
                    var16_16 = false;
                    var26_25 = var3_3.numberAt(var14_14);
                    var9_9 = (List)var13_13.getObject(var4_4, var30_29);
                    SchemaUtil.writeDoubleList(var26_25, (List)var9_9, var5_5, false);
                    break;
                }
                case 17: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var28_27 = var13_13.getObject(var4_4, var30_29);
                    var9_9 = var3_3.getMessageFieldSchema(var14_14);
                    var5_5.writeGroup(var17_17, var28_27, (Schema)var9_9);
                    break;
                }
                case 16: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var24_24 = var13_13.getLong(var4_4, var30_29);
                    var5_5.writeSInt64(var17_17, var24_24);
                    break;
                }
                case 15: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var26_25 = var13_13.getInt(var4_4, var30_29);
                    var5_5.writeSInt32(var17_17, var26_25);
                    break;
                }
                case 14: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var24_24 = var13_13.getLong(var4_4, var30_29);
                    var5_5.writeSFixed64(var17_17, var24_24);
                    break;
                }
                case 13: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var26_25 = var13_13.getInt(var4_4, var30_29);
                    var5_5.writeSFixed32(var17_17, var26_25);
                    break;
                }
                case 12: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var26_25 = var13_13.getInt(var4_4, var30_29);
                    var5_5.writeEnum(var17_17, var26_25);
                    break;
                }
                case 11: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var26_25 = var13_13.getInt(var4_4, var30_29);
                    var5_5.writeUInt32(var17_17, var26_25);
                    break;
                }
                case 10: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var28_27 = (ByteString)var13_13.getObject(var4_4, var30_29);
                    var5_5.writeBytes(var17_17, (ByteString)var28_27);
                    break;
                }
                case 9: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var28_27 = var13_13.getObject(var4_4, var30_29);
                    var9_9 = var3_3.getMessageFieldSchema(var14_14);
                    var5_5.writeMessage(var17_17, var28_27, (Schema)var9_9);
                    break;
                }
                case 8: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var28_27 = var13_13.getObject(var4_4, var30_29);
                    var3_3.writeString(var17_17, var28_27, var5_5);
                    break;
                }
                case 7: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var26_25 = (int)MessageSchema.booleanAt(var4_4, var30_29);
                    var5_5.writeBool(var17_17, (boolean)var26_25);
                    break;
                }
                case 6: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var26_25 = var13_13.getInt(var4_4, var30_29);
                    var5_5.writeFixed32(var17_17, var26_25);
                    break;
                }
                case 5: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var24_24 = var13_13.getLong(var4_4, var30_29);
                    var5_5.writeFixed64(var17_17, var24_24);
                    break;
                }
                case 4: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var26_25 = var13_13.getInt(var4_4, var30_29);
                    var5_5.writeInt32(var17_17, var26_25);
                    break;
                }
                case 3: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var24_24 = var13_13.getLong(var4_4, var30_29);
                    var5_5.writeUInt64(var17_17, var24_24);
                    break;
                }
                case 2: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var24_24 = var13_13.getLong(var4_4, var30_29);
                    var5_5.writeInt64(var17_17, var24_24);
                    break;
                }
                case 1: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var27_26 = MessageSchema.floatAt(var4_4, var30_29);
                    var5_5.writeFloat(var17_17, var27_26);
                    break;
                }
                case 0: {
                    var16_16 = false;
                    if ((var26_25 &= var15_15) == 0) break;
                    var32_30 = MessageSchema.doubleAt(var4_4, var30_29);
                    var5_5.writeDouble(var17_17, var32_30);
                }
            }
            var10_10 = var22_22;
            var9_9 = var20_20 /* !! */ ;
        }
        var23_23 = var9_9;
        while (var9_9 != null) {
            var28_27 = var3_3.extensionSchema;
            var28_27.serializeExtension(var5_5, (Map.Entry)var9_9);
            var26_25 = var7_7.hasNext();
            if (var26_25 != 0) {
                var9_9 = var28_27 = (Map.Entry)var7_7.next();
                continue;
            }
            var8_8 = 0;
            var9_9 = null;
        }
        var7_7 = var3_3.unknownFieldSchema;
        var3_3.writeUnknownInMessageTo((UnknownFieldSchema)var7_7, var4_4, var5_5);
    }

    private void writeFieldsInAscendingOrderProto3(Object object, Writer writer) {
        Map.Entry entry;
        Object object2;
        boolean bl2;
        boolean bl3 = this.hasExtensions;
        if (bl3 && !(bl2 = ((FieldSet)(object2 = this.extensionSchema.getExtensions(object))).isEmpty())) {
            object2 = ((FieldSet)object2).iterator();
            entry = (Map.Entry)object2.next();
        } else {
            bl3 = false;
            object2 = null;
            bl2 = false;
            entry = null;
        }
        Object object3 = this.buffer;
        int n10 = ((int[])object3).length;
        block71: for (int i10 = 0; i10 < n10; i10 += 3) {
            Object object4;
            int n11;
            int n12 = this.typeAndOffsetAt(i10);
            int n13 = this.numberAt(i10);
            while (entry != null && (n11 = ((ExtensionSchema)(object4 = this.extensionSchema)).extensionNumber(entry)) <= n13) {
                object4 = this.extensionSchema;
                ((ExtensionSchema)object4).serializeExtension(writer, entry);
                bl2 = object2.hasNext();
                if (bl2) {
                    entry = (Map.Entry)object2.next();
                    continue;
                }
                bl2 = false;
                entry = null;
            }
            n11 = MessageSchema.type(n12);
            boolean bl4 = true;
            switch (n11) {
                default: {
                    continue block71;
                }
                case 68: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    writer.writeGroup(n13, object5, (Schema)object4);
                    continue block71;
                }
                case 67: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    l10 = MessageSchema.oneofLongAt(object, l10);
                    writer.writeSInt64(n13, l10);
                    continue block71;
                }
                case 66: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeSInt32(n13, n12);
                    continue block71;
                }
                case 65: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    l10 = MessageSchema.oneofLongAt(object, l10);
                    writer.writeSFixed64(n13, l10);
                    continue block71;
                }
                case 64: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeSFixed32(n13, n12);
                    continue block71;
                }
                case 63: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeEnum(n13, n12);
                    continue block71;
                }
                case 62: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeUInt32(n13, n12);
                    continue block71;
                }
                case 61: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (ByteString)UnsafeUtil.getObject(object, l10);
                    writer.writeBytes(n13, (ByteString)object5);
                    continue block71;
                }
                case 60: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    writer.writeMessage(n13, object5, (Schema)object4);
                    continue block71;
                }
                case 59: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    this.writeString(n13, object5, writer);
                    continue block71;
                }
                case 58: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = (int)(MessageSchema.oneofBooleanAt(object, l10) ? 1 : 0);
                    writer.writeBool(n13, n12 != 0);
                    continue block71;
                }
                case 57: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeFixed32(n13, n12);
                    continue block71;
                }
                case 56: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    l10 = MessageSchema.oneofLongAt(object, l10);
                    writer.writeFixed64(n13, l10);
                    continue block71;
                }
                case 55: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeInt32(n13, n12);
                    continue block71;
                }
                case 54: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    l10 = MessageSchema.oneofLongAt(object, l10);
                    writer.writeUInt64(n13, l10);
                    continue block71;
                }
                case 53: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    l10 = MessageSchema.oneofLongAt(object, l10);
                    writer.writeInt64(n13, l10);
                    continue block71;
                }
                case 52: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    float f10 = MessageSchema.oneofFloatAt(object, l10);
                    writer.writeFloat(n13, f10);
                    continue block71;
                }
                case 51: {
                    n11 = (int)(this.isOneofPresent(object, n13, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    double d10 = MessageSchema.oneofDoubleAt(object, l10);
                    writer.writeDouble(n13, d10);
                    continue block71;
                }
                case 50: {
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    this.writeMapHelper(writer, n13, object5, i10);
                    continue block71;
                }
                case 49: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    SchemaUtil.writeGroupList(n13, (List)object5, writer, (Schema)object4);
                    continue block71;
                }
                case 48: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeSInt64List(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 47: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeSInt32List(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 46: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeSFixed64List(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 45: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeSFixed32List(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 44: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeEnumList(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 43: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeUInt32List(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 42: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeBoolList(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 41: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeFixed32List(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 40: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeFixed64List(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 39: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeInt32List(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 38: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeUInt64List(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 37: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeInt64List(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 36: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeFloatList(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 35: {
                    n13 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeDoubleList(n13, (List)object5, writer, bl4);
                    continue block71;
                }
                case 34: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeSInt64List(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 33: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeSInt32List(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 32: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeSFixed64List(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 31: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeSFixed32List(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 30: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeEnumList(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 29: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeUInt32List(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 28: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeBytesList(n13, (List)object5, writer);
                    continue block71;
                }
                case 27: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    SchemaUtil.writeMessageList(n13, (List)object5, writer, (Schema)object4);
                    continue block71;
                }
                case 26: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeStringList(n13, (List)object5, writer);
                    continue block71;
                }
                case 25: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeBoolList(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 24: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeFixed32List(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 23: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeFixed64List(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 22: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeInt32List(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 21: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeUInt64List(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 20: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeInt64List(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 19: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeFloatList(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 18: {
                    n13 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeDoubleList(n13, (List)object5, writer, false);
                    continue block71;
                }
                case 17: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    writer.writeGroup(n13, object5, (Schema)object4);
                    continue block71;
                }
                case 16: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    l10 = MessageSchema.longAt(object, l10);
                    writer.writeSInt64(n13, l10);
                    continue block71;
                }
                case 15: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.intAt(object, l10);
                    writer.writeSInt32(n13, n12);
                    continue block71;
                }
                case 14: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    l10 = MessageSchema.longAt(object, l10);
                    writer.writeSFixed64(n13, l10);
                    continue block71;
                }
                case 13: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.intAt(object, l10);
                    writer.writeSFixed32(n13, n12);
                    continue block71;
                }
                case 12: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.intAt(object, l10);
                    writer.writeEnum(n13, n12);
                    continue block71;
                }
                case 11: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.intAt(object, l10);
                    writer.writeUInt32(n13, n12);
                    continue block71;
                }
                case 10: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = (ByteString)UnsafeUtil.getObject(object, l10);
                    writer.writeBytes(n13, (ByteString)object5);
                    continue block71;
                }
                case 9: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    writer.writeMessage(n13, object5, (Schema)object4);
                    continue block71;
                }
                case 8: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    this.writeString(n13, object5, writer);
                    continue block71;
                }
                case 7: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = (int)(MessageSchema.booleanAt(object, l10) ? 1 : 0);
                    writer.writeBool(n13, n12 != 0);
                    continue block71;
                }
                case 6: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.intAt(object, l10);
                    writer.writeFixed32(n13, n12);
                    continue block71;
                }
                case 5: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    l10 = MessageSchema.longAt(object, l10);
                    writer.writeFixed64(n13, l10);
                    continue block71;
                }
                case 4: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    n12 = MessageSchema.intAt(object, l10);
                    writer.writeInt32(n13, n12);
                    continue block71;
                }
                case 3: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    l10 = MessageSchema.longAt(object, l10);
                    writer.writeUInt64(n13, l10);
                    continue block71;
                }
                case 2: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    l10 = MessageSchema.longAt(object, l10);
                    writer.writeInt64(n13, l10);
                    continue block71;
                }
                case 1: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    float f10 = MessageSchema.floatAt(object, l10);
                    writer.writeFloat(n13, f10);
                    continue block71;
                }
                case 0: {
                    n11 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n11 == 0) continue block71;
                    long l10 = MessageSchema.offset(n12);
                    double d10 = MessageSchema.doubleAt(object, l10);
                    writer.writeDouble(n13, d10);
                }
            }
        }
        while (entry != null) {
            object3 = this.extensionSchema;
            ((ExtensionSchema)object3).serializeExtension(writer, entry);
            bl2 = object2.hasNext();
            if (bl2) {
                entry = (Map.Entry)object2.next();
                continue;
            }
            bl2 = false;
            entry = null;
        }
        object2 = this.unknownFieldSchema;
        this.writeUnknownInMessageTo((UnknownFieldSchema)object2, object, writer);
    }

    private void writeFieldsInDescendingOrder(Object object, Writer writer) {
        Object object2;
        boolean bl2;
        Object object3 = this.unknownFieldSchema;
        this.writeUnknownInMessageTo((UnknownFieldSchema)object3, object, writer);
        boolean bl3 = this.hasExtensions;
        if (bl3 && !(bl2 = ((FieldSet)(object3 = this.extensionSchema.getExtensions(object))).isEmpty())) {
            object3 = ((FieldSet)object3).descendingIterator();
            object2 = (Map.Entry)object3.next();
        } else {
            bl3 = false;
            object3 = null;
            bl2 = false;
            object2 = null;
        }
        int[] nArray = this.buffer;
        block71: for (int i10 = nArray.length + -3; i10 >= 0; i10 += -3) {
            Object object4;
            int n10;
            int n11 = this.typeAndOffsetAt(i10);
            int n12 = this.numberAt(i10);
            while (object2 != null && (n10 = ((ExtensionSchema)(object4 = this.extensionSchema)).extensionNumber((Map.Entry)object2)) > n12) {
                object4 = this.extensionSchema;
                ((ExtensionSchema)object4).serializeExtension(writer, (Map.Entry)object2);
                bl2 = object3.hasNext();
                if (bl2) {
                    object2 = (Map.Entry)object3.next();
                    continue;
                }
                bl2 = false;
                object2 = null;
            }
            n10 = MessageSchema.type(n11);
            boolean bl4 = true;
            switch (n10) {
                default: {
                    continue block71;
                }
                case 68: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    writer.writeGroup(n12, object5, (Schema)object4);
                    continue block71;
                }
                case 67: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    l10 = MessageSchema.oneofLongAt(object, l10);
                    writer.writeSInt64(n12, l10);
                    continue block71;
                }
                case 66: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeSInt32(n12, n11);
                    continue block71;
                }
                case 65: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    l10 = MessageSchema.oneofLongAt(object, l10);
                    writer.writeSFixed64(n12, l10);
                    continue block71;
                }
                case 64: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeSFixed32(n12, n11);
                    continue block71;
                }
                case 63: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeEnum(n12, n11);
                    continue block71;
                }
                case 62: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeUInt32(n12, n11);
                    continue block71;
                }
                case 61: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (ByteString)UnsafeUtil.getObject(object, l10);
                    writer.writeBytes(n12, (ByteString)object5);
                    continue block71;
                }
                case 60: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    writer.writeMessage(n12, object5, (Schema)object4);
                    continue block71;
                }
                case 59: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    this.writeString(n12, object5, writer);
                    continue block71;
                }
                case 58: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = (int)(MessageSchema.oneofBooleanAt(object, l10) ? 1 : 0);
                    writer.writeBool(n12, n11 != 0);
                    continue block71;
                }
                case 57: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeFixed32(n12, n11);
                    continue block71;
                }
                case 56: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    l10 = MessageSchema.oneofLongAt(object, l10);
                    writer.writeFixed64(n12, l10);
                    continue block71;
                }
                case 55: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.oneofIntAt(object, l10);
                    writer.writeInt32(n12, n11);
                    continue block71;
                }
                case 54: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    l10 = MessageSchema.oneofLongAt(object, l10);
                    writer.writeUInt64(n12, l10);
                    continue block71;
                }
                case 53: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    l10 = MessageSchema.oneofLongAt(object, l10);
                    writer.writeInt64(n12, l10);
                    continue block71;
                }
                case 52: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    float f10 = MessageSchema.oneofFloatAt(object, l10);
                    writer.writeFloat(n12, f10);
                    continue block71;
                }
                case 51: {
                    n10 = (int)(this.isOneofPresent(object, n12, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    double d10 = MessageSchema.oneofDoubleAt(object, l10);
                    writer.writeDouble(n12, d10);
                    continue block71;
                }
                case 50: {
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    this.writeMapHelper(writer, n12, object5, i10);
                    continue block71;
                }
                case 49: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    SchemaUtil.writeGroupList(n12, (List)object5, writer, (Schema)object4);
                    continue block71;
                }
                case 48: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeSInt64List(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 47: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeSInt32List(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 46: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeSFixed64List(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 45: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeSFixed32List(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 44: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeEnumList(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 43: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeUInt32List(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 42: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeBoolList(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 41: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeFixed32List(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 40: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeFixed64List(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 39: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeInt32List(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 38: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeUInt64List(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 37: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeInt64List(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 36: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeFloatList(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 35: {
                    n12 = this.numberAt(i10);
                    long l11 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l11);
                    SchemaUtil.writeDoubleList(n12, (List)object5, writer, bl4);
                    continue block71;
                }
                case 34: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeSInt64List(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 33: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeSInt32List(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 32: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeSFixed64List(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 31: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeSFixed32List(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 30: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeEnumList(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 29: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeUInt32List(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 28: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeBytesList(n12, (List)object5, writer);
                    continue block71;
                }
                case 27: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    SchemaUtil.writeMessageList(n12, (List)object5, writer, (Schema)object4);
                    continue block71;
                }
                case 26: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeStringList(n12, (List)object5, writer);
                    continue block71;
                }
                case 25: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeBoolList(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 24: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeFixed32List(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 23: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeFixed64List(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 22: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeInt32List(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 21: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeUInt64List(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 20: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeInt64List(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 19: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeFloatList(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 18: {
                    n12 = this.numberAt(i10);
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (List)UnsafeUtil.getObject(object, l10);
                    SchemaUtil.writeDoubleList(n12, (List)object5, writer, false);
                    continue block71;
                }
                case 17: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    writer.writeGroup(n12, object5, (Schema)object4);
                    continue block71;
                }
                case 16: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    l10 = MessageSchema.longAt(object, l10);
                    writer.writeSInt64(n12, l10);
                    continue block71;
                }
                case 15: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.intAt(object, l10);
                    writer.writeSInt32(n12, n11);
                    continue block71;
                }
                case 14: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    l10 = MessageSchema.longAt(object, l10);
                    writer.writeSFixed64(n12, l10);
                    continue block71;
                }
                case 13: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.intAt(object, l10);
                    writer.writeSFixed32(n12, n11);
                    continue block71;
                }
                case 12: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.intAt(object, l10);
                    writer.writeEnum(n12, n11);
                    continue block71;
                }
                case 11: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.intAt(object, l10);
                    writer.writeUInt32(n12, n11);
                    continue block71;
                }
                case 10: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = (ByteString)UnsafeUtil.getObject(object, l10);
                    writer.writeBytes(n12, (ByteString)object5);
                    continue block71;
                }
                case 9: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    object4 = this.getMessageFieldSchema(i10);
                    writer.writeMessage(n12, object5, (Schema)object4);
                    continue block71;
                }
                case 8: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    Object object5 = UnsafeUtil.getObject(object, l10);
                    this.writeString(n12, object5, writer);
                    continue block71;
                }
                case 7: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = (int)(MessageSchema.booleanAt(object, l10) ? 1 : 0);
                    writer.writeBool(n12, n11 != 0);
                    continue block71;
                }
                case 6: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.intAt(object, l10);
                    writer.writeFixed32(n12, n11);
                    continue block71;
                }
                case 5: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    l10 = MessageSchema.longAt(object, l10);
                    writer.writeFixed64(n12, l10);
                    continue block71;
                }
                case 4: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    n11 = MessageSchema.intAt(object, l10);
                    writer.writeInt32(n12, n11);
                    continue block71;
                }
                case 3: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    l10 = MessageSchema.longAt(object, l10);
                    writer.writeUInt64(n12, l10);
                    continue block71;
                }
                case 2: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    l10 = MessageSchema.longAt(object, l10);
                    writer.writeInt64(n12, l10);
                    continue block71;
                }
                case 1: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    float f10 = MessageSchema.floatAt(object, l10);
                    writer.writeFloat(n12, f10);
                    continue block71;
                }
                case 0: {
                    n10 = (int)(this.isFieldPresent(object, i10) ? 1 : 0);
                    if (n10 == 0) continue block71;
                    long l10 = MessageSchema.offset(n11);
                    double d10 = MessageSchema.doubleAt(object, l10);
                    writer.writeDouble(n12, d10);
                }
            }
        }
        while (object2 != null) {
            object = this.extensionSchema;
            ((ExtensionSchema)object).serializeExtension(writer, (Map.Entry)object2);
            boolean bl5 = object3.hasNext();
            if (bl5) {
                object2 = object = (Map.Entry)object3.next();
                continue;
            }
            bl2 = false;
            object2 = null;
        }
    }

    private void writeMapHelper(Writer writer, int n10, Object object, int n11) {
        if (object != null) {
            MapFieldSchema mapFieldSchema = this.mapFieldSchema;
            Object object2 = this.getMapFieldDefaultEntry(n11);
            object2 = mapFieldSchema.forMapMetadata(object2);
            mapFieldSchema = this.mapFieldSchema;
            object = mapFieldSchema.forMapData(object);
            writer.writeMap(n10, (MapEntryLite$Metadata)object2, (Map)object);
        }
    }

    private void writeString(int n10, Object object, Writer writer) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            object = (String)object;
            writer.writeString(n10, (String)object);
        } else {
            object = (ByteString)object;
            writer.writeBytes(n10, (ByteString)object);
        }
    }

    private void writeUnknownInMessageTo(UnknownFieldSchema unknownFieldSchema, Object object, Writer writer) {
        object = unknownFieldSchema.getFromMessage(object);
        unknownFieldSchema.writeTo(object, writer);
    }

    public boolean equals(Object object, Object object2) {
        Object object3 = this.buffer;
        int n10 = ((int[])object3).length;
        Object object4 = null;
        for (int i10 = 0; i10 < n10; i10 += 3) {
            boolean bl2 = this.equals(object, object2, i10);
            if (bl2) continue;
            return false;
        }
        object3 = this.unknownFieldSchema.getFromMessage(object);
        n10 = (int)(object3.equals(object4 = this.unknownFieldSchema.getFromMessage(object2)) ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        n10 = (int)(this.hasExtensions ? 1 : 0);
        if (n10 != 0) {
            object = this.extensionSchema.getExtensions(object);
            object2 = this.extensionSchema.getExtensions(object2);
            return ((FieldSet)object).equals(object2);
        }
        return true;
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    public int getSerializedSize(Object object) {
        boolean bl2 = this.proto3;
        int n10 = bl2 ? this.getSerializedSizeProto3(object) : this.getSerializedSizeProto2(object);
        return n10;
    }

    /*
     * Unable to fully structure code
     */
    public int hashCode(Object var1_1) {
        var2_2 = this.buffer;
        var3_3 = ((int[])var2_2).length;
        var5_5 = 0;
        block40: for (var4_4 = 0; var4_4 < var3_3; var4_4 += 3) {
            block44: {
                var6_6 = this.typeAndOffsetAt(var4_4);
                var7_7 = this.numberAt(var4_4);
                var8_8 = MessageSchema.offset(var6_6);
                var6_6 = MessageSchema.type(var6_6);
                var10_9 = 37;
                switch (var6_6) {
                    default: {
                        continue block40;
                    }
                    case 68: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var11_10 = UnsafeUtil.getObject(var1_1, var8_8);
                        var5_5 *= 53;
                        var6_6 = var11_10.hashCode();
                        break block44;
                    }
                    case 67: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var12_11 = MessageSchema.oneofLongAt(var1_1, var8_8);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 66: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var6_6 = MessageSchema.oneofIntAt(var1_1, var8_8);
                        break block44;
                    }
                    case 65: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var12_11 = MessageSchema.oneofLongAt(var1_1, var8_8);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 64: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var6_6 = MessageSchema.oneofIntAt(var1_1, var8_8);
                        break block44;
                    }
                    case 63: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var6_6 = MessageSchema.oneofIntAt(var1_1, var8_8);
                        break block44;
                    }
                    case 62: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var6_6 = MessageSchema.oneofIntAt(var1_1, var8_8);
                        break block44;
                    }
                    case 61: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var11_10 = UnsafeUtil.getObject(var1_1, var8_8);
                        var6_6 = var11_10.hashCode();
                        break block44;
                    }
                    case 60: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var11_10 = UnsafeUtil.getObject(var1_1, var8_8);
                        var5_5 *= 53;
                        var6_6 = var11_10.hashCode();
                        break block44;
                    }
                    case 59: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var11_10 = (String)UnsafeUtil.getObject(var1_1, var8_8);
                        var6_6 = var11_10.hashCode();
                        break block44;
                    }
                    case 58: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var6_6 = Internal.hashBoolean(MessageSchema.oneofBooleanAt(var1_1, var8_8));
                        break block44;
                    }
                    case 57: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var6_6 = MessageSchema.oneofIntAt(var1_1, var8_8);
                        break block44;
                    }
                    case 56: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var12_11 = MessageSchema.oneofLongAt(var1_1, var8_8);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 55: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var6_6 = MessageSchema.oneofIntAt(var1_1, var8_8);
                        break block44;
                    }
                    case 54: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var12_11 = MessageSchema.oneofLongAt(var1_1, var8_8);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 53: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var12_11 = MessageSchema.oneofLongAt(var1_1, var8_8);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 52: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var14_12 = MessageSchema.oneofFloatAt(var1_1, var8_8);
                        var6_6 = Float.floatToIntBits(var14_12);
                        break block44;
                    }
                    case 51: {
                        var6_6 = (int)this.isOneofPresent(var1_1, var7_7, var4_4);
                        if (var6_6 == 0) continue block40;
                        var5_5 *= 53;
                        var15_13 = MessageSchema.oneofDoubleAt(var1_1, var8_8);
                        var12_11 = Double.doubleToLongBits(var15_13);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 50: {
                        var5_5 *= 53;
                        var11_10 = UnsafeUtil.getObject(var1_1, var8_8);
                        var6_6 = var11_10.hashCode();
                        break block44;
                    }
                    case 18: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 23: 
                    case 24: 
                    case 25: 
                    case 26: 
                    case 27: 
                    case 28: 
                    case 29: 
                    case 30: 
                    case 31: 
                    case 32: 
                    case 33: 
                    case 34: 
                    case 35: 
                    case 36: 
                    case 37: 
                    case 38: 
                    case 39: 
                    case 40: 
                    case 41: 
                    case 42: 
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: 
                    case 47: 
                    case 48: 
                    case 49: {
                        var5_5 *= 53;
                        var11_10 = UnsafeUtil.getObject(var1_1, var8_8);
                        var6_6 = var11_10.hashCode();
                        break block44;
                    }
                    case 17: {
                        var11_10 = UnsafeUtil.getObject(var1_1, var8_8);
                        if (var11_10 != null) {
                            var10_9 = var11_10.hashCode();
                        }
                        ** GOTO lbl183
                    }
                    case 16: {
                        var5_5 *= 53;
                        var12_11 = UnsafeUtil.getLong(var1_1, var8_8);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 15: {
                        var5_5 *= 53;
                        var6_6 = UnsafeUtil.getInt(var1_1, var8_8);
                        break block44;
                    }
                    case 14: {
                        var5_5 *= 53;
                        var12_11 = UnsafeUtil.getLong(var1_1, var8_8);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 13: {
                        var5_5 *= 53;
                        var6_6 = UnsafeUtil.getInt(var1_1, var8_8);
                        break block44;
                    }
                    case 12: {
                        var5_5 *= 53;
                        var6_6 = UnsafeUtil.getInt(var1_1, var8_8);
                        break block44;
                    }
                    case 11: {
                        var5_5 *= 53;
                        var6_6 = UnsafeUtil.getInt(var1_1, var8_8);
                        break block44;
                    }
                    case 10: {
                        var5_5 *= 53;
                        var11_10 = UnsafeUtil.getObject(var1_1, var8_8);
                        var6_6 = var11_10.hashCode();
                        break block44;
                    }
                    case 9: {
                        var11_10 = UnsafeUtil.getObject(var1_1, var8_8);
                        if (var11_10 != null) {
                            var10_9 = var11_10.hashCode();
                        }
lbl183:
                        // 4 sources

                        var5_5 = var5_5 * 53 + var10_9;
                        continue block40;
                    }
                    case 8: {
                        var5_5 *= 53;
                        var11_10 = (String)UnsafeUtil.getObject(var1_1, var8_8);
                        var6_6 = var11_10.hashCode();
                        break block44;
                    }
                    case 7: {
                        var5_5 *= 53;
                        var6_6 = Internal.hashBoolean(UnsafeUtil.getBoolean(var1_1, var8_8));
                        break block44;
                    }
                    case 6: {
                        var5_5 *= 53;
                        var6_6 = UnsafeUtil.getInt(var1_1, var8_8);
                        break block44;
                    }
                    case 5: {
                        var5_5 *= 53;
                        var12_11 = UnsafeUtil.getLong(var1_1, var8_8);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 4: {
                        var5_5 *= 53;
                        var6_6 = UnsafeUtil.getInt(var1_1, var8_8);
                        break block44;
                    }
                    case 3: {
                        var5_5 *= 53;
                        var12_11 = UnsafeUtil.getLong(var1_1, var8_8);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 2: {
                        var5_5 *= 53;
                        var12_11 = UnsafeUtil.getLong(var1_1, var8_8);
                        var6_6 = Internal.hashLong(var12_11);
                        break block44;
                    }
                    case 1: {
                        var5_5 *= 53;
                        var14_12 = UnsafeUtil.getFloat(var1_1, var8_8);
                        var6_6 = Float.floatToIntBits(var14_12);
                        break block44;
                    }
                    case 0: 
                }
                var5_5 *= 53;
                var15_13 = UnsafeUtil.getDouble(var1_1, var8_8);
                var12_11 = Double.doubleToLongBits(var15_13);
                var6_6 = Internal.hashLong(var12_11);
            }
            var5_5 += var6_6;
        }
        var5_5 *= 53;
        var2_2 = this.unknownFieldSchema.getFromMessage(var1_1);
        var3_3 = var2_2.hashCode();
        var5_5 += var3_3;
        var3_3 = (int)this.hasExtensions;
        if (var3_3 != 0) {
            var5_5 *= 53;
            var2_2 = this.extensionSchema;
            var1_1 = var2_2.getExtensions(var1_1);
            var17_14 = var1_1.hashCode();
            var5_5 += var17_14;
        }
        return var5_5;
    }

    public final boolean isInitialized(Object object) {
        boolean bl2;
        Object object2;
        int n10;
        int n11 = -1;
        int n12 = 0;
        int n13 = 0;
        while (true) {
            block13: {
                int n14;
                Object object3;
                int n15;
                block10: {
                    block11: {
                        int n16;
                        block12: {
                            int n17;
                            n15 = this.checkInitializedCount;
                            n10 = 1;
                            if (n12 >= n15) break;
                            object3 = this.intArray;
                            n15 = object3[n12];
                            n16 = this.numberAt(n15);
                            n14 = this.typeAndOffsetAt(n15);
                            int n18 = this.proto3;
                            if (n18 == 0) {
                                int[] nArray = this.buffer;
                                n17 = n15 + 2;
                                n18 = nArray[n17];
                                n17 = 0xFFFFF & n18;
                                n10 <<= (n18 >>>= 20);
                                if (n17 != n11) {
                                    object2 = UNSAFE;
                                    long l10 = n17;
                                    n13 = ((Unsafe)object2).getInt(object, l10);
                                    n11 = n17;
                                }
                            } else {
                                n10 = 0;
                            }
                            if ((n18 = MessageSchema.isRequired(n14)) != 0 && (n18 = (int)(this.isFieldPresent(object, n15, n13, n10) ? 1 : 0)) == 0) {
                                return false;
                            }
                            n18 = MessageSchema.type(n14);
                            if (n18 == (n17 = 9) || n18 == (n17 = 17)) break block10;
                            n10 = 27;
                            if (n18 == n10) break block11;
                            n10 = 60;
                            if (n18 == n10 || n18 == (n10 = 68)) break block12;
                            n10 = 49;
                            if (n18 == n10) break block11;
                            n10 = 50;
                            if (n18 == n10 && (n15 = (int)(this.isMapInitialized(object, n14, n15) ? 1 : 0)) == 0) {
                                return false;
                            }
                            break block13;
                        }
                        n10 = (int)(this.isOneofPresent(object, n16, n15) ? 1 : 0);
                        if (n10 != 0 && (n15 = (int)(MessageSchema.isInitialized(object, n14, (Schema)(object3 = (Object)this.getMessageFieldSchema(n15))) ? 1 : 0)) == 0) {
                            return false;
                        }
                        break block13;
                    }
                    if ((n15 = (int)(this.isListInitialized(object, n14, n15) ? 1 : 0)) == 0) {
                        return false;
                    }
                    break block13;
                }
                if ((n10 = (int)(this.isFieldPresent(object, n15, n13, n10) ? 1 : 0)) != 0 && (n15 = (int)(MessageSchema.isInitialized(object, n14, (Schema)(object3 = (Object)this.getMessageFieldSchema(n15))) ? 1 : 0)) == 0) {
                    return false;
                }
            }
            ++n12;
        }
        n11 = (int)(this.hasExtensions ? 1 : 0);
        if (n11 != 0 && !(bl2 = ((FieldSet)(object = ((ExtensionSchema)(object2 = this.extensionSchema)).getExtensions(object))).isInitialized())) {
            return false;
        }
        return n10 != 0;
    }

    public void makeImmutable(Object object) {
        Object object2;
        int n10;
        int n11;
        for (n11 = this.checkInitializedCount; n11 < (n10 = this.repeatedFieldOffsetStart); ++n11) {
            int[] nArray = this.intArray;
            n10 = nArray[n11];
            long l10 = MessageSchema.offset(n10 = this.typeAndOffsetAt(n10));
            object2 = UnsafeUtil.getObject(object, l10);
            if (object2 == null) continue;
            MapFieldSchema mapFieldSchema = this.mapFieldSchema;
            object2 = mapFieldSchema.toImmutable(object2);
            UnsafeUtil.putObject(object, l10, object2);
        }
        Object object3 = this.intArray;
        n11 = ((int[])object3).length;
        while (n10 < n11) {
            ListFieldSchema listFieldSchema = this.listFieldSchema;
            object2 = this.intArray;
            int n12 = object2[n10];
            long l11 = n12;
            listFieldSchema.makeImmutableListAt(object, l11);
            ++n10;
        }
        object3 = this.unknownFieldSchema;
        ((UnknownFieldSchema)object3).makeImmutable(object);
        n11 = (int)(this.hasExtensions ? 1 : 0);
        if (n11 != 0) {
            object3 = this.extensionSchema;
            ((ExtensionSchema)object3).makeImmutable(object);
        }
    }

    public void mergeFrom(Object object, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSchema unknownFieldSchema = this.unknownFieldSchema;
        ExtensionSchema extensionSchema = this.extensionSchema;
        this.mergeFromHelper(unknownFieldSchema, extensionSchema, object, reader, extensionRegistryLite);
    }

    public void mergeFrom(Object object, Object object2) {
        int[] nArray;
        int n10;
        int n11;
        Objects.requireNonNull(object2);
        Object object3 = null;
        for (n11 = 0; n11 < (n10 = (nArray = this.buffer).length); n11 += 3) {
            this.mergeSingleField(object, object2, n11);
        }
        object3 = this.unknownFieldSchema;
        SchemaUtil.mergeUnknownFields((UnknownFieldSchema)object3, object, object2);
        n11 = (int)(this.hasExtensions ? 1 : 0);
        if (n11 != 0) {
            object3 = this.extensionSchema;
            SchemaUtil.mergeExtensions((ExtensionSchema)object3, object, object2);
        }
    }

    public void mergeFrom(Object object, byte[] byArray, int n10, int n11, ArrayDecoders$Registers arrayDecoders$Registers) {
        boolean bl2 = this.proto3;
        if (bl2) {
            this.parseProto3Message(object, byArray, n10, n11, arrayDecoders$Registers);
        } else {
            this.parseProto2Message(object, byArray, n10, n11, 0, arrayDecoders$Registers);
        }
    }

    public Object newInstance() {
        NewInstanceSchema newInstanceSchema = this.newInstanceSchema;
        MessageLite messageLite = this.defaultInstance;
        return newInstanceSchema.newInstance(messageLite);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public int parseProto2Message(Object var1_1, byte[] var2_2, int var3_3, int var4_4, int var5_5, ArrayDecoders$Registers var6_6) {
        block70: {
            block69: {
                block68: {
                    block53: {
                        var7_7 = this;
                        var8_8 = var1_1;
                        var9_9 = var2_2;
                        var10_10 = var4_4;
                        var11_11 = var5_5;
                        var12_12 = var6_6;
                        var13_13 = MessageSchema.UNSAFE;
                        var14_14 = var3_3;
                        var15_15 = 0;
                        var16_16 = null;
                        var17_17 = 0;
                        var18_18 = 0;
                        var19_19 = null;
                        var20_20 = -1;
                        var21_21 = -1;
                        block16: while (var14_14 < var10_10) {
                            block55: {
                                block66: {
                                    block67: {
                                        block64: {
                                            block65: {
                                                block62: {
                                                    block63: {
                                                        block61: {
                                                            block56: {
                                                                block57: {
                                                                    block58: {
                                                                        block59: {
                                                                            block60: {
                                                                                block54: {
                                                                                    var17_17 = var14_14 + 1;
                                                                                    if ((var14_14 = var9_9[var14_14]) < 0) {
                                                                                        var14_14 = ArrayDecoders.decodeVarint32(var14_14, var9_9, var17_17, (ArrayDecoders$Registers)var12_12);
                                                                                        var17_17 = var12_12.int1;
                                                                                        var22_22 = var14_14;
                                                                                        var23_23 /* !! */  = var17_17;
                                                                                    } else {
                                                                                        var23_23 /* !! */  = var14_14;
                                                                                        var22_22 = var17_17;
                                                                                    }
                                                                                    var17_17 = var23_23 /* !! */  >>> 3;
                                                                                    var14_14 = var23_23 /* !! */  & 7;
                                                                                    var24_24 = 3;
                                                                                    var20_20 = var17_17 > var20_20 ? var7_7.positionForFieldNumber(var17_17, var15_15 /= var24_24) : var7_7.positionForFieldNumber(var17_17);
                                                                                    var15_15 = var20_20;
                                                                                    var20_20 = -1;
                                                                                    if (var15_15 != var20_20) break block54;
                                                                                    var25_25 = var17_17;
                                                                                    var15_15 = var22_22;
                                                                                    var24_24 = var23_23 /* !! */ ;
                                                                                    var26_26 = var18_18;
                                                                                    var27_27 = var21_21;
                                                                                    var28_28 = var13_13;
                                                                                    var14_14 = var11_11;
                                                                                    var29_29 = 0;
                                                                                    break block55;
                                                                                }
                                                                                var30_30 /* !! */  = var7_7.buffer;
                                                                                var31_31 = var15_15 + 1;
                                                                                var20_20 = var30_30 /* !! */ [var31_31];
                                                                                var24_24 = MessageSchema.type(var20_20);
                                                                                var32_32 = MessageSchema.offset(var20_20);
                                                                                var31_31 = var23_23 /* !! */ ;
                                                                                var23_23 /* !! */  = 17;
                                                                                var27_27 = var20_20;
                                                                                if (var24_24 > var23_23 /* !! */ ) break block56;
                                                                                var34_33 = var7_7.buffer;
                                                                                var29_29 = var15_15 + 2;
                                                                                var23_23 /* !! */  = (int)var34_33[var29_29];
                                                                                var29_29 = var23_23 /* !! */  >>> 20;
                                                                                var20_20 = 1;
                                                                                var29_29 = var20_20 << var29_29;
                                                                                var26_26 = 1048575;
                                                                                if ((var23_23 /* !! */  &= var26_26) != var21_21) {
                                                                                    var10_10 = -1;
                                                                                    var25_25 = var15_15;
                                                                                    if (var21_21 != var10_10) {
                                                                                        var35_34 = var21_21;
                                                                                        var13_13.putInt(var8_8, var35_34, var18_18);
                                                                                    }
                                                                                    var35_34 = var23_23 /* !! */ ;
                                                                                    var18_18 = var13_13.getInt(var8_8, var35_34);
                                                                                    var21_21 = var23_23 /* !! */ ;
                                                                                } else {
                                                                                    var25_25 = var15_15;
                                                                                    var10_10 = -1;
                                                                                }
                                                                                var20_20 = 5;
                                                                                switch (var24_24) {
                                                                                    default: {
                                                                                        var9_9 = var2_2;
                                                                                        var11_11 = var22_22;
                                                                                        var24_24 = var25_25;
                                                                                        var25_25 = var17_17;
                                                                                        var37_35 = var31_31;
                                                                                        var31_31 = var10_10;
                                                                                        var10_10 = var37_35;
                                                                                        break block57;
                                                                                    }
                                                                                    case 17: {
                                                                                        var15_15 = 3;
                                                                                        if (var14_14 != var15_15) ** GOTO lbl109
                                                                                        var23_23 /* !! */  = var17_17 << 3 | 4;
                                                                                        var15_15 = var25_25;
                                                                                        var38_36 = super.getMessageFieldSchema(var25_25);
                                                                                        var30_30 /* !! */  = var2_2;
                                                                                        var24_24 = var25_25;
                                                                                        var15_15 = var22_22;
                                                                                        var25_25 = var17_17;
                                                                                        var17_17 = var4_4;
                                                                                        var22_22 = var23_23 /* !! */ ;
                                                                                        var10_10 = var31_31;
                                                                                        var34_33 = var6_6;
                                                                                        var14_14 = ArrayDecoders.decodeGroupField((Schema)var38_36, var2_2, var15_15, var4_4, var23_23 /* !! */ , var6_6);
                                                                                        var20_20 = var18_18 & var29_29;
                                                                                        if (var20_20 == 0) {
                                                                                            var30_30 /* !! */  = (int[])var12_12.object1;
                                                                                            var13_13.putObject(var8_8, var32_32, var30_30 /* !! */ );
                                                                                        } else {
                                                                                            var30_30 /* !! */  = (int[])var13_13.getObject(var8_8, var32_32);
                                                                                            var16_16 = var12_12.object1;
                                                                                            var30_30 /* !! */  = (int[])Internal.mergeMessage(var30_30 /* !! */ , var16_16);
                                                                                            var13_13.putObject(var8_8, var32_32, var30_30 /* !! */ );
                                                                                        }
                                                                                        var18_18 |= var29_29;
                                                                                        var9_9 = var2_2;
                                                                                        break block58;
lbl109:
                                                                                        // 1 sources

                                                                                        var24_24 = var25_25;
                                                                                        var10_10 = var31_31;
                                                                                        var25_25 = var17_17;
                                                                                        ** GOTO lbl127
                                                                                    }
                                                                                    case 16: {
                                                                                        var24_24 = var25_25;
                                                                                        var10_10 = var31_31;
                                                                                        var25_25 = var17_17;
                                                                                        if (var14_14 != 0) ** GOTO lbl127
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        var11_11 = ArrayDecoders.decodeVarint64(var2_2, var22_22, (ArrayDecoders$Registers)var12_12);
                                                                                        var41_38 = var12_12.long1;
                                                                                        var43_39 = CodedInputStream.decodeZigZag64(var41_38);
                                                                                        var38_36 = var13_13;
                                                                                        var30_30 /* !! */  = (int[])var1_1;
                                                                                        var13_13.putLong(var1_1, var32_32, var43_39);
                                                                                        ** GOTO lbl305
lbl127:
                                                                                        // 2 sources

                                                                                        var9_9 = var2_2;
                                                                                        ** GOTO lbl170
                                                                                    }
                                                                                    case 15: {
                                                                                        var24_24 = var25_25;
                                                                                        var10_10 = var31_31;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        if (var14_14 != 0) ** GOTO lbl170
                                                                                        var14_14 = ArrayDecoders.decodeVarint32(var2_2, var22_22, (ArrayDecoders$Registers)var12_12);
                                                                                        var20_20 = CodedInputStream.decodeZigZag32(var12_12.int1);
                                                                                        var13_13.putInt(var8_8, var32_32, var20_20);
                                                                                        break block59;
                                                                                    }
                                                                                    case 12: {
                                                                                        var24_24 = var25_25;
                                                                                        var10_10 = var31_31;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        if (var14_14 != 0) ** GOTO lbl170
                                                                                        var14_14 = ArrayDecoders.decodeVarint32(var2_2, var22_22, (ArrayDecoders$Registers)var12_12);
                                                                                        var20_20 = var12_12.int1;
                                                                                        var45_40 = super.getEnumFieldVerifier(var24_24);
                                                                                        if (var45_40 == null || (var22_22 = (int)var45_40.isInRange(var20_20)) != 0) ** GOTO lbl156
                                                                                        var16_16 = MessageSchema.getMutableUnknownFields(var1_1);
                                                                                        var46_41 = var20_20;
                                                                                        var30_30 /* !! */  = (int[])var46_41;
                                                                                        var16_16.storeField(var31_31, var30_30 /* !! */ );
                                                                                        break block58;
lbl156:
                                                                                        // 1 sources

                                                                                        var13_13.putInt(var8_8, var39_37, var20_20);
                                                                                        break block59;
                                                                                    }
                                                                                    case 10: {
                                                                                        var24_24 = var25_25;
                                                                                        var10_10 = var31_31;
                                                                                        var20_20 = 2;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        if (var14_14 != var20_20) ** GOTO lbl170
                                                                                        var14_14 = ArrayDecoders.decodeBytes(var2_2, var22_22, (ArrayDecoders$Registers)var12_12);
                                                                                        var30_30 /* !! */  = (int[])var12_12.object1;
                                                                                        var13_13.putObject(var8_8, var32_32, var30_30 /* !! */ );
                                                                                        break block59;
lbl170:
                                                                                        // 4 sources

                                                                                        var11_11 = var22_22;
                                                                                        var31_31 = -1;
                                                                                        break block57;
                                                                                    }
                                                                                    case 9: {
                                                                                        var24_24 = var25_25;
                                                                                        var10_10 = var31_31;
                                                                                        var20_20 = 2;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        if (var14_14 != var20_20) ** GOTO lbl195
                                                                                        var38_36 = super.getMessageFieldSchema(var24_24);
                                                                                        var11_11 = var4_4;
                                                                                        var31_31 = -1;
                                                                                        var14_14 = ArrayDecoders.decodeMessageField((Schema)var38_36, var2_2, var22_22, var4_4, (ArrayDecoders$Registers)var12_12);
                                                                                        var20_20 = var18_18 & var29_29;
                                                                                        if (var20_20 == 0) {
                                                                                            var30_30 /* !! */  = (int[])var12_12.object1;
                                                                                            var13_13.putObject(var8_8, var32_32, var30_30 /* !! */ );
                                                                                        } else {
                                                                                            var30_30 /* !! */  = (int[])var13_13.getObject(var8_8, var32_32);
                                                                                            var45_40 = var12_12.object1;
                                                                                            var30_30 /* !! */  = (int[])Internal.mergeMessage(var30_30 /* !! */ , var45_40);
                                                                                            var13_13.putObject(var8_8, var32_32, var30_30 /* !! */ );
                                                                                        }
                                                                                        ** GOTO lbl250
lbl195:
                                                                                        // 1 sources

                                                                                        var11_11 = var4_4;
                                                                                        var31_31 = -1;
                                                                                        ** GOTO lbl274
                                                                                    }
                                                                                    case 8: {
                                                                                        var24_24 = var25_25;
                                                                                        var20_20 = 2;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        var11_11 = var4_4;
                                                                                        var37_35 = var31_31;
                                                                                        var31_31 = var10_10;
                                                                                        var10_10 = var37_35;
                                                                                        if (var14_14 != var20_20) ** GOTO lbl274
                                                                                        var48_42 = 1.0842022E-19f;
                                                                                        var14_14 = var27_27 & 0x20000000;
                                                                                        var14_14 = var14_14 == 0 ? ArrayDecoders.decodeString(var2_2, var22_22, (ArrayDecoders$Registers)var12_12) : ArrayDecoders.decodeStringRequireUtf8(var2_2, var22_22, (ArrayDecoders$Registers)var12_12);
                                                                                        var30_30 /* !! */  = (int[])var12_12.object1;
                                                                                        var13_13.putObject(var8_8, var39_37, var30_30 /* !! */ );
                                                                                        ** GOTO lbl250
                                                                                    }
                                                                                    case 7: {
                                                                                        var24_24 = var25_25;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        var11_11 = var4_4;
                                                                                        var37_35 = var31_31;
                                                                                        var31_31 = var10_10;
                                                                                        var10_10 = var37_35;
                                                                                        if (var14_14 != 0) ** GOTO lbl274
                                                                                        var14_14 = ArrayDecoders.decodeVarint64(var2_2, var22_22, (ArrayDecoders$Registers)var12_12);
                                                                                        var43_39 = var12_12.long1;
                                                                                        var49_43 = 0L;
                                                                                        cfr_temp_0 = var43_39 - var49_43;
                                                                                        var20_20 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                                        if (var20_20 != 0) {
                                                                                            var20_20 = 1;
                                                                                        } else {
                                                                                            var20_20 = 0;
                                                                                            var30_30 /* !! */  = null;
                                                                                        }
                                                                                        UnsafeUtil.putBoolean(var8_8, var39_37, (boolean)var20_20);
                                                                                        ** GOTO lbl250
                                                                                    }
                                                                                    case 6: 
                                                                                    case 13: {
                                                                                        var24_24 = var25_25;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        var11_11 = var4_4;
                                                                                        var37_35 = var31_31;
                                                                                        var31_31 = var10_10;
                                                                                        var10_10 = var37_35;
                                                                                        if (var14_14 != var20_20) ** GOTO lbl274
                                                                                        var14_14 = ArrayDecoders.decodeFixed32(var2_2, var22_22);
                                                                                        var13_13.putInt(var8_8, var32_32, var14_14);
                                                                                        var14_14 = var22_22 + 4;
lbl250:
                                                                                        // 5 sources

                                                                                        var18_18 |= var29_29;
                                                                                        var15_15 = var24_24;
                                                                                        var17_17 = var10_10;
                                                                                        var20_20 = var25_25;
                                                                                        var10_10 = var11_11;
                                                                                        ** GOTO lbl311
                                                                                    }
                                                                                    case 5: 
                                                                                    case 14: {
                                                                                        var24_24 = var25_25;
                                                                                        var20_20 = 1;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        var11_11 = var4_4;
                                                                                        var37_35 = var31_31;
                                                                                        var31_31 = var10_10;
                                                                                        var10_10 = var37_35;
                                                                                        if (var14_14 != var20_20) ** GOTO lbl274
                                                                                        var51_44 = ArrayDecoders.decodeFixed64(var2_2, var22_22);
                                                                                        var38_36 = var13_13;
                                                                                        var30_30 /* !! */  = (int[])var1_1;
                                                                                        var11_11 = var22_22;
                                                                                        var43_39 = var51_44;
                                                                                        var13_13.putLong(var1_1, var32_32, var51_44);
                                                                                        break block60;
lbl274:
                                                                                        // 5 sources

                                                                                        var11_11 = var22_22;
                                                                                        break block57;
                                                                                    }
                                                                                    case 4: 
                                                                                    case 11: {
                                                                                        var24_24 = var25_25;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        var11_11 = var22_22;
                                                                                        var37_35 = var31_31;
                                                                                        var31_31 = var10_10;
                                                                                        var10_10 = var37_35;
                                                                                        if (var14_14 != 0) break block57;
                                                                                        var14_14 = ArrayDecoders.decodeVarint32(var2_2, var22_22, (ArrayDecoders$Registers)var12_12);
                                                                                        var20_20 = var12_12.int1;
                                                                                        var13_13.putInt(var8_8, var32_32, var20_20);
                                                                                        break block59;
                                                                                    }
                                                                                    case 2: 
                                                                                    case 3: {
                                                                                        var24_24 = var25_25;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        var11_11 = var22_22;
                                                                                        var37_35 = var31_31;
                                                                                        var31_31 = var10_10;
                                                                                        var10_10 = var37_35;
                                                                                        if (var14_14 != 0) break block57;
                                                                                        var11_11 = ArrayDecoders.decodeVarint64(var2_2, var22_22, (ArrayDecoders$Registers)var12_12);
                                                                                        var43_39 = var12_12.long1;
                                                                                        var38_36 = var13_13;
                                                                                        var30_30 /* !! */  = (int[])var1_1;
                                                                                        var13_13.putLong(var1_1, var32_32, var43_39);
lbl305:
                                                                                        // 2 sources

                                                                                        var18_18 |= var29_29;
                                                                                        var15_15 = var24_24;
                                                                                        var14_14 = var11_11;
                                                                                        var17_17 = var10_10;
                                                                                        var20_20 = var25_25;
                                                                                        var10_10 = var4_4;
lbl311:
                                                                                        // 2 sources

                                                                                        var11_11 = var5_5;
                                                                                        continue block16;
                                                                                    }
                                                                                    case 1: {
                                                                                        var24_24 = var25_25;
                                                                                        var25_25 = var17_17;
                                                                                        var39_37 = var32_32;
                                                                                        var9_9 = var2_2;
                                                                                        var11_11 = var22_22;
                                                                                        var37_35 = var31_31;
                                                                                        var31_31 = var10_10;
                                                                                        var10_10 = var37_35;
                                                                                        if (var14_14 != var20_20) break block57;
                                                                                        var48_42 = ArrayDecoders.decodeFloat(var2_2, var22_22);
                                                                                        UnsafeUtil.putFloat(var8_8, var32_32, var48_42);
                                                                                        var14_14 = var22_22 + 4;
                                                                                        break block59;
                                                                                    }
                                                                                    case 0: 
                                                                                }
                                                                                var24_24 = var25_25;
                                                                                var20_20 = 1;
                                                                                var25_25 = var17_17;
                                                                                var39_37 = var32_32;
                                                                                var9_9 = var2_2;
                                                                                var11_11 = var22_22;
                                                                                var37_35 = var31_31;
                                                                                var31_31 = var10_10;
                                                                                var10_10 = var37_35;
                                                                                if (var14_14 != var20_20) break block57;
                                                                                var53_45 = ArrayDecoders.decodeDouble(var2_2, var22_22);
                                                                                UnsafeUtil.putDouble(var8_8, var32_32, var53_45);
                                                                            }
                                                                            var14_14 = var11_11 + 8;
                                                                        }
                                                                        var18_18 |= var29_29;
                                                                    }
                                                                    var11_11 = var5_5;
                                                                    var15_15 = var24_24;
                                                                    var17_17 = var10_10;
                                                                    var20_20 = var25_25;
                                                                    break block61;
                                                                }
                                                                var14_14 = var5_5;
                                                                var26_26 = var18_18;
                                                                var27_27 = var21_21;
                                                                var29_29 = var24_24;
                                                                var28_28 = var13_13;
                                                                var15_15 = var11_11;
                                                                var24_24 = var10_10;
                                                                break block55;
                                                            }
                                                            var23_23 /* !! */  = var15_15;
                                                            var25_25 = var17_17;
                                                            var39_37 = var32_32;
                                                            var10_10 = var31_31;
                                                            var31_31 = -1;
                                                            var9_9 = var2_2;
                                                            var11_11 = var22_22;
                                                            var20_20 = 27;
                                                            if (var24_24 != var20_20) break block62;
                                                            var20_20 = 2;
                                                            if (var14_14 != var20_20) break block63;
                                                            var38_36 = (Internal$ProtobufList)var13_13.getObject(var8_8, var32_32);
                                                            var20_20 = (int)var38_36.isModifiable();
                                                            if (var20_20 == 0) {
                                                                var20_20 = var38_36.size();
                                                                var20_20 = var20_20 == 0 ? 10 : (var20_20 *= 2);
                                                                var38_36 = var38_36.mutableCopyWithCapacity(var20_20);
                                                                var13_13.putObject(var8_8, var39_37, var38_36);
                                                            }
                                                            var55_46 = var38_36;
                                                            var38_36 = super.getMessageFieldSchema(var23_23 /* !! */ );
                                                            var20_20 = var10_10;
                                                            var16_16 = var2_2;
                                                            var17_17 = var11_11;
                                                            var22_22 = var4_4;
                                                            var29_29 = var23_23 /* !! */ ;
                                                            var34_33 = var55_46;
                                                            var26_26 = var18_18;
                                                            var19_19 = var6_6;
                                                            var14_14 = ArrayDecoders.decodeMessageList((Schema)var38_36, var10_10, var2_2, var11_11, var4_4, (Internal$ProtobufList)var55_46, var6_6);
                                                            var11_11 = var5_5;
                                                            var17_17 = var10_10;
                                                            var20_20 = var25_25;
                                                            var15_15 = var23_23 /* !! */ ;
                                                        }
                                                        var10_10 = var4_4;
                                                        continue;
                                                    }
                                                    var29_29 = var15_15;
                                                    var26_26 = var18_18;
                                                    var27_27 = var21_21;
                                                    var28_28 = var13_13;
                                                    var56_47 = var22_22;
                                                    var31_31 = var10_10;
                                                    break block64;
                                                }
                                                var29_29 = var15_15;
                                                var26_26 = var18_18;
                                                var20_20 = 49;
                                                if (var24_24 > var20_20) break block65;
                                                var20_20 = var27_27;
                                                var57_48 = var27_27;
                                                var22_22 = var14_14;
                                                var38_36 = this;
                                                var30_30 /* !! */  = (int[])var1_1;
                                                var49_43 = var32_32;
                                                var16_16 = var2_2;
                                                var17_17 = var11_11;
                                                var3_3 = var14_14;
                                                var22_22 = var4_4;
                                                var23_23 /* !! */  = var10_10;
                                                var18_18 = var25_25;
                                                var27_27 = var21_21;
                                                var21_21 = var14_14;
                                                var59_49 = var24_24;
                                                var24_24 = var15_15;
                                                var28_28 = var13_13;
                                                var56_47 = var11_11;
                                                var11_11 = var59_49;
                                                var31_31 = var10_10;
                                                var8_8 = var6_6;
                                                if ((var14_14 = this.parseRepeatedField(var1_1, var2_2, var17_17, var4_4, var10_10, var25_25, var14_14, var15_15, var57_48, var59_49, var32_32, var6_6)) != var17_17) lbl-1000:
                                                // 3 sources

                                                {
                                                    while (true) {
                                                        var7_7 = this;
                                                        var8_8 = var1_1;
                                                        var9_9 = var2_2;
                                                        var10_10 = var4_4;
                                                        var11_11 = var5_5;
                                                        var12_12 = var6_6;
                                                        var20_20 = var25_25;
                                                        var17_17 = var31_31;
                                                        var21_21 = var27_27;
                                                        var15_15 = var29_29;
                                                        var18_18 = var26_26;
lbl444:
                                                        // 2 sources

                                                        while (true) {
                                                            var13_13 = var28_28;
                                                            continue block16;
                                                            break;
                                                        }
                                                        break;
                                                    }
                                                }
                                                break block66;
                                            }
                                            var3_3 = var14_14;
                                            var49_43 = var32_32;
                                            var59_49 = var24_24;
                                            var28_28 = var13_13;
                                            var56_47 = var22_22;
                                            var31_31 = var10_10;
                                            var20_20 = var27_27;
                                            var27_27 = var21_21;
                                            var14_14 = 50;
                                            var48_42 = 7.0E-44f;
                                            if (var24_24 != var14_14) break block67;
                                            var21_21 = var3_3;
                                            var14_14 = 2;
                                            var48_42 = 2.8E-45f;
                                            if (var3_3 != var14_14) break block64;
                                            var38_36 = this;
                                            var30_30 /* !! */  = (int[])var1_1;
                                            var16_16 = var2_2;
                                            var17_17 = var22_22;
                                            var22_22 = var4_4;
                                            var55_46 = var6_6;
                                            var14_14 = this.parseMapField(var1_1, var2_2, var11_11, var4_4, var15_15, var32_32, var6_6);
                                            if (var14_14 == var11_11) break block66;
                                            ** GOTO lbl-1000
                                        }
                                        var14_14 = var5_5;
                                        var15_15 = var56_47;
                                        var24_24 = var31_31;
                                        break block55;
                                    }
                                    var21_21 = var3_3;
                                    var38_36 = this;
                                    var24_24 = var20_20;
                                    var30_30 /* !! */  = (int[])var1_1;
                                    var16_16 = var2_2;
                                    var17_17 = var22_22;
                                    var22_22 = var4_4;
                                    var23_23 /* !! */  = var10_10;
                                    var18_18 = var25_25;
                                    var14_14 = this.parseOneofField(var1_1, var2_2, var11_11, var4_4, var10_10, var25_25, var3_3, var20_20, var59_49, var32_32, var15_15, var6_6);
                                    if (var14_14 == var11_11) ** break;
                                    ** continue;
                                }
                                var15_15 = var14_14;
                                var24_24 = var31_31;
                                var14_14 = var5_5;
                            }
                            if (var24_24 == var14_14 && var14_14 != 0) {
                                var12_12 = this;
                                var60_50 = var14_14;
                                var14_14 = var15_15;
                                var17_17 = var24_24;
                                var21_21 = var27_27;
                                var18_18 = var26_26;
                                break block53;
                            }
                            var12_12 = this;
                            var60_50 = var14_14;
                            var14_14 = (int)this.hasExtensions;
                            var61_51 = var6_6;
                            if (var14_14 != 0 && (var38_36 = var6_6.extensionRegistry) != (var30_30 /* !! */  = (int[])ExtensionRegistryLite.getEmptyRegistry())) {
                                var34_33 = this.defaultInstance;
                                var19_19 = this.unknownFieldSchema;
                                var14_14 = var24_24;
                                var30_30 /* !! */  = var2_2;
                                var17_17 = var4_4;
                                var45_40 = var1_1;
                                var14_14 = ArrayDecoders.decodeExtensionOrUnknownField(var24_24, var2_2, var15_15, var4_4, var1_1, (MessageLite)var34_33, (UnknownFieldSchema)var19_19, var6_6);
                            } else {
                                var45_40 = MessageSchema.getMutableUnknownFields(var1_1);
                                var14_14 = var24_24;
                                var30_30 /* !! */  = var2_2;
                                var17_17 = var4_4;
                                var34_33 = var6_6;
                                var14_14 = ArrayDecoders.decodeUnknownField(var24_24, var2_2, var15_15, var4_4, (UnknownFieldSetLite)var45_40, var6_6);
                            }
                            var8_8 = var1_1;
                            var9_9 = var2_2;
                            var10_10 = var4_4;
                            var17_17 = var24_24;
                            var7_7 = var12_12;
                            var12_12 = var61_51;
                            var20_20 = var25_25;
                            var21_21 = var27_27;
                            var15_15 = var29_29;
                            var18_18 = var26_26;
                            var11_11 = var60_50;
                            ** continue;
                        }
                        var26_26 = var18_18;
                        var27_27 = var21_21;
                        var28_28 = var13_13;
                        var60_50 = var11_11;
                        var12_12 = var7_7;
                    }
                    var20_20 = -1;
                    if (var21_21 != var20_20) {
                        var35_34 = var21_21;
                        var45_40 = var1_1;
                        var34_33 = var28_28;
                        var28_28.putInt(var1_1, var35_34, var18_18);
                    } else {
                        var45_40 = var1_1;
                    }
                    var20_20 = 0;
                    var30_30 /* !! */  = null;
                    for (var15_15 = var12_12.checkInitializedCount; var15_15 < (var23_23 /* !! */  = var12_12.repeatedFieldOffsetStart); ++var15_15) {
                        var34_33 = var12_12.intArray;
                        var23_23 /* !! */  = (int)var34_33[var15_15];
                        var19_19 = var12_12.unknownFieldSchema;
                        var30_30 /* !! */  = (int[])((UnknownFieldSetLite)super.filterMapUnknownEnumValues(var45_40, var23_23 /* !! */ , var30_30 /* !! */ , (UnknownFieldSchema)var19_19));
                    }
                    if (var30_30 /* !! */  != null) {
                        var16_16 = var12_12.unknownFieldSchema;
                        var16_16.setBuilderToMessage(var45_40, var30_30 /* !! */ );
                    }
                    if (var60_50 != 0) break block68;
                    var20_20 = var4_4;
                    if (var14_14 != var4_4) {
                        throw InvalidProtocolBufferException.parseFailure();
                    }
                    break block69;
                }
                var20_20 = var4_4;
                if (var14_14 > var4_4 || var17_17 != var60_50) break block70;
            }
            return var14_14;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    public void writeTo(Object object, Writer writer) {
        Writer$FieldOrder writer$FieldOrder;
        Writer$FieldOrder writer$FieldOrder2 = writer.fieldOrder();
        if (writer$FieldOrder2 == (writer$FieldOrder = Writer$FieldOrder.DESCENDING)) {
            this.writeFieldsInDescendingOrder(object, writer);
        } else {
            boolean bl2 = this.proto3;
            if (bl2) {
                this.writeFieldsInAscendingOrderProto3(object, writer);
            } else {
                this.writeFieldsInAscendingOrderProto2(object, writer);
            }
        }
    }
}


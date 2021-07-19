/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionSchema;
import com.google.protobuf.FieldInfo;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;
import com.google.protobuf.LazyFieldLite;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.MapFieldSchema;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Schema;
import com.google.protobuf.UnknownFieldSchema;
import com.google.protobuf.UnknownFieldSetLiteSchema;
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.util.List;
import java.util.RandomAccess;

public final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class GENERATED_MESSAGE_CLASS = SchemaUtil.getGeneratedMessageClass();
    private static final UnknownFieldSchema PROTO2_UNKNOWN_FIELD_SET_SCHEMA = SchemaUtil.getUnknownFieldSetSchema(false);
    private static final UnknownFieldSchema PROTO3_UNKNOWN_FIELD_SET_SCHEMA = SchemaUtil.getUnknownFieldSetSchema(true);
    private static final UnknownFieldSchema UNKNOWN_FIELD_SET_LITE_SCHEMA;

    static {
        UnknownFieldSetLiteSchema unknownFieldSetLiteSchema = new UnknownFieldSetLiteSchema();
        UNKNOWN_FIELD_SET_LITE_SCHEMA = unknownFieldSetLiteSchema;
    }

    private SchemaUtil() {
    }

    public static int computeSizeBoolList(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        if (bl2) {
            n10 = CodedOutputStream.computeTagSize(n10);
            n11 = CodedOutputStream.computeLengthDelimitedFieldSize(n11);
            return n10 + n11;
        }
        n10 = CodedOutputStream.computeBoolSize(n10, true);
        return n11 * n10;
    }

    public static int computeSizeBoolListNoTag(List list) {
        return list.size();
    }

    public static int computeSizeByteStringList(int n10, List list) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = CodedOutputStream.computeTagSize(n10);
        n11 *= n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            ByteString byteString = (ByteString)list.get(i10);
            n10 = CodedOutputStream.computeBytesSizeNoTag(byteString);
            n11 += n10;
        }
        return n11;
    }

    public static int computeSizeEnumList(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = SchemaUtil.computeSizeEnumListNoTag(list);
        if (bl2) {
            n10 = CodedOutputStream.computeTagSize(n10);
            n12 = CodedOutputStream.computeLengthDelimitedFieldSize(n12);
            return n10 + n12;
        }
        n10 = CodedOutputStream.computeTagSize(n10);
        return n12 + (n11 *= n10);
    }

    public static int computeSizeEnumListNoTag(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof IntArrayList;
        if (n12 != 0) {
            list = (IntArrayList)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = CodedOutputStream.computeEnumSizeNoTag(((IntArrayList)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = CodedOutputStream.computeEnumSizeNoTag(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int computeSizeFixed32List(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        if (bl2) {
            n11 *= 4;
            n10 = CodedOutputStream.computeTagSize(n10);
            n11 = CodedOutputStream.computeLengthDelimitedFieldSize(n11);
            return n10 + n11;
        }
        n10 = CodedOutputStream.computeFixed32Size(n10, 0);
        return n11 * n10;
    }

    public static int computeSizeFixed32ListNoTag(List list) {
        return list.size() * 4;
    }

    public static int computeSizeFixed64List(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        if (bl2) {
            n11 *= 8;
            n10 = CodedOutputStream.computeTagSize(n10);
            n11 = CodedOutputStream.computeLengthDelimitedFieldSize(n11);
            return n10 + n11;
        }
        n10 = CodedOutputStream.computeFixed64Size(n10, 0L);
        return n11 * n10;
    }

    public static int computeSizeFixed64ListNoTag(List list) {
        return list.size() * 8;
    }

    public static int computeSizeGroupList(int n10, List list) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            MessageLite messageLite = (MessageLite)list.get(i10);
            int n13 = CodedOutputStream.computeGroupSize(n10, messageLite);
            n12 += n13;
        }
        return n12;
    }

    public static int computeSizeGroupList(int n10, List list, Schema schema) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            MessageLite messageLite = (MessageLite)list.get(i10);
            int n13 = CodedOutputStream.computeGroupSize(n10, messageLite, schema);
            n12 += n13;
        }
        return n12;
    }

    public static int computeSizeInt32List(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = SchemaUtil.computeSizeInt32ListNoTag(list);
        if (bl2) {
            n10 = CodedOutputStream.computeTagSize(n10);
            n12 = CodedOutputStream.computeLengthDelimitedFieldSize(n12);
            return n10 + n12;
        }
        n10 = CodedOutputStream.computeTagSize(n10);
        return n12 + (n11 *= n10);
    }

    public static int computeSizeInt32ListNoTag(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof IntArrayList;
        if (n12 != 0) {
            list = (IntArrayList)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = CodedOutputStream.computeInt32SizeNoTag(((IntArrayList)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = CodedOutputStream.computeInt32SizeNoTag(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int computeSizeInt64List(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n11 = SchemaUtil.computeSizeInt64ListNoTag(list);
        if (bl2) {
            n10 = CodedOutputStream.computeTagSize(n10);
            int n12 = CodedOutputStream.computeLengthDelimitedFieldSize(n11);
            return n10 + n12;
        }
        int n13 = list.size();
        n10 = CodedOutputStream.computeTagSize(n10);
        return n11 + (n13 *= n10);
    }

    public static int computeSizeInt64ListNoTag(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof LongArrayList;
        if (n12 != 0) {
            list = (LongArrayList)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((LongArrayList)list).getLong(n10);
                int n13 = CodedOutputStream.computeInt64SizeNoTag(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = CodedOutputStream.computeInt64SizeNoTag(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static int computeSizeMessage(int n10, Object object, Schema schema) {
        boolean bl2 = object instanceof LazyFieldLite;
        if (bl2) {
            object = (LazyFieldLite)object;
            return CodedOutputStream.computeLazyFieldSize(n10, (LazyFieldLite)object);
        }
        object = (MessageLite)object;
        return CodedOutputStream.computeMessageSize(n10, (MessageLite)object, schema);
    }

    public static int computeSizeMessageList(int n10, List list) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = CodedOutputStream.computeTagSize(n10) * n11;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            Object object = list.get(i10);
            boolean bl2 = object instanceof LazyFieldLite;
            if (bl2) {
                object = (LazyFieldLite)object;
                n12 = CodedOutputStream.computeLazyFieldSizeNoTag(object);
            } else {
                object = (MessageLite)object;
                n12 = CodedOutputStream.computeMessageSizeNoTag(object);
            }
            n10 += n12;
        }
        return n10;
    }

    public static int computeSizeMessageList(int n10, List list, Schema schema) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        n10 = CodedOutputStream.computeTagSize(n10) * n11;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            Object object = list.get(i10);
            boolean bl2 = object instanceof LazyFieldLite;
            if (bl2) {
                object = (LazyFieldLite)object;
                n12 = CodedOutputStream.computeLazyFieldSizeNoTag(object);
            } else {
                object = (MessageLite)object;
                n12 = CodedOutputStream.computeMessageSizeNoTag(object, schema);
            }
            n10 += n12;
        }
        return n10;
    }

    public static int computeSizeSInt32List(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = SchemaUtil.computeSizeSInt32ListNoTag(list);
        if (bl2) {
            n10 = CodedOutputStream.computeTagSize(n10);
            n12 = CodedOutputStream.computeLengthDelimitedFieldSize(n12);
            return n10 + n12;
        }
        n10 = CodedOutputStream.computeTagSize(n10);
        return n12 + (n11 *= n10);
    }

    public static int computeSizeSInt32ListNoTag(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof IntArrayList;
        if (n12 != 0) {
            list = (IntArrayList)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = CodedOutputStream.computeSInt32SizeNoTag(((IntArrayList)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = CodedOutputStream.computeSInt32SizeNoTag(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int computeSizeSInt64List(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = SchemaUtil.computeSizeSInt64ListNoTag(list);
        if (bl2) {
            n10 = CodedOutputStream.computeTagSize(n10);
            n12 = CodedOutputStream.computeLengthDelimitedFieldSize(n12);
            return n10 + n12;
        }
        n10 = CodedOutputStream.computeTagSize(n10);
        return n12 + (n11 *= n10);
    }

    public static int computeSizeSInt64ListNoTag(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof LongArrayList;
        if (n12 != 0) {
            list = (LongArrayList)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((LongArrayList)list).getLong(n10);
                int n13 = CodedOutputStream.computeSInt64SizeNoTag(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = CodedOutputStream.computeSInt64SizeNoTag(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static int computeSizeStringList(int n10, List list) {
        int n11;
        int n12 = list.size();
        if (n12 == 0) {
            return 0;
        }
        n10 = CodedOutputStream.computeTagSize(n10) * n12;
        int n13 = list instanceof LazyStringList;
        if (n13 != 0) {
            list = (LazyStringList)list;
            for (n11 = 0; n11 < n12; ++n11) {
                Object object = list.getRaw(n11);
                boolean bl2 = object instanceof ByteString;
                if (bl2) {
                    object = (ByteString)object;
                    n13 = CodedOutputStream.computeBytesSizeNoTag((ByteString)object);
                } else {
                    object = (String)object;
                    n13 = CodedOutputStream.computeStringSizeNoTag((String)object);
                }
                n10 += n13;
            }
        } else {
            while (n11 < n12) {
                Object object = list.get(n11);
                boolean bl3 = object instanceof ByteString;
                if (bl3) {
                    object = (ByteString)object;
                    n13 = CodedOutputStream.computeBytesSizeNoTag(object);
                } else {
                    object = (String)object;
                    n13 = CodedOutputStream.computeStringSizeNoTag(object);
                }
                n10 += n13;
                ++n11;
            }
        }
        return n10;
    }

    public static int computeSizeUInt32List(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = SchemaUtil.computeSizeUInt32ListNoTag(list);
        if (bl2) {
            n10 = CodedOutputStream.computeTagSize(n10);
            n12 = CodedOutputStream.computeLengthDelimitedFieldSize(n12);
            return n10 + n12;
        }
        n10 = CodedOutputStream.computeTagSize(n10);
        return n12 + (n11 *= n10);
    }

    public static int computeSizeUInt32ListNoTag(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof IntArrayList;
        if (n12 != 0) {
            list = (IntArrayList)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = CodedOutputStream.computeUInt32SizeNoTag(((IntArrayList)list).getInt(n10));
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Integer n14 = (Integer)list.get(n10);
                int n15 = CodedOutputStream.computeUInt32SizeNoTag(n14);
                n12 += n15;
                ++n10;
            }
        }
        return n12;
    }

    public static int computeSizeUInt64List(int n10, List list, boolean bl2) {
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = SchemaUtil.computeSizeUInt64ListNoTag(list);
        if (bl2) {
            n10 = CodedOutputStream.computeTagSize(n10);
            n12 = CodedOutputStream.computeLengthDelimitedFieldSize(n12);
            return n10 + n12;
        }
        n10 = CodedOutputStream.computeTagSize(n10);
        return n12 + (n11 *= n10);
    }

    public static int computeSizeUInt64ListNoTag(List list) {
        int n10;
        int n11 = list.size();
        if (n11 == 0) {
            return 0;
        }
        int n12 = list instanceof LongArrayList;
        if (n12 != 0) {
            list = (LongArrayList)list;
            n12 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                long l10 = ((LongArrayList)list).getLong(n10);
                int n13 = CodedOutputStream.computeUInt64SizeNoTag(l10);
                n12 += n13;
            }
        } else {
            n12 = 0;
            while (n10 < n11) {
                Long l11 = (Long)list.get(n10);
                long l12 = l11;
                int n14 = CodedOutputStream.computeUInt64SizeNoTag(l12);
                n12 += n14;
                ++n10;
            }
        }
        return n12;
    }

    public static Object filterUnknownEnumList(int n10, List object, Internal$EnumLiteMap internal$EnumLiteMap, Object object2, UnknownFieldSchema unknownFieldSchema) {
        if (internal$EnumLiteMap == null) {
            return object2;
        }
        int n11 = object instanceof RandomAccess;
        if (n11 != 0) {
            n11 = object.size();
            Object var7_7 = null;
            int n12 = 0;
            for (int i10 = 0; i10 < n11; ++i10) {
                Integer n13 = (Integer)((List)object).get(i10);
                int n14 = n13;
                Internal$EnumLite internal$EnumLite = internal$EnumLiteMap.findValueByNumber(n14);
                if (internal$EnumLite != null) {
                    if (i10 != n12) {
                        n13 = n14;
                        ((List)object).set(n12, n13);
                    }
                    ++n12;
                    continue;
                }
                object2 = SchemaUtil.storeUnknownEnum(n10, n14, object2, unknownFieldSchema);
            }
            if (n12 != n11) {
                List list = ((List)object).subList(n12, n11);
                list.clear();
            }
        } else {
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Integer n15 = (Integer)object.next();
                n11 = n15;
                Internal$EnumLite internal$EnumLite = internal$EnumLiteMap.findValueByNumber(n11);
                if (internal$EnumLite != null) continue;
                object2 = SchemaUtil.storeUnknownEnum(n10, n11, object2, unknownFieldSchema);
                object.remove();
            }
        }
        return object2;
    }

    public static Object filterUnknownEnumList(int n10, List object, Internal$EnumVerifier internal$EnumVerifier, Object object2, UnknownFieldSchema unknownFieldSchema) {
        if (internal$EnumVerifier == null) {
            return object2;
        }
        int n11 = object instanceof RandomAccess;
        if (n11 != 0) {
            n11 = object.size();
            int n12 = 0;
            for (int i10 = 0; i10 < n11; ++i10) {
                Integer n13 = (Integer)((List)object).get(i10);
                int n14 = n13;
                boolean bl2 = internal$EnumVerifier.isInRange(n14);
                if (bl2) {
                    if (i10 != n12) {
                        n13 = n14;
                        ((List)object).set(n12, n13);
                    }
                    ++n12;
                    continue;
                }
                object2 = SchemaUtil.storeUnknownEnum(n10, n14, object2, unknownFieldSchema);
            }
            if (n12 != n11) {
                List list = ((List)object).subList(n12, n11);
                list.clear();
            }
        } else {
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Integer n15 = (Integer)object.next();
                n11 = n15;
                boolean bl3 = internal$EnumVerifier.isInRange(n11);
                if (bl3) continue;
                object2 = SchemaUtil.storeUnknownEnum(n10, n11, object2, unknownFieldSchema);
                object.remove();
            }
        }
        return object2;
    }

    private static Class getGeneratedMessageClass() {
        String string2 = "com.google.protobuf.GeneratedMessageV3";
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static Object getMapDefaultEntry(Class object, String object2) {
        String string2;
        CharSequence charSequence;
        Object object3;
        block20: {
            try {
                object3 = new StringBuilder();
                charSequence = ((Class)object).getName();
            }
            catch (Throwable throwable) {
                object2 = new RuntimeException(throwable);
                throw object2;
            }
            object3.append((String)charSequence);
            charSequence = "$";
            object3.append((String)charSequence);
            int n10 = 1;
            string2 = SchemaUtil.toCamelCase((String)object2, n10 != 0);
            object3.append(string2);
            string2 = "DefaultEntryHolder";
            object3.append(string2);
            object3 = object3.toString();
            object3 = Class.forName((String)object3);
            object3 = object3.getDeclaredFields();
            int n11 = ((Field[])object3).length;
            if (n11 != n10) break block20;
            object = null;
            object = object3[0];
            return UnsafeUtil.getStaticObject((Field)object);
        }
        charSequence = new StringBuilder();
        string2 = "Unable to look up map field default entry holder class for ";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append((String)object2);
        object2 = " in ";
        ((StringBuilder)charSequence).append((String)object2);
        object = ((Class)object).getName();
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        object3 = new IllegalStateException((String)object);
        throw object3;
    }

    private static UnknownFieldSchema getUnknownFieldSetSchema(boolean bl2) {
        int n10;
        GenericDeclaration genericDeclaration;
        try {
            genericDeclaration = SchemaUtil.getUnknownFieldSetSchemaClass();
            if (genericDeclaration == null) {
                return null;
            }
            n10 = 1;
        }
        catch (Throwable throwable) {
            return null;
        }
        Class[] classArray = new Class[n10];
        Class<Boolean> clazz = Boolean.TYPE;
        classArray[0] = clazz;
        genericDeclaration = ((Class)genericDeclaration).getConstructor(classArray);
        Object[] objectArray = new Object[n10];
        Boolean bl3 = bl2;
        objectArray[0] = bl3;
        bl3 = ((Constructor)genericDeclaration).newInstance(objectArray);
        return (UnknownFieldSchema)((Object)bl3);
    }

    private static Class getUnknownFieldSetSchemaClass() {
        String string2 = "com.google.protobuf.UnknownFieldSetSchema";
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static void mergeExtensions(ExtensionSchema object, Object object2, Object object3) {
        boolean bl2 = ((FieldSet)(object3 = ((ExtensionSchema)object).getExtensions(object3))).isEmpty();
        if (!bl2) {
            object = ((ExtensionSchema)object).getMutableExtensions(object2);
            ((FieldSet)object).mergeFrom((FieldSet)object3);
        }
    }

    public static void mergeMap(MapFieldSchema object, Object object2, Object object3, long l10) {
        Object object4 = UnsafeUtil.getObject(object2, l10);
        object3 = UnsafeUtil.getObject(object3, l10);
        object = object.mergeFrom(object4, object3);
        UnsafeUtil.putObject(object2, l10, object);
    }

    public static void mergeUnknownFields(UnknownFieldSchema unknownFieldSchema, Object object, Object object2) {
        Object object3 = unknownFieldSchema.getFromMessage(object);
        object2 = unknownFieldSchema.getFromMessage(object2);
        object2 = unknownFieldSchema.merge(object3, object2);
        unknownFieldSchema.setToMessage(object, object2);
    }

    public static UnknownFieldSchema proto2UnknownFieldSetSchema() {
        return PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema proto3UnknownFieldSetSchema() {
        return PROTO3_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static void requireGeneratedMessage(Class serializable) {
        boolean bl2;
        Class clazz = GeneratedMessageLite.class;
        boolean bl3 = clazz.isAssignableFrom((Class<?>)serializable);
        if (!bl3 && (clazz = GENERATED_MESSAGE_CLASS) != null && !(bl2 = clazz.isAssignableFrom((Class<?>)serializable))) {
            serializable = new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            throw serializable;
        }
    }

    public static boolean safeEquals(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean shouldUseTableSwitch(int n10, int n11, int n12) {
        boolean bl2 = true;
        int n13 = 40;
        if (n11 < n13) {
            return bl2;
        }
        long l10 = n11;
        long l11 = n10;
        l10 = l10 - l11 + 1L;
        long l12 = n12;
        l11 = (long)2 * l12;
        long l13 = 3;
        l11 += l13;
        l12 += l13;
        long l14 = 9;
        long l15 = (l10 += l14) - (l11 += (l12 *= l13));
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 > 0) {
            bl2 = false;
        }
        return bl2;
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArray) {
        int n10 = fieldInfoArray.length;
        int n11 = 0;
        if (n10 == 0) {
            return false;
        }
        n10 = fieldInfoArray[0].getFieldNumber();
        n11 = fieldInfoArray.length + -1;
        n11 = fieldInfoArray[n11].getFieldNumber();
        int n12 = fieldInfoArray.length;
        return SchemaUtil.shouldUseTableSwitch(n10, n11, n12);
    }

    public static Object storeUnknownEnum(int n10, int n11, Object object, UnknownFieldSchema unknownFieldSchema) {
        if (object == null) {
            object = unknownFieldSchema.newBuilder();
        }
        long l10 = n11;
        unknownFieldSchema.addVarint(object, n10, l10);
        return object;
    }

    /*
     * Unable to fully structure code
     */
    public static String toCamelCase(String var0, boolean var1_1) {
        var2_2 = new StringBuilder();
        block0: for (var3_3 = '\u0000'; var3_3 < (var4_4 = var0.length()); ++var3_3) {
            block6: {
                block7: {
                    var4_4 = var0.charAt(var3_3);
                    var5_5 = 'a';
                    var6_6 = '\u0001';
                    if (var5_5 <= var4_4 && var4_4 <= (var5_5 = 'z')) {
                        if (var1_1 != '\u0000') {
                            var1_1 = var4_4 += -32;
                            var2_2.append(var1_1);
                        } else {
                            var2_2.append(var4_4);
                        }
lbl14:
                        // 4 sources

                        while (true) {
                            var1_1 = '\u0000';
                            continue block0;
                            break;
                        }
                    }
                    var5_5 = 'A';
                    if (var5_5 > var4_4 || var4_4 > (var5_5 = 'Z')) break block6;
                    if (var3_3 != '\u0000' || var1_1 != '\u0000') break block7;
                    var1_1 = var4_4 += 32;
                    var2_2.append(var1_1);
                    ** GOTO lbl14
                }
                var2_2.append(var4_4);
                ** continue;
            }
            var1_1 = (char)48;
            if (var1_1 <= var4_4 && var4_4 <= (var1_1 = '9')) {
                var2_2.append(var4_4);
            }
            var1_1 = var6_6;
        }
        return var2_2.toString();
    }

    public static UnknownFieldSchema unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int n10, boolean bl2, Writer writer) {
        if (bl2) {
            bl2 = true;
            writer.writeBool(n10, bl2);
        }
    }

    public static void writeBoolList(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeBoolList(n10, list, bl2);
        }
    }

    public static void writeBytes(int n10, ByteString byteString, Writer writer) {
        boolean bl2;
        if (byteString != null && !(bl2 = byteString.isEmpty())) {
            writer.writeBytes(n10, byteString);
        }
    }

    public static void writeBytesList(int n10, List list, Writer writer) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            writer.writeBytesList(n10, list);
        }
    }

    public static void writeDouble(int n10, double d10, Writer writer) {
        double d11 = 0.0;
        int n11 = Double.compare(d10, d11);
        if (n11 != 0) {
            writer.writeDouble(n10, d10);
        }
    }

    public static void writeDoubleList(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeDoubleList(n10, list, bl2);
        }
    }

    public static void writeEnum(int n10, int n11, Writer writer) {
        if (n11 != 0) {
            writer.writeEnum(n10, n11);
        }
    }

    public static void writeEnumList(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeEnumList(n10, list, bl2);
        }
    }

    public static void writeFixed32(int n10, int n11, Writer writer) {
        if (n11 != 0) {
            writer.writeFixed32(n10, n11);
        }
    }

    public static void writeFixed32List(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeFixed32List(n10, list, bl2);
        }
    }

    public static void writeFixed64(int n10, long l10, Writer writer) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            writer.writeFixed64(n10, l10);
        }
    }

    public static void writeFixed64List(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeFixed64List(n10, list, bl2);
        }
    }

    public static void writeFloat(int n10, float f10, Writer writer) {
        int n11 = Float.compare(f10, 0.0f);
        if (n11 != 0) {
            writer.writeFloat(n10, f10);
        }
    }

    public static void writeFloatList(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeFloatList(n10, list, bl2);
        }
    }

    public static void writeGroupList(int n10, List list, Writer writer) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            writer.writeGroupList(n10, list);
        }
    }

    public static void writeGroupList(int n10, List list, Writer writer, Schema schema) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            writer.writeGroupList(n10, list, schema);
        }
    }

    public static void writeInt32(int n10, int n11, Writer writer) {
        if (n11 != 0) {
            writer.writeInt32(n10, n11);
        }
    }

    public static void writeInt32List(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeInt32List(n10, list, bl2);
        }
    }

    public static void writeInt64(int n10, long l10, Writer writer) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            writer.writeInt64(n10, l10);
        }
    }

    public static void writeInt64List(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeInt64List(n10, list, bl2);
        }
    }

    public static void writeLazyFieldList(int n10, List object, Writer writer) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                LazyFieldLite lazyFieldLite = (LazyFieldLite)object.next();
                lazyFieldLite.writeTo(writer, n10);
            }
        }
    }

    public static void writeMessage(int n10, Object object, Writer writer) {
        if (object != null) {
            writer.writeMessage(n10, object);
        }
    }

    public static void writeMessageList(int n10, List list, Writer writer) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            writer.writeMessageList(n10, list);
        }
    }

    public static void writeMessageList(int n10, List list, Writer writer, Schema schema) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            writer.writeMessageList(n10, list, schema);
        }
    }

    public static void writeSFixed32(int n10, int n11, Writer writer) {
        if (n11 != 0) {
            writer.writeSFixed32(n10, n11);
        }
    }

    public static void writeSFixed32List(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeSFixed32List(n10, list, bl2);
        }
    }

    public static void writeSFixed64(int n10, long l10, Writer writer) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            writer.writeSFixed64(n10, l10);
        }
    }

    public static void writeSFixed64List(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeSFixed64List(n10, list, bl2);
        }
    }

    public static void writeSInt32(int n10, int n11, Writer writer) {
        if (n11 != 0) {
            writer.writeSInt32(n10, n11);
        }
    }

    public static void writeSInt32List(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeSInt32List(n10, list, bl2);
        }
    }

    public static void writeSInt64(int n10, long l10, Writer writer) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            writer.writeSInt64(n10, l10);
        }
    }

    public static void writeSInt64List(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeSInt64List(n10, list, bl2);
        }
    }

    public static void writeString(int n10, Object object, Writer writer) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            object = (String)object;
            SchemaUtil.writeStringInternal(n10, (String)object, writer);
        } else {
            object = (ByteString)object;
            SchemaUtil.writeBytes(n10, (ByteString)object, writer);
        }
    }

    private static void writeStringInternal(int n10, String string2, Writer writer) {
        boolean bl2;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            writer.writeString(n10, string2);
        }
    }

    public static void writeStringList(int n10, List list, Writer writer) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            writer.writeStringList(n10, list);
        }
    }

    public static void writeUInt32(int n10, int n11, Writer writer) {
        if (n11 != 0) {
            writer.writeUInt32(n10, n11);
        }
    }

    public static void writeUInt32List(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeUInt32List(n10, list, bl2);
        }
    }

    public static void writeUInt64(int n10, long l10, Writer writer) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            writer.writeUInt64(n10, l10);
        }
    }

    public static void writeUInt64List(int n10, List list, Writer writer, boolean bl2) {
        boolean bl3;
        if (list != null && !(bl3 = list.isEmpty())) {
            writer.writeUInt64List(n10, list, bl2);
        }
    }
}


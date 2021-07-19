/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.FieldType$1;
import com.google.protobuf.FieldType$Collection;
import com.google.protobuf.JavaType;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public final class FieldType
extends Enum {
    private static final /* synthetic */ FieldType[] $VALUES;
    public static final /* enum */ FieldType BOOL;
    public static final /* enum */ FieldType BOOL_LIST;
    public static final /* enum */ FieldType BOOL_LIST_PACKED;
    public static final /* enum */ FieldType BYTES;
    public static final /* enum */ FieldType BYTES_LIST;
    public static final /* enum */ FieldType DOUBLE;
    public static final /* enum */ FieldType DOUBLE_LIST;
    public static final /* enum */ FieldType DOUBLE_LIST_PACKED;
    private static final Type[] EMPTY_TYPES;
    public static final /* enum */ FieldType ENUM;
    public static final /* enum */ FieldType ENUM_LIST;
    public static final /* enum */ FieldType ENUM_LIST_PACKED;
    public static final /* enum */ FieldType FIXED32;
    public static final /* enum */ FieldType FIXED32_LIST;
    public static final /* enum */ FieldType FIXED32_LIST_PACKED;
    public static final /* enum */ FieldType FIXED64;
    public static final /* enum */ FieldType FIXED64_LIST;
    public static final /* enum */ FieldType FIXED64_LIST_PACKED;
    public static final /* enum */ FieldType FLOAT;
    public static final /* enum */ FieldType FLOAT_LIST;
    public static final /* enum */ FieldType FLOAT_LIST_PACKED;
    public static final /* enum */ FieldType GROUP;
    public static final /* enum */ FieldType GROUP_LIST;
    public static final /* enum */ FieldType INT32;
    public static final /* enum */ FieldType INT32_LIST;
    public static final /* enum */ FieldType INT32_LIST_PACKED;
    public static final /* enum */ FieldType INT64;
    public static final /* enum */ FieldType INT64_LIST;
    public static final /* enum */ FieldType INT64_LIST_PACKED;
    public static final /* enum */ FieldType MAP;
    public static final /* enum */ FieldType MESSAGE;
    public static final /* enum */ FieldType MESSAGE_LIST;
    public static final /* enum */ FieldType SFIXED32;
    public static final /* enum */ FieldType SFIXED32_LIST;
    public static final /* enum */ FieldType SFIXED32_LIST_PACKED;
    public static final /* enum */ FieldType SFIXED64;
    public static final /* enum */ FieldType SFIXED64_LIST;
    public static final /* enum */ FieldType SFIXED64_LIST_PACKED;
    public static final /* enum */ FieldType SINT32;
    public static final /* enum */ FieldType SINT32_LIST;
    public static final /* enum */ FieldType SINT32_LIST_PACKED;
    public static final /* enum */ FieldType SINT64;
    public static final /* enum */ FieldType SINT64_LIST;
    public static final /* enum */ FieldType SINT64_LIST_PACKED;
    public static final /* enum */ FieldType STRING;
    public static final /* enum */ FieldType STRING_LIST;
    public static final /* enum */ FieldType UINT32;
    public static final /* enum */ FieldType UINT32_LIST;
    public static final /* enum */ FieldType UINT32_LIST_PACKED;
    public static final /* enum */ FieldType UINT64;
    public static final /* enum */ FieldType UINT64_LIST;
    public static final /* enum */ FieldType UINT64_LIST_PACKED;
    private static final FieldType[] VALUES;
    private final FieldType$Collection collection;
    private final Class elementType;
    private final int id;
    private final JavaType javaType;
    private final boolean primitiveScalar;

    static {
        FieldType[] fieldTypeArray;
        FieldType$Collection fieldType$Collection = FieldType$Collection.SCALAR;
        Enum enum_ = JavaType.DOUBLE;
        FieldType fieldType2 = null;
        FieldType[] fieldTypeArray2 = fieldTypeArray;
        FieldType[] fieldTypeArray3 = fieldType$Collection;
        JavaType javaType = enum_;
        fieldTypeArray = new FieldType("DOUBLE", 0, 0, fieldType$Collection, (JavaType)enum_);
        DOUBLE = fieldTypeArray;
        Object object = JavaType.FLOAT;
        fieldTypeArray2 = fieldTypeArray;
        javaType = object;
        fieldTypeArray = new FieldType("FLOAT", 1, 1, fieldType$Collection, object);
        FLOAT = fieldTypeArray;
        JavaType javaType2 = JavaType.LONG;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType2;
        fieldTypeArray = new FieldType("INT64", 2, 2, fieldType$Collection, javaType2);
        INT64 = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        fieldTypeArray = new FieldType("UINT64", 3, 3, fieldType$Collection, javaType2);
        UINT64 = fieldTypeArray;
        JavaType javaType3 = JavaType.INT;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("INT32", 4, 4, fieldType$Collection, javaType3);
        INT32 = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType2;
        fieldTypeArray = new FieldType("FIXED64", 5, 5, fieldType$Collection, javaType2);
        FIXED64 = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("FIXED32", 6, 6, fieldType$Collection, javaType3);
        FIXED32 = fieldTypeArray;
        Enum enum_2 = JavaType.BOOLEAN;
        fieldTypeArray2 = fieldTypeArray;
        javaType = enum_2;
        fieldTypeArray = new FieldType("BOOL", 7, 7, fieldType$Collection, (JavaType)enum_2);
        BOOL = fieldTypeArray;
        Enum enum_3 = JavaType.STRING;
        fieldTypeArray2 = fieldTypeArray;
        javaType = enum_3;
        fieldTypeArray = new FieldType("STRING", 8, 8, fieldType$Collection, (JavaType)enum_3);
        STRING = fieldTypeArray;
        JavaType javaType4 = JavaType.MESSAGE;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType4;
        fieldTypeArray = new FieldType("MESSAGE", 9, 9, fieldType$Collection, javaType4);
        MESSAGE = fieldTypeArray;
        JavaType javaType5 = JavaType.BYTE_STRING;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType5;
        fieldTypeArray = new FieldType("BYTES", 10, 10, fieldType$Collection, javaType5);
        BYTES = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("UINT32", 11, 11, fieldType$Collection, javaType3);
        UINT32 = fieldTypeArray;
        JavaType javaType6 = JavaType.ENUM;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType6;
        fieldTypeArray = new FieldType("ENUM", 12, 12, fieldType$Collection, javaType6);
        ENUM = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("SFIXED32", 13, 13, fieldType$Collection, javaType3);
        SFIXED32 = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType2;
        fieldTypeArray = new FieldType("SFIXED64", 14, 14, fieldType$Collection, javaType2);
        SFIXED64 = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("SINT32", 15, 15, fieldType$Collection, javaType3);
        SINT32 = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType2;
        fieldTypeArray = new FieldType("SINT64", 16, 16, fieldType$Collection, javaType2);
        SINT64 = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType4;
        fieldTypeArray = new FieldType("GROUP", 17, 17, fieldType$Collection, javaType4);
        GROUP = fieldTypeArray;
        fieldType$Collection = FieldType$Collection.VECTOR;
        fieldTypeArray2 = fieldTypeArray;
        fieldTypeArray3 = fieldType$Collection;
        javaType = enum_;
        fieldTypeArray = new FieldType("DOUBLE_LIST", 18, 18, fieldType$Collection, (JavaType)enum_);
        DOUBLE_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = object;
        fieldTypeArray = new FieldType("FLOAT_LIST", 19, 19, fieldType$Collection, object);
        FLOAT_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType2;
        fieldTypeArray = new FieldType("INT64_LIST", 20, 20, fieldType$Collection, javaType2);
        INT64_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        fieldTypeArray = new FieldType("UINT64_LIST", 21, 21, fieldType$Collection, javaType2);
        UINT64_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("INT32_LIST", 22, 22, fieldType$Collection, javaType3);
        INT32_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType2;
        fieldTypeArray = new FieldType("FIXED64_LIST", 23, 23, fieldType$Collection, javaType2);
        FIXED64_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("FIXED32_LIST", 24, 24, fieldType$Collection, javaType3);
        FIXED32_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = enum_2;
        fieldTypeArray = new FieldType("BOOL_LIST", 25, 25, fieldType$Collection, (JavaType)enum_2);
        BOOL_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = enum_3;
        fieldTypeArray = new FieldType("STRING_LIST", 26, 26, fieldType$Collection, (JavaType)enum_3);
        STRING_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType4;
        fieldTypeArray = new FieldType("MESSAGE_LIST", 27, 27, fieldType$Collection, javaType4);
        MESSAGE_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType5;
        fieldTypeArray = new FieldType("BYTES_LIST", 28, 28, fieldType$Collection, javaType5);
        BYTES_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("UINT32_LIST", 29, 29, fieldType$Collection, javaType3);
        UINT32_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType6;
        fieldTypeArray = new FieldType("ENUM_LIST", 30, 30, fieldType$Collection, javaType6);
        ENUM_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("SFIXED32_LIST", 31, 31, fieldType$Collection, javaType3);
        SFIXED32_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType2;
        fieldTypeArray = new FieldType("SFIXED64_LIST", 32, 32, fieldType$Collection, javaType2);
        SFIXED64_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("SINT32_LIST", 33, 33, fieldType$Collection, javaType3);
        SINT32_LIST = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType2;
        fieldTypeArray = new FieldType("SINT64_LIST", 34, 34, fieldType$Collection, javaType2);
        SINT64_LIST = fieldTypeArray;
        enum_3 = FieldType$Collection.PACKED_VECTOR;
        fieldTypeArray2 = fieldTypeArray;
        fieldTypeArray3 = enum_3;
        javaType = enum_;
        fieldTypeArray = new FieldType("DOUBLE_LIST_PACKED", 35, 35, (FieldType$Collection)enum_3, (JavaType)enum_);
        DOUBLE_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = object;
        fieldTypeArray = new FieldType("FLOAT_LIST_PACKED", 36, 36, (FieldType$Collection)enum_3, object);
        FLOAT_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType2;
        fieldTypeArray = new FieldType("INT64_LIST_PACKED", 37, 37, (FieldType$Collection)enum_3, javaType2);
        INT64_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        fieldTypeArray = new FieldType("UINT64_LIST_PACKED", 38, 38, (FieldType$Collection)enum_3, javaType2);
        UINT64_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("INT32_LIST_PACKED", 39, 39, (FieldType$Collection)enum_3, javaType3);
        INT32_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType2;
        fieldTypeArray = new FieldType("FIXED64_LIST_PACKED", 40, 40, (FieldType$Collection)enum_3, javaType2);
        FIXED64_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("FIXED32_LIST_PACKED", 41, 41, (FieldType$Collection)enum_3, javaType3);
        FIXED32_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = enum_2;
        fieldTypeArray = new FieldType("BOOL_LIST_PACKED", 42, 42, (FieldType$Collection)enum_3, (JavaType)enum_2);
        BOOL_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("UINT32_LIST_PACKED", 43, 43, (FieldType$Collection)enum_3, javaType3);
        UINT32_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType6;
        fieldTypeArray = new FieldType("ENUM_LIST_PACKED", 44, 44, (FieldType$Collection)enum_3, javaType6);
        ENUM_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = javaType3;
        fieldTypeArray = new FieldType("SFIXED32_LIST_PACKED", 45, 45, (FieldType$Collection)enum_3, javaType3);
        SFIXED32_LIST_PACKED = fieldTypeArray;
        enum_ = JavaType.LONG;
        fieldTypeArray2 = fieldTypeArray;
        javaType = enum_;
        fieldTypeArray = new FieldType("SFIXED64_LIST_PACKED", 46, 46, (FieldType$Collection)enum_3, (JavaType)enum_);
        SFIXED64_LIST_PACKED = fieldTypeArray;
        javaType = JavaType.INT;
        fieldTypeArray2 = fieldTypeArray;
        fieldTypeArray = new FieldType("SINT32_LIST_PACKED", 47, 47, (FieldType$Collection)enum_3, javaType);
        SINT32_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        javaType = enum_;
        fieldTypeArray = new FieldType("SINT64_LIST_PACKED", 48, 48, (FieldType$Collection)enum_3, (JavaType)enum_);
        SINT64_LIST_PACKED = fieldTypeArray;
        fieldTypeArray2 = fieldTypeArray;
        fieldTypeArray3 = fieldType$Collection;
        javaType = javaType4;
        fieldTypeArray = new FieldType("GROUP_LIST", 49, 49, fieldType$Collection, javaType4);
        GROUP_LIST = fieldTypeArray;
        enum_2 = FieldType$Collection.MAP;
        enum_3 = JavaType.VOID;
        object = "MAP";
        int n10 = 50;
        int n11 = 50;
        enum_ = fieldTypeArray2;
        fieldTypeArray2 = new FieldType((String)object, n10, n11, (FieldType$Collection)enum_2, (JavaType)enum_3);
        MAP = fieldTypeArray2;
        int n12 = 51;
        fieldTypeArray2 = new FieldType[n12];
        FieldType[] fieldTypeArray4 = DOUBLE;
        fieldTypeArray2[0] = fieldTypeArray4;
        fieldTypeArray4 = FLOAT;
        fieldTypeArray2[1] = fieldTypeArray4;
        fieldTypeArray4 = INT64;
        fieldTypeArray2[2] = fieldTypeArray4;
        fieldTypeArray4 = UINT64;
        fieldTypeArray2[3] = fieldTypeArray4;
        fieldTypeArray4 = INT32;
        fieldTypeArray2[4] = fieldTypeArray4;
        fieldTypeArray4 = FIXED64;
        fieldTypeArray2[5] = fieldTypeArray4;
        fieldTypeArray4 = FIXED32;
        fieldTypeArray2[6] = fieldTypeArray4;
        fieldTypeArray4 = BOOL;
        fieldTypeArray2[7] = fieldTypeArray4;
        fieldTypeArray4 = STRING;
        fieldTypeArray2[8] = fieldTypeArray4;
        fieldTypeArray4 = MESSAGE;
        fieldTypeArray2[9] = fieldTypeArray4;
        fieldTypeArray4 = BYTES;
        fieldTypeArray2[10] = fieldTypeArray4;
        fieldTypeArray4 = UINT32;
        fieldTypeArray2[11] = fieldTypeArray4;
        fieldTypeArray4 = ENUM;
        fieldTypeArray2[12] = fieldTypeArray4;
        fieldTypeArray4 = SFIXED32;
        fieldTypeArray2[13] = fieldTypeArray4;
        fieldTypeArray4 = SFIXED64;
        fieldTypeArray2[14] = fieldTypeArray4;
        fieldTypeArray4 = SINT32;
        fieldTypeArray2[15] = fieldTypeArray4;
        fieldTypeArray4 = SINT64;
        fieldTypeArray2[16] = fieldTypeArray4;
        fieldTypeArray4 = GROUP;
        fieldTypeArray2[17] = fieldTypeArray4;
        fieldTypeArray4 = DOUBLE_LIST;
        fieldTypeArray2[18] = fieldTypeArray4;
        fieldTypeArray4 = FLOAT_LIST;
        fieldTypeArray2[19] = fieldTypeArray4;
        fieldTypeArray4 = INT64_LIST;
        fieldTypeArray2[20] = fieldTypeArray4;
        fieldTypeArray4 = UINT64_LIST;
        fieldTypeArray2[21] = fieldTypeArray4;
        fieldTypeArray4 = INT32_LIST;
        fieldTypeArray2[22] = fieldTypeArray4;
        fieldTypeArray4 = FIXED64_LIST;
        fieldTypeArray2[23] = fieldTypeArray4;
        fieldTypeArray4 = FIXED32_LIST;
        fieldTypeArray2[24] = fieldTypeArray4;
        fieldTypeArray4 = BOOL_LIST;
        fieldTypeArray2[25] = fieldTypeArray4;
        fieldTypeArray4 = STRING_LIST;
        fieldTypeArray2[26] = fieldTypeArray4;
        fieldTypeArray4 = MESSAGE_LIST;
        fieldTypeArray2[27] = fieldTypeArray4;
        fieldTypeArray4 = BYTES_LIST;
        fieldTypeArray2[28] = fieldTypeArray4;
        fieldTypeArray4 = UINT32_LIST;
        fieldTypeArray2[29] = fieldTypeArray4;
        fieldTypeArray4 = ENUM_LIST;
        fieldTypeArray2[30] = fieldTypeArray4;
        fieldTypeArray4 = SFIXED32_LIST;
        fieldTypeArray2[31] = fieldTypeArray4;
        fieldTypeArray4 = SFIXED64_LIST;
        fieldTypeArray2[32] = fieldTypeArray4;
        fieldTypeArray4 = SINT32_LIST;
        fieldTypeArray2[33] = fieldTypeArray4;
        fieldTypeArray4 = SINT64_LIST;
        fieldTypeArray2[34] = fieldTypeArray4;
        fieldTypeArray4 = DOUBLE_LIST_PACKED;
        fieldTypeArray2[35] = fieldTypeArray4;
        fieldTypeArray4 = FLOAT_LIST_PACKED;
        fieldTypeArray2[36] = fieldTypeArray4;
        fieldTypeArray4 = INT64_LIST_PACKED;
        fieldTypeArray2[37] = fieldTypeArray4;
        fieldTypeArray4 = UINT64_LIST_PACKED;
        fieldTypeArray2[38] = fieldTypeArray4;
        fieldTypeArray4 = INT32_LIST_PACKED;
        fieldTypeArray2[39] = fieldTypeArray4;
        fieldTypeArray4 = FIXED64_LIST_PACKED;
        fieldTypeArray2[40] = fieldTypeArray4;
        fieldTypeArray4 = FIXED32_LIST_PACKED;
        fieldTypeArray2[41] = fieldTypeArray4;
        fieldTypeArray4 = BOOL_LIST_PACKED;
        fieldTypeArray2[42] = fieldTypeArray4;
        fieldTypeArray4 = UINT32_LIST_PACKED;
        fieldTypeArray2[43] = fieldTypeArray4;
        fieldTypeArray4 = ENUM_LIST_PACKED;
        fieldTypeArray2[44] = fieldTypeArray4;
        fieldTypeArray4 = SFIXED32_LIST_PACKED;
        fieldTypeArray2[45] = fieldTypeArray4;
        fieldTypeArray4 = SFIXED64_LIST_PACKED;
        fieldTypeArray2[46] = fieldTypeArray4;
        fieldTypeArray4 = SINT32_LIST_PACKED;
        fieldTypeArray2[47] = fieldTypeArray4;
        fieldTypeArray4 = SINT64_LIST_PACKED;
        fieldTypeArray2[48] = fieldTypeArray4;
        fieldTypeArray4 = GROUP_LIST;
        fieldTypeArray2[49] = fieldTypeArray4;
        fieldTypeArray4 = MAP;
        int n13 = 50;
        fieldTypeArray2[n13] = fieldTypeArray4;
        $VALUES = fieldTypeArray2;
        EMPTY_TYPES = new Type[0];
        fieldTypeArray2 = FieldType.values();
        fieldTypeArray4 = new FieldType[fieldTypeArray2.length];
        VALUES = fieldTypeArray4;
        for (FieldType fieldType2 : fieldTypeArray2) {
            fieldTypeArray3 = VALUES;
            int n14 = fieldType2.id;
            fieldTypeArray3[n14] = fieldType2;
        }
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FieldType(JavaType javaType) {
        int n11;
        int n12;
        void var5_4;
        int[] nArray;
        void var2_-1;
        void var1_-1;
        this.id = (int)javaType;
        this.collection = nArray;
        this.javaType = var5_4;
        Object object = FieldType$1.$SwitchMap$com$google$protobuf$FieldType$Collection;
        int n13 = nArray.ordinal();
        int n14 = object[n13];
        n13 = 2;
        int n15 = 1;
        if (n14 != n15) {
            if (n14 != n13) {
                n14 = 0;
                object = null;
                this.elementType = null;
            } else {
                object = var5_4.getBoxedType();
                this.elementType = object;
            }
        } else {
            object = var5_4.getBoxedType();
            this.elementType = object;
        }
        n14 = 0;
        object = null;
        FieldType$Collection fieldType$Collection = FieldType$Collection.SCALAR;
        if (nArray != fieldType$Collection || (n12 = (nArray = FieldType$1.$SwitchMap$com$google$protobuf$JavaType)[n11 = var5_4.ordinal()]) == n15 || n12 == n13 || n12 == (n13 = 3)) {
            n15 = 0;
        }
        this.primitiveScalar = n15;
    }

    public static FieldType forId(int n10) {
        FieldType[] fieldTypeArray;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (fieldTypeArray = VALUES).length)) {
            return fieldTypeArray[n10];
        }
        return null;
    }

    private static Type getGenericSuperList(Class type) {
        for (Type type2 : ((Class)type).getGenericInterfaces()) {
            boolean bl2 = type2 instanceof ParameterizedType;
            if (!bl2) continue;
            Type type3 = type2;
            Class<List> clazz = List.class;
            type3 = (Class)((ParameterizedType)type2).getRawType();
            bl2 = clazz.isAssignableFrom((Class<?>)type3);
            if (!bl2) continue;
            return type2;
        }
        boolean bl3 = (type = ((Class)type).getGenericSuperclass()) instanceof ParameterizedType;
        if (bl3) {
            Type type4 = type;
            Class<List> clazz = List.class;
            Class clazz2 = (Class)((ParameterizedType)type).getRawType();
            bl3 = clazz.isAssignableFrom(clazz2);
            if (bl3) {
                return type;
            }
        }
        return null;
    }

    private static Type getListParameter(Class serializable, Type[] object) {
        int n10;
        block0: while (true) {
            int n11;
            Class<List> clazz;
            Object object2;
            Object object3 = List.class;
            n10 = 1;
            if (serializable == object3) break;
            object3 = FieldType.getGenericSuperList((Class)serializable);
            boolean bl2 = object3 instanceof ParameterizedType;
            if (bl2) {
                int n12;
                object3 = (ParameterizedType)object3;
                object2 = object3.getActualTypeArguments();
                clazz = null;
                for (n11 = 0; n11 < (n12 = ((Type[])object2).length); ++n11) {
                    Type type = object2[n11];
                    int n13 = type instanceof TypeVariable;
                    if (n13 == 0) continue;
                    int n14 = ((Type[])object).length;
                    Object object4 = ((Class)serializable).getTypeParameters();
                    int n15 = ((TypeVariable<Class<T>>[])object4).length;
                    if (n14 == n15) {
                        block7: {
                            for (n14 = 0; n14 < (n15 = ((TypeVariable<Class<T>>[])object4).length); ++n14) {
                                TypeVariable typeVariable = object4[n14];
                                if (type != typeVariable) continue;
                                object2[n11] = object4 = object[n14];
                                n13 = n10;
                                break block7;
                            }
                            n13 = 0;
                            object4 = null;
                        }
                        if (n13 != 0) continue;
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Unable to find replacement for ");
                        ((StringBuilder)object).append(type);
                        object = ((StringBuilder)object).toString();
                        serializable = new RuntimeException((String)object);
                        throw serializable;
                    }
                    serializable = new RuntimeException("Type array mismatch");
                    throw serializable;
                }
                serializable = (Class)object3.getRawType();
                object = object2;
                continue;
            }
            object = EMPTY_TYPES;
            object3 = ((Class)serializable).getInterfaces();
            n10 = ((Class<?>[])object3).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                clazz = List.class;
                object2 = object3[i10];
                n11 = (int)(clazz.isAssignableFrom((Class<?>)object2) ? 1 : 0);
                if (n11 == 0) continue;
                serializable = object2;
                continue block0;
            }
            serializable = ((Class)serializable).getSuperclass();
        }
        int n16 = ((Type[])object).length;
        if (n16 == n10) {
            return object[0];
        }
        serializable = new RuntimeException("Unable to identify parameter type for List<T>");
        throw serializable;
    }

    private boolean isValidForList(Field object) {
        boolean bl2;
        Class clazz = ((Field)object).getType();
        Type[] typeArray = this.javaType.getType();
        boolean bl3 = typeArray.isAssignableFrom(clazz);
        if (!bl3) {
            return false;
        }
        typeArray = EMPTY_TYPES;
        Type type = ((Field)object).getGenericType();
        boolean bl4 = type instanceof ParameterizedType;
        if (bl4) {
            object = (ParameterizedType)((Field)object).getGenericType();
            typeArray = object.getActualTypeArguments();
        }
        if (!(bl2 = (object = FieldType.getListParameter(clazz, typeArray)) instanceof Class)) {
            return true;
        }
        clazz = this.elementType;
        object = (Class)object;
        return clazz.isAssignableFrom((Class<?>)object);
    }

    public static FieldType valueOf(String string2) {
        return Enum.valueOf(FieldType.class, string2);
    }

    public static FieldType[] values() {
        return (FieldType[])$VALUES.clone();
    }

    public JavaType getJavaType() {
        return this.javaType;
    }

    public int id() {
        return this.id;
    }

    public boolean isList() {
        return this.collection.isList();
    }

    public boolean isMap() {
        boolean bl2;
        FieldType$Collection fieldType$Collection = this.collection;
        FieldType$Collection fieldType$Collection2 = FieldType$Collection.MAP;
        if (fieldType$Collection == fieldType$Collection2) {
            bl2 = true;
        } else {
            bl2 = false;
            fieldType$Collection = null;
        }
        return bl2;
    }

    public boolean isPacked() {
        FieldType$Collection fieldType$Collection = FieldType$Collection.PACKED_VECTOR;
        FieldType$Collection fieldType$Collection2 = this.collection;
        return fieldType$Collection.equals((Object)fieldType$Collection2);
    }

    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public boolean isScalar() {
        boolean bl2;
        FieldType$Collection fieldType$Collection = this.collection;
        FieldType$Collection fieldType$Collection2 = FieldType$Collection.SCALAR;
        if (fieldType$Collection == fieldType$Collection2) {
            bl2 = true;
        } else {
            bl2 = false;
            fieldType$Collection = null;
        }
        return bl2;
    }

    public boolean isValidForField(Field annotatedElement) {
        Object object = FieldType$Collection.VECTOR;
        FieldType$Collection fieldType$Collection = this.collection;
        boolean bl2 = object.equals((Object)fieldType$Collection);
        if (bl2) {
            return this.isValidForList((Field)annotatedElement);
        }
        object = this.javaType.getType();
        annotatedElement = annotatedElement.getType();
        return ((Class)object).isAssignableFrom((Class<?>)annotatedElement);
    }
}


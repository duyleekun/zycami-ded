/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.Serializable;
import java.lang.constant.Constable;

public final class JavaType
extends Enum {
    private static final /* synthetic */ JavaType[] $VALUES;
    public static final /* enum */ JavaType BOOLEAN;
    public static final /* enum */ JavaType BYTE_STRING;
    public static final /* enum */ JavaType DOUBLE;
    public static final /* enum */ JavaType ENUM;
    public static final /* enum */ JavaType FLOAT;
    public static final /* enum */ JavaType INT;
    public static final /* enum */ JavaType LONG;
    public static final /* enum */ JavaType MESSAGE;
    public static final /* enum */ JavaType STRING;
    public static final /* enum */ JavaType VOID;
    private final Class boxedType;
    private final Object defaultDefault;
    private final Class type;

    static {
        JavaType javaType;
        JavaType javaType2;
        JavaType javaType3;
        JavaType javaType4;
        JavaType javaType5;
        JavaType[] javaTypeArray;
        JavaType[] javaTypeArray2 = javaTypeArray;
        javaTypeArray = new JavaType("VOID", 0, Void.class, Void.class, null);
        VOID = javaTypeArray;
        Object object = Integer.TYPE;
        Serializable serializable = 0;
        JavaType[] javaTypeArray3 = javaTypeArray2;
        Class<Constable> clazz = object;
        javaTypeArray2 = new JavaType("INT", 1, object, Integer.class, (Object)serializable);
        INT = javaTypeArray2;
        Class<Number> clazz2 = Long.TYPE;
        Number number = 0L;
        JavaType javaType6 = javaType5;
        LONG = javaType5 = new JavaType("LONG", 2, clazz2, Long.class, (Object)number);
        clazz = Float.TYPE;
        serializable = Float.valueOf(0.0f);
        javaTypeArray3 = javaType4;
        FLOAT = javaType4 = new JavaType("FLOAT", 3, clazz, Float.class, (Object)serializable);
        clazz2 = Double.TYPE;
        number = 0.0;
        javaType6 = javaType3;
        DOUBLE = javaType3 = new JavaType("DOUBLE", 4, clazz2, Double.class, (Object)number);
        clazz = Boolean.TYPE;
        serializable = Boolean.FALSE;
        javaTypeArray3 = javaType6;
        BOOLEAN = javaType6 = new JavaType("BOOLEAN", 5, clazz, Boolean.class, (Object)serializable);
        JavaType javaType7 = javaType2;
        STRING = javaType2 = new JavaType("STRING", 6, String.class, String.class, (Object)"");
        serializable = ByteString.EMPTY;
        javaTypeArray3 = javaType7;
        BYTE_STRING = javaType7 = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, (Object)serializable);
        javaTypeArray3 = javaType;
        clazz = object;
        ENUM = javaType = new JavaType("ENUM", 8, object, Integer.class, null);
        object = new Object("MESSAGE", 9, Object.class, Object.class, null);
        MESSAGE = object;
        javaTypeArray3 = new JavaType[]{javaTypeArray, javaTypeArray2, javaType5, javaType4, javaType3, javaType6, javaType2, javaType7, javaType, object};
        $VALUES = javaTypeArray3;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private JavaType(Object object) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.type = object;
        this.boxedType = var4_2;
        this.defaultDefault = var5_3;
    }

    public static JavaType valueOf(String string2) {
        return Enum.valueOf(JavaType.class, string2);
    }

    public static JavaType[] values() {
        return (JavaType[])$VALUES.clone();
    }

    public Class getBoxedType() {
        return this.boxedType;
    }

    public Object getDefaultDefault() {
        return this.defaultDefault;
    }

    public Class getType() {
        return this.type;
    }

    public boolean isValidType(Class clazz) {
        return this.type.isAssignableFrom(clazz);
    }
}


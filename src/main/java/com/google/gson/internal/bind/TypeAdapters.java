/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters$1;
import com.google.gson.internal.bind.TypeAdapters$10;
import com.google.gson.internal.bind.TypeAdapters$11;
import com.google.gson.internal.bind.TypeAdapters$12;
import com.google.gson.internal.bind.TypeAdapters$13;
import com.google.gson.internal.bind.TypeAdapters$14;
import com.google.gson.internal.bind.TypeAdapters$15;
import com.google.gson.internal.bind.TypeAdapters$16;
import com.google.gson.internal.bind.TypeAdapters$17;
import com.google.gson.internal.bind.TypeAdapters$18;
import com.google.gson.internal.bind.TypeAdapters$19;
import com.google.gson.internal.bind.TypeAdapters$2;
import com.google.gson.internal.bind.TypeAdapters$20;
import com.google.gson.internal.bind.TypeAdapters$21;
import com.google.gson.internal.bind.TypeAdapters$22;
import com.google.gson.internal.bind.TypeAdapters$23;
import com.google.gson.internal.bind.TypeAdapters$24;
import com.google.gson.internal.bind.TypeAdapters$25;
import com.google.gson.internal.bind.TypeAdapters$26;
import com.google.gson.internal.bind.TypeAdapters$27;
import com.google.gson.internal.bind.TypeAdapters$28;
import com.google.gson.internal.bind.TypeAdapters$29;
import com.google.gson.internal.bind.TypeAdapters$3;
import com.google.gson.internal.bind.TypeAdapters$30;
import com.google.gson.internal.bind.TypeAdapters$31;
import com.google.gson.internal.bind.TypeAdapters$32;
import com.google.gson.internal.bind.TypeAdapters$33;
import com.google.gson.internal.bind.TypeAdapters$34;
import com.google.gson.internal.bind.TypeAdapters$35;
import com.google.gson.internal.bind.TypeAdapters$4;
import com.google.gson.internal.bind.TypeAdapters$5;
import com.google.gson.internal.bind.TypeAdapters$6;
import com.google.gson.internal.bind.TypeAdapters$7;
import com.google.gson.internal.bind.TypeAdapters$8;
import com.google.gson.internal.bind.TypeAdapters$9;
import com.google.gson.reflect.TypeToken;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class TypeAdapters {
    public static final TypeAdapter ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter ATOMIC_INTEGER;
    public static final TypeAdapter ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter BIG_DECIMAL;
    public static final TypeAdapter BIG_INTEGER;
    public static final TypeAdapter BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter BOOLEAN;
    public static final TypeAdapter BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter FLOAT;
    public static final TypeAdapter INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter LONG;
    public static final TypeAdapter NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter STRING;
    public static final TypeAdapter STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapter URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    static {
        Object object = new TypeAdapters$1();
        object = ((TypeAdapter)object).nullSafe();
        CLASS = object;
        CLASS_FACTORY = TypeAdapters.newFactory(Class.class, (TypeAdapter)object);
        object = new TypeAdapters$2();
        object = ((TypeAdapter)object).nullSafe();
        BIT_SET = object;
        BIT_SET_FACTORY = TypeAdapters.newFactory(BitSet.class, (TypeAdapter)object);
        object = new TypeAdapters$3();
        BOOLEAN = object;
        TypeAdapter typeAdapter = new TypeAdapters$4();
        BOOLEAN_AS_STRING = typeAdapter;
        BOOLEAN_FACTORY = TypeAdapters.newFactory(Boolean.TYPE, Boolean.class, (TypeAdapter)object);
        object = new TypeAdapters$5();
        BYTE = object;
        BYTE_FACTORY = TypeAdapters.newFactory(Byte.TYPE, Byte.class, (TypeAdapter)object);
        object = new TypeAdapters$6();
        SHORT = object;
        SHORT_FACTORY = TypeAdapters.newFactory(Short.TYPE, Short.class, (TypeAdapter)object);
        object = new TypeAdapters$7();
        INTEGER = object;
        INTEGER_FACTORY = TypeAdapters.newFactory(Integer.TYPE, Integer.class, (TypeAdapter)object);
        object = new TypeAdapters$8();
        object = ((TypeAdapter)object).nullSafe();
        ATOMIC_INTEGER = object;
        ATOMIC_INTEGER_FACTORY = TypeAdapters.newFactory(AtomicInteger.class, (TypeAdapter)object);
        object = new TypeAdapters$9();
        object = ((TypeAdapter)object).nullSafe();
        ATOMIC_BOOLEAN = object;
        ATOMIC_BOOLEAN_FACTORY = TypeAdapters.newFactory(AtomicBoolean.class, (TypeAdapter)object);
        object = new TypeAdapters$10();
        object = ((TypeAdapter)object).nullSafe();
        ATOMIC_INTEGER_ARRAY = object;
        ATOMIC_INTEGER_ARRAY_FACTORY = TypeAdapters.newFactory(AtomicIntegerArray.class, (TypeAdapter)object);
        object = new TypeAdapters$11();
        LONG = object;
        object = new TypeAdapters$12();
        FLOAT = object;
        object = new TypeAdapters$13();
        DOUBLE = object;
        object = new TypeAdapters$14();
        NUMBER = object;
        NUMBER_FACTORY = TypeAdapters.newFactory(Number.class, (TypeAdapter)object);
        object = new TypeAdapters$15();
        CHARACTER = object;
        CHARACTER_FACTORY = TypeAdapters.newFactory(Character.TYPE, Character.class, (TypeAdapter)object);
        object = new TypeAdapters$16();
        STRING = object;
        typeAdapter = new TypeAdapters$17();
        BIG_DECIMAL = typeAdapter;
        typeAdapter = new TypeAdapters$18();
        BIG_INTEGER = typeAdapter;
        STRING_FACTORY = TypeAdapters.newFactory(String.class, (TypeAdapter)object);
        object = new TypeAdapters$19();
        STRING_BUILDER = object;
        STRING_BUILDER_FACTORY = TypeAdapters.newFactory(StringBuilder.class, (TypeAdapter)object);
        object = new TypeAdapters$20();
        STRING_BUFFER = object;
        STRING_BUFFER_FACTORY = TypeAdapters.newFactory(StringBuffer.class, (TypeAdapter)object);
        object = new TypeAdapters$21();
        URL = object;
        URL_FACTORY = TypeAdapters.newFactory(URL.class, (TypeAdapter)object);
        object = new TypeAdapters$22();
        URI = object;
        URI_FACTORY = TypeAdapters.newFactory(URI.class, (TypeAdapter)object);
        object = new TypeAdapters$23();
        INET_ADDRESS = object;
        INET_ADDRESS_FACTORY = TypeAdapters.newTypeHierarchyFactory(InetAddress.class, (TypeAdapter)object);
        object = new TypeAdapters$24();
        UUID = object;
        UUID_FACTORY = TypeAdapters.newFactory(UUID.class, (TypeAdapter)object);
        object = new TypeAdapters$25();
        object = ((TypeAdapter)object).nullSafe();
        CURRENCY = object;
        CURRENCY_FACTORY = TypeAdapters.newFactory(Currency.class, (TypeAdapter)object);
        TIMESTAMP_FACTORY = object = new TypeAdapters$26();
        CALENDAR = object = new TypeAdapters$27();
        CALENDAR_FACTORY = TypeAdapters.newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, (TypeAdapter)object);
        LOCALE = object = new TypeAdapters$28();
        LOCALE_FACTORY = TypeAdapters.newFactory(Locale.class, (TypeAdapter)object);
        JSON_ELEMENT = object = new TypeAdapters$29();
        JSON_ELEMENT_FACTORY = TypeAdapters.newTypeHierarchyFactory(JsonElement.class, (TypeAdapter)object);
        ENUM_FACTORY = object = new TypeAdapters$30();
    }

    private TypeAdapters() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public static TypeAdapterFactory newFactory(TypeToken typeToken, TypeAdapter typeAdapter) {
        TypeAdapters$31 typeAdapters$31 = new TypeAdapters$31(typeToken, typeAdapter);
        return typeAdapters$31;
    }

    public static TypeAdapterFactory newFactory(Class clazz, TypeAdapter typeAdapter) {
        TypeAdapters$32 typeAdapters$32 = new TypeAdapters$32(clazz, typeAdapter);
        return typeAdapters$32;
    }

    public static TypeAdapterFactory newFactory(Class clazz, Class clazz2, TypeAdapter typeAdapter) {
        TypeAdapters$33 typeAdapters$33 = new TypeAdapters$33(clazz, clazz2, typeAdapter);
        return typeAdapters$33;
    }

    public static TypeAdapterFactory newFactoryForMultipleTypes(Class clazz, Class clazz2, TypeAdapter typeAdapter) {
        TypeAdapters$34 typeAdapters$34 = new TypeAdapters$34(clazz, clazz2, typeAdapter);
        return typeAdapters$34;
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class clazz, TypeAdapter typeAdapter) {
        TypeAdapters$35 typeAdapters$35 = new TypeAdapters$35(clazz, typeAdapter);
        return typeAdapters$35;
    }
}


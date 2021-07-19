/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class Primitives {
    private static final Map PRIMITIVE_TO_WRAPPER_TYPE;
    private static final Map WRAPPER_TO_PRIMITIVE_TYPE;

    static {
        int n10 = 16;
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(n10);
        Class<Object> clazz = Boolean.TYPE;
        Primitives.add(linkedHashMap, linkedHashMap2, clazz, Boolean.class);
        clazz = Byte.TYPE;
        Primitives.add(linkedHashMap, linkedHashMap2, clazz, Byte.class);
        clazz = Character.TYPE;
        Primitives.add(linkedHashMap, linkedHashMap2, clazz, Character.class);
        clazz = Double.TYPE;
        Primitives.add(linkedHashMap, linkedHashMap2, clazz, Double.class);
        clazz = Float.TYPE;
        Primitives.add(linkedHashMap, linkedHashMap2, clazz, Float.class);
        clazz = Integer.TYPE;
        Primitives.add(linkedHashMap, linkedHashMap2, clazz, Integer.class);
        clazz = Long.TYPE;
        Primitives.add(linkedHashMap, linkedHashMap2, clazz, Long.class);
        clazz = Short.TYPE;
        Primitives.add(linkedHashMap, linkedHashMap2, clazz, Short.class);
        clazz = Void.TYPE;
        Primitives.add(linkedHashMap, linkedHashMap2, clazz, Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(linkedHashMap);
        WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(linkedHashMap2);
    }

    private Primitives() {
    }

    private static void add(Map map, Map map2, Class clazz, Class clazz2) {
        map.put(clazz, clazz2);
        map2.put(clazz2, clazz);
    }

    public static Set allPrimitiveTypes() {
        return PRIMITIVE_TO_WRAPPER_TYPE.keySet();
    }

    public static Set allWrapperTypes() {
        return WRAPPER_TO_PRIMITIVE_TYPE.keySet();
    }

    public static boolean isWrapperType(Class object) {
        Map map = WRAPPER_TO_PRIMITIVE_TYPE;
        object = Preconditions.checkNotNull(object);
        return map.containsKey(object);
    }

    public static Class unwrap(Class clazz) {
        Preconditions.checkNotNull(clazz);
        Class clazz2 = (Class)WRAPPER_TO_PRIMITIVE_TYPE.get(clazz);
        if (clazz2 != null) {
            clazz = clazz2;
        }
        return clazz;
    }

    public static Class wrap(Class clazz) {
        Preconditions.checkNotNull(clazz);
        Class clazz2 = (Class)PRIMITIVE_TO_WRAPPER_TYPE.get(clazz);
        if (clazz2 != null) {
            clazz = clazz2;
        }
        return clazz;
    }
}


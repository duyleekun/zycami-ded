/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Enums$StringConverter;
import com.google.common.base.Optional;
import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class Enums {
    private static final Map enumConstantCache;

    static {
        WeakHashMap weakHashMap;
        enumConstantCache = weakHashMap = new WeakHashMap();
    }

    private Enums() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Map getEnumConstants(Class clazz) {
        Map map = enumConstantCache;
        synchronized (map) {
            Object object = map.get(clazz);
            object = (Map)object;
            if (object != null) return object;
            return Enums.populateCache(clazz);
        }
    }

    public static Field getField(Enum object) {
        Object object2 = ((Enum)object).getDeclaringClass();
        try {
            object = ((Enum)object).name();
        }
        catch (NoSuchFieldException noSuchFieldException) {
            object2 = new AssertionError((Object)noSuchFieldException);
            throw object2;
        }
        return ((Class)object2).getDeclaredField((String)object);
    }

    public static Optional getIfPresent(Class clazz, String string2) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(string2);
        return Platform.getEnumIfPresent(clazz, string2);
    }

    private static Map populateCache(Class clazz) {
        boolean bl2;
        HashMap<String, WeakReference<Enum>> hashMap = new HashMap<String, WeakReference<Enum>>();
        Iterator iterator2 = EnumSet.allOf(clazz).iterator();
        while (bl2 = iterator2.hasNext()) {
            Enum enum_ = (Enum)iterator2.next();
            String string2 = enum_.name();
            WeakReference<Enum> weakReference = new WeakReference<Enum>(enum_);
            hashMap.put(string2, weakReference);
        }
        enumConstantCache.put(clazz, hashMap);
        return hashMap;
    }

    public static Converter stringConverter(Class clazz) {
        Enums$StringConverter enums$StringConverter = new Enums$StringConverter(clazz);
        return enums$StringConverter;
    }
}


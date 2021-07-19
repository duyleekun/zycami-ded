/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.reflect.TypeToken$1;
import com.google.common.reflect.TypeToken$TypeCollector$1;
import com.google.common.reflect.TypeToken$TypeCollector$2;
import com.google.common.reflect.TypeToken$TypeCollector$3;
import com.google.common.reflect.TypeToken$TypeCollector$4;
import java.lang.constant.Constable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public abstract class TypeToken$TypeCollector {
    public static final TypeToken$TypeCollector FOR_GENERIC_TYPE;
    public static final TypeToken$TypeCollector FOR_RAW_TYPE;

    static {
        TypeToken$TypeCollector typeToken$TypeCollector = new TypeToken$TypeCollector$1();
        FOR_GENERIC_TYPE = typeToken$TypeCollector;
        typeToken$TypeCollector = new TypeToken$TypeCollector$2();
        FOR_RAW_TYPE = typeToken$TypeCollector;
    }

    private TypeToken$TypeCollector() {
    }

    public /* synthetic */ TypeToken$TypeCollector(TypeToken.1 var1_1) {
        this();
    }

    private int collectTypes(Object object, Map map) {
        int n10;
        int n11;
        int n12;
        Constable constable = (Integer)map.get(object);
        if (constable != null) {
            return (Integer)constable;
        }
        constable = this.getRawType(object);
        boolean n112 = ((Class)constable).isInterface();
        Object object2 = this.getInterfaces(object).iterator();
        while ((n12 = object2.hasNext()) != 0) {
            Object t10 = object2.next();
            n12 = this.collectTypes(t10, map);
            n11 = Math.max(n11, n12);
        }
        object2 = this.getSuperclass(object);
        if (object2 != null) {
            int n13 = this.collectTypes(object2, map);
            n10 = Math.max(n11, n13);
        }
        void var4_7 = n10 + true;
        object2 = (int)var4_7;
        map.put(object, object2);
        return (int)var4_7;
    }

    private static ImmutableList sortKeysByValue(Map object, Comparator comparator) {
        TypeToken$TypeCollector$4 typeToken$TypeCollector$4 = new TypeToken$TypeCollector$4(comparator, (Map)object);
        object = object.keySet();
        return typeToken$TypeCollector$4.immutableSortedCopy((Iterable)object);
    }

    public final TypeToken$TypeCollector classesOnly() {
        TypeToken$TypeCollector$3 typeToken$TypeCollector$3 = new TypeToken$TypeCollector$3(this, this);
        return typeToken$TypeCollector$3;
    }

    public ImmutableList collectTypes(Iterable object) {
        boolean bl2;
        HashMap hashMap = Maps.newHashMap();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            this.collectTypes(e10, hashMap);
        }
        object = Ordering.natural().reverse();
        return TypeToken$TypeCollector.sortKeysByValue(hashMap, (Comparator)object);
    }

    public final ImmutableList collectTypes(Object object) {
        object = ImmutableList.of(object);
        return this.collectTypes((Iterable)object);
    }

    public abstract Iterable getInterfaces(Object var1);

    public abstract Class getRawType(Object var1);

    public abstract Object getSuperclass(Object var1);
}


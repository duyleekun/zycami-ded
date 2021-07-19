/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Strings;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashSet;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashSet;
import com.google.common.collect.MapMaker;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public final class Platform {
    private static final String GWT_RPC_PROPERTY_NAME = "guava.gwt.emergency_reenable_rpc";

    private Platform() {
    }

    public static void checkGwtRpcEnabled() {
        String string2 = GWT_RPC_PROPERTY_NAME;
        Object object = System.getProperty(string2, "true");
        boolean bl2 = Boolean.parseBoolean((String)object);
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{string2, "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ"};
        string2 = Strings.lenientFormat("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", objectArray);
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public static Object[] copy(Object[] objectArray, int n10, int n11, Object[] object) {
        object = object.getClass();
        return Arrays.copyOfRange(objectArray, n10, n11, (Class<? extends T[]>)object);
    }

    public static Object[] newArray(Object[] objectArray, int n10) {
        return (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n10);
    }

    public static Map newHashMapWithExpectedSize(int n10) {
        return CompactHashMap.createWithExpectedSize(n10);
    }

    public static Set newHashSetWithExpectedSize(int n10) {
        return CompactHashSet.createWithExpectedSize(n10);
    }

    public static Map newLinkedHashMapWithExpectedSize(int n10) {
        return CompactLinkedHashMap.createWithExpectedSize(n10);
    }

    public static Set newLinkedHashSetWithExpectedSize(int n10) {
        return CompactLinkedHashSet.createWithExpectedSize(n10);
    }

    public static Set preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    public static Map preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    public static int reduceExponentIfGwt(int n10) {
        return n10;
    }

    public static int reduceIterationsIfGwt(int n10) {
        return n10;
    }

    public static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }
}


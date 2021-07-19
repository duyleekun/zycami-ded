/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static boolean isEmpty(Collection collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    public static List listOf() {
        return Collections.emptyList();
    }

    public static List listOf(Object object) {
        return Collections.singletonList(object);
    }

    public static List listOf(Object ... objectArray) {
        int n10 = objectArray.length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return Collections.unmodifiableList(Arrays.asList(objectArray));
            }
            return CollectionUtils.listOf(objectArray[0]);
        }
        return CollectionUtils.listOf();
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        Map map = CollectionUtils.zzb(3, false);
        map.put(object, object2);
        map.put(object3, object4);
        map.put(object5, object6);
        return Collections.unmodifiableMap(map);
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12) {
        Map map = CollectionUtils.zzb(6, false);
        map.put(object, object2);
        map.put(object3, object4);
        map.put(object5, object6);
        map.put(object7, object8);
        map.put(object9, object10);
        map.put(object11, object12);
        return Collections.unmodifiableMap(map);
    }

    public static Map mapOfKeyValueArrays(Object[] object, Object[] object2) {
        int n10 = ((Object[])object).length;
        int n11 = ((Object[])object2).length;
        if (n10 == n11) {
            n10 = ((Object[])object).length;
            if (n10 != 0) {
                n11 = 1;
                Object var5_5 = null;
                if (n10 != n11) {
                    n10 = ((Object[])object).length;
                    Map map = CollectionUtils.zzb(n10, false);
                    for (int i10 = 0; i10 < (n11 = ((Object[])object).length); ++i10) {
                        Object object3 = object[i10];
                        Object object4 = object2[i10];
                        map.put(object3, object4);
                    }
                    return Collections.unmodifiableMap(map);
                }
                object = object[0];
                object2 = object2[0];
                return Collections.singletonMap(object, object2);
            }
            return Collections.emptyMap();
        }
        int n12 = ((Object[])object).length;
        int n13 = ((Object[])object2).length;
        StringBuilder stringBuilder = new StringBuilder(66);
        stringBuilder.append("Key and values array lengths not equal: ");
        stringBuilder.append(n12);
        stringBuilder.append(" != ");
        stringBuilder.append(n13);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static Set mutableSetOfWithSize(int n10) {
        if (n10 == 0) {
            ArraySet arraySet = new ArraySet();
            return arraySet;
        }
        return CollectionUtils.zza(n10, true);
    }

    public static Set setOf(Object object, Object object2, Object object3) {
        Set set = CollectionUtils.zza(3, false);
        set.add(object);
        set.add(object2);
        set.add(object3);
        return Collections.unmodifiableSet(set);
    }

    public static Set setOf(Object ... object) {
        int n10 = ((Object[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            Set set = null;
            if (n10 != n11) {
                int n12 = 2;
                if (n10 != n12) {
                    int n13 = 3;
                    if (n10 != n13) {
                        int n14 = 4;
                        if (n10 != n14) {
                            Set set2 = CollectionUtils.zza(((Object[])object).length, false);
                            Collections.addAll(set2, object);
                            return Collections.unmodifiableSet(set2);
                        }
                        Object object2 = object[0];
                        Object object3 = object[n11];
                        Object object4 = object[n12];
                        object = object[n13];
                        set = CollectionUtils.zza(n14, false);
                        set.add(object2);
                        set.add(object3);
                        set.add(object4);
                        set.add(object);
                        return Collections.unmodifiableSet(set);
                    }
                    Object object5 = object[0];
                    Object object6 = object[n11];
                    object = object[n12];
                    return CollectionUtils.setOf(object5, object6, object);
                }
                Object object7 = object[0];
                object = object[n11];
                Set set3 = CollectionUtils.zza(n12, false);
                set3.add(object7);
                set3.add(object);
                return Collections.unmodifiableSet(set3);
            }
            return Collections.singleton(object[0]);
        }
        return Collections.emptySet();
    }

    private static Set zza(int n10, boolean n11) {
        float f10 = n11 != 0 ? 0.75f : 1.0f;
        if (n10 <= (n11 = n11 != 0 ? 128 : 256)) {
            ArraySet arraySet = new ArraySet(n10);
            return arraySet;
        }
        HashSet hashSet = new HashSet(n10, f10);
        return hashSet;
    }

    private static Map zzb(int n10, boolean n11) {
        n11 = 256;
        if (n10 <= n11) {
            ArrayMap arrayMap = new ArrayMap(n10);
            return arrayMap;
        }
        HashMap hashMap = new HashMap(n10, 1.0f);
        return hashMap;
    }
}


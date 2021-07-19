/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.MapCollections$MapBulder;
import com.mob.tools.java8.MapFlow$MapItem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapCollections {
    public static MapCollections$MapBulder buildMap() {
        MapCollections$MapBulder mapCollections$MapBulder = new MapCollections$MapBulder();
        return mapCollections$MapBulder;
    }

    public static List listOf(byte ... byArray) {
        int n10;
        int n11 = byArray.length;
        Object[] objectArray = new Byte[n11];
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            n10 = byArray[i10];
            Byte by2 = (byte)n10;
            objectArray[i10] = by2;
        }
        return MapCollections.listOf(objectArray);
    }

    public static List listOf(char ... cArray) {
        int n10;
        int n11 = cArray.length;
        Object[] objectArray = new Character[n11];
        for (int i10 = 0; i10 < (n10 = cArray.length); ++i10) {
            n10 = cArray[i10];
            Character c10 = Character.valueOf((char)n10);
            objectArray[i10] = c10;
        }
        return MapCollections.listOf(objectArray);
    }

    public static List listOf(double ... dArray) {
        int n10;
        int n11 = dArray.length;
        Object[] objectArray = new Double[n11];
        for (int i10 = 0; i10 < (n10 = dArray.length); ++i10) {
            double d10 = dArray[i10];
            Double d11 = d10;
            objectArray[i10] = d11;
        }
        return MapCollections.listOf(objectArray);
    }

    public static List listOf(float ... fArray) {
        int n10;
        int n11 = fArray.length;
        Object[] objectArray = new Float[n11];
        for (int i10 = 0; i10 < (n10 = fArray.length); ++i10) {
            float f10 = fArray[i10];
            Float f11 = Float.valueOf(f10);
            objectArray[i10] = f11;
        }
        return MapCollections.listOf(objectArray);
    }

    public static List listOf(int ... nArray) {
        int n10;
        int n11 = nArray.length;
        Object[] objectArray = new Integer[n11];
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            n10 = nArray[i10];
            Integer n12 = n10;
            objectArray[i10] = n12;
        }
        return MapCollections.listOf(objectArray);
    }

    public static List listOf(long ... lArray) {
        int n10;
        int n11 = lArray.length;
        Object[] objectArray = new Long[n11];
        for (int i10 = 0; i10 < (n10 = lArray.length); ++i10) {
            long l10 = lArray[i10];
            Long l11 = l10;
            objectArray[i10] = l11;
        }
        return MapCollections.listOf(objectArray);
    }

    public static List listOf(Object ... objectArray) {
        return Arrays.asList(objectArray);
    }

    public static List listOf(short ... sArray) {
        int n10;
        int n11 = sArray.length;
        Object[] objectArray = new Short[n11];
        for (int i10 = 0; i10 < (n10 = sArray.length); ++i10) {
            n10 = sArray[i10];
            Short s10 = (short)n10;
            objectArray[i10] = s10;
        }
        return MapCollections.listOf(objectArray);
    }

    public static List listOf(boolean ... blArray) {
        int n10;
        int n11 = blArray.length;
        Object[] objectArray = new Boolean[n11];
        for (int i10 = 0; i10 < (n10 = blArray.length); ++i10) {
            n10 = blArray[i10];
            Boolean bl2 = n10 != 0;
            objectArray[i10] = bl2;
        }
        return MapCollections.listOf(objectArray);
    }

    public static Map mapOf(Object object, Object object2) {
        MapFlow$MapItem[] mapFlow$MapItemArray = new MapFlow$MapItem[]{object = MapFlow$MapItem.of(object, object2)};
        return MapCollections.mapOfRaw(mapFlow$MapItemArray);
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4) {
        MapFlow$MapItem[] mapFlow$MapItemArray = new MapFlow$MapItem[]{object = MapFlow$MapItem.of(object, object2), object = MapFlow$MapItem.of(object3, object4)};
        return MapCollections.mapOfRaw(mapFlow$MapItemArray);
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        MapFlow$MapItem[] mapFlow$MapItemArray = new MapFlow$MapItem[]{object = MapFlow$MapItem.of(object, object2), object = MapFlow$MapItem.of(object3, object4), object = MapFlow$MapItem.of(object5, object6)};
        return MapCollections.mapOfRaw(mapFlow$MapItemArray);
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        MapFlow$MapItem[] mapFlow$MapItemArray = new MapFlow$MapItem[]{object = MapFlow$MapItem.of(object, object2), object = MapFlow$MapItem.of(object3, object4), object = MapFlow$MapItem.of(object5, object6), object = MapFlow$MapItem.of(object7, object8)};
        return MapCollections.mapOfRaw(mapFlow$MapItemArray);
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        MapFlow$MapItem[] mapFlow$MapItemArray = new MapFlow$MapItem[]{object = MapFlow$MapItem.of(object, object2), object = MapFlow$MapItem.of(object3, object4), object = MapFlow$MapItem.of(object5, object6), object = MapFlow$MapItem.of(object7, object8), object = MapFlow$MapItem.of(object9, object10)};
        return MapCollections.mapOfRaw(mapFlow$MapItemArray);
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12) {
        MapFlow$MapItem[] mapFlow$MapItemArray = new MapFlow$MapItem[]{object = MapFlow$MapItem.of(object, object2), object = MapFlow$MapItem.of(object3, object4), object = MapFlow$MapItem.of(object5, object6), object = MapFlow$MapItem.of(object7, object8), object = MapFlow$MapItem.of(object9, object10), object = MapFlow$MapItem.of(object11, object12)};
        return MapCollections.mapOfRaw(mapFlow$MapItemArray);
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14) {
        MapFlow$MapItem[] mapFlow$MapItemArray = new MapFlow$MapItem[]{object = MapFlow$MapItem.of(object, object2), object = MapFlow$MapItem.of(object3, object4), object = MapFlow$MapItem.of(object5, object6), object = MapFlow$MapItem.of(object7, object8), object = MapFlow$MapItem.of(object9, object10), object = MapFlow$MapItem.of(object11, object12), object = MapFlow$MapItem.of(object13, object14)};
        return MapCollections.mapOfRaw(mapFlow$MapItemArray);
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15, Object object16) {
        MapFlow$MapItem mapFlow$MapItem = MapFlow$MapItem.of(object, object2);
        MapFlow$MapItem[] mapFlow$MapItemArray = new MapFlow$MapItem[]{mapFlow$MapItem, mapFlow$MapItem = MapFlow$MapItem.of(object3, object4), mapFlow$MapItem = MapFlow$MapItem.of(object5, object6), mapFlow$MapItem = MapFlow$MapItem.of(object7, object8), mapFlow$MapItem = MapFlow$MapItem.of(object9, object10), mapFlow$MapItem = MapFlow$MapItem.of(object11, object12), mapFlow$MapItem = MapFlow$MapItem.of(object13, object14), mapFlow$MapItem = MapFlow$MapItem.of(object15, object16)};
        return MapCollections.mapOfRaw(mapFlow$MapItemArray);
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15, Object object16, Object object17, Object object18) {
        MapFlow$MapItem mapFlow$MapItem = MapFlow$MapItem.of(object, object2);
        MapFlow$MapItem[] mapFlow$MapItemArray = new MapFlow$MapItem[]{mapFlow$MapItem, mapFlow$MapItem = MapFlow$MapItem.of(object3, object4), mapFlow$MapItem = MapFlow$MapItem.of(object5, object6), mapFlow$MapItem = MapFlow$MapItem.of(object7, object8), mapFlow$MapItem = MapFlow$MapItem.of(object9, object10), mapFlow$MapItem = MapFlow$MapItem.of(object11, object12), mapFlow$MapItem = MapFlow$MapItem.of(object13, object14), mapFlow$MapItem = MapFlow$MapItem.of(object15, object16), mapFlow$MapItem = MapFlow$MapItem.of(object17, object18)};
        return MapCollections.mapOfRaw(mapFlow$MapItemArray);
    }

    public static Map mapOf(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15, Object object16, Object object17, Object object18, Object object19, Object object20) {
        MapFlow$MapItem mapFlow$MapItem = MapFlow$MapItem.of(object, object2);
        MapFlow$MapItem[] mapFlow$MapItemArray = new MapFlow$MapItem[]{mapFlow$MapItem, mapFlow$MapItem = MapFlow$MapItem.of(object3, object4), mapFlow$MapItem = MapFlow$MapItem.of(object5, object6), mapFlow$MapItem = MapFlow$MapItem.of(object7, object8), mapFlow$MapItem = MapFlow$MapItem.of(object9, object10), mapFlow$MapItem = MapFlow$MapItem.of(object11, object12), mapFlow$MapItem = MapFlow$MapItem.of(object13, object14), mapFlow$MapItem = MapFlow$MapItem.of(object15, object16), mapFlow$MapItem = MapFlow$MapItem.of(object17, object18), mapFlow$MapItem = MapFlow$MapItem.of(object19, object20)};
        return MapCollections.mapOfRaw(mapFlow$MapItemArray);
    }

    private static Map mapOfRaw(MapFlow$MapItem ... mapFlow$MapItemArray) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        for (MapFlow$MapItem mapFlow$MapItem : mapFlow$MapItemArray) {
            Object object = mapFlow$MapItem.key;
            Object object2 = mapFlow$MapItem.value;
            hashMap.put(object, object2);
        }
        return hashMap;
    }

    public static Set setOf(byte ... byArray) {
        int n10;
        int n11 = byArray.length;
        Object[] objectArray = new Byte[n11];
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            n10 = byArray[i10];
            Byte by2 = (byte)n10;
            objectArray[i10] = by2;
        }
        return MapCollections.setOf(objectArray);
    }

    public static Set setOf(char ... cArray) {
        int n10;
        int n11 = cArray.length;
        Object[] objectArray = new Character[n11];
        for (int i10 = 0; i10 < (n10 = cArray.length); ++i10) {
            n10 = cArray[i10];
            Character c10 = Character.valueOf((char)n10);
            objectArray[i10] = c10;
        }
        return MapCollections.setOf(objectArray);
    }

    public static Set setOf(double ... dArray) {
        int n10;
        int n11 = dArray.length;
        Object[] objectArray = new Double[n11];
        for (int i10 = 0; i10 < (n10 = dArray.length); ++i10) {
            double d10 = dArray[i10];
            Double d11 = d10;
            objectArray[i10] = d11;
        }
        return MapCollections.setOf(objectArray);
    }

    public static Set setOf(float ... fArray) {
        int n10;
        int n11 = fArray.length;
        Object[] objectArray = new Float[n11];
        for (int i10 = 0; i10 < (n10 = fArray.length); ++i10) {
            float f10 = fArray[i10];
            Float f11 = Float.valueOf(f10);
            objectArray[i10] = f11;
        }
        return MapCollections.setOf(objectArray);
    }

    public static Set setOf(int ... nArray) {
        int n10;
        int n11 = nArray.length;
        Object[] objectArray = new Integer[n11];
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            n10 = nArray[i10];
            Integer n12 = n10;
            objectArray[i10] = n12;
        }
        return MapCollections.setOf(objectArray);
    }

    public static Set setOf(long ... lArray) {
        int n10;
        int n11 = lArray.length;
        Object[] objectArray = new Long[n11];
        for (int i10 = 0; i10 < (n10 = lArray.length); ++i10) {
            long l10 = lArray[i10];
            Long l11 = l10;
            objectArray[i10] = l11;
        }
        return MapCollections.setOf(objectArray);
    }

    public static Set setOf(Object ... object) {
        object = MapCollections.listOf(object);
        HashSet hashSet = new HashSet(object);
        return hashSet;
    }

    public static Set setOf(short ... sArray) {
        int n10;
        int n11 = sArray.length;
        Object[] objectArray = new Short[n11];
        for (int i10 = 0; i10 < (n10 = sArray.length); ++i10) {
            n10 = sArray[i10];
            Short s10 = (short)n10;
            objectArray[i10] = s10;
        }
        return MapCollections.setOf(objectArray);
    }

    public static Set setOf(boolean ... blArray) {
        int n10;
        int n11 = blArray.length;
        Object[] objectArray = new Boolean[n11];
        for (int i10 = 0; i10 < (n10 = blArray.length); ++i10) {
            n10 = blArray[i10];
            Boolean bl2 = n10 != 0;
            objectArray[i10] = bl2;
        }
        return MapCollections.setOf(objectArray);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.utils;

import cn.leancloud.core.AppConfiguration;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;

public class AVUtils {
    public static final double earthMeanRadiusInKM = 6378.14;

    public static Map createMap(String string2, Object object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(string2, object);
        return hashMap;
    }

    public static Map createStringObjectMap(String string2, Object object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (object != null) {
            hashMap.put(string2, object);
        }
        return hashMap;
    }

    public static double distance(double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = Math.toRadians(d11 - d10);
        d12 = Math.toRadians(d13 - d12);
        d13 = 2.0;
        double d17 = Math.sin(d16 /= d13);
        d16 = Math.sin(d16);
        d17 *= d16;
        d10 = Math.cos(Math.toRadians(d10));
        d11 = Math.cos(Math.toRadians(d11));
        d10 *= d11;
        d11 = Math.sin(d12 /= d13);
        d10 *= d11;
        d11 = Math.sin(d12);
        d10 = Math.sqrt(d17 += (d10 *= d11));
        d11 = Math.sqrt(1.0 - d17);
        d10 = Math.atan2(d10, d11) * d13 * 6378.14 * 1000.0;
        d10 = Math.pow(d10, d13);
        d11 = Math.pow(d14 -= d15, d13);
        return Math.sqrt(d10 + d11);
    }

    public static void ensureElementsNotNull(List object, String string2) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string3 = (String)object.next();
            Objects.requireNonNull(string3, string2);
        }
    }

    public static boolean equals(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    public static JSONObject getJSONObjectFromMap(Map map) {
        return AppConfiguration.getJsonParser().toJSONObject(map);
    }

    public static String getJSONString(Map map) {
        return JSON.toJSONString(map);
    }

    public static List getObjectListFromMapList(List object) {
        ArrayList<JSONObject> arrayList = new ArrayList<JSONObject>();
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                JSONObject jSONObject = AVUtils.getJSONObjectFromMap((Map)object.next());
                arrayList.add(jSONObject);
            }
        }
        return arrayList;
    }

    public static int hash(Object ... objectArray) {
        return Arrays.hashCode(objectArray);
    }

    public static String jsonStringFromMapWithNull(Object object) {
        return JSON.toJSONString(object);
    }

    public static String jsonStringFromObjectWithNull(Object object) {
        return JSON.toJSONString(object);
    }

    public static void mergeConcurrentMap(ConcurrentMap concurrentMap, Map object) {
        if (concurrentMap != null && object != null) {
            boolean bl2;
            object = object.entrySet().iterator();
            while (bl2 = object.hasNext()) {
                Map.Entry entry = (Map.Entry)object.next();
                Object object2 = entry.getKey();
                if (object2 == null || (object2 = entry.getValue()) == null) continue;
                object2 = entry.getKey();
                entry = entry.getValue();
                concurrentMap.put(object2, entry);
            }
        }
    }

    public static double normalize2Double(int n10, Double d10) {
        double d11 = d10;
        BigDecimal bigDecimal = new BigDecimal(d11);
        return AVUtils.normalize2Double(n10, bigDecimal);
    }

    public static double normalize2Double(int n10, BigDecimal bigDecimal) {
        return bigDecimal.setScale(n10, 4).doubleValue();
    }

    public static void putAllWithNullFilter(Map map, Map object) {
        if (map != null && object != null) {
            boolean bl2;
            object = object.entrySet().iterator();
            while (bl2 = object.hasNext()) {
                Map.Entry entry = (Map.Entry)object.next();
                Object object2 = entry.getValue();
                if (object2 == null) continue;
                object2 = entry.getKey();
                entry = entry.getValue();
                map.put(object2, entry);
            }
        }
    }
}


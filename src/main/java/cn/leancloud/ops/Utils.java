/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.AVFile;
import cn.leancloud.AVObject;
import cn.leancloud.AVRelation;
import cn.leancloud.Transformer;
import cn.leancloud.codec.Base64;
import cn.leancloud.json.JSONObject;
import cn.leancloud.types.AVGeoPoint;
import cn.leancloud.utils.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    private static final String typeTag = "__type";

    public static Map createArrayOpMap(String string2, String cloneable, Collection object) {
        boolean bl2;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object2 = "__op";
        hashMap.put((String)object2, cloneable);
        cloneable = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = Utils.getParsedObject(object.next());
            cloneable.add(object2);
        }
        hashMap.put("objects", cloneable);
        cloneable = new HashMap();
        cloneable.put(string2, hashMap);
        return cloneable;
    }

    public static Map createPointerArrayOpMap(String string2, String cloneable, Collection object) {
        boolean bl2;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object2 = "__op";
        hashMap.put((String)object2, cloneable);
        cloneable = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = Utils.mapFromPointerObject((AVObject)object.next());
            cloneable.add(object2);
        }
        hashMap.put("objects", cloneable);
        cloneable = new HashMap();
        cloneable.put(string2, hashMap);
        return cloneable;
    }

    public static byte[] dataFromMap(Map map) {
        return Base64.decode((String)map.get("base64"), 2);
    }

    public static Date dateFromMap(Map map) {
        return StringUtil.dateFromString((String)map.get("iso"));
    }

    public static AVFile fileFromMap(Map map) {
        boolean bl2;
        Object object = "";
        AVFile aVFile = new AVFile((String)object, (String)object);
        aVFile.resetServerData(map);
        object = "metaData";
        map = map.get(object);
        if (map != null && (bl2 = map instanceof Map)) {
            object = aVFile.getMetaData();
            object.putAll(map);
        }
        return aVFile;
    }

    public static AVGeoPoint geoPointFromMap(Map object) {
        double d10 = ((Number)object.get("latitude")).doubleValue();
        double d11 = ((Number)object.get("longitude")).doubleValue();
        object = new AVGeoPoint(d10, d11);
        return object;
    }

    public static Object getObjectFrom(Object object) {
        boolean bl2 = object instanceof Collection;
        if (bl2) {
            return Utils.getObjectFrom((Collection)object);
        }
        bl2 = object instanceof Map;
        if (!bl2 && !(bl2 = object instanceof JSONObject)) {
            return object;
        }
        return Utils.getObjectFrom((Map)object);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static Object getObjectFrom(Map var0) {
        block41: {
            var1_1 = "__type";
            var2_5 /* !! */  = var0.get(var1_1);
            var3_6 = "className";
            if (var2_5 /* !! */  != null && (var4_7 = var2_5 /* !! */  instanceof String)) {
                var0.remove(var1_1);
                var1_1 = "Pointer";
                var5_8 = var2_5 /* !! */ .equals(var1_1);
                if (!var5_8 && !(var5_8 = var2_5 /* !! */ .equals(var1_1 = "Object"))) {
                    var1_1 = "GeoPoint";
                    var5_8 = var2_5 /* !! */ .equals(var1_1);
                    if (var5_8) {
                        return Utils.geoPointFromMap(var0);
                    }
                    var1_1 = "Bytes";
                    var5_8 = var2_5 /* !! */ .equals(var1_1);
                    if (var5_8) {
                        return Utils.dataFromMap((Map)var0);
                    }
                    var1_1 = "Date";
                    var5_8 = var2_5 /* !! */ .equals(var1_1);
                    if (var5_8) {
                        return Utils.dateFromMap(var0);
                    }
                    var1_1 = "Relation";
                    var5_8 = var2_5 /* !! */ .equals(var1_1);
                    if (var5_8) {
                        return Utils.objectFromRelationMap(var0);
                    }
                    var1_1 = "File";
                    var5_8 = var2_5 /* !! */ .equals(var1_1);
                    if (var5_8) {
                        var0 = Utils.fileFromMap(var0);
                    }
                    return var0;
                }
                var1_1 = Transformer.objectFromClassName((String)var0.get(var3_6));
                var0.remove(var3_6);
                var0 = var0.entrySet().iterator();
                while (var6_10 = var0.hasNext()) {
                    var2_5 /* !! */  = (Map.Entry)var0.next();
                    var3_6 = (String)var2_5 /* !! */ .getKey();
                    var4_7 = (var2_5 /* !! */  = var2_5 /* !! */ .getValue()) instanceof String;
                    if (!(var4_7 || (var4_7 = var2_5 /* !! */  instanceof Number) || (var4_7 = var2_5 /* !! */  instanceof Boolean) || (var4_7 = var2_5 /* !! */  instanceof Byte) || (var4_7 = var2_5 /* !! */  instanceof Character))) {
                        var4_7 = var2_5 /* !! */  instanceof Map;
                        if (!var4_7 && !(var4_7 = var2_5 /* !! */  instanceof JSONObject)) {
                            var4_7 = var2_5 /* !! */  instanceof Collection;
                            if (var4_7) {
                                var7_12 = var1_1.getServerData();
                                var2_5 /* !! */  = Utils.getObjectFrom(var2_5 /* !! */ );
                                var7_12.put(var3_6, var2_5 /* !! */ );
                                continue;
                            }
                            if (var2_5 /* !! */  == null) continue;
                            var7_12 = var1_1.getServerData();
                            var7_12.put(var3_6, var2_5 /* !! */ );
                            continue;
                        }
                        var7_12 = var1_1.getServerData();
                        var2_5 /* !! */  = Utils.getObjectFrom(var2_5 /* !! */ );
                        var7_12.put(var3_6, var2_5 /* !! */ );
                        continue;
                    }
                    var7_12 = var1_1.getServerData();
                    var7_12.put(var3_6, var2_5 /* !! */ );
                }
                return var1_1;
            }
            var5_9 = var0.containsKey(var3_6);
            var2_5 /* !! */  = "@type";
            if (var5_9 && (var4_7 = var0.containsKey(var1_1 = "serverData"))) {
                var4_7 = var0.containsKey(var3_6);
                var2_5 /* !! */  = var4_7 != false ? var0.get(var3_6) : var0.get(var2_5 /* !! */ );
                var2_5 /* !! */  = Transformer.objectFromClassName((String)var2_5 /* !! */ );
                var5_9 = (var0 = (Map)var0.get(var1_1)).containsKey(var3_6);
                if (var5_9) {
                    var0.remove(var3_6);
                }
                var1_1 = new HashMap();
                var0 = var0.entrySet().iterator();
                while (var8_15 = var0.hasNext()) {
                    var3_6 = var0.next();
                    var7_13 = (String)var3_6.getKey();
                    var9_17 = (var3_6 = var3_6.getValue()) instanceof String;
                    if (!(var9_17 || (var9_17 = var3_6 instanceof Number) || (var9_17 = var3_6 instanceof Boolean) || (var9_17 = var3_6 instanceof Byte) || (var9_17 = var3_6 instanceof Character))) {
                        var9_17 = var3_6 instanceof Map;
                        if (!var9_17 && !(var9_17 = var3_6 instanceof JSONObject)) {
                            var9_17 = var3_6 instanceof Collection;
                            if (var9_17) {
                                var3_6 = Utils.getObjectFrom(var3_6);
                                var1_1.put(var7_13, var3_6);
                                continue;
                            }
                            if (var3_6 == null) continue;
                            var1_1.put(var7_13, var3_6);
                            continue;
                        }
                        var3_6 = Utils.getObjectFrom(var3_6);
                        var1_1.put(var7_13, var3_6);
                        continue;
                    }
                    var1_1.put(var7_13, var3_6);
                }
                var2_5 /* !! */ .resetServerData((Map)var1_1);
                return var2_5 /* !! */ ;
            }
            var5_9 = var0.containsKey(var2_5 /* !! */ );
            if (!var5_9 || !(var5_9 = (var1_1 = var0.get(var2_5 /* !! */ )) instanceof String) || (var1_1 = (String)var0.get(var2_5 /* !! */ )) == null || !(var8_16 = var1_1.startsWith((String)(var3_6 = "cn.leancloud.")))) break block41;
            var1_1 = Class.forName((String)var1_1);
            var1_1 = var1_1.newInstance();
            var1_1 = (AVObject)var1_1;
            var0.remove(var2_5 /* !! */ );
            var2_5 /* !! */  = new HashMap();
            var3_6 = var0.entrySet();
            var3_6 = var3_6.iterator();
            while (true) {
                block42: {
                    var4_7 = var3_6.hasNext();
                    if (!var4_7) break;
                    var7_14 /* !! */  = var3_6.next();
                    var7_14 /* !! */  = (Map.Entry)var7_14 /* !! */ ;
                    var10_18 /* !! */  = var7_14 /* !! */ .getKey();
                    var10_18 /* !! */  = (String)var10_18 /* !! */ ;
                    var7_14 /* !! */  = var7_14 /* !! */ .getValue();
                    var11_19 = var7_14 /* !! */  instanceof String;
                    if (var11_19 || (var11_19 = var7_14 /* !! */  instanceof Number) || (var11_19 = var7_14 /* !! */  instanceof Boolean) || (var11_19 = var7_14 /* !! */  instanceof Byte) || (var11_19 = var7_14 /* !! */  instanceof Character)) break block42;
                    var11_19 = var7_14 /* !! */  instanceof Map;
                    if (var11_19 || (var11_19 = var7_14 /* !! */  instanceof JSONObject)) ** GOTO lbl149
                    var11_19 = var7_14 /* !! */  instanceof Collection;
                    if (var11_19) {
                        var7_14 /* !! */  = Utils.getObjectFrom(var7_14 /* !! */ );
                        var2_5 /* !! */ .put(var10_18 /* !! */ , var7_14 /* !! */ );
                        continue;
                    }
                    if (var7_14 /* !! */  == null) continue;
                    var2_5 /* !! */ .put(var10_18 /* !! */ , var7_14 /* !! */ );
                    continue;
lbl149:
                    // 1 sources

                    var7_14 /* !! */  = Utils.getObjectFrom(var7_14 /* !! */ );
                    var2_5 /* !! */ .put(var10_18 /* !! */ , var7_14 /* !! */ );
                    continue;
                }
                var2_5 /* !! */ .put(var10_18 /* !! */ , var7_14 /* !! */ );
                continue;
                break;
            }
            try {
                var1_1.resetServerData((Map)var2_5 /* !! */ );
                return var1_1;
            }
            catch (InstantiationException var1_2) {
                var1_2.printStackTrace();
            }
            catch (IllegalAccessException var1_3) {
                var1_3.printStackTrace();
            }
            catch (ClassNotFoundException var1_4) {
                var1_4.printStackTrace();
            }
        }
        var6_11 = var0.size();
        var1_1 = new HashMap(var6_11);
        var0 = var0.entrySet().iterator();
        while ((var6_11 = (int)var0.hasNext()) != 0) {
            var2_5 /* !! */  = var0.next();
            var3_6 = (String)var2_5 /* !! */ .getKey();
            var2_5 /* !! */  = Utils.getObjectFrom(var2_5 /* !! */ .getValue());
            var1_1.put(var3_6, var2_5 /* !! */ );
        }
        return var1_1;
    }

    public static List getObjectFrom(Collection object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = Utils.getObjectFrom(object.next());
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static List getParsedList(Collection object) {
        int n10 = object.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = Utils.getParsedObject(object.next());
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static List getParsedList(Collection object, boolean bl2) {
        if (!bl2) {
            return Utils.getParsedList((Collection)object);
        }
        int n10 = object.size();
        ArrayList arrayList = new ArrayList(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = object.next();
            boolean bl3 = true;
            object2 = Utils.getParsedObject(object2, bl3);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static Map getParsedMap(Map map) {
        return Utils.getParsedMap(map, false);
    }

    public static Map getParsedMap(Map object, boolean bl2) {
        int n10 = object.size();
        HashMap<String, Object> hashMap = new HashMap<String, Object>(n10);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = Utils.getParsedObject(object2.getValue(), bl2);
            hashMap.put(string2, object2);
        }
        return hashMap;
    }

    public static Object getParsedObject(Object object) {
        return Utils.getParsedObject(object, false);
    }

    public static Object getParsedObject(Object object, boolean bl2) {
        if (object == null) {
            return null;
        }
        boolean bl3 = object instanceof Map;
        if (bl3) {
            return Utils.getParsedMap((Map)object, bl2);
        }
        bl3 = object instanceof Collection;
        if (bl3) {
            return Utils.getParsedList((Collection)object, bl2);
        }
        bl3 = object instanceof AVObject;
        if (bl3) {
            if (!bl2) {
                return Utils.mapFromPointerObject((AVObject)object);
            }
            return Utils.mapFromAVObject((AVObject)object, true);
        }
        bl2 = object instanceof AVGeoPoint;
        if (bl2) {
            return Utils.mapFromGeoPoint((AVGeoPoint)object);
        }
        bl2 = object instanceof Date;
        if (bl2) {
            return Utils.mapFromDate((Date)object);
        }
        bl2 = object instanceof byte[];
        if (bl2) {
            return Utils.mapFromByteArray((byte[])object);
        }
        bl2 = object instanceof AVFile;
        if (bl2) {
            object = Utils.mapFromFile((AVFile)object);
        }
        return object;
    }

    public static Map makeCompletedRequest(String hashMap, String string2, String string3, Map map) {
        boolean bl2;
        if (map != null && !(bl2 = StringUtil.isEmpty(string2)) && !(bl2 = StringUtil.isEmpty(string3))) {
            map.put("__internalId", hashMap);
            hashMap = new HashMap<String, Map>();
            hashMap.put("body", map);
            hashMap.put("path", (Map)((Object)string2));
            hashMap.put("method", (Map)((Object)string3));
            return hashMap;
        }
        return null;
    }

    public static Map mapFromAVObject(AVObject object, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string2 = ((AVObject)object).internalClassName();
        String string3 = "className";
        hashMap.put(string3, string2);
        string2 = ((AVObject)object).getObjectId();
        boolean bl3 = StringUtil.isEmpty(string2);
        if (!bl3) {
            string2 = ((AVObject)object).getObjectId();
            string3 = "objectId";
            hashMap.put(string3, string2);
        }
        string2 = typeTag;
        if (!bl2) {
            object = "Pointer";
            hashMap.put(string2, object);
        } else {
            hashMap.put(string2, "Object");
            object = ((AVObject)object).getServerData();
            bl2 = false;
            object = Utils.getParsedMap((Map)object, false);
            if (object != null && !(bl2 = object.isEmpty())) {
                hashMap.putAll((Map<String, Object>)object);
            }
        }
        return hashMap;
    }

    public static Map mapFromByteArray(byte[] object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(typeTag, "Bytes");
        object = Base64.encodeToString(object, 2);
        hashMap.put("base64", object);
        return hashMap;
    }

    public static Map mapFromDate(Date object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(typeTag, "Date");
        object = StringUtil.stringFromDate((Date)object);
        hashMap.put("iso", object);
        return hashMap;
    }

    public static Map mapFromFile(AVFile object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(typeTag, "_File");
        Map map = ((AVFile)object).getMetaData();
        hashMap.put("metaData", map);
        object = ((AVFile)object).getName();
        hashMap.put("id", object);
        return hashMap;
    }

    public static Map mapFromGeoPoint(AVGeoPoint object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(typeTag, "GeoPoint");
        Double d10 = ((AVGeoPoint)object).getLatitude();
        hashMap.put("latitude", d10);
        object = ((AVGeoPoint)object).getLongitude();
        hashMap.put("longitude", object);
        return hashMap;
    }

    public static Map mapFromPointerObject(AVObject aVObject) {
        return Utils.mapFromAVObject(aVObject, false);
    }

    public static AVRelation objectFromRelationMap(Map object) {
        object = (String)object.get("className");
        AVRelation aVRelation = new AVRelation((String)object);
        return aVRelation;
    }

    public static AVObject parseObjectFromMap(Map map) {
        AVObject aVObject = Transformer.objectFromClassName((String)map.get("className"));
        map.remove(typeTag);
        aVObject.resetServerData(map);
        return aVObject;
    }
}


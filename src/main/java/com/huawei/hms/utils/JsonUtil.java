/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.JsonUtil$1;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    private static final String BYTE_BYTE = "_byte_";
    private static final String LIST_FIELD_VALUE = "_value_";
    private static final String LIST_ITEM_VALUE = "_list_item_";
    private static final String LIST_SIZE = "_list_size_";
    private static final String MAP_MAP = "_map_";
    private static final String NEXT_ITEM = "_next_item_";
    private static final String PRE_PKG = "com.huawei";
    private static final String TAG = "JsonUtil";
    public static final int VAL_BYTE = 2;
    public static final int VAL_ENTITY = 0;
    public static final int VAL_LIST = 1;
    public static final int VAL_MAP = 3;
    public static final int VAL_NULL = 255;
    public static final String VAL_TYPE = "_val_type_";

    private static String createInnerJsonString(IMessageEntity iMessageEntity) {
        JSONObject jSONObject = new JSONObject();
        for (Class<?> clazz = iMessageEntity.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            for (Field field : clazz.getDeclaredFields()) {
                Class<Packed> clazz2 = Packed.class;
                boolean bl2 = field.isAnnotationPresent(clazz2);
                if (!bl2) continue;
                bl2 = field.isAccessible();
                boolean bl3 = true;
                JsonUtil.setAccessible(field, bl3);
                String string2 = field.getName();
                Object object = field.get(iMessageEntity);
                JsonUtil.setAccessible(field, bl2);
                JsonUtil.disposeType(string2, object, jSONObject);
            }
        }
        return jSONObject.toString();
    }

    public static String createJsonString(IMessageEntity iMessageEntity) {
        String string2 = "";
        String string3 = TAG;
        if (iMessageEntity == null) {
            HMSLog.e(string3, "createJsonString error, the input IMessageEntity is null");
            return string2;
        }
        try {
            return JsonUtil.createInnerJsonString(iMessageEntity);
        }
        catch (JSONException jSONException) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "catch JSONException ";
            stringBuilder.append(string4);
            String string5 = jSONException.getMessage();
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            HMSLog.e(string3, string5);
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            String string6 = "catch IllegalAccessException ";
            stringBuilder.append(string6);
            String string7 = illegalAccessException.getMessage();
            stringBuilder.append(string7);
            string7 = stringBuilder.toString();
            HMSLog.e(string3, string7);
        }
        return string2;
    }

    private static boolean disposeType(String string2, Object object, JSONObject object2) {
        block18: {
            block7: {
                boolean bl2;
                block17: {
                    block16: {
                        block15: {
                            block14: {
                                block13: {
                                    block12: {
                                        block11: {
                                            block10: {
                                                block9: {
                                                    block8: {
                                                        block6: {
                                                            bl2 = object instanceof String;
                                                            if (!bl2) break block6;
                                                            object = (String)object;
                                                            object2.put(string2, object);
                                                            break block7;
                                                        }
                                                        bl2 = object instanceof Integer;
                                                        if (!bl2) break block8;
                                                        object = (Integer)object;
                                                        int n10 = (Integer)object;
                                                        object2.put(string2, n10);
                                                        break block7;
                                                    }
                                                    bl2 = object instanceof Short;
                                                    if (!bl2) break block9;
                                                    object = (Short)object;
                                                    object2.put(string2, object);
                                                    break block7;
                                                }
                                                bl2 = object instanceof Long;
                                                if (!bl2) break block10;
                                                object = (Long)object;
                                                object2.put(string2, object);
                                                break block7;
                                            }
                                            bl2 = object instanceof Float;
                                            if (!bl2) break block11;
                                            object = (Float)object;
                                            object2.put(string2, object);
                                            break block7;
                                        }
                                        bl2 = object instanceof Double;
                                        if (!bl2) break block12;
                                        object = (Double)object;
                                        object2.put(string2, object);
                                        break block7;
                                    }
                                    bl2 = object instanceof Boolean;
                                    if (!bl2) break block13;
                                    object = (Boolean)object;
                                    object2.put(string2, object);
                                    break block7;
                                }
                                bl2 = object instanceof JSONObject;
                                if (!bl2) break block14;
                                object = (JSONObject)object;
                                object2.put(string2, object);
                                break block7;
                            }
                            bl2 = object instanceof byte[];
                            if (!bl2) break block15;
                            object = (byte[])object;
                            JsonUtil.writeByte(string2, (byte[])object, object2);
                            break block7;
                        }
                        bl2 = object instanceof List;
                        if (!bl2) break block16;
                        object = (List)object;
                        JsonUtil.writeList(string2, (List)object, object2);
                        break block7;
                    }
                    bl2 = object instanceof Map;
                    if (!bl2) break block17;
                    object = (Map)object;
                    JsonUtil.writeMap(string2, (Map)object, object2);
                    break block7;
                }
                bl2 = object instanceof IMessageEntity;
                if (!bl2) break block18;
                object = (IMessageEntity)object;
                object = JsonUtil.createInnerJsonString((IMessageEntity)object);
                try {
                    object2.put(string2, object);
                }
                catch (IllegalAccessException illegalAccessException) {
                    object = new StringBuilder();
                    object2 = "IllegalAccessException , ";
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(illegalAccessException);
                    String string3 = ((StringBuilder)object).toString();
                    object = TAG;
                    HMSLog.e((String)object, string3);
                }
            }
            return true;
        }
        return false;
    }

    public static Object getInfoFromJsonobject(String object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            Object object2;
            block7: {
                object2 = new JSONObject((String)object);
                boolean bl3 = object2.has(string2);
                if (bl3) break block7;
                return null;
            }
            try {
                object = object2.get(string2);
            }
            catch (JSONException jSONException) {
                object = new StringBuilder();
                object2 = "getInfoFromJsonobject:parser json error :";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                string2 = TAG;
                HMSLog.e(string2, (String)object);
            }
            boolean bl4 = object instanceof String;
            if (bl4) {
                return object;
            }
        }
        return null;
    }

    public static int getIntValue(JSONObject jSONObject, String string2) {
        boolean bl2;
        int n10 = jSONObject != null && (bl2 = jSONObject.has(string2)) ? jSONObject.getInt(string2) : -1;
        return n10;
    }

    private static Object getObjectValue(String string2, JSONObject jSONObject) {
        JSONObject jSONObject2;
        boolean bl2 = jSONObject.has(string2);
        if (bl2) {
            return jSONObject.get(string2);
        }
        String string3 = "header";
        boolean bl3 = jSONObject.has(string3);
        if (bl3 && (bl3 = (jSONObject2 = jSONObject.getJSONObject(string3)).has(string2))) {
            return jSONObject.getJSONObject(string3).get(string2);
        }
        string3 = "body";
        bl3 = jSONObject.has(string3);
        if (bl3 && (bl3 = (jSONObject2 = jSONObject.getJSONObject(string3)).has(string2))) {
            return jSONObject.getJSONObject(string3).get(string2);
        }
        return null;
    }

    public static String getStringValue(JSONObject object, String string2) {
        boolean bl2;
        object = object != null && (bl2 = object.has(string2)) ? object.getString(string2) : null;
        return object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static IMessageEntity jsonToEntity(String var0, IMessageEntity var1_3) {
        var2_4 = "JsonUtil";
        ** try [egrp 0[TRYBLOCK] [0 : 3->7)] { 
lbl4:
        // 2 sources

        var4_6 /* !! */  = new JSONObject((String)var0);
        for (var3_5 = var1_3.getClass(); var3_5 != null; var3_5 = var3_5.getSuperclass()) {
            var0 = var3_5.getDeclaredFields();
            var5_7 = var0.length;
            for (var6_8 = 0; var6_8 < var5_7; ++var6_8) {
                var7_9 = var0[var6_8];
                var8_10 = Packed.class;
                var9_11 = var7_9.isAnnotationPresent((Class<? extends Annotation>)var8_10);
                if (!var9_11) continue;
                try {
                    JsonUtil.readFiled(var1_3, (Field)var7_9, var4_6 /* !! */ );
                    continue;
                }
                catch (IllegalAccessException v0) {
                    var8_10 = new StringBuilder();
                    var10_12 = "jsonToEntity, set value of the field exception, field name:";
                    var8_10.append(var10_12);
                    var7_9 = var7_9.getName();
                    var8_10.append((String)var7_9);
                    var7_9 = var8_10.toString();
                    HMSLog.e(var2_4, (String)var7_9);
                }
            }
            continue;
lbl-1000:
            // 12 sources

            {
                catch (JSONException var0_1) {
                    var3_5 = new StringBuilder();
                    var4_6 /* !! */  = "catch JSONException when parse jsonString";
                    var3_5.append((String)var4_6 /* !! */ );
                    var0_2 = var0_1.getMessage();
                    var3_5.append(var0_2);
                    var0_2 = var3_5.toString();
                    HMSLog.e(var2_4, var0_2);
                    break;
                }
            }
        }
        return var1_3;
    }

    private static byte[] readByte(JSONObject object) {
        CharSequence charSequence = BYTE_BYTE;
        try {
            object = object.getString((String)charSequence);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("readByte failed : ");
            String string2 = illegalArgumentException.getMessage();
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            HMSLog.e(TAG, string2);
            return null;
        }
        return Base64.decode((String)object);
    }

    private static void readFiled(IMessageEntity iMessageEntity, Field field, JSONObject object) {
        if ((object = JsonUtil.readJson(iMessageEntity, field, object)) != null) {
            boolean bl2 = field.isAccessible();
            boolean bl3 = true;
            JsonUtil.setAccessible(field, bl3);
            field.set(iMessageEntity, object);
            JsonUtil.setAccessible(field, bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object readJson(IMessageEntity object, Field object2, JSONObject object3) {
        Class<?> clazz;
        Object obj;
        object = VAL_TYPE;
        String string2 = TAG;
        Object object4 = JsonUtil.getObjectValue(((Field)object2).getName(), object3);
        if (object4 == null) return null;
        Class<?> clazz2 = ((Field)object2).getType();
        String string3 = clazz2.getName();
        String string4 = PRE_PKG;
        int n10 = string3.startsWith(string4);
        if (n10 != 0 && (n10 = (obj = (clazz = ((Field)object2).getType()).newInstance()) instanceof IMessageEntity) != 0) {
            String string5 = (String)object4;
            object = ((Field)object2).getType();
            object = ((Class)object).newInstance();
            object = (IMessageEntity)object;
            return JsonUtil.jsonToEntity(string5, (IMessageEntity)object);
        }
        n10 = object4 instanceof JSONObject;
        if (n10 == 0) return object4;
        Object object5 = object4;
        try {
            JSONObject jSONObject = (JSONObject)object4;
            n10 = jSONObject.has((String)object);
            if (n10 == 0) return object4;
            Object object6 = object4;
            JSONObject jSONObject2 = (JSONObject)object4;
            int n11 = jSONObject2.getInt((String)object);
            if (n11 != (n10 = 1) && n11 != 0) {
                n10 = 2;
                if (n11 == n10) {
                    JSONObject jSONObject3 = (JSONObject)object4;
                    return JsonUtil.readByte(jSONObject3);
                }
                n10 = 3;
                if (n11 == n10) {
                    object = ((Field)object2).getGenericType();
                    JSONObject jSONObject4 = (JSONObject)object4;
                    return JsonUtil.readMap((Type)object, jSONObject4);
                }
                object2 = new StringBuilder();
                String string6 = "cannot support type : ";
                ((StringBuilder)object2).append(string6);
                ((StringBuilder)object2).append(n11);
                object = ((StringBuilder)object2).toString();
                HMSLog.e(string2, (String)object);
                return null;
            }
            object = ((Field)object2).getGenericType();
            JSONObject jSONObject5 = (JSONObject)object4;
            return JsonUtil.readList((Type)object, jSONObject5);
        }
        catch (InstantiationException instantiationException) {
            object = "InstantiationException  ";
            HMSLog.e(string2, (String)object);
        }
        return null;
    }

    private static List readList(Type type, JSONObject jSONObject) {
        String string2 = LIST_SIZE;
        int n10 = jSONObject.getInt(string2);
        String string3 = VAL_TYPE;
        int n11 = jSONObject.getInt(string3);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = new StringBuilder();
            Object object2 = LIST_ITEM_VALUE;
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(i10);
            object = ((StringBuilder)object).toString();
            object = jSONObject.get((String)object);
            if (n11 == 0) {
                object2 = type;
                object2 = ((Class)((ParameterizedType)type).getActualTypeArguments()[0]).newInstance();
                object = (String)object;
                object2 = (IMessageEntity)object2;
                object = JsonUtil.jsonToEntity((String)object, (IMessageEntity)object2);
                arrayList.add(object);
                continue;
            }
            int n12 = 1;
            if (n11 != n12) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    private static Map readMap(Type object, JSONObject object2) {
        int n10;
        object = ((ParameterizedType)object).getActualTypeArguments();
        int n11 = 1;
        object = (Class)object[n11];
        object2 = object2.getString(MAP_MAP);
        JSONArray jSONArray = new JSONArray((String)object2);
        object2 = new HashMap();
        for (int i10 = 0; i10 < (n10 = jSONArray.length()); i10 += 2) {
            Object object3;
            Object object4 = ((Class)object).newInstance();
            n10 = object4 instanceof IMessageEntity;
            if (n10 != 0) {
                n10 = i10 + 1;
                object4 = jSONArray.getString(n10);
                object3 = (IMessageEntity)((Class)object).newInstance();
                object4 = JsonUtil.jsonToEntity(object4, (IMessageEntity)object3);
                object3 = jSONArray.get(i10);
                object2.put(object3, object4);
                continue;
            }
            object4 = jSONArray.get(i10);
            int n12 = i10 + 1;
            object3 = jSONArray.get(n12);
            object2.put(object4, object3);
        }
        return object2;
    }

    private static void setAccessible(Field field, boolean bl2) {
        JsonUtil$1 jsonUtil$1 = new JsonUtil$1(field, bl2);
        AccessController.doPrivileged(jsonUtil$1);
    }

    private static void writeByte(String string2, byte[] object, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        int n10 = 2;
        jSONObject2.put(VAL_TYPE, n10);
        CharSequence charSequence = BYTE_BYTE;
        object = Base64.encode(object);
        try {
            jSONObject2.put((String)charSequence, object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            charSequence = new StringBuilder();
            String string3 = "writeByte failed : ";
            ((StringBuilder)charSequence).append(string3);
            String string4 = illegalArgumentException.getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            charSequence = TAG;
            HMSLog.e((String)charSequence, string4);
        }
        jSONObject.put(string2, (Object)jSONObject2);
    }

    private static void writeList(String string2, List list, JSONObject jSONObject) {
        int n10;
        JSONObject jSONObject2 = new JSONObject();
        String string3 = VAL_TYPE;
        jSONObject2.put(string3, 1);
        int n11 = list.size();
        jSONObject2.put(LIST_SIZE, n11);
        n11 = 0;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append(LIST_ITEM_VALUE);
            charSequence.append(i10);
            charSequence = charSequence.toString();
            Object e10 = list.get(i10);
            JsonUtil.disposeType((String)charSequence, e10, jSONObject2);
            charSequence = list.get(i10);
            n10 = charSequence instanceof IMessageEntity;
            if (n10 == 0) continue;
            jSONObject2.put(string3, 0);
        }
        jSONObject.put(string2, (Object)jSONObject2);
    }

    private static void writeMap(String string2, Map object, JSONObject jSONObject) {
        boolean bl2;
        object = object.entrySet().iterator();
        Object object2 = new JSONArray();
        while (bl2 = object.hasNext()) {
            Object object3 = (Map.Entry)object.next();
            Object object4 = object3.getKey();
            object3 = object3.getValue();
            boolean bl3 = object4 instanceof IMessageEntity;
            if (bl3) {
                object4 = JsonUtil.createInnerJsonString((IMessageEntity)object4);
                object2.put(object4);
            } else {
                object2.put(object4);
            }
            boolean bl4 = object3 instanceof IMessageEntity;
            if (bl4) {
                object3 = JsonUtil.createInnerJsonString((IMessageEntity)object3);
                object2.put(object3);
                continue;
            }
            object2.put(object3);
        }
        object = new JSONObject();
        object.put(VAL_TYPE, 3);
        object2 = object2.toString();
        object.put(MAP_MAP, object2);
        jSONObject.put(string2, object);
    }
}


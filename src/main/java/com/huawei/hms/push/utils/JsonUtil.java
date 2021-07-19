/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    public static void a(JSONObject stringArray, String string2, Object stringArray2, Bundle bundle) {
        String string3 = "JsonUtil";
        if (stringArray2 == null) {
            HMSLog.w(string3, "transfer jsonObject to bundle failed, defaultValue is null.");
            return;
        }
        boolean bl2 = stringArray2 instanceof String;
        String[] stringArray3 = null;
        if (bl2) {
            boolean bl3 = TextUtils.isEmpty((CharSequence)(stringArray2 = (String)stringArray2));
            if (!bl3) {
                stringArray3 = stringArray2;
            }
            stringArray = JsonUtil.getString((JSONObject)stringArray, string2, (String)stringArray3);
            bundle.putString(string2, (String)stringArray);
        } else {
            bl2 = stringArray2 instanceof Integer;
            if (bl2) {
                stringArray2 = (Integer)stringArray2;
                int n10 = stringArray2.intValue();
                int n11 = JsonUtil.getInt((JSONObject)stringArray, string2, n10);
                bundle.putInt(string2, n11);
            } else {
                bl2 = stringArray2 instanceof int[];
                if (bl2) {
                    int n12 = (stringArray2 = (String[])((int[])stringArray2)).length;
                    if (n12 != 0) {
                        stringArray3 = stringArray2;
                    }
                    stringArray = (String[])JsonUtil.getIntArray((JSONObject)stringArray, string2, (int[])stringArray3);
                    bundle.putIntArray(string2, (int[])stringArray);
                } else {
                    bl2 = stringArray2 instanceof long[];
                    if (bl2) {
                        int n13 = (stringArray2 = (String[])((long[])stringArray2)).length;
                        if (n13 != 0) {
                            stringArray3 = stringArray2;
                        }
                        stringArray = (String[])JsonUtil.getLongArray((JSONObject)stringArray, string2, (long[])stringArray3);
                        bundle.putLongArray(string2, (long[])stringArray);
                    } else {
                        bl2 = stringArray2 instanceof String[];
                        if (bl2) {
                            int n14 = (stringArray2 = (String[])stringArray2).length;
                            if (n14 != 0) {
                                stringArray3 = stringArray2;
                            }
                            stringArray = JsonUtil.getStringArray((JSONObject)stringArray, string2, stringArray3);
                            bundle.putStringArray(string2, stringArray);
                        } else {
                            stringArray = "transfer jsonObject to bundle failed, invalid data type.";
                            HMSLog.w(string3, (String)stringArray);
                        }
                    }
                }
            }
        }
    }

    public static int getInt(JSONObject object, String string2, int n10) {
        block4: {
            if (object != null) {
                boolean bl2 = object.has(string2);
                if (!bl2) break block4;
                try {
                    n10 = object.getInt(string2);
                }
                catch (JSONException jSONException) {
                    object = new StringBuilder();
                    String string3 = "JSONException: get ";
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(" error.");
                    object = ((StringBuilder)object).toString();
                    string2 = "JsonUtil";
                    HMSLog.w(string2, (String)object);
                }
            }
        }
        return n10;
    }

    public static int[] getIntArray(JSONObject object, String string2, int[] nArray) {
        int[] nArray2;
        block13: {
            nArray2 = null;
            if (object != null) {
                String string3;
                int n10 = object.has(string2);
                if (n10 == 0) break block13;
                object = object.getJSONArray(string2);
                n10 = object.length();
                try {
                    nArray2 = new int[n10];
                    n10 = 0;
                    string3 = null;
                }
                catch (JSONException jSONException) {
                    object = new StringBuilder();
                    string3 = "JSONException: get ";
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(" error.");
                    object = ((StringBuilder)object).toString();
                    string2 = "JsonUtil";
                    HMSLog.w(string2, (String)object);
                }
                while (true) {
                    int n11 = object.length();
                    if (n10 >= n11) break;
                    Object object2 = object.get(n10);
                    object2 = (Integer)object2;
                    n11 = (Integer)object2;
                    nArray2[n10] = n11;
                    ++n10;
                    continue;
                    break;
                }
            }
        }
        if (nArray2 != null) {
            nArray = nArray2;
        }
        return nArray;
    }

    public static JSONArray getIntJsonArray(int[] nArray) {
        int n10;
        JSONArray jSONArray = new JSONArray();
        if (nArray != null && (n10 = nArray.length) != 0) {
            for (int n11 : nArray) {
                jSONArray.put(n11);
            }
        }
        return jSONArray;
    }

    public static long[] getLongArray(JSONObject object, String string2, long[] lArray) {
        long[] lArray2;
        block11: {
            lArray2 = null;
            if (object != null) {
                String string3;
                int n10 = object.has(string2);
                if (n10 == 0) break block11;
                object = object.getJSONArray(string2);
                n10 = object.length();
                try {
                    lArray2 = new long[n10];
                    n10 = 0;
                    string3 = null;
                }
                catch (JSONException jSONException) {
                    object = new StringBuilder();
                    string3 = "JSONException: get ";
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(" error.");
                    object = ((StringBuilder)object).toString();
                    string2 = "JsonUtil";
                    HMSLog.w(string2, (String)object);
                }
                while (true) {
                    int n11 = object.length();
                    if (n10 >= n11) break;
                    long l10 = object.getLong(n10);
                    lArray2[n10] = l10;
                    ++n10;
                    continue;
                    break;
                }
            }
        }
        if (lArray2 != null) {
            lArray = lArray2;
        }
        return lArray;
    }

    public static JSONArray getLongJsonArray(long[] lArray) {
        int n10;
        JSONArray jSONArray = new JSONArray();
        if (lArray != null && (n10 = lArray.length) != 0) {
            for (long l10 : lArray) {
                jSONArray.put(l10);
            }
        }
        return jSONArray;
    }

    public static String getString(JSONObject object, String string2, String string3) {
        block6: {
            if (object != null) {
                boolean bl2 = object.has(string2);
                if (!bl2) break block6;
                Object object2 = object.get(string2);
                if (object2 == null) break block6;
                object = object.get(string2);
                try {
                    string3 = String.valueOf(object);
                }
                catch (JSONException jSONException) {
                    object = new StringBuilder();
                    object2 = "JSONException: get ";
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(" error.");
                    object = ((StringBuilder)object).toString();
                    string2 = "JsonUtil";
                    HMSLog.w(string2, (String)object);
                }
            }
        }
        return string3;
    }

    public static String[] getStringArray(JSONObject object, String string2, String[] stringArray) {
        block11: {
            stringArray = null;
            if (object != null) {
                String string3;
                int n10 = object.has(string2);
                if (n10 == 0) break block11;
                object = object.getJSONArray(string2);
                n10 = object.length();
                try {
                    stringArray = new String[n10];
                    n10 = 0;
                    string3 = null;
                }
                catch (JSONException jSONException) {
                    object = new StringBuilder();
                    string3 = "JSONException: get ";
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(" error.");
                    object = ((StringBuilder)object).toString();
                    string2 = "JsonUtil";
                    HMSLog.w(string2, (String)object);
                }
                while (true) {
                    int n11 = object.length();
                    if (n10 >= n11) break;
                    Object object2 = object.get(n10);
                    object2 = (String)object2;
                    stringArray[n10] = object2;
                    ++n10;
                    continue;
                    break;
                }
            }
        }
        return stringArray;
    }

    public static JSONArray getStringJsonArray(String[] stringArray) {
        int n10;
        JSONArray jSONArray = new JSONArray();
        if (stringArray != null && (n10 = stringArray.length) != 0) {
            for (String string2 : stringArray) {
                jSONArray.put((Object)string2);
            }
        }
        return jSONArray;
    }

    public static void transferJsonObjectToBundle(JSONObject jSONObject, Bundle bundle, HashMap object) {
        boolean bl2;
        object = ((HashMap)object).entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            String string2 = (String)entry.getKey();
            entry = entry.getValue();
            JsonUtil.a(jSONObject, string2, entry, bundle);
        }
    }
}


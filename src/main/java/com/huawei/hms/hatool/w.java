/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.g0;
import com.huawei.hms.hatool.q;
import com.huawei.hms.hatool.s0;
import com.huawei.hms.hatool.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class w {
    public static Map a(Context object, String string2) {
        if (object == null) {
            return null;
        }
        object = g0.a(object, string2);
        w.b((Map)object);
        return w.a((Map)object);
    }

    public static Map a(Context object, String string2, String object2) {
        String string3 = "alltype";
        boolean bl2 = string3.equals(object2);
        String string4 = "cached_v2_1";
        String string5 = "stat_v2_1";
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            string2 = s0.a(string2, (String)object2);
            object2 = w.b(object, string5, string2);
            object = w.b(object, string4, string2);
        } else {
            string2 = "hmsSdk";
            y.c(string2, "read all event records");
            object2 = w.a(object, string5);
            object = w.a(object, string4);
        }
        return w.a((Map)object2, (Map)object);
    }

    public static Map a(Map object) {
        boolean bl2;
        HashMap hashMap = new HashMap();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            Object v10 = object2.getValue();
            boolean bl3 = v10 instanceof String;
            if (!bl3) continue;
            object2 = (String)object2.getValue();
            w.a(string2, (String)object2, hashMap);
        }
        return hashMap;
    }

    public static Map a(Map object, Map map) {
        boolean bl2;
        int n10 = object.size();
        if (n10 == 0 && (n10 = map.size()) == 0) {
            object = new HashMap();
            return object;
        }
        n10 = object.size();
        if (n10 == 0) {
            return map;
        }
        n10 = map.size();
        if (n10 == 0) {
            return object;
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            int n11;
            Object object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = (List)object2.getValue();
            List list = (List)map.get(string2);
            if (list != null && (n11 = list.size()) > 0) {
                object2.addAll(list);
            }
            hashMap.put(string2, object2);
        }
        return hashMap;
    }

    public static void a(String string2, String string3, Map map) {
        int n10;
        JSONArray jSONArray;
        ArrayList<Object> arrayList;
        String string4;
        block10: {
            string4 = "hmsSdk";
            arrayList = new ArrayList<Object>();
            boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl2) break block10;
            return;
        }
        try {
            jSONArray = new JSONArray(string3);
        }
        catch (JSONException jSONException) {
            y.e(string4, "When events turn to JSONArray,JSON Exception has happened");
            return;
        }
        int n11 = jSONArray.length();
        if (n11 == 0) {
            return;
        }
        string3 = null;
        for (n11 = 0; n11 < (n10 = jSONArray.length()); ++n11) {
            Object object = new q();
            JSONObject jSONObject = jSONArray.getJSONObject(n11);
            ((q)object).a(jSONObject);
            try {
                arrayList.add(object);
                continue;
            }
            catch (JSONException jSONException) {
                object = "JSON Exception happened when create data for report - readDataToRecord";
                y.e(string4, (String)object);
            }
        }
        map.put(string2, arrayList);
        return;
    }

    public static Map b(Context object, String hashMap, String string2) {
        object = g0.a(object, (String)((Object)hashMap), string2, "");
        hashMap = new HashMap();
        w.a(string2, (String)object, hashMap);
        return hashMap;
    }

    public static void b(Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        Set set = s0.a(b.a());
        while (bl2 = object.hasNext()) {
            Object k10 = ((Map.Entry)object.next()).getKey();
            bl2 = set.contains(k10);
            if (bl2) continue;
            object.remove();
        }
    }
}


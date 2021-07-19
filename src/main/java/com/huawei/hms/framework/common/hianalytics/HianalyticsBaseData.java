/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HianalyticsBaseData {
    public static final String SDK_NAME = "sdk_name";
    private static final String SDK_TYPE = "sdk_type";
    private static final String TAG = "HianalyticsBaseData";
    private LinkedHashMap data;

    public HianalyticsBaseData() {
        LinkedHashMap<String, String> linkedHashMap;
        this.data = linkedHashMap = new LinkedHashMap<String, String>();
        linkedHashMap.put(SDK_TYPE, "UxPP");
        this.data.put(SDK_NAME, "Restclient");
    }

    public LinkedHashMap get() {
        return this.data;
    }

    public HianalyticsBaseData put(String charSequence, long l10) {
        if (charSequence == null) {
            charSequence = new StringBuilder();
            String string2 = "key = null : value = ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(l10);
            charSequence = ((StringBuilder)charSequence).toString();
            String string3 = TAG;
            Logger.v(string3, charSequence);
        } else {
            LinkedHashMap linkedHashMap = this.data;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "";
            stringBuilder.append(string4);
            stringBuilder.append(l10);
            String string5 = stringBuilder.toString();
            linkedHashMap.put(charSequence, string5);
        }
        return this;
    }

    public HianalyticsBaseData put(String string2, String string3) {
        if (string2 != null && string3 != null) {
            LinkedHashMap linkedHashMap = this.data;
            linkedHashMap.put(string2, string3);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "key = ";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            stringBuilder.append(" : value = ");
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
            string3 = TAG;
            Logger.v(string3, string2);
        }
        return this;
    }

    public HianalyticsBaseData put(LinkedHashMap object) {
        boolean bl2;
        if (object != null && !(bl2 = ((HashMap)object).isEmpty())) {
            LinkedHashMap linkedHashMap = this.data;
            linkedHashMap.putAll(object);
        } else {
            object = TAG;
            String string2 = "data is null";
            Logger.v((String)object, string2);
        }
        return this;
    }

    public String toString() {
        Object object;
        JSONObject jSONObject = new JSONObject();
        Iterator iterator2 = this.get();
        iterator2 = ((LinkedHashMap)((Object)iterator2)).entrySet();
        try {
            iterator2 = iterator2.iterator();
        }
        catch (JSONException jSONException) {
            object = TAG;
            String string2 = "catch JSONException";
            Logger.w((String)object, string2, jSONException);
        }
        while (true) {
            boolean bl2 = iterator2.hasNext();
            if (!bl2) break;
            object = iterator2.next();
            object = (Map.Entry)object;
            Object k10 = object.getKey();
            String string3 = (String)k10;
            object = object.getValue();
            jSONObject.put(string3, object);
            continue;
            break;
        }
        return jSONObject.toString();
    }
}


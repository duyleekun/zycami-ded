/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.huawei.hms.framework.network.grs.c;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class n {
    public static String a(String string2, String string3) {
        boolean bl2 = string2.equals(string3);
        if (!bl2) {
            string2 = n.b(string2, string3);
        }
        return string2;
    }

    private static String b(String string2, String string3) {
        boolean bl2;
        Object object;
        Object object2 = new HashSet();
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        int n11 = 0;
        String string4 = "services";
        if (n10 == 0) {
            int n12;
            object = new JSONObject(string2);
            string2 = object.getJSONArray(string4);
            object = null;
            for (n10 = 0; n10 < (n12 = string2.length()); ++n10) {
                String string5 = string2.getString(n10);
                object2.add(string5);
            }
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            int n13;
            string2 = new JSONObject(string3);
            string2 = string2.getJSONArray(string4);
            while (n11 < (n13 = string2.length())) {
                string3 = string2.getString(n11);
                object2.add(string3);
                ++n11;
            }
        }
        if (bl2 = object2.isEmpty()) {
            return "";
        }
        string2 = new JSONObject();
        string3 = new JSONArray();
        object2 = object2.iterator();
        while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            object = (String)object2.next();
            string3.put(object);
        }
        string2.put(string4, (Object)string3);
        return string2.toString();
    }
}


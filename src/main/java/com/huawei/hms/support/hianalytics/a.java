/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class a {
    public static Map getMapForBi(Context object, String object2) {
        int n10;
        String string2;
        int n11;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        if (object != null && (n11 = TextUtils.isEmpty((CharSequence)object2)) == 0 && (n11 = ((String[])(object2 = object2.split(string2 = "\\."))).length) >= (n10 = 2)) {
            n11 = 0;
            string2 = object2[0];
            n10 = 1;
            object2 = object2[n10];
            String string3 = "service";
            hashMap.put(string3, string2);
            string2 = "apiName";
            hashMap.put(string2, object2);
            object = object.getPackageName();
            hashMap.put("package", object);
            hashMap.put("baseVersion", "5.2.0.300");
            long l10 = System.currentTimeMillis();
            object = String.valueOf(l10);
            object2 = "callTime";
            hashMap.put(object2, object);
        }
        return hashMap;
    }
}


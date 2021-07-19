/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.e;

import android.text.TextUtils;
import com.huawei.updatesdk.b.e.a;
import com.huawei.updatesdk.b.e.b;
import com.huawei.updatesdk.b.e.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static final Map a;

    static {
        ConcurrentHashMap concurrentHashMap;
        a = concurrentHashMap = new ConcurrentHashMap();
    }

    public static a a(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = new c();
            return object;
        }
        Map map = a;
        boolean bl3 = map.containsKey(object);
        if (bl3) {
            return (a)map.get(object);
        }
        Object object2 = "apptouch";
        bl3 = ((String)object2).equals(object);
        object2 = bl3 ? new b() : new c();
        map.put(object, object2);
        return (a)map.get(object);
    }
}


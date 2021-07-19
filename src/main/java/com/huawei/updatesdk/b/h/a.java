/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.h;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.d.h.c;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map b;
    private static a c;
    private int a;

    static {
        HashMap<Object, String> hashMap;
        b = hashMap = new HashMap<Object, String>();
        Object object = new a();
        c = object;
        object = 1;
        hashMap.put(object, "1.0");
        object = 2;
        hashMap.put(object, "1.5");
        object = 3;
        hashMap.put(object, "1.6");
        object = 4;
        String string2 = "2.0";
        hashMap.put(object, string2);
        object = 5;
        hashMap.put(object, string2);
        object = 6;
        hashMap.put(object, "2.3");
        object = 7;
        hashMap.put(object, "3.0");
        object = 8;
        hashMap.put(object, "3.0.5");
        hashMap.put(object, "3.1");
        object = 9;
        hashMap.put(object, "4.0");
        object = 10;
        hashMap.put(object, "4.1");
        object = 11;
        hashMap.put(object, "5.0");
        object = 12;
        hashMap.put(object, "5.1");
    }

    private a() {
        int n10;
        CharSequence charSequence = null;
        this.a = 0;
        this.a = n10 = this.c();
        if (n10 == 0) {
            this.a = n10 = this.b();
        }
        charSequence = new StringBuilder();
        charSequence.append("emuiVersion:");
        int n11 = this.a;
        charSequence.append(n11);
        charSequence = charSequence.toString();
        com.huawei.updatesdk.a.a.c.a.a.a.a("EMUISupportUtil", (String)charSequence);
    }

    private String a(String object) {
        int n10;
        String string2;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 == 0 && (n11 = ((String[])(object = object.split(string2 = "_"))).length) == (n10 = 2)) {
            n11 = 1;
            object = object[n11];
        } else {
            object = "";
        }
        return object;
    }

    private int b() {
        Object object = "";
        String string2 = com.huawei.updatesdk.a.a.d.h.c.a("ro.build.version.emui", (String)object);
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.a(string2)));
        if (!bl2) {
            boolean bl3;
            object = b.entrySet().iterator();
            while (bl3 = object.hasNext()) {
                Map.Entry entry = (Map.Entry)object.next();
                Object v10 = entry.getValue();
                boolean bl4 = string2.equals(v10);
                if (!bl4) continue;
                return (Integer)entry.getKey();
            }
        }
        return 0;
    }

    private int c() {
        return com.huawei.updatesdk.a.a.d.h.c.a("ro.build.hw_emui_api_level", 0);
    }

    public static a d() {
        return c;
    }

    public int a() {
        return this.a;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.b.c.c;

import com.huawei.updatesdk.a.a.d.f;
import com.huawei.updatesdk.a.a.d.g;
import com.huawei.updatesdk.a.b.c.c.b;
import com.huawei.updatesdk.service.appmgr.bean.SDKNetTransmission;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class c {
    public static final String CLIENT_API = "clientApi";
    private static final String END_FLAG = "_";
    private static String url;
    private String method;
    private String ver = "1.1";

    private String a(Field object) {
        boolean bl2 = (object = ((Field)object).get(this)) instanceof b;
        if (bl2) {
            return ((b)object).toJson();
        }
        if (object != null) {
            return String.valueOf(object);
        }
        return null;
    }

    public static void c(String string2) {
        url = string2;
    }

    public String a() {
        int n10;
        this.e();
        Map map = this.c();
        int n11 = map.size();
        Object[] objectArray = new String[n11];
        map.keySet().toArray(objectArray);
        Arrays.sort(objectArray);
        StringBuilder stringBuilder = new StringBuilder();
        int n12 = 0;
        do {
            Object object = objectArray[n12];
            object = (Field)map.get(object);
            if ((object = this.a((Field)object)) == null) continue;
            object = g.a((String)object);
            Object object2 = objectArray[n12];
            stringBuilder.append((String)object2);
            object2 = "=";
            stringBuilder.append((String)object2);
            stringBuilder.append((String)object);
            object = "&";
            stringBuilder.append((String)object);
        } while (++n12 < n11);
        int n13 = stringBuilder.length();
        if (n13 > 0 && (n11 = (int)stringBuilder.charAt(n13 += -1)) == (n10 = 38)) {
            stringBuilder.deleteCharAt(n13);
        }
        return stringBuilder.toString();
    }

    public void a(String string2) {
        this.method = string2;
    }

    public String b() {
        return this.method;
    }

    public void b(String string2) {
        this.ver = string2;
    }

    public Map c() {
        HashMap<String, Field> hashMap = new HashMap<String, Field>();
        for (Field field : f.a(this.getClass())) {
            Class<SDKNetTransmission> clazz;
            int n10 = 1;
            field.setAccessible(n10 != 0);
            String string2 = field.getName();
            String string3 = END_FLAG;
            boolean bl2 = string2.endsWith(string3);
            if (!bl2 && !(bl2 = field.isAnnotationPresent(clazz = SDKNetTransmission.class))) continue;
            int n11 = string2.endsWith(string3);
            if (n11 != 0) {
                n11 = string2.length() - n10;
                string2 = string2.substring(0, n11);
            }
            hashMap.put(string2, field);
        }
        return hashMap;
    }

    public String d() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = url;
        stringBuilder.append(string2);
        stringBuilder.append(CLIENT_API);
        return stringBuilder.toString();
    }

    public void e() {
    }
}


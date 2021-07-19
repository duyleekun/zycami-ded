/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.b.c;

import com.huawei.updatesdk.a.b.c.c.d;
import com.huawei.updatesdk.service.appmgr.bean.b;
import com.huawei.updatesdk.service.appmgr.bean.e;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static final Map a;

    static {
        HashMap<String, Class> hashMap;
        a = hashMap = new HashMap<String, Class>();
        hashMap.put("client.updateCheck", e.class);
        hashMap.put("client.getMarketInfo", b.class);
    }

    public static d a(String string2) {
        Serializable serializable = (Class)a.get(string2);
        if (serializable != null) {
            return (d)serializable.newInstance();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ResponseBean class not found, method:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        serializable = new InstantiationException(string2);
        throw serializable;
    }
}


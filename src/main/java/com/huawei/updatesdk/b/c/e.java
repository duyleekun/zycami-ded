/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.c;

import com.huawei.updatesdk.b.c.c;
import java.util.ArrayList;
import java.util.List;

public class e
extends c {
    public String a() {
        return "com.huawei.appmarket.tv";
    }

    public int b() {
        return 1;
    }

    public String c() {
        return com.huawei.updatesdk.a.a.d.h.c.a("ro.product.manufacturer", "");
    }

    public String d() {
        return com.huawei.updatesdk.a.a.d.h.c.a("ro.product.hw_model", "");
    }

    public List g() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("CE1EF7188F820973C191227D95D54311ED3A65EC83E37009E898A1C058BBC775");
        return arrayList;
    }
}


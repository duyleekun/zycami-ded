/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.c;

import com.huawei.updatesdk.b.c.c;
import java.util.ArrayList;
import java.util.List;

public class d
extends c {
    public String a() {
        return "com.huawei.appmarket";
    }

    public int b() {
        return 0;
    }

    public String c() {
        return com.huawei.updatesdk.a.a.d.h.c.a("ro.product.manufacturer", "");
    }

    public String d() {
        return com.huawei.updatesdk.a.a.d.h.c.a("ro.product.hw_model", "");
    }

    public List g() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("3BAF59A2E5331C30675FAB35FF5FFF0D116142D3D4664F1C3CB804068B40614F");
        arrayList.add("FFE391E0EA186D0734ED601E4E70E3224B7309D48E2075BAC46D8C667EAE7212");
        return arrayList;
    }
}


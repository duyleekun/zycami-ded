/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.updatesdk.b.e;

import android.content.Context;
import com.huawei.updatesdk.b.e.a;
import com.huawei.updatesdk.b.h.c;
import com.huawei.updatesdk.service.otaupdate.f;

public class b
extends a {
    public String a() {
        return "com.huawei.apptouch.updatesdk";
    }

    public String a(Context context) {
        return c.d(context, "upsdk_apptouch_store_url");
    }

    public String b() {
        return f.f().c();
    }

    public void d() {
    }
}


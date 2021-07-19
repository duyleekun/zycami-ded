/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.d;

import com.huawei.updatesdk.a.b.c.c.a;
import com.huawei.updatesdk.b.d.f$b;
import com.huawei.updatesdk.b.g.b;

public class f {
    private static com.huawei.updatesdk.service.otaupdate.b a;

    public static /* synthetic */ com.huawei.updatesdk.service.otaupdate.b a() {
        return a;
    }

    public static void a(com.huawei.updatesdk.service.otaupdate.b b10) {
        a = b10;
    }

    public static void a(boolean bl2) {
        Object object;
        if (bl2) {
            object = com.huawei.updatesdk.service.otaupdate.f.f().c();
        } else {
            bl2 = false;
            object = null;
        }
        com.huawei.updatesdk.service.appmgr.bean.a a10 = new com.huawei.updatesdk.service.appmgr.bean.a((String)object);
        object = new f$b(null);
        b.a(a10, (a)object);
    }
}


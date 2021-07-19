/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.d;

import com.huawei.updatesdk.a.b.c.c.a;
import com.huawei.updatesdk.a.b.c.c.c;
import com.huawei.updatesdk.a.b.c.c.d;
import com.huawei.updatesdk.b.d.f;
import com.huawei.updatesdk.b.d.f$a;
import com.huawei.updatesdk.service.appmgr.bean.b;

public class f$b
implements a {
    private f$b() {
    }

    public /* synthetic */ f$b(f$a f$a) {
        this();
    }

    public void a(c c10, d d10) {
    }

    public void b(c object, d object2) {
        object = f.a();
        if (object == null) {
            return;
        }
        boolean bl2 = object2 instanceof b;
        if (bl2) {
            object = object2;
            object = (b)object2;
            int n10 = ((d)object2).d();
            if (n10 == 0 && (n10 = ((d)object2).e()) == 0) {
                com.huawei.updatesdk.service.appmgr.bean.c c10 = ((b)object).g();
                if (c10 == null) {
                    object = f.a();
                    int n11 = ((d)object2).d();
                    object.a(n11);
                    return;
                }
                object2 = f.a();
                object = ((b)object).g();
                object2.a((com.huawei.updatesdk.service.appmgr.bean.c)object);
            } else {
                object = f.a();
                int n12 = ((d)object2).d();
                object.b(n12);
            }
        } else {
            object = f.a();
            int n13 = ((d)object2).d();
            object.a(n13);
        }
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.manager.a;
import com.xiaomi.clientreport.manager.e;
import com.xiaomi.push.ai$a;

public class d
extends ai$a {
    public final /* synthetic */ a a;

    public d(a a10) {
        this.a = a10;
    }

    public int a() {
        return 100888;
    }

    public void run() {
        Object object = this.a;
        int n10 = com.xiaomi.clientreport.manager.a.a((a)object);
        if (n10 > 0) {
            object = com.xiaomi.clientreport.manager.a.a(this.a);
            e e10 = new e(this);
            object.execute(e10);
        }
    }
}


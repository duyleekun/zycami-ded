/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.manager.a;
import com.xiaomi.clientreport.manager.g;
import com.xiaomi.push.ai$a;

public class f
extends ai$a {
    public final /* synthetic */ a a;

    public f(a a10) {
        this.a = a10;
    }

    public int a() {
        return 100889;
    }

    public void run() {
        Object object = this.a;
        int n10 = com.xiaomi.clientreport.manager.a.b((a)object);
        if (n10 > 0) {
            object = com.xiaomi.clientreport.manager.a.a(this.a);
            g g10 = new g(this);
            object.execute(g10);
        }
    }
}


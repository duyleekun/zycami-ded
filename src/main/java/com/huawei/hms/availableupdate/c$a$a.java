/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.availableupdate;

import com.huawei.hms.availableupdate.c$a;
import com.huawei.hms.availableupdate.f;
import com.huawei.hms.availableupdate.g;

public class c$a$a
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ g b;
    public final /* synthetic */ c$a c;

    public c$a$a(c$a a10, int n10, g g10) {
        this.c = a10;
        this.a = n10;
        this.b = g10;
    }

    public void run() {
        f f10 = this.c.a;
        int n10 = this.a;
        g g10 = this.b;
        f10.a(n10, g10);
    }
}


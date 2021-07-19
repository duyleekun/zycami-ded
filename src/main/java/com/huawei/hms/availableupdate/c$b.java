/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.availableupdate;

import com.huawei.hms.availableupdate.c;
import com.huawei.hms.availableupdate.e;
import com.huawei.hms.availableupdate.f;
import com.huawei.hms.availableupdate.g;

public class c$b
implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ g b;
    public final /* synthetic */ c c;

    public c$b(c c10, f f10, g g10) {
        this.c = c10;
        this.a = f10;
        this.b = g10;
    }

    public void run() {
        e e10 = com.huawei.hms.availableupdate.c.a(this.c);
        f f10 = com.huawei.hms.availableupdate.c.a(this.a);
        g g10 = this.b;
        e10.a(f10, g10);
    }
}


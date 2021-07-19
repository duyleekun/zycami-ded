/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.availableupdate;

import com.huawei.hms.availableupdate.f;
import com.huawei.hms.availableupdate.g;

public final class f0$a
implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ int b;
    public final /* synthetic */ g c;

    public f0$a(f f10, int n10, g g10) {
        this.a = f10;
        this.b = n10;
        this.c = g10;
    }

    public void run() {
        f f10 = this.a;
        int n10 = this.b;
        g g10 = this.c;
        f10.a(n10, g10);
    }
}


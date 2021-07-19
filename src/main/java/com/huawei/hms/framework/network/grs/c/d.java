/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.c.e;
import com.huawei.hms.framework.network.grs.c.f;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class d
implements Callable {
    public final /* synthetic */ ExecutorService a;
    public final /* synthetic */ String b;
    public final /* synthetic */ c c;
    public final /* synthetic */ e d;

    public d(e e10, ExecutorService executorService, String string2, c c10) {
        this.d = e10;
        this.a = executorService;
        this.b = string2;
        this.c = c10;
    }

    public f call() {
        e e10 = this.d;
        ExecutorService executorService = this.a;
        String string2 = this.b;
        c c10 = this.c;
        return e.a(e10, executorService, string2, c10);
    }
}


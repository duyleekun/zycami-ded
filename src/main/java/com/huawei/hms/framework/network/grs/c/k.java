/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.c.b.c;
import com.huawei.hms.framework.network.grs.c.e;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.m;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class k
implements Callable {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.huawei.hms.framework.network.grs.a.c c;
    public final /* synthetic */ m d;

    public k(m m10, c c10, String string2, com.huawei.hms.framework.network.grs.a.c c11) {
        this.d = m10;
        this.a = c10;
        this.b = string2;
        this.c = c11;
    }

    public f call() {
        Object object = this.a;
        Object object2 = m.b(this.d);
        e e10 = new e((c)object, (a)object2);
        object = m.a(this.d);
        object2 = this.b;
        com.huawei.hms.framework.network.grs.a.c c10 = this.c;
        return e10.a((ExecutorService)object, (String)object2, c10);
    }
}


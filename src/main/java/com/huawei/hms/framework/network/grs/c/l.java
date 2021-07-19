/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.network.grs.b;
import com.huawei.hms.framework.network.grs.c.b.c;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.m;

public class l
implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.huawei.hms.framework.network.grs.a.c c;
    public final /* synthetic */ b d;
    public final /* synthetic */ m e;

    public l(m m10, c c10, String string2, com.huawei.hms.framework.network.grs.a.c c11, b b10) {
        this.e = m10;
        this.a = c10;
        this.b = string2;
        this.c = c11;
        this.d = b10;
    }

    public void run() {
        m m10 = this.e;
        Object object = this.a;
        Object object2 = this.b;
        com.huawei.hms.framework.network.grs.a.c c10 = this.c;
        object = m10.a((c)object, (String)object2, c10);
        object2 = this.d;
        m.a(m10, (f)object, (b)object2);
    }
}


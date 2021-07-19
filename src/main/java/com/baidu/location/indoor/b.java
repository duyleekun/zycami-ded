/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.b.aa;
import com.baidu.location.h.f;
import com.baidu.location.indoor.a;
import java.util.concurrent.ExecutorService;

public class b
implements Runnable {
    public final /* synthetic */ a a;

    public b(a a10) {
        this.a = a10;
    }

    public void run() {
        Object object = com.baidu.location.indoor.a.a(this.a);
        if (object != null) {
            object = this.a;
            Object object2 = com.baidu.location.indoor.a.a((a)object);
            com.baidu.location.indoor.a.a((a)object, (String)object2);
            object = this.a;
            object2 = aa.a().c();
            String string2 = com.baidu.location.indoor.a.b(this.a);
            ((f)object).a((ExecutorService)object2, string2);
        }
    }
}


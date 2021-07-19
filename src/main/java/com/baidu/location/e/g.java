/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.e;

import com.baidu.location.b.aa;
import com.baidu.location.e.f$a;
import com.baidu.location.h.f;
import java.util.concurrent.ExecutorService;

public class g
implements Runnable {
    public final /* synthetic */ f$a a;

    public g(f$a f$a) {
        this.a = f$a;
    }

    public void run() {
        Object object = aa.a().c();
        String string2 = "https://ofloc.map.baidu.com/offline_loc";
        if (object != null) {
            f$a f$a = this.a;
            f$a.a((ExecutorService)object, string2);
        } else {
            object = this.a;
            ((f)object).e(string2);
        }
    }
}


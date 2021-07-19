/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.h;

import com.huawei.updatesdk.a.a.c.a.a.a;
import com.huawei.updatesdk.b.d.d;
import com.huawei.updatesdk.b.h.b$a;
import java.io.File;

public class b$c
implements Runnable {
    private b$c() {
    }

    public /* synthetic */ b$c(b$a b$a) {
        this();
    }

    public void run() {
        a.a("PackageManagerRunnable", "PackageManagerRunnable run!!!!");
        String string2 = d.b();
        File file = new File(string2);
        com.huawei.updatesdk.a.a.d.d.a(file);
    }
}


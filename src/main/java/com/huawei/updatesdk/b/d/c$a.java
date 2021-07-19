/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.d;

import com.huawei.updatesdk.a.a.d.d;
import com.huawei.updatesdk.b.d.c;
import java.io.File;
import java.net.HttpURLConnection;

public class c$a
implements Runnable {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void run() {
        Object object = c.a(this.a);
        if (object != null) {
            object = this.a;
            boolean bl2 = true;
            c.a((c)((Object)object), bl2);
            object = c.a(this.a);
            ((HttpURLConnection)object).disconnect();
        }
        String string2 = c.c();
        object = new File(string2);
        d.a((File)object);
    }
}


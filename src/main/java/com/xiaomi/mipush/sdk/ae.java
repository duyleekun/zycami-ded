/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient$a$a;
import java.util.ArrayList;

public class ae
implements Runnable {
    public final /* synthetic */ MiTinyDataClient$a$a a;

    public ae(MiTinyDataClient$a$a miTinyDataClient$a$a) {
        this.a = miTinyDataClient$a$a;
    }

    public void run() {
        Object object = this.a.a;
        int n10 = ((ArrayList)object).size();
        if (n10 != 0) {
            object = this.a;
            MiTinyDataClient$a$a.b((MiTinyDataClient$a$a)object);
        } else {
            object = MiTinyDataClient$a$a.a(this.a);
            if (object != null) {
                MiTinyDataClient$a$a.a(this.a).cancel(false);
                object = this.a;
                MiTinyDataClient$a$a.a((MiTinyDataClient$a$a)object, null);
            }
        }
    }
}


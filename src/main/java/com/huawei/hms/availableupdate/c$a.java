/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.huawei.hms.availableupdate;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.availableupdate.c$a$a;
import com.huawei.hms.availableupdate.c$a$b;
import com.huawei.hms.availableupdate.f;
import com.huawei.hms.availableupdate.g;
import java.io.File;

public final class c$a
implements f {
    public final /* synthetic */ f a;

    public c$a(f f10) {
        this.a = f10;
    }

    public void a(int n10, int n11, int n12, File file) {
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new c$a$b(this, n10, n11, n12, file);
        handler.post((Runnable)object);
    }

    public void a(int n10, g g10) {
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new c$a$a(this, n10, g10);
        handler.post((Runnable)object);
    }
}


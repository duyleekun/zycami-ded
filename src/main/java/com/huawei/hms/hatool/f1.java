/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.hatool;

import android.content.Context;
import com.huawei.hms.hatool.i;
import com.huawei.hms.hatool.l;
import com.huawei.hms.hatool.q0;
import com.huawei.hms.hatool.x0;
import com.huawei.hms.hatool.y;

public final class f1 {
    public static f1 b;
    public static final Object c;
    public Context a;

    static {
        Object object;
        c = object = new Object();
    }

    public static f1 a() {
        f1 f12 = b;
        if (f12 == null) {
            f1.b();
        }
        return b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b() {
        Class<f1> clazz = f1.class;
        synchronized (clazz) {
            f1 f12 = b;
            if (f12 == null) {
                b = f12 = new f1();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Context object) {
        Object object2;
        Object object3 = c;
        synchronized (object3) {
            object2 = this.a;
            if (object2 != null) {
                object = "hmsSdk";
                object2 = "DataManager already initialized.";
                y.f((String)object, (String)object2);
                return;
            }
            this.a = object;
        }
        object3 = i.c().b();
        object2 = this.a;
        ((l)object3).a((Context)object2);
        object3 = i.c().b();
        object2 = object.getPackageName();
        ((l)object3).g((String)object2);
        x0.a().a((Context)object);
    }

    public void a(String string2) {
        String string3 = "hmsSdk";
        y.c(string3, "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.a;
        if (context == null) {
            y.e(string3, "sdk is not init");
            return;
        }
        string3 = context.getPackageName();
        string2 = q0.a("appID", string2, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", string3);
        i.c().b().f(string2);
    }
}


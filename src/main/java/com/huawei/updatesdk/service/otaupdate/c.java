/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import com.huawei.updatesdk.a.a.a;
import com.huawei.updatesdk.b.h.b;
import com.huawei.updatesdk.service.otaupdate.c$a;
import com.huawei.updatesdk.service.otaupdate.c$b;
import com.huawei.updatesdk.service.otaupdate.f;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class c {
    private static String a;

    public static /* synthetic */ String a() {
        return a;
    }

    public void a(Context object, String object2, c$a c$a) {
        Boolean bl2 = Boolean.FALSE;
        boolean bl3 = b.e((Context)object, object2);
        if (bl3 && (bl3 = ((f)(object = f.f())).d())) {
            object = new c$b(c$a);
            Object object3 = Executors.newSingleThreadExecutor();
            Object object4 = new Void[]{};
            object.executeOnExecutor((Executor)object3, object4);
            int n10 = 1;
            object4 = Locale.ROOT;
            String string2 = "content://%s.commondata/item/4";
            Object[] objectArray = new Object[n10];
            objectArray[0] = object2;
            object2 = String.format((Locale)object4, string2, objectArray);
            a = object2;
            long l10 = 500L;
            object2 = TimeUnit.MILLISECONDS;
            try {
                object.get(l10, (TimeUnit)((Object)object2));
            }
            catch (Exception exception) {
                object.cancel(n10 != 0);
                object = new StringBuilder();
                object3 = "init AutoUpdateInfo error: ";
                ((StringBuilder)object).append((String)object3);
                String string3 = exception.toString();
                ((StringBuilder)object).append(string3);
                object = ((StringBuilder)object).toString();
                string3 = "AutoUpdateUtil";
                com.huawei.updatesdk.a.a.a.a(string3, (String)object);
                c$a.a(bl2);
            }
            return;
        }
        c$a.a(bl2);
    }
}


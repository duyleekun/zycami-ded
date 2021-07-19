/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.updatesdk.b.e.d;
import com.huawei.updatesdk.b.h.b;
import com.huawei.updatesdk.service.otaupdate.f;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public abstract class a {
    private String a(Context object, String object2) {
        String string2 = "AbstractTaskInit";
        Object object3 = new GrsBaseInfo();
        ((GrsBaseInfo)object3).setSerCountry((String)object2);
        object2 = new GrsClient((Context)object, (GrsBaseInfo)object3);
        object3 = this.a();
        String string3 = "ROOT";
        try {
            object2 = ((GrsClient)object2).synGetGrsUrl((String)object3, string3);
        }
        catch (Throwable throwable) {
            object3 = new StringBuilder();
            string3 = "UpdateSDK Get url from GRS_SDK error: ";
            ((StringBuilder)object3).append(string3);
            object2 = throwable.toString();
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            com.huawei.updatesdk.a.a.a.c(string2, (String)object2);
            object2 = null;
        }
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2) {
            com.huawei.updatesdk.a.a.a.b(string2, "UpdateSDK Get url is default url");
            return this.a((Context)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("UpdateSDK Get url from GRS_SDK Success!");
        object3 = this.a((String)object2);
        ((StringBuilder)object).append((String)object3);
        object = ((StringBuilder)object).toString();
        com.huawei.updatesdk.a.a.a.b(string2, (String)object);
        return object2;
    }

    private String a(String string2) {
        if (string2 == null) {
            return null;
        }
        int n10 = 46;
        try {
            n10 = string2.indexOf(n10);
        }
        catch (Exception exception) {
            string2 = exception.toString();
            com.huawei.updatesdk.a.a.c.a.a.a.b("AbstractTaskInit", string2);
            return null;
        }
        return string2.substring(0, n10);
    }

    private boolean b(Context object, String string2) {
        long l10;
        Object object2 = b.d((Context)object, string2);
        if (object2 == 0) {
            return false;
        }
        object = com.huawei.updatesdk.b.b.a.d();
        long l11 = ((com.huawei.updatesdk.b.b.a)object).b(string2);
        l11 = Math.abs(System.currentTimeMillis() - l11);
        long l12 = l11 - (l10 = 86400000L);
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 < 0) {
            object = com.huawei.updatesdk.b.b.a.d().a(string2);
            f.f().a((String)object);
            return false;
        }
        return true;
    }

    public abstract String a();

    public abstract String a(Context var1);

    public abstract String b();

    public String b(Context context) {
        String string2 = f.f().a();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            com.huawei.updatesdk.a.a.a.b("AbstractTaskInit", "UpdateSDK accoutZone is empty, so url is default");
            return this.a(context);
        }
        return this.a(context, string2);
    }

    public void c() {
        Object object;
        Object object2 = com.huawei.updatesdk.a.b.a.a.c().a();
        boolean bl2 = this.b((Context)object2, (String)(object = this.b()));
        if (!bl2) {
            return;
        }
        object2 = Locale.ROOT;
        int n10 = 1;
        Object object3 = new Object[n10];
        TimeUnit timeUnit = null;
        object3[0] = object;
        String string2 = "content://%s.commondata/item/1";
        object2 = String.format((Locale)object2, string2, object3);
        object3 = new d((String)object2, (String)object);
        object2 = Executors.newSingleThreadExecutor();
        object = new Void[]{};
        object3.executeOnExecutor((Executor)object2, (Object[])object);
        long l10 = 1000L;
        timeUnit = TimeUnit.MILLISECONDS;
        try {
            object3.get(l10, timeUnit);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            object3 = "init AccountZone error: ";
            ((StringBuilder)object).append((String)object3);
            String string3 = exception.toString();
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            object = "AbstractTaskInit";
            com.huawei.updatesdk.a.a.a.a((String)object, string3);
        }
    }

    public abstract void d();
}


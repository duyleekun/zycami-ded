/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$Builder;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$Builder$ComponentType;
import com.huawei.updatesdk.a.b.c.c.d;
import com.huawei.updatesdk.b.c.b;
import com.huawei.updatesdk.b.e.a;

public class c
extends a {
    private static String a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String e() {
        String string2 = "DefaultTaskInit";
        String string3 = null;
        try {
            Object object = com.huawei.updatesdk.a.b.a.a.c();
            object = ((com.huawei.updatesdk.a.b.a.a)object).a();
            Object object2 = new ServiceVerifyKit$Builder();
            Object object3 = "com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId";
            Object object4 = new Intent(object3);
            object = ((ServiceVerifyKit$Builder)object2).h((Context)object);
            object3 = ServiceVerifyKit$Builder$ComponentType.ACTIVITY;
            ((ServiceVerifyKit$Builder)object).m((Intent)object4, (ServiceVerifyKit$Builder$ComponentType)((Object)object3));
            object = b.a();
            object4 = ((com.huawei.updatesdk.b.c.c)object).g();
            object4 = object4.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object4.hasNext())) {
                    string3 = ((ServiceVerifyKit$Builder)object2).d();
                    object = new StringBuilder();
                    object2 = "UpdateSDK get market packagename from verify kit is: ";
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(string3);
                    object = ((StringBuilder)object).toString();
                    com.huawei.updatesdk.a.a.a.b(string2, (String)object);
                    return string3;
                }
                object3 = object4.next();
                String string4 = ((com.huawei.updatesdk.b.c.c)object).a();
                ((ServiceVerifyKit$Builder)object2).a(string4, (String)object3);
            }
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder();
            String string5 = "UpdateSDK genVerifiedPackageName error: ";
            stringBuilder.append(string5);
            String string6 = throwable.toString();
            stringBuilder.append(string6);
            string6 = stringBuilder.toString();
            com.huawei.updatesdk.a.a.a.c(string2, string6);
        }
        return string3;
    }

    private void f() {
        Object object = com.huawei.updatesdk.a.b.a.a.c().a();
        com.huawei.updatesdk.a.b.c.c.c.c(this.a((Context)object));
        Object object2 = null;
        object = new com.huawei.updatesdk.service.appmgr.bean.a(null);
        Object object3 = new com.huawei.updatesdk.a.b.c.b((com.huawei.updatesdk.a.b.c.c.c)object, null);
        object = object3.c();
        boolean bl2 = ((d)object).f();
        if (bl2) {
            object = (com.huawei.updatesdk.service.appmgr.bean.b)object;
            object2 = ((com.huawei.updatesdk.service.appmgr.bean.b)object).g();
            object3 = "DefaultTaskInit";
            if (object2 != null) {
                a = ((com.huawei.updatesdk.service.appmgr.bean.b)object).g().d();
                object = new StringBuilder();
                ((StringBuilder)object).append("getPackageName from store: ");
                object2 = a;
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
            } else {
                object2 = new StringBuilder();
                String string2 = "getPackageName from store: error";
                ((StringBuilder)object2).append(string2);
                object = ((d)object).toString();
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
            }
            com.huawei.updatesdk.a.a.a.b((String)object3, (String)object);
        }
    }

    public String a() {
        return "com.huawei.updatesdk";
    }

    public String a(Context context) {
        return com.huawei.updatesdk.b.h.c.d(context, "upsdk_store_url");
    }

    public String b() {
        return a;
    }

    public void d() {
        CharSequence charSequence = a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl2) {
            return;
        }
        charSequence = this.e();
        a = charSequence;
        bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            this.f();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("UpdateSDK genVerifiedPackageName is: ");
        String string2 = a;
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        com.huawei.updatesdk.a.a.a.b("DefaultTaskInit", (String)charSequence);
    }
}


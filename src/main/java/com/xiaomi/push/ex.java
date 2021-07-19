/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.el;
import com.xiaomi.push.em;
import com.xiaomi.push.ep;
import com.xiaomi.push.et;
import com.xiaomi.push.service.f;

public class ex
implements et {
    private void a(Service service, Intent object) {
        String string2 = "com.xiaomi.mipush.sdk.WAKEUP";
        String string3 = object.getAction();
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            string3 = object.getStringExtra("waker_pkgname");
            string2 = "awake_info";
            object = object.getStringExtra(string2);
            boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
            String string4 = "service";
            int n10 = 1007;
            if (bl3) {
                em.a(service.getApplicationContext(), string4, n10, "old version message");
                return;
            }
            bl3 = TextUtils.isEmpty((CharSequence)object);
            if (!bl3) {
                object = el.b((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                service = service.getApplicationContext();
                if (!bl2) {
                    string3 = "old version message ";
                    em.a((Context)service, (String)object, n10, string3);
                } else {
                    int n11 = 1008;
                    string3 = "B get a incorrect message";
                    em.a((Context)service, string4, n11, string3);
                }
            } else {
                service = service.getApplicationContext();
                object = "play with service ";
                em.a((Context)service, string3, n10, (String)object);
            }
        }
    }

    private void a(Context context, String string2, String string3, String string4) {
        int n10;
        int n11 = 1008;
        if (context != null && (n10 = TextUtils.isEmpty((CharSequence)string2)) == 0 && (n10 = TextUtils.isEmpty((CharSequence)string3)) == 0) {
            block16: {
                Intent intent;
                n10 = f.a(context, string2);
                if (n10 == 0) {
                    em.a(context, string4, 1003, "B is not ready");
                    return;
                }
                em.a(context, string4, 1002, "B is ready");
                n10 = 1004;
                String string5 = "A is ready";
                em.a(context, string4, n10, string5);
                try {
                    intent = new Intent();
                }
                catch (Exception exception) {
                    b.a(exception);
                    em.a(context, string4, n11, "A meet a exception when help B's service");
                    return;
                }
                intent.setClassName(string2, string3);
                string2 = "com.xiaomi.mipush.sdk.WAKEUP";
                intent.setAction(string2);
                string2 = "waker_pkgname";
                string3 = context.getPackageName();
                intent.putExtra(string2, string3);
                string2 = "awake_info";
                string3 = el.a(string4);
                intent.putExtra(string2, string3);
                string2 = context.startService(intent);
                if (string2 == null) break block16;
                int n12 = 1005;
                string3 = "A is successful";
                em.a(context, string4, n12, string3);
                em.a(context, string4, 1006, "The job is finished");
                return;
            }
            string2 = "A is fail to help B's service";
            em.a(context, string4, n11, string2);
            return;
        }
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        string3 = "argument error";
        if (bl2) {
            string2 = "service";
            em.a(context, string2, n11, string3);
        } else {
            em.a(context, string4, n11, string3);
        }
    }

    public void a(Context context, Intent intent, String string2) {
        boolean bl2;
        if (context != null && (bl2 = context instanceof Service)) {
            context = (Service)context;
            this.a((Service)context, intent);
        }
    }

    public void a(Context context, ep object) {
        if (object != null) {
            String string2 = ((ep)object).a();
            String string3 = ((ep)object).c();
            object = ((ep)object).d();
            this.a(context, string2, string3, (String)object);
        }
    }
}


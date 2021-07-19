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
import com.xiaomi.push.eq;
import com.xiaomi.push.et;
import com.xiaomi.push.service.f;

public class ew
implements et {
    private void a(Service service, Intent object) {
        String string2 = "awake_info";
        object = object.getStringExtra(string2);
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string3 = "B get a incorrect message";
        int n11 = 1008;
        String string4 = "service";
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)(object = el.b((String)object)))) == 0) {
            service = service.getApplicationContext();
            n10 = 1007;
            string3 = "play with service successfully";
            em.a((Context)service, (String)object, n10, string3);
        } else {
            service = service.getApplicationContext();
            em.a((Context)service, string4, n11, string3);
        }
    }

    private void b(Context context, ep object) {
        int n10;
        String string2 = ((ep)object).a();
        String string3 = ((ep)object).b();
        String string4 = ((ep)object).d();
        int n11 = ((ep)object).a();
        int n12 = 1008;
        if (context != null && (n10 = TextUtils.isEmpty((CharSequence)string2)) == 0 && (n10 = TextUtils.isEmpty((CharSequence)string3)) == 0 && (n10 = TextUtils.isEmpty((CharSequence)string4)) == 0) {
            block17: {
                Intent intent;
                block16: {
                    n10 = f.a(context, string2, string3);
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
                        em.a(context, string4, n12, "A meet a exception when help B's service");
                        return;
                    }
                    intent.setAction(string3);
                    intent.setPackage(string2);
                    string2 = "awake_info";
                    string3 = el.a(string4);
                    intent.putExtra(string2, string3);
                    int n13 = 1;
                    if (n11 != n13) break block16;
                    n11 = (int)(eq.a(context) ? 1 : 0);
                    if (n11 != 0) break block16;
                    object = "A not in foreground";
                    em.a(context, string4, n12, (String)object);
                    return;
                }
                object = context.startService(intent);
                if (object == null) break block17;
                n11 = 1005;
                string2 = "A is successful";
                em.a(context, string4, n11, string2);
                em.a(context, string4, 1006, "The job is finished");
                return;
            }
            object = "A is fail to help B's service";
            em.a(context, string4, n12, (String)object);
            return;
        }
        n11 = (int)(TextUtils.isEmpty((CharSequence)string4) ? 1 : 0);
        string2 = "argument error";
        if (n11 != 0) {
            object = "service";
            em.a(context, (String)object, n12, string2);
        } else {
            em.a(context, string4, n12, string2);
        }
    }

    public void a(Context context, Intent intent, String string2) {
        boolean bl2;
        if (context != null && (bl2 = context instanceof Service)) {
            context = (Service)context;
            this.a((Service)context, intent);
        } else {
            int n10 = 1008;
            string2 = "service";
            String string3 = "A receive incorrect message";
            em.a(context, string2, n10, string3);
        }
    }

    public void a(Context context, ep ep2) {
        if (ep2 != null) {
            this.b(context, ep2);
        } else {
            int n10 = 1008;
            String string2 = "service";
            String string3 = "A receive incorrect message";
            em.a(context, string2, n10, string3);
        }
    }
}


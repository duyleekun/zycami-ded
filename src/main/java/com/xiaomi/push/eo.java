/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.app.Activity;
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

public class eo
implements et {
    private void a(Activity activity, Intent object) {
        String string2 = "awake_info";
        object = object.getStringExtra(string2);
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string3 = "B get incorrect message";
        int n11 = 1008;
        String string4 = "activity";
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)(object = el.b((String)object)))) == 0) {
            activity = activity.getApplicationContext();
            n10 = 1007;
            string3 = "play with activity successfully";
            em.a((Context)activity, (String)object, n10, string3);
        } else {
            activity = activity.getApplicationContext();
            em.a((Context)activity, string4, n11, string3);
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
            Intent intent;
            block10: {
                n10 = f.b(context, string2, string3);
                if (n10 == 0) {
                    em.a(context, string4, 1003, "B is not ready");
                    return;
                }
                em.a(context, string4, 1002, "B is ready");
                n10 = 1004;
                em.a(context, string4, n10, "A is ready");
                intent = new Intent(string3);
                intent.setPackage(string2);
                string2 = el.a(string4);
                String string5 = "awake_info";
                intent.putExtra(string5, string2);
                intent.addFlags(0x10800000);
                intent.setAction(string3);
                int n13 = 1;
                if (n11 == n13) {
                    n11 = (int)(eq.a(context) ? 1 : 0);
                    if (n11 != 0) break block10;
                    object = "A not in foreground";
                    em.a(context, string4, n12, (String)object);
                    return;
                }
            }
            try {
                context.startActivity(intent);
                n11 = 1005;
                string2 = "A is successful";
            }
            catch (Exception exception) {
                b.a(exception);
                em.a(context, string4, n12, "A meet a exception when help B's activity");
                return;
            }
            em.a(context, string4, n11, string2);
            em.a(context, string4, 1006, "The job is finished");
            return;
        }
        n11 = (int)(TextUtils.isEmpty((CharSequence)string4) ? 1 : 0);
        string2 = "argument error";
        if (n11 != 0) {
            object = "activity";
            em.a(context, (String)object, n12, string2);
        } else {
            em.a(context, string4, n12, string2);
        }
    }

    public void a(Context context, Intent intent, String string2) {
        boolean bl2;
        if (context != null && (bl2 = context instanceof Activity) && intent != null) {
            context = (Activity)context;
            this.a((Activity)context, intent);
        } else {
            int n10 = 1008;
            string2 = "activity";
            String string3 = "B receive incorrect message";
            em.a(context, string2, n10, string3);
        }
    }

    public void a(Context context, ep ep2) {
        if (ep2 != null) {
            this.b(context, ep2);
        } else {
            int n10 = 1008;
            String string2 = "activity";
            String string3 = "A receive incorrect message";
            em.a(context, string2, n10, string3);
        }
    }
}


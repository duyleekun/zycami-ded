/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.c;
import com.xiaomi.mipush.sdk.o;
import com.xiaomi.mipush.sdk.p;
import com.xiaomi.push.ai;
import com.xiaomi.push.eq;
import com.xiaomi.push.es;
import com.xiaomi.push.hr;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.l;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.ak$a;
import com.xiaomi.push.service.an;
import java.util.HashMap;
import java.util.Map;

public class n {
    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static void a(Context context, Intent object, Uri object2) {
        Object object3;
        block9: {
            void var2_4;
            block8: {
                boolean bl2;
                block7: {
                    Object object4;
                    if (context == null) {
                        return;
                    }
                    aq.a(context).a();
                    object3 = eq.a(context.getApplicationContext()).a();
                    if (object3 == null) {
                        object3 = eq.a(context.getApplicationContext());
                        object4 = b.a(context.getApplicationContext()).a();
                        String string2 = context.getPackageName();
                        Object object5 = ak.a(context.getApplicationContext());
                        int n10 = hr.aF.a();
                        int n11 = ((ak)object5).a(n10, 0);
                        c c10 = new c();
                        ((eq)object3).a((String)object4, string2, n11, c10);
                        object3 = ak.a(context);
                        int n12 = 102;
                        object5 = "awake online config";
                        object4 = new p(n12, (String)object5, context);
                        ((ak)object3).a((ak$a)object4);
                    }
                    bl2 = context instanceof Activity;
                    object4 = null;
                    if (!bl2 || object == null) break block7;
                    eq eq2 = eq.a(context.getApplicationContext());
                    object3 = es.a;
                    break block8;
                }
                bl2 = context instanceof Service;
                if (!bl2 || object == null) break block9;
                object3 = "com.xiaomi.mipush.sdk.WAKEUP";
                String string3 = object.getAction();
                boolean bl3 = ((String)object3).equals(string3);
                if (bl3) {
                    eq eq3 = eq.a(context.getApplicationContext());
                    object3 = es.c;
                } else {
                    eq eq4 = eq.a(context.getApplicationContext());
                    object3 = es.b;
                }
            }
            var2_4.a((es)((Object)object3), context, (Intent)object, null);
            return;
        }
        if (object2 == null) return;
        object = object2.toString();
        boolean bl4 = TextUtils.isEmpty((CharSequence)object);
        if (bl4) return;
        object = eq.a(context.getApplicationContext());
        object3 = es.d;
        String string4 = object2.toString();
        ((eq)object).a((es)((Object)object3), context, null, string4);
    }

    private static void a(Context context, il il2) {
        Object object = ak.a(context);
        int n10 = hr.aG.a();
        boolean bl2 = false;
        o o10 = null;
        boolean bl3 = ((ak)object).a(n10, false);
        Object object2 = ak.a(context);
        hr hr2 = hr.aH;
        int n11 = hr2.a();
        n10 = ((ak)object2).a(n11, 0);
        n11 = 30;
        if (n10 >= 0 && n10 < n11) {
            object2 = "aw_ping: frquency need > 30s.";
            com.xiaomi.channel.commonutils.logger.b.c((String)object2);
            n10 = n11;
        }
        if (n10 >= 0) {
            bl2 = bl3;
        }
        bl3 = l.a();
        if (!bl3) {
            n.a(context, il2, bl2, n10);
        } else if (bl2) {
            object = ai.a(context.getApplicationContext());
            o10 = new o(il2, context);
            ((ai)object).a(o10, n10);
        }
    }

    public static final void a(Context context, ix object, boolean bl2, int n10) {
        if ((object = (Object)iw.a((ix)object)) == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", bl2);
        intent.putExtra("extra_help_ping_frequency", n10);
        intent.putExtra("mipush_payload", (byte[])object);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        aq.a(context).a(intent);
    }

    public static void a(Context context, String object) {
        com.xiaomi.channel.commonutils.logger.b.a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("awake_info", (String)object);
        object = String.valueOf(9999);
        hashMap.put("event_type", (String)object);
        hashMap.put("description", "ping message");
        object = new il();
        String string2 = b.a(context).a();
        ((il)object).b(string2);
        string2 = context.getPackageName();
        ((il)object).d(string2);
        string2 = hw.H.a;
        ((il)object).c(string2);
        string2 = an.a();
        ((il)object).a(string2);
        ((il)object).a = hashMap;
        n.a(context, (il)object);
    }

    public static void a(Context context, String object, int n10, String string2) {
        il il2 = new il();
        il2.b((String)object);
        object = new HashMap();
        il2.a((Map)object);
        object = il2.a();
        String string3 = String.valueOf(n10);
        String string4 = "extra_aw_app_online_cmd";
        object.put(string4, string3);
        object = il2.a();
        string3 = "extra_help_aw_info";
        object.put(string3, string2);
        object = an.a();
        il2.a((String)object);
        object = iw.a(il2);
        if (object == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
            return;
        }
        string3 = new Intent();
        string3.setAction("action_aw_app_logic");
        string3.putExtra("mipush_payload", (byte[])object);
        aq.a(context).a((Intent)string3);
    }
}


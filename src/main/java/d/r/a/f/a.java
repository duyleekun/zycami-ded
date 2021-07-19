/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package d.r.a.f;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import d.r.a.g;
import d.r.a.h;
import d.r.a.o;
import d.r.a.u.d0;
import d.r.a.u.s;
import d.r.a.u.w;

public final class a {
    public static void a(Context object, Intent intent) {
        String string2 = "CommandBridge";
        if (object != null) {
            try {
                object.startService(intent);
                return;
            }
            catch (Exception exception) {
                s.b(string2, "start service error", exception);
                intent.setComponent(null);
                object.sendBroadcast(intent);
                return;
            }
        }
        s.m(string2, "enter startService context is null");
        object = new Exception("context is null");
        throw object;
    }

    public static void b(Context context, String object, o object2) {
        String string2;
        String string3;
        boolean bl2 = ((o)object2).c();
        Object object3 = bl2 ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice";
        object3 = h.a(context, (String)object3);
        ((h)object3).b = string3 = w.e(((h)object3).c);
        Object object4 = TextUtils.isEmpty((CharSequence)string3);
        int n10 = 0;
        Object object5 = null;
        if (object4 != 0) {
            string3 = ((h)object3).c;
            string2 = "push pkgname is null";
            s.l((Context)string3, string2);
        } else {
            long l10;
            string3 = ((h)object3).c;
            string2 = ((h)object3).b;
            long l11 = d0.a((Context)string3, string2);
            long l12 = l11 - (l10 = 1260L);
            object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 >= 0) {
                n10 = object4 = 1;
            }
            ((h)object3).a = n10;
        }
        string3 = ((o)object2).b;
        object4 = TextUtils.isEmpty((CharSequence)string3);
        if (object4 != 0) {
            ((o)object2).b = string3 = context.getPackageName();
        }
        string3 = "CommandBridge";
        if (n10 != 0 && (n10 = (int)((string2 = "com.vivo.pushservice").equals(object5 = context.getPackageName()) ? 1 : 0)) == 0) {
            string2 = ((o)object2).b;
            Bundle bundle = new Bundle();
            object5 = new g(string2, (String)object, bundle);
            ((o)object2).b((g)object5);
            object5 = ((g)object5).a;
            boolean bl3 = ((h)object3).e((Bundle)object5);
            if (bl3) {
                return;
            }
            object3 = "send command error by aidl";
            s.h(string3, (String)object3);
            s.l(context, (String)object3);
        }
        object5 = "com.vivo.pushservice.action.METHOD";
        object3 = new Intent((String)object5);
        object3.setPackage((String)object);
        String string4 = bl2 ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService";
        object3.setClassName((String)object, string4);
        object = g.a((Intent)object3);
        if (object == null) {
            object = "PushCommand";
            object2 = "bundleWapper is null";
            s.h((String)object, (String)object2);
        } else {
            ((o)object2).b((g)object);
            object = ((g)object).a;
            if (object != null) {
                object3.putExtras((Bundle)object);
            }
        }
        try {
            a.a(context, (Intent)object3);
            return;
        }
        catch (Exception exception) {
            s.b(string3, "CommandBridge startService exception: ", exception);
            return;
        }
    }

    public static boolean c(Context object, String string2, String string3) {
        Object object2;
        String string4;
        block10: {
            int n10;
            string4 = "CommandBridge";
            object2 = new Intent(string2);
            object2.setPackage(string3);
            try {
                object = object.getPackageManager();
                n10 = 576;
            }
            catch (Exception exception) {
                s.h(string4, "queryBroadcastReceivers error");
                return false;
            }
            object = object.queryBroadcastReceivers(object2, n10);
            if (object == null) break block10;
            int n11 = object.size();
            if (n11 <= 0) break block10;
            return true;
        }
        object2 = "action check error\uff1aaction>>";
        object = new StringBuilder((String)object2);
        ((StringBuilder)object).append(string2);
        string2 = ";pkgname>>";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        s.h(string4, (String)object);
        return false;
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package d.r.a.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import d.r.a.s.d$a;
import d.r.a.u.c;
import d.r.a.u.s;

public class d
extends BroadcastReceiver {
    private static HandlerThread a;
    private static Handler b;
    private static d$a c;

    static {
        d$a d$a;
        c = d$a = new d$a();
    }

    public void onReceive(Context context, Intent object) {
        context = d.r.a.u.c.c(context);
        Object object2 = "android.net.conn.CONNECTIVITY_CHANGE";
        boolean bl2 = ((String)object2).equals(object = object.getAction());
        if (bl2 || (bl2 = ((String)(object2 = "android.intent.action.ACTION_POWER_CONNECTED")).equals(object)) || (bl2 = ((String)(object2 = "android.intent.action.ACTION_POWER_DISCONNECTED")).equals(object))) {
            String string2;
            object2 = a;
            String string3 = "PushServiceReceiver";
            if (object2 == null) {
                object2 = new HandlerThread(string3);
                a = object2;
                object2.start();
                string2 = a.getLooper();
                object2 = new Handler((Looper)string2);
                b = object2;
            }
            object2 = new StringBuilder();
            string2 = context.getPackageName();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(": start PushSerevice for by ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("  ; handler : ");
            string2 = b;
            ((StringBuilder)object2).append((Object)string2);
            object2 = ((StringBuilder)object2).toString();
            s.m(string3, (String)object2);
            object2 = c;
            d$a.a((d$a)object2, context, (String)object);
            context = b;
            object = c;
            context.removeCallbacks((Runnable)object);
            context = b;
            object = c;
            long l10 = 2000L;
            context.postDelayed((Runnable)object, l10);
        }
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.os.Message
 */
package com.baidu.location.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.b.o;
import com.baidu.location.c.b$a;
import com.baidu.location.c.c;
import com.baidu.location.f;
import com.baidu.location.h.l;

public class b {
    private static b a;
    private boolean b = false;
    private Handler c = null;
    private AlarmManager d = null;
    private b$a e = null;
    private PendingIntent f = null;
    private long g = 0L;

    private b() {
    }

    public static /* synthetic */ PendingIntent a(b b10, PendingIntent pendingIntent) {
        b10.f = pendingIntent;
        return pendingIntent;
    }

    public static b a() {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            b b10 = a;
            if (b10 == null) {
                a = b10 = new b();
            }
            b10 = a;
            return b10;
        }
    }

    public static /* synthetic */ void a(b b10) {
        b10.f();
    }

    public static /* synthetic */ void b(b b10) {
        b10.g();
    }

    public static /* synthetic */ boolean c(b b10) {
        return b10.b;
    }

    public static /* synthetic */ Handler d(b b10) {
        return b10.c;
    }

    private void f() {
        long l10;
        int n10;
        Object object;
        long l11 = System.currentTimeMillis();
        long l12 = this.g;
        long l13 = (l11 -= l12) - (l12 = 1000L);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 < 0) {
            return;
        }
        PendingIntent pendingIntent = this.f;
        if (pendingIntent != null) {
            object = this.d;
            object.cancel(pendingIntent);
            object2 = 0;
            pendingIntent = null;
            this.f = null;
        }
        if ((pendingIntent = this.f) == null) {
            pendingIntent = com.baidu.location.f.getServiceContext();
            String string2 = "com.baidu.location.autonotifyloc_8.4.0";
            object = new Intent(string2);
            int n11 = 0x8000000;
            n10 = 0;
            this.f = pendingIntent = PendingIntent.getBroadcast((Context)pendingIntent, (int)0, (Intent)object, (int)n11);
            pendingIntent = this.d;
            l10 = System.currentTimeMillis();
            int n12 = l.Z;
            long l14 = n12;
            PendingIntent pendingIntent2 = this.f;
            pendingIntent.set(0, l10 += l14, pendingIntent2);
        }
        pendingIntent = new Message();
        pendingIntent.what = 22;
        l10 = System.currentTimeMillis();
        long l15 = this.g;
        n10 = l.aa;
        long l16 = (l10 -= l15) - (l15 = (long)n10);
        Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object3 < 0) {
            return;
        }
        this.g = l10 = System.currentTimeMillis();
        object = com.baidu.location.f.f.a();
        object3 = ((com.baidu.location.f.f)object).k();
        if (object3 == false) {
            object = o.c();
            ((o)object).b((Message)pendingIntent);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        bl2 = false;
        try {
            PendingIntent pendingIntent = this.f;
            if (pendingIntent != null) {
                AlarmManager alarmManager = this.d;
                alarmManager.cancel(pendingIntent);
                this.f = null;
            }
            pendingIntent = com.baidu.location.f.getServiceContext();
            b$a b$a = this.e;
            pendingIntent.unregisterReceiver((BroadcastReceiver)b$a);
        }
        catch (Exception exception) {}
        this.d = null;
        this.e = null;
        this.c = null;
        this.b = false;
    }

    public void b() {
        int n10 = this.b;
        if (n10 != 0) {
            return;
        }
        n10 = l.Z;
        int n11 = 10000;
        if (n10 >= n11) {
            long l10;
            Object object = this.c;
            if (object == null) {
                this.c = object = new c(this);
            }
            object = (AlarmManager)com.baidu.location.f.getServiceContext().getSystemService("alarm");
            this.d = object;
            n11 = 0;
            object = new b$a(this, null);
            this.e = object;
            object = com.baidu.location.f.getServiceContext();
            b$a b$a = this.e;
            String string2 = "com.baidu.location.autonotifyloc_8.4.0";
            IntentFilter intentFilter = new IntentFilter(string2);
            String string3 = "android.permission.ACCESS_FINE_LOCATION";
            object.registerReceiver((BroadcastReceiver)b$a, intentFilter, string3, null);
            object = com.baidu.location.f.getServiceContext();
            Intent intent = new Intent(string2);
            int n12 = 0x8000000;
            intentFilter = null;
            object = PendingIntent.getBroadcast((Context)object, (int)0, (Intent)intent, (int)n12);
            this.f = object;
            object = this.d;
            long l11 = System.currentTimeMillis();
            int n13 = l.Z;
            long l12 = n13;
            string2 = this.f;
            object.set(0, l11 += l12, (PendingIntent)string2);
            n10 = 1;
            this.b = n10;
            this.g = l10 = System.currentTimeMillis();
        }
    }

    public void c() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        Handler handler = this.c;
        if (handler != null) {
            int n10 = 2;
            handler.sendEmptyMessage(n10);
        }
    }

    public void d() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        Handler handler = this.c;
        if (handler != null) {
            int n10 = 1;
            handler.sendEmptyMessage(n10);
        }
    }

    public void e() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        Handler handler = this.c;
        if (handler != null) {
            int n10 = 1;
            handler.sendEmptyMessage(n10);
        }
    }
}


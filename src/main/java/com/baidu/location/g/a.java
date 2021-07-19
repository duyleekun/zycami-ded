/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.Process
 *  android.util.Log
 */
package com.baidu.location.g;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.location.LLSInterface;
import com.baidu.location.b.aa;
import com.baidu.location.b.ac;
import com.baidu.location.b.ad;
import com.baidu.location.b.c;
import com.baidu.location.b.k;
import com.baidu.location.b.o;
import com.baidu.location.b.t;
import com.baidu.location.b.z;
import com.baidu.location.c.d;
import com.baidu.location.c.e;
import com.baidu.location.e.h;
import com.baidu.location.f;
import com.baidu.location.f.i;
import com.baidu.location.g.a$a;
import com.baidu.location.g.b;
import com.baidu.location.h.l;
import com.baidu.location.indoor.g;
import java.lang.ref.WeakReference;

public class a
extends Service
implements LLSInterface {
    public static a$a a;
    public static long c;
    private static long g;
    public Messenger b = null;
    private Looper d = null;
    private HandlerThread e = null;
    private boolean f;
    private int h;
    private boolean i;

    public a() {
        boolean bl2;
        this.f = bl2 = true;
        this.h = 0;
        this.i = bl2;
    }

    public static /* synthetic */ int a(a a10) {
        return a10.h;
    }

    public static Handler a() {
        return a;
    }

    private void a(Message object) {
        com.baidu.location.b.b b10 = com.baidu.location.b.b.a();
        b10.a((Message)object);
        com.baidu.location.e.h.a();
        object = com.baidu.location.c.e.a();
        ((e)object).d();
        boolean bl2 = l.b();
        if (!bl2) {
            object = t.a();
            ((t)object).c();
        }
    }

    public static /* synthetic */ void a(a a10, Message message) {
        a10.a(message);
    }

    public static /* synthetic */ boolean a(a a10, boolean bl2) {
        a10.i = bl2;
        return bl2;
    }

    public static long b() {
        return g;
    }

    private void b(Message message) {
        com.baidu.location.b.b.a().b(message);
    }

    public static /* synthetic */ void b(a a10) {
        a10.d();
    }

    public static /* synthetic */ void b(a a10, Message message) {
        a10.b(message);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        Object object = com.baidu.location.a.a.a();
        Context context = com.baidu.location.f.getServiceContext();
        ((com.baidu.location.a.a)object).a(context);
        object = com.baidu.location.c.e.a();
        ((e)object).b();
        com.baidu.location.h.b.a();
        try {
            object = ad.a();
            ((ad)object).e();
        }
        catch (Exception exception) {}
        k.a().b();
        com.baidu.location.f.f.a().b();
        com.baidu.location.f.b.a().b();
        o.c().d();
        com.baidu.location.e.a.a().c();
        com.baidu.location.c.d.a().b();
        com.baidu.location.c.g.a().b();
        com.baidu.location.c.a.a().b();
        com.baidu.location.f.i.a().c();
        this.h = 2;
    }

    private void c(Message message) {
        com.baidu.location.b.b.a().c(message);
    }

    public static /* synthetic */ void c(a a10) {
        a10.c();
    }

    public static /* synthetic */ void c(a a10, Message message) {
        a10.c(message);
    }

    private void d() {
        com.baidu.location.f.f.a().e();
        com.baidu.location.f.i.a().e();
        com.baidu.location.e.h.a().n();
        ad.a().f();
        com.baidu.location.c.e.a().c();
        com.baidu.location.c.d.a().c();
        com.baidu.location.c.b.a().c();
        com.baidu.location.c.a.a().c();
        com.baidu.location.b.c.a().b();
        com.baidu.location.f.b.a().c();
        o.c().e();
        com.baidu.location.indoor.g.a().d();
        Object object = k.a();
        ((k)object).c();
        int n10 = this.i;
        if (n10 != 0) {
            ac.d();
        }
        object = com.baidu.location.b.b.a();
        ((com.baidu.location.b.b)object).b();
        object = aa.a();
        try {
            ((aa)object).d();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.h = 4;
        object = "baidu_location_service";
        String string2 = "baidu location service has stoped ...";
        Log.d((String)object, (String)string2);
        n10 = this.f;
        if (n10 == 0) {
            n10 = Process.myPid();
            Process.killProcess((int)n10);
        }
    }

    public double getVersion() {
        return 8.4f;
    }

    public IBinder onBind(Intent object) {
        boolean bl2;
        if ((object = object.getExtras()) != null) {
            boolean bl3;
            com.baidu.location.h.b.h = object.getString("key");
            com.baidu.location.h.b.g = object.getString("sign");
            this.f = bl3 = object.getBoolean("kill_process");
            String string2 = "cache_exception";
            bl2 = object.getBoolean(string2);
        } else {
            bl2 = false;
            object = null;
        }
        if (!bl2) {
            object = com.baidu.location.c.g.a();
            Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)object);
        }
        return this.b.getBinder();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCreate(Context object) {
        long l10;
        try {
            l.az = object = object.getPackageName();
        }
        catch (Exception exception) {}
        g = l10 = System.currentTimeMillis();
        object = z.a();
        this.e = object;
        if (object != null) {
            object = object.getLooper();
            this.d = object;
        }
        if ((object = this.d) == null) {
            Looper looper = Looper.getMainLooper();
            object = new a$a(looper, this);
        } else {
            Looper looper = this.d;
            object = new a$a(looper, this);
        }
        a = object;
        c = System.currentTimeMillis();
        a$a a$a = a;
        object = new Messenger((Handler)a$a);
        this.b = object;
        a.sendEmptyMessage(0);
        this.h = 1;
        object = new StringBuilder();
        ((StringBuilder)object).append("baidu location service start1 ...20200421...");
        int n10 = Process.myPid();
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        Log.d((String)"baidu_location_service", (String)object);
    }

    public void onDestroy() {
        String string2 = "baidu_location_service";
        a$a a$a = a;
        int n10 = 1;
        try {
            a$a.sendEmptyMessage(n10);
        }
        catch (Exception exception) {
            Log.d((String)string2, (String)"baidu location service stop exception...");
            a$a = null;
            this.i = false;
            this.d();
            int n11 = Process.myPid();
            Process.killProcess((int)n11);
        }
        this.h = 3;
        Object object = Looper.getMainLooper();
        a$a = new Handler(object);
        object = new WeakReference(this);
        b b10 = new b(this, (WeakReference)object);
        a$a.postDelayed(b10, 1000L);
        Log.d((String)string2, (String)"baidu location service stop ...");
    }

    public int onStartCommand(Intent intent, int n10, int n11) {
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        Log.d((String)"baidu_location_service", (String)"baidu location service remove task...");
    }

    public boolean onUnBind(Intent intent) {
        return false;
    }
}


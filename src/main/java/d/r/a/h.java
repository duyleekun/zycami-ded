/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.IBinder
 *  android.os.Looper
 *  android.text.TextUtils
 */
package d.r.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import d.r.a.h$a;
import d.r.a.u.d0;
import d.r.a.u.s;
import d.r.a.u.w;
import d.r.b.b;
import d.r.b.b$b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class h
implements ServiceConnection {
    private static final Object i;
    private static Map j;
    public boolean a;
    public String b;
    public Context c;
    private AtomicInteger d;
    private volatile b e;
    private Object f;
    private String g;
    private Handler h;

    static {
        HashMap hashMap = new HashMap();
        i = hashMap;
        j = hashMap = new HashMap();
    }

    private h(Context context, String object) {
        Object object2;
        String string2 = null;
        this.b = null;
        this.f = object2 = new Object();
        this.h = null;
        this.c = context;
        this.g = object;
        int n10 = 1;
        this.d = object = new AtomicInteger(n10);
        object2 = Looper.getMainLooper();
        h$a h$a = new h$a(this);
        object = new Handler((Looper)object2, (Handler.Callback)h$a);
        this.h = object;
        this.b = object = w.e(context);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        object2 = null;
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.g)))) {
            long l10;
            object = this.b;
            long l11 = d0.a(context, (String)object);
            long l12 = l11 - (l10 = 1260L);
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 < 0) {
                n10 = 0;
                string2 = null;
            }
            this.a = n10;
            this.c();
            return;
        }
        context = this.c;
        object = new StringBuilder("init error : push pkgname is ");
        string2 = this.b;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" ; action is ");
        string2 = this.g;
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        s.l(context, (String)object);
        this.a = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h a(Context object, String string2) {
        Object object2 = (h)j.get(string2);
        if (object2 != null) return object2;
        Object object3 = i;
        synchronized (object3) {
            object2 = j;
            object2 = object2.get(string2);
            object2 = (h)object2;
            if (object2 != null) return object2;
            object2 = new h((Context)object, string2);
            object = j;
            object.put(string2, object2);
            return object2;
        }
    }

    public static /* synthetic */ AtomicInteger b(h h10) {
        return h10.d;
    }

    private void c() {
        int n10;
        AtomicInteger atomicInteger = this.d;
        int n11 = atomicInteger.get();
        CharSequence charSequence = new StringBuilder("Enter connect, Connection Status: ");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        String string2 = "AidlManager";
        s.m(string2, (String)charSequence);
        int n12 = 4;
        if (n11 != n12 && n11 != (n12 = 2) && n11 != (n10 = 3) && n11 != (n10 = 5) && (n11 = (int)(this.a ? 1 : 0)) != 0) {
            this.d(n12);
            n11 = (int)(this.g() ? 1 : 0);
            n12 = 1;
            if (n11 == 0) {
                this.d(n12);
                s.a(string2, "bind core service fail");
                return;
            }
            this.h.removeMessages(n12);
            atomicInteger = this.h;
            long l10 = 3000L;
            atomicInteger.sendEmptyMessageDelayed(n12, l10);
        }
    }

    private void d(int n10) {
        this.d.set(n10);
    }

    public static /* synthetic */ void f(h h10) {
        h10.d(1);
    }

    private boolean g() {
        int n10;
        String string2 = this.g;
        Intent intent = new Intent(string2);
        string2 = this.b;
        intent.setPackage(string2);
        try {
            string2 = this.c;
            n10 = 1;
        }
        catch (Exception exception) {
            s.b("AidlManager", "bind core error", exception);
            return false;
        }
        return string2.bindService(intent, (ServiceConnection)this, n10);
    }

    private void h() {
        this.h.removeMessages(1);
    }

    public static /* synthetic */ void i(h h10) {
        h10.j();
    }

    private void j() {
        Context context;
        try {
            context = this.c;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("On unBindServiceException:");
            String string2 = exception.getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            s.a("AidlManager", string2);
            return;
        }
        context.unbindService((ServiceConnection)this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean e(Bundle object) {
        int n10;
        int n11;
        block13: {
            this.c();
            Object object2 = this.d;
            n11 = ((AtomicInteger)object2).get();
            n10 = 2;
            if (n11 == n10) {
                object2 = this.f;
                synchronized (object2) {
                    Throwable throwable2;
                    block12: {
                        try {
                            try {
                                Object object3 = this.f;
                                long l10 = 2000L;
                                object3.wait(l10);
                            }
                            catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }
                        catch (Throwable throwable2) {
                            break block12;
                        }
                        break block13;
                    }
                    throw throwable2;
                }
            }
        }
        n11 = 4;
        int n12 = 1;
        try {
            Object object4 = this.d;
            int n13 = ((AtomicInteger)object4).get();
            if (n13 == n11) {
                object4 = this.h;
                object4.removeMessages(n10);
                object4 = this.h;
                long l11 = 30000L;
                object4.sendEmptyMessageDelayed(n10, l11);
                object4 = this.e;
                Object var13_16 = null;
                object4.k((Bundle)object, null);
                return n12 != 0;
            }
            object = "AidlManager";
            String string2 = "invoke error : connect status = ";
            StringBuilder stringBuilder = new StringBuilder(string2);
            stringBuilder.append(n13);
            object4 = stringBuilder.toString();
            s.m((String)object, (String)object4);
            return false;
        }
        catch (Exception exception) {
            s.b("AidlManager", "invoke error ", exception);
            AtomicInteger atomicInteger = this.d;
            int n14 = atomicInteger.get();
            String string3 = "AidlManager";
            String string4 = "Enter disconnect, Connection Status: ";
            CharSequence charSequence = new StringBuilder(string4);
            charSequence.append(n14);
            charSequence = charSequence.toString();
            s.m(string3, (String)charSequence);
            if (n14 != n10) {
                n10 = 3;
                if (n14 == n10) {
                    this.d(n12);
                    return false;
                }
                if (n14 != n11) {
                    return false;
                }
                this.d(n12);
                this.j();
                return false;
            }
            this.h();
            this.d(n12);
        }
        return false;
    }

    public final void onBindingDied(ComponentName object) {
        StringBuilder stringBuilder = new StringBuilder("onBindingDied : ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        s.h("AidlManager", (String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onServiceConnected(ComponentName object, IBinder object2) {
        this.h();
        object = b$b.o((IBinder)object2);
        this.e = object;
        object = this.e;
        if (object == null) {
            s.m("AidlManager", "onServiceConnected error : aidl must not be null.");
            this.j();
            this.d.set(1);
            return;
        }
        object = this.d;
        int n10 = ((AtomicInteger)object).get();
        int n11 = 2;
        int n12 = 4;
        if (n10 == n11) {
            this.d(n12);
        } else {
            object = this.d;
            n10 = ((AtomicInteger)object).get();
            if (n10 != n12) {
                this.j();
            }
        }
        object = this.f;
        synchronized (object) {
            object2 = this.f;
            object2.notifyAll();
            return;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.e = null;
        this.d(1);
    }
}


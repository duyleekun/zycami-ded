/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.net.ConnectivityManager
 *  android.net.Uri
 */
package com.baidu.location.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.baidu.location.b.aa;
import com.baidu.location.e.c;
import com.baidu.location.e.h$a;
import com.baidu.location.e.h$b;
import com.baidu.location.e.h$c;
import com.baidu.location.e.i;
import com.baidu.location.e.j;
import com.baidu.location.e.k;
import com.baidu.location.e.l;
import com.baidu.location.f;
import com.baidu.location.f.a;
import com.baidu.location.h.b;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class h {
    public static final String a;
    public static final String b = "http://ofloc.map.baidu.com/offline_loc";
    private static Context c;
    private static volatile h d;
    private static Object e;
    private final File f;
    private final k g;
    private final c h;
    private final l i;
    private final com.baidu.location.e.f j;

    static {
        Object object;
        e = object = new Object();
        a = com.baidu.location.h.a.a;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private h() {
        boolean bl2 = false;
        Object object = null;
        Object object2 = c;
        object2 = object2.getFilesDir();
        String string2 = "ofld";
        Object object3 = new File((File)object2, string2);
        {
            catch (Exception exception) {}
        }
        try {
            bl2 = ((File)object3).exists();
            if (!bl2) {
                ((File)object3).mkdir();
            }
        }
        catch (Exception exception) {
            object = object3;
            object3 = object;
        }
        this.f = object3;
        object = new c(this);
        this.h = object;
        object2 = ((c)object).a();
        this.g = object3 = new k((SQLiteDatabase)object2);
        object2 = ((c)object).a();
        this.j = object3 = new com.baidu.location.e.f(this, (SQLiteDatabase)object2);
        object = ((c)object).a();
        int n10 = ((com.baidu.location.e.f)object3).n();
        super(this, (SQLiteDatabase)object, n10);
        this.i = object2;
    }

    private BDLocation a(String[] object) {
        new BDLocation();
        Object object2 = aa.a().c();
        i i10 = new i(this, (String[])object);
        object = (FutureTask)object2.submit(i10);
        long l10 = 2000L;
        Object object3 = null;
        boolean bl2 = true;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        object2 = ((FutureTask)object).get(l10, timeUnit);
        try {
            object3 = object2 = (BDLocation)object2;
        }
        catch (InterruptedException | ExecutionException | TimeoutException exception) {
            ((FutureTask)object).cancel(bl2);
        }
        return object3;
    }

    public static /* synthetic */ com.baidu.location.e.f a(h h10) {
        return h10.j;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h a() {
        Object object = e;
        synchronized (object) {
            h h10 = d;
            if (h10 == null) {
                h10 = c;
                if (h10 == null) {
                    h10 = com.baidu.location.f.getServiceContext();
                    com.baidu.location.e.h.a((Context)h10);
                }
                d = h10 = new h();
            }
            h10 = d;
            h10.q();
            return d;
        }
    }

    public static void a(Context object) {
        Context context = c;
        if (context == null) {
            c = object;
            object = com.baidu.location.h.b.a();
            context = c;
            ((b)object).a(context);
        }
    }

    public static /* synthetic */ Uri b(String string2) {
        return com.baidu.location.e.h.c(string2);
    }

    public static /* synthetic */ c b(h h10) {
        return h10.h;
    }

    private static final Uri c(String string2) {
        Object[] objectArray = new Object[]{string2};
        return Uri.parse((String)String.format("content://%s/", objectArray));
    }

    public static /* synthetic */ Context p() {
        return c;
    }

    private void q() {
        this.j.g();
    }

    private boolean r() {
        boolean bl2;
        int n10;
        String string2 = c.getPackageName();
        Object object = this.j.o();
        boolean bl3 = false;
        Context context = null;
        for (int i10 = 0; i10 < (n10 = ((String[])object).length); ++i10) {
            context = c;
            context = context.getPackageManager();
            String string3 = object[i10];
            try {
                context = context.resolveContentProvider(string3, 0);
            }
            catch (Exception exception) {
                context = null;
            }
            if (context != null) break;
        }
        if (context == null || (bl2 = string2.equals(object = context.packageName))) {
            bl3 = true;
        }
        return bl3;
    }

    public long a(String string2) {
        return this.j.a(string2);
    }

    public BDLocation a(a stringArray, com.baidu.location.f.h object, BDLocation bDLocation, h$b object2, h$a h$a) {
        Object object3;
        int n10;
        Object object4 = h$b.a;
        if (object2 == object4) {
            object2 = this.j;
            n10 = ((com.baidu.location.e.f)object2).a();
            object4 = new StringBuilder();
            object3 = com.baidu.location.h.b.a().d();
            ((StringBuilder)object4).append((String)object3);
            object3 = "&mixMode=1";
            ((StringBuilder)object4).append((String)object3);
            object4 = ((StringBuilder)object4).toString();
        } else {
            n10 = 0;
            object2 = null;
            object4 = com.baidu.location.h.b.a().d();
        }
        int n11 = n10;
        h$b h$b = object4;
        object2 = h$a.a;
        object2 = h$a == object2 ? Boolean.TRUE : Boolean.FALSE;
        boolean bl2 = (Boolean)object2;
        object3 = stringArray;
        stringArray = com.baidu.location.e.j.a((a)stringArray, (com.baidu.location.f.h)object, bDLocation, (String)((Object)h$b), bl2, n11);
        object = null;
        int n12 = stringArray.length;
        if (n12 > 0 && (object = this.a(stringArray)) != null) {
            ((BDLocation)object).getLocType();
        }
        return object;
    }

    public Context b() {
        return c;
    }

    public File c() {
        return this.f;
    }

    public boolean d() {
        return this.j.h();
    }

    public boolean e() {
        return this.j.i();
    }

    public boolean f() {
        return this.j.j();
    }

    public boolean g() {
        return this.j.k();
    }

    public boolean h() {
        return this.j.m();
    }

    public void i() {
        boolean bl2 = com.baidu.location.h.l.b();
        if (!bl2) {
            k k10 = this.g;
            k10.a();
        }
    }

    public k j() {
        return this.g;
    }

    public l k() {
        return this.i;
    }

    public com.baidu.location.e.f l() {
        return this.j;
    }

    public void m() {
        boolean bl2 = this.r();
        if (bl2 && !(bl2 = com.baidu.location.h.l.b())) {
            c c10 = this.h;
            c10.b();
        }
    }

    public void n() {
    }

    public double o() {
        Object object;
        int n10;
        int n11;
        Object object2 = c;
        Object object3 = "connectivity";
        object2 = (ConnectivityManager)object2.getSystemService(object3);
        try {
            object2 = object2.getActiveNetworkInfo();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            n11 = 0;
            object2 = null;
        }
        object3 = h$c.a;
        if (object2 != null && (n10 = object2.isConnected()) != 0) {
            int n12;
            n10 = object2.getType();
            object = n10 == (n12 = 1) ? h$c.b : object3;
            int n13 = object2.getType();
            if (n13 == 0) {
                n11 = object2.getSubtype();
                if (n11 != n12 && n11 != (n12 = 2) && n11 != (n12 = 4) && n11 != (n12 = 7) && n11 != (n12 = 11)) {
                    n12 = 3;
                    if (n11 != n12 && n11 != (n12 = 5) && n11 != (n12 = 6) && n11 != (n12 = 8) && n11 != (n12 = 9) && n11 != (n12 = 10) && n11 != (n12 = 12) && n11 != (n12 = 14) && n11 != (n12 = 15)) {
                        n12 = 13;
                        if (n11 == n12) {
                            object = h$c.e;
                        }
                    } else {
                        object = h$c.d;
                    }
                } else {
                    object = h$c.c;
                }
            }
        } else {
            object = object3;
        }
        double d10 = 0.0;
        if (object == object3) {
            object2 = this.j;
            d10 = object2.b();
        } else {
            object2 = h$c.b;
            if (object == object2) {
                object2 = this.j;
                d10 = object2.c();
            } else {
                object2 = h$c.c;
                if (object == object2) {
                    object2 = this.j;
                    d10 = object2.d();
                } else {
                    object2 = h$c.d;
                    if (object == object2) {
                        object2 = this.j;
                        d10 = object2.e();
                    } else {
                        object2 = h$c.e;
                        if (object == object2) {
                            object2 = this.j;
                            d10 = object2.f();
                        }
                    }
                }
            }
        }
        return d10;
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.res.AssetManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.util.SparseArray
 */
package l.a;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import l.a.c$a;
import l.a.c$b;
import l.a.c$c;
import l.a.e.a;
import l.a.e.g;
import l.a.e.h;
import l.a.m.b;
import l.a.m.d;
import l.a.o.e;

public class c
extends l.a.n.a {
    public static final int l = 255;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 2;
    private static volatile c p;
    private final Object b;
    private final Context c;
    private boolean d;
    private List e;
    private List f;
    private List g;
    private SparseArray h;
    private boolean i;
    private boolean j;
    private boolean k;

    private c(Context context) {
        boolean bl2;
        SparseArray sparseArray;
        Object object;
        this.b = object = new Object();
        this.d = false;
        this.e = sparseArray = new ArrayList();
        this.f = sparseArray = new ArrayList();
        this.g = sparseArray = new ArrayList();
        this.h = sparseArray = new SparseArray();
        this.i = bl2 = true;
        this.j = false;
        this.k = bl2;
        this.c = context = context.getApplicationContext();
        this.x();
    }

    public static c L(Application application) {
        l.a.c.w((Context)application);
        a.g(application);
        return p;
    }

    public static /* synthetic */ Object g(c c10) {
        return c10.b;
    }

    public static /* synthetic */ boolean h(c c10) {
        return c10.d;
    }

    public static /* synthetic */ boolean i(c c10, boolean bl2) {
        c10.d = bl2;
        return bl2;
    }

    public static /* synthetic */ Context j(c c10) {
        return c10.c;
    }

    public static c r() {
        return p;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c w(Context context) {
        Object object = p;
        if (object == null) {
            object = c.class;
            synchronized (object) {
                c c10 = p;
                if (c10 == null) {
                    p = c10 = new c(context);
                }
            }
        }
        l.a.o.e.f(context);
        return p;
    }

    private void x() {
        SparseArray sparseArray = this.h;
        c$c c$c = new l.a.m.c();
        sparseArray.put(-1, (Object)c$c);
        sparseArray = this.h;
        c$c = new l.a.m.a();
        sparseArray.put(0, (Object)c$c);
        sparseArray = this.h;
        c$c = new b();
        sparseArray.put(1, (Object)c$c);
        sparseArray = this.h;
        c$c = new d();
        sparseArray.put(2, (Object)c$c);
    }

    public boolean A() {
        return this.k;
    }

    public AsyncTask B() {
        String string2 = l.a.o.e.b().c();
        e e10 = l.a.o.e.b();
        int n10 = e10.d();
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 == 0 && n10 != (n11 = -1)) {
            return this.F(string2, null, n10);
        }
        return null;
    }

    public AsyncTask C(String string2) {
        return this.E(string2, null);
    }

    public AsyncTask D(String string2, int n10) {
        return this.F(string2, null, n10);
    }

    public AsyncTask E(String string2, c$b c$b) {
        return this.F(string2, c$b, 0);
    }

    public AsyncTask F(String string2, c$b object, int n10) {
        Object object2 = this.h;
        Object[] objectArray = (Object[])object2.get(n10);
        if (objectArray == null) {
            return null;
        }
        object2 = new c$a(this, (c$b)object, (c$c)objectArray);
        object = AsyncTask.THREAD_POOL_EXECUTOR;
        objectArray = new String[]{string2};
        return object2.executeOnExecutor((Executor)object, objectArray);
    }

    public AsyncTask G(c$b c$b) {
        String string2 = l.a.o.e.b().c();
        e e10 = l.a.o.e.b();
        int n10 = e10.d();
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 == 0 && n10 != (n11 = -1)) {
            return this.F(string2, c$b, n10);
        }
        return null;
    }

    public void H() {
        this.D("", -1);
    }

    public c I(boolean bl2) {
        this.i = bl2;
        return this;
    }

    public c J(boolean bl2) {
        this.j = bl2;
        return this;
    }

    public c K(boolean bl2) {
        this.k = bl2;
        return this;
    }

    public c k(g g10) {
        this.g.add(g10);
        return this;
    }

    public c l(g g10) {
        boolean bl2 = g10 instanceof h;
        if (bl2) {
            List list = this.e;
            Object object = g10;
            object = (h)((Object)g10);
            list.add(object);
        }
        this.f.add(g10);
        return this;
    }

    public c m(c$c c$c) {
        SparseArray sparseArray = this.h;
        int n10 = c$c.getType();
        sparseArray.put(n10, (Object)c$c);
        return this;
    }

    public Context n() {
        return this.c;
    }

    public String o() {
        return l.a.o.e.b().c();
    }

    public List p() {
        return this.g;
    }

    public List q() {
        return this.f;
    }

    public String s(String string2) {
        return this.c.getPackageManager().getPackageArchiveInfo((String)string2, (int)1).packageName;
    }

    public Resources t(String string2) {
        Context context;
        try {
            context = this.c;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        context = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        context = context.getPackageArchiveInfo(string2, 0);
        applicationInfo = context.applicationInfo;
        applicationInfo.sourceDir = string2;
        applicationInfo.publicSourceDir = string2;
        string2 = this.c;
        string2 = string2.getPackageManager();
        context = context.applicationInfo;
        string2 = string2.getResourcesForApplication((ApplicationInfo)context);
        context = this.c;
        context = context.getResources();
        string2 = string2.getAssets();
        DisplayMetrics displayMetrics = context.getDisplayMetrics();
        context = context.getConfiguration();
        applicationInfo = new Resources((AssetManager)string2, displayMetrics, (Configuration)context);
        return applicationInfo;
    }

    public SparseArray u() {
        return this.h;
    }

    public List v() {
        return this.e;
    }

    public boolean y() {
        return this.i;
    }

    public boolean z() {
        return this.j;
    }
}


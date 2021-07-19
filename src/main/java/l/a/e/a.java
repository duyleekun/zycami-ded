/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory2
 */
package l.a.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import l.a.c;
import l.a.d.f;
import l.a.e.a$a;
import l.a.e.e;
import l.a.j.a.d;
import l.a.n.b;
import l.a.q.j;
import l.a.q.z;

public class a
implements Application.ActivityLifecycleCallbacks {
    private static final String d = "SkinActivityLifecycle";
    private static volatile a e;
    private WeakHashMap a;
    private WeakHashMap b;
    private WeakReference c;

    private a(Application object) {
        object.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
        this.h((Context)object);
        c c10 = l.a.c.r();
        object = this.e((Context)object);
        c10.a((b)object);
    }

    public static /* synthetic */ WeakReference a(a a10) {
        return a10.c;
    }

    public static /* synthetic */ boolean b(a a10, Context context) {
        return a10.i(context);
    }

    public static /* synthetic */ void c(a a10, Activity activity) {
        a10.j(activity);
    }

    public static /* synthetic */ e d(a a10, Context context) {
        return a10.f(context);
    }

    private a$a e(Context context) {
        WeakHashMap weakHashMap = this.b;
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
            this.b = weakHashMap;
        }
        if ((weakHashMap = (a$a)this.b.get(context)) == null) {
            weakHashMap = new a$a(this, context);
            WeakHashMap weakHashMap2 = this.b;
            weakHashMap2.put(context, weakHashMap);
        }
        return weakHashMap;
    }

    private e f(Context context) {
        WeakHashMap weakHashMap = this.a;
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
            this.a = weakHashMap;
        }
        if ((weakHashMap = (e)this.a.get(context)) == null) {
            weakHashMap = l.a.e.e.b(context);
            WeakHashMap weakHashMap2 = this.a;
            weakHashMap2.put(context, weakHashMap);
        }
        return weakHashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a g(Application application) {
        Object object = e;
        if (object != null) return e;
        object = a.class;
        synchronized (object) {
            a a10 = e;
            if (a10 != null) return e;
            e = a10 = new a(application);
            return e;
        }
    }

    private void h(Context object) {
        Object object2 = LayoutInflater.from((Context)object);
        object = this.f((Context)object);
        try {
            l.a.p.a.d(object2, (LayoutInflater.Factory2)object);
        }
        catch (Throwable throwable) {
            object = "SkinActivity";
            object2 = "A factory has already been set on this LayoutInflater";
            l.a.o.f.b((String)object, (String)object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean i(Context context) {
        Object object = l.a.c.r();
        boolean bl2 = ((c)object).y();
        if (bl2) return true;
        object = context.getClass();
        Class<f> clazz = f.class;
        if ((object = ((Class)object).getAnnotation(clazz)) != null) return true;
        boolean bl3 = context instanceof z;
        if (!bl3) return false;
        return true;
    }

    private void j(Activity activity) {
        int n10;
        c c10 = l.a.c.r();
        int n11 = c10.A();
        if (n11 != 0 && (n10 = j.b(n11 = l.a.j.a.e.h((Context)activity))) != 0 && (c10 = l.a.j.a.d.g((Context)activity, n11)) != null) {
            activity = activity.getWindow();
            activity.setBackgroundDrawable((Drawable)c10);
        }
    }

    public void onActivityCreated(Activity object, Bundle bundle) {
        boolean bl2 = this.i((Context)object);
        if (bl2) {
            this.h((Context)object);
            this.j((Activity)object);
            bl2 = object instanceof z;
            if (bl2) {
                object = (z)object;
                object.e();
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        boolean bl2 = this.i((Context)activity);
        if (bl2) {
            Object object = l.a.c.r();
            a$a a$a = this.e((Context)activity);
            ((l.a.n.a)object).c(a$a);
            this.b.remove(activity);
            object = this.a;
            ((WeakHashMap)object).remove(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity object) {
        Object object2 = new WeakReference(object);
        this.c = object2;
        boolean bl2 = this.i((Context)object);
        if (bl2) {
            object = this.e((Context)object);
            object2 = l.a.c.r();
            ((l.a.n.a)object2).a((b)object);
            ((a$a)object).c();
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}


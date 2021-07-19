/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$AppTask
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 */
package d.v.e;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import d.v.e.b$a;
import d.v.e.b$b;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class b
implements Application.ActivityLifecycleCallbacks {
    private static b e;
    private final Stack a;
    private b$a b;
    private ArrayList c;
    private int d;

    private b() {
        AbstractList abstractList;
        this.a = abstractList = new AbstractList();
        this.c = abstractList;
        this.d = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b i() {
        Object object = e;
        if (object != null) return e;
        object = b.class;
        synchronized (object) {
            b b10 = e;
            if (b10 != null) return e;
            e = b10 = new b();
            return e;
        }
    }

    public void a(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            Stack stack = this.a;
            stack.add(fragmentActivity);
        }
    }

    public void b(b$b b$b) {
        ArrayList arrayList = this.c;
        if (arrayList == null) {
            this.c = arrayList = new ArrayList();
        }
        this.c.add(b$b);
    }

    public FragmentActivity c(Class clazz) {
        Serializable serializable;
        int n10;
        for (int i10 = 0; i10 < (n10 = (serializable = this.a).size()); ++i10) {
            serializable = ((FragmentActivity)this.a.get(i10)).getClass();
            if (serializable != clazz) continue;
            return (FragmentActivity)this.a.get(i10);
        }
        return null;
    }

    public void d() {
        FragmentActivity fragmentActivity = (FragmentActivity)this.a.lastElement();
        this.e(fragmentActivity);
    }

    public void e(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            this.n(fragmentActivity);
            fragmentActivity.finish();
        }
    }

    public int f() {
        return this.a.size();
    }

    public Stack g() {
        return this.a;
    }

    public FragmentActivity h() {
        return (FragmentActivity)this.a.lastElement();
    }

    public FragmentActivity j() {
        Stack stack = this.a;
        int n10 = stack.size();
        if (n10 > 0) {
            stack = this.a;
            int n11 = stack.size() + -1;
            return (FragmentActivity)stack.get(n11);
        }
        return null;
    }

    public boolean k(Context context) {
        boolean bl2;
        Iterator iterator2 = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2;
            Object object = (ActivityManager.RunningAppProcessInfo)iterator2.next();
            int n10 = ((ActivityManager.RunningAppProcessInfo)object).importance;
            int n11 = 100;
            if (n10 != n11 || !(bl2 = ((String)(object = ((ActivityManager.RunningAppProcessInfo)object).processName)).equals(string2 = context.getApplicationInfo().processName))) continue;
            return true;
        }
        return false;
    }

    public void l(Context context) {
        boolean bl2 = this.k(context);
        if (!bl2) {
            boolean bl3;
            ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
            Iterator iterator2 = activityManager.getAppTasks().iterator();
            while (bl3 = iterator2.hasNext()) {
                String string2;
                boolean bl4;
                ActivityManager.AppTask appTask = (ActivityManager.AppTask)iterator2.next();
                Object object = appTask.getTaskInfo().topActivity;
                if (object == null || !(bl4 = ((String)(object = appTask.getTaskInfo().topActivity.getPackageName())).equals(string2 = context.getPackageName()))) continue;
                context = appTask.getTaskInfo();
                int n10 = context.id;
                iterator2 = null;
                activityManager.moveTaskToFront(n10, 0);
                break;
            }
        }
    }

    public void m(Application application) {
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
    }

    public void n(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            Stack stack = this.a;
            stack.remove(fragmentActivity);
        }
    }

    public void o(b$b b$b) {
        ArrayList arrayList = this.c;
        if (arrayList != null) {
            arrayList.remove(b$b);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        boolean bl2 = activity instanceof FragmentActivity;
        if (bl2) {
            activity = (FragmentActivity)activity;
            this.a((FragmentActivity)activity);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        boolean bl2 = activity instanceof FragmentActivity;
        if (bl2) {
            activity = (FragmentActivity)activity;
            this.n((FragmentActivity)activity);
        }
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity object) {
        Object object2 = this.b;
        if (object2 != null) {
            object2.a((Activity)object);
        }
        int n10 = this.d;
        int n11 = 1;
        this.d = n10 += n11;
        object = this.a;
        n10 = ((Vector)object).size();
        if (n10 == n11 && (object = this.c) != null && (n10 = ((ArrayList)object).size()) > 0) {
            object = this.c.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (b$b)object.next();
                if (object2 == null) continue;
                object2.a();
            }
        }
    }

    public void onActivityStopped(Activity object) {
        int n10;
        this.d = n10 = this.d + -1;
        if (n10 == 0 && (object = this.c) != null && (n10 = ((ArrayList)object).size()) > 0) {
            boolean bl2;
            object = this.c.iterator();
            while (bl2 = object.hasNext()) {
                b$b b$b = (b$b)object.next();
                if (b$b == null) continue;
                b$b.b();
            }
        }
    }

    public void p(b$a b$a) {
        this.b = b$a;
    }

    public void q(Application application) {
        application.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
        this.a.clear();
        this.c.clear();
    }
}


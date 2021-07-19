/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 */
package d.v.c.x1;

import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import d.v.c.x1.h$a;
import d.v.c.x1.h$b;
import java.util.ArrayList;
import java.util.List;

public class h {
    private static volatile h d;
    private List a;
    private List b;
    private Application.ActivityLifecycleCallbacks c;

    private h() {
        Object object = new ArrayList();
        this.a = object;
        object = new ArrayList();
        this.b = object;
        object = new h$a(this);
        this.c = object;
    }

    public static /* synthetic */ List a(h h10) {
        return h10.a;
    }

    public static /* synthetic */ List b(h h10) {
        return h10.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h e() {
        Object object = d;
        if (object != null) return d;
        object = h.class;
        synchronized (object) {
            h h10 = d;
            if (h10 != null) return d;
            d = h10 = new h();
            return d;
        }
    }

    public void c(h$b h$b) {
        ArrayList arrayList = this.b;
        if (arrayList == null) {
            this.b = arrayList = new ArrayList();
        }
        this.b.add(h$b);
    }

    public int d() {
        int n10;
        List list = this.a;
        if (list == null) {
            n10 = 0;
            list = null;
        } else {
            n10 = list.size();
        }
        return n10;
    }

    public FragmentActivity f() {
        int n10;
        List list = this.a;
        if (list != null && (n10 = list.size()) > 0) {
            list = this.a;
            int n11 = list.size() + -1;
            return (FragmentActivity)list.get(n11);
        }
        return null;
    }

    public void g(Application application) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.c;
        application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void h(h$b h$b) {
        List list = this.b;
        if (list != null) {
            list.remove(h$b);
        }
    }

    public void i(Application application) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.c;
        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        this.c = null;
        this.a = null;
    }
}


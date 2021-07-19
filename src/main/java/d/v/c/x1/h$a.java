/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 */
package d.v.c.x1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import d.v.c.x1.h;
import d.v.c.x1.h$b;

public class h$a
implements Application.ActivityLifecycleCallbacks {
    private int a = 0;
    public final /* synthetic */ h b;

    public h$a(h h10) {
        this.b = h10;
    }

    public void onActivityCreated(Activity activity, Bundle object) {
        boolean bl2 = activity instanceof FragmentActivity;
        if (bl2) {
            object = h.a(this.b);
            activity = (FragmentActivity)activity;
            object.add(activity);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        h.a(this.b).remove(activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity object) {
        int n10 = this.a;
        int n11 = 1;
        this.a = n10 += n11;
        if (n10 == n11 && (object = h.b(this.b)) != null && (n10 = (object = h.b(this.b)).size()) > 0) {
            object = h.b(this.b).iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                h$b h$b = (h$b)object.next();
                if (h$b == null) continue;
                h$b.a();
            }
        }
    }

    public void onActivityStopped(Activity object) {
        int n10;
        this.a = n10 = this.a + -1;
        if (n10 == 0 && (object = h.b(this.b)) != null && (n10 = (object = h.b(this.b)).size()) > 0) {
            boolean bl2;
            object = h.b(this.b).iterator();
            while (bl2 = object.hasNext()) {
                h$b h$b = (h$b)object.next();
                if (h$b == null) continue;
                h$b.b();
            }
        }
    }
}


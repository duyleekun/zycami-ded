/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 */
package d.v.w;

import android.app.Activity;
import android.app.Application;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import com.zhiyun.pay.PayClientLifecycle;
import d.v.w.c0.b;
import d.v.w.c0.c;
import d.v.w.c0.f;
import e.a.o0;
import java.util.List;

public interface y
extends LifecycleObserver {
    public static y E(Application application) {
        return PayClientLifecycle.f0(application);
    }

    public o0 B(String var1, boolean var2, boolean var3, String var4);

    public void C();

    public boolean D(Activity var1, c var2);

    default public LiveData O() {
        return null;
    }

    default public List a(List list) {
        return null;
    }

    public o0 h(f var1);

    public o0 q(b var1);
}


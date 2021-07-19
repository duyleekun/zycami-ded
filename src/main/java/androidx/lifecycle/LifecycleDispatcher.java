/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 */
package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LifecycleDispatcher$DispatcherActivityCallback;
import java.util.concurrent.atomic.AtomicBoolean;

public class LifecycleDispatcher {
    private static AtomicBoolean sInitialized;

    static {
        AtomicBoolean atomicBoolean;
        sInitialized = atomicBoolean = new AtomicBoolean(false);
    }

    private LifecycleDispatcher() {
    }

    public static void init(Context context) {
        Object object = sInitialized;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).getAndSet(bl2);
        if (bl3) {
            return;
        }
        context = (Application)context.getApplicationContext();
        object = new LifecycleDispatcher$DispatcherActivityCallback();
        context.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object);
    }
}


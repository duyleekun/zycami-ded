/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.api.internal.zaa;

public abstract class ActivityLifecycleObserver {
    public static final ActivityLifecycleObserver of(Activity activity) {
        zaa zaa2 = new zaa(activity);
        return zaa2;
    }

    public abstract ActivityLifecycleObserver onStopCallOnce(Runnable var1);
}


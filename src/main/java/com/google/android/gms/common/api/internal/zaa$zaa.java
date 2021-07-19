/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.List;

public class zaa$zaa
extends LifecycleCallback {
    private List zacm;

    private zaa$zaa(LifecycleFragment arrayList) {
        super((LifecycleFragment)((Object)arrayList));
        this.zacm = arrayList = new ArrayList();
        this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static zaa$zaa zaa(Activity activity) {
        synchronized (activity) {
            LifecycleFragment lifecycleFragment = LifecycleCallback.getFragment(activity);
            Object object = "LifecycleObserverOnStop";
            Class<zaa$zaa> clazz = zaa$zaa.class;
            object = lifecycleFragment.getCallbackOrNull((String)object, clazz);
            object = (zaa$zaa)object;
            if (object != null) return object;
            return new zaa$zaa(lifecycleFragment);
        }
    }

    public static /* synthetic */ void zaa(zaa$zaa zaa$zaa, Runnable runnable) {
        zaa$zaa.zaa(runnable);
    }

    private final void zaa(Runnable runnable) {
        synchronized (this) {
            List list = this.zacm;
            list.add(runnable);
            return;
        }
    }

    public static /* synthetic */ zaa$zaa zab(Activity activity) {
        return zaa$zaa.zaa(activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onStop() {
        Object object;
        Object object2;
        synchronized (this) {
            object2 = this.zacm;
            object = new ArrayList();
            this.zacm = object;
        }
        object2 = object2.iterator();
        boolean bl2;
        while (bl2 = object2.hasNext()) {
            object = (Runnable)object2.next();
            object.run();
        }
        return;
    }
}


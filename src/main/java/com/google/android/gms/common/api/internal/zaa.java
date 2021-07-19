/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.api.internal.ActivityLifecycleObserver;
import com.google.android.gms.common.api.internal.zaa$zaa;
import java.lang.ref.WeakReference;

public final class zaa
extends ActivityLifecycleObserver {
    private final WeakReference zacl;

    public zaa(Activity object) {
        object = zaa$zaa.zab(object);
        this((zaa$zaa)object);
    }

    private zaa(zaa$zaa zaa$zaa) {
        WeakReference<zaa$zaa> weakReference;
        this.zacl = weakReference = new WeakReference<zaa$zaa>(zaa$zaa);
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable object) {
        zaa$zaa zaa$zaa = (zaa$zaa)this.zacl.get();
        if (zaa$zaa != null) {
            zaa$zaa.zaa(zaa$zaa, (Runnable)object);
            return this;
        }
        object = new IllegalStateException("The target activity has already been GC'd");
        throw object;
    }
}


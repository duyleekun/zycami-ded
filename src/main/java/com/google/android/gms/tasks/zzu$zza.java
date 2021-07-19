/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.tasks.zzr;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class zzu$zza
extends LifecycleCallback {
    private final List zza;

    private zzu$zza(LifecycleFragment arrayList) {
        super((LifecycleFragment)((Object)arrayList));
        this.zza = arrayList = new ArrayList();
        this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }

    public static zzu$zza zza(Activity object) {
        String string2;
        zzu$zza zzu$zza = (zzu$zza)(object = LifecycleCallback.getFragment((Activity)object)).getCallbackOrNull(string2 = "TaskOnStopCallback", zzu$zza.class);
        if (zzu$zza == null) {
            zzu$zza = new zzu$zza((LifecycleFragment)object);
        }
        return zzu$zza;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onStop() {
        List list = this.zza;
        synchronized (list) {
            Object object = this.zza;
            object = object.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = this.zza;
                    object.clear();
                    return;
                }
                Object object2 = object.next();
                object2 = (WeakReference)object2;
                object2 = ((Reference)object2).get();
                if ((object2 = (zzr)object2) == null) continue;
                object2.zza();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(zzr zzr2) {
        List list = this.zza;
        synchronized (list) {
            List list2 = this.zza;
            WeakReference<zzr> weakReference = new WeakReference<zzr>(zzr2);
            list2.add(weakReference);
            return;
        }
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.ComponentCallbacks
 *  android.content.ComponentCallbacks2
 *  android.content.res.Configuration
 *  android.os.Bundle
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.api.internal.BackgroundDetector$BackgroundStateChangeListener;
import com.google.android.gms.common.util.PlatformVersion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BackgroundDetector
implements Application.ActivityLifecycleCallbacks,
ComponentCallbacks2 {
    private static final BackgroundDetector zza;
    private final AtomicBoolean zzb;
    private final AtomicBoolean zzc;
    private final ArrayList zzd;
    private boolean zze;

    static {
        BackgroundDetector backgroundDetector;
        zza = backgroundDetector = new BackgroundDetector();
    }

    private BackgroundDetector() {
        Serializable serializable;
        this.zzb = serializable = new AtomicBoolean();
        this.zzc = serializable = new AtomicBoolean();
        this.zzd = serializable;
        this.zze = false;
    }

    public static BackgroundDetector getInstance() {
        return zza;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void initialize(Application application) {
        BackgroundDetector backgroundDetector = zza;
        synchronized (backgroundDetector) {
            boolean bl2 = backgroundDetector.zze;
            if (!bl2) {
                boolean bl3;
                application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)backgroundDetector);
                application.registerComponentCallbacks((ComponentCallbacks)backgroundDetector);
                backgroundDetector.zze = bl3 = true;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zza(boolean bl2) {
        BackgroundDetector backgroundDetector = zza;
        synchronized (backgroundDetector) {
            ArrayList arrayList = this.zzd;
            int n10 = arrayList.size();
            int n11 = 0;
            while (n11 < n10) {
                Object object = arrayList.get(n11);
                ++n11;
                object = (BackgroundDetector$BackgroundStateChangeListener)object;
                object.onBackgroundStateChanged(bl2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void addListener(BackgroundDetector$BackgroundStateChangeListener backgroundDetector$BackgroundStateChangeListener) {
        BackgroundDetector backgroundDetector = zza;
        synchronized (backgroundDetector) {
            ArrayList arrayList = this.zzd;
            arrayList.add(backgroundDetector$BackgroundStateChangeListener);
            return;
        }
    }

    public final boolean isInBackground() {
        return this.zzb.get();
    }

    public final void onActivityCreated(Activity object, Bundle bundle) {
        object = this.zzb;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(bl2, false);
        AtomicBoolean atomicBoolean = this.zzc;
        atomicBoolean.set(bl2);
        if (bl3) {
            this.zza(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity object) {
        object = this.zzb;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(bl2, false);
        AtomicBoolean atomicBoolean = this.zzc;
        atomicBoolean.set(bl2);
        if (bl3) {
            this.zza(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int n10) {
        int n11 = 20;
        if (n10 == n11) {
            AtomicBoolean atomicBoolean = this.zzb;
            n11 = 0;
            boolean bl2 = true;
            n10 = (int)(atomicBoolean.compareAndSet(false, bl2) ? 1 : 0);
            if (n10 != 0) {
                atomicBoolean = this.zzc;
                atomicBoolean.set(bl2);
                this.zza(bl2);
            }
        }
    }

    public final boolean readCurrentStateIfPossible(boolean n10) {
        AtomicBoolean atomicBoolean = this.zzc;
        int n11 = atomicBoolean.get();
        if (n11 == 0) {
            n11 = PlatformVersion.isAtLeastJellyBean();
            if (n11 != 0) {
                Object object = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState((ActivityManager.RunningAppProcessInfo)object);
                atomicBoolean = this.zzc;
                boolean bl2 = true;
                n11 = atomicBoolean.getAndSet(bl2);
                if (n11 == 0 && (n10 = ((ActivityManager.RunningAppProcessInfo)object).importance) > (n11 = 100)) {
                    object = this.zzb;
                    ((AtomicBoolean)object).set(bl2);
                }
            } else {
                return n10 != 0;
            }
        }
        return this.isInBackground();
    }
}


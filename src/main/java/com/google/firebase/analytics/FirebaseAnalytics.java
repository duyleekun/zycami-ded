/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 */
package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.internal.zzho;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics$ConsentStatus;
import com.google.firebase.analytics.FirebaseAnalytics$ConsentType;
import com.google.firebase.analytics.zza;
import com.google.firebase.analytics.zzb;
import com.google.firebase.analytics.zzc;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zza;
    private final zzbr zzb;
    private ExecutorService zzc;

    public FirebaseAnalytics(zzbr zzbr2) {
        Preconditions.checkNotNull(zzbr2);
        this.zzb = zzbr2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static FirebaseAnalytics getInstance(Context object) {
        Object object2 = zza;
        if (object2 != null) return zza;
        object2 = FirebaseAnalytics.class;
        synchronized (object2) {
            FirebaseAnalytics firebaseAnalytics = zza;
            if (firebaseAnalytics != null) return zza;
            firebaseAnalytics = null;
            object = zzbr.zza(object, null, null, null, null);
            zza = firebaseAnalytics = new FirebaseAnalytics((zzbr)object);
            return zza;
        }
    }

    public static zzho getScionFrontendApiImplementation(Context object, Bundle object2) {
        if ((object = zzbr.zza(object, null, null, null, object2)) == null) {
            return null;
        }
        object2 = new zzc((zzbr)object);
        return object2;
    }

    public static /* synthetic */ zzbr zza(FirebaseAnalytics firebaseAnalytics) {
        return firebaseAnalytics.zzb;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Task getAppInstanceId() {
        int n10;
        ArrayBlockingQueue arrayBlockingQueue;
        TimeUnit timeUnit;
        ExecutorService executorService;
        Object object = FirebaseAnalytics.class;
        try {
            synchronized (object) {
                executorService = this.zzc;
                if (executorService != null) break block7;
                timeUnit = TimeUnit.SECONDS;
                int n11 = 100;
                arrayBlockingQueue = new ArrayBlockingQueue(n11);
                n10 = 1;
            }
        }
        catch (Exception exception) {
            this.zzb.zzC(5, "Failed to schedule task for getAppInstanceId", null, null, null);
            return Tasks.forException(exception);
        }
        {
            block7: {
                long l10 = 30;
                this.zzc = executorService = new zza(this, 0, n10, l10, timeUnit, arrayBlockingQueue);
            }
            executorService = this.zzc;
        }
        {
            object = new zzb(this);
            return Tasks.call(executorService, (Callable)object);
        }
    }

    public String getFirebaseInstanceId() {
        Object object = FirebaseInstallations.getInstance();
        object = ((FirebaseInstallations)object).getId();
        Object object2 = TimeUnit.MILLISECONDS;
        long l10 = 30000L;
        object = Tasks.await((Task)object, l10, (TimeUnit)((Object)object2));
        try {
            return (String)object;
        }
        catch (InterruptedException interruptedException) {
            object2 = new IllegalStateException(interruptedException);
            throw object2;
        }
        catch (TimeoutException timeoutException) {
            object = new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
            throw object;
        }
        catch (ExecutionException executionException) {
            Throwable throwable = executionException.getCause();
            object2 = new IllegalStateException(throwable);
            throw object2;
        }
    }

    public void logEvent(String string2, Bundle bundle) {
        this.zzb.zzg(string2, bundle);
    }

    public void resetAnalyticsData() {
        this.zzb.zzs();
    }

    public void setAnalyticsCollectionEnabled(boolean bl2) {
        zzbr zzbr2 = this.zzb;
        Boolean bl3 = bl2;
        zzbr2.zzp(bl3);
    }

    public void setConsent(Map object) {
        Bundle bundle = new Bundle();
        Object object2 = FirebaseAnalytics$ConsentType.AD_STORAGE;
        object2 = (FirebaseAnalytics$ConsentStatus)((Object)object.get(object2));
        String string2 = "denied";
        String string3 = "granted";
        int n10 = 1;
        if (object2 != null) {
            int n11 = ((Enum)object2).ordinal();
            String string4 = "ad_storage";
            if (n11 != 0) {
                if (n11 == n10) {
                    bundle.putString(string4, string2);
                }
            } else {
                bundle.putString(string4, string3);
            }
        }
        if ((object = (FirebaseAnalytics$ConsentStatus)((Object)object.get(object2 = FirebaseAnalytics$ConsentType.ANALYTICS_STORAGE))) != null) {
            int n12 = ((Enum)object).ordinal();
            object2 = "analytics_storage";
            if (n12 != 0) {
                if (n12 == n10) {
                    bundle.putString((String)object2, string2);
                }
            } else {
                bundle.putString((String)object2, string3);
            }
        }
        this.zzb.zzr(bundle);
    }

    public void setCurrentScreen(Activity activity, String string2, String string3) {
        this.zzb.zzo(activity, string2, string3);
    }

    public void setDefaultEventParameters(Bundle bundle) {
        this.zzb.zzJ(bundle);
    }

    public void setSessionTimeoutDuration(long l10) {
        this.zzb.zzt(l10);
    }

    public void setUserId(String string2) {
        this.zzb.zzn(string2);
    }

    public void setUserProperty(String string2, String string3) {
        this.zzb.zzj(null, string2, string3, false);
    }
}


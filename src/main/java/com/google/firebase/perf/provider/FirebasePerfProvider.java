/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.pm.ProviderInfo
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.firebase.perf.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.metrics.AppStartTrace$StartFromBackgroundRunnable;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;

public class FirebasePerfProvider
extends ContentProvider {
    private static final Timer APP_START_TIME;
    public static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.firebaseperfprovider";
    private final Handler mHandler;

    static {
        Clock clock = new Clock();
        APP_START_TIME = clock.getTime();
    }

    public FirebasePerfProvider() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.mHandler = handler = new Handler(looper);
    }

    private static void checkContentProviderAuthority(ProviderInfo object) {
        Preconditions.checkNotNull(object, "FirebasePerfProvider ProviderInfo cannot be null.");
        object = object.authority;
        String string2 = EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY;
        boolean bl2 = string2.equals(object);
        if (!bl2) {
            return;
        }
        object = new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        throw object;
    }

    public static Timer getAppStartTime() {
        return APP_START_TIME;
    }

    public void attachInfo(Context object, ProviderInfo object2) {
        FirebasePerfProvider.checkContentProviderAuthority(object2);
        super.attachInfo((Context)object, object2);
        object = ConfigResolver.getInstance();
        object2 = this.getContext();
        ((ConfigResolver)object).setContentProviderContext((Context)object2);
        boolean bl2 = ((ConfigResolver)object).isPerformanceMonitoringEnabled();
        if (bl2) {
            object = AppStateMonitor.getInstance();
            object2 = this.getContext();
            ((AppStateMonitor)object).registerActivityLifecycleCallbacks((Context)object2);
            object = AppStartTrace.getInstance();
            object2 = this.getContext();
            ((AppStartTrace)object).registerActivityLifecycleCallbacks((Context)object2);
            object2 = this.mHandler;
            AppStartTrace$StartFromBackgroundRunnable appStartTrace$StartFromBackgroundRunnable = new AppStartTrace$StartFromBackgroundRunnable((AppStartTrace)object);
            object2.post((Runnable)appStartTrace$StartFromBackgroundRunnable);
        }
        object = SessionManager.getInstance();
        object2 = ApplicationProcessState.FOREGROUND;
        ((SessionManager)object).updatePerfSession((ApplicationProcessState)object2);
    }

    public int delete(Uri uri, String string2, String[] stringArray) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] stringArray, String string2, String[] stringArray2, String string3) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String string2, String[] stringArray) {
        return 0;
    }
}


/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorHandle;
import com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorListener;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.google.firebase.crashlytics.CustomKeysAndValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics$1;
import com.google.firebase.crashlytics.FirebaseCrashlytics$2;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.MissingNativeComponent;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class FirebaseCrashlytics {
    private static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
    public static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
    private static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
    private final CrashlyticsCore core;

    private FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        this.core = crashlyticsCore;
    }

    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics)FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        Objects.requireNonNull(firebaseCrashlytics, "FirebaseCrashlytics component is not present.");
        return firebaseCrashlytics;
    }

    public static FirebaseCrashlytics init(FirebaseApp object, FirebaseInstallationsApi object2, CrashlyticsNativeComponent object3, AnalyticsConnector object4) {
        Object object5;
        Object object6;
        Object object7;
        Object object8;
        Object object9 = Logger.getLogger();
        Object object10 = new StringBuilder();
        ((StringBuilder)object10).append("Initializing Firebase Crashlytics ");
        String string2 = CrashlyticsCore.getVersion();
        ((StringBuilder)object10).append(string2);
        object10 = ((StringBuilder)object10).toString();
        ((Logger)object9).i((String)object10);
        string2 = ((FirebaseApp)object).getApplicationContext();
        object9 = string2.getPackageName();
        object10 = new IdManager((Context)string2, (String)object9, (FirebaseInstallationsApi)object2);
        object2 = new DataCollectionArbiter((FirebaseApp)object);
        if (object3 == null) {
            object3 = new MissingNativeComponent();
        }
        Object object11 = object3;
        if (object4 != null) {
            object3 = new CrashlyticsOriginAnalyticsEventLogger((AnalyticsConnector)object4);
            object9 = new CrashlyticsAnalyticsListener();
            if ((object4 = FirebaseCrashlytics.subscribeToAnalyticsEvents((AnalyticsConnector)object4, (CrashlyticsAnalyticsListener)object9)) != null) {
                Logger.getLogger().d("Registered Firebase Analytics listener.");
                object4 = new BreadcrumbAnalyticsEventReceiver();
                int n10 = 500;
                object8 = TimeUnit.MILLISECONDS;
                object7 = new BlockingAnalyticsEventLogger((CrashlyticsOriginAnalyticsEventLogger)object3, n10, (TimeUnit)((Object)object8));
                ((CrashlyticsAnalyticsListener)object9).setBreadcrumbEventReceiver((AnalyticsEventReceiver)object4);
                ((CrashlyticsAnalyticsListener)object9).setCrashlyticsOriginEventReceiver((AnalyticsEventReceiver)object7);
                object3 = object7;
            } else {
                object4 = Logger.getLogger();
                object9 = "Could not register Firebase Analytics listener; a listener is already registered.";
                ((Logger)object4).w((String)object9);
                object4 = new DisabledBreadcrumbSource();
            }
            object6 = object3;
            object5 = object4;
        } else {
            Logger.getLogger().d("Firebase Analytics is not available.");
            object3 = new DisabledBreadcrumbSource();
            object4 = new UnavailableAnalyticsEventLogger();
            object5 = object3;
            object6 = object4;
        }
        ExecutorService executorService = ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler");
        object7 = object3;
        Object object12 = object;
        object8 = object10;
        Object object13 = object2;
        object3 = new CrashlyticsCore((FirebaseApp)object, (IdManager)object10, (CrashlyticsNativeComponent)object11, (DataCollectionArbiter)object2, (BreadcrumbSource)object5, (AnalyticsEventLogger)object6, executorService);
        object7 = ((FirebaseApp)object).getOptions().getApplicationId();
        object = CommonUtils.getMappingFileId((Context)string2);
        object4 = Logger.getLogger();
        object9 = new StringBuilder();
        object12 = "Mapping file ID is: ";
        ((StringBuilder)object9).append((String)object12);
        ((StringBuilder)object9).append((String)object);
        object9 = ((StringBuilder)object9).toString();
        ((Logger)object4).d((String)object9);
        object4 = new ResourceUnityVersionProvider((Context)string2);
        try {
            object = AppData.create((Context)string2, (IdManager)object10, (String)object7, (String)object, (UnityVersionProvider)object4);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Logger.getLogger().e("Error retrieving app package info.", nameNotFoundException);
            return null;
        }
        object4 = Logger.getLogger();
        object9 = new StringBuilder();
        ((StringBuilder)object9).append("Installer package name is: ");
        object12 = ((AppData)object).installerPackageName;
        ((StringBuilder)object9).append((String)object12);
        object9 = ((StringBuilder)object9).toString();
        ((Logger)object4).v((String)object9);
        object4 = ExecutorUtils.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
        object8 = new HttpRequestFactory();
        object11 = ((AppData)object).versionCode;
        object13 = ((AppData)object).versionName;
        object12 = object10;
        object5 = object2;
        object2 = SettingsController.create((Context)string2, (String)object7, (IdManager)object10, (HttpRequestFactory)object8, (String)object11, (String)object13, (DataCollectionArbiter)object2);
        object9 = ((SettingsController)object2).loadSettingsData((Executor)object4);
        object10 = new FirebaseCrashlytics$1();
        ((Task)object9).continueWith((Executor)object4, (Continuation)object10);
        boolean bl2 = ((CrashlyticsCore)object3).onPreExecute((AppData)object, (SettingsDataProvider)object2);
        object9 = new FirebaseCrashlytics$2(bl2, (CrashlyticsCore)object3, (SettingsController)object2);
        Tasks.call((Executor)object4, (Callable)object9);
        object = new FirebaseCrashlytics((CrashlyticsCore)object3);
        return object;
    }

    private static AnalyticsConnector$AnalyticsConnectorHandle subscribeToAnalyticsEvents(AnalyticsConnector object, CrashlyticsAnalyticsListener object2) {
        Object object3 = object.registerAnalyticsConnectorListener(FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN, (AnalyticsConnector$AnalyticsConnectorListener)object2);
        if (object3 == null) {
            object3 = Logger.getLogger();
            String string2 = "Could not register AnalyticsConnectorListener with Crashlytics origin.";
            ((Logger)object3).d(string2);
            object3 = object.registerAnalyticsConnectorListener(LEGACY_CRASH_ANALYTICS_ORIGIN, (AnalyticsConnector$AnalyticsConnectorListener)object2);
            if (object3 != null) {
                object = Logger.getLogger();
                object2 = "A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.";
                ((Logger)object).w((String)object2);
            }
        }
        return object3;
    }

    public Task checkForUnsentReports() {
        return this.core.checkForUnsentReports();
    }

    public void deleteUnsentReports() {
        this.core.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.core.didCrashOnPreviousExecution();
    }

    public void log(String string2) {
        this.core.log(string2);
    }

    public void recordException(Throwable throwable) {
        if (throwable == null) {
            Logger.getLogger().w("A null value was passed to recordException. Ignoring.");
            return;
        }
        this.core.logException(throwable);
    }

    public void sendUnsentReports() {
        this.core.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(Boolean bl2) {
        this.core.setCrashlyticsCollectionEnabled(bl2);
    }

    public void setCrashlyticsCollectionEnabled(boolean bl2) {
        CrashlyticsCore crashlyticsCore = this.core;
        Boolean bl3 = bl2;
        crashlyticsCore.setCrashlyticsCollectionEnabled(bl3);
    }

    public void setCustomKey(String string2, double d10) {
        CrashlyticsCore crashlyticsCore = this.core;
        String string3 = Double.toString(d10);
        crashlyticsCore.setCustomKey(string2, string3);
    }

    public void setCustomKey(String string2, float f10) {
        CrashlyticsCore crashlyticsCore = this.core;
        String string3 = Float.toString(f10);
        crashlyticsCore.setCustomKey(string2, string3);
    }

    public void setCustomKey(String string2, int n10) {
        CrashlyticsCore crashlyticsCore = this.core;
        String string3 = Integer.toString(n10);
        crashlyticsCore.setCustomKey(string2, string3);
    }

    public void setCustomKey(String string2, long l10) {
        CrashlyticsCore crashlyticsCore = this.core;
        String string3 = Long.toString(l10);
        crashlyticsCore.setCustomKey(string2, string3);
    }

    public void setCustomKey(String string2, String string3) {
        this.core.setCustomKey(string2, string3);
    }

    public void setCustomKey(String string2, boolean bl2) {
        CrashlyticsCore crashlyticsCore = this.core;
        String string3 = Boolean.toString(bl2);
        crashlyticsCore.setCustomKey(string2, string3);
    }

    public void setCustomKeys(CustomKeysAndValues object) {
        CrashlyticsCore crashlyticsCore = this.core;
        object = ((CustomKeysAndValues)object).keysAndValues;
        crashlyticsCore.setCustomKeys((Map)object);
    }

    public void setUserId(String string2) {
        this.core.setUserId(string2);
    }
}


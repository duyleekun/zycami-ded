/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$Lambda$1;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore$1;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore$2;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore$3;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore$4;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore$LogFileDirectoryProvider;
import com.google.firebase.crashlytics.internal.common.CrashlyticsFileMarker;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.log.LogFileManager$DirectoryProvider;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.persistence.FileStoreImpl;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CrashlyticsCore {
    public static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    public static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    public static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    public static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    public static final int MAX_STACK_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.";
    public static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private final AnalyticsEventLogger analyticsEventLogger;
    private final FirebaseApp app;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    private final BreadcrumbSource breadcrumbSource;
    private final Context context;
    private CrashlyticsController controller;
    private final ExecutorService crashHandlerExecutor;
    private CrashlyticsFileMarker crashMarker;
    private final DataCollectionArbiter dataCollectionArbiter;
    private boolean didCrashOnPreviousExecution;
    private final IdManager idManager;
    private CrashlyticsFileMarker initializationMarker;
    private final CrashlyticsNativeComponent nativeComponent;
    private final long startTime;

    public CrashlyticsCore(FirebaseApp object, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, ExecutorService executorService) {
        long l10;
        this.app = object;
        this.dataCollectionArbiter = dataCollectionArbiter;
        object = ((FirebaseApp)object).getApplicationContext();
        this.context = object;
        this.idManager = idManager;
        this.nativeComponent = crashlyticsNativeComponent;
        this.breadcrumbSource = breadcrumbSource;
        this.analyticsEventLogger = analyticsEventLogger;
        this.crashHandlerExecutor = executorService;
        this.backgroundWorker = object = new CrashlyticsBackgroundWorker(executorService);
        this.startTime = l10 = System.currentTimeMillis();
    }

    public static /* synthetic */ Task access$000(CrashlyticsCore crashlyticsCore, SettingsDataProvider settingsDataProvider) {
        return crashlyticsCore.doBackgroundInitialization(settingsDataProvider);
    }

    public static /* synthetic */ CrashlyticsFileMarker access$100(CrashlyticsCore crashlyticsCore) {
        return crashlyticsCore.initializationMarker;
    }

    public static /* synthetic */ CrashlyticsController access$200(CrashlyticsCore crashlyticsCore) {
        return crashlyticsCore.controller;
    }

    private void checkForPreviousCrash() {
        boolean bl2;
        Object object = this.backgroundWorker;
        CrashlyticsCore$4 crashlyticsCore$4 = new CrashlyticsCore$4(this);
        object = ((CrashlyticsBackgroundWorker)object).submit(crashlyticsCore$4);
        try {
            object = Utils.awaitEvenIfOnMainThread((Task)object);
        }
        catch (Exception exception) {
            this.didCrashOnPreviousExecution = false;
            return;
        }
        object = (Boolean)object;
        this.didCrashOnPreviousExecution = bl2 = Boolean.TRUE.equals(object);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Task doBackgroundInitialization(SettingsDataProvider object) {
        Throwable throwable2222222;
        block7: {
            Object object2 = "Collection of crash reports disabled in Crashlytics settings.";
            this.markInitializationStarted();
            Object object3 = this.breadcrumbSource;
            BreadcrumbHandler breadcrumbHandler = CrashlyticsCore$$Lambda$1.lambdaFactory$(this);
            object3.registerBreadcrumbHandler(breadcrumbHandler);
            object3 = object.getSettings();
            object3 = object3.getFeaturesData();
            boolean bl2 = ((FeaturesSettingsData)object3).collectReports;
            if (!bl2) {
                object = Logger.getLogger();
                ((Logger)object).d((String)object2);
                object = new RuntimeException((String)object2);
                object = Tasks.forException((Exception)object);
                this.markInitializationComplete();
                return object;
            }
            {
                catch (Throwable throwable2222222) {
                    break block7;
                }
                catch (Exception exception) {}
                {
                    object2 = Logger.getLogger();
                    object3 = "Crashlytics encountered a problem during asynchronous initialization.";
                    ((Logger)object2).e((String)object3, exception);
                    Task task = Tasks.forException(exception);
                    this.markInitializationComplete();
                    return task;
                }
            }
            {
                object2 = this.controller;
                boolean bl3 = ((CrashlyticsController)object2).finalizeSessions();
                if (!bl3) {
                    object2 = Logger.getLogger();
                    object3 = "Previous sessions could not be finalized.";
                    ((Logger)object2).w((String)object3);
                }
                object2 = this.controller;
                object = object.getAppSettings();
                object = ((CrashlyticsController)object2).submitAllReports((Task)object);
                this.markInitializationComplete();
                return object;
            }
        }
        this.markInitializationComplete();
        throw throwable2222222;
    }

    private void finishInitSynchronously(SettingsDataProvider object) {
        Object object2 = new CrashlyticsCore$2(this, (SettingsDataProvider)object);
        object = this.crashHandlerExecutor.submit((Runnable)object2);
        object2 = Logger.getLogger();
        String string2 = "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.";
        ((Logger)object2).d(string2);
        long l10 = 4;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        try {
            object.get(l10, timeUnit);
        }
        catch (TimeoutException timeoutException) {
            object2 = Logger.getLogger();
            string2 = "Crashlytics timed out during initialization.";
            ((Logger)object2).e(string2, timeoutException);
        }
        catch (ExecutionException executionException) {
            object2 = Logger.getLogger();
            string2 = "Crashlytics encountered a problem during initialization.";
            ((Logger)object2).e(string2, executionException);
        }
        catch (InterruptedException interruptedException) {
            object2 = Logger.getLogger();
            string2 = "Crashlytics was interrupted during initialization.";
            ((Logger)object2).e(string2, interruptedException);
        }
    }

    public static String getVersion() {
        return "17.4.0";
    }

    public static boolean isBuildIdValid(String string2, boolean bl2) {
        boolean bl3 = true;
        if (!bl2) {
            Logger.getLogger().v("Configured not to require a build ID.");
            return bl3;
        }
        boolean bl4 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl4) {
            return bl3;
        }
        string2 = "FirebaseCrashlytics";
        String string3 = ".";
        Log.e((String)string2, (String)string3);
        Log.e((String)string2, (String)".     |  | ");
        String string4 = ".     |  |";
        Log.e((String)string2, (String)string4);
        Log.e((String)string2, (String)string4);
        Log.e((String)string2, (String)".   \\ |  | /");
        Log.e((String)string2, (String)".    \\    /");
        Log.e((String)string2, (String)".     \\  /");
        Log.e((String)string2, (String)".      \\/");
        Log.e((String)string2, (String)string3);
        Log.e((String)string2, (String)MISSING_BUILD_ID_MSG);
        Log.e((String)string2, (String)string3);
        Log.e((String)string2, (String)".      /\\");
        Log.e((String)string2, (String)".     /  \\");
        Log.e((String)string2, (String)".    /    \\");
        Log.e((String)string2, (String)".   / |  | \\");
        Log.e((String)string2, (String)string4);
        Log.e((String)string2, (String)string4);
        Log.e((String)string2, (String)string4);
        Log.e((String)string2, (String)string3);
        return false;
    }

    public Task checkForUnsentReports() {
        return this.controller.checkForUnsentReports();
    }

    public Task deleteUnsentReports() {
        return this.controller.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.didCrashOnPreviousExecution;
    }

    public boolean didPreviousInitializationFail() {
        return this.initializationMarker.isPresent();
    }

    public Task doBackgroundInitializationAsync(SettingsDataProvider settingsDataProvider) {
        ExecutorService executorService = this.crashHandlerExecutor;
        CrashlyticsCore$1 crashlyticsCore$1 = new CrashlyticsCore$1(this, settingsDataProvider);
        return Utils.callTask(executorService, crashlyticsCore$1);
    }

    public CrashlyticsController getController() {
        return this.controller;
    }

    public void log(String string2) {
        long l10 = System.currentTimeMillis();
        long l11 = this.startTime;
        this.controller.writeToLog(l10 -= l11, string2);
    }

    public void logException(Throwable throwable) {
        CrashlyticsController crashlyticsController = this.controller;
        Thread thread = Thread.currentThread();
        crashlyticsController.writeNonFatalException(thread, throwable);
    }

    public void markInitializationComplete() {
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = this.backgroundWorker;
        CrashlyticsCore$3 crashlyticsCore$3 = new CrashlyticsCore$3(this);
        crashlyticsBackgroundWorker.submit(crashlyticsCore$3);
    }

    public void markInitializationStarted() {
        this.backgroundWorker.checkRunningOnThread();
        this.initializationMarker.create();
        Logger.getLogger().v("Initialization marker file was created.");
    }

    public boolean onPreExecute(AppData appData, SettingsDataProvider settingsDataProvider) {
        CrashlyticsCore crashlyticsCore = this;
        Object object = settingsDataProvider;
        Object object2 = this.context;
        boolean bl2 = true;
        int n10 = CommonUtils.getBooleanResourceValue((Context)object2, CRASHLYTICS_REQUIRE_BUILD_ID, bl2);
        Object object3 = appData.buildId;
        if ((n10 = CrashlyticsCore.isBuildIdValid((String)object3, n10 != 0)) != 0) {
            block38: {
                try {
                    object2 = this.context;
                }
                catch (Exception exception) {
                    Logger.getLogger().e("Crashlytics was not started due to an exception during initialization", exception);
                    crashlyticsCore.controller = null;
                    return false;
                }
                Object object4 = new FileStoreImpl((Context)object2);
                object3 = CRASH_MARKER_FILE_NAME;
                object2 = new CrashlyticsFileMarker((String)object3, (FileStore)object4);
                this.crashMarker = object2;
                object3 = INITIALIZATION_MARKER_FILE_NAME;
                object2 = new CrashlyticsFileMarker((String)object3, (FileStore)object4);
                this.initializationMarker = object2;
                UserMetadata userMetadata = new UserMetadata();
                Object object5 = new CrashlyticsCore$LogFileDirectoryProvider((FileStore)object4);
                object2 = this.context;
                LogFileManager logFileManager = new LogFileManager((Context)object2, (LogFileManager$DirectoryProvider)object5);
                n10 = 1024;
                object3 = new StackTraceTrimmingStrategy[bl2];
                int n11 = 10;
                Object object6 = new RemoveRepeatsStrategy(n11);
                object3[0] = object6;
                Object object7 = new MiddleOutFallbackStrategy(n10, (StackTraceTrimmingStrategy[])object3);
                object2 = this.context;
                object3 = this.idManager;
                object6 = object4;
                Object object8 = appData;
                Object object9 = logFileManager;
                Object object10 = userMetadata;
                Object object11 = settingsDataProvider;
                SessionReportingCoordinator sessionReportingCoordinator = SessionReportingCoordinator.create((Context)object2, (IdManager)object3, (FileStore)object4, appData, logFileManager, userMetadata, (StackTraceTrimmingStrategy)object7, settingsDataProvider);
                object3 = this.context;
                object6 = this.backgroundWorker;
                object8 = this.idManager;
                object9 = this.dataCollectionArbiter;
                object10 = this.crashMarker;
                object7 = this.nativeComponent;
                object11 = this.analyticsEventLogger;
                LogFileManager logFileManager2 = logFileManager;
                logFileManager = object3;
                object3 = object5;
                object5 = object6;
                object6 = object4;
                object4 = object8;
                object2 = new CrashlyticsController((Context)logFileManager, (CrashlyticsBackgroundWorker)object5, (IdManager)object8, (DataCollectionArbiter)object9, (FileStore)object6, (CrashlyticsFileMarker)object10, appData, userMetadata, logFileManager2, (LogFileManager$DirectoryProvider)object3, sessionReportingCoordinator, (CrashlyticsNativeComponent)object7, (AnalyticsEventLogger)object11);
                this.controller = object2;
                n10 = (int)(this.didPreviousInitializationFail() ? 1 : 0);
                this.checkForPreviousCrash();
                object3 = this.controller;
                object6 = Thread.getDefaultUncaughtExceptionHandler();
                ((CrashlyticsController)object3).enableExceptionHandling((Thread.UncaughtExceptionHandler)object6, settingsDataProvider);
                if (n10 == 0) break block38;
                object2 = this.context;
                n10 = (int)(CommonUtils.canTryConnection((Context)object2) ? 1 : 0);
                if (n10 == 0) break block38;
                object2 = Logger.getLogger();
                object3 = "Crashlytics did not finish previous background initialization. Initializing synchronously.";
                ((Logger)object2).d((String)object3);
                this.finishInitSynchronously(settingsDataProvider);
                return false;
            }
            Logger.getLogger().d("Successfully configured exception handler.");
            return bl2;
        }
        object = new IllegalStateException(MISSING_BUILD_ID_MSG);
        throw object;
    }

    public Task sendUnsentReports() {
        return this.controller.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(Boolean bl2) {
        this.dataCollectionArbiter.setCrashlyticsDataCollectionEnabled(bl2);
    }

    public void setCustomKey(String string2, String string3) {
        this.controller.setCustomKey(string2, string3);
    }

    public void setCustomKeys(Map map) {
        this.controller.setCustomKeys(map);
    }

    public void setUserId(String string2) {
        this.controller.setUserId(string2);
    }
}


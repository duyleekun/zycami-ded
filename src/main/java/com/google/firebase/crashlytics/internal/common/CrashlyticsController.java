/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.StatFs
 */
package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.BytesBackedNativeSessionFile;
import com.google.firebase.crashlytics.internal.common.CLSUUID;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$$Lambda$1;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$1;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$10;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$2;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$3;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$4;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$5;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$6;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$7;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$8;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$9;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.CrashlyticsFileMarker;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.FileBackedNativeSessionFile;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.MetaDataStore;
import com.google.firebase.crashlytics.internal.common.NativeSessionFileGzipper;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.log.LogFileManager$DirectoryProvider;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrashlyticsController {
    public static final FilenameFilter APP_EXCEPTION_MARKER_FILTER = CrashlyticsController$$Lambda$1.lambdaFactory$();
    public static final String APP_EXCEPTION_MARKER_PREFIX = ".ae";
    public static final String FIREBASE_APPLICATION_EXCEPTION = "_ae";
    public static final String FIREBASE_CRASH_TYPE = "fatal";
    public static final int FIREBASE_CRASH_TYPE_FATAL = 1;
    public static final String FIREBASE_TIMESTAMP = "timestamp";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    public static final String NATIVE_SESSION_DIR = "native-sessions";
    private final AnalyticsEventLogger analyticsEventLogger;
    private final AppData appData;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    public final AtomicBoolean checkForUnsentReportsCalled;
    private final Context context;
    private CrashlyticsUncaughtExceptionHandler crashHandler;
    private final CrashlyticsFileMarker crashMarker;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final FileStore fileStore;
    private final IdManager idManager;
    private final LogFileManager$DirectoryProvider logFileDirectoryProvider;
    private final LogFileManager logFileManager;
    private final CrashlyticsNativeComponent nativeComponent;
    public final TaskCompletionSource reportActionProvided;
    private final SessionReportingCoordinator reportingCoordinator;
    private final String unityVersion;
    public final TaskCompletionSource unsentReportsAvailable;
    public final TaskCompletionSource unsentReportsHandled;
    private final UserMetadata userMetadata;

    public CrashlyticsController(Context object, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData, UserMetadata userMetadata, LogFileManager logFileManager, LogFileManager$DirectoryProvider directoryProvider, SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger) {
        Object object2 = new TaskCompletionSource();
        this.unsentReportsAvailable = object2;
        object2 = new TaskCompletionSource();
        this.reportActionProvided = object2;
        object2 = new TaskCompletionSource();
        this.unsentReportsHandled = object2;
        this.checkForUnsentReportsCalled = object2 = new AtomicBoolean(false);
        this.context = object;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.idManager = idManager;
        this.dataCollectionArbiter = dataCollectionArbiter;
        this.fileStore = fileStore;
        this.crashMarker = crashlyticsFileMarker;
        this.appData = appData;
        this.userMetadata = userMetadata;
        this.logFileManager = logFileManager;
        this.logFileDirectoryProvider = directoryProvider;
        this.nativeComponent = crashlyticsNativeComponent;
        object = appData.unityVersionProvider.getUnityVersion();
        this.unityVersion = object;
        this.analyticsEventLogger = analyticsEventLogger;
        this.reportingCoordinator = sessionReportingCoordinator;
    }

    public static /* synthetic */ long access$000(Date date) {
        return CrashlyticsController.getTimestampSeconds(date);
    }

    public static /* synthetic */ String access$100(CrashlyticsController crashlyticsController) {
        return crashlyticsController.getCurrentSessionId();
    }

    public static /* synthetic */ LogFileManager access$1000(CrashlyticsController crashlyticsController) {
        return crashlyticsController.logFileManager;
    }

    public static /* synthetic */ AnalyticsEventLogger access$1100(CrashlyticsController crashlyticsController) {
        return crashlyticsController.analyticsEventLogger;
    }

    public static /* synthetic */ CrashlyticsFileMarker access$200(CrashlyticsController crashlyticsController) {
        return crashlyticsController.crashMarker;
    }

    public static /* synthetic */ SessionReportingCoordinator access$300(CrashlyticsController crashlyticsController) {
        return crashlyticsController.reportingCoordinator;
    }

    public static /* synthetic */ void access$400(CrashlyticsController crashlyticsController, long l10) {
        crashlyticsController.doWriteAppExceptionMarker(l10);
    }

    public static /* synthetic */ void access$500(CrashlyticsController crashlyticsController) {
        crashlyticsController.doOpenSession();
    }

    public static /* synthetic */ DataCollectionArbiter access$600(CrashlyticsController crashlyticsController) {
        return crashlyticsController.dataCollectionArbiter;
    }

    public static /* synthetic */ CrashlyticsBackgroundWorker access$700(CrashlyticsController crashlyticsController) {
        return crashlyticsController.backgroundWorker;
    }

    public static /* synthetic */ Task access$800(CrashlyticsController crashlyticsController) {
        return crashlyticsController.logAnalyticsAppExceptionEvents();
    }

    public static /* synthetic */ void access$900(File[] fileArray) {
        CrashlyticsController.deleteFiles(fileArray);
    }

    private void cacheKeyData(Map map) {
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = this.backgroundWorker;
        CrashlyticsController$8 crashlyticsController$8 = new CrashlyticsController$8(this, map);
        crashlyticsBackgroundWorker.submit(crashlyticsController$8);
    }

    private void cacheUserData(UserMetadata userMetadata) {
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = this.backgroundWorker;
        CrashlyticsController$7 crashlyticsController$7 = new CrashlyticsController$7(this, userMetadata);
        crashlyticsBackgroundWorker.submit(crashlyticsController$7);
    }

    private static void deleteFiles(File[] fileArray) {
        if (fileArray == null) {
            return;
        }
        for (File file : fileArray) {
            file.delete();
        }
    }

    private void doCloseSessions(boolean n10) {
        SessionReportingCoordinator sessionReportingCoordinator;
        List list = this.reportingCoordinator.listSortedOpenSessionIds();
        int n11 = list.size();
        if (n11 <= n10) {
            Logger.getLogger().v("No open sessions to be closed.");
            return;
        }
        Object object = this.nativeComponent;
        Object object2 = (String)list.get(n10);
        boolean bl2 = object.hasCrashDataForSession((String)object2);
        if (bl2) {
            this.finalizePreviousNativeSession((String)object2);
            object = this.nativeComponent;
            bl2 = object.finalizeSession((String)object2);
            if (!bl2) {
                object = Logger.getLogger();
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "Could not finalize native session: ";
                stringBuilder.append(string2);
                stringBuilder.append((String)object2);
                object2 = stringBuilder.toString();
                ((Logger)object).w((String)object2);
            }
        }
        n11 = 0;
        object2 = null;
        if (n10 != 0) {
            n10 = 0;
            sessionReportingCoordinator = list.get(0);
            object2 = sessionReportingCoordinator;
            object2 = (String)((Object)sessionReportingCoordinator);
        }
        sessionReportingCoordinator = this.reportingCoordinator;
        long l10 = CrashlyticsController.getCurrentTimestampSeconds();
        sessionReportingCoordinator.finalizeSessions(l10, (String)object2);
    }

    private void doOpenSession() {
        long l10 = CrashlyticsController.getCurrentTimestampSeconds();
        Object object = this.idManager;
        Object object2 = new CLSUUID((IdManager)object);
        object2 = ((CLSUUID)object2).toString();
        object = Logger.getLogger();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Opening a new session with ID ");
        charSequence.append((String)object2);
        charSequence = charSequence.toString();
        ((Logger)object).d((String)charSequence);
        this.nativeComponent.openSession((String)object2);
        this.writeBeginSession((String)object2, l10);
        this.writeSessionApp((String)object2);
        this.writeSessionOS((String)object2);
        this.writeSessionDevice((String)object2);
        this.logFileManager.setCurrentSession((String)object2);
        this.reportingCoordinator.onBeginSession((String)object2, l10);
    }

    private void doWriteAppExceptionMarker(long l10) {
        Object object;
        File file = this.getFilesDir();
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = APP_EXCEPTION_MARKER_PREFIX;
        stringBuilder.append(string2);
        stringBuilder.append(l10);
        String string3 = stringBuilder.toString();
        try {
            object = new File(file, string3);
            ((File)object).createNewFile();
        }
        catch (IOException iOException) {
            Logger logger = Logger.getLogger();
            object = "Could not create app exception marker file.";
            logger.w((String)object, iOException);
        }
    }

    private static File[] ensureFileArrayNotNull(File[] fileArray) {
        if (fileArray == null) {
            fileArray = new File[]{};
        }
        return fileArray;
    }

    private void finalizePreviousNativeSession(String string2) {
        boolean bl2;
        Object object = Logger.getLogger();
        Object object2 = new StringBuilder();
        Object object3 = "Finalizing native report for session ";
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        ((Logger)object).v((String)object2);
        object = this.nativeComponent.getSessionFileProvider(string2);
        object2 = object.getMinidumpFile();
        if (object2 != null && (bl2 = ((File)object2).exists())) {
            long l10 = ((File)object2).lastModified();
            Object object4 = this.context;
            Object object5 = this.logFileDirectoryProvider;
            LogFileManager logFileManager = new LogFileManager((Context)object4, (LogFileManager$DirectoryProvider)object5, string2);
            object5 = this.getNativeSessionFilesDir();
            object4 = new File((File)object5, string2);
            boolean bl3 = ((File)object4).mkdirs();
            if (!bl3) {
                Logger.getLogger().w("Couldn't create directory to store native session files, aborting.");
                return;
            }
            this.doWriteAppExceptionMarker(l10);
            object2 = this.getFilesDir();
            object3 = logFileManager.getBytesForLog();
            object = CrashlyticsController.getNativeSessionFiles((NativeSessionFileProvider)object, string2, (File)object2, (byte[])object3);
            NativeSessionFileGzipper.processNativeSessions((File)object4, (List)object);
            this.reportingCoordinator.finalizeSessionWithNativeEvent(string2, (List)object);
            logFileManager.clearLog();
            return;
        }
        object = Logger.getLogger();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("No minidump data found for session ");
        ((StringBuilder)object2).append(string2);
        string2 = ((StringBuilder)object2).toString();
        ((Logger)object).w(string2);
    }

    private static boolean firebaseCrashExists() {
        String string2 = "com.google.firebase.crash.FirebaseCrash";
        try {
            Class.forName(string2);
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    private Context getContext() {
        return this.context;
    }

    private String getCurrentSessionId() {
        Object object = this.reportingCoordinator.listSortedOpenSessionIds();
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            bl2 = false;
            object = (String)object.get(0);
        } else {
            object = null;
        }
        return object;
    }

    private static long getCurrentTimestampSeconds() {
        Date date = new Date();
        return CrashlyticsController.getTimestampSeconds(date);
    }

    public static List getNativeSessionFiles(NativeSessionFileProvider object, String object2, File file, byte[] object3) {
        ArrayList<BytesBackedNativeSessionFile> arrayList = new ArrayList<BytesBackedNativeSessionFile>(file);
        file = ((MetaDataStore)((Object)arrayList)).getUserDataFileForSession((String)object2);
        object2 = ((MetaDataStore)((Object)arrayList)).getKeysFileForSession((String)object2);
        arrayList = new ArrayList<BytesBackedNativeSessionFile>();
        Object object4 = new BytesBackedNativeSessionFile("logs_file", "logs", (byte[])object3);
        arrayList.add((BytesBackedNativeSessionFile)object4);
        object3 = new FileBackedNativeSessionFile;
        object4 = object.getMetadataFile();
        object3("crash_meta_file", "metadata", (File)object4);
        arrayList.add((BytesBackedNativeSessionFile)object3);
        object3 = new FileBackedNativeSessionFile;
        object4 = object.getSessionFile();
        object3("session_meta_file", "session", (File)object4);
        arrayList.add((BytesBackedNativeSessionFile)object3);
        object3 = new FileBackedNativeSessionFile;
        object4 = object.getAppFile();
        object3("app_meta_file", "app", (File)object4);
        arrayList.add((BytesBackedNativeSessionFile)object3);
        object3 = new FileBackedNativeSessionFile;
        object4 = object.getDeviceFile();
        object3("device_meta_file", "device", (File)object4);
        arrayList.add((BytesBackedNativeSessionFile)object3);
        object3 = new FileBackedNativeSessionFile;
        object4 = object.getOsFile();
        object3("os_meta_file", "os", (File)object4);
        arrayList.add((BytesBackedNativeSessionFile)object3);
        object3 = new FileBackedNativeSessionFile;
        object = object.getMinidumpFile();
        object3("minidump_file", "minidump", (File)object);
        arrayList.add((BytesBackedNativeSessionFile)object3);
        object = new FileBackedNativeSessionFile("user_meta_file", "user", file);
        arrayList.add((BytesBackedNativeSessionFile)object);
        object = new FileBackedNativeSessionFile("keys_file", "keys", (File)object2);
        arrayList.add((BytesBackedNativeSessionFile)object);
        return arrayList;
    }

    private static long getTimestampSeconds(Date date) {
        return date.getTime() / 1000L;
    }

    public static /* synthetic */ boolean lambda$static$0(File file, String string2) {
        return string2.startsWith(APP_EXCEPTION_MARKER_PREFIX);
    }

    private static File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return CrashlyticsController.ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }

    private File[] listFilesMatching(FilenameFilter filenameFilter) {
        return CrashlyticsController.listFilesMatching(this.getFilesDir(), filenameFilter);
    }

    private Task logAnalyticsAppExceptionEvent(long l10) {
        boolean bl2 = CrashlyticsController.firebaseCrashExists();
        if (bl2) {
            Logger.getLogger().w("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        Logger.getLogger().d("Logging app exception event to Firebase Analytics");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        CrashlyticsController$10 crashlyticsController$10 = new CrashlyticsController$10(this, l10);
        return Tasks.call(scheduledThreadPoolExecutor, crashlyticsController$10);
    }

    private Task logAnalyticsAppExceptionEvents() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (File file : this.listAppExceptionMarkerFiles()) {
            Object object = file.getName();
            int n10 = 3;
            object = ((String)object).substring(n10);
            long l10 = Long.parseLong((String)object);
            object = this.logAnalyticsAppExceptionEvent(l10);
            try {
                arrayList.add(object);
            }
            catch (NumberFormatException numberFormatException) {
                object = Logger.getLogger();
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Could not parse app exception timestamp from file ");
                String string2 = file.getName();
                charSequence.append(string2);
                charSequence = charSequence.toString();
                ((Logger)object).w((String)charSequence);
            }
            file.delete();
        }
        return Tasks.whenAll(arrayList);
    }

    private Task waitForReportAction() {
        Object object = Boolean.TRUE;
        Object object2 = this.dataCollectionArbiter;
        boolean bl2 = ((DataCollectionArbiter)object2).isAutomaticDataCollectionEnabled();
        if (bl2) {
            Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
            object2 = this.unsentReportsAvailable;
            Boolean bl3 = Boolean.FALSE;
            ((TaskCompletionSource)object2).trySetResult(bl3);
            return Tasks.forResult(object);
        }
        Logger.getLogger().d("Automatic data collection is disabled.");
        Logger.getLogger().v("Notifying that unsent reports are available.");
        this.unsentReportsAvailable.trySetResult(object);
        object = this.dataCollectionArbiter.waitForAutomaticDataCollectionEnabled();
        object2 = new CrashlyticsController$3(this);
        object = ((Task)object).onSuccessTask((SuccessContinuation)object2);
        Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
        object2 = this.reportActionProvided.getTask();
        return Utils.race((Task)object, (Task)object2);
    }

    private void writeBeginSession(String string2, long l10) {
        Object object = Locale.US;
        Object[] objectArray = new Object[1];
        String string3 = CrashlyticsCore.getVersion();
        objectArray[0] = string3;
        object = String.format((Locale)object, GENERATOR_FORMAT, objectArray);
        this.nativeComponent.writeBeginSession(string2, (String)object, l10);
    }

    private void writeSessionApp(String string2) {
        String string3 = this.idManager.getAppIdentifier();
        AppData appData = this.appData;
        String string4 = appData.versionCode;
        String string5 = appData.versionName;
        String string6 = this.idManager.getCrashlyticsInstallId();
        int n10 = DeliveryMechanism.determineFrom(this.appData.installerPackageName).getId();
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.nativeComponent;
        String string7 = this.unityVersion;
        crashlyticsNativeComponent.writeSessionApp(string2, string3, string4, string5, string6, n10, string7);
    }

    private void writeSessionDevice(String string2) {
        Object object = this.getContext();
        String string3 = Environment.getDataDirectory().getPath();
        StatFs statFs = new StatFs(string3);
        int n10 = CommonUtils.getCpuArchitectureInt();
        String string4 = Build.MODEL;
        int n11 = Runtime.getRuntime().availableProcessors();
        long l10 = CommonUtils.getTotalRamInBytes();
        long l11 = statFs.getBlockCount();
        long l12 = (long)statFs.getBlockSize() * l11;
        boolean bl2 = CommonUtils.isEmulator(object);
        int n12 = CommonUtils.getDeviceState(object);
        String string5 = Build.MANUFACTURER;
        String string6 = Build.PRODUCT;
        object = this;
        this.nativeComponent.writeSessionDevice(string2, n10, string4, n11, l10, l12, bl2, n12, string5, string6);
    }

    private void writeSessionOS(String string2) {
        String string3 = Build.VERSION.RELEASE;
        String string4 = Build.VERSION.CODENAME;
        boolean bl2 = CommonUtils.isRooted(this.getContext());
        this.nativeComponent.writeSessionOs(string2, string3, string4, bl2);
    }

    public Task checkForUnsentReports() {
        AtomicBoolean atomicBoolean = this.checkForUnsentReportsCalled;
        boolean bl2 = true;
        boolean bl3 = atomicBoolean.compareAndSet(false, bl2);
        if (!bl3) {
            Logger.getLogger().w("checkForUnsentReports should only be called once per execution.");
            return Tasks.forResult(Boolean.FALSE);
        }
        return this.unsentReportsAvailable.getTask();
    }

    public Task deleteUnsentReports() {
        TaskCompletionSource taskCompletionSource = this.reportActionProvided;
        Boolean bl2 = Boolean.FALSE;
        taskCompletionSource.trySetResult(bl2);
        return this.unsentReportsHandled.getTask();
    }

    public boolean didCrashOnPreviousExecution() {
        Object object = this.crashMarker;
        boolean bl2 = ((CrashlyticsFileMarker)object).isPresent();
        boolean bl3 = true;
        if (!bl2) {
            CrashlyticsNativeComponent crashlyticsNativeComponent;
            object = this.getCurrentSessionId();
            if (object == null || !(bl2 = (crashlyticsNativeComponent = this.nativeComponent).hasCrashDataForSession((String)object))) {
                bl3 = false;
            }
            return bl3;
        }
        Logger.getLogger().v("Found previous crash marker.");
        this.crashMarker.remove();
        return bl3;
    }

    public void doCloseSessions() {
        this.doCloseSessions(false);
    }

    public void enableExceptionHandling(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsDataProvider settingsDataProvider) {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler;
        this.openSession();
        CrashlyticsController$1 crashlyticsController$1 = new CrashlyticsController$1(this);
        this.crashHandler = crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(crashlyticsController$1, settingsDataProvider, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }

    public boolean finalizeSessions() {
        Object object = this.backgroundWorker;
        ((CrashlyticsBackgroundWorker)object).checkRunningOnThread();
        boolean bl2 = this.isHandlingException();
        if (bl2) {
            Logger.getLogger().w("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        object = Logger.getLogger();
        String string2 = "Finalizing previously open sessions.";
        ((Logger)object).v(string2);
        bl2 = true;
        try {
            this.doCloseSessions(bl2);
            Logger.getLogger().v("Closed all previously open sessions.");
            return bl2;
        }
        catch (Exception exception) {
            Logger.getLogger().e("Unable to finalize previously open sessions.", exception);
            return false;
        }
    }

    public File getFilesDir() {
        return this.fileStore.getFilesDir();
    }

    public File getNativeSessionFilesDir() {
        File file = this.getFilesDir();
        File file2 = new File(file, NATIVE_SESSION_DIR);
        return file2;
    }

    public UserMetadata getUserMetadata() {
        return this.userMetadata;
    }

    public void handleUncaughtException(SettingsDataProvider object, Thread object2, Throwable object3) {
        synchronized (this) {
            Object object4 = Logger.getLogger();
            Object object5 = new StringBuilder();
            Object object6 = "Handling uncaught exception \"";
            ((StringBuilder)object5).append((String)object6);
            ((StringBuilder)object5).append(object3);
            object6 = "\" from thread ";
            ((StringBuilder)object5).append((String)object6);
            object6 = ((Thread)object2).getName();
            ((StringBuilder)object5).append((String)object6);
            object5 = ((StringBuilder)object5).toString();
            ((Logger)object4).d((String)object5);
            Date date = new Date();
            object4 = this.backgroundWorker;
            object6 = object5;
            object5 = new CrashlyticsController$2(this, date, (Throwable)object3, (Thread)object2, (SettingsDataProvider)object);
            object = ((CrashlyticsBackgroundWorker)object4).submitTask((Callable)object5);
            Utils.awaitEvenIfOnMainThread((Task)object);
            return;
        }
    }

    public boolean isHandlingException() {
        boolean bl2;
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.crashHandler;
        if (crashlyticsUncaughtExceptionHandler != null && (bl2 = crashlyticsUncaughtExceptionHandler.isHandlingException())) {
            bl2 = true;
        } else {
            bl2 = false;
            crashlyticsUncaughtExceptionHandler = null;
        }
        return bl2;
    }

    public File[] listAppExceptionMarkerFiles() {
        FilenameFilter filenameFilter = APP_EXCEPTION_MARKER_FILTER;
        return this.listFilesMatching(filenameFilter);
    }

    public File[] listNativeSessionFileDirectories() {
        return CrashlyticsController.ensureFileArrayNotNull(this.getNativeSessionFilesDir().listFiles());
    }

    public void openSession() {
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = this.backgroundWorker;
        CrashlyticsController$9 crashlyticsController$9 = new CrashlyticsController$9(this);
        crashlyticsBackgroundWorker.submit(crashlyticsController$9);
    }

    public Task sendUnsentReports() {
        TaskCompletionSource taskCompletionSource = this.reportActionProvided;
        Boolean bl2 = Boolean.TRUE;
        taskCompletionSource.trySetResult(bl2);
        return this.unsentReportsHandled.getTask();
    }

    public void setCustomKey(String object, String string2) {
        UserMetadata userMetadata;
        try {
            userMetadata = this.userMetadata;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            boolean bl2;
            string2 = this.context;
            if (string2 != null && (bl2 = CommonUtils.isAppDebuggable((Context)string2))) {
                throw illegalArgumentException;
            }
            Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
            return;
        }
        userMetadata.setCustomKey((String)object, string2);
        object = this.userMetadata.getCustomKeys();
        this.cacheKeyData((Map)object);
    }

    public void setCustomKeys(Map map) {
        this.userMetadata.setCustomKeys(map);
        map = this.userMetadata.getCustomKeys();
        this.cacheKeyData(map);
    }

    public void setUserId(String object) {
        this.userMetadata.setUserId((String)object);
        object = this.userMetadata;
        this.cacheUserData((UserMetadata)object);
    }

    public Task submitAllReports(Task object) {
        Object object2 = this.reportingCoordinator;
        boolean bl2 = ((SessionReportingCoordinator)object2).hasReportsToSend();
        if (!bl2) {
            Logger.getLogger().v("No crash reports are available to be sent.");
            object = this.unsentReportsAvailable;
            object2 = Boolean.FALSE;
            ((TaskCompletionSource)object).trySetResult(object2);
            return Tasks.forResult(null);
        }
        Logger.getLogger().v("Crash reports are available to be sent.");
        object2 = this.waitForReportAction();
        CrashlyticsController$4 crashlyticsController$4 = new CrashlyticsController$4(this, (Task)object);
        return ((Task)object2).onSuccessTask(crashlyticsController$4);
    }

    public void writeNonFatalException(Thread thread, Throwable throwable) {
        Date date = new Date();
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = this.backgroundWorker;
        CrashlyticsController$6 crashlyticsController$6 = new CrashlyticsController$6(this, date, throwable, thread);
        crashlyticsBackgroundWorker.submit(crashlyticsController$6);
    }

    public void writeToLog(long l10, String string2) {
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = this.backgroundWorker;
        CrashlyticsController$5 crashlyticsController$5 = new CrashlyticsController$5(this, l10, string2);
        crashlyticsBackgroundWorker.submit(crashlyticsController$5);
    }
}


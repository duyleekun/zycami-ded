/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.NativeSessionFile;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator$$Lambda$1;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator$$Lambda$2;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log$Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class SessionReportingCoordinator
implements CrashlyticsLifecycleEvents {
    private static final int EVENT_THREAD_IMPORTANCE = 4;
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final int MAX_CHAINED_EXCEPTION_DEPTH = 8;
    private final CrashlyticsReportDataCapture dataCapture;
    private final LogFileManager logFileManager;
    private final UserMetadata reportMetadata;
    private final CrashlyticsReportPersistence reportPersistence;
    private final DataTransportCrashlyticsReportSender reportsSender;

    public SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager, UserMetadata userMetadata) {
        this.dataCapture = crashlyticsReportDataCapture;
        this.reportPersistence = crashlyticsReportPersistence;
        this.reportsSender = dataTransportCrashlyticsReportSender;
        this.logFileManager = logFileManager;
        this.reportMetadata = userMetadata;
    }

    public static /* synthetic */ boolean access$lambda$0(SessionReportingCoordinator sessionReportingCoordinator, Task task) {
        return sessionReportingCoordinator.onReportSendComplete(task);
    }

    public static SessionReportingCoordinator create(Context object, IdManager idManager, FileStore object2, AppData appData, LogFileManager logFileManager, UserMetadata userMetadata, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsDataProvider settingsDataProvider) {
        object2 = object2.getFilesDirPath();
        File file = new File((String)object2);
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = new CrashlyticsReportDataCapture((Context)object, idManager, appData, stackTraceTrimmingStrategy);
        CrashlyticsReportPersistence crashlyticsReportPersistence = new CrashlyticsReportPersistence(file, settingsDataProvider);
        DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender = DataTransportCrashlyticsReportSender.create(object);
        object = new SessionReportingCoordinator(crashlyticsReportDataCapture, crashlyticsReportPersistence, dataTransportCrashlyticsReportSender, logFileManager, userMetadata);
        return object;
    }

    private static List getSortedCustomAttributes(Map object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = object.size();
        arrayList.ensureCapacity(n10);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (Map.Entry)object.next();
            CrashlyticsReport$CustomAttribute$Builder crashlyticsReport$CustomAttribute$Builder = CrashlyticsReport$CustomAttribute.builder();
            String string2 = (String)object2.getKey();
            crashlyticsReport$CustomAttribute$Builder = crashlyticsReport$CustomAttribute$Builder.setKey(string2);
            object2 = (String)object2.getValue();
            object2 = crashlyticsReport$CustomAttribute$Builder.setValue((String)object2).build();
            arrayList.add(object2);
        }
        object = SessionReportingCoordinator$$Lambda$2.lambdaFactory$();
        Collections.sort(arrayList, object);
        return arrayList;
    }

    public static /* synthetic */ int lambda$getSortedCustomAttributes$0(CrashlyticsReport$CustomAttribute object, CrashlyticsReport$CustomAttribute object2) {
        object = ((CrashlyticsReport$CustomAttribute)object).getKey();
        object2 = ((CrashlyticsReport$CustomAttribute)object2).getKey();
        return ((String)object).compareTo((String)object2);
    }

    private boolean onReportSendComplete(Task object) {
        boolean bl2 = ((Task)object).isSuccessful();
        if (bl2) {
            object = (CrashlyticsReportWithSessionId)((Task)object).getResult();
            Object object2 = Logger.getLogger();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Crashlytics report successfully enqueued to DataTransport: ");
            String string2 = ((CrashlyticsReportWithSessionId)object).getSessionId();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            ((Logger)object2).d((String)charSequence);
            object2 = this.reportPersistence;
            object = ((CrashlyticsReportWithSessionId)object).getSessionId();
            ((CrashlyticsReportPersistence)object2).deleteFinalizedReport((String)object);
            return true;
        }
        Logger logger = Logger.getLogger();
        object = ((Task)object).getException();
        logger.w("Crashlytics report could not be enqueued to DataTransport", (Throwable)object);
        return false;
    }

    private void persistEvent(Throwable throwable, Thread thread, String string2, String string3, long l10, boolean bl2) {
        SessionReportingCoordinator sessionReportingCoordinator = this;
        String string4 = EVENT_TYPE_CRASH;
        Object object = string3;
        boolean bl3 = string3.equals(string4);
        Object object2 = this.dataCapture;
        int n10 = 4;
        int n11 = 8;
        Object object3 = throwable;
        Object object4 = thread;
        object2 = ((CrashlyticsReportDataCapture)object2).captureEventData(throwable, thread, string3, l10, n10, n11, bl2);
        object3 = ((CrashlyticsReport$Session$Event)object2).toBuilder();
        object4 = this.logFileManager.getLogString();
        if (object4 != null) {
            object = CrashlyticsReport$Session$Event$Log.builder();
            object4 = ((CrashlyticsReport$Session$Event$Log$Builder)object).setContent((String)object4).build();
            ((CrashlyticsReport$Session$Event$Builder)object3).setLog((CrashlyticsReport$Session$Event$Log)object4);
        } else {
            object4 = Logger.getLogger();
            object = "No log data to include with this event.";
            ((Logger)object4).v((String)object);
        }
        object4 = SessionReportingCoordinator.getSortedCustomAttributes(sessionReportingCoordinator.reportMetadata.getCustomKeys());
        boolean bl4 = object4.isEmpty();
        if (!bl4) {
            object2 = ((CrashlyticsReport$Session$Event)object2).getApp().toBuilder();
            object4 = ImmutableList.from((List)object4);
            object2 = ((CrashlyticsReport$Session$Event$Application$Builder)object2).setCustomAttributes((ImmutableList)object4).build();
            ((CrashlyticsReport$Session$Event$Builder)object3).setApp((CrashlyticsReport$Session$Event$Application)object2);
        }
        object2 = sessionReportingCoordinator.reportPersistence;
        object3 = ((CrashlyticsReport$Session$Event$Builder)object3).build();
        object4 = string2;
        ((CrashlyticsReportPersistence)object2).persistEvent((CrashlyticsReport$Session$Event)object3, string2, bl3);
    }

    public void finalizeSessionWithNativeEvent(String string2, List object) {
        Object object2;
        boolean bl2;
        Object object3 = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = ((NativeSessionFile)object.next()).asFilePayload();
            if (object2 == null) continue;
            ((ArrayList)object3).add(object2);
        }
        object = this.reportPersistence;
        object2 = CrashlyticsReport$FilesPayload.builder();
        object3 = ImmutableList.from(object3);
        object3 = ((CrashlyticsReport$FilesPayload$Builder)object2).setFiles((ImmutableList)object3).build();
        ((CrashlyticsReportPersistence)object).finalizeSessionWithNativeEvent(string2, (CrashlyticsReport$FilesPayload)object3);
    }

    public void finalizeSessions(long l10, String string2) {
        this.reportPersistence.finalizeReports(string2, l10);
    }

    public boolean hasReportsToSend() {
        return this.reportPersistence.hasFinalizedReports();
    }

    public List listSortedOpenSessionIds() {
        return this.reportPersistence.listSortedOpenSessionIds();
    }

    public void onBeginSession(String object, long l10) {
        object = this.dataCapture.captureReportData((String)object, l10);
        this.reportPersistence.persistReport((CrashlyticsReport)object);
    }

    public void onCustomKey(String string2, String string3) {
        this.reportMetadata.setCustomKey(string2, string3);
    }

    public void onLog(long l10, String string2) {
        this.logFileManager.writeToLog(l10, string2);
    }

    public void onUserId(String string2) {
        this.reportMetadata.setUserId(string2);
    }

    public void persistFatalEvent(Throwable throwable, Thread thread, String string2, long l10) {
        Logger logger = Logger.getLogger();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Persisting fatal event for session ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        logger.v((String)charSequence);
        this.persistEvent(throwable, thread, string2, EVENT_TYPE_CRASH, l10, true);
    }

    public void persistNonFatalEvent(Throwable throwable, Thread thread, String string2, long l10) {
        Logger logger = Logger.getLogger();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Persisting non-fatal event for session ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        logger.v((String)charSequence);
        this.persistEvent(throwable, thread, string2, EVENT_TYPE_LOGGED, l10, false);
    }

    public void persistUserId(String string2) {
        String string3 = this.reportMetadata.getUserId();
        if (string3 == null) {
            Logger.getLogger().v("Could not persist user ID; no user ID available");
            return;
        }
        this.reportPersistence.persistUserIdForSession(string3, string2);
    }

    public void removeAllReports() {
        this.reportPersistence.deleteAllReports();
    }

    public Task sendReports(Executor executor) {
        boolean bl2;
        Object object = this.reportPersistence.loadFinalizedReports();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (CrashlyticsReportWithSessionId)object.next();
            object2 = this.reportsSender.sendReport((CrashlyticsReportWithSessionId)object2);
            Continuation continuation = SessionReportingCoordinator$$Lambda$1.lambdaFactory$(this);
            object2 = ((Task)object2).continueWith(executor, continuation);
            arrayList.add(object2);
        }
        return Tasks.whenAll(arrayList);
    }
}


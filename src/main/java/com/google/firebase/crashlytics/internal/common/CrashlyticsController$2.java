/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$2$1;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class CrashlyticsController$2
implements Callable {
    public final /* synthetic */ CrashlyticsController this$0;
    public final /* synthetic */ Throwable val$ex;
    public final /* synthetic */ SettingsDataProvider val$settingsDataProvider;
    public final /* synthetic */ Thread val$thread;
    public final /* synthetic */ Date val$time;

    public CrashlyticsController$2(CrashlyticsController crashlyticsController, Date date, Throwable throwable, Thread thread, SettingsDataProvider settingsDataProvider) {
        this.this$0 = crashlyticsController;
        this.val$time = date;
        this.val$ex = throwable;
        this.val$thread = thread;
        this.val$settingsDataProvider = settingsDataProvider;
    }

    public Task call() {
        long l10 = CrashlyticsController.access$000(this.val$time);
        String string2 = CrashlyticsController.access$100(this.this$0);
        Executor executor = null;
        if (string2 == null) {
            Logger.getLogger().e("Tried to write a fatal exception while no session was open.");
            return Tasks.forResult(null);
        }
        CrashlyticsController.access$200(this.this$0).create();
        Object object = CrashlyticsController.access$300(this.this$0);
        Object object2 = this.val$ex;
        Thread thread = this.val$thread;
        ((SessionReportingCoordinator)object).persistFatalEvent((Throwable)object2, thread, string2, l10);
        object = this.this$0;
        object2 = this.val$time;
        long l11 = ((Date)object2).getTime();
        CrashlyticsController.access$400((CrashlyticsController)object, l11);
        this.this$0.doCloseSessions();
        CrashlyticsController.access$500(this.this$0);
        object = CrashlyticsController.access$600(this.this$0);
        boolean bl2 = ((DataCollectionArbiter)object).isAutomaticDataCollectionEnabled();
        if (!bl2) {
            return Tasks.forResult(null);
        }
        executor = CrashlyticsController.access$700(this.this$0).getExecutor();
        object = this.val$settingsDataProvider.getAppSettings();
        object2 = new CrashlyticsController$2$1(this, executor);
        return ((Task)object).onSuccessTask(executor, (SuccessContinuation)object2);
    }
}


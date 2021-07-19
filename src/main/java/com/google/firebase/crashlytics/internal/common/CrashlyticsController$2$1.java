/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$2;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.util.concurrent.Executor;

public class CrashlyticsController$2$1
implements SuccessContinuation {
    public final /* synthetic */ CrashlyticsController$2 this$1;
    public final /* synthetic */ Executor val$executor;

    public CrashlyticsController$2$1(CrashlyticsController$2 crashlyticsController$2, Executor executor) {
        this.this$1 = crashlyticsController$2;
        this.val$executor = executor;
    }

    public Task then(AppSettingsData taskArray) {
        if (taskArray == null) {
            Logger.getLogger().w("Received null app settings, cannot send reports at crash time.");
            return Tasks.forResult(null);
        }
        taskArray = new Task[2];
        Object object = CrashlyticsController.access$800(this.this$1.this$0);
        taskArray[0] = object;
        object = CrashlyticsController.access$300(this.this$1.this$0);
        Executor executor = this.val$executor;
        taskArray[1] = object = ((SessionReportingCoordinator)object).sendReports(executor);
        return Tasks.whenAll(taskArray);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$4$1;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.util.concurrent.Executor;

public class CrashlyticsController$4$1$1
implements SuccessContinuation {
    public final /* synthetic */ CrashlyticsController$4$1 this$2;
    public final /* synthetic */ Executor val$executor;

    public CrashlyticsController$4$1$1(CrashlyticsController$4$1 crashlyticsController$4$1, Executor executor) {
        this.this$2 = crashlyticsController$4$1;
        this.val$executor = executor;
    }

    public Task then(AppSettingsData object) {
        if (object == null) {
            Logger.getLogger().w("Received null app settings at app startup. Cannot send cached reports");
            return Tasks.forResult(null);
        }
        CrashlyticsController.access$800(this.this$2.this$1.this$0);
        object = CrashlyticsController.access$300(this.this$2.this$1.this$0);
        Executor executor = this.val$executor;
        ((SessionReportingCoordinator)object).sendReports(executor);
        this.this$2.this$1.this$0.unsentReportsHandled.trySetResult(null);
        return Tasks.forResult(null);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$4;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$4$1$1;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class CrashlyticsController$4$1
implements Callable {
    public final /* synthetic */ CrashlyticsController$4 this$1;
    public final /* synthetic */ Boolean val$send;

    public CrashlyticsController$4$1(CrashlyticsController$4 var1_1, Boolean bl2) {
        this.this$1 = var1_1;
        this.val$send = bl2;
    }

    public Task call() {
        Object object = this.val$send;
        boolean bl2 = (Boolean)object;
        if (!bl2) {
            Logger.getLogger().v("Deleting cached crash reports...");
            CrashlyticsController.access$900(this.this$1.this$0.listAppExceptionMarkerFiles());
            CrashlyticsController.access$300(this.this$1.this$0).removeAllReports();
            this.this$1.this$0.unsentReportsHandled.trySetResult(null);
            return Tasks.forResult(null);
        }
        Logger.getLogger().d("Sending cached crash reports...");
        bl2 = this.val$send;
        CrashlyticsController.access$600(this.this$1.this$0).grantDataCollectionPermission(bl2);
        object = CrashlyticsController.access$700(this.this$1.this$0).getExecutor();
        Task task = this.this$1.val$appSettingsDataTask;
        CrashlyticsController$4$1$1 crashlyticsController$4$1$1 = new CrashlyticsController$4$1$1(this, (Executor)object);
        return task.onSuccessTask((Executor)object, crashlyticsController$4$1$1);
    }
}


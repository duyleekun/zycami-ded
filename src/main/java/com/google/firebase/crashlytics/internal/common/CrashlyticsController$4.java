/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController$4$1;

public class CrashlyticsController$4
implements SuccessContinuation {
    public final /* synthetic */ CrashlyticsController this$0;
    public final /* synthetic */ Task val$appSettingsDataTask;

    public CrashlyticsController$4(CrashlyticsController crashlyticsController, Task task) {
        this.this$0 = crashlyticsController;
        this.val$appSettingsDataTask = task;
    }

    public Task then(Boolean bl2) {
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = CrashlyticsController.access$700(this.this$0);
        CrashlyticsController$4$1 crashlyticsController$4$1 = new CrashlyticsController$4$1(this, bl2);
        return crashlyticsBackgroundWorker.submitTask(crashlyticsController$4$1);
    }
}


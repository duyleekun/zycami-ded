/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;

public class CrashlyticsController$3
implements SuccessContinuation {
    public final /* synthetic */ CrashlyticsController this$0;

    public CrashlyticsController$3(CrashlyticsController crashlyticsController) {
        this.this$0 = crashlyticsController;
    }

    public Task then(Void void_) {
        return Tasks.forResult(Boolean.TRUE);
    }
}


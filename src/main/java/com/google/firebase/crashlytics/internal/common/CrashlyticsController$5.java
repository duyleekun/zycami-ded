/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import java.util.concurrent.Callable;

public class CrashlyticsController$5
implements Callable {
    public final /* synthetic */ CrashlyticsController this$0;
    public final /* synthetic */ String val$msg;
    public final /* synthetic */ long val$timestamp;

    public CrashlyticsController$5(CrashlyticsController crashlyticsController, long l10, String string2) {
        this.this$0 = crashlyticsController;
        this.val$timestamp = l10;
        this.val$msg = string2;
    }

    public Void call() {
        Object object = this.this$0;
        boolean bl2 = ((CrashlyticsController)object).isHandlingException();
        if (!bl2) {
            object = CrashlyticsController.access$1000(this.this$0);
            long l10 = this.val$timestamp;
            String string2 = this.val$msg;
            ((LogFileManager)object).writeToLog(l10, string2);
        }
        return null;
    }
}


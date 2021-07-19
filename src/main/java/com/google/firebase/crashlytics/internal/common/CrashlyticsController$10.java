/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.firebase.crashlytics.internal.common;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import java.util.concurrent.Callable;

public class CrashlyticsController$10
implements Callable {
    public final /* synthetic */ CrashlyticsController this$0;
    public final /* synthetic */ long val$timestamp;

    public CrashlyticsController$10(CrashlyticsController crashlyticsController, long l10) {
        this.this$0 = crashlyticsController;
        this.val$timestamp = l10;
    }

    public Void call() {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", 1);
        long l10 = this.val$timestamp;
        bundle.putLong("timestamp", l10);
        CrashlyticsController.access$1100(this.this$0).logEvent("_ae", bundle);
        return null;
    }
}


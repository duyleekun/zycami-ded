/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import java.util.concurrent.Callable;

public class CrashlyticsCore$4
implements Callable {
    public final /* synthetic */ CrashlyticsCore this$0;

    public CrashlyticsCore$4(CrashlyticsCore crashlyticsCore) {
        this.this$0 = crashlyticsCore;
    }

    public Boolean call() {
        return CrashlyticsCore.access$200(this.this$0).didCrashOnPreviousExecution();
    }
}


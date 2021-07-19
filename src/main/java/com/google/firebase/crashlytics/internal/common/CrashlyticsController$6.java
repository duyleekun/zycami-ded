/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import java.util.Date;

public class CrashlyticsController$6
implements Runnable {
    public final /* synthetic */ CrashlyticsController this$0;
    public final /* synthetic */ Throwable val$ex;
    public final /* synthetic */ Thread val$thread;
    public final /* synthetic */ Date val$time;

    public CrashlyticsController$6(CrashlyticsController crashlyticsController, Date date, Throwable throwable, Thread thread) {
        this.this$0 = crashlyticsController;
        this.val$time = date;
        this.val$ex = throwable;
        this.val$thread = thread;
    }

    public void run() {
        CrashlyticsController crashlyticsController = this.this$0;
        boolean bl2 = crashlyticsController.isHandlingException();
        if (!bl2) {
            long l10 = CrashlyticsController.access$000(this.val$time);
            crashlyticsController = this.this$0;
            String string2 = CrashlyticsController.access$100(crashlyticsController);
            if (string2 == null) {
                Logger.getLogger().w("Tried to write a non-fatal exception while no session was open.");
                return;
            }
            crashlyticsController = this.this$0;
            SessionReportingCoordinator sessionReportingCoordinator = CrashlyticsController.access$300(crashlyticsController);
            Throwable throwable = this.val$ex;
            Thread thread = this.val$thread;
            sessionReportingCoordinator.persistNonFatalEvent(throwable, thread, string2, l10);
        }
    }
}


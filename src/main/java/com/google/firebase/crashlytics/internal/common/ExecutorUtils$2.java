/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorUtils$2
extends BackgroundPriorityRunnable {
    public final /* synthetic */ ExecutorService val$service;
    public final /* synthetic */ String val$serviceName;
    public final /* synthetic */ long val$terminationTimeout;
    public final /* synthetic */ TimeUnit val$timeUnit;

    public ExecutorUtils$2(String string2, ExecutorService executorService, long l10, TimeUnit timeUnit) {
        this.val$serviceName = string2;
        this.val$service = executorService;
        this.val$terminationTimeout = l10;
        this.val$timeUnit = timeUnit;
    }

    public void onRun() {
        block18: {
            Object object = Logger.getLogger();
            Object object2 = new StringBuilder();
            Object object3 = "Executing shutdown hook for ";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.val$serviceName;
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            ((Logger)object).d((String)object2);
            object = this.val$service;
            object.shutdown();
            object = this.val$service;
            long l10 = this.val$terminationTimeout;
            Object object4 = this.val$timeUnit;
            boolean bl2 = object.awaitTermination(l10, (TimeUnit)((Object)object4));
            if (bl2) break block18;
            object = Logger.getLogger();
            object2 = new StringBuilder();
            object3 = this.val$serviceName;
            ((StringBuilder)object2).append((String)object3);
            object3 = " did not shut down in the allocated time. Requesting immediate shutdown.";
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            ((Logger)object).d((String)object2);
            object = this.val$service;
            try {
                object.shutdownNow();
            }
            catch (InterruptedException interruptedException) {
                object = Logger.getLogger();
                object2 = Locale.US;
                int n10 = 1;
                object3 = new Object[n10];
                String string2 = this.val$serviceName;
                object3[0] = string2;
                object4 = "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.";
                object2 = String.format((Locale)object2, object4, object3);
                ((Logger)object).d((String)object2);
                object = this.val$service;
                object.shutdownNow();
            }
        }
    }
}


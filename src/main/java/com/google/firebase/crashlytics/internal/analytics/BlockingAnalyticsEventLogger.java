/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingAnalyticsEventLogger
implements AnalyticsEventReceiver,
AnalyticsEventLogger {
    public static final String APP_EXCEPTION_EVENT_NAME = "_ae";
    private final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
    private boolean callbackReceived;
    private CountDownLatch eventLatch;
    private final Object latchLock;
    private final TimeUnit timeUnit;
    private final int timeout;

    public BlockingAnalyticsEventLogger(CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int n10, TimeUnit timeUnit) {
        Object object;
        this.latchLock = object = new Object();
        this.callbackReceived = false;
        this.baseAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
        this.timeout = n10;
        this.timeUnit = timeUnit;
    }

    public boolean isCallbackReceived() {
        return this.callbackReceived;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void logEvent(String object, Bundle object2) {
        Object object3 = this.latchLock;
        synchronized (object3) {
            boolean bl2;
            Object object4 = Logger.getLogger();
            CharSequence charSequence = new StringBuilder();
            String string2 = "Logging event ";
            charSequence.append(string2);
            charSequence.append((String)object);
            string2 = " to Firebase Analytics with params ";
            charSequence.append(string2);
            charSequence.append(object2);
            charSequence = charSequence.toString();
            ((Logger)object4).v((String)charSequence);
            int n10 = 1;
            this.eventLatch = object4 = new CountDownLatch(n10);
            object4 = null;
            this.callbackReceived = false;
            object4 = this.baseAnalyticsEventLogger;
            ((CrashlyticsOriginAnalyticsEventLogger)object4).logEvent((String)object, (Bundle)object2);
            object = Logger.getLogger();
            object2 = "Awaiting app exception callback from Analytics...";
            ((Logger)object).v((String)object2);
            try {
                object = this.eventLatch;
                int n11 = this.timeout;
                long l10 = n11;
                object2 = this.timeUnit;
                bl2 = ((CountDownLatch)object).await(l10, (TimeUnit)((Object)object2));
                if (bl2) {
                    this.callbackReceived = n10;
                    object = Logger.getLogger();
                    object2 = "App exception callback received from Analytics listener.";
                    ((Logger)object).v((String)object2);
                } else {
                    object = Logger.getLogger();
                    object2 = "Timeout exceeded while awaiting app exception callback from Analytics listener.";
                    ((Logger)object).w((String)object2);
                }
            }
            catch (InterruptedException interruptedException) {
                object = Logger.getLogger();
                object2 = "Interrupted while awaiting app exception callback from Analytics listener.";
                ((Logger)object).e((String)object2);
            }
            bl2 = false;
            object = null;
            this.eventLatch = null;
            return;
        }
    }

    public void onEvent(String string2, Bundle object) {
        object = this.eventLatch;
        if (object == null) {
            return;
        }
        String string3 = APP_EXCEPTION_EVENT_NAME;
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            ((CountDownLatch)object).countDown();
        }
    }
}


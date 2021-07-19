/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector$AnalyticsConnectorListener;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import java.util.Locale;

public class CrashlyticsAnalyticsListener
implements AnalyticsConnector$AnalyticsConnectorListener {
    public static final String CRASHLYTICS_ORIGIN = "clx";
    public static final String EVENT_NAME_KEY = "name";
    public static final String EVENT_ORIGIN_KEY = "_o";
    public static final String EVENT_PARAMS_KEY = "params";
    private AnalyticsEventReceiver breadcrumbEventReceiver;
    private AnalyticsEventReceiver crashlyticsOriginEventReceiver;

    private static void notifyEventReceiver(AnalyticsEventReceiver analyticsEventReceiver, String string2, Bundle bundle) {
        if (analyticsEventReceiver == null) {
            return;
        }
        analyticsEventReceiver.onEvent(string2, bundle);
    }

    private void notifyEventReceivers(String string2, Bundle bundle) {
        String string3 = CRASHLYTICS_ORIGIN;
        Object object = bundle.getString(EVENT_ORIGIN_KEY);
        boolean bl2 = string3.equals(object);
        object = bl2 ? this.crashlyticsOriginEventReceiver : this.breadcrumbEventReceiver;
        CrashlyticsAnalyticsListener.notifyEventReceiver((AnalyticsEventReceiver)object, string2, bundle);
    }

    public void onMessageTriggered(int n10, Bundle bundle) {
        Object object;
        Object object2 = Logger.getLogger();
        Locale locale = Locale.US;
        int n11 = 2;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object = Integer.valueOf(n10);
        n10 = 1;
        objectArray[n10] = bundle;
        object = String.format(locale, "Analytics listener received message. ID: %d, Extras: %s", objectArray);
        ((Logger)object2).v((String)object);
        if (bundle == null) {
            return;
        }
        object = bundle.getString(EVENT_NAME_KEY);
        if (object != null) {
            object2 = EVENT_PARAMS_KEY;
            if ((bundle = bundle.getBundle((String)object2)) == null) {
                bundle = new Bundle();
            }
            this.notifyEventReceivers((String)object, bundle);
        }
    }

    public void setBreadcrumbEventReceiver(AnalyticsEventReceiver analyticsEventReceiver) {
        this.breadcrumbEventReceiver = analyticsEventReceiver;
    }

    public void setCrashlyticsOriginEventReceiver(AnalyticsEventReceiver analyticsEventReceiver) {
        this.crashlyticsOriginEventReceiver = analyticsEventReceiver;
    }
}


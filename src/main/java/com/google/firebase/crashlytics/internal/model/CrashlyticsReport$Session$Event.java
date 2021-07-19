/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log;

public abstract class CrashlyticsReport$Session$Event {
    public static CrashlyticsReport$Session$Event$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Event$Builder autoValue_CrashlyticsReport_Session_Event$Builder = new AutoValue_CrashlyticsReport_Session_Event$Builder();
        return autoValue_CrashlyticsReport_Session_Event$Builder;
    }

    public abstract CrashlyticsReport$Session$Event$Application getApp();

    public abstract CrashlyticsReport$Session$Event$Device getDevice();

    public abstract CrashlyticsReport$Session$Event$Log getLog();

    public abstract long getTimestamp();

    public abstract String getType();

    public abstract CrashlyticsReport$Session$Event$Builder toBuilder();
}


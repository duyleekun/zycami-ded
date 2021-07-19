/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log;

public abstract class CrashlyticsReport$Session$Event$Builder {
    public abstract CrashlyticsReport$Session$Event build();

    public abstract CrashlyticsReport$Session$Event$Builder setApp(CrashlyticsReport$Session$Event$Application var1);

    public abstract CrashlyticsReport$Session$Event$Builder setDevice(CrashlyticsReport$Session$Event$Device var1);

    public abstract CrashlyticsReport$Session$Event$Builder setLog(CrashlyticsReport$Session$Event.Log var1);

    public abstract CrashlyticsReport$Session$Event$Builder setTimestamp(long var1);

    public abstract CrashlyticsReport$Session$Event$Builder setType(String var1);
}


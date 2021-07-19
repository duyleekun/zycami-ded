/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log$Builder;

public abstract class CrashlyticsReport$Session$Event$Log {
    public static CrashlyticsReport$Session$Event$Log$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Event_Log$Builder autoValue_CrashlyticsReport_Session_Event_Log$Builder = new AutoValue_CrashlyticsReport_Session_Event_Log$Builder();
        return autoValue_CrashlyticsReport_Session_Event_Log$Builder;
    }

    public abstract String getContent();
}


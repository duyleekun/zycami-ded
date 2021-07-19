/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public abstract class CrashlyticsReport$Session$Event$Application {
    public static CrashlyticsReport$Session$Event$Application$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Event_Application$Builder autoValue_CrashlyticsReport_Session_Event_Application$Builder = new AutoValue_CrashlyticsReport_Session_Event_Application$Builder();
        return autoValue_CrashlyticsReport_Session_Event_Application$Builder;
    }

    public abstract Boolean getBackground();

    public abstract ImmutableList getCustomAttributes();

    public abstract CrashlyticsReport$Session$Event$Application$Execution getExecution();

    public abstract int getUiOrientation();

    public abstract CrashlyticsReport$Session$Event$Application$Builder toBuilder();
}


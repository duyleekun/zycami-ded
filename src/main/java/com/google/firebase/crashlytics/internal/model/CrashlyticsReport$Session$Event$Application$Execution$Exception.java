/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public abstract class CrashlyticsReport$Session$Event$Application$Execution$Exception {
    public static CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception$Builder autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception$Builder = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception$Builder();
        return autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception$Builder;
    }

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Exception getCausedBy();

    public abstract ImmutableList getFrames();

    public abstract int getOverflowCount();

    public abstract String getReason();

    public abstract String getType();
}


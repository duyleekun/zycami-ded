/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public abstract class CrashlyticsReport$Session$Event$Application$Execution$Thread {
    public static CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$Builder autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$Builder = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$Builder();
        return autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$Builder;
    }

    public abstract ImmutableList getFrames();

    public abstract int getImportance();

    public abstract String getName();
}


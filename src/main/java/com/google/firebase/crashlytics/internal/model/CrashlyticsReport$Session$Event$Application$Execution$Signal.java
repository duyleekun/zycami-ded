/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder;

public abstract class CrashlyticsReport$Session$Event$Application$Execution$Signal {
    public static CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$Builder autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$Builder = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$Builder();
        return autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$Builder;
    }

    public abstract long getAddress();

    public abstract String getCode();

    public abstract String getName();
}


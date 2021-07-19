/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder;

public abstract class CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame {
    public static CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$Builder autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$Builder = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$Builder();
        return autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$Builder;
    }

    public abstract String getFile();

    public abstract int getImportance();

    public abstract long getOffset();

    public abstract long getPc();

    public abstract String getSymbol();
}


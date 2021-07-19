/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization$Builder;

public abstract class CrashlyticsReport$Session$Application$Organization {
    public static CrashlyticsReport$Session$Application$Organization$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Application_Organization$Builder autoValue_CrashlyticsReport_Session_Application_Organization$Builder = new AutoValue_CrashlyticsReport_Session_Application_Organization$Builder();
        return autoValue_CrashlyticsReport_Session_Application_Organization$Builder;
    }

    public abstract String getClsId();

    public abstract CrashlyticsReport$Session$Application$Organization$Builder toBuilder();
}


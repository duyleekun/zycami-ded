/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization$Builder;

public abstract class CrashlyticsReport$Session$Application {
    public static CrashlyticsReport$Session$Application$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Application$Builder autoValue_CrashlyticsReport_Session_Application$Builder = new AutoValue_CrashlyticsReport_Session_Application$Builder();
        return autoValue_CrashlyticsReport_Session_Application$Builder;
    }

    public abstract String getDevelopmentPlatform();

    public abstract String getDevelopmentPlatformVersion();

    public abstract String getDisplayVersion();

    public abstract String getIdentifier();

    public abstract String getInstallationUuid();

    public abstract CrashlyticsReport$Session$Application$Organization getOrganization();

    public abstract String getVersion();

    public abstract CrashlyticsReport$Session$Application$Builder toBuilder();

    public CrashlyticsReport$Session$Application withOrganizationId(String object) {
        Object object2 = this.getOrganization();
        object2 = object2 != null ? ((CrashlyticsReport$Session$Application$Organization)object2).toBuilder() : CrashlyticsReport$Session$Application$Organization.builder();
        CrashlyticsReport$Session$Application$Builder crashlyticsReport$Session$Application$Builder = this.toBuilder();
        object = ((CrashlyticsReport$Session$Application$Organization$Builder)object2).setClsId((String)object).build();
        return crashlyticsReport$Session$Application$Builder.setOrganization((CrashlyticsReport$Session$Application$Organization)object).build();
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization;

public abstract class CrashlyticsReport$Session$Application$Builder {
    public abstract CrashlyticsReport$Session$Application build();

    public abstract CrashlyticsReport$Session$Application$Builder setDevelopmentPlatform(String var1);

    public abstract CrashlyticsReport$Session$Application$Builder setDevelopmentPlatformVersion(String var1);

    public abstract CrashlyticsReport$Session$Application$Builder setDisplayVersion(String var1);

    public abstract CrashlyticsReport$Session$Application$Builder setIdentifier(String var1);

    public abstract CrashlyticsReport$Session$Application$Builder setInstallationUuid(String var1);

    public abstract CrashlyticsReport$Session$Application$Builder setOrganization(CrashlyticsReport$Session$Application.Organization var1);

    public abstract CrashlyticsReport$Session$Application$Builder setVersion(String var1);
}


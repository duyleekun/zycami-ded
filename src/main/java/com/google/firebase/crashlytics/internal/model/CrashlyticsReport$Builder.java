/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;

public abstract class CrashlyticsReport$Builder {
    public abstract CrashlyticsReport build();

    public abstract CrashlyticsReport$Builder setBuildVersion(String var1);

    public abstract CrashlyticsReport$Builder setDisplayVersion(String var1);

    public abstract CrashlyticsReport$Builder setGmpAppId(String var1);

    public abstract CrashlyticsReport$Builder setInstallationUuid(String var1);

    public abstract CrashlyticsReport$Builder setNdkPayload(CrashlyticsReport.FilesPayload var1);

    public abstract CrashlyticsReport$Builder setPlatform(int var1);

    public abstract CrashlyticsReport$Builder setSdkVersion(String var1);

    public abstract CrashlyticsReport$Builder setSession(CrashlyticsReport$Session var1);
}


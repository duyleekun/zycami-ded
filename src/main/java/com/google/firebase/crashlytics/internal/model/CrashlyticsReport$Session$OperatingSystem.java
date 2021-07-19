/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem$Builder;

public abstract class CrashlyticsReport$Session$OperatingSystem {
    public static CrashlyticsReport$Session$OperatingSystem$Builder builder() {
        AutoValue_CrashlyticsReport_Session_OperatingSystem$Builder autoValue_CrashlyticsReport_Session_OperatingSystem$Builder = new AutoValue_CrashlyticsReport_Session_OperatingSystem$Builder();
        return autoValue_CrashlyticsReport_Session_OperatingSystem$Builder;
    }

    public abstract String getBuildVersion();

    public abstract int getPlatform();

    public abstract String getVersion();

    public abstract boolean isJailbroken();
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User$Builder;

public abstract class CrashlyticsReport$Session$User {
    public static CrashlyticsReport$Session$User$Builder builder() {
        AutoValue_CrashlyticsReport_Session_User$Builder autoValue_CrashlyticsReport_Session_User$Builder = new AutoValue_CrashlyticsReport_Session_User$Builder();
        return autoValue_CrashlyticsReport_Session_User$Builder;
    }

    public abstract String getIdentifier();
}


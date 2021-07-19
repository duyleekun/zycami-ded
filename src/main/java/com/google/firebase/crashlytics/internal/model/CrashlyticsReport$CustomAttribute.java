/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute$Builder;

public abstract class CrashlyticsReport$CustomAttribute {
    public static CrashlyticsReport$CustomAttribute$Builder builder() {
        AutoValue_CrashlyticsReport_CustomAttribute$Builder autoValue_CrashlyticsReport_CustomAttribute$Builder = new AutoValue_CrashlyticsReport_CustomAttribute$Builder();
        return autoValue_CrashlyticsReport_CustomAttribute$Builder;
    }

    public abstract String getKey();

    public abstract String getValue();
}


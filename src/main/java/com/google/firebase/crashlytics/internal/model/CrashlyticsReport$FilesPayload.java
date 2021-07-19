/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public abstract class CrashlyticsReport$FilesPayload {
    public static CrashlyticsReport$FilesPayload$Builder builder() {
        AutoValue_CrashlyticsReport_FilesPayload$Builder autoValue_CrashlyticsReport_FilesPayload$Builder = new AutoValue_CrashlyticsReport_FilesPayload$Builder();
        return autoValue_CrashlyticsReport_FilesPayload$Builder;
    }

    public abstract ImmutableList getFiles();

    public abstract String getOrgId();

    public abstract CrashlyticsReport$FilesPayload$Builder toBuilder();
}


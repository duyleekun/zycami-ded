/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public abstract class CrashlyticsReport$FilesPayload$Builder {
    public abstract CrashlyticsReport$FilesPayload build();

    public abstract CrashlyticsReport$FilesPayload$Builder setFiles(ImmutableList var1);

    public abstract CrashlyticsReport$FilesPayload$Builder setOrgId(String var1);
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder;

public abstract class CrashlyticsReport$FilesPayload$File {
    public static CrashlyticsReport$FilesPayload$File$Builder builder() {
        AutoValue_CrashlyticsReport_FilesPayload_File$Builder autoValue_CrashlyticsReport_FilesPayload_File$Builder = new AutoValue_CrashlyticsReport_FilesPayload_File$Builder();
        return autoValue_CrashlyticsReport_FilesPayload_File$Builder;
    }

    public abstract byte[] getContents();

    public abstract String getFilename();
}


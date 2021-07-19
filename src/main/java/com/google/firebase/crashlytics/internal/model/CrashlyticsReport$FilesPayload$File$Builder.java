/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File;

public abstract class CrashlyticsReport$FilesPayload$File$Builder {
    public abstract CrashlyticsReport$FilesPayload$File build();

    public abstract CrashlyticsReport$FilesPayload$File$Builder setContents(byte[] var1);

    public abstract CrashlyticsReport$FilesPayload$File$Builder setFilename(String var1);
}


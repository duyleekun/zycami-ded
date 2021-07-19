/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File;
import java.io.InputStream;

public interface NativeSessionFile {
    public CrashlyticsReport.FilesPayload.File asFilePayload();

    public String getReportsEndpointFilename();

    public InputStream getStream();
}


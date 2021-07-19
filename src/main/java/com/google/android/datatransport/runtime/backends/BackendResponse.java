/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendResponse$Status;

public abstract class BackendResponse {
    public static BackendResponse fatalError() {
        BackendResponse$Status backendResponse$Status = BackendResponse$Status.FATAL_ERROR;
        AutoValue_BackendResponse autoValue_BackendResponse = new AutoValue_BackendResponse(backendResponse$Status, -1);
        return autoValue_BackendResponse;
    }

    public static BackendResponse ok(long l10) {
        BackendResponse$Status backendResponse$Status = BackendResponse$Status.OK;
        AutoValue_BackendResponse autoValue_BackendResponse = new AutoValue_BackendResponse(backendResponse$Status, l10);
        return autoValue_BackendResponse;
    }

    public static BackendResponse transientError() {
        BackendResponse$Status backendResponse$Status = BackendResponse$Status.TRANSIENT_ERROR;
        AutoValue_BackendResponse autoValue_BackendResponse = new AutoValue_BackendResponse(backendResponse$Status, -1);
        return autoValue_BackendResponse;
    }

    public abstract long getNextRequestWaitMillis();

    public abstract BackendResponse$Status getStatus();
}


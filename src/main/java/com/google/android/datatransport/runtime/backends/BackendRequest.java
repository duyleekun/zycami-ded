/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest$Builder;
import com.google.android.datatransport.runtime.backends.BackendRequest$Builder;

public abstract class BackendRequest {
    public static BackendRequest$Builder builder() {
        AutoValue_BackendRequest$Builder autoValue_BackendRequest$Builder = new AutoValue_BackendRequest$Builder();
        return autoValue_BackendRequest$Builder;
    }

    public static BackendRequest create(Iterable iterable) {
        return BackendRequest.builder().setEvents(iterable).build();
    }

    public abstract Iterable getEvents();

    public abstract byte[] getExtras();
}


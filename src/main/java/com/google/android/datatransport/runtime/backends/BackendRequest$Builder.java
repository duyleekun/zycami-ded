/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendRequest;

public abstract class BackendRequest$Builder {
    public abstract BackendRequest build();

    public abstract BackendRequest$Builder setEvents(Iterable var1);

    public abstract BackendRequest$Builder setExtras(byte[] var1);
}


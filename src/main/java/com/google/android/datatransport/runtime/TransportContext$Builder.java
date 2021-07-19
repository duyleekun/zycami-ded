/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;

public abstract class TransportContext$Builder {
    public abstract TransportContext build();

    public abstract TransportContext$Builder setBackendName(String var1);

    public abstract TransportContext$Builder setExtras(byte[] var1);

    public abstract TransportContext$Builder setPriority(Priority var1);
}


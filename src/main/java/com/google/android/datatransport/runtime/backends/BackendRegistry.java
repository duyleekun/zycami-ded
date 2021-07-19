/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.TransportBackend;

public interface BackendRegistry {
    public TransportBackend get(String var1);
}


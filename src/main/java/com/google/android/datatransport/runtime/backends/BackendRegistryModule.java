/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;

public abstract class BackendRegistryModule {
    public abstract BackendRegistry backendRegistry(MetadataBackendRegistry var1);
}


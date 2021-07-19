/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Set;

public final class ClientSettings$OptionalApiSettings {
    public final Set mScopes;

    public ClientSettings$OptionalApiSettings(Set set) {
        Preconditions.checkNotNull(set);
        this.mScopes = set = Collections.unmodifiableSet(set);
    }
}


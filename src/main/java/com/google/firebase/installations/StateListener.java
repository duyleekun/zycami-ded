/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

public interface StateListener {
    public boolean onException(Exception var1);

    public boolean onStateReached(PersistedInstallationEntry var1);
}


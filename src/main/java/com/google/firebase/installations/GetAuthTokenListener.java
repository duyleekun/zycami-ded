/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.installations.InstallationTokenResult$Builder;
import com.google.firebase.installations.StateListener;
import com.google.firebase.installations.Utils;
import com.google.firebase.installations.local.PersistedInstallationEntry;

public class GetAuthTokenListener
implements StateListener {
    private final TaskCompletionSource resultTaskCompletionSource;
    private final Utils utils;

    public GetAuthTokenListener(Utils utils, TaskCompletionSource taskCompletionSource) {
        this.utils = utils;
        this.resultTaskCompletionSource = taskCompletionSource;
    }

    public boolean onException(Exception exception) {
        this.resultTaskCompletionSource.trySetException(exception);
        return true;
    }

    public boolean onStateReached(PersistedInstallationEntry object) {
        Object object2;
        boolean bl2 = ((PersistedInstallationEntry)object).isRegistered();
        if (bl2 && !(bl2 = ((Utils)(object2 = this.utils)).isAuthTokenExpired((PersistedInstallationEntry)object))) {
            object2 = this.resultTaskCompletionSource;
            InstallationTokenResult$Builder installationTokenResult$Builder = InstallationTokenResult.builder();
            String string2 = ((PersistedInstallationEntry)object).getAuthToken();
            installationTokenResult$Builder = installationTokenResult$Builder.setToken(string2);
            long l10 = ((PersistedInstallationEntry)object).getExpiresInSecs();
            installationTokenResult$Builder = installationTokenResult$Builder.setTokenExpirationTimestamp(l10);
            l10 = ((PersistedInstallationEntry)object).getTokenCreationEpochInSecs();
            object = installationTokenResult$Builder.setTokenCreationTimestamp(l10).build();
            ((TaskCompletionSource)object2).setResult(object);
            return true;
        }
        return false;
    }
}


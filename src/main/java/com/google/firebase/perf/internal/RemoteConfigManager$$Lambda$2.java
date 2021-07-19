/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.perf.internal.RemoteConfigManager;

public final class RemoteConfigManager$$Lambda$2
implements OnFailureListener {
    private final RemoteConfigManager arg$1;

    private RemoteConfigManager$$Lambda$2(RemoteConfigManager remoteConfigManager) {
        this.arg$1 = remoteConfigManager;
    }

    public static OnFailureListener lambdaFactory$(RemoteConfigManager remoteConfigManager) {
        RemoteConfigManager$$Lambda$2 remoteConfigManager$$Lambda$2 = new RemoteConfigManager$$Lambda$2(remoteConfigManager);
        return remoteConfigManager$$Lambda$2;
    }

    public void onFailure(Exception exception) {
        RemoteConfigManager.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(this.arg$1, exception);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.perf.internal.RemoteConfigManager;

public final class RemoteConfigManager$$Lambda$1
implements OnSuccessListener {
    private final RemoteConfigManager arg$1;

    private RemoteConfigManager$$Lambda$1(RemoteConfigManager remoteConfigManager) {
        this.arg$1 = remoteConfigManager;
    }

    public static OnSuccessListener lambdaFactory$(RemoteConfigManager remoteConfigManager) {
        RemoteConfigManager$$Lambda$1 remoteConfigManager$$Lambda$1 = new RemoteConfigManager$$Lambda$1(remoteConfigManager);
        return remoteConfigManager$$Lambda$1;
    }

    public void onSuccess(Object object) {
        RemoteConfigManager remoteConfigManager = this.arg$1;
        object = (Boolean)object;
        RemoteConfigManager.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0(remoteConfigManager, (Boolean)object);
    }
}


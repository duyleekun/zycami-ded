/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class FirebaseRemoteConfig$$Lambda$3
implements SuccessContinuation {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$3(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static SuccessContinuation lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        FirebaseRemoteConfig$$Lambda$3 firebaseRemoteConfig$$Lambda$3 = new FirebaseRemoteConfig$$Lambda$3(firebaseRemoteConfig);
        return firebaseRemoteConfig$$Lambda$3;
    }

    public Task then(Object object) {
        FirebaseRemoteConfig firebaseRemoteConfig = this.arg$1;
        object = (Void)object;
        return FirebaseRemoteConfig.lambda$fetchAndActivate$1(firebaseRemoteConfig, (Void)object);
    }
}


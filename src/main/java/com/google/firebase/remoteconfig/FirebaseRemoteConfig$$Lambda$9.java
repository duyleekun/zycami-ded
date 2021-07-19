/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.ConfigContainer;

public final class FirebaseRemoteConfig$$Lambda$9
implements SuccessContinuation {
    private static final FirebaseRemoteConfig$$Lambda$9 instance;

    static {
        FirebaseRemoteConfig$$Lambda$9 firebaseRemoteConfig$$Lambda$9;
        instance = firebaseRemoteConfig$$Lambda$9 = new FirebaseRemoteConfig$$Lambda$9();
    }

    private FirebaseRemoteConfig$$Lambda$9() {
    }

    public static SuccessContinuation lambdaFactory$() {
        return instance;
    }

    public Task then(Object object) {
        return FirebaseRemoteConfig.lambda$setDefaultsWithStringsMapAsync$7((ConfigContainer)object);
    }
}


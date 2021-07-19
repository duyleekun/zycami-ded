/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.Callable;

public final class FirebaseRemoteConfig$$Lambda$8
implements Callable {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$8(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static Callable lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        FirebaseRemoteConfig$$Lambda$8 firebaseRemoteConfig$$Lambda$8 = new FirebaseRemoteConfig$$Lambda$8(firebaseRemoteConfig);
        return firebaseRemoteConfig$$Lambda$8;
    }

    public Object call() {
        return FirebaseRemoteConfig.lambda$reset$6(this.arg$1);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.Callable;

public final class FirebaseRemoteConfig$$Lambda$1
implements Callable {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$1(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static Callable lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        FirebaseRemoteConfig$$Lambda$1 firebaseRemoteConfig$$Lambda$1 = new FirebaseRemoteConfig$$Lambda$1(firebaseRemoteConfig);
        return firebaseRemoteConfig$$Lambda$1;
    }

    public Object call() {
        return this.arg$1.getInfo();
    }
}


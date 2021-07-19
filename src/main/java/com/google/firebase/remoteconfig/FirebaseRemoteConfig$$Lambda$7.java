/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.concurrent.Callable;

public final class FirebaseRemoteConfig$$Lambda$7
implements Callable {
    private final FirebaseRemoteConfig arg$1;
    private final FirebaseRemoteConfigSettings arg$2;

    private FirebaseRemoteConfig$$Lambda$7(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.arg$1 = firebaseRemoteConfig;
        this.arg$2 = firebaseRemoteConfigSettings;
    }

    public static Callable lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        FirebaseRemoteConfig$$Lambda$7 firebaseRemoteConfig$$Lambda$7 = new FirebaseRemoteConfig$$Lambda$7(firebaseRemoteConfig, firebaseRemoteConfigSettings);
        return firebaseRemoteConfig$$Lambda$7;
    }

    public Object call() {
        FirebaseRemoteConfig firebaseRemoteConfig = this.arg$1;
        FirebaseRemoteConfigSettings firebaseRemoteConfigSettings = this.arg$2;
        return FirebaseRemoteConfig.lambda$setConfigSettingsAsync$5(firebaseRemoteConfig, firebaseRemoteConfigSettings);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class FirebaseRemoteConfig$$Lambda$10
implements Continuation {
    private final FirebaseRemoteConfig arg$1;

    private FirebaseRemoteConfig$$Lambda$10(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.arg$1 = firebaseRemoteConfig;
    }

    public static Continuation lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig) {
        FirebaseRemoteConfig$$Lambda$10 firebaseRemoteConfig$$Lambda$10 = new FirebaseRemoteConfig$$Lambda$10(firebaseRemoteConfig);
        return firebaseRemoteConfig$$Lambda$10;
    }

    public Object then(Task task) {
        return FirebaseRemoteConfig.access$lambda$0(this.arg$1, task);
    }
}


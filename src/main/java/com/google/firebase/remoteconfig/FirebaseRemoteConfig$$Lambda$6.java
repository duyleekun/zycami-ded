/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse;

public final class FirebaseRemoteConfig$$Lambda$6
implements SuccessContinuation {
    private static final FirebaseRemoteConfig$$Lambda$6 instance;

    static {
        FirebaseRemoteConfig$$Lambda$6 firebaseRemoteConfig$$Lambda$6;
        instance = firebaseRemoteConfig$$Lambda$6 = new FirebaseRemoteConfig$$Lambda$6();
    }

    private FirebaseRemoteConfig$$Lambda$6() {
    }

    public static SuccessContinuation lambdaFactory$() {
        return instance;
    }

    public Task then(Object object) {
        return FirebaseRemoteConfig.lambda$fetch$4((ConfigFetchHandler$FetchResponse)object);
    }
}


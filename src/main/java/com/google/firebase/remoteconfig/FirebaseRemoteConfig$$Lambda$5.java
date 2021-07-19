/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse;

public final class FirebaseRemoteConfig$$Lambda$5
implements SuccessContinuation {
    private static final FirebaseRemoteConfig$$Lambda$5 instance;

    static {
        FirebaseRemoteConfig$$Lambda$5 firebaseRemoteConfig$$Lambda$5;
        instance = firebaseRemoteConfig$$Lambda$5 = new FirebaseRemoteConfig$$Lambda$5();
    }

    private FirebaseRemoteConfig$$Lambda$5() {
    }

    public static SuccessContinuation lambdaFactory$() {
        return instance;
    }

    public Task then(Object object) {
        return FirebaseRemoteConfig.lambda$fetch$3((ConfigFetchHandler$FetchResponse)object);
    }
}


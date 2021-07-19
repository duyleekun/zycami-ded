/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class FirebaseRemoteConfig$$Lambda$2
implements Continuation {
    private final Task arg$1;

    private FirebaseRemoteConfig$$Lambda$2(Task task) {
        this.arg$1 = task;
    }

    public static Continuation lambdaFactory$(Task task) {
        FirebaseRemoteConfig$$Lambda$2 firebaseRemoteConfig$$Lambda$2 = new FirebaseRemoteConfig$$Lambda$2(task);
        return firebaseRemoteConfig$$Lambda$2;
    }

    public Object then(Task task) {
        return FirebaseRemoteConfig.lambda$ensureInitialized$0(this.arg$1, task);
    }
}


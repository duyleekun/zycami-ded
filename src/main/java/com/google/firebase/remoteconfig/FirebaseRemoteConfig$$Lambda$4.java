/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class FirebaseRemoteConfig$$Lambda$4
implements Continuation {
    private final FirebaseRemoteConfig arg$1;
    private final Task arg$2;
    private final Task arg$3;

    private FirebaseRemoteConfig$$Lambda$4(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        this.arg$1 = firebaseRemoteConfig;
        this.arg$2 = task;
        this.arg$3 = task2;
    }

    public static Continuation lambdaFactory$(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2) {
        FirebaseRemoteConfig$$Lambda$4 firebaseRemoteConfig$$Lambda$4 = new FirebaseRemoteConfig$$Lambda$4(firebaseRemoteConfig, task, task2);
        return firebaseRemoteConfig$$Lambda$4;
    }

    public Object then(Task task) {
        FirebaseRemoteConfig firebaseRemoteConfig = this.arg$1;
        Task task2 = this.arg$2;
        Task task3 = this.arg$3;
        return FirebaseRemoteConfig.lambda$activate$2(firebaseRemoteConfig, task2, task3, task);
    }
}


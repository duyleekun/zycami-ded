/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.installations.FirebaseInstallations;

public final class FirebaseInstallations$$Lambda$1
implements Runnable {
    private final FirebaseInstallations arg$1;

    private FirebaseInstallations$$Lambda$1(FirebaseInstallations firebaseInstallations) {
        this.arg$1 = firebaseInstallations;
    }

    public static Runnable lambdaFactory$(FirebaseInstallations firebaseInstallations) {
        FirebaseInstallations$$Lambda$1 firebaseInstallations$$Lambda$1 = new FirebaseInstallations$$Lambda$1(firebaseInstallations);
        return firebaseInstallations$$Lambda$1;
    }

    public void run() {
        FirebaseInstallations.lambda$getId$0(this.arg$1);
    }
}


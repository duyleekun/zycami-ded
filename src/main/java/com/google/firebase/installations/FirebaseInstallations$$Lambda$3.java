/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.installations.FirebaseInstallations;
import java.util.concurrent.Callable;

public final class FirebaseInstallations$$Lambda$3
implements Callable {
    private final FirebaseInstallations arg$1;

    private FirebaseInstallations$$Lambda$3(FirebaseInstallations firebaseInstallations) {
        this.arg$1 = firebaseInstallations;
    }

    public static Callable lambdaFactory$(FirebaseInstallations firebaseInstallations) {
        FirebaseInstallations$$Lambda$3 firebaseInstallations$$Lambda$3 = new FirebaseInstallations$$Lambda$3(firebaseInstallations);
        return firebaseInstallations$$Lambda$3;
    }

    public Object call() {
        return FirebaseInstallations.access$lambda$0(this.arg$1);
    }
}


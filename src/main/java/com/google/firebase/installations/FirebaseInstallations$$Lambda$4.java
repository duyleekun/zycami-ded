/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.installations.FirebaseInstallations;

public final class FirebaseInstallations$$Lambda$4
implements Runnable {
    private final FirebaseInstallations arg$1;
    private final boolean arg$2;

    private FirebaseInstallations$$Lambda$4(FirebaseInstallations firebaseInstallations, boolean bl2) {
        this.arg$1 = firebaseInstallations;
        this.arg$2 = bl2;
    }

    public static Runnable lambdaFactory$(FirebaseInstallations firebaseInstallations, boolean bl2) {
        FirebaseInstallations$$Lambda$4 firebaseInstallations$$Lambda$4 = new FirebaseInstallations$$Lambda$4(firebaseInstallations, bl2);
        return firebaseInstallations$$Lambda$4;
    }

    public void run() {
        FirebaseInstallations firebaseInstallations = this.arg$1;
        boolean bl2 = this.arg$2;
        FirebaseInstallations.lambda$doRegistrationOrRefresh$2(firebaseInstallations, bl2);
    }
}


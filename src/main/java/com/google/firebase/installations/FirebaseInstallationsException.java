/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.FirebaseException;
import com.google.firebase.installations.FirebaseInstallationsException$Status;

public class FirebaseInstallationsException
extends FirebaseException {
    private final FirebaseInstallationsException$Status status;

    public FirebaseInstallationsException(FirebaseInstallationsException$Status firebaseInstallationsException$Status) {
        this.status = firebaseInstallationsException$Status;
    }

    public FirebaseInstallationsException(String string2, FirebaseInstallationsException$Status firebaseInstallationsException$Status) {
        super(string2);
        this.status = firebaseInstallationsException$Status;
    }

    public FirebaseInstallationsException(String string2, FirebaseInstallationsException$Status firebaseInstallationsException$Status, Throwable throwable) {
        super(string2, throwable);
        this.status = firebaseInstallationsException$Status;
    }

    public FirebaseInstallationsException$Status getStatus() {
        return this.status;
    }
}


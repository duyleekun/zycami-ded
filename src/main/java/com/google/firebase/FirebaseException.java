/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;

public class FirebaseException
extends Exception {
    public FirebaseException() {
    }

    public FirebaseException(String string2) {
        string2 = Preconditions.checkNotEmpty(string2, "Detail message must not be empty");
        super(string2);
    }

    public FirebaseException(String string2, Throwable throwable) {
        string2 = Preconditions.checkNotEmpty(string2, "Detail message must not be empty");
        super(string2, throwable);
    }
}


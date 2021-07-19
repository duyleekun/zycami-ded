/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;

public final class FirebaseApp$$Lambda$1
implements Provider {
    private final FirebaseApp arg$1;
    private final Context arg$2;

    private FirebaseApp$$Lambda$1(FirebaseApp firebaseApp, Context context) {
        this.arg$1 = firebaseApp;
        this.arg$2 = context;
    }

    public static Provider lambdaFactory$(FirebaseApp firebaseApp, Context context) {
        FirebaseApp$$Lambda$1 firebaseApp$$Lambda$1 = new FirebaseApp$$Lambda$1(firebaseApp, context);
        return firebaseApp$$Lambda$1;
    }

    public Object get() {
        FirebaseApp firebaseApp = this.arg$1;
        Context context = this.arg$2;
        return FirebaseApp.lambda$new$0(firebaseApp, context);
    }
}


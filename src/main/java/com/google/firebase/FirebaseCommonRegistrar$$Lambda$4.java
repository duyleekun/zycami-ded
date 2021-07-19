/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase;

import android.content.Context;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor;

public final class FirebaseCommonRegistrar$$Lambda$4
implements LibraryVersionComponent$VersionExtractor {
    private static final FirebaseCommonRegistrar$$Lambda$4 instance;

    static {
        FirebaseCommonRegistrar$$Lambda$4 firebaseCommonRegistrar$$Lambda$4;
        instance = firebaseCommonRegistrar$$Lambda$4 = new FirebaseCommonRegistrar$$Lambda$4();
    }

    private FirebaseCommonRegistrar$$Lambda$4() {
    }

    public static LibraryVersionComponent$VersionExtractor lambdaFactory$() {
        return instance;
    }

    public String extract(Object object) {
        return FirebaseCommonRegistrar.lambda$getComponents$1((Context)object);
    }
}


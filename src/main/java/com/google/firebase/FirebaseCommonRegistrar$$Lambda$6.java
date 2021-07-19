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

public final class FirebaseCommonRegistrar$$Lambda$6
implements LibraryVersionComponent$VersionExtractor {
    private static final FirebaseCommonRegistrar$$Lambda$6 instance;

    static {
        FirebaseCommonRegistrar$$Lambda$6 firebaseCommonRegistrar$$Lambda$6;
        instance = firebaseCommonRegistrar$$Lambda$6 = new FirebaseCommonRegistrar$$Lambda$6();
    }

    private FirebaseCommonRegistrar$$Lambda$6() {
    }

    public static LibraryVersionComponent$VersionExtractor lambdaFactory$() {
        return instance;
    }

    public String extract(Object object) {
        return FirebaseCommonRegistrar.lambda$getComponents$3((Context)object);
    }
}


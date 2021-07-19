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

public final class FirebaseCommonRegistrar$$Lambda$5
implements LibraryVersionComponent$VersionExtractor {
    private static final FirebaseCommonRegistrar$$Lambda$5 instance;

    static {
        FirebaseCommonRegistrar$$Lambda$5 firebaseCommonRegistrar$$Lambda$5;
        instance = firebaseCommonRegistrar$$Lambda$5 = new FirebaseCommonRegistrar$$Lambda$5();
    }

    private FirebaseCommonRegistrar$$Lambda$5() {
    }

    public static LibraryVersionComponent$VersionExtractor lambdaFactory$() {
        return instance;
    }

    public String extract(Object object) {
        return FirebaseCommonRegistrar.lambda$getComponents$2((Context)object);
    }
}


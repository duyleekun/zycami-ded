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

public final class FirebaseCommonRegistrar$$Lambda$1
implements LibraryVersionComponent$VersionExtractor {
    private static final FirebaseCommonRegistrar$$Lambda$1 instance;

    static {
        FirebaseCommonRegistrar$$Lambda$1 firebaseCommonRegistrar$$Lambda$1;
        instance = firebaseCommonRegistrar$$Lambda$1 = new FirebaseCommonRegistrar$$Lambda$1();
    }

    private FirebaseCommonRegistrar$$Lambda$1() {
    }

    public static LibraryVersionComponent$VersionExtractor lambdaFactory$() {
        return instance;
    }

    public String extract(Object object) {
        return FirebaseCommonRegistrar.lambda$getComponents$0((Context)object);
    }
}


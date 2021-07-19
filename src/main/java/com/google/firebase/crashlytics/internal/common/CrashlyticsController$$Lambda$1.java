/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import java.io.File;
import java.io.FilenameFilter;

public final class CrashlyticsController$$Lambda$1
implements FilenameFilter {
    private static final CrashlyticsController$$Lambda$1 instance;

    static {
        CrashlyticsController$$Lambda$1 crashlyticsController$$Lambda$1;
        instance = crashlyticsController$$Lambda$1 = new CrashlyticsController$$Lambda$1();
    }

    private CrashlyticsController$$Lambda$1() {
    }

    public static FilenameFilter lambdaFactory$() {
        return instance;
    }

    public boolean accept(File file, String string2) {
        return CrashlyticsController.lambda$static$0(file, string2);
    }
}


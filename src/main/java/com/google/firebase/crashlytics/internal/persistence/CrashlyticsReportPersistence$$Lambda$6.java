/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.io.FilenameFilter;

public final class CrashlyticsReportPersistence$$Lambda$6
implements FilenameFilter {
    private static final CrashlyticsReportPersistence$$Lambda$6 instance;

    static {
        CrashlyticsReportPersistence$$Lambda$6 crashlyticsReportPersistence$$Lambda$6;
        instance = crashlyticsReportPersistence$$Lambda$6 = new CrashlyticsReportPersistence$$Lambda$6();
    }

    private CrashlyticsReportPersistence$$Lambda$6() {
    }

    public static FilenameFilter lambdaFactory$() {
        return instance;
    }

    public boolean accept(File file, String string2) {
        return CrashlyticsReportPersistence.lambda$static$1(file, string2);
    }
}


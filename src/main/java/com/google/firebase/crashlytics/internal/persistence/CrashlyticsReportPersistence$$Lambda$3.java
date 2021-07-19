/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.io.FilenameFilter;

public final class CrashlyticsReportPersistence$$Lambda$3
implements FilenameFilter {
    private static final CrashlyticsReportPersistence$$Lambda$3 instance;

    static {
        CrashlyticsReportPersistence$$Lambda$3 crashlyticsReportPersistence$$Lambda$3;
        instance = crashlyticsReportPersistence$$Lambda$3 = new CrashlyticsReportPersistence$$Lambda$3();
    }

    private CrashlyticsReportPersistence$$Lambda$3() {
    }

    public static FilenameFilter lambdaFactory$() {
        return instance;
    }

    public boolean accept(File file, String string2) {
        return CrashlyticsReportPersistence.access$lambda$0(file, string2);
    }
}


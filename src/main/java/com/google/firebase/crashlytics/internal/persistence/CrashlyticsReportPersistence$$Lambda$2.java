/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.io.FileFilter;

public final class CrashlyticsReportPersistence$$Lambda$2
implements FileFilter {
    private final String arg$1;

    private CrashlyticsReportPersistence$$Lambda$2(String string2) {
        this.arg$1 = string2;
    }

    public static FileFilter lambdaFactory$(String string2) {
        CrashlyticsReportPersistence$$Lambda$2 crashlyticsReportPersistence$$Lambda$2 = new CrashlyticsReportPersistence$$Lambda$2(string2);
        return crashlyticsReportPersistence$$Lambda$2;
    }

    public boolean accept(File file) {
        return CrashlyticsReportPersistence.lambda$capAndGetOpenSessions$3(this.arg$1, file);
    }
}


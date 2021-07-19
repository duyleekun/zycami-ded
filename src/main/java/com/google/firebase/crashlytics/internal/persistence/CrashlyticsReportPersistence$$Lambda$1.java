/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.io.FilenameFilter;

public final class CrashlyticsReportPersistence$$Lambda$1
implements FilenameFilter {
    private final String arg$1;

    private CrashlyticsReportPersistence$$Lambda$1(String string2) {
        this.arg$1 = string2;
    }

    public static FilenameFilter lambdaFactory$(String string2) {
        CrashlyticsReportPersistence$$Lambda$1 crashlyticsReportPersistence$$Lambda$1 = new CrashlyticsReportPersistence$$Lambda$1(string2);
        return crashlyticsReportPersistence$$Lambda$1;
    }

    public boolean accept(File file, String string2) {
        return CrashlyticsReportPersistence.lambda$deleteFinalizedReport$2(this.arg$1, file, string2);
    }
}


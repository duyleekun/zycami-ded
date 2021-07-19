/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.util.Comparator;

public final class CrashlyticsReportPersistence$$Lambda$4
implements Comparator {
    private static final CrashlyticsReportPersistence$$Lambda$4 instance;

    static {
        CrashlyticsReportPersistence$$Lambda$4 crashlyticsReportPersistence$$Lambda$4;
        instance = crashlyticsReportPersistence$$Lambda$4 = new CrashlyticsReportPersistence$$Lambda$4();
    }

    private CrashlyticsReportPersistence$$Lambda$4() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    public int compare(Object object, Object object2) {
        object = (File)object;
        object2 = (File)object2;
        return CrashlyticsReportPersistence.access$lambda$1((File)object, (File)object2);
    }
}


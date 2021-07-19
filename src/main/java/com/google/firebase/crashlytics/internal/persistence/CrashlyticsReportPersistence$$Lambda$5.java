/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.util.Comparator;

public final class CrashlyticsReportPersistence$$Lambda$5
implements Comparator {
    private static final CrashlyticsReportPersistence$$Lambda$5 instance;

    static {
        CrashlyticsReportPersistence$$Lambda$5 crashlyticsReportPersistence$$Lambda$5;
        instance = crashlyticsReportPersistence$$Lambda$5 = new CrashlyticsReportPersistence$$Lambda$5();
    }

    private CrashlyticsReportPersistence$$Lambda$5() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    public int compare(Object object, Object object2) {
        object = (File)object;
        object2 = (File)object2;
        return CrashlyticsReportPersistence.lambda$static$0((File)object, (File)object2);
    }
}


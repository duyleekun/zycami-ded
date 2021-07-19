/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.Transformer;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;

public final class DataTransportCrashlyticsReportSender$$Lambda$2
implements Transformer {
    private static final DataTransportCrashlyticsReportSender$$Lambda$2 instance;

    static {
        DataTransportCrashlyticsReportSender$$Lambda$2 dataTransportCrashlyticsReportSender$$Lambda$2;
        instance = dataTransportCrashlyticsReportSender$$Lambda$2 = new DataTransportCrashlyticsReportSender$$Lambda$2();
    }

    private DataTransportCrashlyticsReportSender$$Lambda$2() {
    }

    public static Transformer lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return DataTransportCrashlyticsReportSender.lambda$static$0((CrashlyticsReport)object);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.AutoValue_CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

public abstract class CrashlyticsReportWithSessionId {
    public static CrashlyticsReportWithSessionId create(CrashlyticsReport crashlyticsReport, String string2) {
        AutoValue_CrashlyticsReportWithSessionId autoValue_CrashlyticsReportWithSessionId = new AutoValue_CrashlyticsReportWithSessionId(crashlyticsReport, string2);
        return autoValue_CrashlyticsReportWithSessionId;
    }

    public abstract CrashlyticsReport getReport();

    public abstract String getSessionId();
}


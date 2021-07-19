/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;

public final class DataTransportCrashlyticsReportSender$$Lambda$1
implements TransportScheduleCallback {
    private final TaskCompletionSource arg$1;
    private final CrashlyticsReportWithSessionId arg$2;

    private DataTransportCrashlyticsReportSender$$Lambda$1(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.arg$1 = taskCompletionSource;
        this.arg$2 = crashlyticsReportWithSessionId;
    }

    public static TransportScheduleCallback lambdaFactory$(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        DataTransportCrashlyticsReportSender$$Lambda$1 dataTransportCrashlyticsReportSender$$Lambda$1 = new DataTransportCrashlyticsReportSender$$Lambda$1(taskCompletionSource, crashlyticsReportWithSessionId);
        return dataTransportCrashlyticsReportSender$$Lambda$1;
    }

    public void onSchedule(Exception exception) {
        TaskCompletionSource taskCompletionSource = this.arg$1;
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = this.arg$2;
        DataTransportCrashlyticsReportSender.lambda$sendReport$1(taskCompletionSource, crashlyticsReportWithSessionId, exception);
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;

public final class SessionReportingCoordinator$$Lambda$1
implements Continuation {
    private final SessionReportingCoordinator arg$1;

    private SessionReportingCoordinator$$Lambda$1(SessionReportingCoordinator sessionReportingCoordinator) {
        this.arg$1 = sessionReportingCoordinator;
    }

    public static Continuation lambdaFactory$(SessionReportingCoordinator sessionReportingCoordinator) {
        SessionReportingCoordinator$$Lambda$1 sessionReportingCoordinator$$Lambda$1 = new SessionReportingCoordinator$$Lambda$1(sessionReportingCoordinator);
        return sessionReportingCoordinator$$Lambda$1;
    }

    public Object then(Task task) {
        return SessionReportingCoordinator.access$lambda$0(this.arg$1, task);
    }
}


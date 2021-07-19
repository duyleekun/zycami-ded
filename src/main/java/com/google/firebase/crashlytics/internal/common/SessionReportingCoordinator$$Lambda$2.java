/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute;
import java.util.Comparator;

public final class SessionReportingCoordinator$$Lambda$2
implements Comparator {
    private static final SessionReportingCoordinator$$Lambda$2 instance;

    static {
        SessionReportingCoordinator$$Lambda$2 sessionReportingCoordinator$$Lambda$2;
        instance = sessionReportingCoordinator$$Lambda$2 = new SessionReportingCoordinator$$Lambda$2();
    }

    private SessionReportingCoordinator$$Lambda$2() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    public int compare(Object object, Object object2) {
        object = (CrashlyticsReport$CustomAttribute)object;
        object2 = (CrashlyticsReport$CustomAttribute)object2;
        return SessionReportingCoordinator.lambda$getSortedCustomAttributes$0((CrashlyticsReport$CustomAttribute)object, (CrashlyticsReport$CustomAttribute)object2);
    }
}


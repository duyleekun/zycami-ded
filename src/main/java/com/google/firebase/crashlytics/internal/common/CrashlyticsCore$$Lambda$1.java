/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;

public final class CrashlyticsCore$$Lambda$1
implements BreadcrumbHandler {
    private final CrashlyticsCore arg$1;

    private CrashlyticsCore$$Lambda$1(CrashlyticsCore crashlyticsCore) {
        this.arg$1 = crashlyticsCore;
    }

    public static BreadcrumbHandler lambdaFactory$(CrashlyticsCore crashlyticsCore) {
        CrashlyticsCore$$Lambda$1 crashlyticsCore$$Lambda$1 = new CrashlyticsCore$$Lambda$1(crashlyticsCore);
        return crashlyticsCore$$Lambda$1;
    }

    public void handleBreadcrumb(String string2) {
        this.arg$1.log(string2);
    }
}


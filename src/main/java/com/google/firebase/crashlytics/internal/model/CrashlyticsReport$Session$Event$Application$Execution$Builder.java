/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public abstract class CrashlyticsReport$Session$Event$Application$Execution$Builder {
    public abstract CrashlyticsReport$Session$Event$Application$Execution build();

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Builder setBinaries(ImmutableList var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Builder setException(CrashlyticsReport$Session$Event$Application$Execution$Exception var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Builder setSignal(CrashlyticsReport$Session$Event$Application$Execution$Signal var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Builder setThreads(ImmutableList var1);
}


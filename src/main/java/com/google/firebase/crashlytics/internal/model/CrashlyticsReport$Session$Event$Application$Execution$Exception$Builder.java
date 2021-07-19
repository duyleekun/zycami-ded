/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public abstract class CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder {
    public abstract CrashlyticsReport$Session$Event$Application$Execution$Exception build();

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder setCausedBy(CrashlyticsReport$Session$Event$Application$Execution$Exception var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder setFrames(ImmutableList var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder setOverflowCount(int var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder setReason(String var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder setType(String var1);
}


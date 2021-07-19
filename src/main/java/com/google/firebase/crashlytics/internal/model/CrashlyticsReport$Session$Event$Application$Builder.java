/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public abstract class CrashlyticsReport$Session$Event$Application$Builder {
    public abstract CrashlyticsReport$Session$Event$Application build();

    public abstract CrashlyticsReport$Session$Event$Application$Builder setBackground(Boolean var1);

    public abstract CrashlyticsReport$Session$Event$Application$Builder setCustomAttributes(ImmutableList var1);

    public abstract CrashlyticsReport$Session$Event$Application$Builder setExecution(CrashlyticsReport$Session$Event$Application$Execution var1);

    public abstract CrashlyticsReport$Session$Event$Application$Builder setUiOrientation(int var1);
}


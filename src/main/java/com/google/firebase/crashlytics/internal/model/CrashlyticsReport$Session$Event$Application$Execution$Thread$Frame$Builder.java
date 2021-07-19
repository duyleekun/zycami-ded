/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame;

public abstract class CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder {
    public abstract CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame build();

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder setFile(String var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder setImportance(int var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder setOffset(long var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder setPc(long var1);

    public abstract CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder setSymbol(String var1);
}


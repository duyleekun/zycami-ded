/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem;

public abstract class CrashlyticsReport$Session$OperatingSystem$Builder {
    public abstract CrashlyticsReport$Session$OperatingSystem build();

    public abstract CrashlyticsReport$Session$OperatingSystem$Builder setBuildVersion(String var1);

    public abstract CrashlyticsReport$Session$OperatingSystem$Builder setJailbroken(boolean var1);

    public abstract CrashlyticsReport$Session$OperatingSystem$Builder setPlatform(int var1);

    public abstract CrashlyticsReport$Session$OperatingSystem$Builder setVersion(String var1);
}


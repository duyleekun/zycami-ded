/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device;

public abstract class CrashlyticsReport$Session$Event$Device$Builder {
    public abstract CrashlyticsReport$Session$Event$Device build();

    public abstract CrashlyticsReport$Session$Event$Device$Builder setBatteryLevel(Double var1);

    public abstract CrashlyticsReport$Session$Event$Device$Builder setBatteryVelocity(int var1);

    public abstract CrashlyticsReport$Session$Event$Device$Builder setDiskUsed(long var1);

    public abstract CrashlyticsReport$Session$Event$Device$Builder setOrientation(int var1);

    public abstract CrashlyticsReport$Session$Event$Device$Builder setProximityOn(boolean var1);

    public abstract CrashlyticsReport$Session$Event$Device$Builder setRamUsed(long var1);
}


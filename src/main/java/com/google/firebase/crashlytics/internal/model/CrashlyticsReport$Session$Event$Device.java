/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device$Builder;

public abstract class CrashlyticsReport$Session$Event$Device {
    public static CrashlyticsReport$Session$Event$Device$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Event_Device$Builder autoValue_CrashlyticsReport_Session_Event_Device$Builder = new AutoValue_CrashlyticsReport_Session_Event_Device$Builder();
        return autoValue_CrashlyticsReport_Session_Event_Device$Builder;
    }

    public abstract Double getBatteryLevel();

    public abstract int getBatteryVelocity();

    public abstract long getDiskUsed();

    public abstract int getOrientation();

    public abstract long getRamUsed();

    public abstract boolean isProximityOn();
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device$Builder;

public final class AutoValue_CrashlyticsReport_Session_Event_Device$Builder
extends CrashlyticsReport$Session$Event$Device$Builder {
    private Double batteryLevel;
    private Integer batteryVelocity;
    private Long diskUsed;
    private Integer orientation;
    private Boolean proximityOn;
    private Long ramUsed;

    public CrashlyticsReport$Session$Event$Device build() {
        boolean bl2;
        Object object = this.batteryVelocity;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" batteryVelocity");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.proximityOn) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" proximityOn");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.orientation) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" orientation");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.ramUsed) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" ramUsed");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.diskUsed) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" diskUsed");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            Double d10 = this.batteryLevel;
            int n10 = this.batteryVelocity;
            boolean bl3 = this.proximityOn;
            int n11 = this.orientation;
            long l10 = this.ramUsed;
            long l11 = this.diskUsed;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_Event_Device(d10, n10, bl3, n11, l10, l11, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Event$Device$Builder setBatteryLevel(Double d10) {
        this.batteryLevel = d10;
        return this;
    }

    public CrashlyticsReport$Session$Event$Device$Builder setBatteryVelocity(int n10) {
        Integer n11;
        this.batteryVelocity = n11 = Integer.valueOf(n10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Device$Builder setDiskUsed(long l10) {
        Long l11;
        this.diskUsed = l11 = Long.valueOf(l10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Device$Builder setOrientation(int n10) {
        Integer n11;
        this.orientation = n11 = Integer.valueOf(n10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Device$Builder setProximityOn(boolean bl2) {
        Boolean bl3;
        this.proximityOn = bl3 = Boolean.valueOf(bl2);
        return this;
    }

    public CrashlyticsReport$Session$Event$Device$Builder setRamUsed(long l10) {
        Long l11;
        this.ramUsed = l11 = Long.valueOf(l10);
        return this;
    }
}


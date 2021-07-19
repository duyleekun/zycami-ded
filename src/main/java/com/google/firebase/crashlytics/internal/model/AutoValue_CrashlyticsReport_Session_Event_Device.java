/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device;

public final class AutoValue_CrashlyticsReport_Session_Event_Device
extends CrashlyticsReport$Session$Event$Device {
    private final Double batteryLevel;
    private final int batteryVelocity;
    private final long diskUsed;
    private final int orientation;
    private final boolean proximityOn;
    private final long ramUsed;

    private AutoValue_CrashlyticsReport_Session_Event_Device(Double d10, int n10, boolean bl2, int n11, long l10, long l11) {
        this.batteryLevel = d10;
        this.batteryVelocity = n10;
        this.proximityOn = bl2;
        this.orientation = n11;
        this.ramUsed = l10;
        this.diskUsed = l11;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event_Device(Double d10, int n10, boolean bl2, int n11, long l10, long l11, AutoValue_CrashlyticsReport_Session_Event_Device$1 autoValue_CrashlyticsReport_Session_Event_Device$1) {
        this(d10, n10, bl2, n11, l10, l11);
    }

    public boolean equals(Object object) {
        block4: {
            boolean bl2;
            block6: {
                block5: {
                    long l10;
                    long l11;
                    long l12;
                    long l13;
                    long l14;
                    Double d10;
                    bl2 = true;
                    if (object == this) {
                        return bl2;
                    }
                    int n10 = object instanceof CrashlyticsReport$Session$Event$Device;
                    if (n10 == 0) break block4;
                    object = (CrashlyticsReport$Session$Event$Device)object;
                    Double d11 = this.batteryLevel;
                    if (!(d11 == null ? (d11 = ((CrashlyticsReport$Session$Event$Device)object).getBatteryLevel()) == null : (n10 = d11.equals(d10 = ((CrashlyticsReport$Session$Event$Device)object).getBatteryLevel())) != 0)) break block5;
                    n10 = this.batteryVelocity;
                    int n11 = ((CrashlyticsReport$Session$Event$Device)object).getBatteryVelocity();
                    if (n10 == n11 && (n10 = (int)(this.proximityOn ? 1 : 0)) == (n11 = (int)(((CrashlyticsReport$Session$Event$Device)object).isProximityOn() ? 1 : 0)) && (n10 = this.orientation) == (n11 = ((CrashlyticsReport$Session$Event$Device)object).getOrientation()) && (n10 = (int)((l14 = (l13 = this.ramUsed) - (l12 = ((CrashlyticsReport$Session$Event$Device)object).getRamUsed())) == 0L ? 0 : (l14 < 0L ? -1 : 1))) == 0 && (l11 = (l10 = (l13 = this.diskUsed) - (l12 = ((CrashlyticsReport$Session$Event$Device)object).getDiskUsed())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) break block6;
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Double getBatteryLevel() {
        return this.batteryLevel;
    }

    public int getBatteryVelocity() {
        return this.batteryVelocity;
    }

    public long getDiskUsed() {
        return this.diskUsed;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public long getRamUsed() {
        return this.ramUsed;
    }

    public int hashCode() {
        int n10;
        Double d10 = this.batteryLevel;
        if (d10 == null) {
            n10 = 0;
            d10 = null;
        } else {
            n10 = d10.hashCode();
        }
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.batteryVelocity;
        n10 = (n10 ^ n12) * n11;
        n12 = (int)(this.proximityOn ? 1 : 0);
        n12 = n12 != 0 ? 1231 : 1237;
        n10 = (n10 ^ n12) * n11;
        n12 = this.orientation;
        n10 = (n10 ^ n12) * n11;
        long l10 = this.ramUsed;
        int n13 = 32;
        long l11 = l10 >>> n13;
        n12 = (int)(l10 ^ l11);
        n10 = (n10 ^ n12) * n11;
        long l12 = this.diskUsed;
        long l13 = l12 >>> n13;
        n11 = (int)(l12 ^ l13);
        return n10 ^ n11;
    }

    public boolean isProximityOn() {
        return this.proximityOn;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Device{batteryLevel=");
        Double d10 = this.batteryLevel;
        stringBuilder.append(d10);
        stringBuilder.append(", batteryVelocity=");
        int n10 = this.batteryVelocity;
        stringBuilder.append(n10);
        stringBuilder.append(", proximityOn=");
        n10 = (int)(this.proximityOn ? 1 : 0);
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", orientation=");
        n10 = this.orientation;
        stringBuilder.append(n10);
        stringBuilder.append(", ramUsed=");
        long l10 = this.ramUsed;
        stringBuilder.append(l10);
        stringBuilder.append(", diskUsed=");
        l10 = this.diskUsed;
        stringBuilder.append(l10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


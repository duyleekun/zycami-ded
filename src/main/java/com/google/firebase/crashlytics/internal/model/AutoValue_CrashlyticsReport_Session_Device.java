/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device;

public final class AutoValue_CrashlyticsReport_Session_Device
extends CrashlyticsReport$Session$Device {
    private final int arch;
    private final int cores;
    private final long diskSpace;
    private final String manufacturer;
    private final String model;
    private final String modelClass;
    private final long ram;
    private final boolean simulator;
    private final int state;

    private AutoValue_CrashlyticsReport_Session_Device(int n10, String string2, int n11, long l10, long l11, boolean bl2, int n12, String string3, String string4) {
        this.arch = n10;
        this.model = string2;
        this.cores = n11;
        this.ram = l10;
        this.diskSpace = l11;
        this.simulator = bl2;
        this.state = n12;
        this.manufacturer = string3;
        this.modelClass = string4;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Device(int n10, String string2, int n11, long l10, long l11, boolean bl2, int n12, String string3, String string4, AutoValue_CrashlyticsReport_Session_Device$1 autoValue_CrashlyticsReport_Session_Device$1) {
        this(n10, string2, n11, l10, l11, bl2, n12, string3, string4);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof CrashlyticsReport$Session$Device;
        if (n10 != 0) {
            boolean bl3;
            long l10;
            long l11;
            long l12;
            long l13;
            String string2;
            String string3;
            n10 = this.arch;
            int n11 = ((CrashlyticsReport$Session$Device)(object = (CrashlyticsReport$Session$Device)object)).getArch();
            if (n10 != n11 || (n10 = (int)((string3 = this.model).equals(string2 = ((CrashlyticsReport$Session$Device)object).getModel()) ? 1 : 0)) == 0 || (n10 = this.cores) != (n11 = ((CrashlyticsReport$Session$Device)object).getCores()) || (n10 = (int)((l13 = (l12 = this.ram) - (l11 = ((CrashlyticsReport$Session$Device)object).getRam())) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0 || (n10 = (int)((l10 = (l12 = this.diskSpace) - (l11 = ((CrashlyticsReport$Session$Device)object).getDiskSpace())) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 || (n10 = (int)(this.simulator ? 1 : 0)) != (n11 = (int)(((CrashlyticsReport$Session$Device)object).isSimulator() ? 1 : 0)) || (n10 = this.state) != (n11 = ((CrashlyticsReport$Session$Device)object).getState()) || (n10 = (int)((string3 = this.manufacturer).equals(string2 = ((CrashlyticsReport$Session$Device)object).getManufacturer()) ? 1 : 0)) == 0 || !(bl3 = (string3 = this.modelClass).equals(object = ((CrashlyticsReport$Session$Device)object).getModelClass()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getArch() {
        return this.arch;
    }

    public int getCores() {
        return this.cores;
    }

    public long getDiskSpace() {
        return this.diskSpace;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getModelClass() {
        return this.modelClass;
    }

    public long getRam() {
        return this.ram;
    }

    public int getState() {
        return this.state;
    }

    public int hashCode() {
        int n10 = this.arch;
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        String string2 = this.model;
        int n12 = string2.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.cores;
        n10 = (n10 ^ n12) * n11;
        long l10 = this.ram;
        int n13 = 32;
        long l11 = l10 >>> n13;
        n12 = (int)(l10 ^ l11);
        n10 = (n10 ^ n12) * n11;
        l10 = this.diskSpace;
        long l12 = l10 >>> n13;
        n12 = (int)(l10 ^= l12);
        n10 = (n10 ^ n12) * n11;
        n12 = (int)(this.simulator ? 1 : 0);
        n12 = n12 != 0 ? 1231 : 1237;
        n10 = (n10 ^ n12) * n11;
        n12 = this.state;
        n10 = (n10 ^ n12) * n11;
        n12 = this.manufacturer.hashCode();
        n10 = (n10 ^ n12) * n11;
        n11 = this.modelClass.hashCode();
        return n10 ^ n11;
    }

    public boolean isSimulator() {
        return this.simulator;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Device{arch=");
        int n10 = this.arch;
        stringBuilder.append(n10);
        stringBuilder.append(", model=");
        String string2 = this.model;
        stringBuilder.append(string2);
        stringBuilder.append(", cores=");
        n10 = this.cores;
        stringBuilder.append(n10);
        stringBuilder.append(", ram=");
        long l10 = this.ram;
        stringBuilder.append(l10);
        stringBuilder.append(", diskSpace=");
        l10 = this.diskSpace;
        stringBuilder.append(l10);
        stringBuilder.append(", simulator=");
        n10 = (int)(this.simulator ? 1 : 0);
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", state=");
        n10 = this.state;
        stringBuilder.append(n10);
        stringBuilder.append(", manufacturer=");
        string2 = this.manufacturer;
        stringBuilder.append(string2);
        stringBuilder.append(", modelClass=");
        string2 = this.modelClass;
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


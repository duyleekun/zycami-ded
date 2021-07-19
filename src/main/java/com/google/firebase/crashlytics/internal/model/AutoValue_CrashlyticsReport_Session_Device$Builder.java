/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Device$Builder
extends CrashlyticsReport$Session$Device$Builder {
    private Integer arch;
    private Integer cores;
    private Long diskSpace;
    private String manufacturer;
    private String model;
    private String modelClass;
    private Long ram;
    private Boolean simulator;
    private Integer state;

    public CrashlyticsReport$Session$Device build() {
        boolean bl2;
        Object object = this.arch;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" arch");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.model) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" model");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.cores) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" cores");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.ram) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" ram");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.diskSpace) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" diskSpace");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.simulator) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" simulator");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.state) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" state");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.manufacturer) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" manufacturer");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.modelClass) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" modelClass");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            int n10 = this.arch;
            String string3 = this.model;
            int n11 = this.cores;
            long l10 = this.ram;
            long l11 = this.diskSpace;
            boolean bl3 = this.simulator;
            int n12 = this.state;
            String string4 = this.manufacturer;
            String string5 = this.modelClass;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_Device(n10, string3, n11, l10, l11, bl3, n12, string4, string5, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Device$Builder setArch(int n10) {
        Integer n11;
        this.arch = n11 = Integer.valueOf(n10);
        return this;
    }

    public CrashlyticsReport$Session$Device$Builder setCores(int n10) {
        Integer n11;
        this.cores = n11 = Integer.valueOf(n10);
        return this;
    }

    public CrashlyticsReport$Session$Device$Builder setDiskSpace(long l10) {
        Long l11;
        this.diskSpace = l11 = Long.valueOf(l10);
        return this;
    }

    public CrashlyticsReport$Session$Device$Builder setManufacturer(String string2) {
        Objects.requireNonNull(string2, "Null manufacturer");
        this.manufacturer = string2;
        return this;
    }

    public CrashlyticsReport$Session$Device$Builder setModel(String string2) {
        Objects.requireNonNull(string2, "Null model");
        this.model = string2;
        return this;
    }

    public CrashlyticsReport$Session$Device$Builder setModelClass(String string2) {
        Objects.requireNonNull(string2, "Null modelClass");
        this.modelClass = string2;
        return this;
    }

    public CrashlyticsReport$Session$Device$Builder setRam(long l10) {
        Long l11;
        this.ram = l11 = Long.valueOf(l10);
        return this;
    }

    public CrashlyticsReport$Session$Device$Builder setSimulator(boolean bl2) {
        Boolean bl3;
        this.simulator = bl3 = Boolean.valueOf(bl2);
        return this;
    }

    public CrashlyticsReport$Session$Device$Builder setState(int n10) {
        Integer n11;
        this.state = n11 = Integer.valueOf(n10);
        return this;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder;

public abstract class CrashlyticsReport$Session$Device {
    public static CrashlyticsReport$Session$Device$Builder builder() {
        AutoValue_CrashlyticsReport_Session_Device$Builder autoValue_CrashlyticsReport_Session_Device$Builder = new AutoValue_CrashlyticsReport_Session_Device$Builder();
        return autoValue_CrashlyticsReport_Session_Device$Builder;
    }

    public abstract int getArch();

    public abstract int getCores();

    public abstract long getDiskSpace();

    public abstract String getManufacturer();

    public abstract String getModel();

    public abstract String getModelClass();

    public abstract long getRam();

    public abstract int getState();

    public abstract boolean isSimulator();
}


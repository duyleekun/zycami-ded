/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device;

public abstract class CrashlyticsReport$Session$Device$Builder {
    public abstract CrashlyticsReport$Session$Device build();

    public abstract CrashlyticsReport$Session$Device$Builder setArch(int var1);

    public abstract CrashlyticsReport$Session$Device$Builder setCores(int var1);

    public abstract CrashlyticsReport$Session$Device$Builder setDiskSpace(long var1);

    public abstract CrashlyticsReport$Session$Device$Builder setManufacturer(String var1);

    public abstract CrashlyticsReport$Session$Device$Builder setModel(String var1);

    public abstract CrashlyticsReport$Session$Device$Builder setModelClass(String var1);

    public abstract CrashlyticsReport$Session$Device$Builder setRam(long var1);

    public abstract CrashlyticsReport$Session$Device$Builder setSimulator(boolean var1);

    public abstract CrashlyticsReport$Session$Device$Builder setState(int var1);
}


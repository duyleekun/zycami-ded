/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.nio.charset.Charset;

public abstract class CrashlyticsReport$Session$Builder {
    public abstract CrashlyticsReport$Session build();

    public abstract CrashlyticsReport$Session$Builder setApp(CrashlyticsReport$Session$Application var1);

    public abstract CrashlyticsReport$Session$Builder setCrashed(boolean var1);

    public abstract CrashlyticsReport$Session$Builder setDevice(CrashlyticsReport$Session$Device var1);

    public abstract CrashlyticsReport$Session$Builder setEndedAt(Long var1);

    public abstract CrashlyticsReport$Session$Builder setEvents(ImmutableList var1);

    public abstract CrashlyticsReport$Session$Builder setGenerator(String var1);

    public abstract CrashlyticsReport$Session$Builder setGeneratorType(int var1);

    public abstract CrashlyticsReport$Session$Builder setIdentifier(String var1);

    public CrashlyticsReport$Session$Builder setIdentifierFromUtf8Bytes(byte[] byArray) {
        Charset charset = CrashlyticsReport.access$000();
        String string2 = new String(byArray, charset);
        return this.setIdentifier(string2);
    }

    public abstract CrashlyticsReport$Session$Builder setOs(CrashlyticsReport$Session$OperatingSystem var1);

    public abstract CrashlyticsReport$Session$Builder setStartedAt(long var1);

    public abstract CrashlyticsReport$Session$Builder setUser(CrashlyticsReport$Session.User var1);
}


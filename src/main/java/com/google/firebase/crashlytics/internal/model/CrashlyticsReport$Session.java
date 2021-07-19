/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.nio.charset.Charset;

public abstract class CrashlyticsReport$Session {
    public static CrashlyticsReport$Session$Builder builder() {
        AutoValue_CrashlyticsReport_Session$Builder autoValue_CrashlyticsReport_Session$Builder = new AutoValue_CrashlyticsReport_Session$Builder();
        return autoValue_CrashlyticsReport_Session$Builder.setCrashed(false);
    }

    public abstract CrashlyticsReport$Session$Application getApp();

    public abstract CrashlyticsReport$Session$Device getDevice();

    public abstract Long getEndedAt();

    public abstract ImmutableList getEvents();

    public abstract String getGenerator();

    public abstract int getGeneratorType();

    public abstract String getIdentifier();

    public byte[] getIdentifierUtf8Bytes() {
        String string2 = this.getIdentifier();
        Charset charset = CrashlyticsReport.access$000();
        return string2.getBytes(charset);
    }

    public abstract CrashlyticsReport$Session$OperatingSystem getOs();

    public abstract long getStartedAt();

    public abstract CrashlyticsReport$Session$User getUser();

    public abstract boolean isCrashed();

    public abstract CrashlyticsReport$Session$Builder toBuilder();

    public CrashlyticsReport$Session withEvents(ImmutableList immutableList) {
        return this.toBuilder().setEvents(immutableList).build();
    }

    public CrashlyticsReport$Session withOrganizationId(String object) {
        object = this.getApp().withOrganizationId((String)object);
        return this.toBuilder().setApp((CrashlyticsReport$Session$Application)object).build();
    }

    public CrashlyticsReport$Session withSessionEndFields(long l10, boolean bl2, String string2) {
        CrashlyticsReport$Session$Builder crashlyticsReport$Session$Builder = this.toBuilder();
        Object object = l10;
        crashlyticsReport$Session$Builder.setEndedAt((Long)object);
        crashlyticsReport$Session$Builder.setCrashed(bl2);
        if (string2 != null) {
            object = CrashlyticsReport$Session$User.builder().setIdentifier(string2).build();
            object = crashlyticsReport$Session$Builder.setUser((CrashlyticsReport$Session$User)object);
            ((CrashlyticsReport$Session$Builder)object).build();
        }
        return crashlyticsReport$Session$Builder.build();
    }
}


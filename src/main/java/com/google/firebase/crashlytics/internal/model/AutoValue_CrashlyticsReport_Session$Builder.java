/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session$Builder
extends CrashlyticsReport$Session$Builder {
    private CrashlyticsReport$Session$Application app;
    private Boolean crashed;
    private CrashlyticsReport$Session$Device device;
    private Long endedAt;
    private ImmutableList events;
    private String generator;
    private Integer generatorType;
    private String identifier;
    private CrashlyticsReport$Session$OperatingSystem os;
    private Long startedAt;
    private CrashlyticsReport$Session$User user;

    public AutoValue_CrashlyticsReport_Session$Builder() {
    }

    private AutoValue_CrashlyticsReport_Session$Builder(CrashlyticsReport$Session object) {
        Object object2 = ((CrashlyticsReport$Session)object).getGenerator();
        this.generator = object2;
        object2 = ((CrashlyticsReport$Session)object).getIdentifier();
        this.identifier = object2;
        this.startedAt = object2 = Long.valueOf(((CrashlyticsReport$Session)object).getStartedAt());
        this.endedAt = object2 = ((CrashlyticsReport$Session)object).getEndedAt();
        this.crashed = object2 = Boolean.valueOf(((CrashlyticsReport$Session)object).isCrashed());
        this.app = object2 = ((CrashlyticsReport$Session)object).getApp();
        this.user = object2 = ((CrashlyticsReport$Session)object).getUser();
        this.os = object2 = ((CrashlyticsReport$Session)object).getOs();
        this.device = object2 = ((CrashlyticsReport$Session)object).getDevice();
        this.events = object2 = ((CrashlyticsReport$Session)object).getEvents();
        this.generatorType = object = Integer.valueOf(((CrashlyticsReport$Session)object).getGeneratorType());
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session$Builder(CrashlyticsReport$Session crashlyticsReport$Session, AutoValue_CrashlyticsReport_Session$1 autoValue_CrashlyticsReport_Session$1) {
        this(crashlyticsReport$Session);
    }

    public CrashlyticsReport$Session build() {
        boolean bl2;
        AutoValue_CrashlyticsReport_Session$Builder autoValue_CrashlyticsReport_Session$Builder = this;
        Object object = this.generator;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" generator");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = autoValue_CrashlyticsReport_Session$Builder.identifier) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" identifier");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = autoValue_CrashlyticsReport_Session$Builder.startedAt) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" startedAt");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = autoValue_CrashlyticsReport_Session$Builder.crashed) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" crashed");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = autoValue_CrashlyticsReport_Session$Builder.app) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" app");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = autoValue_CrashlyticsReport_Session$Builder.generatorType) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" generatorType");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            String string3 = autoValue_CrashlyticsReport_Session$Builder.generator;
            String string4 = autoValue_CrashlyticsReport_Session$Builder.identifier;
            long l10 = autoValue_CrashlyticsReport_Session$Builder.startedAt;
            Long l11 = autoValue_CrashlyticsReport_Session$Builder.endedAt;
            boolean bl3 = autoValue_CrashlyticsReport_Session$Builder.crashed;
            CrashlyticsReport$Session$Application crashlyticsReport$Session$Application = autoValue_CrashlyticsReport_Session$Builder.app;
            CrashlyticsReport$Session$User crashlyticsReport$Session$User = autoValue_CrashlyticsReport_Session$Builder.user;
            CrashlyticsReport$Session$OperatingSystem crashlyticsReport$Session$OperatingSystem = autoValue_CrashlyticsReport_Session$Builder.os;
            CrashlyticsReport$Session$Device crashlyticsReport$Session$Device = autoValue_CrashlyticsReport_Session$Builder.device;
            ImmutableList immutableList = autoValue_CrashlyticsReport_Session$Builder.events;
            int n10 = autoValue_CrashlyticsReport_Session$Builder.generatorType;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session(string3, string4, l10, l11, bl3, crashlyticsReport$Session$Application, crashlyticsReport$Session$User, crashlyticsReport$Session$OperatingSystem, crashlyticsReport$Session$Device, immutableList, n10, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Builder setApp(CrashlyticsReport$Session$Application crashlyticsReport$Session$Application) {
        Objects.requireNonNull(crashlyticsReport$Session$Application, "Null app");
        this.app = crashlyticsReport$Session$Application;
        return this;
    }

    public CrashlyticsReport$Session$Builder setCrashed(boolean bl2) {
        Boolean bl3;
        this.crashed = bl3 = Boolean.valueOf(bl2);
        return this;
    }

    public CrashlyticsReport$Session$Builder setDevice(CrashlyticsReport$Session$Device crashlyticsReport$Session$Device) {
        this.device = crashlyticsReport$Session$Device;
        return this;
    }

    public CrashlyticsReport$Session$Builder setEndedAt(Long l10) {
        this.endedAt = l10;
        return this;
    }

    public CrashlyticsReport$Session$Builder setEvents(ImmutableList immutableList) {
        this.events = immutableList;
        return this;
    }

    public CrashlyticsReport$Session$Builder setGenerator(String string2) {
        Objects.requireNonNull(string2, "Null generator");
        this.generator = string2;
        return this;
    }

    public CrashlyticsReport$Session$Builder setGeneratorType(int n10) {
        Integer n11;
        this.generatorType = n11 = Integer.valueOf(n10);
        return this;
    }

    public CrashlyticsReport$Session$Builder setIdentifier(String string2) {
        Objects.requireNonNull(string2, "Null identifier");
        this.identifier = string2;
        return this;
    }

    public CrashlyticsReport$Session$Builder setOs(CrashlyticsReport$Session$OperatingSystem crashlyticsReport$Session$OperatingSystem) {
        this.os = crashlyticsReport$Session$OperatingSystem;
        return this;
    }

    public CrashlyticsReport$Session$Builder setStartedAt(long l10) {
        Long l11;
        this.startedAt = l11 = Long.valueOf(l10);
        return this;
    }

    public CrashlyticsReport$Session$Builder setUser(CrashlyticsReport$Session$User crashlyticsReport$Session$User) {
        this.user = crashlyticsReport$Session$User;
        return this;
    }
}


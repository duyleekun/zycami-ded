/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event$Builder
extends CrashlyticsReport$Session$Event$Builder {
    private CrashlyticsReport$Session$Event$Application app;
    private CrashlyticsReport$Session$Event$Device device;
    private CrashlyticsReport$Session$Event$Log log;
    private Long timestamp;
    private String type;

    public AutoValue_CrashlyticsReport_Session_Event$Builder() {
    }

    private AutoValue_CrashlyticsReport_Session_Event$Builder(CrashlyticsReport$Session$Event object) {
        Object object2 = ((CrashlyticsReport$Session$Event)object).getTimestamp();
        this.timestamp = object2;
        this.type = object2 = ((CrashlyticsReport$Session$Event)object).getType();
        this.app = object2 = ((CrashlyticsReport$Session$Event)object).getApp();
        this.device = object2 = ((CrashlyticsReport$Session$Event)object).getDevice();
        this.log = object = ((CrashlyticsReport$Session$Event)object).getLog();
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event$Builder(CrashlyticsReport$Session$Event crashlyticsReport$Session$Event, AutoValue_CrashlyticsReport_Session_Event$1 autoValue_CrashlyticsReport_Session_Event$1) {
        this(crashlyticsReport$Session$Event);
    }

    public CrashlyticsReport$Session$Event build() {
        boolean bl2;
        Object object = this.timestamp;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" timestamp");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.type) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" type");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.app) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" app");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.device) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" device");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            long l10 = this.timestamp;
            String string3 = this.type;
            CrashlyticsReport$Session$Event$Application crashlyticsReport$Session$Event$Application = this.app;
            CrashlyticsReport$Session$Event$Device crashlyticsReport$Session$Event$Device = this.device;
            CrashlyticsReport$Session$Event$Log crashlyticsReport$Session$Event$Log = this.log;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_Event(l10, string3, crashlyticsReport$Session$Event$Application, crashlyticsReport$Session$Event$Device, crashlyticsReport$Session$Event$Log, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Event$Builder setApp(CrashlyticsReport$Session$Event$Application crashlyticsReport$Session$Event$Application) {
        Objects.requireNonNull(crashlyticsReport$Session$Event$Application, "Null app");
        this.app = crashlyticsReport$Session$Event$Application;
        return this;
    }

    public CrashlyticsReport$Session$Event$Builder setDevice(CrashlyticsReport$Session$Event$Device crashlyticsReport$Session$Event$Device) {
        Objects.requireNonNull(crashlyticsReport$Session$Event$Device, "Null device");
        this.device = crashlyticsReport$Session$Event$Device;
        return this;
    }

    public CrashlyticsReport$Session$Event$Builder setLog(CrashlyticsReport$Session$Event$Log crashlyticsReport$Session$Event$Log) {
        this.log = crashlyticsReport$Session$Event$Log;
        return this;
    }

    public CrashlyticsReport$Session$Event$Builder setTimestamp(long l10) {
        Long l11;
        this.timestamp = l11 = Long.valueOf(l10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Builder setType(String string2) {
        Objects.requireNonNull(string2, "Null type");
        this.type = string2;
        return this;
    }
}


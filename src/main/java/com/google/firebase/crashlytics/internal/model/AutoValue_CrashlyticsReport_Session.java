/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session$1;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public final class AutoValue_CrashlyticsReport_Session
extends CrashlyticsReport$Session {
    private final CrashlyticsReport$Session$Application app;
    private final boolean crashed;
    private final CrashlyticsReport$Session$Device device;
    private final Long endedAt;
    private final ImmutableList events;
    private final String generator;
    private final int generatorType;
    private final String identifier;
    private final CrashlyticsReport$Session$OperatingSystem os;
    private final long startedAt;
    private final CrashlyticsReport$Session$User user;

    private AutoValue_CrashlyticsReport_Session(String string2, String string3, long l10, Long l11, boolean bl2, CrashlyticsReport$Session$Application crashlyticsReport$Session$Application, CrashlyticsReport$Session$User crashlyticsReport$Session$User, CrashlyticsReport$Session$OperatingSystem crashlyticsReport$Session$OperatingSystem, CrashlyticsReport$Session$Device crashlyticsReport$Session$Device, ImmutableList immutableList, int n10) {
        this.generator = string2;
        this.identifier = string3;
        this.startedAt = l10;
        this.endedAt = l11;
        this.crashed = bl2;
        this.app = crashlyticsReport$Session$Application;
        this.user = crashlyticsReport$Session$User;
        this.os = crashlyticsReport$Session$OperatingSystem;
        this.device = crashlyticsReport$Session$Device;
        this.events = immutableList;
        this.generatorType = n10;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session(String string2, String string3, long l10, Long l11, boolean bl2, CrashlyticsReport$Session$Application crashlyticsReport$Session$Application, CrashlyticsReport$Session$User crashlyticsReport$Session$User, CrashlyticsReport$Session$OperatingSystem crashlyticsReport$Session$OperatingSystem, CrashlyticsReport$Session$Device crashlyticsReport$Session$Device, ImmutableList immutableList, int n10, AutoValue_CrashlyticsReport_Session$1 autoValue_CrashlyticsReport_Session$1) {
        this(string2, string3, l10, l11, bl2, crashlyticsReport$Session$Application, crashlyticsReport$Session$User, crashlyticsReport$Session$OperatingSystem, crashlyticsReport$Session$Device, immutableList, n10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean n11 = object instanceof CrashlyticsReport$Session;
        if (n11) {
            int n10;
            int n12;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            long l10;
            long l11;
            long l12;
            long l13;
            boolean bl11;
            Object object2 = this.generator;
            Object object3 = ((CrashlyticsReport$Session)(object = (CrashlyticsReport$Session)object)).getGenerator();
            boolean bl12 = ((String)object2).equals(object3);
            if (!(bl12 && (bl11 = ((String)(object2 = this.identifier)).equals(object3 = ((CrashlyticsReport$Session)object).getIdentifier())) && (l13 = (l12 = (l11 = this.startedAt) - (l10 = ((CrashlyticsReport$Session)object).getStartedAt())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false && ((object2 = this.endedAt) == null ? (object2 = ((CrashlyticsReport$Session)object).getEndedAt()) == null : (bl10 = ((Long)object2).equals(object3 = ((CrashlyticsReport$Session)object).getEndedAt()))) && (bl9 = this.crashed) == (bl8 = ((CrashlyticsReport$Session)object).isCrashed()) && (bl7 = (object2 = this.app).equals(object3 = ((CrashlyticsReport$Session)object).getApp())) && ((object2 = this.user) == null ? (object2 = ((CrashlyticsReport$Session)object).getUser()) == null : (bl6 = object2.equals(object3 = ((CrashlyticsReport$Session)object).getUser()))) && ((object2 = this.os) == null ? (object2 = ((CrashlyticsReport$Session)object).getOs()) == null : (bl5 = object2.equals(object3 = ((CrashlyticsReport$Session)object).getOs()))) && ((object2 = this.device) == null ? (object2 = ((CrashlyticsReport$Session)object).getDevice()) == null : (bl4 = object2.equals(object3 = ((CrashlyticsReport$Session)object).getDevice()))) && ((object2 = this.events) == null ? (object2 = ((CrashlyticsReport$Session)object).getEvents()) == null : (bl3 = ((ImmutableList)object2).equals(object3 = ((CrashlyticsReport$Session)object).getEvents()))) && (n12 = this.generatorType) == (n10 = ((CrashlyticsReport$Session)object).getGeneratorType()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public CrashlyticsReport$Session$Application getApp() {
        return this.app;
    }

    public CrashlyticsReport$Session$Device getDevice() {
        return this.device;
    }

    public Long getEndedAt() {
        return this.endedAt;
    }

    public ImmutableList getEvents() {
        return this.events;
    }

    public String getGenerator() {
        return this.generator;
    }

    public int getGeneratorType() {
        return this.generatorType;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public CrashlyticsReport$Session$OperatingSystem getOs() {
        return this.os;
    }

    public long getStartedAt() {
        return this.startedAt;
    }

    public CrashlyticsReport$Session$User getUser() {
        return this.user;
    }

    public int hashCode() {
        String string2 = this.generator;
        int n10 = string2.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.identifier.hashCode();
        n10 = (n10 ^ n12) * n11;
        long l10 = this.startedAt;
        int n13 = 32;
        long l11 = l10 >>> n13;
        n12 = (int)(l10 ^= l11);
        n10 = (n10 ^ n12) * n11;
        Object object = this.endedAt;
        int n14 = 0;
        if (object == null) {
            n12 = 0;
            object = null;
        } else {
            n12 = ((Long)object).hashCode();
        }
        n10 = (n10 ^ n12) * n11;
        n12 = (int)(this.crashed ? 1 : 0);
        n12 = n12 != 0 ? 1231 : 1237;
        n10 = (n10 ^ n12) * n11;
        n12 = this.app.hashCode();
        n10 = (n10 ^ n12) * n11;
        object = this.user;
        if (object == null) {
            n12 = 0;
            object = null;
        } else {
            n12 = object.hashCode();
        }
        n10 = (n10 ^ n12) * n11;
        object = this.os;
        if (object == null) {
            n12 = 0;
            object = null;
        } else {
            n12 = object.hashCode();
        }
        n10 = (n10 ^ n12) * n11;
        object = this.device;
        if (object == null) {
            n12 = 0;
            object = null;
        } else {
            n12 = object.hashCode();
        }
        n10 = (n10 ^ n12) * n11;
        object = this.events;
        if (object != null) {
            n14 = ((ImmutableList)object).hashCode();
        }
        n10 = (n10 ^ n14) * n11;
        n11 = this.generatorType;
        return n10 ^ n11;
    }

    public boolean isCrashed() {
        return this.crashed;
    }

    public CrashlyticsReport$Session$Builder toBuilder() {
        AutoValue_CrashlyticsReport_Session$Builder autoValue_CrashlyticsReport_Session$Builder = new AutoValue_CrashlyticsReport_Session$Builder(this, null);
        return autoValue_CrashlyticsReport_Session$Builder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Session{generator=");
        Object object = this.generator;
        stringBuilder.append((String)object);
        stringBuilder.append(", identifier=");
        object = this.identifier;
        stringBuilder.append((String)object);
        stringBuilder.append(", startedAt=");
        long l10 = this.startedAt;
        stringBuilder.append(l10);
        stringBuilder.append(", endedAt=");
        object = this.endedAt;
        stringBuilder.append(object);
        stringBuilder.append(", crashed=");
        int n10 = this.crashed;
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", app=");
        object = this.app;
        stringBuilder.append(object);
        stringBuilder.append(", user=");
        object = this.user;
        stringBuilder.append(object);
        stringBuilder.append(", os=");
        object = this.os;
        stringBuilder.append(object);
        stringBuilder.append(", device=");
        object = this.device;
        stringBuilder.append(object);
        stringBuilder.append(", events=");
        object = this.events;
        stringBuilder.append(object);
        stringBuilder.append(", generatorType=");
        n10 = this.generatorType;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


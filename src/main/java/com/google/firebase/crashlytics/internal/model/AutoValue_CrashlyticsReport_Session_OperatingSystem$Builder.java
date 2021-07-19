/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem$Builder;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_OperatingSystem$Builder
extends CrashlyticsReport$Session$OperatingSystem$Builder {
    private String buildVersion;
    private Boolean jailbroken;
    private Integer platform;
    private String version;

    public CrashlyticsReport$Session$OperatingSystem build() {
        boolean bl2;
        Object object = this.platform;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" platform");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.version) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" version");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.buildVersion) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" buildVersion");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.jailbroken) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" jailbroken");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            int n10 = this.platform;
            String string3 = this.version;
            String string4 = this.buildVersion;
            boolean bl3 = this.jailbroken;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_OperatingSystem(n10, string3, string4, bl3, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$OperatingSystem$Builder setBuildVersion(String string2) {
        Objects.requireNonNull(string2, "Null buildVersion");
        this.buildVersion = string2;
        return this;
    }

    public CrashlyticsReport$Session$OperatingSystem$Builder setJailbroken(boolean bl2) {
        Boolean bl3;
        this.jailbroken = bl3 = Boolean.valueOf(bl2);
        return this;
    }

    public CrashlyticsReport$Session$OperatingSystem$Builder setPlatform(int n10) {
        Integer n11;
        this.platform = n11 = Integer.valueOf(n10);
        return this;
    }

    public CrashlyticsReport$Session$OperatingSystem$Builder setVersion(String string2) {
        Objects.requireNonNull(string2, "Null version");
        this.version = string2;
        return this;
    }
}


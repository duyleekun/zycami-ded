/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Application$Builder
extends CrashlyticsReport$Session$Application$Builder {
    private String developmentPlatform;
    private String developmentPlatformVersion;
    private String displayVersion;
    private String identifier;
    private String installationUuid;
    private CrashlyticsReport$Session$Application$Organization organization;
    private String version;

    public AutoValue_CrashlyticsReport_Session_Application$Builder() {
    }

    private AutoValue_CrashlyticsReport_Session_Application$Builder(CrashlyticsReport$Session$Application object) {
        Object object2 = ((CrashlyticsReport$Session$Application)object).getIdentifier();
        this.identifier = object2;
        object2 = ((CrashlyticsReport$Session$Application)object).getVersion();
        this.version = object2;
        object2 = ((CrashlyticsReport$Session$Application)object).getDisplayVersion();
        this.displayVersion = object2;
        this.organization = object2 = ((CrashlyticsReport$Session$Application)object).getOrganization();
        this.installationUuid = object2 = ((CrashlyticsReport$Session$Application)object).getInstallationUuid();
        this.developmentPlatform = object2 = ((CrashlyticsReport$Session$Application)object).getDevelopmentPlatform();
        this.developmentPlatformVersion = object = ((CrashlyticsReport$Session$Application)object).getDevelopmentPlatformVersion();
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Application$Builder(CrashlyticsReport$Session$Application crashlyticsReport$Session$Application, AutoValue_CrashlyticsReport_Session_Application$1 autoValue_CrashlyticsReport_Session_Application$1) {
        this(crashlyticsReport$Session$Application);
    }

    public CrashlyticsReport$Session$Application build() {
        boolean bl2;
        Object object = this.identifier;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" identifier");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.version) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" version");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            String string3 = this.identifier;
            String string4 = this.version;
            String string5 = this.displayVersion;
            CrashlyticsReport$Session$Application$Organization crashlyticsReport$Session$Application$Organization = this.organization;
            String string6 = this.installationUuid;
            String string7 = this.developmentPlatform;
            String string8 = this.developmentPlatformVersion;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_Application(string3, string4, string5, crashlyticsReport$Session$Application$Organization, string6, string7, string8, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Application$Builder setDevelopmentPlatform(String string2) {
        this.developmentPlatform = string2;
        return this;
    }

    public CrashlyticsReport$Session$Application$Builder setDevelopmentPlatformVersion(String string2) {
        this.developmentPlatformVersion = string2;
        return this;
    }

    public CrashlyticsReport$Session$Application$Builder setDisplayVersion(String string2) {
        this.displayVersion = string2;
        return this;
    }

    public CrashlyticsReport$Session$Application$Builder setIdentifier(String string2) {
        Objects.requireNonNull(string2, "Null identifier");
        this.identifier = string2;
        return this;
    }

    public CrashlyticsReport$Session$Application$Builder setInstallationUuid(String string2) {
        this.installationUuid = string2;
        return this;
    }

    public CrashlyticsReport$Session$Application$Builder setOrganization(CrashlyticsReport$Session$Application$Organization crashlyticsReport$Session$Application$Organization) {
        this.organization = crashlyticsReport$Session$Application$Organization;
        return this;
    }

    public CrashlyticsReport$Session$Application$Builder setVersion(String string2) {
        Objects.requireNonNull(string2, "Null version");
        this.version = string2;
        return this;
    }
}


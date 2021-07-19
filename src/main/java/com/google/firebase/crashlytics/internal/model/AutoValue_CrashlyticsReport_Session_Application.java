/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application$1;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization;

public final class AutoValue_CrashlyticsReport_Session_Application
extends CrashlyticsReport$Session$Application {
    private final String developmentPlatform;
    private final String developmentPlatformVersion;
    private final String displayVersion;
    private final String identifier;
    private final String installationUuid;
    private final CrashlyticsReport$Session$Application$Organization organization;
    private final String version;

    private AutoValue_CrashlyticsReport_Session_Application(String string2, String string3, String string4, CrashlyticsReport$Session$Application$Organization crashlyticsReport$Session$Application$Organization, String string5, String string6, String string7) {
        this.identifier = string2;
        this.version = string3;
        this.displayVersion = string4;
        this.organization = crashlyticsReport$Session$Application$Organization;
        this.installationUuid = string5;
        this.developmentPlatform = string6;
        this.developmentPlatformVersion = string7;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Application(String string2, String string3, String string4, CrashlyticsReport$Session$Application$Organization crashlyticsReport$Session$Application$Organization, String string5, String string6, String string7, AutoValue_CrashlyticsReport_Session_Application$1 autoValue_CrashlyticsReport_Session_Application$1) {
        this(string2, string3, string4, crashlyticsReport$Session$Application$Organization, string5, string6, string7);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof CrashlyticsReport$Session$Application;
        if (bl3) {
            boolean bl4;
            Object object2 = this.identifier;
            Object object3 = ((CrashlyticsReport$Session$Application)(object = (CrashlyticsReport$Session$Application)object)).getIdentifier();
            bl3 = ((String)object2).equals(object3);
            if (!(bl3 && (bl3 = ((String)(object2 = this.version)).equals(object3 = ((CrashlyticsReport$Session$Application)object).getVersion())) && ((object2 = this.displayVersion) == null ? (object2 = ((CrashlyticsReport$Session$Application)object).getDisplayVersion()) == null : (bl3 = ((String)object2).equals(object3 = ((CrashlyticsReport$Session$Application)object).getDisplayVersion()))) && ((object2 = this.organization) == null ? (object2 = ((CrashlyticsReport$Session$Application)object).getOrganization()) == null : (bl3 = object2.equals(object3 = ((CrashlyticsReport$Session$Application)object).getOrganization()))) && ((object2 = this.installationUuid) == null ? (object2 = ((CrashlyticsReport$Session$Application)object).getInstallationUuid()) == null : (bl3 = ((String)object2).equals(object3 = ((CrashlyticsReport$Session$Application)object).getInstallationUuid()))) && ((object2 = this.developmentPlatform) == null ? (object2 = ((CrashlyticsReport$Session$Application)object).getDevelopmentPlatform()) == null : (bl3 = ((String)object2).equals(object3 = ((CrashlyticsReport$Session$Application)object).getDevelopmentPlatform()))) && ((object2 = this.developmentPlatformVersion) == null ? (object = ((CrashlyticsReport$Session$Application)object).getDevelopmentPlatformVersion()) == null : (bl4 = ((String)object2).equals(object = ((CrashlyticsReport$Session$Application)object).getDevelopmentPlatformVersion()))))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getDevelopmentPlatform() {
        return this.developmentPlatform;
    }

    public String getDevelopmentPlatformVersion() {
        return this.developmentPlatformVersion;
    }

    public String getDisplayVersion() {
        return this.displayVersion;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getInstallationUuid() {
        return this.installationUuid;
    }

    public CrashlyticsReport$Session$Application$Organization getOrganization() {
        return this.organization;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String string2 = this.identifier;
        int n10 = string2.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.version.hashCode();
        n10 = (n10 ^ n12) * n11;
        Object object = this.displayVersion;
        int n13 = 0;
        if (object == null) {
            n12 = 0;
            object = null;
        } else {
            n12 = ((String)object).hashCode();
        }
        n10 = (n10 ^ n12) * n11;
        object = this.organization;
        if (object == null) {
            n12 = 0;
            object = null;
        } else {
            n12 = object.hashCode();
        }
        n10 = (n10 ^ n12) * n11;
        object = this.installationUuid;
        if (object == null) {
            n12 = 0;
            object = null;
        } else {
            n12 = ((String)object).hashCode();
        }
        n10 = (n10 ^ n12) * n11;
        object = this.developmentPlatform;
        if (object == null) {
            n12 = 0;
            object = null;
        } else {
            n12 = ((String)object).hashCode();
        }
        n10 = (n10 ^ n12) * n11;
        String string3 = this.developmentPlatformVersion;
        if (string3 != null) {
            n13 = string3.hashCode();
        }
        return n10 ^ n13;
    }

    public CrashlyticsReport$Session$Application$Builder toBuilder() {
        AutoValue_CrashlyticsReport_Session_Application$Builder autoValue_CrashlyticsReport_Session_Application$Builder = new AutoValue_CrashlyticsReport_Session_Application$Builder(this, null);
        return autoValue_CrashlyticsReport_Session_Application$Builder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Application{identifier=");
        Object object = this.identifier;
        stringBuilder.append((String)object);
        stringBuilder.append(", version=");
        object = this.version;
        stringBuilder.append((String)object);
        stringBuilder.append(", displayVersion=");
        object = this.displayVersion;
        stringBuilder.append((String)object);
        stringBuilder.append(", organization=");
        object = this.organization;
        stringBuilder.append(object);
        stringBuilder.append(", installationUuid=");
        object = this.installationUuid;
        stringBuilder.append((String)object);
        stringBuilder.append(", developmentPlatform=");
        object = this.developmentPlatform;
        stringBuilder.append((String)object);
        stringBuilder.append(", developmentPlatformVersion=");
        object = this.developmentPlatformVersion;
        stringBuilder.append((String)object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


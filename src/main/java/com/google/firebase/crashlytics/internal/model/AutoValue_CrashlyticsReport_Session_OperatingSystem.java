/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem;

public final class AutoValue_CrashlyticsReport_Session_OperatingSystem
extends CrashlyticsReport$Session$OperatingSystem {
    private final String buildVersion;
    private final boolean jailbroken;
    private final int platform;
    private final String version;

    private AutoValue_CrashlyticsReport_Session_OperatingSystem(int n10, String string2, String string3, boolean bl2) {
        this.platform = n10;
        this.version = string2;
        this.buildVersion = string3;
        this.jailbroken = bl2;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_OperatingSystem(int n10, String string2, String string3, boolean bl2, AutoValue_CrashlyticsReport_Session_OperatingSystem$1 autoValue_CrashlyticsReport_Session_OperatingSystem$1) {
        this(n10, string2, string3, bl2);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof CrashlyticsReport$Session$OperatingSystem;
        if (n10 != 0) {
            int n11;
            String string2;
            String string3;
            n10 = this.platform;
            int n12 = ((CrashlyticsReport$Session$OperatingSystem)(object = (CrashlyticsReport$Session$OperatingSystem)object)).getPlatform();
            if (n10 != n12 || (n10 = (int)((string3 = this.version).equals(string2 = ((CrashlyticsReport$Session$OperatingSystem)object).getVersion()) ? 1 : 0)) == 0 || (n10 = (int)((string3 = this.buildVersion).equals(string2 = ((CrashlyticsReport$Session$OperatingSystem)object).getBuildVersion()) ? 1 : 0)) == 0 || (n10 = (int)(this.jailbroken ? 1 : 0)) != (n11 = ((CrashlyticsReport$Session$OperatingSystem)object).isJailbroken())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getBuildVersion() {
        return this.buildVersion;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int n10 = this.platform;
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.version.hashCode();
        n10 = (n10 ^ n12) * n11;
        String string2 = this.buildVersion;
        n12 = string2.hashCode();
        n10 = (n10 ^ n12) * n11;
        n11 = (int)(this.jailbroken ? 1 : 0);
        n11 = n11 != 0 ? 1231 : 1237;
        return n10 ^ n11;
    }

    public boolean isJailbroken() {
        return this.jailbroken;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OperatingSystem{platform=");
        int bl2 = this.platform;
        stringBuilder.append(bl2);
        stringBuilder.append(", version=");
        String string2 = this.version;
        stringBuilder.append(string2);
        stringBuilder.append(", buildVersion=");
        string2 = this.buildVersion;
        stringBuilder.append(string2);
        stringBuilder.append(", jailbroken=");
        boolean bl3 = this.jailbroken;
        stringBuilder.append(bl3);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


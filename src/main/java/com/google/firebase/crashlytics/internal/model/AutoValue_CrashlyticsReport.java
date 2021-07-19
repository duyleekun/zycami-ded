/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport$1;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;

public final class AutoValue_CrashlyticsReport
extends CrashlyticsReport {
    private final String buildVersion;
    private final String displayVersion;
    private final String gmpAppId;
    private final String installationUuid;
    private final CrashlyticsReport$FilesPayload ndkPayload;
    private final int platform;
    private final String sdkVersion;
    private final CrashlyticsReport$Session session;

    private AutoValue_CrashlyticsReport(String string2, String string3, int n10, String string4, String string5, String string6, CrashlyticsReport$Session crashlyticsReport$Session, CrashlyticsReport$FilesPayload crashlyticsReport$FilesPayload) {
        this.sdkVersion = string2;
        this.gmpAppId = string3;
        this.platform = n10;
        this.installationUuid = string4;
        this.buildVersion = string5;
        this.displayVersion = string6;
        this.session = crashlyticsReport$Session;
        this.ndkPayload = crashlyticsReport$FilesPayload;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport(String string2, String string3, int n10, String string4, String string5, String string6, CrashlyticsReport$Session crashlyticsReport$Session, CrashlyticsReport$FilesPayload crashlyticsReport$FilesPayload, AutoValue_CrashlyticsReport$1 autoValue_CrashlyticsReport$1) {
        this(string2, string3, n10, string4, string5, string6, crashlyticsReport$Session, crashlyticsReport$FilesPayload);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean n10 = object instanceof CrashlyticsReport;
        if (n10) {
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            int n11;
            int n12;
            boolean bl8;
            Object object2 = this.sdkVersion;
            Object object3 = ((CrashlyticsReport)(object = (CrashlyticsReport)object)).getSdkVersion();
            boolean bl9 = ((String)object2).equals(object3);
            if (!(bl9 && (bl8 = ((String)(object2 = this.gmpAppId)).equals(object3 = ((CrashlyticsReport)object).getGmpAppId())) && (n12 = this.platform) == (n11 = ((CrashlyticsReport)object).getPlatform()) && (bl7 = ((String)(object2 = this.installationUuid)).equals(object3 = ((CrashlyticsReport)object).getInstallationUuid())) && (bl6 = ((String)(object2 = this.buildVersion)).equals(object3 = ((CrashlyticsReport)object).getBuildVersion())) && (bl5 = ((String)(object2 = this.displayVersion)).equals(object3 = ((CrashlyticsReport)object).getDisplayVersion())) && ((object2 = this.session) == null ? (object2 = ((CrashlyticsReport)object).getSession()) == null : (bl4 = object2.equals(object3 = ((CrashlyticsReport)object).getSession()))) && ((object2 = this.ndkPayload) == null ? (object = ((CrashlyticsReport)object).getNdkPayload()) == null : (bl3 = object2.equals(object = ((CrashlyticsReport)object).getNdkPayload()))))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getBuildVersion() {
        return this.buildVersion;
    }

    public String getDisplayVersion() {
        return this.displayVersion;
    }

    public String getGmpAppId() {
        return this.gmpAppId;
    }

    public String getInstallationUuid() {
        return this.installationUuid;
    }

    public CrashlyticsReport$FilesPayload getNdkPayload() {
        return this.ndkPayload;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public CrashlyticsReport$Session getSession() {
        return this.session;
    }

    public int hashCode() {
        String string2 = this.sdkVersion;
        int n10 = string2.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.gmpAppId.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.platform;
        n10 = (n10 ^ n12) * n11;
        n12 = this.installationUuid.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.buildVersion.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.displayVersion.hashCode();
        n10 = (n10 ^ n12) * n11;
        CrashlyticsReport$Session crashlyticsReport$Session = this.session;
        int n13 = 0;
        if (crashlyticsReport$Session == null) {
            n12 = 0;
            crashlyticsReport$Session = null;
        } else {
            n12 = crashlyticsReport$Session.hashCode();
        }
        n10 = (n10 ^ n12) * n11;
        CrashlyticsReport$FilesPayload crashlyticsReport$FilesPayload = this.ndkPayload;
        if (crashlyticsReport$FilesPayload != null) {
            n13 = crashlyticsReport$FilesPayload.hashCode();
        }
        return n10 ^ n13;
    }

    public CrashlyticsReport$Builder toBuilder() {
        AutoValue_CrashlyticsReport$Builder autoValue_CrashlyticsReport$Builder = new AutoValue_CrashlyticsReport$Builder(this, null);
        return autoValue_CrashlyticsReport$Builder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CrashlyticsReport{sdkVersion=");
        Object object = this.sdkVersion;
        stringBuilder.append((String)object);
        stringBuilder.append(", gmpAppId=");
        object = this.gmpAppId;
        stringBuilder.append((String)object);
        stringBuilder.append(", platform=");
        int n10 = this.platform;
        stringBuilder.append(n10);
        stringBuilder.append(", installationUuid=");
        object = this.installationUuid;
        stringBuilder.append((String)object);
        stringBuilder.append(", buildVersion=");
        object = this.buildVersion;
        stringBuilder.append((String)object);
        stringBuilder.append(", displayVersion=");
        object = this.displayVersion;
        stringBuilder.append((String)object);
        stringBuilder.append(", session=");
        object = this.session;
        stringBuilder.append(object);
        stringBuilder.append(", ndkPayload=");
        object = this.ndkPayload;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


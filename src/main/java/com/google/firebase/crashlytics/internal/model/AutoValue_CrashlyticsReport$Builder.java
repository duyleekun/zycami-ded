/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport$Builder
extends CrashlyticsReport$Builder {
    private String buildVersion;
    private String displayVersion;
    private String gmpAppId;
    private String installationUuid;
    private CrashlyticsReport$FilesPayload ndkPayload;
    private Integer platform;
    private String sdkVersion;
    private CrashlyticsReport$Session session;

    public AutoValue_CrashlyticsReport$Builder() {
    }

    private AutoValue_CrashlyticsReport$Builder(CrashlyticsReport object) {
        Object object2 = ((CrashlyticsReport)object).getSdkVersion();
        this.sdkVersion = object2;
        object2 = ((CrashlyticsReport)object).getGmpAppId();
        this.gmpAppId = object2;
        this.platform = object2 = Integer.valueOf(((CrashlyticsReport)object).getPlatform());
        this.installationUuid = object2 = ((CrashlyticsReport)object).getInstallationUuid();
        this.buildVersion = object2 = ((CrashlyticsReport)object).getBuildVersion();
        this.displayVersion = object2 = ((CrashlyticsReport)object).getDisplayVersion();
        this.session = object2 = ((CrashlyticsReport)object).getSession();
        this.ndkPayload = object = ((CrashlyticsReport)object).getNdkPayload();
    }

    public /* synthetic */ AutoValue_CrashlyticsReport$Builder(CrashlyticsReport crashlyticsReport, AutoValue_CrashlyticsReport$1 autoValue_CrashlyticsReport$1) {
        this(crashlyticsReport);
    }

    public CrashlyticsReport build() {
        boolean bl2;
        Object object = this.sdkVersion;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" sdkVersion");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.gmpAppId) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" gmpAppId");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.platform) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" platform");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.installationUuid) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" installationUuid");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.buildVersion) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" buildVersion");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.displayVersion) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" displayVersion");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            String string3 = this.sdkVersion;
            String string4 = this.gmpAppId;
            int n10 = this.platform;
            String string5 = this.installationUuid;
            String string6 = this.buildVersion;
            String string7 = this.displayVersion;
            CrashlyticsReport$Session crashlyticsReport$Session = this.session;
            CrashlyticsReport$FilesPayload crashlyticsReport$FilesPayload = this.ndkPayload;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport(string3, string4, n10, string5, string6, string7, crashlyticsReport$Session, crashlyticsReport$FilesPayload, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Builder setBuildVersion(String string2) {
        Objects.requireNonNull(string2, "Null buildVersion");
        this.buildVersion = string2;
        return this;
    }

    public CrashlyticsReport$Builder setDisplayVersion(String string2) {
        Objects.requireNonNull(string2, "Null displayVersion");
        this.displayVersion = string2;
        return this;
    }

    public CrashlyticsReport$Builder setGmpAppId(String string2) {
        Objects.requireNonNull(string2, "Null gmpAppId");
        this.gmpAppId = string2;
        return this;
    }

    public CrashlyticsReport$Builder setInstallationUuid(String string2) {
        Objects.requireNonNull(string2, "Null installationUuid");
        this.installationUuid = string2;
        return this;
    }

    public CrashlyticsReport$Builder setNdkPayload(CrashlyticsReport$FilesPayload crashlyticsReport$FilesPayload) {
        this.ndkPayload = crashlyticsReport$FilesPayload;
        return this;
    }

    public CrashlyticsReport$Builder setPlatform(int n10) {
        Integer n11;
        this.platform = n11 = Integer.valueOf(n10);
        return this;
    }

    public CrashlyticsReport$Builder setSdkVersion(String string2) {
        Objects.requireNonNull(string2, "Null sdkVersion");
        this.sdkVersion = string2;
        return this;
    }

    public CrashlyticsReport$Builder setSession(CrashlyticsReport$Session crashlyticsReport$Session) {
        this.session = crashlyticsReport$Session;
        return this;
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization$Builder;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Application_Organization$Builder
extends CrashlyticsReport$Session$Application$Organization$Builder {
    private String clsId;

    public AutoValue_CrashlyticsReport_Session_Application_Organization$Builder() {
    }

    private AutoValue_CrashlyticsReport_Session_Application_Organization$Builder(CrashlyticsReport$Session$Application$Organization object) {
        this.clsId = object = ((CrashlyticsReport$Session$Application$Organization)object).getClsId();
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Application_Organization$Builder(CrashlyticsReport$Session$Application$Organization crashlyticsReport$Session$Application$Organization, AutoValue_CrashlyticsReport_Session_Application_Organization$1 autoValue_CrashlyticsReport_Session_Application_Organization$1) {
        this(crashlyticsReport$Session$Application$Organization);
    }

    public CrashlyticsReport$Session$Application$Organization build() {
        boolean bl2;
        Object object = this.clsId;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" clsId");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            string2 = this.clsId;
            object = new AutoValue_CrashlyticsReport_Session_Application_Organization(string2, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Application$Organization$Builder setClsId(String string2) {
        Objects.requireNonNull(string2, "Null clsId");
        this.clsId = string2;
        return this;
    }
}


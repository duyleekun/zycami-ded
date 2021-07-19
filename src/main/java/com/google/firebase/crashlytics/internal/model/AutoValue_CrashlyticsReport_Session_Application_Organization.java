/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization$1;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization$Builder;

public final class AutoValue_CrashlyticsReport_Session_Application_Organization
extends CrashlyticsReport$Session$Application$Organization {
    private final String clsId;

    private AutoValue_CrashlyticsReport_Session_Application_Organization(String string2) {
        this.clsId = string2;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Application_Organization(String string2, AutoValue_CrashlyticsReport_Session_Application_Organization$1 autoValue_CrashlyticsReport_Session_Application_Organization$1) {
        this(string2);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof CrashlyticsReport$Session$Application$Organization;
        if (bl2) {
            object = (CrashlyticsReport$Session$Application$Organization)object;
            String string2 = this.clsId;
            object = ((CrashlyticsReport$Session$Application$Organization)object).getClsId();
            return string2.equals(object);
        }
        return false;
    }

    public String getClsId() {
        return this.clsId;
    }

    public int hashCode() {
        return this.clsId.hashCode() ^ 0xF4243;
    }

    public CrashlyticsReport$Session$Application$Organization$Builder toBuilder() {
        AutoValue_CrashlyticsReport_Session_Application_Organization$Builder autoValue_CrashlyticsReport_Session_Application_Organization$Builder = new AutoValue_CrashlyticsReport_Session_Application_Organization$Builder(this, null);
        return autoValue_CrashlyticsReport_Session_Application_Organization$Builder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Organization{clsId=");
        String string2 = this.clsId;
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


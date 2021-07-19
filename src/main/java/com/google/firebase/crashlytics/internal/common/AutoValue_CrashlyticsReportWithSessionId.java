/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

public final class AutoValue_CrashlyticsReportWithSessionId
extends CrashlyticsReportWithSessionId {
    private final CrashlyticsReport report;
    private final String sessionId;

    public AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String string2) {
        Objects.requireNonNull(crashlyticsReport, "Null report");
        this.report = crashlyticsReport;
        Objects.requireNonNull(string2, "Null sessionId");
        this.sessionId = string2;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof CrashlyticsReportWithSessionId;
        if (bl3) {
            boolean bl4;
            Object object2 = this.report;
            CrashlyticsReport crashlyticsReport = ((CrashlyticsReportWithSessionId)(object = (CrashlyticsReportWithSessionId)object)).getReport();
            bl3 = object2.equals(crashlyticsReport);
            if (!bl3 || !(bl4 = ((String)(object2 = this.sessionId)).equals(object = ((CrashlyticsReportWithSessionId)object).getSessionId()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public CrashlyticsReport getReport() {
        return this.report;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        int n10 = this.report.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = this.sessionId.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CrashlyticsReportWithSessionId{report=");
        Object object = this.report;
        stringBuilder.append(object);
        stringBuilder.append(", sessionId=");
        object = this.sessionId;
        stringBuilder.append((String)object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


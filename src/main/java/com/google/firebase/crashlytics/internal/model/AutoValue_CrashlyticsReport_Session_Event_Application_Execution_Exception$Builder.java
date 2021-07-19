/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception$Builder
extends CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder {
    private CrashlyticsReport$Session$Event$Application$Execution$Exception causedBy;
    private ImmutableList frames;
    private Integer overflowCount;
    private String reason;
    private String type;

    public CrashlyticsReport$Session$Event$Application$Execution$Exception build() {
        boolean bl2;
        Object object = this.type;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" type");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.frames) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" frames");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.overflowCount) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" overflowCount");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            String string3 = this.type;
            String string4 = this.reason;
            ImmutableList immutableList = this.frames;
            CrashlyticsReport$Session$Event$Application$Execution$Exception crashlyticsReport$Session$Event$Application$Execution$Exception = this.causedBy;
            int n10 = this.overflowCount;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(string3, string4, immutableList, crashlyticsReport$Session$Event$Application$Execution$Exception, n10, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder setCausedBy(CrashlyticsReport$Session$Event$Application$Execution$Exception crashlyticsReport$Session$Event$Application$Execution$Exception) {
        this.causedBy = crashlyticsReport$Session$Event$Application$Execution$Exception;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder setFrames(ImmutableList immutableList) {
        Objects.requireNonNull(immutableList, "Null frames");
        this.frames = immutableList;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder setOverflowCount(int n10) {
        Integer n11;
        this.overflowCount = n11 = Integer.valueOf(n10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder setReason(String string2) {
        this.reason = string2;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder setType(String string2) {
        Objects.requireNonNull(string2, "Null type");
        this.type = string2;
        return this;
    }
}


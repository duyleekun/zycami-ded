/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$Builder
extends CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder {
    private Long address;
    private String code;
    private String name;

    public CrashlyticsReport$Session$Event$Application$Execution$Signal build() {
        boolean bl2;
        Object object = this.name;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" name");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.code) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" code");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.address) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" address");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            String string3 = this.name;
            String string4 = this.code;
            long l10 = this.address;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(string3, string4, l10, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder setAddress(long l10) {
        Long l11;
        this.address = l11 = Long.valueOf(l10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder setCode(String string2) {
        Objects.requireNonNull(string2, "Null code");
        this.code = string2;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder setName(String string2) {
        Objects.requireNonNull(string2, "Null name");
        this.name = string2;
        return this;
    }
}


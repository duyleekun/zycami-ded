/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$Builder
extends CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder {
    private ImmutableList frames;
    private Integer importance;
    private String name;

    public CrashlyticsReport$Session$Event$Application$Execution$Thread build() {
        boolean bl2;
        Object object = this.name;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" name");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.importance) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" importance");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.frames) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" frames");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            string2 = this.name;
            int n10 = this.importance;
            ImmutableList immutableList = this.frames;
            object = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(string2, n10, immutableList, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder setFrames(ImmutableList immutableList) {
        Objects.requireNonNull(immutableList, "Null frames");
        this.frames = immutableList;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder setImportance(int n10) {
        Integer n11;
        this.importance = n11 = Integer.valueOf(n10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder setName(String string2) {
        Objects.requireNonNull(string2, "Null name");
        this.name = string2;
        return this;
    }
}


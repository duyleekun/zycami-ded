/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event_Application$Builder
extends CrashlyticsReport$Session$Event$Application$Builder {
    private Boolean background;
    private ImmutableList customAttributes;
    private CrashlyticsReport$Session$Event$Application$Execution execution;
    private Integer uiOrientation;

    public AutoValue_CrashlyticsReport_Session_Event_Application$Builder() {
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application$Builder(CrashlyticsReport$Session$Event$Application object) {
        Object object2 = ((CrashlyticsReport$Session$Event$Application)object).getExecution();
        this.execution = object2;
        this.customAttributes = object2 = ((CrashlyticsReport$Session$Event$Application)object).getCustomAttributes();
        this.background = object2 = ((CrashlyticsReport$Session$Event$Application)object).getBackground();
        this.uiOrientation = object = Integer.valueOf(((CrashlyticsReport$Session$Event$Application)object).getUiOrientation());
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event_Application$Builder(CrashlyticsReport$Session$Event$Application crashlyticsReport$Session$Event$Application, AutoValue_CrashlyticsReport_Session_Event_Application$1 autoValue_CrashlyticsReport_Session_Event_Application$1) {
        this(crashlyticsReport$Session$Event$Application);
    }

    public CrashlyticsReport$Session$Event$Application build() {
        boolean bl2;
        Object object = this.execution;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" execution");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.uiOrientation) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" uiOrientation");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            CrashlyticsReport$Session$Event$Application$Execution crashlyticsReport$Session$Event$Application$Execution = this.execution;
            ImmutableList immutableList = this.customAttributes;
            Boolean bl3 = this.background;
            int n10 = this.uiOrientation;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_Event_Application(crashlyticsReport$Session$Event$Application$Execution, immutableList, bl3, n10, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Event$Application$Builder setBackground(Boolean bl2) {
        this.background = bl2;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Builder setCustomAttributes(ImmutableList immutableList) {
        this.customAttributes = immutableList;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Builder setExecution(CrashlyticsReport$Session$Event$Application$Execution crashlyticsReport$Session$Event$Application$Execution) {
        Objects.requireNonNull(crashlyticsReport$Session$Event$Application$Execution, "Null execution");
        this.execution = crashlyticsReport$Session$Event$Application$Execution;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Builder setUiOrientation(int n10) {
        Integer n11;
        this.uiOrientation = n11 = Integer.valueOf(n10);
        return this;
    }
}


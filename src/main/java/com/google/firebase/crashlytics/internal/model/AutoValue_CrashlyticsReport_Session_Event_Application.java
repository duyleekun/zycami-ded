/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application$1;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public final class AutoValue_CrashlyticsReport_Session_Event_Application
extends CrashlyticsReport$Session$Event$Application {
    private final Boolean background;
    private final ImmutableList customAttributes;
    private final CrashlyticsReport$Session$Event$Application$Execution execution;
    private final int uiOrientation;

    private AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport$Session$Event$Application$Execution crashlyticsReport$Session$Event$Application$Execution, ImmutableList immutableList, Boolean bl2, int n10) {
        this.execution = crashlyticsReport$Session$Event$Application$Execution;
        this.customAttributes = immutableList;
        this.background = bl2;
        this.uiOrientation = n10;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport$Session$Event$Application$Execution crashlyticsReport$Session$Event$Application$Execution, ImmutableList immutableList, Boolean bl2, int n10, AutoValue_CrashlyticsReport_Session_Event_Application$1 autoValue_CrashlyticsReport_Session_Event_Application$1) {
        this(crashlyticsReport$Session$Event$Application$Execution, immutableList, bl2, n10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof CrashlyticsReport$Session$Event$Application;
        if (n10 != 0) {
            int n11;
            Object object2 = this.execution;
            Object object3 = ((CrashlyticsReport$Session$Event$Application)(object = (CrashlyticsReport$Session$Event$Application)object)).getExecution();
            n10 = object2.equals(object3);
            if (n10 == 0 || !((object2 = this.customAttributes) == null ? (object2 = ((CrashlyticsReport$Session$Event$Application)object).getCustomAttributes()) == null : (n10 = ((ImmutableList)object2).equals(object3 = ((CrashlyticsReport$Session$Event$Application)object).getCustomAttributes())) != 0) || !((object2 = this.background) == null ? (object2 = ((CrashlyticsReport$Session$Event$Application)object).getBackground()) == null : (n10 = ((Boolean)object2).equals(object3 = ((CrashlyticsReport$Session$Event$Application)object).getBackground())) != 0) || (n10 = this.uiOrientation) != (n11 = ((CrashlyticsReport$Session$Event$Application)object).getUiOrientation())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Boolean getBackground() {
        return this.background;
    }

    public ImmutableList getCustomAttributes() {
        return this.customAttributes;
    }

    public CrashlyticsReport$Session$Event$Application$Execution getExecution() {
        return this.execution;
    }

    public int getUiOrientation() {
        return this.uiOrientation;
    }

    public int hashCode() {
        int n10;
        CrashlyticsReport$Session$Event$Application$Execution crashlyticsReport$Session$Event$Application$Execution = this.execution;
        int n11 = crashlyticsReport$Session$Event$Application$Execution.hashCode();
        int n12 = 1000003;
        n11 = (n11 ^ n12) * n12;
        Object object = this.customAttributes;
        int n13 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((ImmutableList)object).hashCode();
        }
        n11 = (n11 ^ n10) * n12;
        object = this.background;
        if (object != null) {
            n13 = ((Boolean)object).hashCode();
        }
        n11 = (n11 ^ n13) * n12;
        n12 = this.uiOrientation;
        return n11 ^ n12;
    }

    public CrashlyticsReport$Session$Event$Application$Builder toBuilder() {
        AutoValue_CrashlyticsReport_Session_Event_Application$Builder autoValue_CrashlyticsReport_Session_Event_Application$Builder = new AutoValue_CrashlyticsReport_Session_Event_Application$Builder(this, null);
        return autoValue_CrashlyticsReport_Session_Event_Application$Builder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Application{execution=");
        Object object = this.execution;
        stringBuilder.append(object);
        stringBuilder.append(", customAttributes=");
        object = this.customAttributes;
        stringBuilder.append(object);
        stringBuilder.append(", background=");
        object = this.background;
        stringBuilder.append(object);
        stringBuilder.append(", uiOrientation=");
        int n10 = this.uiOrientation;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


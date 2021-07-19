/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log$Builder;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event_Log$Builder
extends CrashlyticsReport$Session$Event$Log$Builder {
    private String content;

    public CrashlyticsReport$Session$Event$Log build() {
        boolean bl2;
        Object object = this.content;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" content");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            string2 = this.content;
            object = new AutoValue_CrashlyticsReport_Session_Event_Log(string2, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Event$Log$Builder setContent(String string2) {
        Objects.requireNonNull(string2, "Null content");
        this.content = string2;
        return this;
    }
}


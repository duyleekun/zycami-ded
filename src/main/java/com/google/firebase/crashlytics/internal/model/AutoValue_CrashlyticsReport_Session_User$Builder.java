/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User$Builder;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_User$Builder
extends CrashlyticsReport$Session$User$Builder {
    private String identifier;

    public CrashlyticsReport$Session$User build() {
        boolean bl2;
        Object object = this.identifier;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" identifier");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            string2 = this.identifier;
            object = new AutoValue_CrashlyticsReport_Session_User(string2, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$User$Builder setIdentifier(String string2) {
        Objects.requireNonNull(string2, "Null identifier");
        this.identifier = string2;
        return this;
    }
}


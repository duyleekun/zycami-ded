/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute$Builder;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_CustomAttribute$Builder
extends CrashlyticsReport$CustomAttribute$Builder {
    private String key;
    private String value;

    public CrashlyticsReport$CustomAttribute build() {
        boolean bl2;
        Object object = this.key;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" key");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.value) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" value");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            string2 = this.key;
            String string3 = this.value;
            object = new AutoValue_CrashlyticsReport_CustomAttribute(string2, string3, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$CustomAttribute$Builder setKey(String string2) {
        Objects.requireNonNull(string2, "Null key");
        this.key = string2;
        return this;
    }

    public CrashlyticsReport$CustomAttribute$Builder setValue(String string2) {
        Objects.requireNonNull(string2, "Null value");
        this.value = string2;
        return this;
    }
}


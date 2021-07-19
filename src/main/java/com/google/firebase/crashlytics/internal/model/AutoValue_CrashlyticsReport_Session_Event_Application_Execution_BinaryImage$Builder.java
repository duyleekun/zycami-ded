/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$Builder
extends CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder {
    private Long baseAddress;
    private String name;
    private Long size;
    private String uuid;

    public CrashlyticsReport$Session$Event$Application$Execution$BinaryImage build() {
        boolean bl2;
        Object object = this.baseAddress;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" baseAddress");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.size) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" size");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.name) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" name");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            long l10 = this.baseAddress;
            long l11 = this.size;
            String string3 = this.name;
            String string4 = this.uuid;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(l10, l11, string3, string4, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder setBaseAddress(long l10) {
        Long l11;
        this.baseAddress = l11 = Long.valueOf(l10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder setName(String string2) {
        Objects.requireNonNull(string2, "Null name");
        this.name = string2;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder setSize(long l10) {
        Long l11;
        this.size = l11 = Long.valueOf(l10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder setUuid(String string2) {
        this.uuid = string2;
        return this;
    }
}


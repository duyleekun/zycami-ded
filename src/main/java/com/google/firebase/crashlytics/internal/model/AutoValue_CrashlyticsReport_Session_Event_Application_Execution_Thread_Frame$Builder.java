/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$Builder
extends CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder {
    private String file;
    private Integer importance;
    private Long offset;
    private Long pc;
    private String symbol;

    public CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame build() {
        boolean bl2;
        Object object = this.pc;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" pc");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.symbol) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" symbol");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.offset) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" offset");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.importance) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" importance");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            long l10 = this.pc;
            String string3 = this.symbol;
            String string4 = this.file;
            long l11 = this.offset;
            int n10 = this.importance;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(l10, string3, string4, l11, n10, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder setFile(String string2) {
        this.file = string2;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder setImportance(int n10) {
        Integer n11;
        this.importance = n11 = Integer.valueOf(n10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder setOffset(long l10) {
        Long l11;
        this.offset = l11 = Long.valueOf(l10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder setPc(long l10) {
        Long l11;
        this.pc = l11 = Long.valueOf(l10);
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder setSymbol(String string2) {
        Objects.requireNonNull(string2, "Null symbol");
        this.symbol = string2;
        return this;
    }
}


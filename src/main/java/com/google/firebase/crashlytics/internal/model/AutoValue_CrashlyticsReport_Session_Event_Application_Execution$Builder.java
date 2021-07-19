/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Objects;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution$Builder
extends CrashlyticsReport$Session$Event$Application$Execution$Builder {
    private ImmutableList binaries;
    private CrashlyticsReport$Session$Event$Application$Execution$Exception exception;
    private CrashlyticsReport$Session$Event$Application$Execution$Signal signal;
    private ImmutableList threads;

    public CrashlyticsReport$Session$Event$Application$Execution build() {
        boolean bl2;
        Object object = this.threads;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" threads");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.exception) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" exception");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.signal) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" signal");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.binaries) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" binaries");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            ImmutableList immutableList = this.threads;
            CrashlyticsReport$Session$Event$Application$Execution$Exception crashlyticsReport$Session$Event$Application$Execution$Exception = this.exception;
            CrashlyticsReport$Session$Event$Application$Execution$Signal crashlyticsReport$Session$Event$Application$Execution$Signal = this.signal;
            ImmutableList immutableList2 = this.binaries;
            Object object2 = object;
            object = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(immutableList, crashlyticsReport$Session$Event$Application$Execution$Exception, crashlyticsReport$Session$Event$Application$Execution$Signal, immutableList2, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Builder setBinaries(ImmutableList immutableList) {
        Objects.requireNonNull(immutableList, "Null binaries");
        this.binaries = immutableList;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Builder setException(CrashlyticsReport$Session$Event$Application$Execution$Exception crashlyticsReport$Session$Event$Application$Execution$Exception) {
        Objects.requireNonNull(crashlyticsReport$Session$Event$Application$Execution$Exception, "Null exception");
        this.exception = crashlyticsReport$Session$Event$Application$Execution$Exception;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Builder setSignal(CrashlyticsReport$Session$Event$Application$Execution$Signal crashlyticsReport$Session$Event$Application$Execution$Signal) {
        Objects.requireNonNull(crashlyticsReport$Session$Event$Application$Execution$Signal, "Null signal");
        this.signal = crashlyticsReport$Session$Event$Application$Execution$Signal;
        return this;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Builder setThreads(ImmutableList immutableList) {
        Objects.requireNonNull(immutableList, "Null threads");
        this.threads = immutableList;
        return this;
    }
}


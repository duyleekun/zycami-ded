/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution
extends CrashlyticsReport$Session$Event$Application$Execution {
    private final ImmutableList binaries;
    private final CrashlyticsReport$Session$Event$Application$Execution$Exception exception;
    private final CrashlyticsReport$Session$Event$Application$Execution$Signal signal;
    private final ImmutableList threads;

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution(ImmutableList immutableList, CrashlyticsReport$Session$Event$Application$Execution$Exception crashlyticsReport$Session$Event$Application$Execution$Exception, CrashlyticsReport$Session$Event$Application$Execution$Signal crashlyticsReport$Session$Event$Application$Execution$Signal, ImmutableList immutableList2) {
        this.threads = immutableList;
        this.exception = crashlyticsReport$Session$Event$Application$Execution$Exception;
        this.signal = crashlyticsReport$Session$Event$Application$Execution$Signal;
        this.binaries = immutableList2;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event_Application_Execution(ImmutableList immutableList, CrashlyticsReport$Session$Event$Application$Execution$Exception crashlyticsReport$Session$Event$Application$Execution$Exception, CrashlyticsReport$Session$Event$Application$Execution$Signal crashlyticsReport$Session$Event$Application$Execution$Signal, ImmutableList immutableList2, AutoValue_CrashlyticsReport_Session_Event_Application_Execution$1 autoValue_CrashlyticsReport_Session_Event_Application_Execution$1) {
        this(immutableList, crashlyticsReport$Session$Event$Application$Execution$Exception, crashlyticsReport$Session$Event$Application$Execution$Signal, immutableList2);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof CrashlyticsReport$Session$Event$Application$Execution;
        if (bl3) {
            boolean bl4;
            Object object2 = this.threads;
            Object object3 = ((CrashlyticsReport$Session$Event$Application$Execution)(object = (CrashlyticsReport$Session$Event$Application$Execution)object)).getThreads();
            bl3 = ((ImmutableList)object2).equals(object3);
            if (!(bl3 && (bl3 = (object2 = this.exception).equals(object3 = ((CrashlyticsReport$Session$Event$Application$Execution)object).getException())) && (bl3 = (object2 = this.signal).equals(object3 = ((CrashlyticsReport$Session$Event$Application$Execution)object).getSignal())) && (bl4 = ((ImmutableList)(object2 = this.binaries)).equals(object = ((CrashlyticsReport$Session$Event$Application$Execution)object).getBinaries())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public ImmutableList getBinaries() {
        return this.binaries;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Exception getException() {
        return this.exception;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Signal getSignal() {
        return this.signal;
    }

    public ImmutableList getThreads() {
        return this.threads;
    }

    public int hashCode() {
        int n10 = this.threads.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.exception.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.signal.hashCode();
        n10 = (n10 ^ n12) * n11;
        n11 = this.binaries.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Execution{threads=");
        Object object = this.threads;
        stringBuilder.append(object);
        stringBuilder.append(", exception=");
        object = this.exception;
        stringBuilder.append(object);
        stringBuilder.append(", signal=");
        object = this.signal;
        stringBuilder.append(object);
        stringBuilder.append(", binaries=");
        object = this.binaries;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


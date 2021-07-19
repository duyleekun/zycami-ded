/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread
extends CrashlyticsReport$Session$Event$Application$Execution$Thread {
    private final ImmutableList frames;
    private final int importance;
    private final String name;

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String string2, int n10, ImmutableList immutableList) {
        this.name = string2;
        this.importance = n10;
        this.frames = immutableList;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String string2, int n10, ImmutableList immutableList, AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$1 autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$1) {
        this(string2, n10, immutableList);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean n10 = object instanceof CrashlyticsReport$Session$Event$Application$Execution$Thread;
        if (n10) {
            boolean bl3;
            int n11;
            int n12;
            Object object2 = this.name;
            String string2 = ((CrashlyticsReport$Session$Event$Application$Execution$Thread)(object = (CrashlyticsReport$Session$Event$Application$Execution$Thread)object)).getName();
            boolean bl4 = ((String)object2).equals(string2);
            if (!bl4 || (n12 = this.importance) != (n11 = ((CrashlyticsReport$Session$Event$Application$Execution$Thread)object).getImportance()) || !(bl3 = ((ImmutableList)(object2 = this.frames)).equals(object = ((CrashlyticsReport$Session$Event$Application$Execution$Thread)object).getFrames()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public ImmutableList getFrames() {
        return this.frames;
    }

    public int getImportance() {
        return this.importance;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int n10 = this.name.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.importance;
        n10 = (n10 ^ n12) * n11;
        n11 = this.frames.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thread{name=");
        Object object = this.name;
        stringBuilder.append((String)object);
        stringBuilder.append(", importance=");
        int n10 = this.importance;
        stringBuilder.append(n10);
        stringBuilder.append(", frames=");
        object = this.frames;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


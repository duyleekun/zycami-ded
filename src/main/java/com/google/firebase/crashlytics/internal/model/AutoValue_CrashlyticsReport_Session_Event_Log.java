/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log;

public final class AutoValue_CrashlyticsReport_Session_Event_Log
extends CrashlyticsReport$Session$Event$Log {
    private final String content;

    private AutoValue_CrashlyticsReport_Session_Event_Log(String string2) {
        this.content = string2;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event_Log(String string2, AutoValue_CrashlyticsReport_Session_Event_Log$1 autoValue_CrashlyticsReport_Session_Event_Log$1) {
        this(string2);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof CrashlyticsReport$Session$Event$Log;
        if (bl2) {
            object = (CrashlyticsReport$Session$Event$Log)object;
            String string2 = this.content;
            object = ((CrashlyticsReport$Session$Event$Log)object).getContent();
            return string2.equals(object);
        }
        return false;
    }

    public String getContent() {
        return this.content;
    }

    public int hashCode() {
        return this.content.hashCode() ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Log{content=");
        String string2 = this.content;
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


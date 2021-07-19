/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User;

public final class AutoValue_CrashlyticsReport_Session_User
extends CrashlyticsReport$Session$User {
    private final String identifier;

    private AutoValue_CrashlyticsReport_Session_User(String string2) {
        this.identifier = string2;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_User(String string2, AutoValue_CrashlyticsReport_Session_User$1 autoValue_CrashlyticsReport_Session_User$1) {
        this(string2);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof CrashlyticsReport$Session$User;
        if (bl2) {
            object = (CrashlyticsReport$Session$User)object;
            String string2 = this.identifier;
            object = ((CrashlyticsReport$Session$User)object).getIdentifier();
            return string2.equals(object);
        }
        return false;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode() ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User{identifier=");
        String string2 = this.identifier;
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


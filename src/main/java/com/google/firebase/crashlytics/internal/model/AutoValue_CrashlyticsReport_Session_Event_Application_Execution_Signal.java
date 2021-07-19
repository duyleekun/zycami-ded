/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal
extends CrashlyticsReport$Session$Event$Application$Execution$Signal {
    private final long address;
    private final String code;
    private final String name;

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String string2, String string3, long l10) {
        this.name = string2;
        this.code = string3;
        this.address = l10;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String string2, String string3, long l10, AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$1 autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$1) {
        this(string2, string3, l10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof CrashlyticsReport$Session$Event$Application$Execution$Signal;
        if (bl3) {
            long l10;
            long l11;
            long l12;
            long l13;
            String string2 = this.name;
            String string3 = ((CrashlyticsReport$Session$Event$Application$Execution$Signal)(object = (CrashlyticsReport$Session$Event$Application$Execution$Signal)object)).getName();
            bl3 = string2.equals(string3);
            if (!bl3 || !(bl3 = (string2 = this.code).equals(string3 = ((CrashlyticsReport$Session$Event$Application$Execution$Signal)object).getCode())) || (l13 = (l12 = (l11 = this.address) - (l10 = ((CrashlyticsReport$Session$Event$Application$Execution$Signal)object).getAddress())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getAddress() {
        return this.address;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int n10 = this.name.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.code.hashCode();
        n10 = (n10 ^ n12) * n11;
        long l10 = this.address;
        long l11 = l10 >>> 32;
        n11 = (int)(l10 ^ l11);
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Signal{name=");
        String string2 = this.name;
        stringBuilder.append(string2);
        stringBuilder.append(", code=");
        string2 = this.code;
        stringBuilder.append(string2);
        stringBuilder.append(", address=");
        long l10 = this.address;
        stringBuilder.append(l10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


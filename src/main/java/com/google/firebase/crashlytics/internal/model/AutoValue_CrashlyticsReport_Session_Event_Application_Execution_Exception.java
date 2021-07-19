/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception;
import com.google.firebase.crashlytics.internal.model.ImmutableList;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception
extends CrashlyticsReport$Session$Event$Application$Execution$Exception {
    private final CrashlyticsReport$Session$Event$Application$Execution$Exception causedBy;
    private final ImmutableList frames;
    private final int overflowCount;
    private final String reason;
    private final String type;

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String string2, String string3, ImmutableList immutableList, CrashlyticsReport$Session$Event$Application$Execution$Exception crashlyticsReport$Session$Event$Application$Execution$Exception, int n10) {
        this.type = string2;
        this.reason = string3;
        this.frames = immutableList;
        this.causedBy = crashlyticsReport$Session$Event$Application$Execution$Exception;
        this.overflowCount = n10;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String string2, String string3, ImmutableList immutableList, CrashlyticsReport$Session$Event$Application$Execution$Exception crashlyticsReport$Session$Event$Application$Execution$Exception, int n10, AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception$1 autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception$1) {
        this(string2, string3, immutableList, crashlyticsReport$Session$Event$Application$Execution$Exception, n10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean n10 = object instanceof CrashlyticsReport$Session$Event$Application$Execution$Exception;
        if (n10) {
            int n11;
            int n12;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            Object object2 = this.type;
            Object object3 = ((CrashlyticsReport$Session$Event$Application$Execution$Exception)(object = (CrashlyticsReport$Session$Event$Application$Execution$Exception)object)).getType();
            boolean bl6 = ((String)object2).equals(object3);
            if (!(bl6 && ((object2 = this.reason) == null ? (object2 = ((CrashlyticsReport$Session$Event$Application$Execution$Exception)object).getReason()) == null : (bl5 = ((String)object2).equals(object3 = ((CrashlyticsReport$Session$Event$Application$Execution$Exception)object).getReason()))) && (bl4 = ((ImmutableList)(object2 = this.frames)).equals(object3 = ((CrashlyticsReport$Session$Event$Application$Execution$Exception)object).getFrames())) && ((object2 = this.causedBy) == null ? (object2 = ((CrashlyticsReport$Session$Event$Application$Execution$Exception)object).getCausedBy()) == null : (bl3 = object2.equals(object3 = ((CrashlyticsReport$Session$Event$Application$Execution$Exception)object).getCausedBy()))) && (n12 = this.overflowCount) == (n11 = ((CrashlyticsReport$Session$Event$Application$Execution$Exception)object).getOverflowCount()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public CrashlyticsReport$Session$Event$Application$Execution$Exception getCausedBy() {
        return this.causedBy;
    }

    public ImmutableList getFrames() {
        return this.frames;
    }

    public int getOverflowCount() {
        return this.overflowCount;
    }

    public String getReason() {
        return this.reason;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int n10;
        String string2 = this.type;
        int n11 = string2.hashCode();
        int n12 = 1000003;
        n11 = (n11 ^ n12) * n12;
        Object object = this.reason;
        int n13 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n11 = (n11 ^ n10) * n12;
        n10 = this.frames.hashCode();
        n11 = (n11 ^ n10) * n12;
        object = this.causedBy;
        if (object != null) {
            n13 = object.hashCode();
        }
        n11 = (n11 ^ n13) * n12;
        n12 = this.overflowCount;
        return n11 ^ n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception{type=");
        Object object = this.type;
        stringBuilder.append((String)object);
        stringBuilder.append(", reason=");
        object = this.reason;
        stringBuilder.append((String)object);
        stringBuilder.append(", frames=");
        object = this.frames;
        stringBuilder.append(object);
        stringBuilder.append(", causedBy=");
        object = this.causedBy;
        stringBuilder.append(object);
        stringBuilder.append(", overflowCount=");
        int n10 = this.overflowCount;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


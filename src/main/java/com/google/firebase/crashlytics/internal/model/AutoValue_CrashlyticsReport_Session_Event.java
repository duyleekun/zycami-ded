/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event$1;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log;

public final class AutoValue_CrashlyticsReport_Session_Event
extends CrashlyticsReport$Session$Event {
    private final CrashlyticsReport$Session$Event$Application app;
    private final CrashlyticsReport$Session$Event$Device device;
    private final CrashlyticsReport$Session$Event$Log log;
    private final long timestamp;
    private final String type;

    private AutoValue_CrashlyticsReport_Session_Event(long l10, String string2, CrashlyticsReport$Session$Event$Application crashlyticsReport$Session$Event$Application, CrashlyticsReport$Session$Event$Device crashlyticsReport$Session$Event$Device, CrashlyticsReport$Session$Event$Log crashlyticsReport$Session$Event$Log) {
        this.timestamp = l10;
        this.type = string2;
        this.app = crashlyticsReport$Session$Event$Application;
        this.device = crashlyticsReport$Session$Event$Device;
        this.log = crashlyticsReport$Session$Event$Log;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event(long l10, String string2, CrashlyticsReport$Session$Event$Application crashlyticsReport$Session$Event$Application, CrashlyticsReport$Session$Event$Device crashlyticsReport$Session$Event$Device, CrashlyticsReport$Session$Event$Log crashlyticsReport$Session$Event$Log, AutoValue_CrashlyticsReport_Session_Event$1 autoValue_CrashlyticsReport_Session_Event$1) {
        this(l10, string2, crashlyticsReport$Session$Event$Application, crashlyticsReport$Session$Event$Device, crashlyticsReport$Session$Event$Log);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        Object object2 = object instanceof CrashlyticsReport$Session$Event;
        if (object2) {
            boolean bl3;
            Object object3;
            Object object4;
            long l10 = this.timestamp;
            long l11 = ((CrashlyticsReport$Session$Event)(object = (CrashlyticsReport$Session$Event)object)).getTimestamp();
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!(!object2 && (object2 = ((String)(object4 = this.type)).equals(object3 = ((CrashlyticsReport$Session$Event)object).getType())) && (object2 = (object4 = this.app).equals(object3 = ((CrashlyticsReport$Session$Event)object).getApp())) && (object2 = (object4 = this.device).equals(object3 = ((CrashlyticsReport$Session$Event)object).getDevice())) && ((object4 = this.log) == null ? (object = ((CrashlyticsReport$Session$Event)object).getLog()) == null : (bl3 = object4.equals(object = ((CrashlyticsReport$Session$Event)object).getLog()))))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public CrashlyticsReport$Session$Event$Application getApp() {
        return this.app;
    }

    public CrashlyticsReport$Session$Event$Device getDevice() {
        return this.device;
    }

    public CrashlyticsReport$Session$Event$Log getLog() {
        return this.log;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        long l10 = this.timestamp;
        long l11 = l10 >>> 32;
        int n10 = (int)(l10 ^= l11);
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.type.hashCode();
        n10 = (n10 ^ n12) * n11;
        n12 = this.app.hashCode();
        n10 = (n10 ^ n12) * n11;
        CrashlyticsReport$Session$Event$Device crashlyticsReport$Session$Event$Device = this.device;
        n12 = crashlyticsReport$Session$Event$Device.hashCode();
        n10 = (n10 ^ n12) * n11;
        CrashlyticsReport$Session$Event$Log crashlyticsReport$Session$Event$Log = this.log;
        if (crashlyticsReport$Session$Event$Log == null) {
            n11 = 0;
            crashlyticsReport$Session$Event$Log = null;
        } else {
            n11 = crashlyticsReport$Session$Event$Log.hashCode();
        }
        return n10 ^ n11;
    }

    public CrashlyticsReport$Session$Event$Builder toBuilder() {
        AutoValue_CrashlyticsReport_Session_Event$Builder autoValue_CrashlyticsReport_Session_Event$Builder = new AutoValue_CrashlyticsReport_Session_Event$Builder(this, null);
        return autoValue_CrashlyticsReport_Session_Event$Builder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{timestamp=");
        long l10 = this.timestamp;
        stringBuilder.append(l10);
        stringBuilder.append(", type=");
        Object object = this.type;
        stringBuilder.append((String)object);
        stringBuilder.append(", app=");
        object = this.app;
        stringBuilder.append(object);
        stringBuilder.append(", device=");
        object = this.device;
        stringBuilder.append(object);
        stringBuilder.append(", log=");
        object = this.log;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


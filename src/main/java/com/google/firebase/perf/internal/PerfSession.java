/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.PerfSession$1;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.PerfSession$Builder;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class PerfSession
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private Timer mCreationTime;
    private boolean mGaugeAndEventCollectionEnabled;
    private String mSessionId;

    static {
        PerfSession$1 perfSession$1 = new PerfSession$1();
        CREATOR = perfSession$1;
    }

    private PerfSession(Parcel object) {
        String string2;
        boolean bl2 = false;
        ClassLoader classLoader = null;
        this.mGaugeAndEventCollectionEnabled = false;
        this.mSessionId = string2 = object.readString();
        byte by2 = object.readByte();
        if (by2 != 0) {
            bl2 = true;
        }
        this.mGaugeAndEventCollectionEnabled = bl2;
        classLoader = Timer.class.getClassLoader();
        object = (Timer)object.readParcelable(classLoader);
        this.mCreationTime = object;
    }

    public /* synthetic */ PerfSession(Parcel parcel, PerfSession$1 perfSession$1) {
        this(parcel);
    }

    public PerfSession(String object, Clock clock) {
        this.mGaugeAndEventCollectionEnabled = false;
        this.mSessionId = object;
        this.mCreationTime = object = clock.getTime();
    }

    public static com.google.firebase.perf.v1.PerfSession[] buildAndSort(List list) {
        int n10;
        int n11 = list.isEmpty();
        if (n11 != 0) {
            return null;
        }
        n11 = list.size();
        com.google.firebase.perf.v1.PerfSession[] perfSessionArray = new com.google.firebase.perf.v1.PerfSession[n11];
        com.google.firebase.perf.v1.PerfSession perfSession = ((PerfSession)list.get(0)).build();
        int n12 = 1;
        int n13 = 0;
        for (int i10 = n12; i10 < (n10 = list.size()); ++i10) {
            PerfSession perfSession2;
            boolean bl2;
            com.google.firebase.perf.v1.PerfSession perfSession3 = ((PerfSession)list.get(i10)).build();
            if (n13 == 0 && (bl2 = (perfSession2 = (PerfSession)list.get(i10)).isVerbose())) {
                perfSessionArray[0] = perfSession3;
                perfSessionArray[i10] = perfSession;
                n13 = n12;
                continue;
            }
            perfSessionArray[i10] = perfSession3;
        }
        if (n13 == 0) {
            perfSessionArray[0] = perfSession;
        }
        return perfSessionArray;
    }

    public static PerfSession create() {
        String string2 = UUID.randomUUID().toString().replaceAll("\\-", "");
        Object object = new Clock();
        PerfSession perfSession = new PerfSession(string2, (Clock)object);
        boolean bl2 = PerfSession.shouldCollectGaugesAndEvents();
        perfSession.setGaugeAndEventCollectionEnabled(bl2);
        object = AndroidLogger.getInstance();
        int n10 = 2;
        Object[] objectArray = new Object[n10];
        boolean bl3 = perfSession.isVerbose();
        String string3 = bl3 ? "Verbose" : "Non Verbose";
        objectArray[0] = string3;
        objectArray[1] = string2;
        ((AndroidLogger)object).debug("Creating a new %s Session: %s", objectArray);
        return perfSession;
    }

    public static boolean isVerbose(com.google.firebase.perf.v1.PerfSession object) {
        boolean bl2;
        object = ((com.google.firebase.perf.v1.PerfSession)object).getSessionVerbosityList().iterator();
        while (bl2 = object.hasNext()) {
            SessionVerbosity sessionVerbosity;
            SessionVerbosity sessionVerbosity2 = (SessionVerbosity)object.next();
            if (sessionVerbosity2 != (sessionVerbosity = SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS)) continue;
            return true;
        }
        return false;
    }

    public static boolean shouldCollectGaugesAndEvents() {
        float f10;
        double d10;
        double d11;
        double d12;
        int n10;
        ConfigResolver configResolver = ConfigResolver.getInstance();
        boolean bl2 = configResolver.isPerformanceMonitoringEnabled();
        if (bl2 && (n10 = (d12 = (d11 = Math.random()) - (d10 = (double)(f10 = configResolver.getSessionsSamplingRate()))) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1)) < 0) {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f10 = 0.0f;
            configResolver = null;
        }
        return n10 != 0;
    }

    public com.google.firebase.perf.v1.PerfSession build() {
        PerfSession$Builder perfSession$Builder = com.google.firebase.perf.v1.PerfSession.newBuilder();
        Object object = this.mSessionId;
        perfSession$Builder = perfSession$Builder.setSessionId((String)object);
        boolean bl2 = this.mGaugeAndEventCollectionEnabled;
        if (bl2) {
            object = SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS;
            perfSession$Builder.addSessionVerbosity((SessionVerbosity)object);
        }
        return (com.google.firebase.perf.v1.PerfSession)perfSession$Builder.build();
    }

    public int describeContents() {
        return 0;
    }

    public Timer getTimer() {
        return this.mCreationTime;
    }

    public boolean isExpired() {
        ConfigResolver configResolver;
        long l10;
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        Timer timer = this.mCreationTime;
        long l11 = timer.getDurationMicros();
        long l12 = timeUnit.toMinutes(l11);
        long l13 = l12 - (l10 = (configResolver = ConfigResolver.getInstance()).getSessionsMaxDurationMinutes());
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            object = 1;
        } else {
            object = 0;
            timeUnit = null;
        }
        return (boolean)object;
    }

    public boolean isGaugeAndEventCollectionEnabled() {
        return this.mGaugeAndEventCollectionEnabled;
    }

    public boolean isVerbose() {
        return this.mGaugeAndEventCollectionEnabled;
    }

    public String sessionId() {
        return this.mSessionId;
    }

    public void setGaugeAndEventCollectionEnabled(boolean bl2) {
        this.mGaugeAndEventCollectionEnabled = bl2;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.mSessionId;
        parcel.writeString((String)object);
        n10 = (byte)(this.mGaugeAndEventCollectionEnabled ? 1 : 0);
        parcel.writeByte((byte)n10);
        object = this.mCreationTime;
        parcel.writeParcelable((Parcelable)object, 0);
    }
}


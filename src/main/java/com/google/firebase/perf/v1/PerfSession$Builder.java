/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.PerfSession$1;
import com.google.firebase.perf.v1.PerfSessionOrBuilder;
import com.google.firebase.perf.v1.SessionVerbosity;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.List;

public final class PerfSession$Builder
extends GeneratedMessageLite$Builder
implements PerfSessionOrBuilder {
    private PerfSession$Builder() {
        PerfSession perfSession = PerfSession.access$000();
        super(perfSession);
    }

    public /* synthetic */ PerfSession$Builder(PerfSession$1 perfSession$1) {
        this();
    }

    public PerfSession$Builder addAllSessionVerbosity(Iterable iterable) {
        this.copyOnWrite();
        PerfSession.access$600((PerfSession)this.instance, iterable);
        return this;
    }

    public PerfSession$Builder addSessionVerbosity(SessionVerbosity sessionVerbosity) {
        this.copyOnWrite();
        PerfSession.access$500((PerfSession)this.instance, sessionVerbosity);
        return this;
    }

    public PerfSession$Builder clearSessionId() {
        this.copyOnWrite();
        PerfSession.access$200((PerfSession)this.instance);
        return this;
    }

    public PerfSession$Builder clearSessionVerbosity() {
        this.copyOnWrite();
        PerfSession.access$700((PerfSession)this.instance);
        return this;
    }

    public String getSessionId() {
        return ((PerfSession)this.instance).getSessionId();
    }

    public ByteString getSessionIdBytes() {
        return ((PerfSession)this.instance).getSessionIdBytes();
    }

    public SessionVerbosity getSessionVerbosity(int n10) {
        return ((PerfSession)this.instance).getSessionVerbosity(n10);
    }

    public int getSessionVerbosityCount() {
        return ((PerfSession)this.instance).getSessionVerbosityCount();
    }

    public List getSessionVerbosityList() {
        return ((PerfSession)this.instance).getSessionVerbosityList();
    }

    public boolean hasSessionId() {
        return ((PerfSession)this.instance).hasSessionId();
    }

    public PerfSession$Builder setSessionId(String string2) {
        this.copyOnWrite();
        PerfSession.access$100((PerfSession)this.instance, string2);
        return this;
    }

    public PerfSession$Builder setSessionIdBytes(ByteString byteString) {
        this.copyOnWrite();
        PerfSession.access$300((PerfSession)this.instance, byteString);
        return this;
    }

    public PerfSession$Builder setSessionVerbosity(int n10, SessionVerbosity sessionVerbosity) {
        this.copyOnWrite();
        PerfSession.access$400((PerfSession)this.instance, n10, sessionVerbosity);
        return this;
    }
}


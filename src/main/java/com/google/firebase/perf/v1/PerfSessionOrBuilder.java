/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.SessionVerbosity;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface PerfSessionOrBuilder
extends MessageLiteOrBuilder {
    public String getSessionId();

    public ByteString getSessionIdBytes();

    public SessionVerbosity getSessionVerbosity(int var1);

    public int getSessionVerbosityCount();

    public List getSessionVerbosityList();

    public boolean hasSessionId();
}


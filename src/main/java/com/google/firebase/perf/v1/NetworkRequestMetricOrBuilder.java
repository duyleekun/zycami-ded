/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod;
import com.google.firebase.perf.v1.NetworkRequestMetric$NetworkClientErrorReason;
import com.google.firebase.perf.v1.PerfSession;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;
import java.util.Map;

public interface NetworkRequestMetricOrBuilder
extends MessageLiteOrBuilder {
    public boolean containsCustomAttributes(String var1);

    public long getClientStartTimeUs();

    public Map getCustomAttributes();

    public int getCustomAttributesCount();

    public Map getCustomAttributesMap();

    public String getCustomAttributesOrDefault(String var1, String var2);

    public String getCustomAttributesOrThrow(String var1);

    public NetworkRequestMetric$HttpMethod getHttpMethod();

    public int getHttpResponseCode();

    public NetworkRequestMetric$NetworkClientErrorReason getNetworkClientErrorReason();

    public PerfSession getPerfSessions(int var1);

    public int getPerfSessionsCount();

    public List getPerfSessionsList();

    public long getRequestPayloadBytes();

    public String getResponseContentType();

    public ByteString getResponseContentTypeBytes();

    public long getResponsePayloadBytes();

    public long getTimeToRequestCompletedUs();

    public long getTimeToResponseCompletedUs();

    public long getTimeToResponseInitiatedUs();

    public String getUrl();

    public ByteString getUrlBytes();

    public boolean hasClientStartTimeUs();

    public boolean hasHttpMethod();

    public boolean hasHttpResponseCode();

    public boolean hasNetworkClientErrorReason();

    public boolean hasRequestPayloadBytes();

    public boolean hasResponseContentType();

    public boolean hasResponsePayloadBytes();

    public boolean hasTimeToRequestCompletedUs();

    public boolean hasTimeToResponseCompletedUs();

    public boolean hasTimeToResponseInitiatedUs();

    public boolean hasUrl();
}


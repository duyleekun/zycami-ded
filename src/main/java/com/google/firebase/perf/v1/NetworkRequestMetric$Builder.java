/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric$1;
import com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod;
import com.google.firebase.perf.v1.NetworkRequestMetric$NetworkClientErrorReason;
import com.google.firebase.perf.v1.NetworkRequestMetricOrBuilder;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.PerfSession$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class NetworkRequestMetric$Builder
extends GeneratedMessageLite$Builder
implements NetworkRequestMetricOrBuilder {
    private NetworkRequestMetric$Builder() {
        NetworkRequestMetric networkRequestMetric = NetworkRequestMetric.access$000();
        super(networkRequestMetric);
    }

    public /* synthetic */ NetworkRequestMetric$Builder(NetworkRequestMetric$1 networkRequestMetric$1) {
        this();
    }

    public NetworkRequestMetric$Builder addAllPerfSessions(Iterable iterable) {
        this.copyOnWrite();
        NetworkRequestMetric.access$2900((NetworkRequestMetric)this.instance, iterable);
        return this;
    }

    public NetworkRequestMetric$Builder addPerfSessions(int n10, PerfSession$Builder perfSessionOrBuilder) {
        this.copyOnWrite();
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric)this.instance;
        perfSessionOrBuilder = (PerfSession)perfSessionOrBuilder.build();
        NetworkRequestMetric.access$2800(networkRequestMetric, n10, (PerfSession)perfSessionOrBuilder);
        return this;
    }

    public NetworkRequestMetric$Builder addPerfSessions(int n10, PerfSession perfSession) {
        this.copyOnWrite();
        NetworkRequestMetric.access$2800((NetworkRequestMetric)this.instance, n10, perfSession);
        return this;
    }

    public NetworkRequestMetric$Builder addPerfSessions(PerfSession$Builder perfSessionOrBuilder) {
        this.copyOnWrite();
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric)this.instance;
        perfSessionOrBuilder = (PerfSession)perfSessionOrBuilder.build();
        NetworkRequestMetric.access$2700(networkRequestMetric, (PerfSession)perfSessionOrBuilder);
        return this;
    }

    public NetworkRequestMetric$Builder addPerfSessions(PerfSession perfSession) {
        this.copyOnWrite();
        NetworkRequestMetric.access$2700((NetworkRequestMetric)this.instance, perfSession);
        return this;
    }

    public NetworkRequestMetric$Builder clearClientStartTimeUs() {
        this.copyOnWrite();
        NetworkRequestMetric.access$1800((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearCustomAttributes() {
        this.copyOnWrite();
        NetworkRequestMetric.access$2500((NetworkRequestMetric)this.instance).clear();
        return this;
    }

    public NetworkRequestMetric$Builder clearHttpMethod() {
        this.copyOnWrite();
        NetworkRequestMetric.access$500((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearHttpResponseCode() {
        this.copyOnWrite();
        NetworkRequestMetric.access$1300((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearNetworkClientErrorReason() {
        this.copyOnWrite();
        NetworkRequestMetric.access$1100((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearPerfSessions() {
        this.copyOnWrite();
        NetworkRequestMetric.access$3000((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearRequestPayloadBytes() {
        this.copyOnWrite();
        NetworkRequestMetric.access$700((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearResponseContentType() {
        this.copyOnWrite();
        NetworkRequestMetric.access$1500((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearResponsePayloadBytes() {
        this.copyOnWrite();
        NetworkRequestMetric.access$900((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearTimeToRequestCompletedUs() {
        this.copyOnWrite();
        NetworkRequestMetric.access$2000((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearTimeToResponseCompletedUs() {
        this.copyOnWrite();
        NetworkRequestMetric.access$2400((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearTimeToResponseInitiatedUs() {
        this.copyOnWrite();
        NetworkRequestMetric.access$2200((NetworkRequestMetric)this.instance);
        return this;
    }

    public NetworkRequestMetric$Builder clearUrl() {
        this.copyOnWrite();
        NetworkRequestMetric.access$200((NetworkRequestMetric)this.instance);
        return this;
    }

    public boolean containsCustomAttributes(String string2) {
        string2.getClass();
        return ((NetworkRequestMetric)this.instance).getCustomAttributesMap().containsKey(string2);
    }

    public long getClientStartTimeUs() {
        return ((NetworkRequestMetric)this.instance).getClientStartTimeUs();
    }

    public Map getCustomAttributes() {
        return this.getCustomAttributesMap();
    }

    public int getCustomAttributesCount() {
        return ((NetworkRequestMetric)this.instance).getCustomAttributesMap().size();
    }

    public Map getCustomAttributesMap() {
        return Collections.unmodifiableMap(((NetworkRequestMetric)this.instance).getCustomAttributesMap());
    }

    public String getCustomAttributesOrDefault(String string2, String string3) {
        string2.getClass();
        Map map = ((NetworkRequestMetric)this.instance).getCustomAttributesMap();
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            string3 = string2 = map.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getCustomAttributesOrThrow(String object) {
        object.getClass();
        Map map = ((NetworkRequestMetric)this.instance).getCustomAttributesMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            return (String)map.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public NetworkRequestMetric$HttpMethod getHttpMethod() {
        return ((NetworkRequestMetric)this.instance).getHttpMethod();
    }

    public int getHttpResponseCode() {
        return ((NetworkRequestMetric)this.instance).getHttpResponseCode();
    }

    public NetworkRequestMetric$NetworkClientErrorReason getNetworkClientErrorReason() {
        return ((NetworkRequestMetric)this.instance).getNetworkClientErrorReason();
    }

    public PerfSession getPerfSessions(int n10) {
        return ((NetworkRequestMetric)this.instance).getPerfSessions(n10);
    }

    public int getPerfSessionsCount() {
        return ((NetworkRequestMetric)this.instance).getPerfSessionsCount();
    }

    public List getPerfSessionsList() {
        return Collections.unmodifiableList(((NetworkRequestMetric)this.instance).getPerfSessionsList());
    }

    public long getRequestPayloadBytes() {
        return ((NetworkRequestMetric)this.instance).getRequestPayloadBytes();
    }

    public String getResponseContentType() {
        return ((NetworkRequestMetric)this.instance).getResponseContentType();
    }

    public ByteString getResponseContentTypeBytes() {
        return ((NetworkRequestMetric)this.instance).getResponseContentTypeBytes();
    }

    public long getResponsePayloadBytes() {
        return ((NetworkRequestMetric)this.instance).getResponsePayloadBytes();
    }

    public long getTimeToRequestCompletedUs() {
        return ((NetworkRequestMetric)this.instance).getTimeToRequestCompletedUs();
    }

    public long getTimeToResponseCompletedUs() {
        return ((NetworkRequestMetric)this.instance).getTimeToResponseCompletedUs();
    }

    public long getTimeToResponseInitiatedUs() {
        return ((NetworkRequestMetric)this.instance).getTimeToResponseInitiatedUs();
    }

    public String getUrl() {
        return ((NetworkRequestMetric)this.instance).getUrl();
    }

    public ByteString getUrlBytes() {
        return ((NetworkRequestMetric)this.instance).getUrlBytes();
    }

    public boolean hasClientStartTimeUs() {
        return ((NetworkRequestMetric)this.instance).hasClientStartTimeUs();
    }

    public boolean hasHttpMethod() {
        return ((NetworkRequestMetric)this.instance).hasHttpMethod();
    }

    public boolean hasHttpResponseCode() {
        return ((NetworkRequestMetric)this.instance).hasHttpResponseCode();
    }

    public boolean hasNetworkClientErrorReason() {
        return ((NetworkRequestMetric)this.instance).hasNetworkClientErrorReason();
    }

    public boolean hasRequestPayloadBytes() {
        return ((NetworkRequestMetric)this.instance).hasRequestPayloadBytes();
    }

    public boolean hasResponseContentType() {
        return ((NetworkRequestMetric)this.instance).hasResponseContentType();
    }

    public boolean hasResponsePayloadBytes() {
        return ((NetworkRequestMetric)this.instance).hasResponsePayloadBytes();
    }

    public boolean hasTimeToRequestCompletedUs() {
        return ((NetworkRequestMetric)this.instance).hasTimeToRequestCompletedUs();
    }

    public boolean hasTimeToResponseCompletedUs() {
        return ((NetworkRequestMetric)this.instance).hasTimeToResponseCompletedUs();
    }

    public boolean hasTimeToResponseInitiatedUs() {
        return ((NetworkRequestMetric)this.instance).hasTimeToResponseInitiatedUs();
    }

    public boolean hasUrl() {
        return ((NetworkRequestMetric)this.instance).hasUrl();
    }

    public NetworkRequestMetric$Builder putAllCustomAttributes(Map map) {
        this.copyOnWrite();
        NetworkRequestMetric.access$2500((NetworkRequestMetric)this.instance).putAll(map);
        return this;
    }

    public NetworkRequestMetric$Builder putCustomAttributes(String string2, String string3) {
        string2.getClass();
        string3.getClass();
        this.copyOnWrite();
        NetworkRequestMetric.access$2500((NetworkRequestMetric)this.instance).put(string2, string3);
        return this;
    }

    public NetworkRequestMetric$Builder removeCustomAttributes(String string2) {
        string2.getClass();
        this.copyOnWrite();
        NetworkRequestMetric.access$2500((NetworkRequestMetric)this.instance).remove(string2);
        return this;
    }

    public NetworkRequestMetric$Builder removePerfSessions(int n10) {
        this.copyOnWrite();
        NetworkRequestMetric.access$3100((NetworkRequestMetric)this.instance, n10);
        return this;
    }

    public NetworkRequestMetric$Builder setClientStartTimeUs(long l10) {
        this.copyOnWrite();
        NetworkRequestMetric.access$1700((NetworkRequestMetric)this.instance, l10);
        return this;
    }

    public NetworkRequestMetric$Builder setHttpMethod(NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod) {
        this.copyOnWrite();
        NetworkRequestMetric.access$400((NetworkRequestMetric)this.instance, networkRequestMetric$HttpMethod);
        return this;
    }

    public NetworkRequestMetric$Builder setHttpResponseCode(int n10) {
        this.copyOnWrite();
        NetworkRequestMetric.access$1200((NetworkRequestMetric)this.instance, n10);
        return this;
    }

    public NetworkRequestMetric$Builder setNetworkClientErrorReason(NetworkRequestMetric$NetworkClientErrorReason networkRequestMetric$NetworkClientErrorReason) {
        this.copyOnWrite();
        NetworkRequestMetric.access$1000((NetworkRequestMetric)this.instance, networkRequestMetric$NetworkClientErrorReason);
        return this;
    }

    public NetworkRequestMetric$Builder setPerfSessions(int n10, PerfSession$Builder perfSessionOrBuilder) {
        this.copyOnWrite();
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric)this.instance;
        perfSessionOrBuilder = (PerfSession)perfSessionOrBuilder.build();
        NetworkRequestMetric.access$2600(networkRequestMetric, n10, (PerfSession)perfSessionOrBuilder);
        return this;
    }

    public NetworkRequestMetric$Builder setPerfSessions(int n10, PerfSession perfSession) {
        this.copyOnWrite();
        NetworkRequestMetric.access$2600((NetworkRequestMetric)this.instance, n10, perfSession);
        return this;
    }

    public NetworkRequestMetric$Builder setRequestPayloadBytes(long l10) {
        this.copyOnWrite();
        NetworkRequestMetric.access$600((NetworkRequestMetric)this.instance, l10);
        return this;
    }

    public NetworkRequestMetric$Builder setResponseContentType(String string2) {
        this.copyOnWrite();
        NetworkRequestMetric.access$1400((NetworkRequestMetric)this.instance, string2);
        return this;
    }

    public NetworkRequestMetric$Builder setResponseContentTypeBytes(ByteString byteString) {
        this.copyOnWrite();
        NetworkRequestMetric.access$1600((NetworkRequestMetric)this.instance, byteString);
        return this;
    }

    public NetworkRequestMetric$Builder setResponsePayloadBytes(long l10) {
        this.copyOnWrite();
        NetworkRequestMetric.access$800((NetworkRequestMetric)this.instance, l10);
        return this;
    }

    public NetworkRequestMetric$Builder setTimeToRequestCompletedUs(long l10) {
        this.copyOnWrite();
        NetworkRequestMetric.access$1900((NetworkRequestMetric)this.instance, l10);
        return this;
    }

    public NetworkRequestMetric$Builder setTimeToResponseCompletedUs(long l10) {
        this.copyOnWrite();
        NetworkRequestMetric.access$2300((NetworkRequestMetric)this.instance, l10);
        return this;
    }

    public NetworkRequestMetric$Builder setTimeToResponseInitiatedUs(long l10) {
        this.copyOnWrite();
        NetworkRequestMetric.access$2100((NetworkRequestMetric)this.instance, l10);
        return this;
    }

    public NetworkRequestMetric$Builder setUrl(String string2) {
        this.copyOnWrite();
        NetworkRequestMetric.access$100((NetworkRequestMetric)this.instance, string2);
        return this;
    }

    public NetworkRequestMetric$Builder setUrlBytes(ByteString byteString) {
        this.copyOnWrite();
        NetworkRequestMetric.access$300((NetworkRequestMetric)this.instance, byteString);
        return this;
    }
}


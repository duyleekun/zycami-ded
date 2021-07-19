/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.http.HttpMessage
 *  org.apache.http.HttpResponse
 *  org.apache.http.client.ResponseHandler
 */
package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.util.Timer;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

public class InstrumentApacheHttpResponseHandler
implements ResponseHandler {
    private final NetworkRequestMetricBuilder mBuilder;
    private final ResponseHandler mResponseHandlerDelegate;
    private final Timer mTimer;

    public InstrumentApacheHttpResponseHandler(ResponseHandler responseHandler, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        this.mResponseHandlerDelegate = responseHandler;
        this.mTimer = timer;
        this.mBuilder = networkRequestMetricBuilder;
    }

    public Object handleResponse(HttpResponse httpResponse) {
        Object object = this.mBuilder;
        long l10 = this.mTimer.getDurationMicros();
        ((NetworkRequestMetricBuilder)object).setTimeToResponseCompletedMicros(l10);
        object = this.mBuilder;
        Object object2 = httpResponse.getStatusLine();
        int n10 = object2.getStatusCode();
        ((NetworkRequestMetricBuilder)object).setHttpResponseCode(n10);
        object = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpResponse);
        if (object != null) {
            object2 = this.mBuilder;
            long l11 = (Long)object;
            ((NetworkRequestMetricBuilder)object2).setResponsePayloadBytes(l11);
        }
        if ((object = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(httpResponse)) != null) {
            object2 = this.mBuilder;
            ((NetworkRequestMetricBuilder)object2).setResponseContentType((String)object);
        }
        this.mBuilder.build();
        return this.mResponseHandlerDelegate.handleResponse(httpResponse);
    }
}


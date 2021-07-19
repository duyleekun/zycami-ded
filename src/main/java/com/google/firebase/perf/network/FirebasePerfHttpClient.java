/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.http.HttpHost
 *  org.apache.http.HttpMessage
 *  org.apache.http.HttpRequest
 *  org.apache.http.HttpResponse
 *  org.apache.http.client.HttpClient
 *  org.apache.http.client.ResponseHandler
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.protocol.HttpContext
 */
package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.network.InstrumentApacheHttpResponseHandler;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpHost;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public class FirebasePerfHttpClient {
    private FirebasePerfHttpClient() {
    }

    public static Object execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler) {
        Timer timer = new Timer();
        TransportManager transportManager = TransportManager.getInstance();
        return FirebasePerfHttpClient.execute(httpClient, httpHost, httpRequest, responseHandler, timer, transportManager);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, Timer timer, TransportManager appStateMonitor$AppStateCallback) {
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            long l10;
            Object object = new StringBuilder();
            String string2 = httpHost.toURI();
            ((StringBuilder)object).append(string2);
            string2 = httpRequest.getRequestLine();
            string2 = string2.getUri();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            object = ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object);
            string2 = httpRequest.getRequestLine();
            string2 = string2.getMethod();
            ((NetworkRequestMetricBuilder)object).setHttpMethod(string2);
            object = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpRequest);
            if (object != null) {
                l10 = (Long)object;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestPayloadBytes(l10);
            }
            timer.reset();
            l10 = timer.getMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            object = new InstrumentApacheHttpResponseHandler(responseHandler, timer, (NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            return httpClient.execute(httpHost, httpRequest, (ResponseHandler)object);
        }
        catch (IOException iOException) {
            long l11 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
    }

    public static Object execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext) {
        Timer timer = new Timer();
        TransportManager transportManager = TransportManager.getInstance();
        return FirebasePerfHttpClient.execute(httpClient, httpHost, httpRequest, responseHandler, httpContext, timer, transportManager);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext, Timer timer, TransportManager appStateMonitor$AppStateCallback) {
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            long l10;
            Object object = new StringBuilder();
            String string2 = httpHost.toURI();
            ((StringBuilder)object).append(string2);
            string2 = httpRequest.getRequestLine();
            string2 = string2.getUri();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            object = ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object);
            string2 = httpRequest.getRequestLine();
            string2 = string2.getMethod();
            ((NetworkRequestMetricBuilder)object).setHttpMethod(string2);
            object = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpRequest);
            if (object != null) {
                l10 = (Long)object;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestPayloadBytes(l10);
            }
            timer.reset();
            l10 = timer.getMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            object = new InstrumentApacheHttpResponseHandler(responseHandler, timer, (NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            return httpClient.execute(httpHost, httpRequest, (ResponseHandler)object, httpContext);
        }
        catch (IOException iOException) {
            long l11 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
    }

    public static Object execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler) {
        Timer timer = new Timer();
        TransportManager transportManager = TransportManager.getInstance();
        return FirebasePerfHttpClient.execute(httpClient, httpUriRequest, responseHandler, timer, transportManager);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler, Timer timer, TransportManager appStateMonitor$AppStateCallback) {
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            long l10;
            Object object = httpUriRequest.getURI();
            object = ((URI)object).toString();
            object = ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object);
            String string2 = httpUriRequest.getMethod();
            ((NetworkRequestMetricBuilder)object).setHttpMethod(string2);
            object = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpUriRequest);
            if (object != null) {
                l10 = (Long)object;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestPayloadBytes(l10);
            }
            timer.reset();
            l10 = timer.getMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            object = new InstrumentApacheHttpResponseHandler(responseHandler, timer, (NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            return httpClient.execute(httpUriRequest, (ResponseHandler)object);
        }
        catch (IOException iOException) {
            long l11 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
    }

    public static Object execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext) {
        Timer timer = new Timer();
        TransportManager transportManager = TransportManager.getInstance();
        return FirebasePerfHttpClient.execute(httpClient, httpUriRequest, responseHandler, httpContext, timer, transportManager);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext, Timer timer, TransportManager appStateMonitor$AppStateCallback) {
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            long l10;
            Object object = httpUriRequest.getURI();
            object = ((URI)object).toString();
            object = ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object);
            String string2 = httpUriRequest.getMethod();
            ((NetworkRequestMetricBuilder)object).setHttpMethod(string2);
            object = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpUriRequest);
            if (object != null) {
                l10 = (Long)object;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestPayloadBytes(l10);
            }
            timer.reset();
            l10 = timer.getMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            object = new InstrumentApacheHttpResponseHandler(responseHandler, timer, (NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            return httpClient.execute(httpUriRequest, (ResponseHandler)object, httpContext);
        }
        catch (IOException iOException) {
            long l11 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) {
        Timer timer = new Timer();
        TransportManager transportManager = TransportManager.getInstance();
        return FirebasePerfHttpClient.execute(httpClient, httpHost, httpRequest, timer, transportManager);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HttpResponse execute(HttpClient httpClient, HttpHost object, HttpRequest httpRequest, Timer timer, TransportManager appStateMonitor$AppStateCallback) {
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            long l10;
            Object object2 = new StringBuilder();
            String string2 = object.toURI();
            ((StringBuilder)object2).append(string2);
            string2 = httpRequest.getRequestLine();
            string2 = string2.getUri();
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            object2 = ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object2);
            string2 = httpRequest.getRequestLine();
            string2 = string2.getMethod();
            ((NetworkRequestMetricBuilder)object2).setHttpMethod(string2);
            object2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpRequest);
            if (object2 != null) {
                l10 = (Long)object2;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestPayloadBytes(l10);
            }
            timer.reset();
            l10 = timer.getMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            httpClient = httpClient.execute((HttpHost)object, httpRequest);
            long l11 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l11);
            object = httpClient.getStatusLine();
            int n10 = object.getStatusCode();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setHttpResponseCode(n10);
            object = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpClient);
            if (object != null) {
                l11 = (Long)object;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setResponsePayloadBytes(l11);
            }
            if ((object = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType((HttpResponse)httpClient)) != null) {
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setResponseContentType((String)object);
            }
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).build();
            return httpClient;
        }
        catch (IOException iOException) {
            long l12 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l12);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        Timer timer = new Timer();
        TransportManager transportManager = TransportManager.getInstance();
        return FirebasePerfHttpClient.execute(httpClient, httpHost, httpRequest, httpContext, timer, transportManager);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HttpResponse execute(HttpClient httpClient, HttpHost object, HttpRequest httpRequest, HttpContext httpContext, Timer timer, TransportManager appStateMonitor$AppStateCallback) {
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            long l10;
            Object object2 = new StringBuilder();
            String string2 = object.toURI();
            ((StringBuilder)object2).append(string2);
            string2 = httpRequest.getRequestLine();
            string2 = string2.getUri();
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            object2 = ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object2);
            string2 = httpRequest.getRequestLine();
            string2 = string2.getMethod();
            ((NetworkRequestMetricBuilder)object2).setHttpMethod(string2);
            object2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpRequest);
            if (object2 != null) {
                l10 = (Long)object2;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestPayloadBytes(l10);
            }
            timer.reset();
            l10 = timer.getMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            httpClient = httpClient.execute((HttpHost)object, httpRequest, httpContext);
            long l11 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l11);
            object = httpClient.getStatusLine();
            int n10 = object.getStatusCode();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setHttpResponseCode(n10);
            object = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpClient);
            if (object != null) {
                l11 = (Long)object;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setResponsePayloadBytes(l11);
            }
            if ((object = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType((HttpResponse)httpClient)) != null) {
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setResponseContentType((String)object);
            }
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).build();
            return httpClient;
        }
        catch (IOException iOException) {
            long l12 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l12);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) {
        Timer timer = new Timer();
        TransportManager transportManager = TransportManager.getInstance();
        return FirebasePerfHttpClient.execute(httpClient, httpUriRequest, timer, transportManager);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest object, Timer timer, TransportManager appStateMonitor$AppStateCallback) {
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            long l10;
            Object object2 = object.getURI();
            object2 = ((URI)object2).toString();
            object2 = ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object2);
            String string2 = object.getMethod();
            ((NetworkRequestMetricBuilder)object2).setHttpMethod(string2);
            object2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)object);
            if (object2 != null) {
                l10 = (Long)object2;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestPayloadBytes(l10);
            }
            timer.reset();
            l10 = timer.getMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            httpClient = httpClient.execute((HttpUriRequest)object);
            l10 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l10);
            object = httpClient.getStatusLine();
            int n10 = object.getStatusCode();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setHttpResponseCode(n10);
            object = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpClient);
            if (object != null) {
                l10 = (Long)object;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setResponsePayloadBytes(l10);
            }
            if ((object = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType((HttpResponse)httpClient)) != null) {
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setResponseContentType((String)object);
            }
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).build();
            return httpClient;
        }
        catch (IOException iOException) {
            long l11 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) {
        Timer timer = new Timer();
        TransportManager transportManager = TransportManager.getInstance();
        return FirebasePerfHttpClient.execute(httpClient, httpUriRequest, httpContext, timer, transportManager);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest object, HttpContext httpContext, Timer timer, TransportManager appStateMonitor$AppStateCallback) {
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            long l10;
            Object object2 = object.getURI();
            object2 = ((URI)object2).toString();
            object2 = ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object2);
            String string2 = object.getMethod();
            ((NetworkRequestMetricBuilder)object2).setHttpMethod(string2);
            object2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)object);
            if (object2 != null) {
                l10 = (Long)object2;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestPayloadBytes(l10);
            }
            timer.reset();
            l10 = timer.getMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            httpClient = httpClient.execute((HttpUriRequest)object, httpContext);
            long l11 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l11);
            object = httpClient.getStatusLine();
            int n10 = object.getStatusCode();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setHttpResponseCode(n10);
            object = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength((HttpMessage)httpClient);
            if (object != null) {
                l11 = (Long)object;
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setResponsePayloadBytes(l11);
            }
            if ((object = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType((HttpResponse)httpClient)) != null) {
                ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setResponseContentType((String)object);
            }
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).build();
            return httpClient;
        }
        catch (IOException iOException) {
            long l12 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l12);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
    }
}


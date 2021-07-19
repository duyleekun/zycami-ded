/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.impl;

import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.AppStateUpdateHandler;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.PerfSession;
import com.google.firebase.perf.internal.SessionAwareObject;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric$Builder;
import com.google.firebase.perf.v1.NetworkRequestMetric$HttpMethod;
import com.google.firebase.perf.v1.NetworkRequestMetric$NetworkClientErrorReason;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class NetworkRequestMetricBuilder
extends AppStateUpdateHandler
implements SessionAwareObject {
    private static final char HIGHEST_ASCII_CHAR = '\u007f';
    private static final char HIGHEST_CONTROL_CHAR = '\u001f';
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final GaugeManager gaugeManager;
    private boolean isManualNetworkRequestMetric;
    private boolean isReportSent;
    private final NetworkRequestMetric$Builder networkRequestMetricBuilder;
    private final List sessions;
    private final TransportManager transportManager;
    private String userAgent;
    private final WeakReference weakReference;

    private NetworkRequestMetricBuilder(TransportManager transportManager) {
        AppStateMonitor appStateMonitor = AppStateMonitor.getInstance();
        GaugeManager gaugeManager = GaugeManager.getInstance();
        this(transportManager, appStateMonitor, gaugeManager);
    }

    public NetworkRequestMetricBuilder(TransportManager list, AppStateMonitor weakReference, GaugeManager gaugeManager) {
        super((AppStateMonitor)((Object)weakReference));
        weakReference = NetworkRequestMetric.newBuilder();
        this.networkRequestMetricBuilder = weakReference;
        this.weakReference = weakReference = new WeakReference<NetworkRequestMetricBuilder>(this);
        this.transportManager = list;
        this.gaugeManager = gaugeManager;
        list = new List();
        this.sessions = list = Collections.synchronizedList(list);
        this.registerForAppState();
    }

    public static NetworkRequestMetricBuilder builder(TransportManager transportManager) {
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(transportManager);
        return networkRequestMetricBuilder;
    }

    private boolean hasStarted() {
        return this.networkRequestMetricBuilder.hasClientStartTimeUs();
    }

    private boolean isStopped() {
        return this.networkRequestMetricBuilder.hasTimeToResponseCompletedUs();
    }

    private static boolean isValidContentType(String string2) {
        int n10;
        int n11 = string2.length();
        if (n11 > (n10 = 128)) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = string2.length()); ++n11) {
            int n12;
            n10 = string2.charAt(n11);
            if (n10 > (n12 = 31) && n10 <= (n12 = 127)) {
                continue;
            }
            return false;
        }
        return true;
    }

    public NetworkRequestMetric build() {
        Object object = SessionManager.getInstance();
        Object object2 = this.weakReference;
        object.unregisterForSessionUpdates((WeakReference)object2);
        this.unregisterForAppState();
        object = PerfSession.buildAndSort(this.getSessions());
        if (object != null) {
            object2 = this.networkRequestMetricBuilder;
            object = Arrays.asList(object);
            ((NetworkRequestMetric$Builder)object2).addAllPerfSessions((Iterable)object);
        }
        object = (NetworkRequestMetric)this.networkRequestMetricBuilder.build();
        object2 = this.userAgent;
        boolean bl2 = NetworkRequestMetricBuilderUtil.isAllowedUserAgent((String)object2);
        if (!bl2) {
            logger.debug("Dropping network request from a 'User-Agent' that is not allowed");
            return object;
        }
        bl2 = this.isReportSent;
        if (!bl2) {
            object2 = this.transportManager;
            ApplicationProcessState applicationProcessState = this.getAppState();
            ((TransportManager)object2).log((NetworkRequestMetric)object, applicationProcessState);
            this.isReportSent = true;
            return object;
        }
        bl2 = this.isManualNetworkRequestMetric;
        if (bl2) {
            object2 = logger;
            String string2 = "This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response";
            ((AndroidLogger)object2).info(string2);
        }
        return object;
    }

    public void clearBuilderFields() {
        this.networkRequestMetricBuilder.clear();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getSessions() {
        List list = this.sessions;
        synchronized (list) {
            List list2 = new List();
            Object object = this.sessions;
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                if ((object2 = (PerfSession)object2) == null) continue;
                ((ArrayList)list2).add(object2);
            }
            return Collections.unmodifiableList(list2);
        }
    }

    public long getTimeToResponseInitiatedMicros() {
        return this.networkRequestMetricBuilder.getTimeToResponseInitiatedUs();
    }

    public String getUrl() {
        return this.networkRequestMetricBuilder.getUrl();
    }

    public boolean hasHttpResponseCode() {
        return this.networkRequestMetricBuilder.hasHttpResponseCode();
    }

    public boolean isReportSent() {
        return this.isReportSent;
    }

    public NetworkRequestMetricBuilder setCustomAttributes(Map map) {
        this.networkRequestMetricBuilder.clearCustomAttributes().putAllCustomAttributes(map);
        return this;
    }

    public NetworkRequestMetricBuilder setHttpMethod(String object) {
        if (object != null) {
            NetworkRequestMetric$HttpMethod networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.HTTP_METHOD_UNKNOWN;
            object = ((String)object).toUpperCase();
            ((String)object).hashCode();
            int n10 = -1;
            int n11 = ((String)object).hashCode();
            switch (n11) {
                default: {
                    break;
                }
                case 2012838315: {
                    String string2 = "DELETE";
                    boolean bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 8;
                    break;
                }
                case 1669334218: {
                    String string3 = "CONNECT";
                    boolean bl3 = ((String)object).equals(string3);
                    if (!bl3) break;
                    n10 = 7;
                    break;
                }
                case 80083237: {
                    String string4 = "TRACE";
                    boolean bl4 = ((String)object).equals(string4);
                    if (!bl4) break;
                    n10 = 6;
                    break;
                }
                case 75900968: {
                    String string5 = "PATCH";
                    boolean bl5 = ((String)object).equals(string5);
                    if (!bl5) break;
                    n10 = 5;
                    break;
                }
                case 2461856: {
                    String string6 = "POST";
                    boolean bl6 = ((String)object).equals(string6);
                    if (!bl6) break;
                    n10 = 4;
                    break;
                }
                case 2213344: {
                    String string7 = "HEAD";
                    boolean bl7 = ((String)object).equals(string7);
                    if (!bl7) break;
                    n10 = 3;
                    break;
                }
                case 79599: {
                    String string8 = "PUT";
                    boolean bl8 = ((String)object).equals(string8);
                    if (!bl8) break;
                    n10 = 2;
                    break;
                }
                case 70454: {
                    String string9 = "GET";
                    boolean bl9 = ((String)object).equals(string9);
                    if (!bl9) break;
                    n10 = 1;
                    break;
                }
                case -531492226: {
                    String string10 = "OPTIONS";
                    boolean bl10 = ((String)object).equals(string10);
                    if (!bl10) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    break;
                }
                case 8: {
                    networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.DELETE;
                    break;
                }
                case 7: {
                    networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.CONNECT;
                    break;
                }
                case 6: {
                    networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.TRACE;
                    break;
                }
                case 5: {
                    networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.PATCH;
                    break;
                }
                case 4: {
                    networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.POST;
                    break;
                }
                case 3: {
                    networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.HEAD;
                    break;
                }
                case 2: {
                    networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.PUT;
                    break;
                }
                case 1: {
                    networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.GET;
                    break;
                }
                case 0: {
                    networkRequestMetric$HttpMethod = NetworkRequestMetric$HttpMethod.OPTIONS;
                }
            }
            object = this.networkRequestMetricBuilder;
            ((NetworkRequestMetric$Builder)object).setHttpMethod(networkRequestMetric$HttpMethod);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setHttpResponseCode(int n10) {
        this.networkRequestMetricBuilder.setHttpResponseCode(n10);
        return this;
    }

    public void setManualNetworkRequestMetric() {
        this.isManualNetworkRequestMetric = true;
    }

    public NetworkRequestMetricBuilder setNetworkClientErrorReason() {
        NetworkRequestMetric$Builder networkRequestMetric$Builder = this.networkRequestMetricBuilder;
        NetworkRequestMetric$NetworkClientErrorReason networkRequestMetric$NetworkClientErrorReason = NetworkRequestMetric$NetworkClientErrorReason.GENERIC_CLIENT_ERROR;
        networkRequestMetric$Builder.setNetworkClientErrorReason(networkRequestMetric$NetworkClientErrorReason);
        return this;
    }

    public void setReportSent() {
        this.isReportSent = true;
    }

    public NetworkRequestMetricBuilder setRequestPayloadBytes(long l10) {
        this.networkRequestMetricBuilder.setRequestPayloadBytes(l10);
        return this;
    }

    public NetworkRequestMetricBuilder setRequestStartTimeMicros(long l10) {
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        Object object = SessionManager.getInstance();
        WeakReference weakReference = this.weakReference;
        ((SessionManager)object).registerForSessionUpdates(weakReference);
        object = this.networkRequestMetricBuilder;
        ((NetworkRequestMetric$Builder)object).setClientStartTimeUs(l10);
        this.updateSession(perfSession);
        boolean bl2 = perfSession.isGaugeAndEventCollectionEnabled();
        if (bl2) {
            GaugeManager gaugeManager = this.gaugeManager;
            Timer timer = perfSession.getTimer();
            gaugeManager.collectGaugeMetricOnce(timer);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setResponseContentType(String string2) {
        if (string2 == null) {
            this.networkRequestMetricBuilder.clearResponseContentType();
            return this;
        }
        boolean bl2 = NetworkRequestMetricBuilder.isValidContentType(string2);
        if (bl2) {
            NetworkRequestMetric$Builder networkRequestMetric$Builder = this.networkRequestMetricBuilder;
            networkRequestMetric$Builder.setResponseContentType(string2);
        } else {
            AndroidLogger androidLogger = logger;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "The content type of the response is not a valid content-type:";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            androidLogger.info(string2);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setResponsePayloadBytes(long l10) {
        this.networkRequestMetricBuilder.setResponsePayloadBytes(l10);
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToRequestCompletedMicros(long l10) {
        this.networkRequestMetricBuilder.setTimeToRequestCompletedUs(l10);
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToResponseCompletedMicros(long l10) {
        NetworkRequestMetric$Builder networkRequestMetric$Builder = this.networkRequestMetricBuilder;
        networkRequestMetric$Builder.setTimeToResponseCompletedUs(l10);
        Object object = SessionManager.getInstance().perfSession();
        boolean bl2 = ((PerfSession)object).isGaugeAndEventCollectionEnabled();
        if (bl2) {
            object = this.gaugeManager;
            Timer timer = SessionManager.getInstance().perfSession().getTimer();
            ((GaugeManager)object).collectGaugeMetricOnce(timer);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToResponseInitiatedMicros(long l10) {
        this.networkRequestMetricBuilder.setTimeToResponseInitiatedUs(l10);
        return this;
    }

    public NetworkRequestMetricBuilder setUrl(String string2) {
        if (string2 != null) {
            string2 = Utils.stripSensitiveInfo(string2);
            NetworkRequestMetric$Builder networkRequestMetric$Builder = this.networkRequestMetricBuilder;
            int n10 = 2000;
            string2 = Utils.truncateURL(string2, n10);
            networkRequestMetric$Builder.setUrl(string2);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setUserAgent(String string2) {
        this.userAgent = string2;
        return this;
    }

    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.info("Unable to add new SessionId to the Network Trace. Continuing without it.");
            return;
        }
        boolean bl2 = this.hasStarted();
        if (bl2 && !(bl2 = this.isStopped())) {
            List list = this.sessions;
            list.add(perfSession);
        }
    }
}


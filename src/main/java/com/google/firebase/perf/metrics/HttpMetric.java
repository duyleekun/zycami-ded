/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.metrics;

import com.google.firebase.perf.FirebasePerformanceAttributable;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.net.URL;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HttpMetric
implements FirebasePerformanceAttributable {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private boolean isDisabled;
    private boolean isStopped;
    private final Map mAttributes;
    private NetworkRequestMetricBuilder mMetricBuilder;
    private Timer mTimer;

    public HttpMetric(String string2, String object, TransportManager appStateMonitor$AppStateCallback, Timer objectArray) {
        ConcurrentHashMap concurrentHashMap;
        this.isStopped = false;
        this.isDisabled = false;
        this.mAttributes = concurrentHashMap = new ConcurrentHashMap();
        this.mTimer = objectArray;
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback).setUrl(string2);
        this.mMetricBuilder = object = ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setHttpMethod((String)object);
        ((NetworkRequestMetricBuilder)object).setManualNetworkRequestMetric();
        object = ConfigResolver.getInstance();
        boolean bl2 = ((ConfigResolver)object).isPerformanceMonitoringEnabled();
        if (!bl2) {
            object = logger;
            int n10 = 1;
            objectArray = new Object[n10];
            objectArray[0] = string2;
            string2 = "HttpMetric feature is disabled. URL %s";
            ((AndroidLogger)object).info(string2, objectArray);
            this.isDisabled = n10;
        }
    }

    public HttpMetric(URL object, String string2, TransportManager transportManager, Timer timer) {
        object = ((URL)object).toString();
        this((String)object, string2, transportManager, timer);
    }

    private void checkAttribute(String object, String object2) {
        int n10 = this.isStopped;
        if (n10 == 0) {
            if (object != null && object2 != null) {
                int n11;
                Object object3 = this.mAttributes;
                n10 = object3.containsKey(object);
                if (n10 == 0 && (n10 = (object3 = this.mAttributes).size()) >= (n11 = 5)) {
                    object2 = Locale.ENGLISH;
                    object3 = new Object[1];
                    Integer n12 = n11;
                    object3[0] = n12;
                    object2 = String.format((Locale)object2, "Exceeds max limit of number of attributes - %d", object3);
                    object = new IllegalArgumentException((String)object2);
                    throw object;
                }
                object3 = new AbstractMap.SimpleEntry(object, object2);
                if ((object = PerfMetricValidator.validateAttribute(object3)) == null) {
                    return;
                }
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            object = new IllegalArgumentException("Attribute must not have null key or value.");
            throw object;
        }
        object = new IllegalArgumentException("HttpMetric has been logged already so unable to modify attributes");
        throw object;
    }

    public String getAttribute(String string2) {
        return (String)this.mAttributes.get(string2);
    }

    public Map getAttributes() {
        Map map = this.mAttributes;
        HashMap hashMap = new HashMap(map);
        return hashMap;
    }

    public void markRequestComplete() {
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mMetricBuilder;
        long l10 = this.mTimer.getDurationMicros();
        networkRequestMetricBuilder.setTimeToRequestCompletedMicros(l10);
    }

    public void markResponseStart() {
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mMetricBuilder;
        long l10 = this.mTimer.getDurationMicros();
        networkRequestMetricBuilder.setTimeToResponseInitiatedMicros(l10);
    }

    public void putAttribute(String string2, String string3) {
        Object object;
        int n10 = 2;
        int n11 = 3;
        int n12 = 0;
        int n13 = 1;
        string2 = string2.trim();
        string3 = string3.trim();
        this.checkAttribute(string2, string3);
        AndroidLogger androidLogger = logger;
        Object object2 = "Setting attribute '%s' to %s on network request '%s'";
        Object[] objectArray = new Object[n11];
        objectArray[0] = string2;
        objectArray[n13] = string3;
        Object object3 = this.mMetricBuilder;
        object3 = ((NetworkRequestMetricBuilder)object3).getUrl();
        objectArray[n10] = object3;
        try {
            androidLogger.debug((String)object2, objectArray);
            n12 = n13;
        }
        catch (Exception exception) {
            object2 = logger;
            Object[] objectArray2 = new Object[n11];
            objectArray2[0] = string2;
            objectArray2[n13] = string3;
            String string4 = exception.getMessage();
            objectArray2[n10] = string4;
            object = "Cannot set attribute '%s' with value '%s' (%s)";
            ((AndroidLogger)object2).error((String)object, objectArray2);
        }
        if (n12 != 0) {
            object = this.mAttributes;
            object.put(string2, string3);
        }
    }

    public void removeAttribute(String string2) {
        boolean bl2 = this.isStopped;
        if (bl2) {
            logger.error("Can't remove a attribute from a HttpMetric that's stopped.");
            return;
        }
        this.mAttributes.remove(string2);
    }

    public void setHttpResponseCode(int n10) {
        this.mMetricBuilder.setHttpResponseCode(n10);
    }

    public void setRequestPayloadSize(long l10) {
        this.mMetricBuilder.setRequestPayloadBytes(l10);
    }

    public void setResponseContentType(String string2) {
        this.mMetricBuilder.setResponseContentType(string2);
    }

    public void setResponsePayloadSize(long l10) {
        this.mMetricBuilder.setResponsePayloadBytes(l10);
    }

    public void start() {
        this.mTimer.reset();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mMetricBuilder;
        long l10 = this.mTimer.getMicros();
        networkRequestMetricBuilder.setRequestStartTimeMicros(l10);
    }

    public void stop() {
        boolean bl2 = this.isDisabled;
        if (bl2) {
            return;
        }
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mMetricBuilder;
        long l10 = this.mTimer.getDurationMicros();
        networkRequestMetricBuilder = networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l10);
        Map map = this.mAttributes;
        networkRequestMetricBuilder.setCustomAttributes(map).build();
        this.isStopped = true;
    }
}


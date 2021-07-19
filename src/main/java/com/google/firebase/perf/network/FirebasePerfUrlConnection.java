/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.network.InstrHttpURLConnection;
import com.google.firebase.perf.network.InstrHttpsURLConnection;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.URLWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class FirebasePerfUrlConnection {
    private FirebasePerfUrlConnection() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object getContent(URLWrapper object, TransportManager appStateMonitor$AppStateCallback, Timer timer) {
        URLConnection uRLConnection;
        timer.reset();
        long l10 = timer.getMicros();
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            uRLConnection = ((URLWrapper)object).openConnection();
        }
        catch (IOException iOException) {
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            l10 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l10);
            object = ((URLWrapper)object).toString();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
        boolean bl2 = uRLConnection instanceof HttpsURLConnection;
        if (bl2) {
            uRLConnection = (HttpsURLConnection)uRLConnection;
            InstrHttpsURLConnection instrHttpsURLConnection = new InstrHttpsURLConnection((HttpsURLConnection)uRLConnection, timer, (NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            return instrHttpsURLConnection.getContent();
        }
        bl2 = uRLConnection instanceof HttpURLConnection;
        if (!bl2) return uRLConnection.getContent();
        uRLConnection = (HttpURLConnection)uRLConnection;
        InstrHttpURLConnection instrHttpURLConnection = new InstrHttpURLConnection((HttpURLConnection)uRLConnection, timer, (NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
        return instrHttpURLConnection.getContent();
    }

    public static Object getContent(URLWrapper object, Class[] classArray, TransportManager appStateMonitor$AppStateCallback, Timer timer) {
        URLConnection uRLConnection;
        timer.reset();
        long l10 = timer.getMicros();
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            uRLConnection = ((URLWrapper)object).openConnection();
        }
        catch (IOException iOException) {
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            l10 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l10);
            object = ((URLWrapper)object).toString();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
        boolean bl2 = uRLConnection instanceof HttpsURLConnection;
        if (bl2) {
            uRLConnection = (HttpsURLConnection)uRLConnection;
            InstrHttpsURLConnection instrHttpsURLConnection = new InstrHttpsURLConnection((HttpsURLConnection)uRLConnection, timer, (NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            return instrHttpsURLConnection.getContent(classArray);
        }
        bl2 = uRLConnection instanceof HttpURLConnection;
        if (bl2) {
            uRLConnection = (HttpURLConnection)uRLConnection;
            InstrHttpURLConnection instrHttpURLConnection = new InstrHttpURLConnection((HttpURLConnection)uRLConnection, timer, (NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            return instrHttpURLConnection.getContent(classArray);
        }
        return uRLConnection.getContent(classArray);
    }

    public static Object getContent(URL object) {
        URLWrapper uRLWrapper = new URLWrapper((URL)object);
        object = TransportManager.getInstance();
        Timer timer = new Timer();
        return FirebasePerfUrlConnection.getContent(uRLWrapper, (TransportManager)object, timer);
    }

    public static Object getContent(URL object, Class[] classArray) {
        URLWrapper uRLWrapper = new URLWrapper((URL)object);
        object = TransportManager.getInstance();
        Timer timer = new Timer();
        return FirebasePerfUrlConnection.getContent(uRLWrapper, classArray, (TransportManager)object, timer);
    }

    public static Object instrument(Object object) {
        boolean bl2 = object instanceof HttpsURLConnection;
        if (bl2) {
            object = (HttpsURLConnection)object;
            Timer timer = new Timer();
            NetworkRequestMetricBuilder networkRequestMetricBuilder = NetworkRequestMetricBuilder.builder(TransportManager.getInstance());
            InstrHttpsURLConnection instrHttpsURLConnection = new InstrHttpsURLConnection((HttpsURLConnection)object, timer, networkRequestMetricBuilder);
            return instrHttpsURLConnection;
        }
        bl2 = object instanceof HttpURLConnection;
        if (bl2) {
            object = (HttpURLConnection)object;
            Timer timer = new Timer();
            NetworkRequestMetricBuilder networkRequestMetricBuilder = NetworkRequestMetricBuilder.builder(TransportManager.getInstance());
            InstrHttpURLConnection instrHttpURLConnection = new InstrHttpURLConnection((HttpURLConnection)object, timer, networkRequestMetricBuilder);
            return instrHttpURLConnection;
        }
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static InputStream openStream(URLWrapper object, TransportManager appStateMonitor$AppStateCallback, Timer timer) {
        URLConnection uRLConnection;
        timer.reset();
        long l10 = timer.getMicros();
        appStateMonitor$AppStateCallback = NetworkRequestMetricBuilder.builder((TransportManager)appStateMonitor$AppStateCallback);
        try {
            uRLConnection = ((URLWrapper)object).openConnection();
        }
        catch (IOException iOException) {
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setRequestStartTimeMicros(l10);
            l10 = timer.getDurationMicros();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setTimeToResponseCompletedMicros(l10);
            object = ((URLWrapper)object).toString();
            ((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback).setUrl((String)object);
            NetworkRequestMetricBuilderUtil.logError((NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            throw iOException;
        }
        boolean bl2 = uRLConnection instanceof HttpsURLConnection;
        if (bl2) {
            uRLConnection = (HttpsURLConnection)uRLConnection;
            InstrHttpsURLConnection instrHttpsURLConnection = new InstrHttpsURLConnection((HttpsURLConnection)uRLConnection, timer, (NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
            return instrHttpsURLConnection.getInputStream();
        }
        bl2 = uRLConnection instanceof HttpURLConnection;
        if (!bl2) return uRLConnection.getInputStream();
        uRLConnection = (HttpURLConnection)uRLConnection;
        InstrHttpURLConnection instrHttpURLConnection = new InstrHttpURLConnection((HttpURLConnection)uRLConnection, timer, (NetworkRequestMetricBuilder)appStateMonitor$AppStateCallback);
        return instrHttpURLConnection.getInputStream();
    }

    public static InputStream openStream(URL object) {
        URLWrapper uRLWrapper = new URLWrapper((URL)object);
        object = TransportManager.getInstance();
        Timer timer = new Timer();
        return FirebasePerfUrlConnection.openStream(uRLWrapper, (TransportManager)object, timer);
    }
}


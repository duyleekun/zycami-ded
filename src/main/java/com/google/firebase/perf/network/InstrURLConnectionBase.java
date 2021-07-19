/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.google.firebase.perf.network;

import android.os.Build;
import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.network.InstrHttpInputStream;
import com.google.firebase.perf.network.InstrHttpOutputStream;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import java.util.Map;

public class InstrURLConnectionBase {
    private static final String USER_AGENT_PROPERTY = "User-Agent";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final NetworkRequestMetricBuilder mBuilder;
    private final HttpURLConnection mHttpUrlConnection;
    private long mTimeRequested;
    private long mTimeToResponseInitiated;
    private final Timer mTimer;

    public InstrURLConnectionBase(HttpURLConnection object, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        long l10;
        this.mTimeRequested = l10 = (long)-1;
        this.mTimeToResponseInitiated = l10;
        this.mHttpUrlConnection = object;
        this.mBuilder = networkRequestMetricBuilder;
        this.mTimer = timer;
        object = ((URLConnection)object).getURL().toString();
        networkRequestMetricBuilder.setUrl((String)object);
    }

    private void updateRequestInfo() {
        Object object;
        long l10 = this.mTimeRequested;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.mTimer.reset();
            object = this.mTimer;
            this.mTimeRequested = l10 = ((Timer)object).getMicros();
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            networkRequestMetricBuilder.setRequestStartTimeMicros(l10);
        }
        if ((object = this.getRequestMethod()) != null) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            networkRequestMetricBuilder.setHttpMethod((String)object);
        } else {
            object2 = this.getDoOutput();
            if (object2 != false) {
                object = this.mBuilder;
                String string2 = "POST";
                ((NetworkRequestMetricBuilder)object).setHttpMethod(string2);
            } else {
                object = this.mBuilder;
                String string3 = "GET";
                ((NetworkRequestMetricBuilder)object).setHttpMethod(string3);
            }
        }
    }

    public void addRequestProperty(String string2, String string3) {
        this.mHttpUrlConnection.addRequestProperty(string2, string3);
    }

    public void connect() {
        Object object;
        long l10 = this.mTimeRequested;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.mTimer.reset();
            object = this.mTimer;
            this.mTimeRequested = l10 = ((Timer)object).getMicros();
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            networkRequestMetricBuilder.setRequestStartTimeMicros(l10);
        }
        try {
            object = this.mHttpUrlConnection;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            l11 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        ((URLConnection)object).connect();
    }

    public void disconnect() {
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
        long l10 = this.mTimer.getDurationMicros();
        networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l10);
        this.mBuilder.build();
        this.mHttpUrlConnection.disconnect();
    }

    public boolean equals(Object object) {
        return this.mHttpUrlConnection.equals(object);
    }

    public boolean getAllowUserInteraction() {
        return this.mHttpUrlConnection.getAllowUserInteraction();
    }

    public int getConnectTimeout() {
        return this.mHttpUrlConnection.getConnectTimeout();
    }

    public Object getContent() {
        this.updateRequestInfo();
        Object object = this.mBuilder;
        Object object2 = this.mHttpUrlConnection;
        int n10 = ((HttpURLConnection)object2).getResponseCode();
        ((NetworkRequestMetricBuilder)object).setHttpResponseCode(n10);
        try {
            object = this.mHttpUrlConnection;
        }
        catch (IOException iOException) {
            object2 = this.mBuilder;
            long l10 = this.mTimer.getDurationMicros();
            ((NetworkRequestMetricBuilder)object2).setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        object = ((URLConnection)object).getContent();
        n10 = object instanceof InputStream;
        if (n10 != 0) {
            object2 = this.mBuilder;
            Object object3 = this.mHttpUrlConnection.getContentType();
            ((NetworkRequestMetricBuilder)object2).setResponseContentType((String)object3);
            object = (InputStream)object;
            object3 = this.mBuilder;
            Timer timer = this.mTimer;
            object = object2 = new InstrHttpInputStream((InputStream)object, (NetworkRequestMetricBuilder)object3, timer);
        } else {
            object2 = this.mBuilder;
            Object object4 = this.mHttpUrlConnection.getContentType();
            ((NetworkRequestMetricBuilder)object2).setResponseContentType((String)object4);
            object2 = this.mBuilder;
            int n11 = this.mHttpUrlConnection.getContentLength();
            long l11 = n11;
            ((NetworkRequestMetricBuilder)object2).setResponsePayloadBytes(l11);
            object2 = this.mBuilder;
            object4 = this.mTimer;
            l11 = ((Timer)object4).getDurationMicros();
            ((NetworkRequestMetricBuilder)object2).setTimeToResponseCompletedMicros(l11);
            object2 = this.mBuilder;
            ((NetworkRequestMetricBuilder)object2).build();
        }
        return object;
    }

    public Object getContent(Class[] object) {
        this.updateRequestInfo();
        Object object2 = this.mBuilder;
        Object object3 = this.mHttpUrlConnection;
        int n10 = ((HttpURLConnection)object3).getResponseCode();
        ((NetworkRequestMetricBuilder)object2).setHttpResponseCode(n10);
        try {
            object2 = this.mHttpUrlConnection;
        }
        catch (IOException iOException) {
            object2 = this.mBuilder;
            long l10 = this.mTimer.getDurationMicros();
            ((NetworkRequestMetricBuilder)object2).setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        object = ((URLConnection)object2).getContent((Class<?>[])object);
        boolean bl2 = object instanceof InputStream;
        if (bl2) {
            object2 = this.mBuilder;
            object3 = this.mHttpUrlConnection.getContentType();
            ((NetworkRequestMetricBuilder)object2).setResponseContentType((String)object3);
            object = (InputStream)object;
            object3 = this.mBuilder;
            Timer timer = this.mTimer;
            object2 = new InstrHttpInputStream((InputStream)object, (NetworkRequestMetricBuilder)object3, timer);
            object = object2;
        } else {
            object2 = this.mBuilder;
            object3 = this.mHttpUrlConnection.getContentType();
            ((NetworkRequestMetricBuilder)object2).setResponseContentType((String)object3);
            object2 = this.mBuilder;
            n10 = this.mHttpUrlConnection.getContentLength();
            long l11 = n10;
            ((NetworkRequestMetricBuilder)object2).setResponsePayloadBytes(l11);
            object2 = this.mBuilder;
            object3 = this.mTimer;
            l11 = ((Timer)object3).getDurationMicros();
            ((NetworkRequestMetricBuilder)object2).setTimeToResponseCompletedMicros(l11);
            object2 = this.mBuilder;
            ((NetworkRequestMetricBuilder)object2).build();
        }
        return object;
    }

    public String getContentEncoding() {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getContentEncoding();
    }

    public int getContentLength() {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getContentLength();
    }

    public long getContentLengthLong() {
        long l10;
        this.updateRequestInfo();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            HttpURLConnection httpURLConnection = this.mHttpUrlConnection;
            l10 = httpURLConnection.getContentLengthLong();
        } else {
            l10 = 0L;
        }
        return l10;
    }

    public String getContentType() {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getContentType();
    }

    public long getDate() {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.mHttpUrlConnection.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.mHttpUrlConnection.getDoInput();
    }

    public boolean getDoOutput() {
        return this.mHttpUrlConnection.getDoOutput();
    }

    public InputStream getErrorStream() {
        this.updateRequestInfo();
        Object object = this.mBuilder;
        Object object2 = this.mHttpUrlConnection;
        int n10 = ((HttpURLConnection)object2).getResponseCode();
        try {
            ((NetworkRequestMetricBuilder)object).setHttpResponseCode(n10);
        }
        catch (IOException iOException) {
            object = logger;
            object2 = "IOException thrown trying to obtain the response code";
            ((AndroidLogger)object).debug((String)object2);
        }
        object = this.mHttpUrlConnection.getErrorStream();
        if (object != null) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            Timer timer = this.mTimer;
            object2 = new InstrHttpInputStream((InputStream)object, networkRequestMetricBuilder, timer);
            return object2;
        }
        return object;
    }

    public long getExpiration() {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getExpiration();
    }

    public String getHeaderField(int n10) {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderField(n10);
    }

    public String getHeaderField(String string2) {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderField(string2);
    }

    public long getHeaderFieldDate(String string2, long l10) {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderFieldDate(string2, l10);
    }

    public int getHeaderFieldInt(String string2, int n10) {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderFieldInt(string2, n10);
    }

    public String getHeaderFieldKey(int n10) {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderFieldKey(n10);
    }

    public long getHeaderFieldLong(String string2, long l10) {
        long l11;
        this.updateRequestInfo();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            HttpURLConnection httpURLConnection = this.mHttpUrlConnection;
            l11 = httpURLConnection.getHeaderFieldLong(string2, l10);
        } else {
            l11 = 0L;
        }
        return l11;
    }

    public Map getHeaderFields() {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getHeaderFields();
    }

    public long getIfModifiedSince() {
        return this.mHttpUrlConnection.getIfModifiedSince();
    }

    public InputStream getInputStream() {
        this.updateRequestInfo();
        Object object = this.mBuilder;
        int n10 = this.mHttpUrlConnection.getResponseCode();
        ((NetworkRequestMetricBuilder)object).setHttpResponseCode(n10);
        object = this.mBuilder;
        Object object2 = this.mHttpUrlConnection.getContentType();
        ((NetworkRequestMetricBuilder)object).setResponseContentType((String)object2);
        try {
            object = this.mHttpUrlConnection;
        }
        catch (IOException iOException) {
            object2 = this.mBuilder;
            long l10 = this.mTimer.getDurationMicros();
            ((NetworkRequestMetricBuilder)object2).setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        object = ((URLConnection)object).getInputStream();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
        Timer timer = this.mTimer;
        object2 = new InstrHttpInputStream((InputStream)object, networkRequestMetricBuilder, timer);
        return object2;
    }

    public boolean getInstanceFollowRedirects() {
        return this.mHttpUrlConnection.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        this.updateRequestInfo();
        return this.mHttpUrlConnection.getLastModified();
    }

    public OutputStream getOutputStream() {
        Object object;
        try {
            object = this.mHttpUrlConnection;
        }
        catch (IOException iOException) {
            object = this.mBuilder;
            long l10 = this.mTimer.getDurationMicros();
            ((NetworkRequestMetricBuilder)object).setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        object = ((URLConnection)object).getOutputStream();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
        Timer timer = this.mTimer;
        InstrHttpOutputStream instrHttpOutputStream = new InstrHttpOutputStream((OutputStream)object, networkRequestMetricBuilder, timer);
        return instrHttpOutputStream;
    }

    public Permission getPermission() {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = this.mHttpUrlConnection;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            long l10 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        return httpURLConnection.getPermission();
    }

    public int getReadTimeout() {
        return this.mHttpUrlConnection.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.mHttpUrlConnection.getRequestMethod();
    }

    public Map getRequestProperties() {
        return this.mHttpUrlConnection.getRequestProperties();
    }

    public String getRequestProperty(String string2) {
        return this.mHttpUrlConnection.getRequestProperty(string2);
    }

    public int getResponseCode() {
        NetworkRequestMetricBuilder networkRequestMetricBuilder;
        Object object;
        this.updateRequestInfo();
        long l10 = this.mTimeToResponseInitiated;
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            object = this.mTimer;
            this.mTimeToResponseInitiated = l10 = ((Timer)object).getDurationMicros();
            NetworkRequestMetricBuilder networkRequestMetricBuilder2 = this.mBuilder;
            networkRequestMetricBuilder2.setTimeToResponseInitiatedMicros(l10);
        }
        try {
            object = this.mHttpUrlConnection;
        }
        catch (IOException iOException) {
            networkRequestMetricBuilder = this.mBuilder;
            l11 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        l12 = ((HttpURLConnection)object).getResponseCode();
        networkRequestMetricBuilder = this.mBuilder;
        networkRequestMetricBuilder.setHttpResponseCode((int)l12);
        return (int)l12;
    }

    public String getResponseMessage() {
        NetworkRequestMetricBuilder networkRequestMetricBuilder;
        Object object;
        Object object2;
        this.updateRequestInfo();
        long l10 = this.mTimeToResponseInitiated;
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            object2 = this.mTimer;
            this.mTimeToResponseInitiated = l10 = ((Timer)object2).getDurationMicros();
            object = this.mBuilder;
            ((NetworkRequestMetricBuilder)object).setTimeToResponseInitiatedMicros(l10);
        }
        try {
            object2 = this.mHttpUrlConnection;
        }
        catch (IOException iOException) {
            networkRequestMetricBuilder = this.mBuilder;
            l11 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        object2 = ((HttpURLConnection)object2).getResponseMessage();
        networkRequestMetricBuilder = this.mBuilder;
        object = this.mHttpUrlConnection;
        int n10 = ((HttpURLConnection)object).getResponseCode();
        networkRequestMetricBuilder.setHttpResponseCode(n10);
        return object2;
    }

    public URL getURL() {
        return this.mHttpUrlConnection.getURL();
    }

    public boolean getUseCaches() {
        return this.mHttpUrlConnection.getUseCaches();
    }

    public int hashCode() {
        return this.mHttpUrlConnection.hashCode();
    }

    public void setAllowUserInteraction(boolean bl2) {
        this.mHttpUrlConnection.setAllowUserInteraction(bl2);
    }

    public void setChunkedStreamingMode(int n10) {
        this.mHttpUrlConnection.setChunkedStreamingMode(n10);
    }

    public void setConnectTimeout(int n10) {
        this.mHttpUrlConnection.setConnectTimeout(n10);
    }

    public void setDefaultUseCaches(boolean bl2) {
        this.mHttpUrlConnection.setDefaultUseCaches(bl2);
    }

    public void setDoInput(boolean bl2) {
        this.mHttpUrlConnection.setDoInput(bl2);
    }

    public void setDoOutput(boolean bl2) {
        this.mHttpUrlConnection.setDoOutput(bl2);
    }

    public void setFixedLengthStreamingMode(int n10) {
        this.mHttpUrlConnection.setFixedLengthStreamingMode(n10);
    }

    public void setFixedLengthStreamingMode(long l10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            HttpURLConnection httpURLConnection = this.mHttpUrlConnection;
            httpURLConnection.setFixedLengthStreamingMode(l10);
        }
    }

    public void setIfModifiedSince(long l10) {
        this.mHttpUrlConnection.setIfModifiedSince(l10);
    }

    public void setInstanceFollowRedirects(boolean bl2) {
        this.mHttpUrlConnection.setInstanceFollowRedirects(bl2);
    }

    public void setReadTimeout(int n10) {
        this.mHttpUrlConnection.setReadTimeout(n10);
    }

    public void setRequestMethod(String string2) {
        this.mHttpUrlConnection.setRequestMethod(string2);
    }

    public void setRequestProperty(String string2, String string3) {
        Object object = USER_AGENT_PROPERTY;
        boolean bl2 = ((String)object).equalsIgnoreCase(string2);
        if (bl2) {
            object = this.mBuilder;
            ((NetworkRequestMetricBuilder)object).setUserAgent(string3);
        }
        this.mHttpUrlConnection.setRequestProperty(string2, string3);
    }

    public void setUseCaches(boolean bl2) {
        this.mHttpUrlConnection.setUseCaches(bl2);
    }

    public String toString() {
        return this.mHttpUrlConnection.toString();
    }

    public boolean usingProxy() {
        return this.mHttpUrlConnection.usingProxy();
    }
}


/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.network.InstrURLConnectionBase;
import com.google.firebase.perf.util.Timer;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class InstrHttpsURLConnection
extends HttpsURLConnection {
    private final InstrURLConnectionBase mDelegate;
    private final HttpsURLConnection mHttpsURLConnection;

    public InstrHttpsURLConnection(HttpsURLConnection httpsURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        Object object = httpsURLConnection.getURL();
        super((URL)object);
        this.mHttpsURLConnection = httpsURLConnection;
        this.mDelegate = object = new InstrURLConnectionBase(httpsURLConnection, timer, networkRequestMetricBuilder);
    }

    public void addRequestProperty(String string2, String string3) {
        this.mDelegate.addRequestProperty(string2, string3);
    }

    public void connect() {
        this.mDelegate.connect();
    }

    public void disconnect() {
        this.mDelegate.disconnect();
    }

    public boolean equals(Object object) {
        return this.mDelegate.equals(object);
    }

    public boolean getAllowUserInteraction() {
        return this.mDelegate.getAllowUserInteraction();
    }

    public String getCipherSuite() {
        return this.mHttpsURLConnection.getCipherSuite();
    }

    public int getConnectTimeout() {
        return this.mDelegate.getConnectTimeout();
    }

    public Object getContent() {
        return this.mDelegate.getContent();
    }

    public Object getContent(Class[] classArray) {
        return this.mDelegate.getContent(classArray);
    }

    public String getContentEncoding() {
        return this.mDelegate.getContentEncoding();
    }

    public int getContentLength() {
        return this.mDelegate.getContentLength();
    }

    public long getContentLengthLong() {
        return this.mDelegate.getContentLengthLong();
    }

    public String getContentType() {
        return this.mDelegate.getContentType();
    }

    public long getDate() {
        return this.mDelegate.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.mDelegate.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.mDelegate.getDoInput();
    }

    public boolean getDoOutput() {
        return this.mDelegate.getDoOutput();
    }

    public InputStream getErrorStream() {
        return this.mDelegate.getErrorStream();
    }

    public long getExpiration() {
        return this.mDelegate.getExpiration();
    }

    public String getHeaderField(int n10) {
        return this.mDelegate.getHeaderField(n10);
    }

    public String getHeaderField(String string2) {
        return this.mDelegate.getHeaderField(string2);
    }

    public long getHeaderFieldDate(String string2, long l10) {
        return this.mDelegate.getHeaderFieldDate(string2, l10);
    }

    public int getHeaderFieldInt(String string2, int n10) {
        return this.mDelegate.getHeaderFieldInt(string2, n10);
    }

    public String getHeaderFieldKey(int n10) {
        return this.mDelegate.getHeaderFieldKey(n10);
    }

    public long getHeaderFieldLong(String string2, long l10) {
        return this.mDelegate.getHeaderFieldLong(string2, l10);
    }

    public Map getHeaderFields() {
        return this.mDelegate.getHeaderFields();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.mHttpsURLConnection.getHostnameVerifier();
    }

    public long getIfModifiedSince() {
        return this.mDelegate.getIfModifiedSince();
    }

    public InputStream getInputStream() {
        return this.mDelegate.getInputStream();
    }

    public boolean getInstanceFollowRedirects() {
        return this.mDelegate.getInstanceFollowRedirects();
    }

    public long getLastModified() {
        return this.mDelegate.getLastModified();
    }

    public Certificate[] getLocalCertificates() {
        return this.mHttpsURLConnection.getLocalCertificates();
    }

    public Principal getLocalPrincipal() {
        return this.mHttpsURLConnection.getLocalPrincipal();
    }

    public OutputStream getOutputStream() {
        return this.mDelegate.getOutputStream();
    }

    public Principal getPeerPrincipal() {
        return this.mHttpsURLConnection.getPeerPrincipal();
    }

    public Permission getPermission() {
        return this.mDelegate.getPermission();
    }

    public int getReadTimeout() {
        return this.mDelegate.getReadTimeout();
    }

    public String getRequestMethod() {
        return this.mDelegate.getRequestMethod();
    }

    public Map getRequestProperties() {
        return this.mDelegate.getRequestProperties();
    }

    public String getRequestProperty(String string2) {
        return this.mDelegate.getRequestProperty(string2);
    }

    public int getResponseCode() {
        return this.mDelegate.getResponseCode();
    }

    public String getResponseMessage() {
        return this.mDelegate.getResponseMessage();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.mHttpsURLConnection.getSSLSocketFactory();
    }

    public Certificate[] getServerCertificates() {
        return this.mHttpsURLConnection.getServerCertificates();
    }

    public URL getURL() {
        return this.mDelegate.getURL();
    }

    public boolean getUseCaches() {
        return this.mDelegate.getUseCaches();
    }

    public int hashCode() {
        return this.mDelegate.hashCode();
    }

    public void setAllowUserInteraction(boolean bl2) {
        this.mDelegate.setAllowUserInteraction(bl2);
    }

    public void setChunkedStreamingMode(int n10) {
        this.mDelegate.setChunkedStreamingMode(n10);
    }

    public void setConnectTimeout(int n10) {
        this.mDelegate.setConnectTimeout(n10);
    }

    public void setDefaultUseCaches(boolean bl2) {
        this.mDelegate.setDefaultUseCaches(bl2);
    }

    public void setDoInput(boolean bl2) {
        this.mDelegate.setDoInput(bl2);
    }

    public void setDoOutput(boolean bl2) {
        this.mDelegate.setDoOutput(bl2);
    }

    public void setFixedLengthStreamingMode(int n10) {
        this.mDelegate.setFixedLengthStreamingMode(n10);
    }

    public void setFixedLengthStreamingMode(long l10) {
        this.mDelegate.setFixedLengthStreamingMode(l10);
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.mHttpsURLConnection.setHostnameVerifier(hostnameVerifier);
    }

    public void setIfModifiedSince(long l10) {
        this.mDelegate.setIfModifiedSince(l10);
    }

    public void setInstanceFollowRedirects(boolean bl2) {
        this.mDelegate.setInstanceFollowRedirects(bl2);
    }

    public void setReadTimeout(int n10) {
        this.mDelegate.setReadTimeout(n10);
    }

    public void setRequestMethod(String string2) {
        this.mDelegate.setRequestMethod(string2);
    }

    public void setRequestProperty(String string2, String string3) {
        this.mDelegate.setRequestProperty(string2, string3);
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.mHttpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
    }

    public void setUseCaches(boolean bl2) {
        this.mDelegate.setUseCaches(bl2);
    }

    public String toString() {
        return this.mDelegate.toString();
    }

    public boolean usingProxy() {
        return this.mDelegate.usingProxy();
    }
}


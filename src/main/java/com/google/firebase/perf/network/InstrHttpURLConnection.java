/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.network.InstrURLConnectionBase;
import com.google.firebase.perf.util.Timer;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Permission;
import java.util.Map;

public final class InstrHttpURLConnection
extends HttpURLConnection {
    private final InstrURLConnectionBase mDelegate;

    public InstrHttpURLConnection(HttpURLConnection httpURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        Object object = httpURLConnection.getURL();
        super((URL)object);
        this.mDelegate = object = new InstrURLConnectionBase(httpURLConnection, timer, networkRequestMetricBuilder);
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

    public OutputStream getOutputStream() {
        return this.mDelegate.getOutputStream();
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


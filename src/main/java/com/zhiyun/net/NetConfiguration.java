/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net;

import com.zhiyun.net.ChangeHostInterceptor;
import com.zhiyun.net.RequestInterceptor;
import com.zhiyun.net.TimeoutInterceptor;
import g.u;
import java.util.HashMap;
import java.util.Map;

public class NetConfiguration {
    public static final String HEADER_BASE_URL = "base_url";
    public static final String HEADER_BASE_URL_SEMICOLON = ":";
    public static final String HEADER_STATIC = "static:host";
    public static final String HEADER_TIMEOUT = "timeout:";
    public static final String HEADER_TIMEOUT_KEY = "timeout";
    private static volatile NetConfiguration sNetConfiguration;
    private String mAppVersion;
    private TimeoutInterceptor mChangeTimeoutInterceptor;
    private String mEnv;
    private String mHost = "http://172.16.2.101:3000/v1/";
    private ChangeHostInterceptor mHostInterceptor;
    private boolean mLogEnable = true;
    private u mLogInterceptor;
    private Map mOtherHost;
    private RequestInterceptor mRequestInterceptor;
    private long mTimeout = 15000L;
    private String mZyProduction;

    private NetConfiguration() {
        HashMap hashMap = new HashMap();
        this.mLogInterceptor = hashMap;
        this.mChangeTimeoutInterceptor = hashMap;
        this.mOtherHost = hashMap = new HashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static NetConfiguration create() {
        Object object = sNetConfiguration;
        if (object != null) return sNetConfiguration;
        object = NetConfiguration.class;
        synchronized (object) {
            NetConfiguration netConfiguration = sNetConfiguration;
            if (netConfiguration != null) return sNetConfiguration;
            sNetConfiguration = netConfiguration = new NetConfiguration();
            return sNetConfiguration;
        }
    }

    public NetConfiguration addOtherHost(String string2, String string3) {
        this.mOtherHost.put(string2, string3);
        return sNetConfiguration;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public u getChangeTimeoutInterceptor() {
        return this.mChangeTimeoutInterceptor;
    }

    public String getEnv() {
        return this.mEnv;
    }

    public String getHost() {
        return this.mHost;
    }

    public ChangeHostInterceptor getHostInterceptor() {
        return this.mHostInterceptor;
    }

    public u getLogInterceptor() {
        return this.mLogInterceptor;
    }

    public Map getOtherHost() {
        return this.mOtherHost;
    }

    public u getRequestInterceptor() {
        RequestInterceptor requestInterceptor = this.mRequestInterceptor;
        if (requestInterceptor == null) {
            String string2 = this.mEnv;
            String string3 = this.mZyProduction;
            String string4 = this.mAppVersion;
            this.mRequestInterceptor = requestInterceptor = new RequestInterceptor(string2, string3, string4);
        }
        return this.mRequestInterceptor;
    }

    public long getTimeout() {
        return this.mTimeout;
    }

    public String getZyProduction() {
        return this.mZyProduction;
    }

    public boolean isLogEnable() {
        return this.mLogEnable;
    }

    public void removeOtherHost(String string2) {
        this.mOtherHost.remove(string2);
    }

    public NetConfiguration setAppVersion(String string2) {
        this.mAppVersion = string2;
        return sNetConfiguration;
    }

    public NetConfiguration setEnv(String string2) {
        this.mEnv = string2;
        RequestInterceptor requestInterceptor = this.mRequestInterceptor;
        if (requestInterceptor != null) {
            requestInterceptor.setEnv(string2);
        }
        return sNetConfiguration;
    }

    public NetConfiguration setHost(String string2) {
        this.mHost = string2;
        ChangeHostInterceptor changeHostInterceptor = this.mHostInterceptor;
        if (changeHostInterceptor != null) {
            changeHostInterceptor.setHost(string2);
        }
        return sNetConfiguration;
    }

    public NetConfiguration setHostInterceptor(ChangeHostInterceptor changeHostInterceptor) {
        this.mHostInterceptor = changeHostInterceptor;
        if (changeHostInterceptor != null) {
            String string2 = this.mHost;
            changeHostInterceptor.setHost(string2);
        }
        return sNetConfiguration;
    }

    public NetConfiguration setLogEnable(boolean bl2) {
        this.mLogEnable = bl2;
        return sNetConfiguration;
    }

    public NetConfiguration setLogInterceptor(u u10) {
        this.mLogInterceptor = u10;
        return sNetConfiguration;
    }

    public NetConfiguration setTimeout(long l10) {
        this.mTimeout = l10;
        return sNetConfiguration;
    }

    public NetConfiguration setZyProduction(String string2) {
        this.mZyProduction = string2;
        return sNetConfiguration;
    }
}


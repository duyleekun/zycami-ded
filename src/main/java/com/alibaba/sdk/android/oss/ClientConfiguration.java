/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ClientConfiguration {
    private static final int DEFAULT_MAX_RETRIES = 2;
    private boolean checkCRC64;
    private int connectionTimeout;
    private List customCnameExcludeList;
    private boolean httpDnsEnable;
    private String ipWithHeader;
    private String mUserAgentMark;
    private int maxConcurrentRequest = 5;
    private int maxErrorRetry;
    private long max_log_size;
    private String proxyHost;
    private int proxyPort;
    private int socketTimeout;

    public ClientConfiguration() {
        ArrayList arrayList;
        int n10;
        this.socketTimeout = n10 = 60000;
        this.connectionTimeout = n10;
        this.max_log_size = 0x500000L;
        this.maxErrorRetry = 2;
        this.customCnameExcludeList = arrayList = new ArrayList();
        this.httpDnsEnable = true;
        this.checkCRC64 = false;
    }

    public static ClientConfiguration getDefaultConf() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        return clientConfiguration;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public List getCustomCnameExcludeList() {
        return Collections.unmodifiableList(this.customCnameExcludeList);
    }

    public String getCustomUserMark() {
        return this.mUserAgentMark;
    }

    public String getIpWithHeader() {
        return this.ipWithHeader;
    }

    public int getMaxConcurrentRequest() {
        return this.maxConcurrentRequest;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public long getMaxLogSize() {
        return this.max_log_size;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public boolean isCheckCRC64() {
        return this.checkCRC64;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public void setCheckCRC64(boolean bl2) {
        this.checkCRC64 = bl2;
    }

    public void setConnectionTimeout(int n10) {
        this.connectionTimeout = n10;
    }

    public void setCustomCnameExcludeList(List iterator2) {
        int n10;
        if (iterator2 != null && (n10 = iterator2.size()) != 0) {
            Object object = this.customCnameExcludeList;
            object.clear();
            iterator2 = iterator2.iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                Object object2;
                object = (String)iterator2.next();
                boolean bl2 = ((String)object).contains((CharSequence)(object2 = "://"));
                if (bl2) {
                    List list = this.customCnameExcludeList;
                    int n11 = ((String)object).indexOf((String)object2) + 3;
                    object = ((String)object).substring(n11);
                    list.add(object);
                    continue;
                }
                object2 = this.customCnameExcludeList;
                object2.add(object);
            }
            return;
        }
        iterator2 = new Iterator("cname exclude list should not be null.");
        throw iterator2;
    }

    public void setHttpDnsEnable(boolean bl2) {
        this.httpDnsEnable = bl2;
    }

    public void setIpWithHeader(String string2) {
        this.ipWithHeader = string2;
    }

    public void setMaxConcurrentRequest(int n10) {
        this.maxConcurrentRequest = n10;
    }

    public void setMaxErrorRetry(int n10) {
        this.maxErrorRetry = n10;
    }

    public void setMaxLogSize(long l10) {
        this.max_log_size = l10;
    }

    public void setProxyHost(String string2) {
        this.proxyHost = string2;
    }

    public void setProxyPort(int n10) {
        this.proxyPort = n10;
    }

    public void setSocketTimeout(int n10) {
        this.socketTimeout = n10;
    }

    public void setUserAgentMark(String string2) {
        this.mUserAgentMark = string2;
    }
}


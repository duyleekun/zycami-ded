/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.utils;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.HttpdnsMini$HostObject;
import com.alibaba.sdk.android.oss.common.utils.HttpdnsMini$QueryHostTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpdnsMini {
    private static final String ACCOUNT_ID = "181345";
    private static final int EMPTY_RESULT_HOST_TTL = 30;
    private static final int MAX_HOLD_HOST_NUM = 100;
    private static final int MAX_THREAD_NUM = 5;
    private static final int RESOLVE_TIMEOUT_IN_SEC = 10;
    private static final String SERVER_IP = "203.107.1.1";
    private static final String TAG = "HttpDnsMini";
    private static HttpdnsMini instance;
    private ConcurrentMap hostManager;
    private ExecutorService pool;

    private HttpdnsMini() {
        Object object = new ConcurrentHashMap();
        this.hostManager = object;
        this.pool = object = Executors.newFixedThreadPool(5);
    }

    public static /* synthetic */ ConcurrentMap access$000(HttpdnsMini httpdnsMini) {
        return httpdnsMini.hostManager;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HttpdnsMini getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = HttpdnsMini.class;
        synchronized (object) {
            HttpdnsMini httpdnsMini = instance;
            if (httpdnsMini != null) return instance;
            instance = httpdnsMini = new HttpdnsMini();
            return instance;
        }
    }

    public String getIpByHostAsync(String string2) {
        boolean bl2;
        HttpdnsMini$HostObject httpdnsMini$HostObject = (HttpdnsMini$HostObject)this.hostManager.get(string2);
        if (httpdnsMini$HostObject == null || (bl2 = httpdnsMini$HostObject.isExpired())) {
            Object object = new StringBuilder();
            ((StringBuilder)object).append("[httpdnsmini] - refresh host: ");
            ((StringBuilder)object).append(string2);
            OSSLog.logDebug(((StringBuilder)object).toString());
            object = this.pool;
            HttpdnsMini$QueryHostTask httpdnsMini$QueryHostTask = new HttpdnsMini$QueryHostTask(this, string2);
            object.submit(httpdnsMini$QueryHostTask);
        }
        string2 = null;
        if (httpdnsMini$HostObject != null && (bl2 = httpdnsMini$HostObject.isStillAvailable())) {
            string2 = httpdnsMini$HostObject.getIp();
        }
        return string2;
    }
}


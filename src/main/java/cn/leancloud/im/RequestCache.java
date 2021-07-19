/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVLogger;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.utils.LogUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestCache {
    private static final String KEY_FORMAT = "%s/%s/%d";
    private static final AVLogger LOGGER;
    public static final RequestCache instance;
    private Map requests;

    static {
        RequestCache requestCache;
        LOGGER = LogUtil.getLogger(RequestCache.class);
        instance = requestCache = new RequestCache();
    }

    private RequestCache() {
        ConcurrentHashMap concurrentHashMap;
        this.requests = concurrentHashMap = new ConcurrentHashMap();
    }

    private String getCacheKey(String object, String string2, int n10) {
        Object[] objectArray = new Object[]{object, string2, object = Integer.valueOf(n10)};
        return String.format(KEY_FORMAT, objectArray);
    }

    public static RequestCache getInstance() {
        return instance;
    }

    public void addRequestCallback(String string2, String string3, int n10, AVCallback object) {
        CharSequence charSequence = this.getCacheKey(string2, string3, n10);
        this.requests.put(charSequence, object);
        object = LOGGER;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("add request cache. client=");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(", conv=");
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(", request=");
        ((StringBuilder)charSequence).append(n10);
        string2 = ((StringBuilder)charSequence).toString();
        ((AVLogger)object).d(string2);
    }

    public void cleanRequestCallback(String string2, String string3, int n10) {
        string2 = this.getCacheKey(string2, string3, n10);
        this.requests.remove(string2);
    }

    public AVCallback getRequestCallback(String string2, String string3, int n10) {
        string2 = this.getCacheKey(string2, string3, n10);
        return (AVCallback)this.requests.get(string2);
    }
}


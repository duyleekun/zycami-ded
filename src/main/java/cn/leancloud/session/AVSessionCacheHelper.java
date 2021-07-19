/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVLogger;
import cn.leancloud.session.AVSessionCacheHelper$SessionTagCache;
import cn.leancloud.utils.LogUtil;

public class AVSessionCacheHelper {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVSessionCacheHelper.class);
    private static final String SESSION_KEY = "sessionids";
    private static AVSessionCacheHelper$SessionTagCache tagCacheInstance;

    public static /* synthetic */ AVLogger access$100() {
        return LOGGER;
    }

    public static AVSessionCacheHelper$SessionTagCache getTagCacheInstance() {
        Class<AVSessionCacheHelper> clazz = AVSessionCacheHelper.class;
        synchronized (clazz) {
            AVSessionCacheHelper$SessionTagCache aVSessionCacheHelper$SessionTagCache = tagCacheInstance;
            if (aVSessionCacheHelper$SessionTagCache == null) {
                tagCacheInstance = aVSessionCacheHelper$SessionTagCache = new AVSessionCacheHelper$SessionTagCache(null);
            }
            aVSessionCacheHelper$SessionTagCache = tagCacheInstance;
            return aVSessionCacheHelper$SessionTagCache;
        }
    }
}


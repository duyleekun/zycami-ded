/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.utils;

import cn.leancloud.AVLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogUtil {
    private static Map loggerCache;

    static {
        ConcurrentHashMap concurrentHashMap;
        loggerCache = concurrentHashMap = new ConcurrentHashMap();
    }

    public static AVLogger getLogger(Class object) {
        if (object == null) {
            return null;
        }
        Object object2 = loggerCache;
        Object object3 = ((Class)object).getCanonicalName();
        boolean bl2 = object2.containsKey(object3);
        if (bl2) {
            object2 = loggerCache;
            object = ((Class)object).getCanonicalName();
            return (AVLogger)object2.get(object);
        }
        object3 = ((Class)object).getSimpleName();
        object2 = new AVLogger((String)object3);
        object3 = loggerCache;
        object = ((Class)object).getCanonicalName();
        object3.put(object, object2);
        return object2;
    }
}


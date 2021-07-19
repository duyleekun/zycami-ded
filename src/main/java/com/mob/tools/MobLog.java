/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

import com.mob.tools.log.NLog;

public class MobLog {
    private static NLog logger;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static NLog getInstance() {
        Class<MobLog> clazz = MobLog.class;
        synchronized (clazz) {
            Object object = logger;
            if (object != null) return logger;
            object = "MOBSDK";
            logger = object = NLog.getInstance((String)object);
            return logger;
        }
    }
}


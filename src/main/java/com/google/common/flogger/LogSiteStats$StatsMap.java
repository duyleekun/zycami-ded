/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.LogSiteStats;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class LogSiteStats$StatsMap {
    private final ConcurrentMap statsMap;

    public LogSiteStats$StatsMap() {
        ConcurrentHashMap concurrentHashMap;
        this.statsMap = concurrentHashMap = new ConcurrentHashMap();
    }

    public LogSiteStats getStatsForKey(Object object) {
        ConcurrentMap concurrentMap;
        Object object2 = (LogSiteStats)this.statsMap.get(object);
        if (object2 == null && (object = (concurrentMap = this.statsMap).putIfAbsent(object, object2 = new LogSiteStats())) != null) {
            object2 = object;
        }
        return object2;
    }
}


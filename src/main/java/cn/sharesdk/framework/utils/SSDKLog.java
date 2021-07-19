/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils;

import cn.sharesdk.framework.ShareSDK;
import com.mob.commons.logcollector.DefaultLogsCollector;
import com.mob.tools.log.NLog;

public class SSDKLog {
    private static NLog a;

    public static NLog a() {
        String string2 = "SHARESDK";
        a = NLog.getInstance(string2);
        DefaultLogsCollector defaultLogsCollector = DefaultLogsCollector.get();
        int n10 = ShareSDK.SDK_VERSION_CODE;
        defaultLogsCollector.addSDK(string2, n10);
        return a;
    }

    public static NLog b() {
        NLog nLog = a;
        if (nLog == null) {
            SSDKLog.a();
        }
        return a;
    }
}


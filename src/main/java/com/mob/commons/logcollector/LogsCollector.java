/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.logcollector;

import com.mob.commons.logcollector.DefaultLogsCollector;
import com.mob.tools.log.LogCollector;
import com.mob.tools.proguard.ProtectedMemberKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;

public abstract class LogsCollector
implements LogCollector,
ProtectedMemberKeeper,
PublicMemberKeeper {
    public LogsCollector() {
        DefaultLogsCollector defaultLogsCollector = DefaultLogsCollector.get();
        String string2 = this.getSDKTag();
        int n10 = this.getSDKVersion();
        defaultLogsCollector.addSDK(string2, n10);
    }

    public abstract String getSDKTag();

    public abstract int getSDKVersion();

    public final void log(String string2, int n10, int n11, String string3, String string4) {
        DefaultLogsCollector.get().log(string2, n10, n11, string3, string4);
    }
}


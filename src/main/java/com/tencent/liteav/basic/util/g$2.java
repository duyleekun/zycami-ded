/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Debug
 *  android.os.Debug$MemoryInfo
 */
package com.tencent.liteav.basic.util;

import android.os.Debug;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;

public final class g$2
implements Runnable {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void run() {
        System.currentTimeMillis();
        int n10 = 0;
        Debug.MemoryInfo memoryInfo = null;
        g.a(false);
        try {
            memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo((Debug.MemoryInfo)memoryInfo);
            n10 = memoryInfo.getTotalPss();
        }
        catch (Exception exception) {
            return;
        }
        long l10 = TXCTimeUtil.getTimeTick();
        g.a(l10);
        n10 /= 1024;
        g.b(n10);
    }
}


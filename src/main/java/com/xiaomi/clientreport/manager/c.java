/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class c
implements Runnable {
    public final /* synthetic */ PerfClientReport a;
    public final /* synthetic */ a a;

    public c(a a10, PerfClientReport perfClientReport) {
        this.a = a10;
        this.a = perfClientReport;
    }

    public void run() {
        a a10 = this.a;
        PerfClientReport perfClientReport = this.a;
        com.xiaomi.clientreport.manager.a.a(a10, perfClientReport);
    }
}


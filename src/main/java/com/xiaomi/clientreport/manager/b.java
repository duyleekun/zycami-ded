/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.manager.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b
implements Runnable {
    public final /* synthetic */ EventClientReport a;
    public final /* synthetic */ a a;

    public b(a a10, EventClientReport eventClientReport) {
        this.a = a10;
        this.a = eventClientReport;
    }

    public void run() {
        a a10 = this.a;
        EventClientReport eventClientReport = this.a;
        com.xiaomi.clientreport.manager.a.a(a10, eventClientReport);
    }
}


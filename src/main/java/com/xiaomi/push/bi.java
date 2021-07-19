/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.clientreport.processor.c;
import com.xiaomi.push.bm;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bi
implements Runnable {
    private Context a;
    private c a;

    public void a(Context context) {
        this.a = context;
    }

    public void a(c c10) {
        this.a = c10;
    }

    /*
     * Unable to fully structure code
     */
    public void run() {
        block14: {
            block13: {
                var1_1 = this.a;
                if (var1_1 == null) break block13;
                var1_1.a();
            }
            var1_1 = "begin read and send perf / event";
            b.c((String)var1_1);
            var1_1 = this.a;
            var2_3 = var1_1 instanceof IEventProcessor;
            var3_4 = "sp_client_report_status";
            if (var2_3) {
                var1_1 = this.a;
                var1_1 = bm.a((Context)var1_1);
                var4_5 = "event_last_upload_time";
                var5_6 = System.currentTimeMillis();
lbl21:
                // 2 sources

                while (true) {
                    var1_1.a(var3_4, var4_5, var5_6);
                    break;
                }
            }
            var7_7 = var1_1 instanceof IPerfProcessor;
            if (!var7_7) break block14;
            var1_1 = this.a;
            var1_1 = bm.a((Context)var1_1);
            var4_5 = "perf_last_upload_time";
            try {
                var5_6 = System.currentTimeMillis();
                ** continue;
            }
            catch (Exception var1_2) {
                b.a(var1_2);
            }
        }
    }
}


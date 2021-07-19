/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Process
 */
package com.xiaomi.clientreport.manager;

import android.content.Context;
import android.os.Process;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.clientreport.processor.b;
import com.xiaomi.push.g;

public class ClientReportClient {
    public static void init(Context context) {
        Config config = Config.defaultConfig(context);
        com.xiaomi.clientreport.processor.a a10 = new com.xiaomi.clientreport.processor.a(context);
        b b10 = new b(context);
        ClientReportClient.init(context, config, a10, b10);
    }

    public static void init(Context context, Config config) {
        com.xiaomi.clientreport.processor.a a10 = new com.xiaomi.clientreport.processor.a(context);
        b b10 = new b(context);
        ClientReportClient.init(context, config, a10, b10);
    }

    public static void init(Context object, Config object2, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("init in process ");
        Object object4 = g.a((Context)object);
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append(" pid :");
        int n10 = Process.myPid();
        ((StringBuilder)object3).append(n10);
        ((StringBuilder)object3).append(" threadId: ");
        object4 = Thread.currentThread();
        long l10 = ((Thread)object4).getId();
        ((StringBuilder)object3).append(l10);
        com.xiaomi.channel.commonutils.logger.b.c(((StringBuilder)object3).toString());
        object3 = a.a((Context)object);
        ((a)object3).a((Config)object2, iEventProcessor, iPerfProcessor);
        boolean bl2 = g.a((Context)object);
        if (bl2) {
            object2 = "init in process\u3000start scheduleJob";
            com.xiaomi.channel.commonutils.logger.b.c((String)object2);
            object = a.a((Context)object);
            ((a)object).a();
        }
    }

    public static void reportEvent(Context object, EventClientReport eventClientReport) {
        if (eventClientReport != null) {
            object = a.a((Context)object);
            ((a)object).a(eventClientReport);
        }
    }

    public static void reportPerf(Context object, PerfClientReport perfClientReport) {
        if (perfClientReport != null) {
            object = a.a((Context)object);
            ((a)object).a(perfClientReport);
        }
    }

    public static void updateConfig(Context context, Config config) {
        if (config == null) {
            return;
        }
        a a10 = a.a(context);
        boolean bl2 = config.isEventUploadSwitchOpen();
        boolean bl3 = config.isPerfUploadSwitchOpen();
        long l10 = config.getEventUploadFrequency();
        long l11 = config.getPerfUploadFrequency();
        a10.a(bl2, bl3, l10, l11);
    }
}

